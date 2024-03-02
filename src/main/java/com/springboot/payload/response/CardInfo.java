package com.springboot.payload.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CardInfo {
    private String ownerName;
    private String cardName;

    @Builder
    public CardInfo(String ownerName, String cardName) {
        this.ownerName = ownerName;
        this.cardName = cardName;
    }
}
