/**
 * Simple sorting algorithms and their performance 
 * Reg: E/18/397
 */

public class Sort {

    //create an array of given size and populate it with random data  
    static int [] create_rand_data(int size_of_array) {
	int [] data = new int[size_of_array];
	int i; 
	for(i=0; i < data.length; i++)
	    data[i] = (int)(Math.random() * 100);
	return data; 
    }

    //create an array of given size and populate it with worst data arrangement 
    static int [] create_worst_data(int size_of_array) {
	int [] data = new int[size_of_array];
	int i; 
	for(i=0; i < data.length; i++)
	    data[i] = data.length - i;
	return data; 
    }

    //create an array of given size and populate it with best data arrangement 
    static int [] create_best_data(int size_of_array) {
	int [] data = new int[size_of_array];
	int i; 
	for(i=0; i < data.length; i++)
	    data[i] = i;
	return data; 
    }

    // function to swap. Would be useful since all need this 
    static void swap(int []d, int i, int j) { 
	int tmp = d[i]; 
	d[i] = d[j]; 
	d[j] = tmp;
    }

    // check if the sorting worked on the array 
    static boolean isSorted(int [] data) {
	int i;
	for(i=1; i < data.length; i++)
	    if(data[i] < data[i-1]) break;
	return (i == data.length);
    }

    // If you want just display the array as well :) 
    static void display(int []data) { 
	System.out.println("=======");
	for(int i=0; i < data.length; i++) 
	    System.out.print(data[i] + "  "); 
	System.out.println("\n=======");
    }

    
    /**********************************************************
     *     Implementation of sorting algorithms               *
     *********************************************************/


	// Bubble sort
    static void buble_sort(int [] data)  {
		boolean quit = false;
		for (int i = 0; i< data.length && !quit; i++){
			quit = true;
			for(int j = data.length-1; j>i; j--){
				if(data[j] < data[j-1]){
					swap(data, j, j-1);
					quit = false;
				}
			}
		}
	
    }

	// selection sort
    static void selection_sort(int [] data) {
		for (int i=0; i<data.length-1; i++){
			int min = i;
			for (int j=i+1; j<data.length; j++){
				if(data[j]<data[min]){
					min = j;
				}
			}
			swap(data, i, min);
		}
	
    }

	// insertion sort
    static void insertion_sort(int [] data) {
	for(int i =1; i< data.length; i++){
		int val = data[i];
		int j =i -1;
		while(j>=0 && data[j]>val){
			data[j+1]=data[j];
			j = j- 1;
		}
		data[j+1] = val;
	}
    }

		       
		
    
    
    

    public static void main(String [] args) {

		// varibles for testing
		long start, end;
		
		int[] data, saveddata1,saveddata2;
		int arrayLength[] = {25,250,2500,25000,250000};


		// loop for testing
		for(int i =0; i< arrayLength.length; i++){

		

		System.out.println("Sorting Times for random array of size " + arrayLength[i]);

		//random array set
		data = create_rand_data(arrayLength[i]);
		saveddata1 = data;
		saveddata2 = data;


		
		
		// bubble sort
		start = System.nanoTime();
		buble_sort(data);
		end = System.nanoTime();
		if(isSorted(data)){
			System.out.println("Bubble Sort time = " + (end - start));
		}
		
		data = create_rand_data(arrayLength[i]);
		
		// selection sort
		start = System.nanoTime();
		selection_sort(saveddata1);
		end = System.nanoTime();
		if(isSorted(saveddata1)){
			System.out.println("Selection Sort time = " + (end - start));
		}

		data = create_rand_data(arrayLength[i]);
		
		
		start = System.nanoTime();
		insertion_sort(saveddata2);
		end = System.nanoTime();
		if(isSorted(saveddata2)){
			System.out.println("Insertion Sort time = " + (end - start));
		}




		System.out.println("Sorting Times for bestcase array of size " + arrayLength[i]);

		//best case array test
		data = create_best_data(arrayLength[i]);
		
		
		// bubble sort
		start = System.nanoTime();
		buble_sort(data);
		end = System.nanoTime();
		if(isSorted(data)){
			System.out.println("Bubble Sort time = " + (end - start));
		}
		
		data = create_best_data(arrayLength[i]);
		
		// selection sort
		start = System.nanoTime();
		selection_sort(data);
		end = System.nanoTime();
		if(isSorted(data)){
			System.out.println("Selection Sort time = " + (end - start));
		}

		data = create_best_data(arrayLength[i]);
		
		
		start = System.nanoTime();
		insertion_sort(data);
		end = System.nanoTime();
		if(isSorted(data)){
			System.out.println("Insertion Sort time = " + (end - start));
		}





		System.out.println("Sorting Times for worst case array of size " + arrayLength[i]);

		//worst case array test
		data = create_worst_data(arrayLength[i]);
		
		
		// bubble sort
		start = System.nanoTime();
		buble_sort(data);
		end = System.nanoTime();
		if(isSorted(data)){
			System.out.println("Bubble Sort time = " + (end - start));
		}
		
		data = create_worst_data(arrayLength[i]);
		
		// selection sort
		start = System.nanoTime();
		selection_sort(data);
		end = System.nanoTime();
		if(isSorted(data)){
			System.out.println("Selection Sort time = " + (end - start));
		}

		data = create_worst_data(arrayLength[i]);
		
		
		start = System.nanoTime();
		insertion_sort(data);
		end = System.nanoTime();
		if(isSorted(data)){
			System.out.println("Insertion Sort time = " + (end - start));
		}

	}
		
	// create arrays of different size populate with data
	// measure the time taken by different algorithms to
	// sort the array.
	// Think about effects of caches, other apps running etc. 
    }
}