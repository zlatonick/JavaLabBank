package model.accounts;

public class AccountNumbersGenerator {

    private static int currNumber = 1000;

    public static String nextNumber() {
        currNumber++;
        return "" + currNumber;
    }
}
