package com.vm.enums;

import com.vm.money.Money;
import com.vm.product.*;

import java.util.HashMap;

/**
 * Created by shailendra.singh on 1/9/17.
 */
public enum ProductType {


    CANDY   ("CANDY" ,    10)    ,
    SNACK   ("SNACK" ,    50)    ,
    NUTS    ("NUTS"  ,    90)    ,
    COKE    ("COKE"  ,    25)    ,
    PEPSI   ("PEPSI" ,    35)    ,
    SODA    ("SODA"  ,    45)    ;

    private Product product;

    ProductType(String productCode, double price){
        switch (productCode){
            case "CANDY":
                product = new Candy(price);
                break;
            case "SNACKS":
                product = new Snacks(price);
                break;
            case "NUTS":
                product = new Nuts(price);
                break;
            case "COKE":
                product = new Coke(price);
                break;
            case "PEPSI":
                product = new Pepsi(price);
                break;
            case "SODA":
                product = new Soda(price);
                break;
        }
    }

    public Product getProduct(){
        return product;
    }

}
