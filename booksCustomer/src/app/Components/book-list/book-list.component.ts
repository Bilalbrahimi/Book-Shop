import { Component, OnInit } from '@angular/core';
import { Book} from 'src/app/models/book';
import { ActivatedRoute, Router } from '@angular/router';
import { BooksService } from 'src/app/services/book.service';
@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {
  public term : string
  public books : Book[] =[]


  constructor(router : Router, route : ActivatedRoute, private booksService : BooksService) { 
      this.term = route.snapshot.paramMap.get('term') || ""
  }

  ngOnInit(): void {
      this.booksService.getBooks().subscribe((books : Book[]) => {
          this.books = books

      }, (error: ErrorEvent) => {
      })
  }


}