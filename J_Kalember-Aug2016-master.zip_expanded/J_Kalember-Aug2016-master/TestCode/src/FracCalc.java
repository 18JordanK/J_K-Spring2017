import java.util.*;

public class FracCalc {
	public static void main(String[] args){
    	Scanner userInput = new Scanner(System.in);
    	System.out.println("Enter a problem.");
    	String userString = userInput.next();
    	
    	while(userString != "stop"){
	    	produceAnswer(userString);
	    	System.out.println(produceAnswer(userString));
	    	userString = userInput.next();
    	}
        // TODO: Read the input from the user and call produceAnswer with an equation

    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    
	public static String[] splitString(String input){
    	String[] splitString = new String[3];
    	
    	//Gets the index of the space and stores in variables
    	int indxOfFirstSpace = 0;
    	int indxOfSecondSpace = 0;
    	for(int i=0;i<input.length();i++){
    		if(indxOfFirstSpace == 0 && splitString[i] != " "){
    			indxOfFirstSpace = i;
    		}
    	}
    	
    	//Uses the index to get strings of each 
    	String firstOperand = input.substring(0,indxOfFirstSpace);
    	String calculation = input.substring(indxOfFirstSpace+1, indxOfSecondSpace);
    	String secondOperand = input.substring(indxOfSecondSpace+1);
    	
    	//Adds the String of operands and calculations to Array
    	splitString[0] = firstOperand;
    	splitString[1] = calculation;
    	splitString[2] = secondOperand;
    	
    	return splitString;
    }
    
    public static String produceAnswer(String input){ 
        // TODO: Implement this function to produce the solution to the input
    	String[] splitInput = splitString(input);
    	
    	int[] parsedOperands1 = parseOperands(splitInput[0]);
    	int[] parsedOperands2 = parseOperands(splitInput[2]);
    	
    	int[] solution = {3};
    	// Does the correct operation based on input given by user and sets value to the solution.
    	if(splitInput[1] == "+"){
    		solution = addSubtract(parsedOperands1,parsedOperands2,false);
    	}else if(splitInput[1] == "-"){
    		solution = addSubtract(parsedOperands1,parsedOperands2,true);
    	}else if(splitInput[1] == "*"){
    		solution = multiplyDivide(parsedOperands1,parsedOperands2,true);
    	}else if(splitInput[1] == "/"){
    		solution = multiplyDivide(parsedOperands1,parsedOperands2,false);
    	}
    	// Puts the solution in format to be printed out.
    	toMixedNum(solution);
    	
    	// prints the solution in string fraction format.
    	return(solution[0] + "_" + solution[1] + "/" + solution[2]);
    }
    
    public static int[] parseOperands(String operand){
    	int indxOfUnderscore = 0;
    	int indxOfSlash = 0;
    	int[] parsedOperand = {3};
    	
    	if(operand.contains("_")){
    		indxOfUnderscore = operand.indexOf("_");
    	}
    	if(operand.contains("/")){
    		indxOfUnderscore = operand.indexOf("/");
    	}
    	
    	//checks for special cases of input where there is no "/" or "_".
    	if(indxOfUnderscore == 0 && indxOfSlash == 0){
    		parsedOperand[1] = 0;
    		parsedOperand[2] = 1;
    	}else if(indxOfUnderscore == 0){
    		parsedOperand[0] = 0;
    	}else if(indxOfSlash == 0){
    		parsedOperand[1] = 1;
    	}
    	
    	String wholeNumString = operand.substring(0, indxOfUnderscore+1); 
    	String numeratorString = operand.substring(indxOfUnderscore+1, indxOfSlash+1);
    	String denominatorString = operand.substring(indxOfSlash+1);
    	
    	int wholeNumInt = Integer.parseInt(wholeNumString);
    	int numeratorInt = Integer.parseInt(numeratorString);
    	int denominatorInt = Integer.parseInt(denominatorString);
    	
    	parsedOperand[0] = wholeNumInt;
    	parsedOperand[1] = numeratorInt;
    	parsedOperand[2] = denominatorInt;
    	
    	//Changes the arr(whole,numerator,denominator) to (numerator,denominator).
    	toImproperFrac(parsedOperand);
    	
    	return parsedOperand;
    }
    
    public static void toImproperFrac(int[] arr){
    	int numerator = arr[2] * arr[0] + arr[1];
    	int denominator = arr[2];
    	
    	arr[0] = numerator;
    	arr[1] = denominator;
    }
    
    public static void toMixedNum(int [] arr){
    	int wholeNum = arr[0] / arr[2];
    	int numerator = arr[0] % arr[2];
    	int denominator = arr[1];
    	
    	arr[0] = wholeNum;
    	arr[1] = numerator;
    	arr[2] = denominator;
    }
    
    public static int[] multiplyDivide(int[] arr1, int[] arr2, boolean divide){
    	int[] result = {2};
    	
    	//Swaps the values of the numerator and denominator to become reciprocal when divide is true
    	if(divide){
    		int control = arr2[0];
    		arr2[0] = arr2[1];
    		arr2[2] = control;
    	}
    	int productNumerator = arr1[0] * arr1[0];
    	int productDenominator = arr1[1] * arr2[1];
    	
    	result[0] = productNumerator;
    	result[1] = productDenominator;
    	return result;
    }
    
    public static int[] addSubtract(int[] arr1, int[] arr2, boolean subtract){
    	int[] result = {2};
    	
    	//Makes the numerator of second operand negative when subtract is true
    	if(subtract){
    		arr2[0] *= -1;
    	}
    	int num1 = arr1[0] * arr2[1];
    	int num2 = arr2[0] * arr1[1];
    	
    	int sumNumerator = num1+num2;
    	int sumDenominator = arr1[1] * arr1[1];
    	
    	result[0] = sumNumerator;
    	result[1] = sumDenominator;
    	return result;
    }
    // TODO: Fill in the space below with any helper methods that you think you will need
 }