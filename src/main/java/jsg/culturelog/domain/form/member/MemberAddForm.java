package jsg.culturelog.domain.form.member;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberAddForm {
    @NotEmpty
    private String userId;
    @NotEmpty
    private String name;
    @NotEmpty
    private String pwd;
    private String email;
    private String sex;
    private String phone;
}
