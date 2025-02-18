package jsg.culturelog.domain.item;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@DiscriminatorValue("M")
public class Movie extends Item{
    private String director;
    private String movieKey;
    private String openDate;
}
