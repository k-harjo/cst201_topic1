package dq2;

public class SelectionSort {

    public static void selectionSort(int[] arr) { 
        for(int i = 0; i < arr.length-1; i++) {
            // Assume the min is the first element
            int minIndex = i;
            int minValue = arr[i];
    
            // Test against elements after i to find the smallest
            for(int j = i + 1; j < arr.length; j++) {
                // If this element is less, then it is the new minimum
                if(arr[j] < minValue) {
                    // Found new minimum; remember its index and value
                    minIndex = j;
                    minValue = arr[j];
                }
            }
            // Swap it with the minimum value in the unsorted part
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] testArray = {64, 25, 12, 22, 11};
        
        System.out.println("Original Array:");
        for(int value : testArray) {
            System.out.print(value + " ");
        }
        System.out.println();
        
        selectionSort(testArray);
        
        System.out.println("Sorted Array:");
        for(int value : testArray) {
            System.out.print(value + " ");
        }
    }
}
