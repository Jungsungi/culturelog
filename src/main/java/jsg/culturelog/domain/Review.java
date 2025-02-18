package jsg.culturelog.domain;

import jakarta.persistence.*;
import jsg.culturelog.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@DiscriminatorColumn
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class Review extends CommonDomain {

    @Id @GeneratedValue
    private Long id;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private Double rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @OneToMany(mappedBy = "review")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "review")
    private List<Like> likes = new ArrayList<>();

    private String content;

    private String useAt;
}
