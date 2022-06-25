import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import {HttpClientModule } from '@angular/common/http';
import {FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReactiveFormsModule } from '@angular/forms';
import { CartComponent } from './Components/cart/cart.component';
import { LoginComponent } from './Components/login/login.component';
import { RegisterComponent } from './Components/register/register.component';
import { BookListComponent } from './Components/book-list/book-list.component';
import { BookDetailComponent } from './Components/book-detail/book-detail.component';
import { UserDetailComponent } from './Components/user-detail/user-detail.component';
import { SortDirective } from './directive/sort.directive';
import { UserListComponent } from './Components/user-list/user-list.component';
import { PaiementComponent } from './Components/paiement/paiement.component';
import { CommandeComponent } from './Components/commande/commande.component';
import { CommandeListComponent } from './Components/commande-list/commande-list.component';
import { BookDetailAdminComponent } from './Components/book-detail-admin/book-detail-admin.component';




@NgModule({
  declarations: [
    AppComponent,
    CartComponent,
    LoginComponent,
    RegisterComponent,
    BookListComponent,
    BookDetailComponent,
    UserDetailComponent,
    SortDirective,
    UserListComponent,
    PaiementComponent,
    CommandeComponent,
    CommandeListComponent,
    BookDetailAdminComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,


  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
