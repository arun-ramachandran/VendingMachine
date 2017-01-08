package com.vm;

import com.vm.enums.CurrencyType;
import com.vm.enums.ProductType;
import com.vm.money.Money;
import com.vm.product.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shailendra.singh on 1/6/17.
 */
public class VendingMachine implements AllowableOperations {

    CurrencyType[] currencyTypes = CurrencyType.values();
    Money accepted;
    Product desired;

    @Override
    public void reset() {
    }

    @Override
    public Map<Product,Money> processInputs(Money accepted, ProductType desired) {
        this.accepted   = accepted;
        this.desired    = desired.getProduct();
        Map<Product,Money> returnItems = new HashMap<>(1);
        returnItems.put(returnSelectedProduct(desired),
                        returnChange(accepted,this.desired.price));
        return returnItems;
    }

    @Override
    public Product returnSelectedProduct(ProductType productType) {
        return productType.getProduct();
    }

    @Override
    public Money returnChange(Money accepted, double productValue) {
        if(accepted.sum == productValue){
            return null;
        }
        return getChangeDenominations(productValue - accepted.sum);
    }

    @Override
    public Money cancelTransaction() {
        double toReturnMoney = this.accepted.sum;
        this.accepted = null;
        this.desired = null;
        return getChangeDenominations(toReturnMoney);
    }

    private Money getChangeDenominations(double v) {
        double diff = v;
        Map<CurrencyType,Integer> currencyChange = new HashMap<>();
        for (CurrencyType currencyType : currencyTypes) {
            int denominationCount = (int)(diff / currencyType.getValue());
            if(denominationCount >= 1){
                currencyChange.put(currencyType,denominationCount);
                diff = diff % currencyType.getValue();
            }
            if(diff == 0)
                break;
        }
        return new Money(currencyChange);
    }


}
