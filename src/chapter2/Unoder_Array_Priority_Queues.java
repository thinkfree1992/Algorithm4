package chapter2;

public class Unoder_Array_Priority_Queues<T extends Comparable<T>> {
	private T[] arr;
	private int size;
	private int	index;
	
	public Unoder_Array_Priority_Queues(int capacity) {
		arr = (T[])new Comparable[capacity];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	public void Insert(T t) {
		arr[size++] = t;
//		if(max.compareTo(t) < 0) {
//			max = t;
//			index = size;
//		}
	}	 
	
	public T delMax() {
		T max = arr[0];
		for(int i = 1; i < size; i++) {
			if(max.compareTo(arr[i]) < 0) {
				max = arr[i];
				index = i;
			}
		}
		exchange(arr, size-1, index);
		return arr[--size];
	}
	
	public T max() {
		T max = arr[0];
		for(int i = 1; i < size; i++) {
			if(max.compareTo(arr[i]) < 0) {
				max = arr[i];
			}
		}
		return max;
	}
	
	public void exchange(T[] arr, int min , int max) {
		T temp = arr[min];
		arr[min] = arr[max];
		arr[max] = temp;
	}
	
	public static void main(String[] args) {
		Unoder_Array_Priority_Queues<Integer> uapq = new Unoder_Array_Priority_Queues<Integer>(5);
		uapq.Insert(1);
		uapq.Insert(2);
		uapq.Insert(3);
		//uapq.delMax();
		System.out.println(uapq.delMax());
		System.out.println(uapq.max());
	}
}
