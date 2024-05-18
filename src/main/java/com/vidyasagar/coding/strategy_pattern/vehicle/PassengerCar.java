package com.vsk.warehousemanagement.strategy_pattern.vehicle;

import com.vsk.warehousemanagement.strategy_pattern.driveStrategy.NormalDriveStrategy;

public class PassengerCar extends Vehicle {

  public PassengerCar() {
    super(new NormalDriveStrategy());

  }
}
