package jsg.culturelog.domain.form.member;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberEditForm {

    @NotNull
    private Long id;
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
