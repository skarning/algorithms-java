package data;
import java.util.Random;

public class RandomArray {

	private int[] array;
	private int length;
	
	public RandomArray(int length){
		this.length = length;
		array = new int[length];
	}
	
	//Fills the array with random number
	public void fillArray() {
		Random rand = new Random();
		for(int i = 0; i < length; i++) {
			int randomNumber = rand.nextInt(2 * length) + 0;
			array[i] = randomNumber;
		}
	}
	
	//Returns the random generated array
	public int[] getArray() {
		return array;
	}
	
	//Truncates the array
	public void truncate() {
		array = new int[length];
	}
	
	//Sets the array
	public void setArray(int[] array) {
		this.array = array;
	}
	
	//Prints the array
	public void printArray() {
		for(int i = 0; i < array.length; i++) {
			System.out.println("[" + array[i] + "]");
		}
	}
}