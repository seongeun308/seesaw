package team.seesaw.common.entity;


import lombok.*;
import team.seesaw.web.dto.MemberDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "member")
@Getter @ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String pw;
    private String nick;

    @Builder
    public Member(Long id, String email, String pw, String nick) {
        this.id = id;
        this.email = email;
        this.pw = pw;
        this.nick = nick;
    }

    public MemberDto toDto(){
        return MemberDto.builder()
                .id(this.id)
                .email(this.email)
                .pw(this.pw)
                .nick(this.nick)
                .build();
    }
}
