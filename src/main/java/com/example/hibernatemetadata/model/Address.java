package com.example.hibernatemetadata.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

@Getter
@Setter
@Entity
@Comment("Адрес")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Comment("Айди")
    Long id;
    @Comment("Страна")
    String state;
    @Comment("Город")
    String city;
    @Comment("Улица")
    String street;
    @Comment("Индекс")
    String zipCode;
    @Comment("Человек")
    @OneToOne(mappedBy = "address")
    Man man;
}