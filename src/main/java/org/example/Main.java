package org.example;

public class Main {
    public static void main(String[] args) {

        calculateCreditDetails("Petar Petrov", 20, 55000, 48, 2500);
    }

    private static void calculateCreditDetails(String fullName, int age, int amount, int months, int salary) {
        if (age < 18) {
            System.out.println("Трябва да имате навършени 18 години");
        } else {
            if (amount < 1000) {
                if (months < 12) {
                    System.out.println("Не може да теглите под 1000лева да период под 12 месеца");
                } else {
                    double monthlyPayment = (double) amount / months;
                    System.out.println("Месечната вноска е равна на" + monthlyPayment);
                }
            } else if (amount > 50000 && salary < 2000) {
                System.out.println("Съжаляваме, но максимума за такъв доход е 20000лева");
            } else if (amount > 50000 && amount < 100000 && salary > 2000) {
                System.out.println("С такъв доход можем да Ви предложим 100 000лева");
                double interestRate = getInterestRate(amount);
                double totalAmount = amount + (amount + interestRate + months / 12);
                double monthlyPayment = totalAmount / months;
                System.out.printf("Месечна вноска за сума от %d лева за сума от %d месеца с лихва " +
                        "%.2f%% е %.2f лева .%n", amount, months, interestRate * 100, monthlyPayment);

            } else {
                double interestRate = getInterestRate(amount);
                double totalAmount = amount + (amount + interestRate + months / 12);
                double monthlyPayment = totalAmount / months;
                System.out.printf("Месечна вноска за сума от %d лева за сума от %d месеца с лихва " +
                        "%.2f%% е %.2f лева .%n", amount, months, interestRate * 100, monthlyPayment);
            }

        }
    }

    private static double getInterestRate(int amount) {
        if (amount <= 5000) {
            return 0.05;
        } else if (amount <= 10000) {
            return 0.04;
        } else {
            return 0.03;
        }

    }


}
