/**
 * Exercise4.java
 */
package experiment2.exercise4;

public class Exercise4 {
	public static void main(String[] args) {

		int[][] brackets2001 = { 
				{ 0, 27050, 65550, 136750, 297350, },
				{ 0, 45200, 109250, 166500, 297350, },
				{ 0, 22600, 54625, 83250, 148675, },
				{ 0, 36250, 93650, 151650, 297350, }, };
		double[] rates2001 = { 0.15, 0.275, 0.305, 0.355, 0.391, };
		

		display(brackets2001, rates2001);

		int[][] brackets2009 = { 
				{ 0, 8350, 33950, 82250, 171550, 372950 },
				{ 0, 16700, 67900, 137050, 208850, 372950 },
				{ 0, 8350, 33950, 68525, 104425, 186475 },
				{ 0, 11950, 45500, 117450, 190200, 372950 } };
		double[] rates2009 = { 0.10, 0.15, 0.25, 0.28, 0.33, 0.35 };
		display(brackets2009, rates2009);
	}

	public static void display(int[][] brackets, double[] rates) {
		String[][] s = {
				{ "Taxable   ", "Single    ", "Married   ", "Married","   Head of" },
				{ "Income    ", "          ", "Joint     ", "Seperate",	"a House" }, };
		for (int j = 0; j < 2; j++) {
			for (int i = 0; i < 5; i++)
				System.out.print(s[j][i]);
			System.out.println();
		}
		System.out.println("------------------------------------------------");
		//表头打印完成
		Tax tax = null;
		for (int i = 50000; i <= 60000; i += 1000) {
			System.out.printf("%-10d", i);
			for (int j = 0; j < 4; j++) {
				tax = new Tax(j, brackets, rates, i);
				System.out.printf("%-10.2f", tax.getResult());
			}
			System.out.println();
		}
		System.out.println();
		tax.resetStageTax();
	}
}
