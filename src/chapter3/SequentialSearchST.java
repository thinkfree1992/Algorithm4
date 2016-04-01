package chapter3;

public class SequentialSearchST<Key, Value> {
	private int size;
	private Node first;
	
	private class Node {
		Key key;
		Value value;
		Node next;
		
		public Node(Key key, Value value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	
	public Value get(Key key) {
		for(Node i = first; i != null; i = i.next) 
			if(i.key == key)
				return i.value;
				return null;
	//	Node temp = first;
//		while(temp.key != key && temp.next != null) {
//			temp = temp.next;
//		}
//		if(temp.next == null) 
//			return null;
//		else 
//			return temp.value;
	}
	
	public void put(Key key, Value value) {
	/*	Node temp = first;
		while(temp.key != key && temp.next != null) {
			temp = temp.next;
		}
		if(temp.key == key) {          //¸Ð¾õ²»¹»ºÃ
			temp.value = value;
			return;
		}
		else {
			first = new Node(key, value, first);
			size++;
		}*/
		
		for(Node i = first; i != null; i = i.next) 
			if(i.key == key) {
				i.value = value;
				return;
			}
			first = new Node(key, value, first);
			size++;
	}
	
	public static void main(String[] args) {
		SequentialSearchST<String, Integer> ss = new SequentialSearchST<String, Integer>();
		ss.put("A", 1);
		ss.put("b", 2);
		ss.put("e", 3);
		System.out.println(ss.size);
		System.out.println(ss.get("e"));
	}
}
