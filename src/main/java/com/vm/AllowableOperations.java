package com.vm;

import com.vm.enums.ProductType;
import com.vm.money.Money;
import com.vm.product.Product;

import java.util.Map;

/**
 * Created by shailendra.singh on 1/6/17.
 */
public interface AllowableOperations {

    void reset();

    Map<Product, Money> processInputs(Money money, ProductType desired);

    Product returnSelectedProduct(ProductType productType);

    Money returnChange(Money accepted, double productValue);

    Money cancelTransaction();


}
