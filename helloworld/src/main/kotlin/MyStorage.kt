import com.diacht.ktest.Product
import com.diacht.ktest.ProductType
import com.diacht.ktest.Storage

class MyStorage : Storage {

    private val products = mutableMapOf<ProductType, Int>()

    override fun addProduct(product: Product) {
        val current = products.getOrDefault(product.type, 0)
        products[product.type] = current + product.count
    }

    override fun checkProductCount(type: ProductType): Int {
        return products[type] ?: 0
    }

    override fun getProduct(productType: ProductType, count: Int): Product {
        val current = products.getOrDefault(productType, 0)

        if (current < count)
            throw IllegalStateException("Not enough $productType in storage")

        products[productType] = current - count

        return Product(productType, count)
    }

    override fun getLeftovers(): List<Product> {
        return products.map { Product(it.key, it.value) }
    }

    override fun resetSimulation() {
        products.clear()
    }
}
