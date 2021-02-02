package io.practise.algo;

import java.text.DecimalFormat;

/**
 * price matching engine
 *
 */
public class PriceMatching {
	private static DecimalFormat df = new DecimalFormat("0.00");
	public static void main(String[] args) {
		double[] prices = {98.65664};
		//double[] prices = {98.65614};
		int[] stocks = {100};
		
		
		for(int i=0;i<prices.length;i++) {
			double newPrice1 = Double.valueOf(df.format((Double.valueOf(df.format(prices[i])) + 0.01)));
			double newPrice2 = Double.valueOf(df.format((Double.valueOf(df.format(prices[i])) - 0.01)));
			double total = prices[i] * stocks[i];
			double target = Double.valueOf(df.format(total));
			
			System.out.println("Target "+  target);
			int result = findBestCombination(target,stocks[i],newPrice1,newPrice2);
			System.out.println("Result: "+  result + "*" + newPrice1
					+ "+" + (stocks[i]-result)+ "*" + newPrice2 + "=" + target);
		}

	}
	
	public static int findBestCombination(double target,int num,double price1, double price2) {
		int i =1 , l =num,m=-1;
		
		while(i<=l) {
			m= (i+l)/2;
			double result =(m*price1) + (num-m)*price2;
			if(result == target) {
				break;
			}
			
			if(result < target) {
				i=m+1;
			}else {
				l = m -1;
			}
		}
		return m;
	}

}
