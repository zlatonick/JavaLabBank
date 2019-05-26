package model;

import java.math.BigDecimal;
import java.util.Date;

public class AccountRequest {

    private int requestId;

    private int userId;

    private BigDecimal amount;

    private BigDecimal creditRate;

    private Date term;

    public AccountRequest(int requestId, int userId, BigDecimal amount,
                          BigDecimal creditRate, Date term) {
        this.requestId = requestId;
        this.userId = userId;
        this.amount = amount;
        this.creditRate = creditRate;
        this.term = term;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getRequestId() {
        return requestId;
    }

    public int getUserId() {
        return userId;
    }

    public BigDecimal getCreditRate() {
        return creditRate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Date getTerm() {
        return term;
    }
}
