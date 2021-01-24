package com.arkhelais.checkout.repository;

import com.arkhelais.checkout.dto.Product;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ProductRepository {

  private static final Product waterBottle = new Product("0001", "Water Bottle", 24.95);
  private static final Product hoodie = new Product("0002", "Hoodie", 65.0);
  private static final Product stickerSet = new Product("0003", "Sticker Set", 3.99);

  private static final Map<String, Product> products = new HashMap<String, Product>() {{
    put(waterBottle.getCode(), waterBottle);
    put(hoodie.getCode(), hoodie);
    put(stickerSet.getCode(), stickerSet);
  }};

  public static Optional<Product> getProduct(String code) {
    if (products.containsKey(code)) {
      return Optional.of(products.get(code));
    } else {
      return Optional.empty();
    }
  }

}