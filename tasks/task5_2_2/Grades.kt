// Task 5.2.2: conversion of marks into grades, using a function
fun grade(mark: Int) = when (mark) {
    in 0..39   -> "Fail"
    in 40..69  -> "Pass"
    in 70..100 -> "Distinction"
    else       -> "?"
}
fun main(args:Array<String>){
    for (arg in args){
        val mark=arg.toIntOrNull()
        if (mark!=null){
            println("$mark is a ${grade(mark)}")
        }else{
            println("$arg is not a valid number")
        }
    }
}
