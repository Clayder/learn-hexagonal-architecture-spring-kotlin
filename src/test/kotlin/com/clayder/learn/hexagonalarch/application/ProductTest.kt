package com.clayder.learn.hexagonalarch.application

import com.clayder.learn.hexagonalarch.mock.ProductMock
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ProductTest {

    @Test
    fun `Enable product with success`() {
        val product: Product = ProductMock().build()
        product.enable()

        assertEquals(ENABLED, product.getStatus())
    }

    @Test
    fun `Throw exception when enable product with price is null`() {
        val product: Product = ProductMock().withPriceNull().build()

        val exception = Assertions.assertThrows(Exception::class.java) {
            product.enable()
        }

        assertEquals("The price must be grater than zero to enable the product", exception.message)
    }

    @Test
    fun `Throw exception when enable product with price is zero`() {
        val product: Product = ProductMock().withPriceZero().build()

        val exception = Assertions.assertThrows(Exception::class.java) {
            product.enable()
        }

        assertEquals("The price must be grater than zero to enable the product", exception.message)
    }
}