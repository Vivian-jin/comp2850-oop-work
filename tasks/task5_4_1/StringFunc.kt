// Task 5.4.1: string extension function
fun String.toLong():Boolean=this.length>20
fun main(){
    print("Enter a string:")
    val input =readln()
    if (input.toLong()){
        println("That string is too long!")
    }else{
        println("that string is fine.")
    }
}
