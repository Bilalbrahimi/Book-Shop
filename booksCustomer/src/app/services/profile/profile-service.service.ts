import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { observable, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProfileServiceService implements CanActivate{

  apiUrl= "api/customers/connected/";
  profile: any;
  mail!: String; 
  mdp!: String;

  constructor(private http: HttpClient, private router: Router) { }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
    throw new Error('Method not implemented.');
  }

}


/*
export class ProfileServiceService implements CanActivate{

  apiUrl= "api/customers/connected/";
  profile: any;
  mail!: String; 
  mdp!: String;

  constructor(private http: HttpClient, private router: Router) { }


  getProfile(){
    return new Observable((observer) => {
      if(this.profile){
        observer.next(this.profile);
        observer.complete;
      }else{
        this.http.get(`${this.apiUrl}${this.mail}/${this.mdp}`).subscribe(profile => {
          this.profile = profile;
          observer.next(profile);
          observer.complete;
        }, error => {
          observer.error(error);
          observer.complete;  
        })
      }
    })
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean>{
    return new Observable((observer) => {
      this.getProfile().subscribe(profile => {
        observer.next(true);
        observer.complete();
      }, error => {
          this.router.navigate(['/login']);
          observer.next(false);
          observer.complete();
      })
    })
  }
}

*/