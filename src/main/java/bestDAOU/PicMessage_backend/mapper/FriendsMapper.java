package bestDAOU.PicMessage_backend.mapper;

import bestDAOU.PicMessage_backend.dto.FriendsDto;
import bestDAOU.PicMessage_backend.entity.Friends;
import bestDAOU.PicMessage_backend.entity.Member;

public class FriendsMapper {

    // Friends 엔티티 -> FriendsDto로 매핑
    public static FriendsDto mapToFriendsDto(Friends friends) {
        return new FriendsDto(
                friends.getId(),
                friends.getFriendName(),
                friends.getFriendPhone(),
                friends.getTags(),
                friends.getMemos(),
                friends.getTones(),
                friends.getMember().getId(), // Member의 ID를 직접 설정
                friends.getRelationType()
        );
    }

    // FriendsDto -> Friends 엔티티로 매핑
    public static Friends mapToFriends(FriendsDto friendsDto, Member member) {
        return new Friends(
                friendsDto.getId(),
                friendsDto.getFriendName(),
                friendsDto.getFriendPhone(),
                friendsDto.getTags(),
                friendsDto.getMemos(),
                friendsDto.getTones(),
                member, // Member 엔티티를 직접 설정
                friendsDto.getRelationType()
        );
    }
}
