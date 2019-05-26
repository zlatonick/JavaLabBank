package model.accountOperations;

import java.math.BigDecimal;
import java.util.Date;

public class DepositOperation extends AccountOperation {
    public DepositOperation(int accountId, BigDecimal amount, Date date) {
        super(accountId, amount, date);
    }
}
