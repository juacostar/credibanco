package credibanco.assessment.card.model;

import javax.persistence.*;

@Entity
@Table(name = "Transaction")
public class Transaction {

    @Id
    @Column(name = "reference")
    private String reference;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "address")
    private String address;

    @Column(name = "state")
    private String state;

    @ManyToOne
    @JoinColumn(name = "PAN")
    private Card card;
}
