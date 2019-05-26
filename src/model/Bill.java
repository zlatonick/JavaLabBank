package model;

import java.math.BigDecimal;
import java.util.Date;

public class Bill {

    private int billId;

    private int userId;

    private BigDecimal amount;

    private Date payUntil;

    public Bill(int billId, int userId, BigDecimal amount, Date payUntil) {
        this.billId = billId;
        this.userId = userId;
        this.amount = amount;
        this.payUntil = payUntil;
    }

    public int getBillId() {
        return billId;
    }

    public int getUserId() {
        return userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Date getPayUntil() {
        return payUntil;
    }
}
