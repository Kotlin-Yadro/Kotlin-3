package ru.otus.cars

interface Tank {
    val mouth: TankMouth
    fun getContents(): Int
    fun receiveFuel(liters: Int)
}