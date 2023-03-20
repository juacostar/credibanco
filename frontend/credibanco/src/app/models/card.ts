export class Card{

    pan: String;
    owner: String;
    userId: String;
    phone: String;
    state: String;

    constructor(pan: String, owner: String, userId: String, phone: String, state: String){
        this.pan = pan;
        this.owner = owner;
        this.userId = userId;
        this.phone = phone;
        this.state = state;
    }
}