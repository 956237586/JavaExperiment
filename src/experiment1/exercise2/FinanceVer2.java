package experiment1.exercise2;

import javax.swing.JOptionPane;

public class FinanceVer2 {
	/**
	 * 
	 * @param alertString
	 *            ��ʾ���
	 * @return �û�����
	 */
	public static String getUeserInput(String alertString) {
		String userInput = JOptionPane.showInputDialog(null,
				alertString, 
				"����",
				JOptionPane.QUESTION_MESSAGE);
		return userInput;
	}

	/**
	 * 
	 * @param s
	 *            ԭʼ�ַ���
	 * @return ת����С��
	 */
	public static double toDouble(String s) {
		return Double.parseDouble(s);
	}

	public static void main(String[] args) {
		//��Ҫ�õ����ַ���
		String[] s = new String[] { "Enter employee's name: ",
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
				"Net Pay: $" };
		
		//���벿�ֿ�ʼ
		String name = getUeserInput(s[0]);
		double hours = toDouble((getUeserInput(s[1])));
		double hourlyPayRate = toDouble(getUeserInput(s[2]));
		double federalTaxRate = toDouble(getUeserInput(s[3]));
		double stateTaxRate = toDouble(getUeserInput(s[4]));
		
		//���㲿�ֿ�ʼ
		double grossPay = hourlyPayRate * hours;
		double federalWithholding = grossPay * federalTaxRate;
		double stateWihtholding = grossPay * stateTaxRate;
		double totalDeduction = federalWithholding + stateWihtholding;
		double netPay = grossPay - totalDeduction;

		//������ֿ�ʼ
		JOptionPane.showMessageDialog(
				null,
				s[5] + name + "\n" + 
				s[6] + hours + "\n" + 
				s[7] + hourlyPayRate + "\n" + 
				s[8] + grossPay + "\n" + 
				s[9] + "\n" + 
				s[10] + (federalTaxRate * 100) + "%): $" +  
					(int) (federalWithholding * 100) / 100.0 + "\n" + 
				s[11] + (stateTaxRate * 100) + "%): $" +  
					(int) (stateWihtholding * 100) / 100.0 + "\n" + 
				s[12] + (int) (totalDeduction * 100) / 100.0 + "\n" + 
				s[13] + (int) (netPay * 100) / 100.0 + "\n");

	}

}
