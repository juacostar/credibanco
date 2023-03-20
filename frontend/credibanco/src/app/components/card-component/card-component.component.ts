import { Component, OnInit } from '@angular/core';
import { Card } from 'src/app/models/card';
import { CardServiceService } from 'src/app/services/card-service.service';

@Component({
  selector: 'app-card-component',
  templateUrl: './card-component.component.html',
  styleUrls: ['./card-component.component.css']
})
export class CardComponentComponent implements OnInit {

  ngOnInit(): void {
    this.listAllCards();
  }

  public cards: Card[] = [];

  constructor(private cardService: CardServiceService){}

  listAllCards(){
      this.cardService.findAllCards().subscribe(response =>{
          this.cards = response;
      });
  }
}
