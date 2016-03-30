package chapter2;

public class Oder_Array_Priority_Queues<T extends Comparable<T>> {
	private T[] arr;
	private int size;
	
	public Oder_Array_Priority_Queues(int capacity) {
		arr = (T[])new Comparable[capacity];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	public void insert(T t) {
		if(size == 0) {
			arr[size++] = t;
		}
		else {
			int j = size - 1;
			while(j >= 0 && arr[j].compareTo(t) > 0) {
					arr[++j] = arr[j];
					j--;
				}
				arr[++j] = t;
				size++;
			}
	}
	
	public T delMax() {
		T t = arr[--size];
		return t;
	}
	
	public  T max() {
		int temp = size;
		return arr[--temp];
	}
	
	public static void main(String[] args) {
		Oder_Array_Priority_Queues<Integer> oapq = new Oder_Array_Priority_Queues<Integer>(5);
		oapq.insert(1);
		oapq.insert(2);
		oapq.insert(3);
		oapq.insert(4);
		oapq.insert(5);
		System.out.println(oapq.delMax());
		System.out.println(oapq.max());
	}
}
