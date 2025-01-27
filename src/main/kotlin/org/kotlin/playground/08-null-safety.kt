package org.kotlin.playground

/**
 * Famous Null safety.
 */
fun main() {

    /**
     * Nullable types
     */

    var stringCannotBeNull: String = "Not Nullable"
    //Compiler will complain:
    //stringCannotBeNull = null

    var nullableString: String? = "Not Null"
    //That's ok. To some degree of course.
    nullableString = null

    //This function won't accept null as arg
    fun ppp(input: String) {
        println(input)
    }
    //Compiler will complain
    //ppp(null)

    fun checkIfNullOrEmpty(input: String?): String {
        return when {
            input == null -> "Value is null"
            input.isEmpty() -> "Value is empty"
            else -> "Value length is ${input.length}"
        }
    }

    println(checkIfNullOrEmpty(nullableString))
    println(checkIfNullOrEmpty(""))
    println(checkIfNullOrEmpty("Hello World!"))


    /**
     * Safe calls
     *
     * To safely access properties of an object that might contain a null value,
     * use the safe call operator ?.
     * The safe call operator returns null if either the object
     * or one of its accessed properties is null.
     * This is useful if you want to avoid the presence of
     * null values triggering errors in your code.
     */

    fun stringLength(string: String?): Int? {
        return string?.length
    }

    println(stringLength(null))

    /**
     * Elvis operator
     */
    val result = nullableString ?: "default string"
    println(result)
}