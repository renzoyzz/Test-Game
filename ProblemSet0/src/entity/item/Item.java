package entity.item;


import java.util.Random;

import entity.Entity;
/**
 * Item is the abstract base class for all potential
 * dropped items after an enemy is slain. This class
 * will keep track of properties common to all possible
 * items that are dropped.
 * <p>
 * There are two constructors: 
 * <p>
 * 1) Non quest items, which using will randomly generate 
 * the properties of the item. 
 * <p>
 * 2) Quest items, which using requires the item properties 
 * to be explicitly defined.
 * 
 * @author Garren Boggs
 */
abstract class Item extends Entity
{	
	private Type itemType;
	private String itemName;
	private int itemLevel;
	private Rarity itemRarity;
	private boolean questItem;
	private int itemPrice;
	//TODO figure out how to implement parameters for randomization instantiations
	//Not Quest
	public Item(Type type)
	{
		itemType = type;
		itemLevel = randomizeLevel(99, 150);
		itemRarity = Rarity.randomize(100, 99, 150, itemLevel);
		questItem = false;
	}
	//Quest
	public Item(Type type, String name, Rarity rarity, int level)
	{
		itemType = type;
		itemName = name;
		itemLevel = level;
		itemRarity = rarity;
		questItem = true;
		itemPrice = 0;
	}
	
	/**
	 * Generates a random level for the item based on an algorithm dependent
	 * on both the players' and enemies' levels. The algorithm accounts for
	 * large differences between the corresponding levels, and adjusts
	 * accordingly.
	 * 
	 * @param pLvl the player's current level
	 * @param eLvl the enemy's current level
	 * @return a randomly generated item level
	 */
	private int randomizeLevel(int pLvl, int eLvl)
	{
		int _lvl = pLvl < eLvl ? pLvl : eLvl;
		
		//Additional random perturbation
		int ptrb = new Random().nextInt((pLvl/15 + eLvl/15)/(eLvl/pLvl+1)+(eLvl/pLvl)+3);

		//Shifts ranges to account for large difference between player and enemy levels
		int lshift = ((pLvl-eLvl)/10 != 0 && eLvl < 100) ? (((pLvl-eLvl)/20 != 0 && eLvl < 100) 
				? pLvl-eLvl : (pLvl-eLvl)/2) : 0;
		lshift *= lshift < 0 ? -1 : 1;
		
		//Item levels must be between 1 and 99
		int lvlLBound = (_lvl-ptrb-lshift <= 0) ? 1 : 
			((_lvl-ptrb-lshift > 95) ? 95 : _lvl-ptrb-lshift);
		int lvlUBound = (_lvl+ptrb/2-lshift > 98) ? 98 : 
			((_lvl+ptrb/2-lshift <= 0) ? lvlLBound+eLvl/5 : _lvl+ptrb/2-lshift) ;
		
		//Additional randomness increasing difficulty to achieve level 99
		if(lvlUBound == 98)
			lvlUBound += new Random().nextInt(10)+1 > 7 ? 1 : 0;
		
		//Return randomly generated level between calculated bounds
		return new Random().nextInt(lvlUBound-lvlLBound+1) + lvlLBound;
	}
	
	/**
	 * 
	 * 
	 * @return a randomly generated Item
	 */
	abstract protected Item dropItem();
	
	/**
	 * Unique for each subclass of items. Each property
	 * of the item is accessed and weighed into 
	 * determining its price. 
	 * 
	 * @return the calculated price for the item
	 */
	abstract protected int determinePrice();
	
	/**
	 * @return the item's type
	 */
	public Type getItemType()
	{
		return itemType;
	}
	
	/**
	 * @return the item's name
	 */
	public String getItemName()
	{
		return itemName;
	}
	
	/**
	 * @return the item's level
	 */
	public int getItemLevel()
	{
		return itemLevel;
	}
	
	/**
	 * @return the item's rarity
	 */
	public Rarity getItemRarity()
	{
		return itemRarity;
	}
	
	/**
	 * Returns true if the item is a quest item, false
	 * otherwise. Quest items have predefined properties
	 * and cannot be sold.
	 * 
	 * @return quest status of the item
	 */
	public boolean isQuestItem()
	{
		return questItem;
	}
	
	/**
	 * @return the item's price
	 */
	public int getItemPrice()
	{
		return itemPrice;
	}
	
	/**
	 * Sets the name of the item. The name of a non quest item
	 * is randomly selected, and can sometimes be concatenated
	 * with other properties (such as Quality for Weapons). For
	 * quest items, the name of the item will be predetermined.
	 * 
	 * @param name the name to set for the item
	 */
	protected void setItemName(String name)
	{
		itemName = name;
	}
	
	/**
	 * Sets the price of the item. The price of each item
	 * is procedurally determined based on the properties
	 * of the item.
	 * 
	 * @param price the price to set for the item
	 * @see determinePrice
	 */
	protected void setItemPrice(int price)
	{
		itemPrice = price;
	}
}
