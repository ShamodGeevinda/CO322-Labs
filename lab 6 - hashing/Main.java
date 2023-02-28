public class Main {
    public static void main(String [] args){

        //  Task 1 
       
        System.out.println("Tak1: Double hashing - hash table");
         System.out.println("");

        HashTable hashtable=new HashTable(11); //creating a new hash table, capacity=13

        hashtable.insert(20, "value 20");  //insert some entries to hash table
        hashtable.insert(34, "value 34"); 
        hashtable.insert(45, "value 45");
        hashtable.insert(70, "value 70"); 
        hashtable.insert(56, "value 56"); 
  
        System.out.println("Hash Table after adding 20, 34, 45, 70, 56");
        hashtable.printList(); //print the hash table
        System.out.println("");

        hashtable.remove(45); //remove 10 from the hash table
        System.out.println("Hash table after removing 45");
        hashtable.printList(); //print the hash table

        System.out.println("");
        System.out.println("getting values from hashtable and not in hashtable");
        System.out.println(hashtable.get(34));
        System.out.println(hashtable.get(610));
        System.out.println("");
        System.out.println("");
        System.out.println("");




        // Task 2
        System.out.println("Task2: Hash table that uses separate chaining(using linked list)");
        System.out.println("");


        LinkedHashTable linkedHashTable=new LinkedHashTable(13); //number of slots = 13

        linkedHashTable.insert(1,"value 1"); //insert some values
        linkedHashTable.insert(2,"value 2");
        linkedHashTable.insert(3,"value 3");
        linkedHashTable.insert(5,"value 5");
        linkedHashTable.insert(10,"value 10");
        linkedHashTable.insert(14,"value 14");
        linkedHashTable.insert(28,"value 28");
        linkedHashTable.insert(96,"value 96");
        linkedHashTable.insert(559,"value 559");

        System.out.println("Linked hash table after adding 1, 2, 3, 5, 10, 14, 28, 96, 559");
        linkedHashTable.printList();
        System.out.println("");

        linkedHashTable.remove(5); //remove value 5
        
         System.out.println("Linked hash table after removing 5");
        linkedHashTable.printList(); //print the hash table
        System.out.println("");
        
         System.out.println("getting values from linkedhashtable and not in linkedhashtable");
        System.out.println(linkedHashTable.get(559));
        System.out.println(linkedHashTable.get(610));

    }
}
