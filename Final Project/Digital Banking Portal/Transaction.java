package project;
public class Transaction {
    private String transactionId;
    private String transactionType;
    private double amount;

    public Transaction(String transactionId, String transactionType, double amount) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public void displayTransaction() {
        System.out.println("Transaction ID: " + transactionId + 
                           ", Type: " + transactionType + 
                           ", Amount: $" + amount);
    }
}
