package ru.otus.cars

interface Tank {

    fun receiveFuel(liters: Int)
    fun getLevel(): Int
    fun consume(liters: Int) : Int
}
