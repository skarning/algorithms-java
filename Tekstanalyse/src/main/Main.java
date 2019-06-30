package main;

import java.util.Scanner;
import input.TextInput;
import treeStructure.BinaryTree;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Text Analyzer!");
		System.out.println();
		System.out.println("Please type the path of the textfile"
				+ " you want to analyze.");
		String path = sc.nextLine();
		sc.close();
		
		boolean status = TextInput.ReadFile(path);
		if(status == false) {
			System.out.println("Something went wrong with reading the file...");
			System.exit(0);
		}
		BinaryTree mytree = new BinaryTree();
		for(String s: TextInput.cutAndFormat()) {
			mytree.insert(s);
		}
		mytree.printInOrder();
		System.out.println("System done...");
		System.exit(1);
	}
}
