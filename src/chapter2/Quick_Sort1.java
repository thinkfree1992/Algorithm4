package chapter2;

import java.util.Arrays;

public class Quick_Sort1 {
	public static void sort(int[] arr, int start, int end){
//		if(end - start < 13){
//			Insert_Sort.sort(arr, start, end);
//			return;
//		}
		if(end <= start)
			return;
		int lt = start;
		int i = start + 1;
		int gt = end;
		int mid  = (start + end) >> 1;
		int key = selectPivot(arr, start, mid, end);
		
		while(i <= gt){
			if(arr[i] < key)
				exchange(arr, i++, lt++);
			else if(arr[i] > key)
				exchange(arr, gt-- , i);
			else 
				i++;
		}
		sort(arr, start, lt -1);
		sort(arr, gt + 1, end);
	}
	
	public static void exchange(int[] arr, int min, int max){
		int temp = arr[min];
		arr[min] = arr[max];
		arr[max] = temp;
	}
	
	public static int selectPivot(int[] arr, int start,int mid, int end){
		if(arr[mid] > arr[end])
			exchange(arr, end, mid);
		if(arr[start] > arr[end])
			exchange(arr, end, start);
		if(arr[mid] > arr[start])
			exchange(arr, start, mid);
		return arr[start];
	}
	
	public static void show(int[] a){
		for(int c : a){
			System.out.print(c + " ");
		}
	}
	public static void main(String[] args){
		int[] a = new int[10000000];
		for(int i = 0; i <10000000; i++){
			//a[i] = i;
			a[i] = (int) (1000000000*Math.random());
		}
		//int[] a = {12,11,43,5,3,34,26,23,455,23,424,242,243,23,34,455,33,34,43,54,8,10,15,13};
		//int[] a = {592,401,874,141,348,72,911,887,820,283};
		//int[] a = {592,401,874,141,348};
		//int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		double start = System.currentTimeMillis();
		int c = a.length;
		sort(a,0,c-1);
		System.out.println(System.currentTimeMillis() - start);
		//show(a);
		System.out.println();
		double start2 = System.currentTimeMillis();
		Arrays.sort(a);
		System.out.println(System.currentTimeMillis() - start2);
	}
}
