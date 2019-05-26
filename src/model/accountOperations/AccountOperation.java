package model.accountOperations;

import java.math.BigDecimal;
import java.util.Date;

public abstract class AccountOperation {

    private int accountId;

    private BigDecimal amount;

    private Date date;

    public int getAccountId() {
        return accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public AccountOperation(int accountId, BigDecimal amount, Date date) {
        this.accountId = accountId;
        this.amount = amount;
        this.date = date;
    }
}
