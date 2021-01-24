package com.arkhelais.checkout.service;


import com.arkhelais.checkout.dto.PromotionType;
import java.util.Optional;

public interface PromotionalRule {

  String getProductCode();

  PromotionType getPromotionType();

  Optional<Double> apply(Object object);

}