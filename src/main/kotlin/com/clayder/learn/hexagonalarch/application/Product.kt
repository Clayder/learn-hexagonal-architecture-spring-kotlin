package com.clayder.learn.hexagonalarch.application

const val DISABLED = "DISABLED"
const val ENABLED = "ENABLED"

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
            throw Exception("The price must be grater than zero to enable the product")
        }
        this.status = ENABLED
    } ?: throw Exception("The price must be grater than zero to enable the product")

    override fun disable() {
        TODO("Not yet implemented")
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