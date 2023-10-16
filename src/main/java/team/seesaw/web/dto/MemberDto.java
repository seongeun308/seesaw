package team.seesaw.web.dto;

import lombok.*;
import team.seesaw.common.entity.Member;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter @ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberDto {

    private Long id;

    @NotBlank @NotNull
    @Min(1)
    private String email;

    @NotBlank @NotNull
    @Min(8)
    private String pw;

    @NotBlank @NotNull
    @Min(1)
    private String nick;

    @Builder
    public MemberDto(Long id, String email, String pw, String nick) {
        this.id = id;
        this.email = email;
        this.pw = pw;
        this.nick = nick;
    }

    public Member toEntity(){
        return Member.builder()
                .id(this.id)
                .email(this.email)
                .pw(this.pw)
                .nick(this.nick)
                .build();
    }
}
