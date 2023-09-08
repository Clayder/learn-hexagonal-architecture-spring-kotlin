package com.clayder.learn.hexagonalarch.application

import com.clayder.learn.hexagonalarch.mock.ProductMock
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class ProductTest {

    @Test
    fun `Enable product with success`() {
        val product: Product = ProductMock().build()
        product.enable()

        assertEquals(ENABLED, product.getStatus())
    }

    @ParameterizedTest
    @MethodSource("productsWithPriceNullOrZero")
    fun `Throw exception when enable product with price null or zero`(product: Product) {

        val exception = Assertions.assertThrows(Exception::class.java) {
            product.enable()
        }

        assertEquals("The price must be greater than zero to enable the product", exception.message)
    }

    @ParameterizedTest
    @MethodSource("productsWithPriceNullOrZero")
    fun `Disable product with success`(product: Product) {
        product.disable()

        assertEquals(DISABLED, product.getStatus())
    }

    @Test
    fun `Throw exception when disable product with price different null or zero`() {

        val product: Product = ProductMock().build()

        val exception = Assertions.assertThrows(Exception::class.java) {
            product.disable()
        }

        assertEquals("The price must be zero or null to have the product disabled", exception.message)
    }
    
    companion object {
        @JvmStatic
        fun productsWithPriceNullOrZero() = listOf(
            Arguments.of(ProductMock().withPriceNull().build()),
            Arguments.of(ProductMock().withPriceZero().build()),
        )
    }
}