package com.vm.money;

import com.vm.enums.CurrencyType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.DoubleStream;

/**
 * Created by shailendra.singh on 1/6/17.
 */
public class Money {

    private Map<CurrencyType,Integer> money;

    public double sum = getTotalSum();

    public Money(Map<CurrencyType,Integer> money){
        this.money = money;
    }

    private double getTotalSum(){
        final double[] sum = {0d};
        money.forEach((ct, c) -> sum[0] += ct.getValue() * c);
        return sum[0];
    }


}
