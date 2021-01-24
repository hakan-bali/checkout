package com.arkhelais.checkout.dto;

public class Product {

  private String code;

  private String name;

  private Double price;

  public Product(String code, String name, Double price) {
    this.code = code;
    this.name = name;
    this.price = price;
  }

  public Product() {
  }

  public static ProductBuilder builder() {
    return new ProductBuilder();
  }

  public String getCode() {
    return this.code;
  }

  public String getName() {
    return this.name;
  }

  public Double getPrice() {
    return this.price;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public boolean equals(final Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Product)) {
      return false;
    }
    final Product other = (Product) o;
    if (!other.canEqual((Object) this)) {
      return false;
    }
    final Object this$code = this.getCode();
    final Object other$code = other.getCode();
    if (this$code == null ? other$code != null : !this$code.equals(other$code)) {
      return false;
    }
    final Object this$name = this.getName();
    final Object other$name = other.getName();
    if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
      return false;
    }
    final Object this$price = this.getPrice();
    final Object other$price = other.getPrice();
    if (this$price == null ? other$price != null : !this$price.equals(other$price)) {
      return false;
    }
    return true;
  }

  protected boolean canEqual(final Object other) {
    return other instanceof Product;
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $code = this.getCode();
    result = result * PRIME + ($code == null ? 43 : $code.hashCode());
    final Object $name = this.getName();
    result = result * PRIME + ($name == null ? 43 : $name.hashCode());
    final Object $price = this.getPrice();
    result = result * PRIME + ($price == null ? 43 : $price.hashCode());
    return result;
  }

  public String toString() {
    return "Product(code=" + this.getCode() + ", name=" + this.getName() + ", price=" + this
        .getPrice() + ")";
  }

  public static class ProductBuilder {

    private String code;
    private String name;
    private Double price;

    ProductBuilder() {
    }

    public ProductBuilder code(String code) {
      this.code = code;
      return this;
    }

    public ProductBuilder name(String name) {
      this.name = name;
      return this;
    }

    public ProductBuilder price(Double price) {
      this.price = price;
      return this;
    }

    public Product build() {
      return new Product(code, name, price);
    }

    public String toString() {
      return "Product.ProductBuilder(code=" + this.code + ", name=" + this.name + ", price="
          + this.price + ")";
    }
  }
}