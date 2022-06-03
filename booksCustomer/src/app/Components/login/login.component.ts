import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SessionLoginService } from 'src/app/services/session/session-login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email='';
  password='';
  wrongCredentials = false;
  session = {};

  constructor(private sessionLogin : SessionLoginService, private router : Router) { }

  ngOnInit(): void {
  }

  login(){
    /*
    this.sessionLogin.login(this.email,this.password).subscribe(result => {
      this.router.navigate(['/'])
    })
    */
    this.session = this.sessionLogin.connect(this.email,this.password);
    if(this.session == {}){
      this.wrongCredentials = true;
    }else{
      this.router.navigate(['/'])
      
    }

    
  }

}
