package com.creditsesame.challange.cart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.creditsesame.challange.item.Item;
import com.creditsesame.challange.tax.SalesTax;
import com.creditsesame.challange.tax.SalesTaxImpl;
/**
 * Cart implementation class
 * @author nahrin
 *
 */
public class CartImpl implements Cart {

	private List<Item> items = null;
	private SalesTax s = null;
	private BigDecimal salesTaxes = null;
	private BigDecimal total =  null;
	
	public CartImpl() {
		init();
	}

	/**
	 * Add item to list of items
	 * @param item item
	 */
	public void addItemToCart(Item item) {
		s.calculateTax(item);
		items.add(item);
	}

	public void printReciept() {
		for(Item item: items){
			total = total.add(item.getPrice()).add(item.getSalesTax()).multiply(new BigDecimal(item.getCount()));
			salesTaxes = salesTaxes.add(item.getSalesTax());
			System.out.println(item.getCount() + "  "+ 
					(item.isImported()? "imported ": "") + 
					item.getDescription() + " " + 
					"at " + item.getPrice().add(item.getSalesTax()) );
		}
		System.out.println("sales tax: " + salesTaxes.toString());
		System.out.println("total: " + total.toString());

	}

	public void init() {
		items = new ArrayList<Item>();
		s = new SalesTaxImpl();
		salesTaxes = new BigDecimal("0.00");
		total = new BigDecimal("0.00");	
		
	}
}
