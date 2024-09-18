package ru.otus.cars

sealed class TankMouth(val fuelType: FuelType,
                       val tank: Tank) {
    protected var isOpened: Boolean = false

    fun open() {
        isOpened = true
        println("$fuelType tank mouth opened")
    }

    fun close() {
        isOpened = false
        println("$fuelType tank mouth closed")
    }

    abstract fun fuelTank(fuelType: FuelType, liters: Int)
}