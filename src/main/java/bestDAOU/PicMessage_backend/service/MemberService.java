package bestDAOU.PicMessage_backend.service;

import bestDAOU.PicMessage_backend.dto.CreateMemberDto;
import bestDAOU.PicMessage_backend.dto.MemberDto;

import java.util.List;

public interface MemberService {
    MemberDto createMember(CreateMemberDto createMemberDto);
    MemberDto getMemberById(Long memberId);
    MemberDto updateMember(Long memberId, MemberDto memberDto);
    void deleteMember(Long memberId);
    List<MemberDto> getAllMembers();
}
