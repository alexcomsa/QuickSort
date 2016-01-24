package ro.alex.model;
/**
 * @author Alexandru Comsa
 */
import java.util.Arrays;

public class QuickSortModel {

	public QuickSortModel() {

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
		quicksort(0, number - 1);
		System.out.println(Arrays.toString(numbers));
	}

	private void quicksort(int low, int high) {
	    int i = low, j = high;
	   
	    int pivot = numbers[low + (high-low)/2];

	   
	    while (i <= j) {
	     
	      while (numbers[i] < pivot) {
	        i++;
	      }
	     
	      while (numbers[j] > pivot) {
	        j--;
	      }

	     
	      if (i <= j) {
	        exchange(i, j);
	        i++;
	        j--;
	      }
	    }
	    // Recursion
	    if (low < j)
	      quicksort(low, j);
	    if (i < high)
	      quicksort(i, high);
	  }

	  private void exchange(int i, int j) {
	    int temp = numbers[i];
	    numbers[i] = numbers[j];
	    numbers[j] = temp;
	  }
}
