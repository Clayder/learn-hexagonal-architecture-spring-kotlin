package com.clayder.learn.hexagonalarch.application

const val DISABLED = "DISABLED"
const val ENABLED = "ENABLED"

private const val PRICE_GREATER_THAN_ZERO = "The price must be greater than zero to enable the product"

private const val ERROR_DISABLED_PRODUCT = "The price must be zero or null to have the product disabled"

data class Product(
    private var id: String = "",
    private var name: String? = null,
    private var price: Float? = null,
    private var status: String = DISABLED
): IProduct {

    override fun isValid(): Boolean {
        TODO("Not yet implemented")
    }

    override fun enable() = price?.let {
        if (it <= 0) {
            throw Exception(PRICE_GREATER_THAN_ZERO)
        }
        status = ENABLED
    } ?: throw Exception(PRICE_GREATER_THAN_ZERO)

    override fun disable() {
        if(price != null && price != 0f ) {
            throw Exception(ERROR_DISABLED_PRODUCT)
        }
        status = DISABLED
    }

    override fun getId(): String {
        return id
    }

    override fun getName(): String? {
        return name
    }

    override fun getStatus(): String {
        return status
    }

    override fun getPrice(): Float? {
        return price
    }
}

fun main(args: Array<String>) {
    var t = Product("qwq", "assas", 0f)
    t.enable()
    var a = 1
}