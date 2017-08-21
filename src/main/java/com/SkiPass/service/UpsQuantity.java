package com.SkiPass.service;

public enum UpsQuantity {
    TEN{
        public int getValue(){
            return 10;
        }
    },
    TWENTY{
        public int getValue(){
            return 20;
        }
    },
    FIFTY{
        public int getValue(){
            return 30;
        }
    },
    ONE_HUNDRED{
        public int getValue(){
            return 40;
        }
    }
}
