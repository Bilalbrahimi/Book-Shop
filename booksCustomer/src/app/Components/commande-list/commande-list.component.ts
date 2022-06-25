import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartItem } from 'src/app/models/cart-item';
import { Commande } from 'src/app/models/commande';
import { User } from 'src/app/models/user';
import { CartItemsService } from 'src/app/services/cart-items.service';
import { CommandeService } from 'src/app/services/commande.service';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-commande-list',
  templateUrl: './commande-list.component.html',
  styleUrls: ['./commande-list.component.css']
})
export class CommandeListComponent implements OnInit {

  commandes : Commande[] = []
  user : any;
  
  constructor(private router : Router, private commandeServices : CommandeService, private usersService : UsersService,) { }

  ngOnInit(): void {
    if (!localStorage.getItem('token')) {
      this.router.navigateByUrl('/login')
      return
  }

  this.usersService.getUserByToken().subscribe((user : User) => {
      this.user = user;
      this.getCommandes()
  }, (error : ErrorEvent) => {
      console.log(error)
  })
  }


  getCommandes () {
    this.commandeServices.getCommandes().subscribe((commandes : Commande[]) => {
      this.commandes = commandes;
    })

  }

  deleteCommande(cmd : Commande){
    this.commandeServices.deleteCommande(cmd.commandeId.toString()).subscribe(res => {
        console.log(res)
        this.getCommandes()
    })
}
}




