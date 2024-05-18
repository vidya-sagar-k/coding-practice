package com.vsk.warehousemanagement.observerePattern.observable;

import com.vsk.warehousemanagement.observerePattern.observer.NotificationAlertObserver;
import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StocksObservable {
  private List<NotificationAlertObserver> observers = new ArrayList<>();
  private int stockCount = 0;


  @Override
  public void add(NotificationAlertObserver observer) {
    observers.add(observer);

  }

  @Override
  public void remove(NotificationAlertObserver observer) {
    observers.remove(observer);

  }

  @Override
  public void notifySubscribers() {
    for (NotificationAlertObserver observer : observers) {
      observer.update();
    }

  }

  @Override
  public void setStockCount(int newStockAdded) {
    if (stockCount == 0) {
      notifySubscribers();
    }

    stockCount += newStockAdded;

  }

  @Override
  public int getStockCount() {
    return stockCount;
  }
}
