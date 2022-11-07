package vn.com.sqlite.database;


public class wallet {

    private int id;
    private String address;
    private int balance;
    private int pendingBalance;

    public wallet(int id, String address, int balance, int pendingBalance) {
        this.id = id;
        this.address = address;
        this.balance = balance;
        this.pendingBalance = pendingBalance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getPendingBalance() {
        return pendingBalance;
    }

    public void setPendingBalance(int pendingBalance) {
        this.pendingBalance = pendingBalance;
    }

    @Override
    public String toString() {
        return "wallet{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", balance=" + balance +
                ", pendingBalance=" + pendingBalance +
                '}';
    }
}
