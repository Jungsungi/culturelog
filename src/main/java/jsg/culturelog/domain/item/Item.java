package jsg.culturelog.domain.item;


import jakarta.persistence.*;
import jsg.culturelog.domain.CommonDomain;
import jsg.culturelog.domain.Review;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@DiscriminatorColumn(name = "dtype")
@Table
public abstract class Item extends CommonDomain {
    @Id @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private String imgLink;

    @OneToMany(mappedBy = "item")
    private List<Review> reviews = new ArrayList<>();
}
