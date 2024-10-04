
// https://leetcode.com/problems/stock-price-fluctuation/


class StockPrice {
  
    TreeMap<Integer, Integer> timePriceMap;
    TreeMap<Integer, Integer> priceCountMap;
    public StockPrice() {
       
        timePriceMap = new TreeMap<>();
        priceCountMap = new TreeMap<>();

        
    }
    
    public void update(int timestamp, int price) {
        if (timePriceMap.containsKey(timestamp)) {
            int oldPrice = timePriceMap.get(timestamp);
            priceCountMap.put(oldPrice, priceCountMap.get(oldPrice) - 1);
            if (priceCountMap.get(oldPrice) == 0) {
                priceCountMap.remove(oldPrice);
            }

        } 
        timePriceMap.put(timestamp, price);
        priceCountMap.put(price, priceCountMap.getOrDefault(price, 0) + 1);


        
    }
    
    public int current() {
        if (!timePriceMap.isEmpty()) {
            return timePriceMap.lastEntry().getValue();
        }
        
        return -1;
    }
    
    public int maximum() {
        return priceCountMap.lastKey();
        
    }
    
    public int minimum() {
        return priceCountMap.firstKey();
        
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
