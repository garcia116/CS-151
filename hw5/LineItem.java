package invoice;

/**
A line item in an invoice.
*/
public interface LineItem
{
/**
   Gets the price of this line item.
   @return the price
*/
double getPrice();

double totalPrice();

/**
   Gets the description of this line item.
   @return the description
*/   
String toString();

int getQuantity();


int incrementItem();




}
