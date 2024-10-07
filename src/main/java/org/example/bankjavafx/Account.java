package org.example.bankjavafx;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private static List<Account> accounts = new ArrayList<>();
    private Date dateCreated;

    public Account() {
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        accounts.add(this);
        this.dateCreated = Date.from(Instant.now());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterest() {
        double MonthlyInterest;
        MonthlyInterest = annualInterestRate / 100 / 12;
        return MonthlyInterest;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Сумма снята со счета!");
        } else {
            System.out.println("Недостаточно средств на счёте.");
        }
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Депозит успешно введен!");
    }

    public static Account findAccountById(List<Account> accounts, int id) throws IllegalArgumentException {
        for (Account account : accounts) {
            if (account.getId() == id) {
                return account;
            }
        }
        throw new IllegalArgumentException("Счета с таким id не найден!");
    }

    public static List<Account> getAccounts() {
        return accounts;
    }
}