package com.vsk.warehousemanagement.observerePattern.observer;

import com.vsk.warehousemanagement.observerePattern.observable.StocksObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver {
  private int mobileNumber;
  private StocksObservable stocksObservable;


  public MobileAlertObserverImpl(StocksObservable stocksObservable, int mobileNumber) {
    this.mobileNumber = mobileNumber;
    this.stocksObservable = stocksObservable;
  }
  @Override
  public void update() {
    sendSms(mobileNumber, "stock is available...pls order now");

  }

  private void sendSms(int mobileNumber, String message) {
    System.out.println("Sending sms to " + mobileNumber + "with msg : " + message);
  }

}
