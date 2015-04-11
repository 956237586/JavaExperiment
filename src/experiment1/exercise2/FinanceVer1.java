package experiment1.exercise2;

import java.util.Scanner;

public class FinanceVer1 {

	public static void main(String[] args) {
		//将要用到的字符串
		String[] s = new String[] { 
				"Enter employee's name: ",
				"Enter number of hours worked in a week: ",
				"Enter hourly pay rate: ",
				"Enter federal tax withholding rate: ",
				"Enter state tax withholding rate: ", 
				"Employee Name: ", 
				"Hours Worked: ",
				"Pay Rate: $",
				"Gross Pay: $",
				"Deductions: ",
				"  Federal Withholding(",
				"  State Wihtholding(",
				"  Total Deduction: $",
				"Net Pay: $"};
		
		//输入部分开始
		Scanner in = new Scanner(System.in);
		
		System.out.print(s[0]);
		String name = in.next();
		
		System.out.print(s[1]);
		double hours = in.nextDouble();
		
		System.out.print(s[2]);
		double hourlyPayRate = in.nextDouble();
		
		System.out.print(s[3]);
		double federalTaxRate = in.nextDouble();
		
		System.out.print(s[4]);
		double stateTaxRate = in.nextDouble();
		in.close();
		
		//计算部分开始		
		double grossPay = hourlyPayRate * hours;
		double federalWithholding = grossPay * federalTaxRate;
		double stateWihtholding = grossPay * stateTaxRate;
		double totalDeduction = federalWithholding + stateWihtholding;
		double netPay = grossPay - totalDeduction;
		
		//输出部分开始
		System.out.println(s[5] + name);
		System.out.println(s[6] + hours);
		System.out.println(s[7] + hourlyPayRate);
		System.out.println(s[8] + grossPay);
		System.out.println(s[9]);
		System.out.println(s[10] + (federalTaxRate * 100) + "%): $" + 
								(int)(federalWithholding * 100)/100.0);
		System.out.println(s[11] + (stateTaxRate * 100) + "%): $" + 
								(int)(stateWihtholding * 100)/100.0);
		System.out.println(s[12] + (int)(totalDeduction * 100)/100.0);
		System.out.println(s[13] + (int)(netPay * 100)/100.0);
	}

}
