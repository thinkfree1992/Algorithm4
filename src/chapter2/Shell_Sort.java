package chapter2;

public class Shell_Sort {
	public static void sort(int[] a){
		int h = a.length/2;
		while(h >= 1){
			for(int i = h; i < a.length; i++){
				int key = a[i];
				int j = i - h;
				while(j >= 0 && a[j] > key){
					a[j+h] = a[j];
					j -= h;
				}
				//if(j != i - h)
					a[j+h] = key;	
			}
			h /=2;
		}
	}
	public static void show(int[] a){
		for(int c : a){
			System.out.print(c + " ");
		}
	}
	public static void main(String[] args){
		int[] a = new int[1000000];
		for(int i = 0; i < 1000000; i++){
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
