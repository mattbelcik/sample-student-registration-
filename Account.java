import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Account {
    private List<Transaction> transactions = new ArrayList<Transaction>();
    private List<Transaction> account = new ArrayList<Transaction>();

    private BigDecimal balance;

    public Account() {

    }

    public List<Transaction> getTransactions() {
        return this.transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public BigDecimal getBalance() {
        Integer index = this.account.size() - 1;
        return getBalance(index);
    }

    private BigDecimal getBalance(Integer index) {
        if (index == 0)
            return this.account.get(index).getAmount();
        else
            return this.account.get(index).getAmount().add(getBalance(index - 1));
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void displayAccount() {
        System.out.println(transactions);

    }

    List<Transaction> list = Arrays.asList();

    BigDecimal total;
    NumberFormat USformat = NumberFormat.getCurrencyInstance(Locale.US);

    public void EvalHours(int creditHours) {

        BigDecimal rate = BigDecimal.valueOf(270);

        if (creditHours > 11 && creditHours < 19) {
            total = BigDecimal.valueOf(-3240);
            System.out.println("amount due: " + USformat.format(total));
        }

        else if (creditHours < 12) {
            BigDecimal temp1 = BigDecimal.valueOf(creditHours);
            total = rate.negate().multiply(temp1);
            System.out.println("amount due: " + USformat.format(total));
        }

        else if (creditHours > 18) {
            BigDecimal temp2 = BigDecimal.valueOf(creditHours);
            total = rate.negate().multiply(temp2);
            System.out.println("amount due: " + USformat.format(total));
        }
        return;
    }

    public void addMoney(int p) {
        BigDecimal temp3 = BigDecimal.valueOf(p);
        total = total.add(temp3);

        System.out.println("Balance: " + USformat.format(total));
    }

    // TODO assign each student an Account and write a setter and getter to keep the
    // balance updated.

    // Use this lambda
    // BigDecimal sum =
    // Transaction.stream().map(Transaction::getAmount).reduce(BigDecimal.ZERO,
    // BigDecimal::add);

}