import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Commande } from 'src/app/models/commande';

import { CommandeService } from 'src/app/services/commande.service';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-commande-client',
  templateUrl: './commande-client.component.html',
  styleUrls: ['./commande-client.component.css']
})
export class CommandeClientComponent implements OnInit {

  public commande : any
  public books:String[] = [];
  public quantities:String[] = [];
  commande_apr_etat : any;
  
  
  constructor(private router : Router, private commandeServices : CommandeService, private usersService : UsersService,private route : ActivatedRoute) { }

  ngOnInit(): void {
    if (!localStorage.getItem('token')) {
      this.router.navigateByUrl('/login')
      return
    }

    this.commandeServices.getCommande(this.route.snapshot.paramMap.get('id') as string).subscribe((commande : Commande) => {
      this.commande = commande
      this.splitCommande(commande);

   }, (error : ErrorEvent) => {
      console.log(error)
  })
  }


  splitCommande(commande : Commande){
    this.books= commande.lBooks.split('_');
    this.quantities= commande.quantities.split('_');
    this.quantities.splice(-1,1);
    this.books.splice(-1,1);
    
  }

  radioChange( etat: number) {
    this.commande.etat = etat;
    let resp = this.commandeServices.editCommande(this.commande);
    resp.subscribe((data: any)=>this.commande_apr_etat=data);
    
  }


}
