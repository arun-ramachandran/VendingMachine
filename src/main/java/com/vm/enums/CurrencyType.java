package com.vm.enums;

/**
 * Created by shailendra.singh on 1/6/17.
 */
public enum CurrencyType {

    DOLLAR_2    (200)   ,
    DOLLAR_1    (100)   ,
    HALF        (50)    ,
    QUATER      (25)    ,
    DIME        (10)    ,
    NICKEL      (5)     ,
    PENNY       (1)     ;

    private double value;

    CurrencyType(double value) {
        this.value = value;
    }

    public double getValue(){
        return value;
    }

}
