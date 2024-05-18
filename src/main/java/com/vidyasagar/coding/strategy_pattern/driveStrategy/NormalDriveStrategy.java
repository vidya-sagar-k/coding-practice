package com.vsk.warehousemanagement.strategy_pattern.driveStrategy;

public class NormalDriveStrategy implements DriveStrategy {

  @Override
  public void drive() {
    System.out.println("Normal DriveStrategy");
  }
}
