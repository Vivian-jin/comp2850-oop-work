// Task 5.4.1: string extension function
val String.tooLong: Boolean
    get() = this.length > 20
fun main(){
    print("Enter a string:")
    val input =readln()
    if (input.tooLong){
        println("That string is too long!")
    }else{
        println("that string is fine.")
    }
}
