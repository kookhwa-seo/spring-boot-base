package com.springboot.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "credit_card")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    User owner;

    @Column(name = "name")
    String cardName;

    @Builder
    public CreditCard(long id, User owner, String cardName) {
        this.id = id;
        this.owner = owner;
        this.cardName = cardName;
    }
}
