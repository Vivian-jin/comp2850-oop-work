// Task 4.5: summing odd integers with a for loop
fun main(){
    print("Please enter your limit: ")
    val limit= readLine()!!.toInt()
    var sum=0
    for (i in 1..limit){
        if (i%2 !=0){
            sum +=i
        }
        
    }
    println("The sum between 1 and $limit is $sum")
}
