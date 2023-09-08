package com.clayder.learn.hexagonalarch.mock

import com.clayder.learn.hexagonalarch.application.DISABLED
import com.clayder.learn.hexagonalarch.application.ENABLED
import com.clayder.learn.hexagonalarch.application.Product

class ProductMock {

    private var id: String = "12345"
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

    fun build(): Product {
        return Product(id, name, price, status)
    }

}