import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Book } from 'src/app/models/book';
import { User } from 'src/app/models/user';
import { CartItemsService } from 'src/app/services/cart-items.service';
import { BooksService } from 'src/app/services/book.service';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-book-detail',
  templateUrl: './book-detail.component.html',
  styleUrls: ['./book-detail.component.css']
})
export class BookDetailComponent implements OnInit {
  public book : any
  public user : any
  public isBookInCart : boolean = false

  constructor(
      private route : ActivatedRoute, 
      private booksService : BooksService, 
      private usersService : UsersService,
      private cartItemsService : CartItemsService
  ) { }

  ngOnInit(): void {
      this.booksService.getBook(this.route.snapshot.paramMap.get('id') as string).subscribe((book : Book) => {
          this.book = book
      }, (error: ErrorEvent) => {
          console.log(this.book);
      })

      this.usersService.getUserByToken().subscribe((user : User) => {
          this.user = user
          console.log(this.user.id);

          this.getCartItem()
      }, (error : ErrorEvent) => {
          console.log(error)
      })
  }

  addToCart () {
      this.cartItemsService.addToUserCart(this.user.id.toString(), this.book.id.toString()).subscribe(res => {
          this.getCartItem()
      })
  }

  getCartItem () {
      this.cartItemsService.getCartItem(this.user.id.toString(), this.book.id.toString()).subscribe(res => {
          this.isBookInCart = true
      }, (error : ErrorEvent) => {
          this.isBookInCart = false
      })
  }
}
