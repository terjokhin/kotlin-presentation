package org.kotlin.playground

import kotlinx.coroutines.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory

val log: Logger = LoggerFactory.getLogger("Coroutines")

fun main() = runBlocking {
    helloWorld()

    val job = launch {
        log.info("Long job is starting.")
        delay(5000)
        log.info("Long job is done.")
    }

    job.join()

    val deferredJob = async(Dispatchers.Default) {
        loadData()
    }

    val result = deferredJob.await()
    log.info(result.toString())
}

suspend fun loadData(): List<Int> {
    for (n in 1..5) {
        delay(1000)
        log.info("Loading $n")
    }
    return listOf(1, 2, 3, 4, 5)
}

suspend fun printSomeInfo() = coroutineScope {
    log.info("I'm here!")
}

suspend fun helloWorld() = coroutineScope {
    launch {
        log.info("World!")
    }
    log.info("Hello, ")
}
