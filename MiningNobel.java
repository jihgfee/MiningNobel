import java.util.Arrays;

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
						if (a[i] + a[j] + a[k] + a[l] == 0) 
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
					int l = Arrays.binarySearch(a, -(a[i] + a[j] + a[k]));
					
					if (l > -1) count++;
                }
            }
        }
		
        return count;
    } 
	
	//This method finds the amount of 4-tuples with ~N^2*log(n) runtime - N being the length of a
	public static int cuteCount(double[] a)
	{
		int N = a.length;
        
		double[] b = new double[a.length*a.length];
		
		for(int i=0; i < N; i++)
		{
			for(int j=0; j < N; j++)
			{
				b[a.length*i+j] = a[i]+a[j];
			}
		}
	
		int count = 0;
        Arrays.sort(a);
		Arrays.sort(b);
		
		for (int i = 0; i < N; i++) 
		{
            for (int j = 0; j < N; j++) 
			{
				double numberToFind = a[i] + a[j] != 0 ? -(a[i] + a[j]) : 0;
				
				int k = Arrays.binarySearch(b, numberToFind);
				
				if (k > -1) 
				{
					count++;
					
					int searchIndex = k;
				
					while(searchIndex++ >= 0 && searchIndex < b.length && b[searchIndex] == numberToFind)
						count ++;
					
					searchIndex = k;
				
					while(searchIndex-- >= 0 && searchIndex < b.length && b[searchIndex] == numberToFind)
						count++;
				}
            }
        }
			
        return count;
	}
	
    public static void main(String[] args)  
	{ 
		
		String[] strings = new In(args[0]).readAll().split("\\n");
		
		double[] doubleArray = new double[strings.length];
		
		for(int i = 0; i < strings.length; i++)
		{
			doubleArray[i] = Double.parseDouble(strings[i].split(",")[1].trim());
		}
		
		Stopwatch timer = new Stopwatch();
        int count = cuteCount(doubleArray);
        StdOut.println("elapsed time = " + timer.elapsedTime());
        StdOut.println(count);
		
    }
}