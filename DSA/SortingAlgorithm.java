import java.util.Scanner;

public class SortingAlgorithm {

    public int[] bubbleSort(int[] arr){
        int arr_size = arr.length;
        boolean swapped;
        for(int i = 0; i < arr_size -1; i++){
            swapped = false;
            for(int j = 0; j < arr_size - 1 - i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            // No swapped occurred in the inner hence the array is sorted.
            if (!swapped)
                break;
        }
        return arr;
    }

    public int[] selectionSort(int[] arr){
        int arr_size = arr.length;
        for(int i=0; i<arr_size; i++){
            int min_idx = i;
            for(int j=i+1; j<arr_size; j++){
                if(arr[j] < arr[min_idx]){
                    min_idx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }
        return arr;
    }

    public int[] interstionSort(int[] arr){
        int arr_size = arr.length;
        for(int i=1; i<arr_size; i++){
            int prev = i-1;
            int key = arr[i];
            while(prev >= 0 && arr[prev] > key){
                arr[prev+1] = arr[prev];
                prev = prev - 1;
            }
            arr[prev+1] = key;
        }
        return arr;
    }

    public void merge(int[] arr, int low, int mid, int high){
        int left = low;
        int right = mid + 1;
        int[] temp = new int[(high - low) + 1];
        int idx = 0;

        while(left<=mid && right<=high){
            if(arr[left] < arr[right]){
                temp[idx] = arr[left];
                idx++; left++;
            } else {
                temp[idx] = arr[right];
                idx++; right++;
            }
        }

        while(left<=mid){
            temp[idx] = arr[left];
            idx++; left++;
        }

        while(right<=high){
            temp[idx] = arr[right];
            idx++; right++;
        }

        for (int i=0; i<temp.length; i++){
            arr[low+i] = temp[i];
        }
    }

    public void mergeSort(int[] arr, int low, int high){
        // Base condition
        if(low >= high)
            return;
        int mid = (low+high)/2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);

        merge(arr, low, mid, high);
    }

    public void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        SortingAlgorithm sortingAlgorithm = new SortingAlgorithm();
        try{
            System.out.println("Enter the size of an array: ");
            int n =  scanner.nextInt();

            if(n<=0){
                System.out.println("Enter positive size of an array: ");
                return;
            }

            System.out.println(String.format("Enter the %d element of an array: ", n));
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = scanner.nextInt();
            }

            //Print Original Array
            System.out.println("Original Array: ");
            sortingAlgorithm.printArray(arr);

            System.out.println("Choose sorting algorithm: " +
                    "\n1) Bubble sort" +
                    "\n2) Selection sort" +
                    "\n3) Insertion sort" +
                    "\n4) Merge sort");

            int sortOption = scanner.nextInt();

            switch (sortOption) {
                case 1:
                    //Bubble sort
                    sortingAlgorithm.bubbleSort(arr);
                case 2:
                    //Selection sort
                    sortingAlgorithm.selectionSort(arr);
                case 3:
                    //Insertion sort
                    sortingAlgorithm.interstionSort(arr);
                case 4:
                    sortingAlgorithm.mergeSort(arr, 0, arr.length - 1);
                default:
                    if(sortOption >= 4)
                        System.out.println("Invalid option");
            }

            //Print sorted array
            System.out.println("Sorted Array: ");
            sortingAlgorithm.printArray(arr);

        } catch (Exception e) {
            System.out.println("Invalid input. Please enter integers only.");
            System.out.println(e.toString());
        } finally {
            scanner.close();
        }
    }
}
