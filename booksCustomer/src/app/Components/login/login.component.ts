import { Component, OnInit } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { Token } from 'src/app/models/token';

import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
    public username: any;
    public password : any;
    public error : any;

    constructor(private usersService : UsersService, private router : Router) { }

    ngOnInit(): void {
        if (localStorage.getItem('token')) {
            this.router.navigateByUrl('/account')
        }
    }

    logIn () {
        this.error = ''

        this.usersService.login(
            this.username, this.password).subscribe((token : Token) => {
                localStorage.setItem('token', token.token);
                this.router.navigateByUrl('/shop').then(() => window.location.reload())
            }, (error : ErrorEvent) => {
                console.log(error);
                this.error = "Nom d'utilisateur ou mot de pass incorrect"
            })
        
    }
}
