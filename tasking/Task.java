
public class Task 
{
	final static int DPG =  15140;
    final static int MPD = 1440;
	final static double DENSITY = 0.698;

	public static int favorite() {
		int result = (( ( ( (16 * 65 ) + 12 ) * 72 ) / 68 ) - 1);
		return result; 	}


	public static void wasted(double r, int d) {
		double gallonsWasted = r*MPD*d/DPG;
        int gallonsWasted_rounded = (Task.roundNumber(gallonsWasted));
		System.out.println("A faucet with " + r + " drips per minute over " + d + " days will waste " + gallonsWasted_rounded + " gallons of water");
		
	}

	public static int count(double a, double b, int mL) {
		double bean_volume = (5 * Math.PI * a * Math.pow(b, (int)2)) / 24; // cm^3
        int num_beans = (int) ((mL * DENSITY) / bean_volume);
        return num_beans;
	}
    public static int roundNumber (double input_number) {
        int roundedNumber = 0;
        if (input_number < 0) {
           roundedNumber = (int)(input_number - 0.5);
        }
        if (input_number > 0) {
           roundedNumber = (int)(input_number + 0.5);
        }
        return roundedNumber;
  
     }
}
