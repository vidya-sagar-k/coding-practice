package com.vsk.warehousemanagement.decoratorPattern.toppings;

import com.vidyasagar.coding.decoratorPattern.BasePizza;
import com.vidyasagar.coding.decoratorPattern.ToppingDecorator;

public class Mushroom extends ToppingDecorator {
  private BasePizza basePizza;

  public Mushroom(BasePizza basePizza) {
    this.basePizza = basePizza;
  }

  @Override
  public int cost() {
    return basePizza.cost() + 10;
  }
}
