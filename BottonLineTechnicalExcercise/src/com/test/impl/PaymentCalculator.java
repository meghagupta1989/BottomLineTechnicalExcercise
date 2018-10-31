/**
 * 
 */
package com.test.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author ex22714
 *
 */
public class PaymentCalculator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if(null != args & args.length == 2 ) {
			BigDecimal totalAmount;
			BigDecimal noOfPay; 
			try {
				//First Argument total number of pay
				totalAmount = new BigDecimal(args[0]);
				
				//First Argument total number of pay
				noOfPay = new BigDecimal(args[1]);
			} catch (NumberFormatException e) {
				//If the arguments passed are not in correct format
				System.out.println("Arguments passed are not numbers/decimal");
				return;
			}
			
	        //Calculating regular amount
			BigDecimal toPay = totalAmount.divide(noOfPay, 2, RoundingMode.HALF_UP);
	        System.out.println("Regular Amount : " + toPay);
	        
	        //calculating last amount if there is some remainder
	        if(toPay.multiply(noOfPay).compareTo(totalAmount) != 0) {
	            BigDecimal lp = toPay.multiply(noOfPay);
	            BigDecimal deficit = totalAmount.subtract(lp);
	            System.out.println("Last Amount : " + toPay.add(deficit));
	        }
		} else {
			System.out.println("Wrong number of arguments");
		}
		
	}
}