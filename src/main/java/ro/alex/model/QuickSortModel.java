package ro.alex.model;

import java.util.Arrays;

public class QuickSortModel {
	
	public QuickSortModel(){
		
	}
	private int[] numbers;
	private int number;
	
	public int[] getNumbers() {
		return numbers;
	}
	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public void sort() {
		System.out.println(Arrays.toString(numbers));
		
	}
	

}
