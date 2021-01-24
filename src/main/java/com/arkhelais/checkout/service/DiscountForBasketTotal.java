package com.arkhelais.checkout.service;

import com.arkhelais.checkout.dto.PromotionType;
import java.util.Optional;

public class DiscountForBasketTotal implements PromotionalRule {

  private final Double promotionalTotal;

  private final Integer percentage;

  public DiscountForBasketTotal(Double promotionalTotal, Integer percentage) {
    this.promotionalTotal = promotionalTotal;
    this.percentage = percentage;
  }

  @Override
  public String getProductCode() {
    return null;
  }

  @Override
  public PromotionType getPromotionType() {
    return PromotionType.BASKET_PROMOTION;
  }

  @Override
  public Optional<Double> apply(Object object) {
    Double basketTotal = (Double)object;

    if (basketTotal >= promotionalTotal) {
      return Optional.of(basketTotal * (100 - percentage) / 100);
    }
    return Optional.empty();
  }

}