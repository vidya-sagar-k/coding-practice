package com.vsk.warehousemanagement.observerePattern.observer;

import com.vsk.warehousemanagement.observerePattern.observable.StocksObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver {
  private String emailId;
  private StocksObservable stocksObservable;

  public EmailAlertObserverImpl(StocksObservable stocksObservable, String emailId) {
    this.stocksObservable = stocksObservable;
    this.emailId = emailId;
  }

  @Override
  public void update(){
    sendEmail(emailId, "the product is now available");

  }

  private void sendEmail(String emailId, String message) {
    System.out.println("Sending email to " + emailId + " with msg : " + message);
    // send actual email
  }

}
