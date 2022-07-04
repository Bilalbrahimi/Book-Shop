import { Book } from "./book";

export interface CartItem {
    addedOn : Date
    quantity : number
    book : Book
    totalPrice : number
}
