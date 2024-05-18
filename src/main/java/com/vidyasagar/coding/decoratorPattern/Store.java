package com.vidyasagar.coding.decoratorPattern;

import com.vidyasagar.coding.decoratorPattern.bases.VegDelight;
import com.vidyasagar.coding.decoratorPattern.bases.VegDelight;
import com.vidyasagar.coding.decoratorPattern.toppings.ExtraCheese;
import com.vsk.warehousemanagement.decoratorPattern.toppings.Mushroom;

public class Store {
  public static void main(String args[]) {
    BasePizza vegDelightExtraCheese = new ExtraCheese(new VegDelight());
    System.out.println("vegDelightExtraCheese cost : " +  vegDelightExtraCheese.cost());

    BasePizza vegDelightExtraCheeseMushroom = new Mushroom(vegDelightExtraCheese);
    System.out.println("vegDelightExtraCheeseMushroom cost : " +  vegDelightExtraCheeseMushroom.cost());


    BasePizza vegDelightExtraCheeseMushroomTwice = new Mushroom(vegDelightExtraCheeseMushroom);
    System.out.println("vegDelightExtraCheeseMushroomTwice cost : " +  vegDelightExtraCheeseMushroomTwice.cost());


  }

}
