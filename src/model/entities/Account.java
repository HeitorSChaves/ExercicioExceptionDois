package model.entities;

import model.exceptions.DomainException;

public class Account {

    //Atributes

    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    //Constructors

    public Account (Integer number, String holder, Double balance, Double withdrawLimit) {
        if (balance<0) {
            throw new DomainException("You cannot open an account with negative values.");
        }
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Account() {
    }

    //Getters and Setters


    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    //Metods

    public void deposit (Double amount) {
        if (amount<0) {
            throw new DomainException("Cannot deposit negative values");
        }
       balance = balance + amount;
    }

    public void withdraw (Double amount) {
        if (amount> withdrawLimit || amount > balance){
            throw new DomainException("Withdraw limit is higher than the limit or account balance.");
        }
        balance = balance - amount;
    }
}
