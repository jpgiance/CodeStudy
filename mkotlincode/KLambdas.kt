package mkotlincode
fun main() {
    val treatFunction = trickOrTreat(false) { "$it quarters" }
    val treatFunction2 = trickOrTreat(false) { parameter ->
        "$parameter quarters"
    }
    val trickFunction = trickOrTreat(true, null)
    repeat(4) {
        treatFunction()
    }
    trickFunction()
    treatFunction2
}

fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    return if (isTrick) {
        trick
    } else {
        if (extraTreat != null) {
            println(extraTreat(5))
        }
        treat
    }
}

val trick = {
    println("No treats!")
}

val treat = {
    println("Have a getTreat!")
}