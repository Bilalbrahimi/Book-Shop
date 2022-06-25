import { Byte } from "@angular/compiler/src/util"
import { Commande } from "./commande";

export interface Book {

    id : Number
    name : string
    description : string
    price : Number
    addedOn : Date
    image : [Byte]
    imageUrl : string
    author : string
    editor : string
    ean : string
    isbn : string
    commande: Commande

}
