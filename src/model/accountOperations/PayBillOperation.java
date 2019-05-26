package model.accountOperations;

import java.math.BigDecimal;
import java.util.Date;

public class PayBillOperation extends AccountOperation {

    private int billId;

    public PayBillOperation(int accountId, BigDecimal amount, Date date, int billId) {
        super(accountId, amount, date);
        this.billId = billId;
    }

    public int getBillId() {
        return billId;
    }
}
