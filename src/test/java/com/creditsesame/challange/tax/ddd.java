package com.creditsesame.challange.tax;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ddd {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws ParseException {
		creditcard c = new creditcard();
		c.setCardid(7);
		System.out.println("cardId" + c.getCardid());
		Double total = 10.00;
		double counter = 2.00;
		System.out.println(total/counter);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
		Date d = sdf.parse("07/12/2014");
		
		
	}

}


class creditcard{
	private int cardid = 9;
	private String name = "test";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "creditcard [cardid=" + cardid + ", name=" + name + "]";
	}

	public int getCardid() {
		return cardid;
	}

	public void setCardid(int cardid) {
		this.cardid = cardid;
	}
	
	
}
