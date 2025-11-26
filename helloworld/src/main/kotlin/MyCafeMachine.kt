import com.diacht.ktest.*

class MyCafeMachine(
    private val storage: Storage
) : Machine() {

    fun makeDrink(receipt: Receipt): Product {

        receipt.products.forEach {
            storage.getProduct(it.type, it.count)
        }

        return Product(receipt.outProductType, 1)
    }

    override fun getLeftovers(): List<Product> = emptyList()

    override fun resetSimulation() { }
}
