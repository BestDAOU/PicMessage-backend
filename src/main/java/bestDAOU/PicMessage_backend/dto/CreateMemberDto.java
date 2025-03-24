package bestDAOU.PicMessage_backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "회원 등록 DTO")
public class CreateMemberDto {

    @Schema(description = "회원 이름", example = "홍길동", required = true)
    private String name;

    @Schema(description = "회원 비밀번호", example = "password123", required = true)
    private String password;

    @Schema(description = "회원 이메일", example = "hong@example.com", required = true)
    private String email;
}