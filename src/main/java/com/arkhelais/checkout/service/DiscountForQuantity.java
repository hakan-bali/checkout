package com.arkhelais.checkout.service;

import com.arkhelais.checkout.dto.Product;
import com.arkhelais.checkout.dto.PromotionType;
import com.arkhelais.checkout.repository.ProductRepository;
import java.util.Optional;

public class DiscountForQuantity implements PromotionalRule {

  private final String productCode;

  private final Integer minimumQuantity;

  private final Double discountedPrice;

  public DiscountForQuantity(String productCode, Integer minimumQuantity, Double discountedPrice) {
    Optional<Product> productOptional = ProductRepository.getProduct(productCode);

    if (productOptional.isEmpty()) {
      throw new IllegalArgumentException("Promotional product is unavailable");
    } else {
      this.productCode = productCode;
    }

    if (minimumQuantity < 1) {
      throw new IllegalArgumentException("Promotional minimum quantity should be greater than 0");
    } else {
      this.minimumQuantity = minimumQuantity;
    }

    if (discountedPrice >= productOptional.get().getPrice()) {
      throw new IllegalArgumentException("Promotional price should be lower than product's original price");
    }
    this.discountedPrice = discountedPrice;
  }

  @Override
  public String getProductCode() {
    return productCode;
  }

  @Override
  public PromotionType getPromotionType() {
    return PromotionType.ITEM_PROMOTION;
  }

  @Override
  public Optional<Double> apply(Object object) {
    Integer quantity;

    try {
      quantity = (Integer)object;
    } catch (ClassCastException exception) {
      throw new IllegalArgumentException("Quantity should be an Integer");
    }

    if (quantity >= minimumQuantity) {
      return Optional.of(quantity * discountedPrice);
    }
    return Optional.empty();
  }

}