package assignments;

public class ItemToPurchase 
{
	private String itemName;
	private int itemPrice;
	private int itemQuantity;
	
	
	
	
	public ItemToPurchase() //default constructor
	{
		this.itemName = (null);
		this.itemPrice = (0);
		this.itemQuantity = (0);
	}
	
	public String getitemName() 
	{
		return this.itemName;
	}
	public void setitemName(String itemName) 
	{
		this.itemName = itemName;
	}
	public int getitemPrice() 
	{
		return itemPrice;
	}
	public void setitemPrice(int itemPrice) 
	{
		this.itemPrice = itemPrice;
	}
	public int getitemQuantity() 
	{
		return itemQuantity;
	}
	public void setitemQuantity(int itemQuantity) 
	{
		this.itemQuantity = itemQuantity;
	}
	
	
	
}
