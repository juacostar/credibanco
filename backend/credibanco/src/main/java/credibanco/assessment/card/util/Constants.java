package credibanco.assessment.card.util;

public enum Constants {

    SUCCESS("Exitoso"),
    FAILED("Fallido"),
    CODE_SUCCESS("00"),
    CODE_FAILED("01"),
    BAD_REFERENCE("02"),
    CARD_DELETED("Se ha eliminado la tarjeta"),
    FAIL_DELETE_CARD("No se ha eliminado la tarjeta"),
    APPROVED("Aprobada"),
    REJECTED("Rechazada"),
    BAD_REFERENCE_MESSAGE("Número de referencia inválido"),
    BUY_DELETED("Compra anulada"),
    CANNOT_DELETE_TRANSACTION("No se úede anular la transacción")
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
