import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from 'src/app/models/customer';

@Injectable({
  providedIn: 'root'
})
export class SessionLoginService {


  apiUrl= "api/customers";
  session= {};

  constructor(private http: HttpClient) { }

  connect(email: String, mdp: String){
    
    //this.http.get(`${this.apiUrl}/connected/${email}/${mdp}`).subscribe(customer => this.session = customer);
    //this.session = this.http.get<Customer>(`${this.apiUrl}/connected/${email}/${mdp}`).subscribe(customer => this.session = customer);
    this.http.get(`${this.apiUrl}/connected/${email}/${mdp}`).subscribe(customer => this.session = customer);
    
    /*if(("error" in this.session)==false){
      return this.session
      
    }else{
      return {};
    }*/
    return this.session
   }

}


/*
export class SessionLoginService {


  apiUrl= "api/";

  constructor(private http: HttpClient) { }


  login(memail : any, mpass : any){
    const loginData = {
      email : memail,
      pass : mpass
    }

    if((memail = "admin@mail.com") && (mpass = "123")){
      return new Observable<boolean>((observer) => {
        // appel http pour login 
        observer.next(true);
        observer.complete();
      });
    }else{
      return new Observable<boolean>((observer) => {
        // appel http pour login 
        observer.next(false);
        observer.complete();
      });
    }
    

  }
}

*/