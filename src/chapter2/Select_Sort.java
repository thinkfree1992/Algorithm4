package chapter2;

public class Select_Sort {
    int[] a = {12,11,43,5,3,34,26,23,455,23,424,242,243,23,34,455,33,34,43};
	public static void exchage(int[] a,int b,int c){
		int temp = a[b];
		a[b] = a[c];
		a[c] = temp;
	}
	public static int[] sort(int[] a){
		for(int i = 0; i < a.length; i ++){
			int index = i;
			for(int j = i; j < a.length; j++){
				if(a[index] > a[j]){
					index = j;
				}
			}
			exchage(a,i,index);
		}
		return a;
	}
	public static void main(String[] args){
		int[] b = {12,11,43,5,3,34,26,23,455,23,424,242,243,23,34,455,33,34,43};
		Select_Sort ss = new Select_Sort();
		ss.sort(b);
		for(int c : b){
			System.out.print(c+" ");
		}
	}
}
