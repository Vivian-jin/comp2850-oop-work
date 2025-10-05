fun main(){
    println("PIZZA MENU\n")
    println("(a) Margherita")
    println("(b) Quattro Stagioni")
    println("(c) Seafood")
    println("(d) Hawaiian")

    print("\nChoose your pizza (a-d): ")

    val choice = readln().lowercase() 

    val message = if (choice.length == 1 && choice[0] in 'a'..'d') {
        "Order accepted"
    } else {
        "Invalid choice!"
    }

    println(message)
}