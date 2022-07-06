import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Token } from 'src/app/models/token';
import { User } from 'src/app/models/user';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-register-admin',
  templateUrl: './register-admin.component.html',
  styleUrls: ['./register-admin.component.css']
})
export class RegisterAdminComponent implements OnInit {
  public username : any;
  public password : any;
  public passwordConfirm : any;
  public email : any;
  public address : any;
  public phone : any;
  public name : any;
  users: User[] = [];

  public error : any

  constructor(private usersService : UsersService, private router : Router) { }

  ngOnInit(): void {

      this.getUsers();
  }

  register () {
      const emailRegex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*/

      this.error = ''

      if (!this.email || !this.email.match(emailRegex)) {
          this.error = "L'adresse mail n'est pas valide ! "
          return
      }

      this.password = this.email;
      this.passwordConfirm = this.email;


      this.usersService.registerAdmin(
          this.username, this.password, this.email, this.name, this.address, this.phone, true).subscribe((token : Token) => {
              localStorage.setItem('token', token.token);
              this.router.navigateByUrl('/adminList').then(() => window.location.reload())
          }, (error : ErrorEvent) => {
              this.error = error.error
          })
  }

  getUsers(){
    this.usersService.getUsers()
    .subscribe(usr => this.users = usr)

  }

}
