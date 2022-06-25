import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from 'src/app/models/book';
import { BooksService } from 'src/app/services/book.service';

@Component({
  selector: 'app-book-detail-admin',
  templateUrl: './book-detail-admin.component.html',
  styleUrls: ['./book-detail-admin.component.css']
})
export class BookDetailAdminComponent implements OnInit {

  user : any;
  books : Book[] = []


  constructor(
      private router : Router, 
      private bookService : BooksService,
  ) { }

  ngOnInit(): void {
      if (!localStorage.getItem('token')) {
          this.router.navigateByUrl('/login')
          return
      }

      this.bookService.getBooks().subscribe((books : Book[]) => {
        this.books = books
          
      }, (error : ErrorEvent) => {
          console.log(error)
      })
      
  }



  deleteItem(book : Book){
      this.bookService.deleteBook(book.id.toString()).subscribe(res => {
          console.log(res)
          this.bookService.getBooks().subscribe((books : Book[]) => {
            this.books = books
              
          }, (error : ErrorEvent) => {
              console.log(error)
          })
      })
  }

}
