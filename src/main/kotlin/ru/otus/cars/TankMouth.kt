package ru.otus.cars

interface TankMouth{
    fun open() {
        println("TankMouth opened")
    }
    fun close() {
        println("TankMouth closed")
    }
}
class Tank (fuelLevel : Int, type : FuelType) : TankMouth{
    val maxFuelLevel = fuelLevel
    val fuelType = type
    private var contents = 0
    fun receiveFuel(liters : Int) {
        contents = liters
    }

    fun getContents() : Int { return contents }

    enum class FuelType {FTPETROL, FTLPG, FTDISEL}
}