package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

// Example scenarios for testing
//   Item("+5 Dexterity Vest", 10, 20));
//   Item("Aged Brie", 2, 0));
//   Item("Elixir of the Mongoose", 5, 7));
//   Item("Sulfuras, Hand of Ragnaros", 0, 80));
//   Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
//   Item("Conjured Mana Cake", 3, 6));

	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_10_11() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 10, 10));
		
		// Act
		for (int i=0; i<12; i++) {
			store.updateEndOfDay();
		}
		
		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(24, item.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_SellIn_20_10() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 20, 20));
		
		// Act
		for (int i=0; i<10; i++) {
			store.updateEndOfDay();
		}
		
		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(10, item.getSellIn());
	}
	
	@Test
	public void testUpdateEndOfDay_Dex_Quality_60_50() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity West", 20, 60));
		
		// Act
		for (int i=0; i<10; i++) {
			store.updateEndOfDay();
		}
		
		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(50, item.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Dex_Quality_20_19() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest", 10, 20));
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(19, item.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Dex_SellIn_20_19() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest", 20, 20));
		
		// Act
		for (int i=0; i<1; i++) {
			store.updateEndOfDay();
		}
		
		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(19, item.getSellIn());
	}
	
	@Test
	public void testUpdateEndOfDay_Elixir_SellIn_15_3() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Elixir of the Mongoose", 15, 15));
		
		// Act
		for (int i=0; i<12; i++) {
			store.updateEndOfDay();
		}
		
		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(3, item.getSellIn());
	}
	
	@Test
	public void testUpdateEndOfDay_Elixir_Quality_10() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Elixir of the Mongoose", 10, 40));
		
		// Act
		for (int i=0; i<20; i++) {
			store.updateEndOfDay();
		}
		
		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(10, item.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Sulfuras_Quality_80_80() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		
		// Act
		for (int i=0; i<15; i++) {
			store.updateEndOfDay();
		}
		
		
		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(80, item.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Sulfuras_SellIn_80_80() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		
		// Act
		for (int i=0; i<15; i++) {
			store.updateEndOfDay();
		}
		
		
		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(0, item.getSellIn());
	}
	
	@Test
	public void testUpdateEndOfDay_Backstage_Quality_20_35() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		
		// Act
		for (int i=0; i<10; i++) {
			store.updateEndOfDay();
		}
		
		
		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(35, item.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Backstage_SellIn_20_5() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 20, 20));
		
		// Act
		for (int i=0; i<15; i++) {
			store.updateEndOfDay();
		}
		
		
		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(5, item.getSellIn());
	}
	
	@Test
	public void testUpdateEndOfDay_ManaCake_SellIn_10_2() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Conjured Mana Cake", 10, 20));
		
		// Act
		for (int i=0; i<8; i++) {
			store.updateEndOfDay();
		}
		
		
		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(2, item.getSellIn());
	}
	
	@Test
	public void testUpdateEndOfDay_ManaCake_Quality_20_10() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Conjured Mana Cake", 20, 20));
		
		// Act
		for (int i=0; i<10; i++) {
			store.updateEndOfDay();
		}
		
		
		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(10, item.getSellIn());
	}
	
}
