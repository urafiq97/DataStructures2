
import java.util.*;
/* Create a hash table using an array to store integers. We will use
 * the remainder method to locate the data. Given a collision, we will
 * resolve by linear probing
 * Code originally developed by Townsend, not Troy
 */
public class Hash1
{
    static int size = 20;
    static int items = 20;
    static int [] hashTable = new int[size];
    
    public static void main (String [] args)
    {
        Random randy = new Random();
        Scanner reader = new Scanner(System.in);
        
/*This is to demonstrate the pre-existing .hashCode() method inherited by all objects
*       String word = "Longhorns";
*       System.out.println( word.hashCode() );
*/        
        for(int x=0; x<items; x++)
        {
            int goofy = randy.nextInt(1000 + 1);
            hashMe(goofy);
        }
        
        System.out.println(Arrays.toString(hashTable));
        System.out.println("Enter an item to search for.");
        int item = reader.nextInt();
        System.out.println("Found in spot " + search(item) );
    
    }
    
    // uses a modulus(division) based system to hash
    public static void hashMe( int i )
    {
        if( hashTable[ i % size ] == 0 ) { hashTable[i % size] = i; }   // evalates if a "bucket" (array item) is occupied (as zero is the default null value for int[])
        else                                                            // if not, linear probes until there's an open space
        {
            int spot = i%size;                  // starts at offending position
                while( hashTable[spot] != 0 )   
                {
                    spot++;                     // iterates the spot position until there's an open space
                    spot = spot%size;           // using mod to "wrap around" the array
                }   
            hashTable[spot] = i;
        }
    }
    
    public static int search( int i )
    { 
        int spot = i%size;                      // start at probable position given our hashing method (modulus)
        for( int x=0; x<size; x++ )             // iterates until we found the spot
        {
            if( hashTable[spot] == i )          
                return spot;
            
            if( hashTable[spot] == 0 )          // if dudebro doesn't exist in his rightful place, he was never in the hastable to begin with
            return -1;
            
            spot++;
            spot = spot % size;
        }
        
        return -1;
    }
    
    
}
