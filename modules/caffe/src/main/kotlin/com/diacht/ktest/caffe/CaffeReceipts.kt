package com.diacht.ktest.caffe

import com.diacht.ktest.*
import java.util.concurrent.TimeUnit

object CaffeReceipts {
    val EspressoReceipt = Receipt(
        products = listOf(
            Product(type = COFFEE, 7),
            Product(type = WATER, 25)
        ),
        time = 5,
        timeUnit = TimeUnit.SECONDS,
        outProductType = ESPRESSO,
        price = 25
    )

    val AmericanoReceipt = Receipt(
        products = listOf(
            Product(type = COFFEE, 7),
            Product(type = SUGAR, 7),
            Product(type = WATER, 120)
        ),
        time = 6,
        timeUnit = TimeUnit.SECONDS,
        outProductType = AMERICANO,
        price = 30
    )

    val CappuccinoReceipt = Receipt(
        products = listOf(
            Product(type = MILK, 50),
            Product(type = COFFEE, 9),
            Product(type = SUGAR, 7),
            Product(type = WATER, 110)
        ),
        time = 10,
        timeUnit = TimeUnit.SECONDS,
        outProductType = CAPPUCCINO,
        price = 30
    )

    val AmericanoMilkReceipt = Receipt(
        products = listOf(
            Product(type = MILK, 30),
            Product(type = COFFEE, 7),
            Product(type = SUGAR, 14),
            Product(type = WATER, 90)
        ),
        time = 8,
        timeUnit = TimeUnit.SECONDS,
        outProductType = AMERICANO_WI_MILK,
        price = 35
    )

    val LateReceipt = Receipt(
        products = listOf(
            Product(type = MILK, 150),
            Product(type = COFFEE, 10),
            Product(type = SUGAR, 14),
            Product(type = WATER, 50)
        ),
        time = 10,
        timeUnit = TimeUnit.SECONDS,
        outProductType = LATE,
        price = 40
    )

    val CacaoReceipt = Receipt(
        products = listOf(
            Product(type = MILK, 180),
            Product(type = SUGAR, 25),
            Product(type = WATER, 30),
            Product(type = CACAO_POWDER, 13)
        ),
        time = 9,
        timeUnit = TimeUnit.SECONDS,
        outProductType = CACAO_DRINK,
        price = 40
    )

    fun getReceipt(type: ProductType): Receipt? {
        return when (type) {
            ESPRESSO -> EspressoReceipt
            AMERICANO -> AmericanoReceipt
            CAPPUCCINO -> CappuccinoReceipt
            AMERICANO_WI_MILK -> AmericanoMilkReceipt
            LATE -> LateReceipt
            CACAO_DRINK -> CacaoReceipt
            else -> null
        }
    }
}