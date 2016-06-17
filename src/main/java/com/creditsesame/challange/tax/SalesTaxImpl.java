package com.creditsesame.challange.tax;
import java.math.BigDecimal;

import com.creditsesame.challange.item.Item;
import com.creditsesame.challange.item.ItemType;

/**
 * @author nahrin
 * @version 0.1
 *
 */
public class SalesTaxImpl implements SalesTax {
	/**
     * Define rounding factor
     */
    private static final BigDecimal ROUND_FACTOR = new BigDecimal("0.05");
 
    /**
     * Define domestic tax percentages
     */
    private static final BigDecimal domesticTaxPercentage = new BigDecimal("10");
 
    /**
     * Define imported tax percentages
     */
    private static final BigDecimal additionalImportedTaxPercentage = new BigDecimal("5");
 
    private static BigDecimal taxPercentage = null;
    
	/** 
	 * @see SalesTax#calculateTax(Item)
	 * @param item item object
	 */
	public void calculateTax(Item item) {
		calculateTaxPercentage(item);
        calculateSalesTax(item);
	}
	/**
	 * Calculate tax percentage for items<BR>
     * Sales tax is applicable at a rate of 10% on all goods, except books,<BR>
     * food, and medical products that are exempt. Import duty is an additional<BR>
     * sales tax applicable on all imported goods at a rate of 5%, with no<BR>
     * exemptions.
	 * @param item object
	 */
	private void calculateSalesTax(Item item) {
		
        BigDecimal salesTax = item.getPrice().multiply(taxPercentage).divide(new BigDecimal("100"));
        salesTax = roundOff(salesTax);
        item.setSalesTax(salesTax);
	}
	/**
	 * @param item item object
	 * calculate the tax percentage for the item.
	 */
	private void calculateTaxPercentage(Item item) {
		ItemType type = item.getItemType();
		 
        if (type.equals(ItemType.BOOK) || type.equals(ItemType.FOOD) || type.equals(ItemType.MEDICAL)) {
            taxPercentage = new BigDecimal("0.00");
        } else {
            taxPercentage = domesticTaxPercentage;
        }
 
        if (item.isImported()) {
            taxPercentage = taxPercentage.add(additionalImportedTaxPercentage);
        }
		
	}
	
	/**
     * Returns the value rounded up to the nearest 0.05.
     * 
     * @param salesTax - value to be rounded
     * @return double rounded up value
     */
	private BigDecimal roundOff(BigDecimal salesTax) {
		salesTax = salesTax.divide(ROUND_FACTOR);
		salesTax = new BigDecimal(Math.ceil(salesTax.doubleValue()));
		salesTax= salesTax.multiply(ROUND_FACTOR);
        return salesTax;
	}

}
