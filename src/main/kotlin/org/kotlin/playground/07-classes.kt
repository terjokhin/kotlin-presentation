package org.kotlin.playground

/**
 * Classes
 */
fun main() {

    //Class without params
    open class Simple


    class ExtendsSimple : Simple()

    val simpleClass = Simple()

    //Val, Var, Could be with default value as function arguments
    class WithParams(val counter: Int, var value: String = "Default", strangeValue: Long) {
        init {
            println("Initializing with params")
            println("StrangeValue is $strangeValue")
        }

        fun increaseCounter(): WithParams {
            return WithParams(counter.inc(), value, 2L)
        }
    }

    val withParams = WithParams(counter = 100, strangeValue = 1L)

    //Access using dot
    println("Value: ${withParams.value}")
    println("Counter: ${withParams.counter}")
    // Not accessible after creation println(withParams.strangeValue)

    val withNewParams = withParams.increaseCounter()
    println("Counter: ${withNewParams.counter}")

    /**
     * Dataclasses
     * Kotlin has data classes which are particularly useful for storing data. Data classes have the same functionality as classes, but they come automatically with additional member functions. These member functions allow you to easily print the instance to readable output, compare instances of a class, copy instances, and more. As these functions are automatically available, you don't have to spend time writing the same boilerplate code for each of your classes.
     */
    data class DataRow(val id: Int, val value: String)

    val data1 = DataRow(1, "Value1")
    val data2 = DataRow(2, "Value2")
    val data3 = DataRow(1, "Value1")

    val data4 = data1.copy(value = data2.value + data3.value)

    println(data1)
    println(data1 == data2)
    println(data1 == data3)
    println(data4)
    println(data1 == data4)

    val worker: Worker = Worker.default(5)
    worker.doWork()
    println(worker.javaClass.kotlin.simpleName)
}


interface Worker {
    fun doWork()

    companion object {
        fun default(i: Int): Worker = DefaultWorker(i)
    }
}

class DefaultWorker : Worker {
    init {
        println("Default worker being initialised")
    }

    constructor(i: Int) {
        println("Work number is $i")
    }

    override fun doWork() {
        println("Doing work.")
    }

}

open class Base {
    open fun doWork() {}
    fun dontDoWork() {
        println("Not doing anything")
    }
}

class A : Base() {
    override fun doWork() {
        println("Doing work A.")
    }
    // Compiler will complain again.
    //override fun dontDoWork() {}
}

// Compiler will complain!
class SuperDefaultWorker : DefaultWorker