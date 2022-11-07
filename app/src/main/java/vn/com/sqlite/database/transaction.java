package vn.com.sqlite.database;


public class transaction {

    private int id;             // INTEGER PRIMARY KEY AUTOINCREMENT;]

    private String hash;        // TEXT
    private String address;     // TEXT,
    private String toAddress;   // TEXT,
    private String pubKey;      // TEXT,
    private int amount;         // INTEGER,
    private int pendingUse;     // INTEGER,
    private int balance;        // INTEGER,
    private int fee;            // INTEGER,
    private int tip;            // INTEGER,
    private String message;     // TEXT,
    private int time;           // INTEGER,
    private int status;         // INTEGER,
    private String type;        // TEXT,
    private String prevHash;    // TEXT,
    private String sign;        // TEXT,
    private String receive_info;    // TEXT,
    private int isDeploy;       // INTEGER,
    private int isCall;         // INTEGER,
    private String functionCall;    // TEXT

    public transaction(int id, String hash, String address, String toAddress, String pubKey, int amount, int pendingUse, int balance, int fee, int tip, String message, int time, int status, String type, String prevHash, String sign, String receive_info, int isDeploy, int isCall, String functionCall) {
        this.id = id;
        this.hash = hash;
        this.address = address;
        this.toAddress = toAddress;
        this.pubKey = pubKey;
        this.amount = amount;
        this.pendingUse = pendingUse;
        this.balance = balance;
        this.fee = fee;
        this.tip = tip;
        this.message = message;
        this.time = time;
        this.status = status;
        this.type = type;
        this.prevHash = prevHash;
        this.sign = sign;
        this.receive_info = receive_info;
        this.isDeploy = isDeploy;
        this.isCall = isCall;
        this.functionCall = functionCall;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getPubKey() {
        return pubKey;
    }

    public void setPubKey(String pubKey) {
        this.pubKey = pubKey;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPendingUse() {
        return pendingUse;
    }

    public void setPendingUse(int pendingUse) {
        this.pendingUse = pendingUse;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getTip() {
        return tip;
    }

    public void setTip(int tip) {
        this.tip = tip;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrevHash() {
        return prevHash;
    }

    public void setPrevHash(String prevHash) {
        this.prevHash = prevHash;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getReceive_info() {
        return receive_info;
    }

    public void setReceive_info(String receive_info) {
        this.receive_info = receive_info;
    }

    public int getIsDeploy() {
        return isDeploy;
    }

    public void setIsDeploy(int isDeploy) {
        this.isDeploy = isDeploy;
    }

    public int getIsCall() {
        return isCall;
    }

    public void setIsCall(int isCall) {
        this.isCall = isCall;
    }

    public String getFunctionCall() {
        return functionCall;
    }

    public void setFunctionCall(String functionCall) {
        this.functionCall = functionCall;
    }

    @Override
    public String toString() {
        return "transaction{" +
                "id=" + id +
                ", hash='" + hash + '\'' +
                ", address='" + address + '\'' +
                ", toAddress='" + toAddress + '\'' +
                ", pubKey='" + pubKey + '\'' +
                ", amount=" + amount +
                ", pendingUse=" + pendingUse +
                ", balance=" + balance +
                ", fee=" + fee +
                ", tip=" + tip +
                ", message='" + message + '\'' +
                ", time=" + time +
                ", status=" + status +
                ", type='" + type + '\'' +
                ", prevHash='" + prevHash + '\'' +
                ", sign='" + sign + '\'' +
                ", receive_info='" + receive_info + '\'' +
                ", isDeploy=" + isDeploy +
                ", isCall=" + isCall +
                ", functionCall='" + functionCall + '\'' +
                '}';
    }
}
