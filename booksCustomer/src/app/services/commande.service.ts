import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Commande } from '../models/commande';

@Injectable({
  providedIn: 'root'
})
export class CommandeService {

  apiUrl= "api";

  constructor(private http : HttpClient) { }

  getCommandes(){
    return this.http.get<Commande[]>(`${this.apiUrl}/api/commande/all`);
  }


  addCommande(commande : Commande){
    return this.http.post(`${this.apiUrl}/api/commande`,commande); 
  }

  deleteCommande (commandeId : string){
    return this.http.delete(`${this.apiUrl}/api/commande/delete/${commandeId}`)
}
}


