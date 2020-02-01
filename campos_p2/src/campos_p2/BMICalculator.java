package campos_p2;

import java.text.DecimalFormat;
import java.util.Scanner;

public class BMICalculator {
	private DecimalFormat df = new DecimalFormat("#.#");
	
	private int unitSet;
	
	private double userWeight;
	private double userHeight;
	private double calculatedBmi;
	
	private String bmiCatagory;

	//set height OR exit program from incorrect value
	private void setHeight(double userInputHeight)
	{
		double userInput = userInputHeight;
		
		if(userInput >= 0)
		{
			this.userHeight = userInputHeight;
		}
		else
		{
			if(userInput < 0)
			{
				System.out.print("\nHeight entered was invalid, Goodbye! ");
				System.exit(0);
			}
		}
	}
	
	//Set weight value OR exit program from incorrect input
	private void setWeight(double userInputWeight)
	{
		double userInput = userInputWeight;
		
		if(userInput >= 0)
		{
			this.userWeight = userInputWeight;
		}
		else
		{
			if(userInput < 0)
			{
				System.out.print("\nWeight entered was invalid, Goodbye! ");
				System.exit(0);
			}
		}
	}
	
	//Calcualte BMI catagory based on American Heart association metrics
	private void calculateBmiCategory(double calcBmi)
	{
		if(this.calculatedBmi < 18.5)
		{
			this.bmiCatagory = "UNDERWEIGHT";
		}
		
		if(this.calculatedBmi >= 18.5 && this.calculatedBmi <= 24.99)
		{
			this.bmiCatagory = "NORMAL WEIGHT";
		}
		
		if(this.calculatedBmi >= 25 && this.calculatedBmi <= 29.99)
		{
			this.bmiCatagory = "OVERWEIGHT";
		}
		
		if(this.calculatedBmi > 30)
		{
			this.bmiCatagory = "OBEASE";
		}
	}
	
	//return IMPERIAL calculation values
	private double[] readImperialData()
	{
		double imperialWeight;
		double imperialHeight;
		
		imperialWeight = this.userWeight * 703;
		imperialHeight = this.userHeight * this.userHeight;
		
		return new double[] {imperialWeight, imperialHeight};
	}
	
	//return METRIC calculation values
	private double[] readMetricData()
	{
		double metricWeight;
		double metricHeight;
		
		metricWeight = this.userWeight;
		metricHeight = this.userHeight * this.userHeight;
		
		return new double[] {metricWeight, metricHeight};
	}
	
	//translate calculation for either unit of measurement
	private double[] readMeasurementData()
	{
		double[] calcVariables = null;
		
		if(this.unitSet == 1)
		{
			calcVariables = readImperialData();
		}
		
		else if(this.unitSet == 2)
		{
			calcVariables = readMetricData();
		}
		
		return calcVariables;
	}
	
	//determine Unit of measurement for calculation
	private void readUnitType()
	{
		Scanner in = new Scanner(System.in);
		
		System.out.print("\n\n1.IMPERIAL ");
		System.out.print("\n2.METRIC ");
		System.out.print("\n\nPlease select the corresponding number for the units used for your calculation:  ");
		this.unitSet = in.nextInt();
		
	}
	
	//return Bmi catagory to display method
	public String getBmiCatagory()
	{
		return this.bmiCatagory;
	}
	
	//return calculated Bmi to display method
	public double getBmi()
	{
		return this.calculatedBmi;
	}
	
	//user input height in Imperial or metric units
	public double getHeight()
	{
		Scanner in = new Scanner(System.in);
		
		double userHeight = 0;
		
		if(this.unitSet == 1)
		{
		System.out.print("\nPlease enter your height in INCHES: ");
		userHeight = in.nextDouble();
		}
		
		if(this.unitSet == 2)
		{
		System.out.print("\nPlease enter your height in METERS: ");
		userHeight = in.nextDouble();
		}
		
		return userHeight;
	}
	
	//user input weight in Imperial or Metric units
	public double getWeight()
	{
		Scanner in = new Scanner(System.in);
		
		double userWeight = 1;
		
		if(this.unitSet == 1)
		{
		System.out.print("\nPlease enter your weight in POUNDS: ");
		userWeight = in.nextDouble();
		}
		
		if(this.unitSet == 2)
		{
		System.out.print("\nPlease enter your weight in KILOGRAMS: ");
		userWeight = in.nextDouble();
		}
		
		return userWeight;
	}
	
	//Introductory method, reference getWeight and getHeight
	public void readUserData()
	{		
		double userInputWeight;
		
		double userInputHeight;
		
		System.out.print("\nHello! Welcome to the BMI Calculation program.");
		
		readUnitType();
		
		userInputWeight = getWeight();
		setWeight(userInputWeight);
		
		userInputHeight = getHeight();
		setHeight(userInputHeight);
	
	}
	
	//determine which calculation to execute and set values for BMI and Catagory
	public void calculateBmi()
	{
		
		double[] calcVariable = readMeasurementData();
		
		this.calculatedBmi = calcVariable[0] / calcVariable[1];
		
		calculateBmiCategory(this.calculatedBmi);
		
	}
	
	//final display of calculated variables
	public void displayBmi()
	{
		System.out.print("\nYour calculated BMI is: " + df.format(getBmi()));
		System.out.print("\nYour BMI catagory is: " + getBmiCatagory());
	}
	
	
	public static void main(String[] args) {
	    BMICalculator app = new BMICalculator();
	    app.readUserData();
	    app.calculateBmi();
	    app.displayBmi();
	}
}
