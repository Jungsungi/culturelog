package jsg.culturelog.domain.dto;

import jsg.culturelog.domain.CommonDomain;
import jsg.culturelog.domain.Member;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.format.DateTimeFormatterBuilder;

@Getter
@Setter
public class MemberDto {
    public MemberDto(Member member) {
        this.id = member.getId();
        this.userId = member.getUserId();
        this.name = member.getName();
        this.pwd = member.getPwd();
        this.email = member.getEmail();
        this.sex = member.getSex();
        this.phone = member.getPhone();
        this.createDate = member.getCreateDate().format(new DateTimeFormatterBuilder().toFormatter());
        this.updateDate = member.getUpdateDate().format(new DateTimeFormatterBuilder().toFormatter());
        this.useAt = member.getUseAt();
    }

    private Long id;

    private String userId;
    private String name;
    private String pwd;
    private String email;
    private String sex;
    private String phone;
    private String createDate;
    private String updateDate;
    private String useAt;
}
