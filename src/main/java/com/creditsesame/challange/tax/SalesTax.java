package com.creditsesame.challange.tax;

import com.creditsesame.challange.item.Item;

/**
 * @author nahrin
 * @version 0.1
 *
 */
public interface SalesTax {
	/**
	 * interface to calculate sales tax
	 * @param item item object
	 */
	public void calculateTax(Item item);
}
