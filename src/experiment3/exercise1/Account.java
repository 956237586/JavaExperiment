/**
 * Created by HYL.
 */
package experiment3.exercise1;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
你会发现很多方法没有设成void而是被我设置成了this
这样做的好处就是，可以多次重复调用不同的方法
而不用再次重复书写对象实例
*/
public class Account {
    private static int num; // 设置为static用于计数
    private static double annualInterestRate; // 题目说假定所有账户年利率相等
    private int id;
    private double balance;
    private Date dateCreated;

    public Account() {
        id = num++;
        //每创建一个账户时候，自动分配id
        //利用num属性的static实现了账户id的递增自动分配
        dateCreated = new Date(); //自动记录当前创建时间
    }

    public Account(double balance) {
        this(); //利用this关键字调用无参构造方法
        this.balance = balance;
    }

    public Account(int id, double balance) {
        this(balance);//嵌套调用上一个构造方法
        this.id = id;
    }

    /**
     * 获得账户ID
     *
     * @return 账户ID
     */
    public int getId() {
        return id;
    }

    /**
     * @param id 新账户ID
     * @return 当前实例
     */
    public Account setId(int id) {
        this.id = id;
        return this;
    }

    /**
     * 获得当前账户的余额
     *
     * @return 当前账户余额
     */
    public double getBalance() {
        return balance;
    }

    /**
     * 设置账户余额，安全设计上，
     * 本方法不得对外公开调用
     *
     * @param balance 新余额
     * @return 当前实例
     */
    public Account setBalance(double balance) {
        this.balance = balance;
        return this;
    }

    /**
     * 获得当前账户年利率
     *
     * @return 年利率
     */
    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    /**
     * 设置当前账户年利率
     *
     * @param annualInterestRate 新年利率
     */
    public static void setAnnualInterestRate(double annualInterestRate) {
        Account.annualInterestRate = annualInterestRate;
    }

    /**
     * 获得账户创建时间
     * 格式为 yyyy.MM.dd - HH:mm:ss
     *
     * @return 账户创建时间
     */
    public String getDateCreated() {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd - HH:mm:ss");
        return sd.format(dateCreated);
    }

    /**
     * 获得账户月利率
     *
     * @return 账户月利率
     */
    public double getMonthlyInterestRate() {
        return annualInterestRate / 12.0;
    }

    /**
     * 从账户取钱
     *
     * @param drawMoney 金额
     * @return 当前实例
     */
    public Account withDraw(double drawMoney) {
        balance -= drawMoney;
        return this;
    }

    /**
     * 存钱进入账户
     *
     * @param depositMoney 存款金额
     * @return 当前实例
     */
    public Account deposit(double depositMoney) {
        balance += depositMoney;
        return this;
    }

    //重写了toString来满足试验要求
    @Override
    public String toString() {
        String ret = "balance: " + balance + "\n" + "MonthlyInterest: "
                + getMonthlyInterestRate() * balance + "\n"
                + "AccountCreatedDate:" + getDateCreated();
        return ret;
    }

}
