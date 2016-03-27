package chapter2;

import edu.princeton.cs.algs4.Shell;

public class Shell_Sort2 {
	public static void sort(int[] a){
		int h = 1;
		while(h <= (a.length/3)){
			h = 6*h + 1;
		}
		while(h >=1){
			for(int i = h; i < a.length; i++){
				for(int j = i; j >= h && a[j] < a[j-h]; j -=h){
					int temp = a[j];
					a[j] = a[j-h];
					a[j-h] = temp;
				}
			}
			h = h/6;
		}
	}
	public static void show(int[] a){
		for(int c : a){
			System.out.print(c + " ");
		}
	}
	public static void main(String[] args){
		int[] a = new int[1000000];
		for(int i = 0; i <1000000; i++){
			a[i] = (int) (10000000*Math.random());
		}
		//int[] a = {12,11,43,5,3,34,26,23,455,23,424,242,243,23,34,455,33,34,43,54,8,10,15,13};
		//int[] a = {592,401,874,141,348,72,911,887,820,283};
		double start = System.currentTimeMillis();
		sort(a);
		show(a);
		System.out.println();
		System.out.println(System.currentTimeMillis() - start);
	}
}
