package ru.otus.cars

interface Tank {
    fun getContents(): Int
    fun receiveFuel(liters: Int)
}