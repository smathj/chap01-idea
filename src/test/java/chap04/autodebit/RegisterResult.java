package chap04.autodebit;

public class RegisterResult {
    private final boolean success;
    private final CardValidity validity;

    public RegisterResult(boolean success, CardValidity validity) {
        this.success = success;
        this.validity = validity;
    }

    public boolean isSuccess() {
        return success;
    }

    public CardValidity getValidity() {
        return validity;
    }

    public static RegisterResult error(CardValidity validity) {
        return new RegisterResult(false, validity);
    }

    public static RegisterResult success() {
        return new RegisterResult(true, CardValidity.VALID);
    }
}
