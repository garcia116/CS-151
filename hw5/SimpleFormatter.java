package invoice;

/**
A simple invoice formatter.
*/
public class SimpleFormatter implements InvoiceFormatter
{
public String formatHeader()
{
   total = 0;
   return "     I N V O I C E\n\n\n";
}

public String formatLineItem(LineItem item)
{
   total += item.totalPrice();
   return (String.format(
         "%s %s %s\n",item.getQuantity(), item.toString(),item.getPrice()));
}

public String formatFooter()
{
   return (String.format("\n\nTOTAL DUE: $%.2f\n", total));
}

private double total;
}

