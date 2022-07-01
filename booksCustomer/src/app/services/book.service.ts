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

  deleteBook (id : string) : Observable<any> {
    return this.http.delete(`${this.apiUrl}/api/books/${id}`);
  }
  

  public addBook(book:Book){
    return this.http.post(`${this.apiUrl}/api/books`,book);
  }  


  public upPic(file:any){
    return this.http.post<any>(`${this.apiUrl}/api/upImg`,file);
  } 
}
