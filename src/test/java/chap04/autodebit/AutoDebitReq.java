package chap04.autodebit;

public class AutoDebitReq {
    private final String userId;
    private final String cardNumber;

    public AutoDebitReq(String userId, String cardNumber) {
        this.userId = userId;
        this.cardNumber = cardNumber;
    }

    public String getUserId() {
        return userId;
    }

    public String getCardNumber() {
        return cardNumber;
    }
}
