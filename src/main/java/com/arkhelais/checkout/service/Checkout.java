package com.arkhelais.checkout.service;

import com.arkhelais.checkout.dto.PromotionType;
import java.util.List;

public class Checkout {

  private Basket basket;

  private final List<PromotionalRule> promotionalRules;

  public Checkout(List<PromotionalRule> promotionalRules) {
    this.promotionalRules = promotionalRules;
  }

  public void scan(Basket basket) {
    promotionalRules.forEach((promotionalRule) -> {
      if (promotionalRule.getPromotionType().equals(PromotionType.ITEM_PROMOTION)) {
        basket.applyItemPromotion(promotionalRule);
      }
    });

    promotionalRules.forEach((promotionalRule) -> {
      if (promotionalRule.getPromotionType().equals(PromotionType.BASKET_PROMOTION)) {
        basket.applyBasketPromotion(promotionalRule);
      }
    });

    this.basket = basket;
  }

  public Double getBasketTotal() {
    return basket.getBasketTotal();
  }

  public Double getBasketDiscountedTotal() {
    return basket.getDiscountedTotal();
  }

}