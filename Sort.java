package sortingalgorithms;

import java.util.ArrayList;

public class Sort{
    
    /* selectionSort: performs selection sort on a given ArrayList
     * preconditions: NA
     * postconditions: if the element at index i is > the index at i + 1, the two
     *                 elements are swapped. This occcurs until the condition is false.
    */
    public static ArrayList<Double> selectionSort(ArrayList<Double> list){
        for(int i = 0; i < list.size(); i++){
            for(int j = i + 1; j < list.size(); j++){
                if(list.get(i) > list.get(j)){
                    swap(list, i, j);
                }
            }
        }
        
        return list;
    }
    
    /* bubbleSort: performs bubble sort on a given ArrayList
     * preconditions: NA
     * postconditions: two iterators start on opposite ends of the array. The jth
     *                 iterator traverses down, and if the jth element is < j - 1
     *                 element, those elements are swapped, effectively bubbling
     *                 the smaller elements to the front of the array. Halts once
     *                 the outer loop terminates.
    */
    public static ArrayList<Double> bubbleSort(ArrayList<Double> list){
        for(int i = 0; i < list.size(); i++){
            for(int j = list.size() - 1; j >= i + 1; j--){
                if(list.get(j) < list.get(j - 1)){
                    swap(list, j, j-1);
                }
            }
        }
        
        return list;
    }
    
    /* insertionSort: performs insertion sort on a given ArrayList
     * preconditions: NA
     * postconditions: inserts the smaller element of the comparison into the list on each iteration
     *                 until the sublist is sorted. The outer loop terminates once the list has been 
     *                 traversed.                 
    */
    public static ArrayList<Double> insertionSort(ArrayList<Double> list){
        int i = 1;
        while(i < list.size()){
            int j = i;
            while(j > 0 && list.get(j - 1) > list.get(j)){
                swap(list, j, j-1);
                j--;
            }
            i++;
        }
        
        return list;
    }
   
    /*insertionSortForStrings: see insertionSort. The difference here is that Strings
    * are handled and repeating elements are removed.        
    */
    public static ArrayList<String> stringInsertionSort(ArrayList<String> list){
        int i = 1;
        while(i < list.size()){
            int j = i;
            while(j > 0 && list.get(j - 1).compareTo(list.get(j)) > 0){
                swapForStrings(list, j, j-1);
                if(list.get(j - 1).equals(list.get(j)))
                    list.remove(j - 1); //may give errors
                j--;
            }
            i++;
        }
        
        return list;
    }
    
    /*
     * mergeSort: performs mergeSort on a given ArrayList. Method is generic to handle
                  doubles and strings.
     * preconditions: if list <= 1, the list is returned, as it is already sorted.
     * postconditions: recursively sorts two sublists, left and right, until they are down to the
                       base case. Each sublist is then sorted, and is passed into merge for merging.
    */
    public static <E extends Comparable> ArrayList<E> mergeSort(ArrayList<E> list){
        if(list.size() <= 1){
            return list;
        }
        
        ArrayList<E> left = new ArrayList<>();
        ArrayList<E> right = new ArrayList<>();
        int midpoint = list.size() / 2;
        
        for(int i = 0; i < midpoint; i++){           
            left.add(list.get(i));              
        }
        
        for(int i = midpoint; i < list.size(); i++){          
            right.add(list.get(i));            
        }
        
        left = mergeSort(left);
        right = mergeSort(right);
        
        return merge(left, right);       
    }
       
    //swap: swaps 2 list elements when called
    private static void swap(ArrayList<Double> list, int i, int j){
        double temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
    
    //swap for strings
    private static void swapForStrings(ArrayList<String> list, int i, int j){
        String temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
    
    /*
     * description: merges two sublists into one
     * preconditions: 2 sublists are passed in
     * postconditions: while the sublits are nonempty, the list elements are appended
                       to the final list. Final merged list is returned after.
    */
    private static <E extends Comparable<E>> ArrayList<E> merge(ArrayList<E> left, ArrayList<E> right){       
        ArrayList<E> finalList = new ArrayList<>();
        
        //appends the smaller element between the right and left lists to the final list until each are empty
        while(!left.isEmpty() && !right.isEmpty()){
            if(left.get(0).compareTo(right.get(0)) <= 0){
                finalList.add(left.remove(0));
            }
            else{
                finalList.add(right.remove(0));
            }
        }
        
        //if there are any elements left, repeat the same process until they are empty
        while(!left.isEmpty()){
            finalList.add(left.remove(0));           
        }
        
        while(!right.isEmpty()){
            finalList.add(right.remove(0));
        }
        
        return finalList;
    }    
}
