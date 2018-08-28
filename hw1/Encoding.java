import java.util.*;
public class Encoding {
	 public static Set<String> morseCodes(int m, int n)
	   {
	      Set<String> result = new TreeSet<>();
	         
	       for(int i = 0; i < m; i++){
	          

	         morseCodes(m-1,n);
	         result.add(".") ;
	       }
	         return result;
	         } 
}
