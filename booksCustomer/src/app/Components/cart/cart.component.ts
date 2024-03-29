import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartItem } from 'src/app/models/cart-item';
import { Commande } from 'src/app/models/commande';
import { User } from 'src/app/models/user';

import { CartItemsService } from 'src/app/services/cart-items.service';
import { CommandeService } from 'src/app/services/commande.service';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

    user : any;
    cartItems : CartItem[] = []


    constructor(
        private router : Router, 
        private usersService : UsersService,
        private cartItemsService : CartItemsService,
    ) { }

    ngOnInit(): void {
        if (!localStorage.getItem('token')) {
            this.router.navigateByUrl('/login')
            return
        }

        this.usersService.getUserByToken().subscribe((user : User) => {
            this.user = user;
            this.getItems()
            
        }, (error : ErrorEvent) => {
            console.log(error)
        })
        
    }

    getItems () {
        this.cartItemsService.getUserCart(this.user.id.toString()).subscribe((cartItems : CartItem[]) => {
            this.cartItems = cartItems;
        })
    }

    getTotal () {
        var reducer = (acc: any, val: any) => acc + val;
        return this.cartItems ? this.cartItems.map((item) => item.totalPrice).reduce(reducer,0) : 0.0
    }




    increaseQuantity (item : CartItem) {
        this.cartItemsService.updateUserCartItem(
            this.user.id.toString(), item.book.id.toString(), item.quantity + 1).subscribe(res => {
            console.log(res)
            this.getItems()
        })
    }

    decreaseQuantity (item : CartItem) {
        if (item.quantity - 1 <= 0) {
            this.cartItemsService.deleteUserCartItem(this.user.id.toString(), item.book.id.toString()).subscribe(res => {
                console.log(res)
                this.getItems()
            })
        } else {
            this.cartItemsService.updateUserCartItem(
                this.user.id.toString(), item.book.id.toString(), item.quantity - 1).subscribe(res => {
                console.log(res)
                this.getItems()
            })
        }
    }

    deleteItem(item : CartItem){
        this.cartItemsService.deleteUserCartItem(this.user.id.toString(), item.book.id.toString()).subscribe(res => {
            console.log(res)
            this.getItems()
        })
    }



}
