package org.kotlin.playground

/**
 * Let's talk about functions!
 */
fun main() {

    //Arguments, return type, body.
    //If you use {} to declare function you MUST
    //indicate return type, unless it is Unit.
    fun logSmth(s: String) {
        println(s)
    }

    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    println(sum(3, 5))


    //Using names args and defaults
    fun sum2(a: Int = 0, b: Int): Int {
        return a + b
    }

    println(sum2(3, 4))
    println(sum2(b = 2))

    fun printSomething(toPrint: String, prefix: String = "[default]") {
        println("$prefix:$toPrint")
    }

    printSomething("hello")
    printSomething("hello", "world")

    //Single expression functions could be simplified
    fun sum3(a: Int, b: Int): Int = a + b

    val usernames = mutableListOf("Alice", "Bob", "Charlie")
    val emails = mutableListOf("alice@mail.com", "bob@mail.com", "charlie@mail.com")

    //Early returns
    fun checkNameAndEmail(username: String, email: String): String {
        if (usernames.contains(username)) {
            return "Username is already taken"
        }

        if (emails.contains(email)) {
            return "Email is already in use"
        }

        usernames.add(username)
        emails.add(email)

        return "New user has been added!"
    }

    val result = checkNameAndEmail("Alice", "a1lice@mail.com")
    println(result)

    /**
     * And everyone's favorite LAMBDAs!
     * Lambda expressions are written within curly braces {}
     * Within the lambda expression, you write:
     * The parameters followed by an ->.
     * The function body after the ->.
     */

    val sumLambda: (Int, Int) -> Int = { x: Int, y: Int ->
            val result = x + y
            println("result is $result")
            result
    }
    println(sumLambda(3, 9))

    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    /**
     * Lambda expressions can be used in a number of ways. You can:
     * 1. Pass a lambda expression as a parameter to another function
     * 2. Return a lambda expression from a function
     * 3. Invoke a lambda expression on its own
     */

    //Parameter example
    val evenFilter = { x: Int -> x % 2 == 0 }
    println(list.filter(evenFilter))

    val doubled = { x: Int -> x * 2 }
    println(list.map(doubled))

    //Function types
    val tripled: (Int) -> Int = { x -> x * 3 }

    //Return from function.
    fun toSeconds(time: String): (Int) -> Int = when (time) {
        "hour" -> { value -> value * 60 * 60 }
        "minute" -> { value -> value * 60 }
        "second" -> { value -> value }
        else -> { value -> value }
    }

    println("Seconds: ${toSeconds("hour")(1)}")

    //Could be used for partial application.
    val sumWithOne: (Int) -> Int = { value -> sum(1, value) }
    println("Sum with one for 5 is: ${sumWithOne(5)}")

    //Invoking lambdas

    println({ text: String -> text.uppercase() }("lowercased text?"))

    //Trailing lambdas
    list.fold(0) { a, b -> a + b } //vs
    list.fold(0, { a, b -> a + b })

    /**
     * Extension functions.
     * Kotlin provides the ability to extend a class or an interface with
     * new functionality without having to inherit from
     * the class or use design patterns such as Decorator.
     * This is done via special declarations called extensions.
     */
    fun String.isEneco(): Boolean {
        return this == "Eneco"
    }

    println("Hello World".isEneco())
    println("Eneco".isEneco())
}

fun String.interesting() {
    println("interesting")
}
