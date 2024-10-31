package bestDAOU.PicMessage_backend.service;

import bestDAOU.PicMessage_backend.dto.FriendsDto;

import java.util.List;

public interface FriendsService {
    FriendsDto addFriend(FriendsDto friendsDto, Long memberId);
    FriendsDto getFriendById(Long friendId);
    List<FriendsDto> getFriendsByMemberId(Long memberId);
    FriendsDto updateFriend(Long friendId, FriendsDto friendsDto);
    void deleteFriend(Long friendId);
}
