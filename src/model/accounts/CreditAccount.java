package model.accounts;

import model.accountOperations.AccountOperation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class CreditAccount extends Account {

    private BigDecimal creditRate;

    private BigDecimal currentDebt;

    private BigDecimal interestCharges;

    public CreditAccount(int accountId, AccountType type, int userId, BigDecimal currBalance,
                         Date validity, String number, BigDecimal creditRate, BigDecimal currentDebt,
                         BigDecimal interestCharges) {
        super(accountId, type, userId, currBalance, validity, number);
        this.creditRate = creditRate;
        this.currentDebt = currentDebt;
        this.interestCharges = interestCharges;
    }

    public BigDecimal getCreditRate() {
        return creditRate;
    }

    public BigDecimal getCurrentDebt() {
        return currentDebt;
    }

    public BigDecimal getInterestCharges() {
        return interestCharges;
    }
}
