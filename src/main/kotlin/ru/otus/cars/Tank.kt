package ru.otus.cars

interface Tank {
    fun receiveFuel(litres: Int)
    fun getContents() : Int
}