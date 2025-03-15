/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.n22dccn045.n22dccn045_752_oop;

public class BankAccount {
    // Thuộc tính
    private String accountNumber;
    private double balance;
    private String accountHolder;

    // Constructor
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Getter và Setter
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    // Phương thức nạp tiền
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Đã nạp " + amount + " vào tài khoản. Số dư mới: " + balance);
        } else {
            System.out.println("Số tiền nạp không hợp lệ! Phải lớn hơn 0.");
        }
    }

    // Phương thức rút tiền
    public void withdraw(double amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Đã rút " + amount + " từ tài khoản. Số dư mới: " + balance);
            } else {
                System.out.println("Số dư không đủ để rút " + amount + "!");
            }
        } else {
            System.out.println("Số tiền rút không hợp lệ! Phải lớn hơn 0.");
        }
    }

    // Phương thức hiển thị số dư
    public void displayBalance() {
        System.out.println("Thông tin tài khoản:");
        System.out.println("Số tài khoản: " + accountNumber);
        System.out.println("Chủ tài khoản: " + accountHolder);
        System.out.println("Số dư hiện tại: " + balance);
    }

    // Main method để test lớp BankAccount
}