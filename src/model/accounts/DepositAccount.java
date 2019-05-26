package model.accounts;

import model.accountOperations.AccountOperation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class DepositAccount extends Account {

    private BigDecimal depositRate;

    private BigDecimal depositAmount;

    public BigDecimal getDepositRate() {
        return depositRate;
    }

    public BigDecimal getDepositAmount() {
        return depositAmount;
    }

    public DepositAccount(BigDecimal currBalance, Date validity, String number,
                          ArrayList<AccountOperation> operations, BigDecimal depositRate, BigDecimal depositAmount) {
        super(currBalance, validity, number, operations);
        this.depositAmount = depositAmount;
        this.depositRate = depositRate;
    }
}
