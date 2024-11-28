package com.vsk.warehousemanagement.lld;

class RateLimiter {
  private int bucketCapacity;
  private int refillRate;
  private long lastRefillTime;
  private int tokenCount;

  public RateLimiter(int bucketCapacity, int refillRate) {
    this.bucketCapacity = bucketCapacity;
    this.refillRate = refillRate;
    this.tokenCount = this.bucketCapacity;
  }

  public synchronized String allowRequest() {
    refillTokens();
    if (tokenCount > 0) {
      tokenCount--;
      return "Allowed";
    }

    return "Blocked";
  }

  private void refillTokens() {
    long currentTime = System.currentTimeMillis();
    long refillToken = (System.currentTimeMillis() - this.lastRefillTime) / 1000 * refillRate;

    if (refillToken == 0) return;

    tokenCount = Math.min(bucketCapacity, tokenCount + (int) refillToken);

    System.out.println("Refilled token : " + refillToken + " final tokens count : " + tokenCount);
    this.lastRefillTime = currentTime;
  }
}

public class RateLimiterDemo {
  public static void main(String[] args) throws InterruptedException {
    System.out.println("Starting RateLimiterDemo");
    RateLimiter rateLimiter = new RateLimiter(4, 1);

    for (int i = 0; i<50; i++) {
      System.out.println(rateLimiter.allowRequest());
      Thread.sleep(400);

    }


  }

}
