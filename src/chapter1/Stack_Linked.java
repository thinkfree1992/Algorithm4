package chapter1;

public class Stack_Linked<T>{
	private Node first;
	private int size;
	
	private class Node<T>{
		T t;
		Node next;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public int size(){
		return size;
	}
	
	public void push(T t){
		Node oldfirst = first;
		first = new Node();
		first.t = t;
		first.next = oldfirst;
		size++;
	}
	
	public T pop(){
		T t = (T) first.t;
		first = first.next;
		size--;
		return t;
	}
	
	public static void main(String[] args){
		Stack_Linked<Integer> stack = new Stack_Linked<Integer>();
		stack.push(3);
		stack.pop();
		stack.push(45);
		stack.push(42);
		stack.push(323);
		stack.push(32423);
		stack.push(42423);
		for(int i = 0; i < 5; i++){
			System.out.println(stack.size + " " + stack.pop());
		}
	}
}
