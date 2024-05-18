package com.vsk.warehousemanagement.strategy_pattern.vehicle;

import com.vsk.warehousemanagement.strategy_pattern.driveStrategy.DriveStrategy;
import com.vsk.warehousemanagement.strategy_pattern.driveStrategy.SportsDriveStrategy;

public class SuvCar extends Vehicle {
  public SuvCar() {
    super(new SportsDriveStrategy());
  }

}
