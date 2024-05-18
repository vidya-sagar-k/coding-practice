package com.vsk.warehousemanagement.strategy_pattern.vehicle;

import com.vsk.warehousemanagement.strategy_pattern.driveStrategy.DriveStrategy;
import com.vsk.warehousemanagement.strategy_pattern.driveStrategy.SportsDriveStrategy;

public class SportsCar extends Vehicle {
  public SportsCar() {
    super(new SportsDriveStrategy());

  }
}
