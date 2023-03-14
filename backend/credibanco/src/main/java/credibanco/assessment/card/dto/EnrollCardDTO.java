package credibanco.assessment.card.dto;


public class EnrollCardDTO {

    private String PAN;
    private Integer validationNumber;

    public String getPAN() {
        return PAN;
    }

    public void setPAN(String PAN) {
        this.PAN = PAN;
    }

    public Integer getValidationNumber() {
        return validationNumber;
    }

    public void setValidationNumber(Integer validationNumber) {
        this.validationNumber = validationNumber;
    }
}
