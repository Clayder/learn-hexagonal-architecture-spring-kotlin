package com.clayder.learn.hexagonalarch.application

import java.util.UUID

interface IProduct {
    fun isValid(): Boolean
    fun enable(): Unit
    fun disable(): Unit
    fun getId(): UUID
    fun getName(): String?
    fun getStatus(): String
    fun getPrice(): Float?
}