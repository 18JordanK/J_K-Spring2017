/*Jordan Kalember August 31,2016.
 *This code converts a temperature from fahrenheit into celsius.
 *The temperature in Celsius is printed out as a test.
 */

public class TempConvert {
	public static void main(String[] args){
		double tempFahrenheit = 32;
		double tempCelsius = (tempFahrenheit-32)*5/9;
		System.out.println(tempCelsius + " degrees in Celsius.");
		
		int testInt = 5;
		String testString = "Yes";
		int[] testArray = {1,2,3,4};
		for(int value : testArray){
			System.out.print(value);
		}
		System.out.println("Before: " + testInt + "," + testString + "," + testArray.toString() + ".");
		changeMe(testInt,testString,testArray);
		System.out.println("After: " + testInt + "," + testString + "," + testArray.toString() + ".");
	}

	public static void changeMe(int x, String str, int[] arr){
		x=2;
		str = "No";
		incrementAll(arr);
	}

	private static void incrementAll(int[] arr) {
		for(int i=0; i<arr.length; i++){
			arr[i]++;
		}
	}
}

