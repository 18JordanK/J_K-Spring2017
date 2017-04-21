/*Jordan Kalember October 5,2016.
 * This code prints out the greatest, smallest, and sum of the even inputs given by the user.
 */
import java.util.*;
public class processingNumbers {
	
	
	@SuppressWarnings("resource")
	public static void main(){
		Scanner userInput = new Scanner(System.in);
		int inputNumber = userInput.nextInt();
		int min = inputNumber;
		int max = inputNumber;
		int evenSum = 0;
		System.out.println("Enter 5 integers.");
		for(int i=1;i<5;i++){
			if(inputNumber %2 == 0){
				evenSum+=inputNumber;
			}
			if(inputNumber<min){
				min = inputNumber;
			}else if(inputNumber>max){
				max = inputNumber;
			}
			inputNumber = userInput.nextInt();
		}
		System.out.println(evenSum);
		System.out.println(max);
		System.out.println(min);
	}
}
