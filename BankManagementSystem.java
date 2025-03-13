import java.util.ArrayList;

// BankAccount class
class BankAccount {
    private String accountNumber;
    private double balance;
    private Bank bank;

    public BankAccount(String accountNumber, double balance, Bank bank) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.bank = bank;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Bank getBank() {
        return bank;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}

// Customer class
class Customer {
    private String name;
    private ArrayList<BankAccount> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public void viewBalance() {
        System.out.println("Accounts for " + name + ":");
        for (BankAccount account : accounts) {
            System.out.println("Account No: " + account.getAccountNumber() +
                    ", Balance: Rupees" + account.getBalance() +
                    ", Bank: " + account.getBank().getName());
        }
    }
}

// Bank class
class Bank {
    private String name;
    private ArrayList<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public BankAccount openAccount(Customer customer, String accountNumber, double initialBalance) {
        BankAccount newAccount = new BankAccount(accountNumber, initialBalance, this);
        customer.addAccount(newAccount);
        if (!customers.contains(customer)) {
            customers.add(customer);
        }
        return newAccount;
    }
}

// Main class to demonstrate association
public class BankManagementSystem {
    public static void main(String[] args) {
        // Create Bank objects
        Bank bank1 = new Bank("HDFC Bank");
        Bank bank2 = new Bank("ICICI Bank");

        // Create Customer objects
        Customer customer1 = new Customer("Siddharth");
        Customer customer2 = new Customer("Shubham");

        // Open accounts for customers in different banks
        bank1.openAccount(customer1, "HDFC12345", 5000);
        bank1.openAccount(customer1, "HDFC67890", 3000);
        bank2.openAccount(customer2, "ICICI54321", 7000);

        // Display customer balances
        customer1.viewBalance();
        customer2.viewBalance();
    }
}

//        Accounts for Siddharth:
//        Account No: HDFC12345, Balance: Rupees5000.0, Bank: HDFC Bank
//        Account No: HDFC67890, Balance: Rupees3000.0, Bank: HDFC Bank
//        Accounts for Shubham:
 //       Account No: ICICI54321, Balance: Rupees7000.0, Bank: ICICI Bank
