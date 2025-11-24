import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import java.net.URL
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.sqrt

// Отримання одного числа з сервера
suspend fun getNumberFromServer(msg: String): Int =
    withContext(Dispatchers.IO) {
        val url = URL("http://diacht.2vsoft.com/api/send-number?message=$msg")
        val connection = url.openConnection()
        connection.connect()

        val input = connection.getInputStream()
        val buffer = ByteArray(128)
        val bytesRead = input.read(buffer)
        input.close()

        String(buffer, 0, bytesRead).toInt()
    }

// Основна функція лабораторної
suspend fun serverDataCalculate(strList: List<String>): Double = coroutineScope {

    // Створюємо список корутин, які паралельно отримують дані
    val deferredValues = strList.map { message ->
        async { getNumberFromServer(message) }
    }

    // Чекаємо всі відповіді від сервера
    val values = deferredValues.awaitAll()

    // Шукаємо максимум серед модулів
    val maxAbs = values.map { abs(it) }.max()

    // Формула: sqrt(max(|x_i|))
    sqrt(maxAbs.toDouble())
}
