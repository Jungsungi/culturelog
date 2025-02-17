package jsg.culturelog.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
@Getter @Setter
public class Member extends CommonDomain{

    @Id @GeneratedValue
    private Long id;

    private String userId;
    private String name;
    private String pwd;
    private String email;
    private String sex;
    private String phone;

    @ColumnDefault("'Y'")
    private String useAt;
}
