package com.creditsesame.challange.cart;

import com.creditsesame.challange.item.Item;

/**
 * Cart interface
 * @author nahrin
 *
 */
public interface Cart {
	
		public void addItemToCart(Item item);
		public void printReciept();
		public void init();
}
