package jsg.culturelog.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@DiscriminatorColumn
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class Review extends CommonDomain {

    @Id @GeneratedValue
    private Long id;

    private String title;
    private Long memberId;
    private Float grade;
    private Long itemId;
    private String content;

    private String useAt;
}
