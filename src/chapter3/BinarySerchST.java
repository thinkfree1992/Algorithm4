package chapter3;

//import edu.princeton.cs.algs4.BinarySearchST;

public class BinarySerchST <Key extends Comparable<Key>, Value>{
	private Key[] key;
	private Value[] value;
	private int size;
	
	public BinarySerchST(int capacity) {
		key = (Key[]) new Comparable[capacity];
		value = (Value[]) new Object[capacity];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	public int rank(Key key) {
		int head = 0;
		int tail = size - 1;
		while(head <= tail) {
			int mid = (head + tail) >> 1;
			if(this.key[mid].compareTo(key) < 0)
				tail = mid - 1;
			else if(this.key[mid].compareTo(key) > 0)
				head = mid + 1;
			else 
				return mid;
		}
		return head;
	}
	
	public void put(Key key, Value value) {
		int i = rank(key);
		if(i < size && this.key[i].compareTo(key) == 0) {
			this.value[i] = value;
		}
		for(int j = size; j > i; j--){
			this.key[j] = this.key[j - 1];
			this.value[j] = this.value[j - 1];
		}
		this.key[i] = key;
		this.value[i] = value;
		size++;
	}
	
	public Value get(Key key) {
		int i = rank(key);
		if(i < size && this.key[i].compareTo(key) == 0)
			return this.value[i];
		else
			return null;
	}
	
	public static void main(String[] args) {
		BinarySerchST<Integer, Integer> bs = new BinarySerchST<Integer, Integer>(5);
		bs.put(1, 1);
		bs.put(3, 3);
		bs.put(2, 2);
		bs.put(4, 4);
		System.out.println(bs.get(1));
		System.out.println(bs.get(3));
		System.out.println((int)bs.key[1]);
	}
}
