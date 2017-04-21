/* Jordan Kalember 
 * Project: ArraysLab3
 * November 2,2016
 */

public class ArraysLab3 {
	
	public static void main(String[] args){
		//b
		int[] a1 = {5,10,15,20,25,30,35,40};
		int[] a2 = {7,14,21,28,35,42,49,56};
		int[] sumArr  = sum(a1,a2);
		int appendNum = 200;
		int[] appendArr = append(a1, appendNum);
		int removeIdx = 5;
		int[] removeArr = remove(a2,removeIdx);
		int sumOfEvens = sumEven(appendArr);
		rotateRight(a1);
		//c
		System.out.println(sumArr.toString());
		System.out.println(appendArr.toString());
		System.out.println(removeArr.toString());
		System.out.println(sumOfEvens);
		System.out.println(a1.toString());
		
	}

	public static int[]sum(int[] arr1,int[] arr2){
		int[] sumArray = new int[arr1.length];
		for(int i=0;i<arr1.length-1;i++){
			int sum = arr1[i] + arr2[i];
			append(sumArray, sum);
		}
		return sumArray;
	}
	
	public static int[] append(int[] arr,int num){
		int[] newArray = new int[arr.length+1];
		for(int i=0;i<arr.length-1;i++){
			newArray[i] = arr[i];
		}
		newArray[newArray.length-1] = num;
		return(newArray);
	}
	
	public static int[] remove(int[] arr, int idx){
		int[] removedArr = new int[arr.length-1];
		for(int i=0;i<idx;i++){
			append(removedArr,i);
		}
		for(int j=idx+1;j<arr.length;j++){
			append(removedArr,j);
		}
		return removedArr;
	}
	
	public static int sumEven(int[] arr){
		int sumOfEvens = 0;
		for(int i=0;i<arr.length-1;i++){
			if(i%2==0){
				sumOfEvens += arr[i];
			}
		}
		return sumOfEvens;
	}
	
	public static void rotateRight(int[] arr){
		append(arr, 0);
		for(int i=arr.length-1;i<1;i--){
			arr[i] = arr[i-1];
		}
		arr[0] = 0;
	}
}