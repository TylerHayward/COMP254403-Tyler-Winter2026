package Exam;

import java.util.Comparator;

public class AccountComparator implements Comparator<Account> {
    public int compare(Account a1, Account a2) {
        return Double.compare(a1.accountBalance, a2.accountBalance);
    }
}