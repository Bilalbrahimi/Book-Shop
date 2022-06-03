import { Component, OnInit } from '@angular/core';
import { Book } from 'src/app/models/book';
import { BookService } from 'src/app/services/book.service';
import { SessionLoginService } from 'src/app/services/session/session-login.service';

@Component({
  selector: 'app-grid-books',
  templateUrl: './grid-books.component.html',
  styleUrls: ['./grid-books.component.css']
})

export class GridBooksComponent implements OnInit {

  books: Book[] = [];

  test: any;
  testOK = false;

  mBook: Book ={
    isbn: '',
    title: '',
    author: '',
    editor: '',
    price: 0,
    numberCopiesInStock: 0,
    date: '',
  }

  constructor(private bookService : BookService, private sessionLogin : SessionLoginService) { }

  ngOnInit(): void {
    this.getBooks();
    if(this.sessionLogin.session != { }){
      this.testOK =true;
      this.test = this.sessionLogin.session;
    }else{
      this.test={"test":"test"};
    }
  }

  getBooks() {
    this.bookService.findAll()
    .subscribe(bks => this.books = bks)
  }

  editBook(bk : any){
    this.mBook.isbn = bk.isbn;
    this.mBook.title = bk.title;
    this.mBook.author = bk.author;
    this.mBook.editor = bk.editor;
    this.mBook.price = bk.price;
    this.mBook.numberCopiesInStock = bk.numberCopiesInStock;
    this.mBook.date = bk.date;

  }

}
