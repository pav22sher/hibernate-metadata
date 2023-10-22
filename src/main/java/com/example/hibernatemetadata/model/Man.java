package com.example.hibernatemetadata.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

@Getter
@Setter
@Entity(name = "man")
@Comment("Человек")
public class Man {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    @SequenceGenerator(name = "id_seq", sequenceName = "man_seq_gen", allocationSize = 1)
    @Comment("Айди")
    Long id;
    @Comment("Имя")
    String firstName;
    @Comment("Фамилия")
    String lastName;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @Comment("Адрес")
    Address address;
}
