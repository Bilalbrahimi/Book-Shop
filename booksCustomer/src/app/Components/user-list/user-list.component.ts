import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: User[] = [];




  constructor(private userService: UsersService ) { }

  ngOnInit(): void {
    this.getUsers();
  }

  getUsers(){
    this.userService.getUsers()
    .subscribe(usr => this.users = usr)
    
  }


  deleteUser(id : any){
    if(confirm("La suppression d'un utilisateur est irréversible.\nVoulez vous continuer? ")) {
      this.userService.deleteUser(id)
      .subscribe(() => {
        this.users = this.users.filter(user => user.id != id)
      })
    }
  }



}
