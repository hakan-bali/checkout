package com.arkhelais.checkout;

import com.arkhelais.checkout.repository.ProductRepository;
import com.arkhelais.checkout.service.Basket;
import com.arkhelais.checkout.service.Checkout;
import com.arkhelais.checkout.service.DiscountForBasketTotal;
import com.arkhelais.checkout.service.DiscountForQuantity;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    Checkout checkout = new Checkout(Arrays.asList(
        new DiscountForBasketTotal(75.0, 10),
        new DiscountForQuantity("0001", 2, 22.99)));
    Basket basket = new Basket();

    for (String productCode : args) {
      ProductRepository.getProduct(productCode)
          .ifPresentOrElse(
              p -> basket.scan(p, 1),
              () -> System.out.println("Product Code Not Found : " + productCode));
    }
    checkout.scan(basket);
    System.out.printf("£%.2f", checkout.getBasketDiscountedTotal());
  }

}