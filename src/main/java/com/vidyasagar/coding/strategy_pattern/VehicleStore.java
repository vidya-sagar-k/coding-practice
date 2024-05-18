package com.vsk.warehousemanagement.strategy_pattern;

import com.vsk.warehousemanagement.strategy_pattern.vehicle.PassengerCar;
import com.vsk.warehousemanagement.strategy_pattern.vehicle.SportsCar;
import com.vsk.warehousemanagement.strategy_pattern.vehicle.SuvCar;
import com.vsk.warehousemanagement.strategy_pattern.vehicle.Vehicle;

public class VehicleStore {
  public static void main(String args[]) {
    Vehicle passengerCar = new PassengerCar();
    Vehicle sportsCar = new SportsCar();
    Vehicle suv = new SuvCar();

    sportsCar.drive();
    passengerCar.drive();
    suv.drive();

  }

}
