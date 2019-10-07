package com.alvi.datastructure;

/**
 * Array Rotaion API (Integer Type). <br>
 * Left and Right both rotation added.
 * 
 * @author tanmoy.tushar
 * @since 2019-10-07
 */
public abstract class Rotation {
	
	/* Declaring default array, you can change it by method overriding */
	protected int[] getArray() {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 }; 
		return arr;
	}
	
	/**
	 * Method for Left Rotation. <br>
	 * Parameter arr stand for an array and parameter t stand for how many position you want to rotate left.
	 * @param arr
	 * @param t
	 */
	public void leftRotate(int[] arr, int t) {
		for (int i = 0; i < t; i++) {
			leftRotateByOne(arr);
		}		
	}
	
	/**
	 * Left rotation of array one by one. <br>
	 * This method rotated array one left each call.
	 * So, if you want to rotate n times then call this method n times.
	 * 
	 * @param arr
	 */
	private void leftRotateByOne(int[] arr) {
		int i, temp;
		temp = arr[0];
		for (i = 0; i < arr.length - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[i] = temp;
	}
	
	/**
	 * Method for Right Rotation. <br>
	 * Parameter arr stand for an array and parameter t stand for how many position you want to rotate left.
	 * @param arr
	 * @param t
	 */
	public void rightRotate(int[] arr, int t) {
		for (int i = 0; i < t; i++) {
			rightRotateByOne(arr);
		}		
	}
	
	/**
	 * Right rotation of array one by one. <br>
	 * This method rotated array one right each call.
	 * So, if you want to rotate n times then call this method n times.
	 * 
	 * @param arr
	 */
	private void rightRotateByOne(int[] arr) {
		int i, temp;
		temp = arr[arr.length - 1];
		for (i = arr.length - 1; i > 0 ; i--) {
			arr[i] = arr[i - 1];
		}
		arr[i] = temp;
	}
	
	/**
	 * Method for printing array elements
	 *   
	 * @param arr
	 */
	public void print(int arr[]) { 
        for (int i : arr) {
			System.out.print(i + " ");
		} 
        System.out.println("");
    }
}
