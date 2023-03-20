export class Transaction{

    address: String;
    amount: Number;
    date: Date;
    reference: String;
    state: String;
    cardPan: String;

    constructor(address: String, amount: Number, date: Date, reference: String, state: String, cardPan: String){
        this.address = address;
        this.amount = amount;
        this.date = date;
        this.reference = reference;
        this.state = state;
        this.cardPan = cardPan;
    }

}