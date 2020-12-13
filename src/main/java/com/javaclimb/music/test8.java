package com.javaclimb.music;

import java.sql.Array;
import java.util.ArrayList;

public class test8 {
    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5,6,7};
        System.out.println(maxPrices(prices));
    }

    public static int maxPrices(int[] prices) {
      int profit=0;
      for (int i=1;i<prices.length;i++){
          if(prices[i]>prices[i-1])
              profit+=prices[i]-prices[i-1];
      }
      return profit;
    }
}