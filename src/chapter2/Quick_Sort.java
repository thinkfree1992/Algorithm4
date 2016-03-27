package chapter2;

public class Quick_Sort {
	public static void sort(int[] arr, int start, int end){
		if(end - start < 13){
			Insert_Sort.sort(arr, start, end);
			return;
		}
		if(start < end){
			int j = partion(arr, start, end);
			sort(arr, start, j-1);
			sort(arr, j+1, end);
		}
	}
	public static int partion(int[] arr, int start, int end){
		int key = arr[end];
		int i = start - 1;
		for(int j = start; j < end; j++){
			if(arr[j] <= key){
				i++;
				exchange(arr, j, i);
			}
		}
		exchange(arr, i+1, end);
		return i+1;
	}
	
	private int partition(int[] input, int lowIndex, int highIndex) {  
		   
	      int i=lowIndex;  
	      int pivotIndex=lowIndex;  
	      int j=highIndex+1;  
	   
	      while (true){  
	   
	          while (less(input[++i], input[pivotIndex])){  
	              if (i==highIndex) break;  
	          }  
	   
	          while (less (input[pivotIndex], input[--j])){  
	              if (j==lowIndex) break;  
	          }  
	   
	          if (i>=j) break;  
	   
	          exchange(input, i, j);  
	   
	      }  
	   
	      exchange(input, pivotIndex, j);  
	   
	      return j;  
	  }  
	
	public static void exchange(int[] arr, int min, int max){
		int temp = arr[max];
		arr[max] = arr[min];
		arr[min] = temp;
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
			a[i] = (int) (100000000*Math.random());
		}
		//int[] a = {12,11,43,5,3,34,26,23,455,23,424,242,243,23,34,455,33,34,43,54,8,10,15,13};
		//int[] a = {592,401,874,141,348,72,911,887,820,283};
		//int[] a = {592,401,874,141,348};
		//int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		double start = System.currentTimeMillis();
		int c = a.length;
		sort(a,0,c-1);
		//show(a);
		System.out.println();
		System.out.println(System.currentTimeMillis() - start);
	}
}
