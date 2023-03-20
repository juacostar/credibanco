import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Transaction } from '../models/Transaction';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  private apiServerUrl = environment.apiBaseUrl;
  headers = new HttpHeaders().set('content-type','appliccation/json');

  constructor(private http: HttpClient) { }

  findAllTransactions(): Observable<Transaction[]>{
    return this.http.get<Transaction[]>(this.apiServerUrl + "/transactions");
  }
}
