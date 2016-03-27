package chapter2;

import java.util.Arrays;

public class Merge_UptoDown {
	static int[] temp = null;
	public static void sort(int[] arr, int start, int end){
		temp = new int[arr.length];
		if(end <= start){
			return;
		}
		int mid = (start + end)/2;
		sort(arr, start, mid);
		sort(arr, mid+1, end);
		merge111(arr, start, mid, end);
	}
	public static void merge111(int[] arr, int start, int mid, int end){
		int[] temp1 = new int[mid+2-start];
		for(int i = start; i <= mid; i ++){
			temp1[i-start] = arr[i];
		}
		temp1[mid+1-start] = Integer.MAX_VALUE;
		
		int[] temp2 = new int[(end - mid + 1)];
		for(int i = mid+1; i <= end; i++){
			temp2[i-mid-1] = arr[i];
		}
		temp2[end - mid] = Integer.MAX_VALUE;
		
		int i = 0;
		int j = 0;
		int k = start;
		while(!(i == temp1.length-1 && j== temp2.length-1)){
			if(temp1[i] <= temp2[j]) {
				arr[k++] = temp1[i++];
			}
			else if(temp1[i] > temp2[j])
				arr[k++] = temp2[j++];
		}
	}
	public static void merge2(int[] arr, int start, int mid, int end){
		int i = start;
		int j = mid + 1;
		for(int e = start; e <= end; e++){
			temp[e] = arr[e];
		}
		for(int k = start; k <= end; k++){
			if( i > mid)
				arr[k] = temp[j++];
			else if(j > end)
				arr[k] = temp[i++];
			else if(temp[j] < temp[i])
				arr[k] = temp[j++];
			else 
				arr[k] = temp[i++];
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
		//int[] a = {592,401,874,141,348};
		double start = System.currentTimeMillis();
		int c = a.length;
		sort(a,0,a.length-1);
		show(a);
		System.out.println();
		System.out.println(System.currentTimeMillis() - start);
	}
}
