package com.creditsesame.challange.tax;
import org.junit.Assert;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.creditsesame.challange.item.Item;
import com.creditsesame.challange.item.ItemType;
import com.creditsesame.challange.tax.SalesTax;
import com.creditsesame.challange.tax.SalesTaxImpl;
/**
 * @author nahrin
 * This test class uses sample inputs to generate and compare with expected results.
 */
public class SalesTaxImplTest {
	SalesTax s = null;
	BigDecimal salesTaxes = null;
	BigDecimal total = null;
	/**
	 * @throws java.lang.Exception error during setup
	 */
	@Before
	public void setUp() throws Exception {
		s = new SalesTaxImpl();
		salesTaxes = new  BigDecimal("0.00");
		total = new BigDecimal("0.00");
	}

	/**
	 * @throws java.lang.Exception error during tear down
	 */
	@After
	public void tearDown() throws Exception {
		s = null;
	}

	/**
	 * calculate sales tax for three input items: <BR>
	 * 1 book at 12.49<BR>
	 * 1 music CD at 14.99<BR>
	 * 1 chocolate bar at 0.85<BR>
	 * display total sales tax and total price<BR>
	 */
	@Test
	public void testcalCulateTax1() {
		System.out.println("for input1 -----");
		Item item1 = new Item(1, "book", null, ItemType.BOOK, new BigDecimal("12.49"), null, false, 1);
		s.calculateTax(item1);
		total = total.add(item1.getPrice()).add(item1.getSalesTax()).multiply(new BigDecimal(item1.getCount()));
		salesTaxes = salesTaxes.add(item1.getSalesTax());
		Item item2 = new Item(2, "music", "music CD", ItemType.GOODS, new BigDecimal("14.99"), null, false, 1);
		s.calculateTax(item2);
		total = total.add(item2.getPrice()).add(item2.getSalesTax()).multiply(new BigDecimal(item2.getCount()));
		salesTaxes = salesTaxes.add(item2.getSalesTax());
		Item item3 = new Item(3, "chocolate", "chocolate Bar", ItemType.FOOD, new BigDecimal("0.85"), null, false, 1);
		s.calculateTax(item3);
		total = total.add(item3.getPrice()).add(item3.getSalesTax()).multiply(new BigDecimal(item3.getCount()));
		salesTaxes = salesTaxes.add(item3.getSalesTax());
		Assert.assertEquals(salesTaxes, new BigDecimal("1.50"));
		Assert.assertEquals(total, new BigDecimal("29.83"));

	}

	/**
	 * calculate sales tax for two input items: <BR>
	 * 1 imported box of chocolates at 10.00<BR>
	 * 1 imported bottle of perfume at 47.50<BR>
	 * display total sales tax and total price<BR>
	 */
	@Test
	public void testcalCulateTax2() {
		System.out.println("for input2 -----");
		Item item1 = new Item(1, "chocolates", "box of chocolates", ItemType.FOOD, new BigDecimal("10.00"), null, true, 1);
		s.calculateTax(item1);
		total = total.add(item1.getPrice()).add(item1.getSalesTax()).multiply(new BigDecimal(item1.getCount()));
		salesTaxes = salesTaxes.add(item1.getSalesTax());
		Item item2 = new Item(2, "bottle", "bottle of perfume", ItemType.GOODS, new BigDecimal("47.50"), null, true, 1);
		s.calculateTax(item2);
		total = total.add(item2.getPrice()).add(item2.getSalesTax()).multiply(new BigDecimal(item2.getCount()));
		salesTaxes = salesTaxes.add(item2.getSalesTax());
		System.out.println("sales tax: " + salesTaxes.toString());
		Assert.assertTrue(salesTaxes.equals(new BigDecimal("7.65")));
		System.out.println("total: " + total.toString());
		Assert.assertTrue(total.equals(new BigDecimal("65.15")));

	}
	
	/**
	 * calculate sales tax for four input items: <BR>
	 * 1 imported bottle of perfume at 27.99<BR>
	 * 1 bottle of perfume at 18.99<BR>
	 * 1 packet of headache pills at 9.75<BR>
	 * 1 box of imported chocolates at 11.25<BR>
	 * display total sales tax and total price<BR>
	 */
	@Test
	public void testcalCulateTax3() {
		System.out.println("for input3 -----");
		Item item1 = new Item(1, "perfume", "bottle of perfume", ItemType.GOODS, new BigDecimal("27.99"), null, true, 1);
		s.calculateTax(item1);
		total = total.add(item1.getPrice()).add(item1.getSalesTax()).multiply(new BigDecimal(item1.getCount()));
		salesTaxes = salesTaxes.add(item1.getSalesTax());
		Item item2 = new Item(2,  "perfume", "bottle of perfume", ItemType.GOODS, new BigDecimal("18.99"), null, false, 1);
		s.calculateTax(item2);
		total = total.add(item2.getPrice()).add(item2.getSalesTax()).multiply(new BigDecimal(item2.getCount()));
		salesTaxes = salesTaxes.add(item2.getSalesTax());
		Item item3 = new Item(3, "Pills", "packet of headache pills", ItemType.MEDICAL, new BigDecimal("9.75"), null, false, 1);
		s.calculateTax(item3);
		total = total.add(item3.getPrice()).add(item3.getSalesTax()).multiply(new BigDecimal(item3.getCount()));
		salesTaxes = salesTaxes.add(item3.getSalesTax());
		Item item4 = new Item(4, "chocolates", "box of chocolates", ItemType.FOOD, new BigDecimal("11.25"), null, true, 1);
		s.calculateTax(item4);
		total = total.add(item4.getPrice()).add(item4.getSalesTax()).multiply(new BigDecimal(item4.getCount()));
		salesTaxes = salesTaxes.add(item4.getSalesTax());

		System.out.println("sales tax: " + salesTaxes.toString());
		Assert.assertTrue(salesTaxes.equals(new BigDecimal("6.70")));
		System.out.println("total: " + total.toString());
		Assert.assertTrue(total.equals(new BigDecimal("74.68")));

	}
}
