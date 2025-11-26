import com.diacht.ktest.Product
import com.diacht.ktest.ProductType
import com.diacht.ktest.Receipt
import java.util.concurrent.TimeUnit

object EspressoReceipt : Receipt(
    products = listOf(
        Product(ProductType.COFFEE, 7),
        Product(ProductType.WATER, 25)
    ),
    time = 5,
    timeUnit = TimeUnit.SECONDS,
    outProductType = ProductType.ESPRESSO,
    price = 25
)

object AmericanoReceipt : Receipt(
    products = listOf(
        Product(ProductType.COFFEE, 7),
        Product(ProductType.WATER, 120)
    ),
    time = 6,
    timeUnit = TimeUnit.SECONDS,
    outProductType = ProductType.AMERICANO,
    price = 30
)

object CappuccinoReceipt : Receipt(
    products = listOf(
        Product(ProductType.COFFEE, 9),
        Product(ProductType.MILK, 50),
        Product(ProductType.WATER, 110)
    ),
    time = 10,
    timeUnit = TimeUnit.SECONDS,
    outProductType = ProductType.CAPPUCCINO,
    price = 30
)

object AmericanoMilkReceipt : Receipt(
    products = listOf(
        Product(ProductType.COFFEE, 7),
        Product(ProductType.MILK, 30),
        Product(ProductType.SUGAR, 7),
        Product(ProductType.WATER, 90)
    ),
    time = 8,
    timeUnit = TimeUnit.SECONDS,
    outProductType = ProductType.AMERICANO_WITH_MILK,
    price = 35
)

object LateReceipt : Receipt(
    products = listOf(
        Product(ProductType.COFFEE, 10),
        Product(ProductType.MILK, 150),
        Product(ProductType.WATER, 50)
    ),
    time = 10,
    timeUnit = TimeUnit.SECONDS,
    outProductType = ProductType.LATE,
    price = 40
)

object CacaoReceipt : Receipt(
    products = listOf(
        Product(ProductType.CACAO_POWDER, 13),
        Product(ProductType.MILK, 180),
        Product(ProductType.WATER, 30),
        Product(ProductType.SUGAR, 25)
    ),
    time = 9,
    timeUnit = TimeUnit.SECONDS,
    outProductType = ProductType.CACAO_DRINK,
    price = 40
)

object Receipts {
    val list = listOf(
        EspressoReceipt,
        AmericanoReceipt,
        CappuccinoReceipt,
        AmericanoMilkReceipt,
        LateReceipt,
        CacaoReceipt
    )
}
