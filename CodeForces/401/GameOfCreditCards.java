import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by piyus on 24-02-2017.
 */
public class GameOfCreditCards {

    public static void main(String[] z) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();

        int[] a = fn(m);
        int[] b = fn(n);

        int x = 0;
        int y = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] < b[i]) {
                x++;
            } else if (b[i] < a[i]) {
                y++;
            }
        }
    }

    public static int[] fn(int n) {
        int temp = n;
        ArrayList<Integer> array = new ArrayList<Integer>();
        do{
            array.add(temp % 10);
            temp /= 10;
        } while  (temp > 0);

        int[] arr = new int[array.size()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = array.get(i);
        }

        mergesort(arr);

        //TODO
        return new int[] {};
    }


    public static void mergesort(int[] arr)
    {
        if(arr.length == 1)
        {
            return;
        }
        int[] split1 = new int[arr.length/2];
        int[] split2 = new int[arr.length - arr.length/2];

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

        mergesort(split1);
        mergesort(split2);
        int x[] = merge(split1,split2);
        for(int i = 0; i < x.length; i++)
        {
            arr[i] = x[i];
        }
    }

    public static int[] merge(int a[], int b[])
    {
        int[] output = new int[a.length + b.length];
        merge_helper(a, b, output, 0, 0, 0);
        return output;
    }

    public static void merge_helper(int[] a, int[] b,int[] outputarr,int begina,int beginb,int arrindex)
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
}
