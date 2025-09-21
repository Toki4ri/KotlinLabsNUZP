import com.diacht.ktest.compose.startTestUi
import org.example.helloworld.BuildConfig
import kotlin.math.*

fun seed(): String = "Toki4ri"

fun labNumber() : Int = BuildConfig.LAB_NUMBER

fun main(args: Array<String>) {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")
    startTestUi(seed(), labNumber())
}

/*Завдання 1. iCalculate() = sqrt(x0^2 + x1^2 + x2^2 + x3^2)*/
fun iCalculate(
    x0: Int = -88,
    x1: Int = -91,
    x2: Int = -127,
    x3: Int = 40
): Double {
    return sqrt((x0 * x0 + x1 * x1 + x2 * x2 + x3 * x3).toDouble())
}

/*Завдання 2. dCalculate() = кубічний корінь з (|x0| + |x1| + |x2| + |x3| + |x4|)*/
fun dCalculate(
    x0: Double = -70.84,
    x1: Double = -65.72,
    x2: Double = -134.56,
    x3: Double = -1.74,
    x4: Double = 5.32
): Double {
    val sum = abs(x0) + abs(x1) + abs(x2) + abs(x3) + abs(x4)
    return sum.pow(1.0 / 3.0)   // кубічний корінь
}

/*Завдання 3. strCalculate() рахує кількість неспівпадінь між x0 та x1
*тільки для символів T і C у x0.*/
fun strCalculate(x0: String, x1: String): Int {
    var result = 0
    val half = x0.length / 2

    for (i in x0.indices) {
        val c0 = x0[i]
        val c1 = x1[i]

        if (c0 == 'T' || c0 == 'C') {
            if (c0 != c1) {
                result += if (i < half) 2 else 1
            }
        }
    }
    return result
}