import java.util.Arrays;
import java.util.LinkedList;



public class LinkedHashTable {

    private  LinkedList<Element> [] linkedElementList; //creating a linked list
    private int capacity;       //size of the hash table
    private int currentSize;    //current size of the hash table

    public LinkedHashTable(int capacity){ // constructor
        this.capacity=capacity;
        this.currentSize=0;

        linkedElementList=new LinkedList[capacity];
        for(int index=0;index<capacity;index++){
            linkedElementList[index]=new LinkedList<Element>();
        }
    }

    //function to return the hash value
    private int hash(int key){

        return key % capacity;
    }

    //function to insert a value to the hash table
    public void insert(int key,String value){


        Element ElementToInsert=new Element(key, value);  //create a new Element

        int h=hash(key); //evaluate the hash function

        LinkedList<Element> column=linkedElementList[h];  //get the corresponding column of the hash table

        //handle duplicate Element
        for(Element Element:column){

            //check whether the Element is already in the table or not
            if(Element.getKey()==key){
                return ; //return from the function if the Element is already in the table
            }

        }

        column.add(ElementToInsert);  //add Element to the table 
        currentSize=currentSize+1; //increment the current size by 1

    }

    // function to get a value for the given key
    public String get(int key){

        int h=hash(key);  //evaluate the hash value

        LinkedList<Element> column=linkedElementList[h]; //get the corresponding column

        //loop through the each Element of the column
        for(Element Element:column){

            if(Element.getKey()==key){ //find the corresponding key from the table
                return Element.getValue();  //return the value
            }

        }

        return null; //return null if the given key is not in the table
    }

    
    //a function to remove an item 
    public void remove(int key){

        if(get(key)==null){ //return from the function if the key is not in the table
            return;
        }

        int h=hash(key); //evaluating the hash value

        LinkedList<Element> column=linkedElementList[h]; //get the corresponding column

        //loop through the each Element of the column
        for(Element Element:column){

            if(Element.getKey()==key){
                column.remove(Element); //remove the corresponding Element from the table
            }

        }

    }

    //function to check whether the table is empty or not
    public boolean isEmpty(){
        return currentSize==0;
    }

    //function to get the current size of the table
    public int getCurrentSize(){
        return this.currentSize;
    }

    //function to clear all the data in the hash table
    public void clear(){

        this.currentSize=0;  //assign 0 to the current size
        linkedElementList=new LinkedList[capacity]; //create a new linked list

        for(int index=0;index<capacity;index++){
            linkedElementList[index]=new LinkedList<Element>(); //create empty entries
        }

    }

    //function to print the hash table
    public void printList(){

        //loop through the each column of the table
        Arrays.stream(linkedElementList).forEach(column ->{

            if(column!=null){
                //loop through the each row of the table
                column.forEach(row->{

                    if(row!=null){ //print the each Element of the table
                        System.out.println("key : " + row.getKey() + " value : " + row.getValue());
                    }
                }
                    
                );
            }

        }
        );
    }
  
}