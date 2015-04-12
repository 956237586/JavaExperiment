package experiment3.exercise1;

public class Exercise1 {

    public static void main(String[] args) {
        Account account = new Account(1122, 20000);
        Account.setAnnualInterestRate(0.045);
        account.withDraw(2500).deposit(3000);
        // 由于这两个方法都被我定义成了返回this
        // 所以在调用时候可以连续调用
        System.out.println(account);
    }

}
