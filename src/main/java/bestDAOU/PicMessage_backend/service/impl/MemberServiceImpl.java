package bestDAOU.PicMessage_backend.service.impl;

import bestDAOU.PicMessage_backend.dto.CreateMemberDto;
import bestDAOU.PicMessage_backend.dto.MemberDto;
import bestDAOU.PicMessage_backend.entity.Member;
import bestDAOU.PicMessage_backend.exception.ResourceNotFoundException;
import bestDAOU.PicMessage_backend.mapper.MemberMapper;
import bestDAOU.PicMessage_backend.repository.MemberRepository;
import bestDAOU.PicMessage_backend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public MemberDto createMember(CreateMemberDto createMemberDto) {
        // CreateMemberDto에서 Member 엔티티로 변환
        Member member = new Member();
        member.setName(createMemberDto.getName());
        member.setPassword(createMemberDto.getPassword());
        member.setEmail(createMemberDto.getEmail());

        // 회원 저장
        Member savedMember = memberRepository.save(member);

        // 저장된 Member 엔티티를 MemberDto로 변환하여 반환
        return MemberMapper.mapToMemberDto(savedMember);
    }

    @Override
    public MemberDto getMemberById(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with id: " + memberId));
        return MemberMapper.mapToMemberDto(member);
    }

    @Override
    public MemberDto updateMember(Long memberId, MemberDto memberDto) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with id: " + memberId));
        member.setName(memberDto.getName());
        member.setEmail(memberDto.getEmail());
        member.setPassword(memberDto.getPassword());
        Member updatedMember = memberRepository.save(member);
        return MemberMapper.mapToMemberDto(updatedMember);
    }

    @Override
    public void deleteMember(Long memberId) {
        memberRepository.deleteById(memberId);
    }

    @Override
    public List<MemberDto> getAllMembers() {
        return memberRepository.findAll().stream()
                .map(MemberMapper::mapToMemberDto)
                .collect(Collectors.toList());
    }
}