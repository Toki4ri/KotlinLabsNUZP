import com.diacht.ktest.*


class MyCafeFactory : FactoryItf() {

    private val storage = MyStorage()
    private val machine = MyCafeMachine(storage)

    private val orderHistory = mutableListOf<ProductType>()

    override fun resetSimulation() {
        storage.resetSimulation()
        machine.resetSimulation()
        orderHistory.clear()
    }

    override fun loadProducts(productsFromSupplier: List<Product>) {
        productsFromSupplier.forEach { storage.addProduct(it) }
    }

    override fun order(order: List<Pair<ProductType, Int>>): List<Product> {

        val result = mutableListOf<Product>()

        order.forEach { (drinkType, count) ->

            repeat(count) {
                orderHistory += drinkType

                val receipt = Receipts.list.firstOrNull { it.outProductType == drinkType }
                    ?: throw IllegalStateException("Unknown drink: $drinkType")

                result += machine.makeDrink(receipt)
            }
        }

        return result
    }

    override fun getLeftovers(): List<Product> {
        return storage.getLeftovers()
    }

    // -------------------------
    // Завдання №2 — getPopularDrink()
    // -------------------------
    override fun getPopularDrink(): Product {
        if (orderHistory.isEmpty())
            return Product(ProductType.NONE, 0)

        val grouped = orderHistory.groupingBy { it }.eachCount()

        val max = grouped.maxBy { it.value }

        return Product(max.key, max.value)
    }
}
