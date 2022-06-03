import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BagComponent } from './Components/bag/bag.component';
import { GridBooksComponent } from './Components/grid-books/grid-books.component';
import { LoginComponent } from './Components/login/login.component';
import { ProfileServiceService } from './services/profile/profile-service.service';

const routes: Routes = [
  {path:"", component:GridBooksComponent},
  {path:"login",component:LoginComponent},
  {path:"bag",component:BagComponent},
  /*{path:"bag",component:BagComponent, canActivate:[ProfileServiceService]},*/
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }


