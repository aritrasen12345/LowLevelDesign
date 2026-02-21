package SOLID.LSP.Violated;

import java.util.*;

class Client {
    List<Account> accounts;
    
    Client() {
        this.accounts = new ArrayList<>();
    }

    void addAccount(Account account) {
        this.accounts.add(account);
    }

    void withdrawFromAllAccounts(double amount) {
        for(Account acc : accounts) {
            acc.withdraw(500);
        }
    }
}

interface Account {
    void deposit(double amount);

    void withdraw(double amount);
}

class SavingsAccount implements Account {
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

class CurrentAccount implements Account {
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

class FixedDepositAccount implements Account {
    FixedDepositAccount() {}

    @Override
    public void deposit(double amount) {
        System.out.println("Depositing amount: " + amount + " from fixed deposit account");
    }

     @Override
    public void withdraw(double amount) {
        throw new UnsupportedOperationException(
            "Withdrawals are not allowed from Fixed Deposit Account"
        );
    }
}

public class LSPViolated {
    public static void main(String[] args) {
        Client user = new Client();

        SavingsAccount saccount = new SavingsAccount();
        CurrentAccount caccount = new CurrentAccount();
        FixedDepositAccount fdaccount = new FixedDepositAccount();

        // ADD ACCOUNTS
        user.addAccount(saccount);
        user.addAccount(caccount);
        user.addAccount(fdaccount);

        // WITHDRAW 500 FROM ALL ACCOUNTS
        user.withdrawFromAllAccounts(500);
    }
}
