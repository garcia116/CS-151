
public class Strings {
	   public static String uniqueLetters(String str)
	   {
	      String letters = "";
	      for(int i = 0; i < str.length(); ++i){
	         int count = 0;
	         for(int a = 0; a <str.length(); ++a){
	         if(i != a && str.charAt(i) == str.charAt(a)){
	            ++count;
	         }
	      }
	         if(count == 0){
	         letters += String.valueOf(str.charAt(i));
	        }
	      }
	      return letters;
	   }
	}
