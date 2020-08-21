package com.interview.questions;

import java.util.ArrayList;
import java.util.List;

/*
 * Note:
 * 
 * 	This program finds all the possible palindrome in the given string.
    Also, a case has been handled in this program to store the longest palindrome in variable longestPalimdrome
*
*/


public class LongestPalindromeInString 
{
	public static void main( String[] args )
	{
		String s = "asbasasasasasabcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbagaga";
		//s = "abc"; // try this
		//s = "";
		
		if( s ==  null || s.length() == 0 )
		{
			System.out.println("Please provide string having more than 1 chars");
			return;
		}
		
		// holds all the possible pallindromes in the list
		List< String > palindromes = new ArrayList<>();
		
		long startTime = System.currentTimeMillis();
		
		/*	Approach used:
		 * 	1) Traverse the given string till the end
		 *  2) Main two variable: frontIndex and rearIndex
		 *  	frontIndex which is initialized to current iterationIndex and rearIndex which is initialized to str.length()-1
		 *  	Both indices will be updated till the time we get the matching chars at frontIndex and rearIndex
		 *  	If chars do not match at both ends, then check whether readIndex has reached to the frontIndex, 
		 *  		if not, just update the rearIndex, else break the loop and start for next character of the string
		 *  			
		 *  3) One variable "palindromeEndIndex" is maintained to keep track of the palindrome string 
		 *  	 
		 * 
		 * */
		
		int longestPatternLen = 1;
		String longestPalindrome = "" + s.charAt(0);
		
		
		for( int i = 0; i < s.length(); i++ )
		{
			int rearIndex = s.length() - 1;
			int frontIndex = i;
			int palindromeEndIndex = -1;
			while( frontIndex <= rearIndex )
			{
				if( (frontIndex == rearIndex ) && palindromeEndIndex != -1 )
				{
					int palindromeLenth = ( palindromeEndIndex + 1 - i );
					if( longestPatternLen < palindromeLenth )
					{
						longestPalindrome = s.substring( i, palindromeEndIndex + 1 );
						longestPatternLen = longestPalindrome.length(); 
					}
					palindromes.add( s.substring( i, palindromeEndIndex + 1 ));
					break;
				}
				if ( s.charAt( frontIndex ) == s.charAt( rearIndex ) )
				{
					if( palindromeEndIndex == -1 )
					{
						palindromeEndIndex = rearIndex;
					}
					frontIndex++;
				}
				else if( rearIndex <= i && palindromeEndIndex != -1 )
				{
					break;
				}
				else
				{
					palindromeEndIndex = -1;
					frontIndex = i;
				}
				rearIndex--;
			}
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println( "Completed in " + ( endTime - startTime ));
		
		System.out.println( "Longest pallindrome = " + longestPalindrome );
		System.out.println( "Palindrome length = " + longestPatternLen );
		
		// If you want to print all the palindrome, just uncomment below statement
		//palindromes.stream().forEach( (str) -> System.out.println(str));
	}
}
