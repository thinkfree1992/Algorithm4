package chapter2;

public class Merge_DownToUp {
	public static int[] sub = null;
	public static void sort(int[] arr){
		sub = new int[arr.length];
		int N = arr.length;
		for(int i = 1; i < N; i = 2*i){
			for(int j = 0; j < N - i; j += 2*i){
				if(arr[j+i-1] <= arr[j+i])
					continue;
				merge11(arr, j, j+i-1, Math.min(j+2*i-1, N-1));
			}
		}
	}
	public static void merge11(int[] arr, int start, int mid, int end){
		int[] temp1 = new int[mid-start+2];
		for(int i = start; i <= mid; i++){
			temp1[i-start] = arr[i];
		}
		temp1[mid-start+1] = Integer.MAX_VALUE;
		
		int[] temp2 = new int[end-mid+1];
		for(int i = mid+1; i <= end; i++){
			temp2[i-mid-1] = arr[i];
		}
		temp2[end - mid] = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		for(int k = start; k <= end; k ++){
			if(temp1[i] <= temp2[j])
				arr[k] = temp1[i++];
			else
				arr[k] = temp2[j++];
		}
	}
	
	public static void merge(int[] arr, int start, int mid, int end){
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
	public static void merge1(int[] arr, int start, int mid, int end){
		for(int i = 0; i < arr.length; i++){
			sub[i] = arr[i];
		}
		int i = start;
		int j = mid + 1;
		for(int k = start; k <= end; k++){
			if(i == mid + 1)
				arr[k] = sub[j++];
			else if(j == end + 1)
				arr[k] = sub[i++];
			else if(arr[i] <= arr[j])
				arr[k] = sub[i++];
			else
				arr[k] = sub[j++];
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
			a[i] = i;
			//a[i] = (int) (10000000*Math.random());
		}
		//int[] a = {12,11,43,5,3,34,26,23,455,23,424,242,243,23,34,455,33,34,43,54,8,10,15,13};
		//int[] a = {592,401,874,141,348,72,911,887,820,283};
		//int[] a = {592,401,874,141,348};
		//int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		double start = System.currentTimeMillis();
		int c = a.length;
		sort(a);
		show(a);
		System.out.println();
		System.out.println(System.currentTimeMillis() - start);
	}
}
