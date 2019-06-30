package sorting;
import tools.CircularArrayQueue;
import tools.EmptyCollectionException;
import tools.QueueADT;

public class ArraySorting {
	//Sorts the array with insertion-sort algorithm
	public static int[] insertionSort(int[] array) {
		float starttime = System.nanoTime();
		for(int i = 0; i < array.length; i++) {
			int countBuffer = i;
			while((i - 1) >= 0) {
				//Checking if the value left of the current value is larger
				if(array[i] < (array[i - 1])) {
					//Switching places of the two compared values in the array
					int buff1, buff2;
					buff1 = array[i];
					buff2 = array[i - 1];
					array[i - 1] = buff1;
					array[i] = buff2;
					i--;
				}
				else {
					break;
				}
			}
			i = countBuffer;
		}
		float timeElapsed = System.nanoTime() - starttime;
		System.out.println("Time elapsed(ns): " + timeElapsed);
		System.out.println("Constant C is " + timeElapsed / Math.pow(array.length, 2));
		return array;
	}
	
	public static int[] quickSort(int[] array) {
		float starttime = System.nanoTime();
		quickSort(array, 0, array.length - 1);
		float timeElapsed = (System.nanoTime() - starttime);
		System.out.println("Time elapsed(ns): " + timeElapsed);
		System.out.println("Constant C is " + timeElapsed / (array.length * Math.log(array.length)));
		return array;
	}
	
	//Sorts the array with quick-sort algorithm
	private static int[] quickSort(int[] array, int min, int max) {
		if(min < max) {
			 int partitionIndex = partition(array, min, max);
			 quickSort(array, min, partitionIndex - 1);
			 quickSort(array, partitionIndex + 1, max);
		}
		return array;
	}
	
	public static int partition(int[] array, int first, int last) {
		int left, right;
		int partitionIndex;
		partitionIndex = array[first];
		left = first;
		right = last;
		while (left < right)
		{
		    while (array[left] <= partitionIndex && left < right)
			left++;
		    while (array[right] > partitionIndex)
			right--;
		    if (left < right)
		    {
		    	swap(array, left, right);
		    }
		}
		swap(array, first, right);
		return right;
	}
	
	private static void swap(int[] array, int element1, int element2) {
		int buff1 = array[element1];
		int buff2 = array[element2];
		array[element1] = buff2;
		array[element2] = buff1;
	}
	
	public static int[] mergeSort(int[] array) {
		float starttime = System.nanoTime();
		int first = 0;
		int last = array.length - 1;
		mergeSort(array, first, last);
		float timeElapsed = System.nanoTime() - starttime;
		System.out.println("Time elapsed(ns): " + timeElapsed);
		System.out.println("Constant C is " + timeElapsed / array.length * Math.log(array.length));
		return array;
	}
	
	private static void mergeSort(int[] array, int first, int last) {
		if(first == last)
			return;
		else {
			int partitionIndex = (first + last) / 2;
			mergeSort(array, first, partitionIndex);
			mergeSort(array, partitionIndex + 1, last);
			merge(array, first, partitionIndex, last);
		}
	}
	
	private static void merge(int[] array, int first, int middle, int last) {
		int size = (last - first + 1);
		int[] bufferArray = new int[size];
		for(int i = 0; i < size; i++) {
			bufferArray[i] = array[first + i];
		}
		int left, right;
		left = 0;
		right = middle - first + 1;
		for(int i = 0; i < size; i++) {
			if(right <= last - first)
				if(left <= middle- first)
					if(bufferArray[left] > bufferArray[right])
						array[i + first] = bufferArray[right++];
					else
						array[i + first] = bufferArray[left++];
				else
					array[i + first] = bufferArray[right++];
			else
				array[i + first] = bufferArray[left++];
		}
	}
	
	public static int[] radixSort(int[] array, int max) {
		float starttime = System.nanoTime();
		int ti_i_m = 1;
		int n = array.length;
		CircularArrayQueue<Integer>[] queue;
		queue = (CircularArrayQueue<Integer>[])(new CircularArrayQueue[10]);
		for (int i = 0; i < 10; i++)
		    queue[i] = new CircularArrayQueue<Integer>(); 
		for (int m = 0; m < max; m++)
		{
		    for (int i = 0; i < n; i++)
		    {
			int number = (array[i] / ti_i_m) % 10;
			queue[number].enqueue(new Integer(array[i]));
		    }
		    int j = 0;
		    for (int i = 0; i < 10; i++)
			while (!queue[i].isEmpty())
			    array[j++] = (int) queue[i].dequeue();
		    ti_i_m *= 10;
		}
		float timeElapsed = System.nanoTime() - starttime;
		System.out.println("Time elapsed(ns): " + timeElapsed);
		System.out.println("Constant C is " + timeElapsed / array.length);
		return array;
	}
}
