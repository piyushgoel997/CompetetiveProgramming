import java.util.Scanner;

public class MinimumScalarProduct {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void mergeSort(long[] arr)
	{
		if(arr.length == 1)
		{
			return;
		}	
		long[] split1 = new long[arr.length/2];
		long[] split2 = new long[arr.length - arr.length/2];

		int k =0;

		for(int j = 0; j < split1.length; j++)
		{
			split1[j] = arr[k];
			k++;
		}
		for(int j = 0; j < split2.length; j++)
		{
			split2[j] = arr[k];
			k++;
		}

		mergeSort(split1);
		mergeSort(split2);
		long x[] = merge(split1,split2);
		for(int i = 0; i < x.length; i++)
		{
			arr[i] = x[i];
		}		
	}
	
	public static long[] merge(long a[], long b[])	
	{
		long[] output = new long[a.length + b.length];
		merge_helper(a, b, output, 0, 0, 0);
		return output;
	}

	public static void merge_helper(long[] a, long[] b,long[] outputarr,int begina,int beginb,int arrindex)
	{
		// Base case
		if(begina == a.length)
		{
			while(beginb < b.length)
			{
				outputarr[arrindex] = b[beginb];
				beginb++;
				arrindex++;
			}
			return;
		}
		if(beginb == b.length)
		{
			while(begina < a.length)
			{
				outputarr[arrindex] = a[begina];
				begina++;
				arrindex++;
			}
			return;
		}



		// General case
		if(a[begina] < b[beginb])
		{
			outputarr[arrindex] = a[begina];
			begina++;
		}
		else
		{
			outputarr[arrindex] = b[beginb];
			beginb++;
		}
		merge_helper(a,b,outputarr,begina,beginb,arrindex+1);
	}
	
	public static void reverseArray(long[] arr){
		for(int i = 0; i < arr.length/2; i++){			
			long x=arr[i];
			arr[i]=arr[arr.length-i-1];
			arr[arr.length-i-1]=x;
		}				
	}
	
	public static long[] takeArrayInput(int n){
		long[] arr = new long[n];
//		Scanner scanner = new Scanner(System.in);
		for(int i = 0; i < n; i++){
			arr[i] = scanner.nextInt();
		}
		return arr;
	}
	
	public static long scalarProduct(long[] a, long[] b){
		// The size of a and b should be same for this method to work.
		long pdt = 0;
		for(int i = 0; i < a.length; i++){
			pdt += a[i]*b[i];
		}		
		return pdt;
	}
	
	/*public static int minScalarPdt(){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] a = takeArrayInput(n);
		int[] b = takeArrayInput(n);
		
		mergeSort(a);
		
		mergeSort(b);
		reverseArray(b);
		
		return scalarProduct(a, b);
	}*/
	
	public static void main(String[] args){
		long x = System.currentTimeMillis();
//		Scanner scanner = new Scanner(System.in);

		int t = scanner.nextInt();
		long[] result = new long[t];
		
		for(int i = 0; i < t; i++){
			int n = scanner.nextInt();
			long[] a = takeArrayInput(n);
			long[] b = takeArrayInput(n);
			
			mergeSort(a);
			
			mergeSort(b);
			reverseArray(b);
			
			result[i] = scalarProduct(a, b);
//			result[i] = minScalarPdt();			
		}
		for(int i = 0; i < t; i++){
			System.out.println("Case #" + (i + 1) + ": " + result[i]);
		}
		System.out.println(System.currentTimeMillis() - x);
	}

}
