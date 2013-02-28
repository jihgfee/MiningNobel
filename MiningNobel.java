import java.util.Arrays;
import java.util.HashMap;

public class MiningNobel
{
	//This method finds the amount of 4-tuples with ~N^4 runtime - N being the length of a
	public static int exhaustiveCount(double[] a) 
	{
        int N = a.length;
        
		int count = 0;
        
		for (int i = 0; i < N; i++) 
		{
            for (int j = 0; j < N; j++) 
			{
                for (int k = 0; k < N; k++) 
				{
					for(int l = 0; l < N; l++)
					{
						if (a[i] + a[j] + a[k] + a[l] == 0)  	//We check if the iterated values sum up to 0
						{
							count++;
						}
					}
                }
            }
        }
		
        return count;
    }
	
	//This method finds the amount of 4-tuples with ~N^3*log(n) runtime - N being the length of a
	public static int fastCount(double[] a) 
	{
        int N = a.length;
        
		int count = 0;
        Arrays.sort(a);
		
		for (int i = 0; i < N; i++) 
		{
            for (int j = 0; j < N; j++) 
			{
                for (int k = 0; k < N; k++) 
				{
					int l = Arrays.binarySearch(a, -(a[i] + a[j] + a[k]));		//We iterate through the first 3 numbers, and then search for the last one
					
					if (l > -1) count++;										//We make sure that the returned index is an actual array index (more than -1)
                }
            }
        }
		
        return count;
    } 
	
	//This method finds the amount of 4-tuples with ~N^2*log(n) runtime - N being the length of a
	public static int cuteCount(double[] a)
	{
		int N = a.length;
        
		double[] b = new double[a.length*a.length];					//We make a new array containing all the summed values of the array a
		HashMap<Double, Integer> map = new HashMap<>();
		
		//We iterate through the array a
		for(int i=0; i < N; i++)
		{
			for(int j=0; j < N; j++)
			{
				double mapKey = a[i]+a[j];					//We allocate the value to save						
			
				b[a.length*i+j] = mapKey;					//We save the value in our array
				
				Integer mapCount = map.get(mapKey);			//We get the count of the current numbers duplicates
				
				if(mapCount == null)
					map.put(mapKey, 1);						//If the key has not yet been initialized we do so
				else
					map.put(mapKey, mapCount+1);			//Otherwise we add 1 to the keys value
			}
		}
	
		int count = 0;
        Arrays.sort(a);
		Arrays.sort(b);
		
		for (int i = 0; i < N; i++) 
		{
            for (int j = 0; j < N; j++) 
			{
				double numberToFind = a[i] + a[j] != 0 ? -(a[i] + a[j]) : 0;	//If the number we want to search for is not 0 we reverse it, else we assign 0 to the variable
				
				int k = Arrays.binarySearch(b, numberToFind);					//We iterate through the first 2 numbers, and then search for the last one in the summed array
				
				if (k > -1) 													//We check that the returned index k is actually in the array (more than -1)
				{
					count += map.get(numberToFind);								//We check our hashmap to see how many duplicates of the found number we have
				}
            }
        }
			
        return count;
	}
	
    public static void main(String[] args)  
	{ 
		String[] strings = new In(args[0]).readAll().split("\\n");					//We accumulate a string array containing each seperate line in the file.
		
		double[] doubleArray = new double[strings.length];
		
		for(int i = 0; i < strings.length; i++)
			doubleArray[i] = Double.parseDouble(strings[i].split(",")[1].trim());	//We iterate through our array and parse the double of each line to our double array
		
		Stopwatch timer = new Stopwatch();
        int count = cuteCount(doubleArray);											//We find the count of 4-tuples. (exhaustiveCount, fastCount, cuteCount may be applied)
        StdOut.println("elapsed time = " + timer.elapsedTime());
        StdOut.println(count);
		
    }
}