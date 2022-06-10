import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from '../models/book';

@Injectable({
  providedIn: 'root'
})
export class BooksService {
  apiUrl= "api";
  
  constructor(private http : HttpClient) { }

  getBooks () : Observable<Book[]> {
      return this.http.get<Book[]>(`${this.apiUrl}/api/books`);
  }

  getBook (id : string) : Observable<Book> {
      return this.http.get<Book>(`${this.apiUrl}/api/books/${id}`);
  }
}
