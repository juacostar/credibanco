import { Component, OnInit } from '@angular/core';
import { Transaction } from 'src/app/models/Transaction';
import { TransactionService } from 'src/app/services/transaction.service';

@Component({
  selector: 'app-transaction-component',
  templateUrl: './transaction-component.component.html',
  styleUrls: ['./transaction-component.component.css']
})
export class TransactionComponentComponent implements OnInit{

  transactions: Transaction[] = [];

  ngOnInit(): void {
    this.findAllTransactions();
  }

  constructor(private transactionService: TransactionService){}

  findAllTransactions(){
    this.transactionService.findAllTransactions().subscribe(response => {
      this.transactions = response;
    });
  }


}
