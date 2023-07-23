import java.util.Scanner;

class Bank {
    protected String IFSC_Code;
    protected String bankname;
    protected String branchname;
    protected String loc = "Done";
    Bank() {

    }
    public Bank(String IFSC_Code, String bankname, String branchname, String loc) {
        super();
        this.IFSC_Code = IFSC_Code;
        this.bankname = bankname;
        this.branchname = branchname;
        this.loc = loc;
    }
    Scanner sc  = new Scanner(System.in);
    public void getBankInfo() {
        System.out.println("Give customers's savings account information: ");
        System.out.println("Enter IFSC code: ");
        IFSC_Code = sc.next();
        System.out.println("Enter Bank Name: ");
        bankname = sc.next();
        System.out.println("Enter Branch Name: ");
        branchname = sc.next();
        loc = "Done";
    }
}

class Customer extends Bank{
    protected long Customer_Id;
    protected String Custname;
    protected String address;
    protected String contactdetails;

    Customer() {

    }
    public Customer(String IFSC_Code, String bankname, String branchname, String loc, long customer_Id, String custname, String address, String contactdetails) {
        super(IFSC_Code, bankname, branchname, loc);
        Customer_Id = customer_Id;
        Custname = custname;
        this.address = address;
        this.contactdetails = contactdetails;
    }
}
class Account extends Customer {
    protected long AccountID;
    protected int balance= 10000;

    Account() {

    }

    public Account(long accountID, int balance) {
        AccountID = accountID;
        this.balance = balance;
    }

    public Account(String IFSC_Code, String bankname, String branchname, String loc, long customer_Id, String custname, String address, String contactdetails, long accountID, int balance) {
        super(IFSC_Code, bankname, branchname, loc, customer_Id, custname, address, contactdetails);
        AccountID = accountID;
        this.balance = balance;
    }

    public void getAccountInfo() {

        System.out.println("IFSC-CODE: "+IFSC_Code+
                "BankName: "+bankname+
                "BranchName: "+branchname+
                "Letter Of Credit: "+loc);

    }
    public void deposit(int amount_deposit, boolean value) {
        value = true;
        balance = balance + amount_deposit;
        System.out.println("Amount_deposit: "+amount_deposit+"\n"+"Value: "+value);
    }

    public void withdraw(int amount_withdraw ) {
        if(balance >= amount_withdraw) {
            balance = balance - amount_withdraw;
            System.out.println("Amount_withdraw: " + amount_withdraw);
        }
        else {
            System.out.println("Your balance is less than withdraw amount "+amount_withdraw+" ..Transaction failed..");
        }

    }

    public int getBalance() {

        return balance;
    }
}
class SavingsAccount extends Account {
    public SavingsAccount() {
    }

    public SavingsAccount(String IFSC_Code, String bankname, String branchname, String loc, long customer_Id, String custname, String address, String contactdetails, long accountID, String balance) {
        super(IFSC_Code, bankname, branchname, loc, customer_Id, custname, address, contactdetails, accountID, Integer.parseInt(balance));
    }
    public void getSavingsAccountInfo() {
        this.getBankInfo();
        System.out.println("******************** Given Savings Account Information ************");
        System.out.println("IFSC-CODE: "+IFSC_Code+
                "\n"+"BankName: "+bankname+
                "\n"+ "BranchName: "+branchname+
                "\n"+"LOC: "+loc);
        System.out.println("******************** Transaction Details **************************");
    }
    public void deposit(int amount_deposit, boolean value) {
        value = true;
        System.out.println("Enter deposit amount: ");
        amount_deposit = sc.nextInt();
        balance = balance + amount_deposit;
        System.out.println("Amount_deposit: "+amount_deposit+" Value: "+value);
    }

    public void withdraw(int amount_withdraw ) {
        System.out.println("Enter withdraw amount: ");
        amount_withdraw = sc.nextInt();
        balance = balance - amount_withdraw;
        System.out.println("Amount_withdraw: "+amount_withdraw);

    }

    public int getBalance() {
        System.out.println("Account_Balance: "+balance);
        return balance;
    }
}
public class Assessment1 {
    public static void main(String[] args) {
        System.out.println("****************** Assessment one executing ********************ICICI!");

        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.getSavingsAccountInfo();
        savingsAccount.deposit(15000,true);
        savingsAccount.withdraw(5000);
        savingsAccount.getBalance();

        System.out.println("*************** Transaction Ended ******************************");
    }
}