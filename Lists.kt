// Do not remove or rename the package
package lists

/*
* The following functions are helper functions that I am providing
*/

//creates a list from 1 to n
fun countingNumbers(n : Int?) : List<Int>? {
    if (n == null) {
        return n
    }
    else {
        val numbers : MutableList<Int> = mutableListOf();
        for (i in 1..n) {
            numbers.add(i)
        }
        return numbers
    }
}

//returns a list from countingNumbers from 1 to n, and keeps all the even numbers
fun evenNumbers(n : Int?) : List<Int>? {
    val numbers = countingNumbers(n)
    val temp = numbers?.filter{ it % 2 == 0 }
    return temp
}

/* 
* The isPrime function takes as input an Int
*      x : an Int object to test
* and returns a Boolean
*      true  if x is a prime
*      false if x is not a prime
*/
fun isPrime(x : Int) : Boolean {
    for (i in 2..(x-1)) {
        if (x % i == 0) {
            return false
        }    
    }
    return true
}

//uses isPrime on a list from 1 to n to get all the prime numbers
fun primeNumbers(n: Int?) : List<Int>? {
    val numbers = countingNumbers(n)
    val nums = numbers?.tail
    val temp = nums?.filter{ isPrime(it) }
    return temp
}

//returns a list containing the sorted elements of two merged lists
fun<T : Comparable<T>> merge (a : List<T>?, b : List<T>?) : List<T>? {
    if (a == null || b == null) return null
    else {
        val temp : MutableList<Int> = mutableListOf()
        temp.addAll(a as MutableList<Int>)
        temp.addAll(b as MutableList<Int>)
        temp.sort()
        val nums : List<T>? = temp as List<T>?
        return nums
    }
}

//takes a list and creates sublists from it that are added into a list and returned
fun subLists(a : List<Int>?) : List<List<Int>>? {
    if (a == null) {
        return null
    }
    else{
        val temp : MutableList<MutableList<Int>> = mutableListOf()
        for (i in 1..a.size){
           val b = a.take(i)
            temp.add(b as MutableList<Int>)
        }
    	val num : List<List<Int>>? = temp
        return num
    }
}

//runs through a list of lists, calculates the size of each sublist, and adds them together
fun countElements(a : List<List<Int>?>?) : Int {
    var total = 0;
    if (a == null) {
        return 0
    }
    else if (a.size > 0) {
        for (i in a) {
            if (i != null) {
                total += i.size
            }
        }
    }
    return total
}

//applies the function f to two Ints and returns the result
fun apply (f : (a : Int, b : Int) -> Int, list : List<Int>) : Int {
    if (list.size == 1) {
        return list.get(0)
    }
    else {
        return f(list.head, apply(f, list.tail))
    }
}

//applies a function f to a list, using the apply function
fun listApply(f : (a : Int, b : Int) -> Int, list : List<List<Int>>?) : List<Int>? {
    if (list == null) {
        return list
    }
    else {
        var temp = listOf<Int>()
        for (i in list) {
            temp += listOf(apply(f, i))
        }
        return temp
    }
}

/* The compose function takes as input
*     f - A function that takes as input a value of type T and returns a value of type T
*     g - A function that takes as input a value of type T and returns a value of type T
*  and returns as output the composition of the functions
*     f(g(x))
*/
fun<T> compose(f: (T)->T,  g:(T) -> T) : (T) -> T = { f(g(it)) }

//composes a function out of the functions in a list, using the compose function
fun composeList(a : List<(Int) -> Int>) : (Int) -> Int {
    if (a.size == 1) {
        return a.get(0)
    }
    else {
        return compose(a.head, composeList(a.tail))
    }
}

/*
* Extend the List class with a "tail" getter to get the tail of a list.
* Below is an example of how you would use tail
*    val a = listOf(1,2,3)
*    val t = a.tail
*    println("tail of $a is $t") // prints [2,3]
*/
val <T> List<T>.tail: List<T>
get() = drop(1)

/*
* Extend the List class with a "head" getter to get the head of a list.
* Below is an example of how you would use head
*    val a = listOf(1,2,3)
*    val h = a.head
*    println("head of $a is $h") // prints 1
*/
val <T> List<T>.head: T
get() = first()



/* Be sure to document 
   your functions
   describing inputs and outputs and what the function does
*/
