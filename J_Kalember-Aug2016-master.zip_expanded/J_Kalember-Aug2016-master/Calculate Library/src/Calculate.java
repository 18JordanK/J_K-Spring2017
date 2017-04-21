/*Jordan Kalember October 5,2016.
 * This is a Calculate library, that executes simple expressions
 */
public class Calculate {
//Part 1:Methods, Headers, and Basic Math
	
	// A call to square returns the square of the value passed.
	public static int square(int number){
		return(number*number);
	}
	
	//A call to cube returns the cube of the value passed.
	public static int cube(int number){
		return(number*number*number);
	}
	
	//A call to average returns the average of the 2 values passed to it.
	public static double average(double number, double number2){
		return((number+number2)/2);
	}
	
	//A call to average returns the average of 3 values passed to it.
	public static double average(double number, double number2, double number3){
		return((number*number2*number3)/3);
	}
	
	//A call to toDegress converts an angle measure given in radians to degrees.
	public static double toDegrees(double radians){
		return(radians/Math.PI*180);
	}
	
	//A call to toRadians converts an angle measure given in degrees into radians.
	public static double toRadians(double angleMeasure){
		return(angleMeasure*Math.PI/180);
	}
	
	/*A call to discriminant provides the coefficients of a quadratic equation in
	 * standard form(a, b, and c) and returns the value of the discriminant.
	 */
	public static double discriminant(double a, double b, double c){
		return(b*b-(4*a*c));
	}
	
	//A call to toImproperFrac converts mixed number into an improper fraction.
	public static String toImproperFrac(int wholeNum, int numerator, int denominator){
		int improperNumerator = (wholeNum*denominator) + numerator;
		return(improperNumerator + "/" + denominator);
	}
	
	//A call to toMixedNum converts an improper fraction into a mixed number.
	public static String toMixedNum(int numerator, int denominator){
		 if(numerator == denominator){
			return("1");
		}
		int wholeNum = numerator/denominator ;
		int mixedNumerator = numerator%denominator ;
		return(wholeNum + "_" + mixedNumerator + "/" + denominator);
	}
	
	/*A call to foil converts a binomial multiplication of the form into a quadratic
	 * equation of the from ax^2 + bx + c.
	 */
	public static String foil(int first, int inner, int outer, int last ,String var){
		int a = first*outer;
		int b = (first*last) - (inner*outer);
		int c = inner*last;
		return(a + var + "^2 + " + b + var + " + " + c);
	}
	
// Part 2: Methods with Conditionals
	
	/*A call to isDivisibleBy determines whether or not one integer is evenly divisible
	 * by another.
	 */
	public static boolean isDivisibleBy(int num1, int num2){
		return(num1%num2==0);
	}
	
	//A call to absValue returns the absolute value of the number passed.
	public static double absValue(double num){
		if(num<0){
			return(0-num);
		}else{
			return(num);
		}
	}
	
	//A call to max returns the larger of the 2 integers passed.
	public static int max(int num1, int num2){
		if(num1>num2){
			return(num1);
		}else{
			return(num2);
		}
	}
	
	//A call to max returns the larger of the 3 doubles passed.
	public static double max(double num1, double num2, double num3){
		if(num1>num2 && num1>num3){
			return(num1);
		}else if(num2>num1 && num2>num3){
			return(num2);
		}else{
			return(num3);
		}
	}
	
	//A call to min returns the smaller of the larger of the values passed.
	public static int min(int num1, int num2){
		if(num1<num2){
			return(num1);
		}else{
			return(num2);
		}
	}
	
	//A call to round2 rounds a double correctly to 2 decimal places. 
	public static double round2(double num){
		double numRoundedBy2 = num*100;
		numRoundedBy2 += 0.5;
		numRoundedBy2 = (int)numRoundedBy2;
		return(numRoundedBy2/100);
		
	}

//Part 3:Methods that use Loops and Calls to Other Methods
	
	/*A call to exponent raises a value to a positive integer power. 
	*Exponent is assumed to be positive.
	*/
	public static double exponent(double base, int power){
		double exponentValue = 1;
		if(power>0){
			for(int i=0; i<power; i++){
				exponentValue *= base;
			}
		}else{
			for(int i=0; i<power; i++){
				exponentValue /= base;
			}
		}
		return(exponentValue);
	}
	
	//A call to factorial returns the factorial of the value passed.
	public static int factorial(int num){
		int factorialValue = 1;
		if(num<0){
			throw new IllegalArgumentException("The Factorial is not possible.");
		}else{
			for(int i=num; i>0; i--){
				factorialValue *= i;
			}
			return(factorialValue);
		}
	}
	
	//A call to isPrime determines whether or not an integer is prime.
	public static boolean isPrime(int num){
		int numFactors = 0;
		int factor = 1;
		for(int i=0; i<num; i++){
			if(Calculate.isDivisibleBy(num, factor)){
				numFactors++;
			}
			factor ++;
		}
		return(numFactors>2);
	}
	
	//A call to gcf finds the greatest common factor of two integers.
	public static int gcf(int num1, int num2){
		int divider = 1;
		int smallerNum = Calculate.min(num1, num2);
		int gcf = 1;
		for(int i=0;i<smallerNum;i++){
			if(Calculate.isDivisibleBy(num1, divider) && Calculate.isDivisibleBy(num2, divider)){
				gcf = divider;
			}
			divider++;
		}
		return(gcf);
	}
	
	/*A call to sqrt returns an approximation of the square root of the value passed,
	 *accurate to two decimal places. 
	 */
	public static double sqrt(double num){
		/*if(num<0){
			throw new IllegalArgumentException(num + " has no square roots.");
		}else{
			double squareRoot = 1+(num-1)/(1+Calculate.sqrt(num));
			return(Calculate.round2(squareRoot));
		}
		*/
		return(Math.sqrt(num));
	}
	
//Part 4:Throwing Exceptions
	
	/*A call to quadForm uses the coefficients of a quadratic equation in standard form uses
	 * the quadratic formula to approximate the real roots, if any.
	 */
	public static String quadForm(int a, int b, int c){
		if(Calculate.discriminant(a, b, c)!=0){
			System.out.println(2 + " solutions");
		}else if(Calculate.discriminant(a, b, c)==0){
			System.out.println(1 + " solutions");
		}else{
			System.out.println(" No solutions");
		}
		double val1 = -b+Calculate.sqrt(Calculate.discriminant(a, b, c))/2;
		double val2 = -b-Calculate.sqrt(Calculate.discriminant(a, b, c))/2;
		return(val1 + " and " + val2);
	}
}



