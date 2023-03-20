import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Card } from '../models/card';

@Injectable({
  providedIn: 'root'
})
export class CardServiceService {

  private apiServerUrl = environment.apiBaseUrl;
  headers = new HttpHeaders().set('content-type','appliccation/json');


  constructor(private http: HttpClient) { }

  findAllCards(): Observable<Card[]> {
    return this.http.get<Card[]>(this.apiServerUrl + "/cards");
  }

}
