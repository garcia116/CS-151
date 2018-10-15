package invoice;

/**
A product with a price and description.
*/
public class Product implements LineItem
{
/**
   Constructs a product.
   @param description the description
   @param price the price
*/
public Product(String description, double price)
{
   this.description = description;
   this.price = price;
}
public double getPrice() { return price; }
public int getQuantity() { return quantity;}
public String toString() { return description; }
private String description;
private double price;
private int quantity=1;
@Override
public int incrementItem() {
	return quantity++;
}
@Override
public double totalPrice() {
	return price*quantity;
}


}

