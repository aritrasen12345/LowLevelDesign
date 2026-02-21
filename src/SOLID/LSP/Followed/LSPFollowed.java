package SOLID.LSP.Followed;

import java.util.*;

class Client {
    List<WithdrawableAccount> withdrawableAccounts;
    List<NonWithdrawableAccount> nonWithdrawableAccounts;
    
    Client() {
        this.withdrawableAccounts = new ArrayList<>();
        this.nonWithdrawableAccounts = new ArrayList<>();
    }

    void addWithdrawableAccount(WithdrawableAccount account) {
        this.withdrawableAccounts.add(account);
    }

    void addNonWithdrawableAccount(NonWithdrawableAccount account) {
        this.nonWithdrawableAccounts.add(account);
    }

    void withdrawFromAllAccounts(double amount) {
        for(WithdrawableAccount acc : this.withdrawableAccounts) {
            acc.withdraw(amount);
        }
    }
}

interface NonWithdrawableAccount {
    void deposit(double amount);
}

interface WithdrawableAccount extends NonWithdrawableAccount{
    void withdraw(double amount);
}

class SavingsAccount implements WithdrawableAccount {
    SavingsAccount() {}

    @Override
    public void deposit(double amount) {
        System.out.println("Depositing amount: " + amount + " from savings account");
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Withdrawing amount: " + amount + " from savings account");
    }
}

class CurrentAccount implements WithdrawableAccount {
    CurrentAccount() {}

    @Override
    public void deposit(double amount) {
        System.out.println("Depositing amount: " + amount + " from current account");
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Withdrawing amount: " + amount + " from current account");
    }   
}

class FixedDepositAccount implements NonWithdrawableAccount {
    FixedDepositAccount() {}

    @Override
    public void deposit(double amount) {
        System.out.println("Depositing amount: " + amount + " from fixed deposit account");
    }
}

public class LSPFollowed {
    public static void main(String[] args) {
        Client user = new Client();

        SavingsAccount saccount = new SavingsAccount();
        CurrentAccount caccount = new CurrentAccount();
        FixedDepositAccount fdaccount = new FixedDepositAccount();

        // ADD ACCOUNTS
        user.addWithdrawableAccount(saccount);
        user.addWithdrawableAccount(caccount);
        user.addNonWithdrawableAccount(fdaccount);

        // WITHDRAW 500 FROM ALL ACCOUNTS
        user.withdrawFromAllAccounts(500);
    }
}
