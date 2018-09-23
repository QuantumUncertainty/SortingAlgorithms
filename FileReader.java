/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingalgorithms;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tucker
 */
public class FileReader {
    private FileReader(){}
    
    //fills list with words from fstein.txt
    public static ArrayList<String> newListFromFile(){
        ArrayList<String> list = new ArrayList<>();
        File file = new File("fstein.txt");
        Scanner input = new Scanner(System.in);
        
        try(Scanner reader = new Scanner(file)){
            while(reader.hasNext()){
                String word = reader.next();
                list.add(word);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return list;
    }
}
