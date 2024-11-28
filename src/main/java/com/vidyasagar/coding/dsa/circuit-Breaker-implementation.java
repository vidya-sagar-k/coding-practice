package com.vsk.warehousemanagement.lld.circuitBreaker;

enum State {
  CLOSED,
  HALF_OPEN,
  OPEN
}

class ExternalService {
  private boolean fail;
  public ExternalService(boolean fail) {
    this.fail = fail;
  }
  public void setFailure(boolean fail) {
    this.fail = fail;
  }

  public String call() throws Exception {
    if (fail) {
      throw new Exception("Service is down, request failed");
    }

    return "Success !!!";
  }
}

class CircuitBreaker {
  private State state;
  private int timeoutThreshold;
  private int failureThreshold;
  private int failureCount;
  private long openTime;

  public CircuitBreaker(int failureThreshold, int timeoutThreshold) {
    this.failureThreshold = failureThreshold;
    this.timeoutThreshold = timeoutThreshold;
    this.state = State.CLOSED;
  }

  public String call(ExternalService service) {
    if (state == State.OPEN) {
      if (System.currentTimeMillis() - openTime < timeoutThreshold) {
        System.out.println("State is open, fast failing");
        return fallback();
      }

      this.state = State.HALF_OPEN;
      System.out.println("New State : HALF_OPEN");

    }

    // state is either close or half open
    try {
      String response = service.call();
      reset();
      return response;

    } catch (Exception ex) {
      recordFailure();
      return ex.getMessage();
    }
  }

  private String fallback() {
    return "";
    // return "service unavailable, pls try later";
  }

  private void reset() {
    if (state != State.CLOSED) {
      System.out.println("New State : CLOSED");
    }
    state = State.CLOSED;
    failureCount = 0;
  }

  private void recordFailure() {
    failureCount++;
    if (failureCount >= failureThreshold || state == State.HALF_OPEN) {
      State prevState = state;
      state = State.OPEN;
      openTime = System.currentTimeMillis();
      System.out.println("Prev state : " + prevState + ", Circuit is now OPEN. Failing fast...");
    }
  }
}



public class CircuitBreakerDemo {
  public static void main(String[] args) throws InterruptedException {
    System.out.println("Starting circuit breaker demo");

    CircuitBreaker circuitBreaker = new CircuitBreaker(3, 5000);
    ExternalService service = new ExternalService(true);

    for (int i = 0; i<=10; i++) {
      System.out.println(circuitBreaker.call(service));

      if (i == 4) {
        service.setFailure(false);
        System.out.println("Service is set to healthy.");
      }

      Thread.sleep(1000);
    }

  }

}
