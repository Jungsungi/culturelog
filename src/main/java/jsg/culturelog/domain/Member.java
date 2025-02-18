package jsg.culturelog.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
@Getter @Setter
public class Member extends CommonDomain{

    @Id @GeneratedValue
    private Long id;

    private String userId;
    private String name;
    private String nickname;
    private String bio;
    private String pwd;
    private String email;
    private String sex;
    private String phone;

    @OneToMany(mappedBy = "member")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Like> likes = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Comment> comments = new ArrayList<>();

    @ColumnDefault("'Y'")
    private String useAt;
}
