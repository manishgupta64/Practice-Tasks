import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*Task:
 * 
 * 
 * Reverse words in a given string 
Given a String of length S, reverse the whole string without reversing the individual words in it. Words are separated by dots.

Input:
The first line contains T denoting the number of testcases. T testcases follow. Each case contains a string S containing characters.

Output:
For each test case, in a new line, output a single line containing the reversed String.

Constraints:
1 <= T <= 100
1 <= |S| <= 2000

Example:
Input:
2
i.like.this.program.very.much
pqr.mno

Output:
much.very.program.this.like.i
mno.pqr

** For More Input/Output Examples Use 'Expected Output' option **

 * 
 * 
 * */

public class ReverseCompleteStringWithReversingCharsOfWords {

	public static void main (String[] args) 
	{
	    Scanner sc = new Scanner( System.in );
	    try
	    {
    	    int T = sc.nextInt();
    	    List< String > inputStrings = new ArrayList<>();
    	    while( T > 0 )
    	    {
    	        inputStrings.add( sc.next() );
    	        T--;
    	    }
    	    List< String > output = new ArrayList<>( inputStrings.size() );
    	    inputStrings.forEach( s -> {
    	    	if( s == null || s.length() <= 1 )
    	    	{
    	    		output.add(s);
    	    	}
    	    	
    	    	String[] words = s.split("[.]");
    	       int i = 0; 
    	       int j = words.length - 1;
    	       int mid = j / 2;
    	       while ( i <= mid )
    	       {
    	           swap( words, i, j );
    	           i++;
    	           j--;
    	       }
    	       StringBuilder op = new StringBuilder();
    	       for( i = 0; i< words.length; i++ )
    	       {
    	    	   op.append( words[i] );
    	    	   if( i != words.length - 1 )
    	    	   {
    	    		   op.append(".");
    	    	   }
    	       }
    	       
    	       output.add( op.toString() );
    	    });
    	    
    	    output.stream().forEach( System.out::println );
    	    
	    }
	    catch( Exception e )
	    {
	        e.printStackTrace();
	    }
	    finally
	    {
	        sc.close();
	    }
	}
	
	private static void swap( String[] words, int i, int j )
	{
	    String temp = words[i];
	    words[i] = words[j];
	    words[j] = temp;
	}
}
