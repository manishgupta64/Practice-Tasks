import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/*Task:
 *
 * Winner of an election 
Given an array of names (consisting of lowercase characters) of candidates in an election. A candidate name in array represents a vote casted to the candidate. Print the name of candidate that received Max votes. If there is tie, print lexicographically smaller name.

Input:
The first line of the input contains a single integer T, denoting the number of test cases. Then T test case follows. Each testcase contains two lines:-
The number of votes cast N
The name of the candidates separated by a space. Each name represents one vote casted to that candidate.

Output:
For each testcase, print the name of the candidate with the maximum votes, and also print the votes casted for the candidate. The name and votes are separated by a space.

Constraints:
1 <= T <= 100
1 <= N <= 105

Example:
Input:
2
13
john johnny jackie johnny john jackie jamie jamie john johnny jamie johnny john
3
andy blake clark

Output:
john 4
andy 1

Explanation:
Testcase1: john has 4 votes casted for him, but so does johny. john is lexicographically smaller, so we print john and the votes he received.
Testcase2: All the candidates get 1 votes each. We print andy as it is lexicographically smaller.

** For More Input/Output Examples Use 'Expected Output' option **
 * 
 * 
 * 
*/
	


public class VotingSystem
{
    public static void main( String[] args )
    {
    	Scanner sc = new Scanner( System.in ); 
    	try 
    	{
    		int T = sc.nextInt();
            int  i = 0;
            while (i < T )
            {
            	Map< String, Candidate > voteCountMap = new HashMap<>();
                int numberOfVotes = sc.nextInt();
                int votesCount = 0;
                while( votesCount < numberOfVotes )
                {
                	String vote = sc.next();
                	if( voteCountMap.containsKey( vote ) )
                	{
                		Candidate c = voteCountMap.get( vote );
                		int newCount = c.getCount() + 1;
                		c.setCount( newCount );
                		voteCountMap.put(vote, c );
                	}
                	else
                	{
                		voteCountMap.put(vote, new Candidate( vote, 1));
                	}
                	votesCount++;
                }
            	i++;
            	
                Comparator< Candidate > c = Comparator.comparing( Candidate::getCount ).reversed().thenComparing( Candidate::getName );
                Candidate winner = voteCountMap.values().stream().sorted( c ).collect( Collectors.toList() ).get(0);

                System.out.println( winner.getName() + " " + winner.getCount() );
            }

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
}

class Candidate
{
	private String name;
	
	private int count;

	Candidate( String name, int count )
	{
		this.name = name;
		this.count = count;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}





