import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CartComponent } from './Components/cart/cart.component';
import { LoginComponent } from './Components/login/login.component';
import { BookDetailComponent } from './Components/book-detail/book-detail.component';
import { BookListComponent } from './Components/book-list/book-list.component';
import { RegisterComponent } from './Components/register/register.component';
import { UserDetailComponent } from './Components/user-detail/user-detail.component';
import { UserListComponent } from './Components/user-list/user-list.component';
import { PaiementComponent } from './Components/paiement/paiement.component';
import { CommandeComponent } from './Components/commande/commande.component';
import { CommandeListComponent } from './Components/commande-list/commande-list.component';
import { BookListAdminComponent } from './Components/book-list-admin/book-list-admin.component';
import { BookDetailAdminComponent } from './Components/book-detail-admin/book-detail-admin.component';
import { HistoriqueClientComponent } from './Components/historique-client/historique-client.component';
import { RegisterAdminComponent } from './Components/register-admin/register-admin.component';


const routes: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'register', component: RegisterComponent},
  {path: 'registerAdmin', component: RegisterAdminComponent},
  {path: 'login', component: LoginComponent},
  {path: 'shop', component: BookListComponent},
  {path: 'shop/:term', component: BookListComponent},
  {path: 'shop/books/:id', component: BookDetailComponent},
  {path: 'account', component: UserDetailComponent},
  {path: 'cart', component: CartComponent},
  {path: 'users', component: UserListComponent},
  {path: 'paiement', component: PaiementComponent},
  {path: 'commande/:id', component: CommandeComponent},
  {path: 'commandeList', component: CommandeListComponent},
  {path: 'addBook', component: BookListAdminComponent},
  {path: 'bookDetailAdmin/:id', component: BookDetailAdminComponent},
  {path: 'historique', component: HistoriqueClientComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }


