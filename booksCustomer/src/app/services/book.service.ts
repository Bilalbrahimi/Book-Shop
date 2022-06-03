import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Book } from '../models/book';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  apiUrl= "api/books/";

  constructor(private http: HttpClient) { }

  findAll(){
    return this.http.get<Book[]>(`${this.apiUrl}all`);
     
   }
}
