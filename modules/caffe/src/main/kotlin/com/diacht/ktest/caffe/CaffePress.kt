package com.diacht.ktest.caffe

import com.diacht.ktest.Machine
import com.diacht.ktest.Product
import com.diacht.ktest.Receipt
import com.diacht.ktest.Storage

class CaffePress(storage: Storage) : Machine(storage) {

    override fun makeDrink(receipt: Receipt): Product {
        // Використовуємо реалізацію Machine (спільну логіку)
        return super.makeDrink(receipt)
    }
}
