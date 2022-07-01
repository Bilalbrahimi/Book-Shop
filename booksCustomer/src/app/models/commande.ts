import { Book } from "./book";
import { User } from "./user";

export class Commande {
    constructor(
        public commandeId : number,
        public date : Date,
        public userName : String, 
        public name : String, 
        public adresse : String, 
        public message : String, 
        public etat : number,
        public books : Book[],
        public lBooks : String,
        public quantities : String,
        public totalPrice : number,
    ){}
}
