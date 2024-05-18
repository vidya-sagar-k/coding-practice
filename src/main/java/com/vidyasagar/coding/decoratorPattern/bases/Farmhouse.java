package com.vidyasagar.coding.decoratorPattern.bases;

import com.vidyasagar.coding.decoratorPattern.BasePizza;

public class Farmhouse extends BasePizza {

  @Override
  public int cost() {
    return 100;
  }
}
