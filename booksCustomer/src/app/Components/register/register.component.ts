import { Component, OnInit } from '@angular/core';
import { UsersService } from 'src/app/services/users.service';
import { Router } from '@angular/router';
import { Token } from 'src/app/models/token';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  public username : any;
  public password : any;
  public passwordConfirm : any;
  public email : any;
  public address : any;
  public phone : any;
  public name : any;

  public error : any

  constructor(private usersService : UsersService, private router : Router) { }

  ngOnInit(): void {
      if (localStorage.getItem('token')) {
          this.router.navigateByUrl('/account')
      }
  }

  register () {
      const emailRegex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*/

      this.error = ''

      if (!this.email || !this.email.match(emailRegex)) {
          this.error = "Email is not valid"
          return
      }

      if (this.password != this.passwordConfirm) {
          this.error = "Passwords do not match"
          return
      }

      this.usersService.register(
          this.username, this.password, this.email, this.email, this.address, this.phone).subscribe((token : Token) => {
              localStorage.setItem('token', token.token);
              this.router.navigateByUrl('/account').then(() => window.location.reload())
          }, (error : ErrorEvent) => {
              this.error = error.error
          })
  }
}
