fun main() {
    
    println("PIZZA MENU\n")
    println("(a) Margherita")
    println("(b) Quattro Stagioni")
    println("(c) Seafood")
    println("(d) Hawaiian")

    var choice: String 

    
    do {
        print("\nChoose your pizza (a-d): ")
        choice = readln().lowercase() 

       
        if (choice.length == 1 && choice[0] in 'a'..'d') {
            println("Order accepted") 
            break                      
        } else {
            println("Invalid choice! Please try again.")
        }

    } while (true) 
}
