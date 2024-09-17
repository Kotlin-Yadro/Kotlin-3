package ru.otus.cars

interface Tank {
    fun getContent(): Int
    fun receiveFuel(liters: Int)
}