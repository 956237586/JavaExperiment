package experiment1.exercise3;

import java.util.Scanner;

public class FinaceProblem {
	static double[] rates = { 0.10, 0.15, 0.25, 0.28, 0.33, 0.35 };
	static int[][] brackets = { 
			{ 0, 8350, 33950, 82250, 171550, 372950 },
			{ 0, 16700, 67900, 137050, 208850, 372950 },
			{ 0, 8350, 33950, 68525, 104425, 186475 },
			{ 0, 11950, 45500, 117450, 190200, 372950 } };
	static double[][] stageTax = {
			{ 0, 835.0, 3840.0, 12075.0, 25004.000000000004, 66462.0, },
			{ 0, 1670.0, 7680.0, 17287.5, 20104.000000000004, 54153.0, },
			{ 0, 835.0, 3840.0, 8643.75, 10052.000000000002, 27076.5, },
			{ 0, 1195.0, 5032.5, 17987.5, 20370.000000000004, 60307.5, }, };

	public static int getStage(int filingStatus, double income) {
		int i = 1;
		for (i = 1; i <= 5; i++) {
			if (brackets[filingStatus][i] >= income
					&& brackets[filingStatus][i - 1] < income) {
				break;
			}
		}
		return i - 1;
	}

	public static double computeTax(int status, 
									double taxableIncome) {
		int stage = getStage(status, taxableIncome);
		double tempTax = 0, tax;
		for (int t = stage; t >= 0; t--) {
			tempTax += stageTax[status][t];
		}

		tax = tempTax + (taxableIncome - brackets[status][stage])
				* rates[stage];
		return tax;
	}

	public static void main(String[] args) {
		/*/
		// 计算重复调用的数组
		int i, j;
		for (i = 0; i < 4; i++) {
			for (j = 0; j < 5; j++) {
				stageTax[i][j] = (brackets[i][j + 1] - brackets[i][j])
						* rates[j];
				System.out.print(stageTax[i][j] + ",");
			}
			System.out.println();
		}
		//*/
		//*/
		String[][] s = {
				{"Taxable   ","Single    ","Married   ","Married","   Head of"},
				{"Income    ", "          ", "Joint     ", "Seperate","a House"},};
		for (int j = 0; j < 2; j++) {
			for (int i = 0; i < 5; i++)
				System.out.print(s[j][i]);
			System.out.println();
		}
		System.out.println("------------------------------------------------");

		for (int i = 50000; i <= 60000; i += 10) {
			System.out.printf("%-10d", i);
			for (int j = 0; j < 4; j++) {
				System.out.printf("%-10d", (int) computeTax(j, i));
			}
			System.out.println();
		}
		//*/
		/*/
		Scanner in = new Scanner(System.in);
		System.out.println(
				"0-单身纳税人, "
				+ "1-已婚共同纳税人或证实的鳏寡, "
				+ "2-已婚单独纳税人, "
				+ "3-家庭户主纳税人");
		System.out.print("Enter the filing status:");
		int filingStatus = in.nextInt();

		System.out.print("Enter the taxable income:");
		int income = in.nextInt();
		in.close();
		// 输入结束
		double tax = computeTax(filingStatus, income);
		System.out.println("Tax is " + tax);
		//*/
		
	}

}
