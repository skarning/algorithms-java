package main;
import data.RandomArray;
import sorting.ArraySorting;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Hvilken sorteringsmetode vil du bruke?\nPress 1 for insertion-sort\nPress 2 for radixsort"+ 
				"\nPress 3 for mergesort\nPress 4 for quicksort");
		int choice = Integer.parseInt(sc.nextLine());
		System.out.println("Type the length of the array?");
		int arrayLength = Integer.parseInt(sc.nextLine());
		RandomArray randArray = new RandomArray(arrayLength);
		randArray.fillArray();
		//randArray.printArray();
		System.out.println("------------------------");
		switch(choice) {
			case(1):
				randArray.setArray(ArraySorting.insertionSort(randArray.getArray()));
				break;
			case(2):
				randArray.setArray(ArraySorting.radixSort(randArray.getArray(), 4));
				break;
			case(3):
				randArray.setArray(ArraySorting.mergeSort(randArray.getArray()));
				break;
			case(4):
				randArray.setArray(ArraySorting.quickSort(randArray.getArray()));
				break;
			default:
				System.out.println("Input is not a choice..");
				break;
		}
		sc.close();
		
		//randArray.printArray();
	}
}
