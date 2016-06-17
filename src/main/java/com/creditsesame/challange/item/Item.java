package com.creditsesame.challange.item;
import java.math.BigDecimal;

/**
 * @author     nahrin
 * @version    0.1
 * Item object
 */
public class Item {
	
	private int id;
	private String name;
	private String description;
	private ItemType itemType = ItemType.GOODS;
	private BigDecimal  price;
	private BigDecimal salesTax;
	private boolean isImported = false;
	private int count = 1;
	
	/**
	 * @param id item id
	 * @param name item name
	 * @param description item description
	 * @param itemType item type
	 * @param price item price
	 * @param salesTax item sales tax after calculation
	 * @param isImported if item is imported
	 * @param count item count
	 */
	public Item(int id, String name, String description, ItemType itemType, BigDecimal price, BigDecimal salesTax,
			boolean isImported, int count) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.itemType = itemType;
		this.price = price;
		this.salesTax = salesTax;
		this.isImported = isImported;
		this.count = count;
	}
	
	/**
	 * @return item id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id set item id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return item name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name item name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return item description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description set item description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return item type 
	 */
	public ItemType getItemType() {
		return itemType;
	}
	/**
	 * @param itemType item type
	 */
	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}
	/**
	 * @return item price in BigDecimal
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * @param price set item price in BigDecimal
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * @return sales tax for the item in BigDecimal
	 */
	public BigDecimal getSalesTax() {
		return salesTax;
	}
	/**
	 * @param salesTax set sales tax for the item in BigDecimal
	 */
	public void setSalesTax(BigDecimal salesTax) {
		this.salesTax = salesTax;
	}
	/**
	 * @return true if the item is imported; otherwise false.
	 */
	public boolean isImported() {
		return isImported;
	}
	/**
	 * @param isImported set true if it is imported
	 */
	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}
	/**
	 * 
	 * @return count
	 */
	public int getCount() {
		return count;
	}
	
	/**
	 * set the count for the selected items
	 * @param count set item count
	 */
	public void setCount(int count) {
		this.count = count;
	}
}
