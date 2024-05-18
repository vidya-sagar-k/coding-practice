package com.vsk.warehousemanagement.strategy_pattern.driveStrategy;

public class SportsDriveStrategy implements DriveStrategy {


  @Override
  public void drive() {
    System.out.println("Sports DriveStrategy");
  }
}
