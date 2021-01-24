package com.arkhelais.checkout.dto;

public class BasketItem {

  private Integer quantity;

  private Double total;

  private Double discountedTotal;

  public BasketItem(Integer quantity, Double total, Double discountedTotal) {
    this.quantity = quantity;
    this.total = total;
    this.discountedTotal = discountedTotal;
  }

  public BasketItem() {
  }

  public static BasketItemBuilder builder() {
    return new BasketItemBuilder();
  }

  public Integer getQuantity() {
    return this.quantity;
  }

  public Double getTotal() {
    return this.total;
  }

  public Double getDiscountedTotal() {
    return this.discountedTotal;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public void setTotal(Double total) {
    this.total = total;
  }

  public void setDiscountedTotal(Double discountedTotal) {
    this.discountedTotal = discountedTotal;
  }

  public boolean equals(final Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof BasketItem)) {
      return false;
    }
    final BasketItem other = (BasketItem) o;
    if (!other.canEqual((Object) this)) {
      return false;
    }
    final Object this$quantity = this.getQuantity();
    final Object other$quantity = other.getQuantity();
    if (this$quantity == null ? other$quantity != null : !this$quantity.equals(other$quantity)) {
      return false;
    }
    final Object this$total = this.getTotal();
    final Object other$total = other.getTotal();
    if (this$total == null ? other$total != null : !this$total.equals(other$total)) {
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
    return other instanceof BasketItem;
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $quantity = this.getQuantity();
    result = result * PRIME + ($quantity == null ? 43 : $quantity.hashCode());
    final Object $total = this.getTotal();
    result = result * PRIME + ($total == null ? 43 : $total.hashCode());
    final Object $discountedTotal = this.getDiscountedTotal();
    result = result * PRIME + ($discountedTotal == null ? 43 : $discountedTotal.hashCode());
    return result;
  }

  public String toString() {
    return "BasketItem(quantity=" + this.getQuantity() + ", total=" + this.getTotal()
        + ", discountedTotal=" + this.getDiscountedTotal() + ")";
  }

  public static class BasketItemBuilder {

    private Integer quantity;
    private Double total;
    private Double discountedTotal;

    BasketItemBuilder() {
    }

    public BasketItemBuilder quantity(Integer quantity) {
      this.quantity = quantity;
      return this;
    }

    public BasketItemBuilder total(Double total) {
      this.total = total;
      return this;
    }

    public BasketItemBuilder discountedTotal(Double discountedTotal) {
      this.discountedTotal = discountedTotal;
      return this;
    }

    public BasketItem build() {
      return new BasketItem(quantity, total, discountedTotal);
    }

    public String toString() {
      return "BasketItem.BasketItemBuilder(quantity=" + this.quantity + ", total=" + this.total
          + ", discountedTotal=" + this.discountedTotal + ")";
    }
  }
}