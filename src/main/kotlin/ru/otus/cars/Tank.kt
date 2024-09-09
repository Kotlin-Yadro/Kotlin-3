package ru.otus.cars

interface Tank {
    fun getContents(): Double
    fun receiveFuel(liters: Int)
}