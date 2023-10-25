package project0;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordArray {
    
	private static final int CAPACITY = 10000;
	
	static void wordSort(String[] array, int num) {
		for (int index = 0; index < num-1; index++) {
			//find min element
			int minIndex = index;
			for (int jIdx = index + 1; jIdx < num; jIdx++)
				if(array[jIdx].compareTo(array[minIndex])<0)
					minIndex = jIdx;
			
			//trade the min element with the first in temporary container
			String temp_arr = array[minIndex];
			array[minIndex] = array[index];
			array[index] = temp_arr;
		}
	}
    static int binarySearch(String[] array, int num, String target) {
        int left = 0, right = num - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int res = target.compareTo(array[mid]);
            // check for target at mid
            if (res == 0)
                return mid;
            // if target greater, ignore left half
            if (res > 0)
                left = mid + 1;
            // if target smaller, ignore right half
            else
                right = mid - 1;
        }
		return -1;
    }
	
	public static void main(String[] args) {
        String[] words = new String[CAPACITY];
        int count = 0; 
        //read in words from file
        try (Scanner sc = new Scanner(new File("text.txt"))){
        	while (sc.hasNext() && count < CAPACITY) {
        		words[count++] = sc.next();
        	}
        } catch (FileNotFoundException e) {
        	e.printStackTrace();
        }
        
        System.out.println("Original array:");
        for (int i = 0; i < count; i++)
            System.out.print(words[i] + " ");
        System.out.println();

        // sorting using selection sort
        wordSort(words, count);
        System.out.println("");
        System.out.println("");
        System.out.println("Sorted array:");
        for (int i = 0; i < count; i++) {
            System.out.print(words[i] + " ");
        	if ((i + 1) % 8 ==0) {
        		System.out.println();
        	}
        }
        
        //cli for search
        try (Scanner inputScan = new Scanner(System.in)){
        	while(true) {
        		System.out.println("Enter word to search for it, or enter 0 to exit:");
        		String search = inputScan.next();
                if (search.equals("0")) {
                    System.out.println("Exiting...");
                    break;
                }
                int index = binarySearch(words, count, search);
                if (index != -1)
                	System.out.println("Word found at index: " + index);
                else
                	System.out.println("Word not found.");
                }
        	}
        }
	
}
