import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from './models/user';
import { UsersService } from './services/users.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend';
  public term : any
  public isTokenThere : boolean
  isAdmin = false
  user : any;
  

  constructor(private usersService : UsersService,private router: Router) {
      console.log("Token:  " + localStorage.getItem('token'));
      this.isTokenThere = localStorage.getItem('token') != null
  }

  ngOnInit(): void {
    if (!localStorage.getItem('token')) {
        this.router.navigateByUrl('/login')
        return
    }

    this.usersService.getUserByToken().subscribe((user : User) => {
        this.user = user
        this.isAdmin = user.admin
        
    }, (error : ErrorEvent) => {
        console.log(error)
    })
}
  search () {
      this.router.navigate(["/shop", this.term]).then(() => window.location.reload())
  }

}
