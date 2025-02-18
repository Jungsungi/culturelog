package jsg.culturelog.domain.item;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("B")
@Getter
@Setter
public class Book extends Item{
    private String author;
    private String bookLink;
    private String isbn;
    private String pubDate;
    private String publisher;
}
