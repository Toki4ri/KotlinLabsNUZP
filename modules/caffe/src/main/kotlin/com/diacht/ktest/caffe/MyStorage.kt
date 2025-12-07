package com.diacht.ktest.caffe

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
        return products.getOrDefault(type, 0)
    }

    override fun getProduct(productType: ProductType, count: Int): Product {
        val currentCount = products.getOrDefault(productType, 0)

        if (currentCount < count) {
            throw IllegalStateException("Not enough product: $productType. Required: $count, Available: $currentCount")
        }
        products[productType] = currentCount - count

        return Product(type = productType, count = count)
    }

    override fun getLeftovers(): List<Product> {
        return products.map { (type, count) ->
            Product(type = type, count = count)
        }

    }

    override fun resetSimulation() {
        products.clear()
    }
}
