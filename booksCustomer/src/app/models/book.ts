import { Byte } from "@angular/compiler/src/util"

export interface Book {

    id : Number
    name : string
    description : string
    price : Number
    addedOn : Date
    image : [Byte]
    imageUrl : string

}
