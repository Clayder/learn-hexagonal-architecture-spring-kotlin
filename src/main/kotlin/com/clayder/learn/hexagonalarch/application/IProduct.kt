package com.clayder.learn.hexagonalarch.application

interface IProduct {
    fun isValid(): Boolean
    fun enable(): Unit
    fun disable(): Unit
    fun getId(): String
    fun getName(): String?
    fun getStatus(): String
    fun getPrice(): Float?
}