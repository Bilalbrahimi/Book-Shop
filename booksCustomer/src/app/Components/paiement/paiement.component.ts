import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartItem } from 'src/app/models/cart-item';
import { Commande } from 'src/app/models/commande';
import { User } from 'src/app/models/user';
import { CartItemsService } from 'src/app/services/cart-items.service';
import { CommandeService } from 'src/app/services/commande.service';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-paiement',
  templateUrl: './paiement.component.html',
  styleUrls: ['./paiement.component.css']
})
export class PaiementComponent implements OnInit {

  cmd : any
  user : any;
  cartItems : CartItem[] = []

  
  constructor(
    private router : Router, 
    private usersService : UsersService,
    private cartItemsService : CartItemsService,
    private commandeService : CommandeService,
  ) {}

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

deleteItem(item : CartItem){
  this.cartItemsService.deleteUserCartItem(this.user.id.toString(), item.book.id.toString()).subscribe(res => {
      console.log(res)
      this.getItems()
  })
}

payer(){
  this.cmd = new Commande(0,new Date(),"","","","",0,[],"","",0);
  this.cmd.userName = this.user.username;
  this.cmd.name = this.user.email;
  this.cmd.adresse = this.user.address;
  this.cmd.totalPrice = this.getTotal();

  this.cartItems.forEach((item) =>{
    this.cmd.quantities+=item.quantity+"_";
    this.cmd.lBooks+=item.book.name+"_"+item.quantity;
    
  });
  this.commandeService.addCommande(this.cmd).subscribe(res => {
      console.log(this.cmd)
      this.cmd;
  })
  this.cartItems.forEach((i) =>{
    this.deleteItem(i);
  });
}
}
