package model.accountOperations;

import java.math.BigDecimal;
import java.util.Date;

public class TransferOperation extends AccountOperation {

    private int accountDestId;

    public TransferOperation(int accountId, BigDecimal amount, Date date, int accountDestId) {
        super(accountId, amount, date);
        this.accountDestId = accountDestId;
    }

    public int getAccountDestId() {
        return accountDestId;
    }
}
