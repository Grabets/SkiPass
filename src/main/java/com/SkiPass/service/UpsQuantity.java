package com.SkiPass.service;

import lombok.Getter;

@Getter
public enum UpsQuantity {
    TEN(10), TWENTY(20), FIFTY(50), ONE_HUNDRED(100);

    private int quantity;

    UpsQuantity (int quantity){
        this.quantity = quantity;
    }
}
