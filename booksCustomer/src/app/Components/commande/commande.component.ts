import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Commande } from 'src/app/models/commande';
import { User } from 'src/app/models/user';
import { CommandeService } from 'src/app/services/commande.service';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-commande',
  templateUrl: './commande.component.html',
  styleUrls: ['./commande.component.css']
})
export class CommandeComponent implements OnInit {

  user : any;
  
  constructor(private router : Router, private commandeServices : CommandeService, private usersService : UsersService,) { }

  ngOnInit(): void {
    if (!localStorage.getItem('token')) {
      this.router.navigateByUrl('/login')
      return
  }

  this.usersService.getUserByToken().subscribe((user : User) => {
      this.user = user;
  }, (error : ErrorEvent) => {
      console.log(error)
  })
  }



}
