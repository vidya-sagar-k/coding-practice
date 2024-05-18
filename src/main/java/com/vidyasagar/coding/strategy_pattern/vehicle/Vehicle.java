package com.vsk.warehousemanagement.strategy_pattern.vehicle;

import com.vsk.warehousemanagement.strategy_pattern.driveStrategy.DriveStrategy;

public class Vehicle {
  DriveStrategy driveStrategy;

  public Vehicle(DriveStrategy driveStrategy) {
    this.driveStrategy = driveStrategy;
  }
  public void drive() {
    driveStrategy.drive();
  }

}
