/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingalgorithms;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Tucker
 */
public class GenerateList {
    private GenerateList(){}
    
    //generates a list of specified size with random doubles between 0 and 1000
    public static ArrayList<Double> newList(int size){
        ArrayList<Double> list = new ArrayList<>();
        
        for(int i = 0; i < size; i++){
            list.add(ThreadLocalRandom.current().nextDouble(0, 1001));
        }
        
        return list;
    }
    
}
