package com.creditsesame.challange;

import java.math.BigDecimal;
import java.util.Scanner;

import com.creditsesame.challange.cart.Cart;
import com.creditsesame.challange.cart.CartImpl;
import com.creditsesame.challange.item.Item;
import com.creditsesame.challange.item.ItemType;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner s = new Scanner(System.in);
        int id = 1; 
        Cart cart = new CartImpl();
        System.out.println("Please enter item name or type 'next' to exit: ");
        while (s.hasNext() ){
        	String name = s.nextLine();
        	if (name.toLowerCase().equals("exit")){
        		break;
        	}
        	System.out.println("Please enter item description: ");
        	String desc = s.nextLine();
        	System.out.println("Please enter item count: ");
        	String count = s.nextLine();
        	System.out.println("\nPlease enter item price: ");
        	String price = s.nextLine();
        	System.out.println("is the item imported (T/F): ");
        	String bl = s.nextLine();
        	Boolean imported = (bl.toUpperCase().equals("T") ) ? true : false;
        	Item item = new Item(id ++, name, desc, ItemType.GOODS, new BigDecimal(price), null, imported, Integer.parseInt(count));
        	System.out.println("Select ItemType: ");
        	System.out.println("B. BOOK");
            System.out.println("F. FOOD");
            System.out.println("M. MEDICAL");
            System.out.println("G. GOODS");
            System.out.println();
            System.out.println("Your answer: ");
            String uSelect1 = s.nextLine();
            System.out.println(uSelect1.toUpperCase());
			if (uSelect1.toUpperCase().equals("M")) {
				item.setItemType(ItemType.MEDICAL);
			} else if (uSelect1.toUpperCase().equals("B")) {
				item.setItemType(ItemType.BOOK);
			} else if (uSelect1.toUpperCase().equals("F")) {
				item.setItemType(ItemType.FOOD);
			} else if (uSelect1.toUpperCase().equals("G")) {
				item.setItemType(ItemType.GOODS);
			} else {
				item.setItemType(ItemType.GOODS);
			}
        	cart.addItemToCart(item);
        	System.out.println("Please enter item name or type 'exit' to exit: ");
        }
        cart.printReciept();
    }
}
