package com.vidyasagar.coding.decoratorPattern.toppings;

import com.vidyasagar.coding.decoratorPattern.BasePizza;
import com.vidyasagar.coding.decoratorPattern.ToppingDecorator;

public class ExtraCheese extends ToppingDecorator {
  private BasePizza basePizza;


  public ExtraCheese(BasePizza basePizza) {
    this.basePizza = basePizza;
  }
  @Override
  public int cost() {
    return basePizza.cost() + 50;
  }
}
