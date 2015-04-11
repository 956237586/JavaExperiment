/**
 * Tax.java
 */
package experiment2.exercise4;

public class Tax {
	public static final int SINGLE_FILER = 0;
	public static final int MARRIED_JOINTLY = 1;
	public static final int MARRIED_SEPERATELY = 2;
	public static final int HEAD_OF_HOUSEHOLD = 3;
	private static double[][] stageTax;//利用其静态的特性只初始化一次
	
	private int filingStatus;
	private int[][] brackets;
	private double[] rates;
	private double taxableIncome;
	
	public Tax() {
	}

	public Tax(int filingStatus, 
			int[][] brackets, 
			double[] rates,
			int taxableIncome) {
		this.filingStatus = filingStatus;
		this.brackets = brackets;
		this.rates = rates;
		this.taxableIncome = taxableIncome;
		if (stageTax == null) {
			initStageTax();
		}
	}

	public int[][] getBrackets() {
		return brackets;
	}

	public void setBrackets(int[][] brackets) {
		this.brackets = brackets;
	}

	public double[] getRates() {
		return rates;
	}

	public void setRates(double[] rates) {
		this.rates = rates;
	}

	public int getFilingStatus() {
		return filingStatus;
	}

	public void setFilingStatus(int filingStatus) {
		this.filingStatus = filingStatus;
	}

	public double getTaxableIncome() {
		return taxableIncome;
	}

	public void setTaxableIncome(double taxableIncome) {
		this.taxableIncome = taxableIncome;
	}

	public double getResult() {
		return computeTax(filingStatus, taxableIncome);
	}

	public void resetStageTax(){
		stageTax = null;
	}

	private void initStageTax() {
		// 计算重复调用的数组
		stageTax = new double[4][brackets[0].length];
		int i, j;
		for (i = 0; i < 4; i++) {
			for (j = 0; j < stageTax[0].length - 1; j++) {
				stageTax[i][j + 1] = (brackets[i][j + 1] - brackets[i][j])
						* rates[j];
			}
		}
	}

	private int getStage(int filingStatus, double income) {
		int i = 1;
		for (i = 1; i <= 5; i++) {
			if (brackets[filingStatus][i] >= income
					&& brackets[filingStatus][i - 1] < income) {
				break;
			}
		}
		return i - 1;
	}

	private double computeTax(int status, double taxableIncome) {
		int stage = getStage(status, taxableIncome);
		double tempTax = 0, tax;
		for (int t = stage; t >= 0; t--) {
			tempTax += stageTax[status][t];
		}

		tax = tempTax + (taxableIncome - brackets[status][stage])
				* rates[stage];
		return tax;
	}

}
