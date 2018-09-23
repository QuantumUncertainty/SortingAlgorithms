//Tucker Bullara
//C00149016
//CMPS 261
//Program Description: implementations of various sorting methods
/*
    Certificate of Authenticity: I certify that the code in the method functions
    including method function main of this project are
    entirely my own work.
*/
package sortingalgorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class P3_C00149016 {

    public static void main(String[] args) {              
        //caution: this will likely take a while to run 
               
        ArrayList<Double> list = GenerateList.newList(100000);
        printDoubleSortTable(list);       
                                
        ArrayList<String> wordsForMerge = FileReader.newListFromFile();        
        handleFileMergeSort(wordsForMerge);
        
        ArrayList<String> wordsForInsertion = FileReader.newListFromFile();
        handleFileInsertionSort(wordsForInsertion);
                
    }
    
    /*
    description: Bottom 2 methods get the approximate execution time for the string sorts.
                 Then, the time is printed along with the number of unique words.
    */
    public static void handleFileMergeSort(ArrayList<String> list){
        long start = System.currentTimeMillis();
        ArrayList<String> sortedList = Sort.mergeSort(list);
        long end = System.currentTimeMillis();
        long time = end - start;
        
        Set<String> nonDuplicateList = new HashSet<>(); //sets do not have duplicates
        
        //adding list elements to a set; only adds unique values
        for(int i = 0; i < sortedList.size(); i++){
            nonDuplicateList.add(list.get(i));
        }
        
        //sort is not retained, so re sort.
        sortedList = Sort.mergeSort(toArrayList(nonDuplicateList));      
               
        System.out.println("Execution time for MergeSort for file: " + time + "ms");
        System.out.println("Number of words after MergeSort: " + sortedList.size());  
        System.out.println();
    }
    
    public static void handleFileInsertionSort(ArrayList<String> list){
        long start = System.currentTimeMillis();
        ArrayList<String> sortedList = Sort.stringInsertionSort(list);
        long end = System.currentTimeMillis();
        long time = end - start;
        
        Set<String> nonDuplicateList = new HashSet<>(); //sets do not have duplicates
        
        //adding list elements to a set; only adds unique values
        for(int i = 0; i < sortedList.size(); i++){
            nonDuplicateList.add(list.get(i));
        }
        
        //sort is not retained, so re sort.
        sortedList = Sort.stringInsertionSort(toArrayList(nonDuplicateList));
        
        System.out.println("Execution time for InsertionSort for file: " + time + "ms");
        System.out.println("Number of words after InsertionSort: " + sortedList.size()); 
    }
    
    //description: prints times from each respective sort time calculation
    public static void printDoubleSortTable(ArrayList<Double> list){        
        int items = list.size(); 
        
        System.out.println("For list of size " + items + ": ");
        System.out.println("Selection: " + getSelectionTime(list) + "ms");
        System.out.println("Bubble: " + getBubbleTime(list) + "ms");
        System.out.println("Insertion: " + getInsertionTime(list) + "ms");
        System.out.println("Merge: " + getMergeTime(list) + "ms"); 
        
        System.out.println("-------------------------");
    }
    
    /*
     * next 4 methods use System.getCurrentTimeMillis to get ex. time for each sort.
     * a deep copy is made before sorting, so that a sorted list is not sorted again.
    */
    public static long getSelectionTime(ArrayList<Double> list){
        long start, end, time;
        ArrayList<Double> copy = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            copy.add(list.get(i));
        }
        
        start = System.currentTimeMillis();
        Sort.selectionSort(copy);
        end = System.currentTimeMillis();
        time = end - start;                
        
        return time;                      
    }
    
    public static long getBubbleTime(ArrayList<Double> list){
        long start, end, time;
        ArrayList<Double> copy = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            copy.add(list.get(i));
        }
        
        start = System.currentTimeMillis();
        Sort.bubbleSort(copy);
        end = System.currentTimeMillis();
        time = end - start;                
        
        return time;                      
    }
    
    public static long getInsertionTime(ArrayList<Double> list){
        long start, end, time;
        ArrayList<Double> copy = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            copy.add(list.get(i));
        }
        
        start = System.currentTimeMillis();
        Sort.insertionSort(copy);
        end = System.currentTimeMillis();
        time = end - start;                
        
        return time;                      
    }
    
    public static long getMergeTime(ArrayList<Double> list){
        long start, end, time;
        ArrayList<Double> copy = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            copy.add(list.get(i));
        }
        
        start = System.currentTimeMillis();
        Sort.mergeSort(copy);
        end = System.currentTimeMillis();
        time = end - start;                
        
        return time;                      
    }
    
    //prints standard ArrayList; used for testing
    public static void printList(ArrayList list){
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
        
        System.out.println();
    }
    
    //iterates through the set and prints each value; used for testing
    public static void printSet(Set s){
        Iterator i = s.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
    }
    
    //converts set to ArrayList
    public static ArrayList<String> toArrayList(Set s){
        ArrayList<String> list = new ArrayList<>(s);     
        return list;
    }
      
}
