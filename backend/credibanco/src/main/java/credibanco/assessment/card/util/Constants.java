package credibanco.assessment.card.util;

public enum Constants {

    SUCCESS("Exitoso"),
    FAILED("Fallido"),
    CODE_SUCCESS("00"),
    CODE_FAILED("01")
    ;

    private String message;
    Constants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
