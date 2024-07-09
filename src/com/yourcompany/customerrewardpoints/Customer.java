package com.yourcompany.customerrewardpoints;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String phoneNumber;
    private String address;
    private Tier tier;
    private int rewardPoints;
    private List<Double> transactions;

    public Customer(String name, String phoneNumber, String address) {
        validatePhoneNumber(phoneNumber);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.tier = Tier.BEGINNER;
        this.rewardPoints = 0;
        this.transactions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public Tier getTier() {
        return tier;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public List<Double> getTransactions() {
        return transactions;
    }

    public void addTransaction(double amount) {
        transactions.add(amount);
    }

    public void updateTierAndPoints(double amountSpent) {
        rewardPoints += calculateRewardPoints(amountSpent);
        updateTier();
    }

    private void updateTier() {
        if (totalAmountSpent() > 999) {
            tier = Tier.LEGEND;
        } else if (totalAmountSpent() > 699) {
            tier = Tier.ELITE;
        } else if (totalAmountSpent() > 399) {
            tier = Tier.INTERMEDIATE;
        } else if (totalAmountSpent() > 100) {
            tier = Tier.BEGINNER;
        }
    }

    private int calculateRewardPoints(double amountSpent) {
        if (amountSpent >= 999) {
            return calculatePointsWithLimit(amountSpent, 0.20, 150);
        } else if (amountSpent >= 699) {
            return calculatePointsWithLimit(amountSpent, 0.15, 100);
        } else if (amountSpent >= 399) {
            return calculatePointsWithLimit(amountSpent, 0.10, 75);
        } else if (amountSpent >= 100) {
            return calculatePointsWithLimit(amountSpent, 0.05, 50);
        }
        return 0;
    }

    private int calculatePointsWithLimit(double amountSpent, double percentage, int limit) {
        int points = (int) (amountSpent * percentage);
        return Math.min(points, limit);
    }

    private double totalAmountSpent() {
        return transactions.stream().mapToDouble(Double::doubleValue).sum();
    }

    private void validatePhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits");
        }
    }

    // @Override
    // public String toString() {
    //     return String.format(
    //             "+-----------------+--------------+----------------------+------------+-----------------+\n" +
    //                     "| Customer Name   | Phone Number | Address              | Tier       | Reward Points   |\n" +
    //                     "+-----------------+--------------+----------------------+------------+-----------------+\n" +
    //                     "| %-15s | %-12s | %-20s | %-10s | %-15d |\n" +
    //                     "+-----------------+--------------+----------------------+------------+-----------------+",
    //             name, phoneNumber, address, tier, rewardPoints);
    // }
}
