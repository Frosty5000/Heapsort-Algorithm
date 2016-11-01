/*Brandell Petty
  Algorithms 4520
  October 23, 2016

       This program is designed to take an ArrayList and sort the elements
       using the Heapsort method.

       How to use: With a text file, type in the elements for the integer
        array separating them with commas. The numbers can be positve as well as
         negative, they can not be decimals. Be sure you have the correct filepath
          for the program when attempting to run the program or the program will
           throw a FileNotFoundException error.

       How the program works: Once the program accepts the file input, the program
                                then sorts the array using a HeapSort algorithm.

       Data Structure used: ArrayList
 */
package heapsort;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;

public class HeapSort {
     
  void maxHeap(ArrayList<Integer> l, int n, int i){
        int left = 2*i + 1; //Left position.
        int right = 2*i + 2; //Right position.
        int max = i; //Integer max.
       
        // If the left child is larger than the root.
       if (left < n && l.get(left) > l.get(max))
           max = left;
       // If the right child is larger than the max.
       if (right < n && l.get(right) > l.get(max))
           max = right;
       //If the max is not the root.
         if (max != i)
       {
           int swap = l.get(i);
           l.set(i, l.get(max));
           l.set(max, swap);

           // Recursively heapify the sub-tree.
           maxHeap(l, n, max);
       }
    }  
    
    public void sort(ArrayList<Integer> l){
        int n = l.size();   
        for (int i = n / 2 - 1; i >= 0; i--) //Construct the heap.
            maxHeap(l, n, i);
        
        //One at a time, take an element from the heap.
        for (int i=n-1; i>=0; i--)
       {
           // Take the root to the end.
           int temp = l.get(0);
           l.set(0, l.get(i));
           l.set(i, temp);

           // Call max heapify(maxHeap) on the reduced heap.
           maxHeap(l, i, 0);
       }
    }
    
      // A function to print list of size n.
   static void printlist(ArrayList<Integer> l)
   {
       int n = l.size();
       for (int i=0; i<n; ++i)
           System.out.print(l.get(i)+" ");
       System.out.println();
   }
    
    public static void main(String[] args) throws FileNotFoundException { //Drives the program.
       //Scanner for file input. (Change the filepath to your specifications if needed)
       Scanner scanner = new Scanner(new FileReader("C:\\Users\\brandellpetty\\Documents\\NetBeansProjects\\HeapSort\\input.txt"));       
       //Creating an Arrayist.
       ArrayList<Integer> list = new ArrayList<Integer>();
       
       String line = scanner.nextLine();
       String[] values = line.split(",");
 
       for(int i=0; i < values.length; i++) {
           list.add(Integer.valueOf(values[i]));
       }
       
       //Prints out the numbers read from the input.txt file, before sorting.
       System.out.println("The list before sorting, read from the file:");
       
       for (int i=0; i < list.size(); ++i){
           System.out.print(list.get(i));
           if(i != list.size() -1)
               System.out.print(", "); //Adds a comma and a space between the numbers
       }
       
       HeapSort heap = new HeapSort();
       heap.sort(list);
       
       //Prints out the numbers read from the input.txt file, after sorting.
       System.out.println("\nThe sorted list using Heapsort is now:");
       for(int i = 0; i < list.size(); ++i){
            System.out.print(list.get(i));
            if(i != list.size() - 1)
               System.out.print(", ");
       }
       
    }
}
