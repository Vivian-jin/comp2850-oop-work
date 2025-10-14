// Task 5.2.1: geometric properties of circles
import kotlin.math.PI
fun circleArea(radius: Double) = PI * radius * radius
fun circlePerimeter(radius: Double) = PI * 2 * radius
fun readDouble(prompt:String): Double{
    print(prompt)
    val input=readLine()
    return input?.toDoubleOrNull() ?: 0.0
}
fun main(){
    val radius=readDouble("Enter the radius:")
    val area=circleArea(radius)
    val perimeter=circlePerimeter(radius)

    println("Area = %.4f".format(area))
    println("Perimeter =%.4f".format(perimeter))
}

