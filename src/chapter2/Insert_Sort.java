package chapter2;

public class Insert_Sort {
	public static void sort(int[] a, int start, int end){
		for(int i = start + 1; i < end+1; i++) {
			int key = a[i];
			int j = i - 1;
			while(j >= 0 && a[j] > key){
				a[j+1] = a[j];
				j = j - 1;
			}
			a[j+1] = key;
		}
	}
	public static void show(int[] a){
		for(int c : a){
			System.out.print(c + " ");
		}
	}
	public static void main(String[] args){
//		int[] a = new int[1000000];
//		for(int i = 0; i < 1000000; i++){
//			a[i] = (int) (10000000*Math.random());
//		}
		int[] a = {12,11,43,5,3,34,26,23,455,23,424,242,243,23,34,455,33,34,43,54,8,10,15,13};
		double start = System.currentTimeMillis();
		show(a);
		System.out.println();
		System.out.println(System.currentTimeMillis() - start);
	}
}
