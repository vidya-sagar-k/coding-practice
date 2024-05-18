package com.vsk.warehousemanagement.observerePattern;

import com.vsk.warehousemanagement.observerePattern.observable.IphoneObservableImpl;
import com.vsk.warehousemanagement.observerePattern.observable.StocksObservable;
import com.vsk.warehousemanagement.observerePattern.observer.EmailAlertObserverImpl;
import com.vsk.warehousemanagement.observerePattern.observer.MobileAlertObserverImpl;
import com.vsk.warehousemanagement.observerePattern.observer.NotificationAlertObserver;

public class Store {
  public static void main(String args[]) {
    StocksObservable iphoneObservable = new IphoneObservableImpl();

    NotificationAlertObserver emailObserver1 = new EmailAlertObserverImpl(iphoneObservable, "vsk@gmail.com");
    NotificationAlertObserver emailObserver2 = new EmailAlertObserverImpl(iphoneObservable, "sagar@gmail.com");
    NotificationAlertObserver mobileObserver = new MobileAlertObserverImpl(iphoneObservable, 1234567890);

    iphoneObservable.add(emailObserver1);
    iphoneObservable.add(emailObserver2);
    iphoneObservable.add(mobileObserver);

    System.out.println("stock is : " + iphoneObservable.getStockCount());

    iphoneObservable.setStockCount(10);
    System.out.println("stock is : " + iphoneObservable.getStockCount());

    iphoneObservable.setStockCount(2);




  }

}
