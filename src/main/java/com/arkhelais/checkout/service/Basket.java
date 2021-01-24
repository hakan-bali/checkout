package com.arkhelais.checkout.service;

import com.arkhelais.checkout.dto.BasketItem;
import com.arkhelais.checkout.dto.Product;
import java.util.HashMap;

public class Basket {

  private HashMap<String, BasketItem> basketItems = new HashMap<String, BasketItem>();

  private Double basketTotal = 0.0;

  private Double discountedTotal = 0.0;

  public Basket() {
  }

  public void scan(Product product, Integer quantity) {
    if (basketItems.containsKey(product.getCode())) {
      BasketItem item = basketItems.get(product.getCode());
      item.setQuantity(item.getQuantity() + quantity);
      item.setTotal(item.getQuantity() * product.getPrice());
      item.setDiscountedTotal(item.getTotal());
    } else {
      basketItems.put(product.getCode(),
          BasketItem.builder()
              .quantity(quantity)
              .total(quantity * product.getPrice())
              .discountedTotal(quantity * product.getPrice())
              .build());
    }
    basketTotal += product.getPrice() * quantity;
    discountedTotal = basketTotal;
  }

  public void empty() {
    basketItems = new HashMap<String, BasketItem>();
    basketTotal = 0.0;
    discountedTotal = 0.0;
  }

  private void calculateDiscountedTotal() {
    discountedTotal = 0.0;
    basketItems.forEach((code, item) -> discountedTotal += item.getDiscountedTotal());
  }

  public void applyItemPromotion(PromotionalRule promotionalRule) {
    basketItems.forEach((code, item) -> {
      if (promotionalRule.getProductCode().equals(code)) {
        item.setDiscountedTotal(promotionalRule.apply(item.getQuantity()).orElse(item.getTotal()));
      }
    });
    calculateDiscountedTotal();
  }

  public void applyBasketPromotion(PromotionalRule promotionalRule) {
    calculateDiscountedTotal();
    discountedTotal = promotionalRule.apply(discountedTotal).orElse(discountedTotal);
  }

  public HashMap<String, BasketItem> getBasketItems() {
    return this.basketItems;
  }

  public Double getBasketTotal() {
    return this.basketTotal;
  }

  public Double getDiscountedTotal() {
    return this.discountedTotal;
  }

  public boolean equals(final Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Basket)) {
      return false;
    }
    final Basket other = (Basket) o;
    if (!other.canEqual((Object) this)) {
      return false;
    }
    final Object this$basketItems = this.getBasketItems();
    final Object other$basketItems = other.getBasketItems();
    if (this$basketItems == null ? other$basketItems != null
        : !this$basketItems.equals(other$basketItems)) {
      return false;
    }
    final Object this$basketTotal = this.getBasketTotal();
    final Object other$basketTotal = other.getBasketTotal();
    if (this$basketTotal == null ? other$basketTotal != null
        : !this$basketTotal.equals(other$basketTotal)) {
      return false;
    }
    final Object this$discountedTotal = this.getDiscountedTotal();
    final Object other$discountedTotal = other.getDiscountedTotal();
    if (this$discountedTotal == null ? other$discountedTotal != null
        : !this$discountedTotal.equals(other$discountedTotal)) {
      return false;
    }
    return true;
  }

  protected boolean canEqual(final Object other) {
    return other instanceof Basket;
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $basketItems = this.getBasketItems();
    result = result * PRIME + ($basketItems == null ? 43 : $basketItems.hashCode());
    final Object $basketTotal = this.getBasketTotal();
    result = result * PRIME + ($basketTotal == null ? 43 : $basketTotal.hashCode());
    final Object $discountedTotal = this.getDiscountedTotal();
    result = result * PRIME + ($discountedTotal == null ? 43 : $discountedTotal.hashCode());
    return result;
  }

  public String toString() {
    return "Basket(basketItems=" + this.getBasketItems() + ", basketTotal=" + this.getBasketTotal()
        + ", discountedTotal=" + this.getDiscountedTotal() + ")";
  }

  private void setBasketItems(HashMap<String, BasketItem> basketItems) {
    this.basketItems = basketItems;
  }

  private void setBasketTotal(Double basketTotal) {
    this.basketTotal = basketTotal;
  }

  private void setDiscountedTotal(Double discountedTotal) {
    this.discountedTotal = discountedTotal;
  }
}