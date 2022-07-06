import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from 'src/app/models/book';
import { BooksService } from 'src/app/services/book.service';

@Component({
  selector: 'app-book-list-admin',
  templateUrl: './book-list-admin.component.html',
  styleUrls: ['./book-list-admin.component.css']
})
export class BookListAdminComponent implements OnInit {

  user : any;
  books : Book[] = []
  uploadForm: any;
  newBook: Book = new Book(0,"","",0,new Date(),"","","","","","");


  constructor(
      private router : Router,
      private bookService : BooksService,
      private formBuilder: FormBuilder,
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
      this.uploadForm = this.formBuilder.group({
        profile: ['']
      });

  }



  deleteBook(book : Book){
      this.bookService.deleteBook(book.id.toString()).subscribe(res => {
          console.log(res)
          this.bookService.getBooks().subscribe((books : Book[]) => {
            this.books = books

          }, (error : ErrorEvent) => {
              console.log(error)
          })
      })
  }

  addBook(){


    const formData = new FormData();
    formData.append('file', this.uploadForm.get('profile').value);

    this.bookService.upPic(formData).subscribe()
      this.newBook.image = this.uploadForm.get('profile').value.name;
       this.bookService.addBook(this.newBook)
       .subscribe((even : any) => {
         this.books = [even, ...this.books];
         console.log(this.newBook);
     })




     this.newBook = new Book(0,"","",0,new Date(),"","","","","","");

   }

   onFileChanged(event : any) {

    if (event.target.files.length > 0) {
      const file = event.target.files[0];
      this.uploadForm.get('profile').setValue(file);
    }

  }

}
