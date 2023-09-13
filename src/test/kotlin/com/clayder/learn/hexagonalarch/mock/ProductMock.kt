package com.clayder.learn.hexagonalarch.mock

import com.clayder.learn.hexagonalarch.application.DISABLED
import com.clayder.learn.hexagonalarch.application.ENABLED
import com.clayder.learn.hexagonalarch.application.Product
import java.util.UUID

class ProductMock {

    private var id: UUID = UUID.randomUUID()
    private var name: String = "TV"
    private var price: Float? = 800f
    private var status: String = ENABLED

    fun withDisabledStatus(): ProductMock = this.apply {
        status = DISABLED
    }

    fun withPriceZero(): ProductMock = this.apply {
        price = 0f
    }

    fun withPriceNull(): ProductMock = this.apply {
        price = null
    }

    fun withNegativePrice(): ProductMock = this.apply {
        price = -1f
    }

    fun withInvalidStatus(): ProductMock = this.apply {
        status = "XPTO"
    }

    fun withEmptyStatus(): ProductMock = this.apply {
        status = ""
    }

    fun build(): Product {
        return Product(id, name, price, status)
    }

}