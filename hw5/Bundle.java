package invoice;

import java.util.*;

/**
   A bundle of line items that is again a line item.
*/
public class Bundle implements LineItem
{
	int count = 0;
   /**
      Constructs a bundle with no items.
   */
   public Bundle() { items = new ArrayList<>(); }

   /**
      Adds an item to the bundle.
      @param item the item to add
   */
   public void add(LineItem item) {
	   items.add(item);
	   count++;}

   public double getPrice()
   {
      double price = 0;

      for (LineItem item : items)
         price += item.getPrice();
      return price;
   }

   public String toString()
   {
      String description = "Bundle: ";
      for (int i = 0; i < items.size(); i++)
      {
         if (i > 0) description += ", ";
         description += items.get(i).toString();
      }
      return description;
   }

   private ArrayList<LineItem> items;

@Override
public int getQuantity() {
	return count-1;
}

@Override
public int incrementItem() {
	return count++;
}

@Override
public double totalPrice() {
	return getQuantity()*getPrice();
}
}

