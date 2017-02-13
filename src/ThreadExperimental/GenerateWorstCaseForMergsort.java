package ThreadExperimental;

/**
 * Created by marc on 04.02.17.
 */
public class GenerateWorstCaseForMergsort {


    public static void print(int arr[])
    {
        System.out.println();
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static void merge(int[] arr, int[] left, int[] right) {
        int i,j;
        for(i=0;i<left.length;i++)
            arr[i]=left[i];
        for(j=0;j<right.length;j++,i++)
            arr[i]=right[j];
    }

    //Pass a sorted array here
    public static void seperate(int[] arr) {

        if(arr.length<=1)
            return;

        if(arr.length==2)
        {
            int swap=arr[0];
            arr[0]=arr[1];
            arr[1]=swap;
            return;
        }

        int i,j;
        int m = (arr.length + 1) / 2;
        int left[] = new int[m];
        int right[] = new int[arr.length-m];

        for(i=0,j=0;i<arr.length;i=i+2,j++) //Storing alternate elements in left subarray
            left[j]=arr[i];

        for(i=1,j=0;i<arr.length;i=i+2,j++) //Storing alternate elements in right subarray
            right[j]=arr[i];

        seperate(left);
        seperate(right);
        merge(arr, left, right);
    }

    public static void main(String args[])
    {
        int arr1[]={1,2,3,4,5,6,7};
        seperate(arr1);
        System.out.print("For array 1:");
        print(arr1);
        int arr2[]={0,1,2,3,4,5,6,7,8};
        seperate(arr2);
        System.out.print("For array 2:");
        print(arr2);
    }
}
