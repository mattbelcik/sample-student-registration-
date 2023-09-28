import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class Transaction {

    private enum type {
        DR, CR
    }; // DR = debit, CR = credit
       // debit: how much you owe
       // credit: how much you put in

    private BigDecimal amount;
    private String label;
    private BigDecimal type;

    public Transaction() {

    }

    public BigDecimal getType() {
        return this.type;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String toString() {
        // TODO: the string representation of a Transaction
        return getLabel() + getAmount() + getType();
    }

    public static Object stream() {
        return null;
    }

    public void EvalHours(int creditHours) {
        int rate = 270;
        int total;

        if (creditHours > 11 && creditHours < 19) {
            total = 3240;
            System.out.println(total);
        }

        if (creditHours < 12) {
            total = rate * creditHours;
            System.out.println(total);
        }

        if (creditHours > 18) {
            total = rate * creditHours;
            System.out.println(total);
        }
        return;
    }

    // TODO: write a constructor, and use a regex to validate file input to validate
    // the parameters you send to it.
}
