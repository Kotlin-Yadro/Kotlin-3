package ru.otus.cars

class BlowException: Exception("Car is blown!!!")

sealed class TankMouth : Tank {
    class LpgMouth() : TankMouth()
    class PetrolMouth() : TankMouth()
    class TazMouth() : TankMouth()

    private var isOpened = false
    private var fuelLevel = 0

    fun open() {
        isOpened = true
        println("Mouth is opened!")
    }

    fun close() {
        isOpened = false
        println("Mouth is closed!")
    }

    override fun receiveFuel(liters: Int){
        if(isOpened) {
            when (this) {
                is LpgMouth -> {
                    println("Закачиваем $liters литров газа")
                    this.fuelLevel += liters
                }
                is PetrolMouth -> {
                    println("Заливаем $liters литров бензина")
                    this.fuelLevel += liters
                }
                is TazMouth -> throw BlowException()
                else -> {
                    println("Unknown mouth type")
                }
            }
        } else {
            println("Unable to refuel: the mouth is closed")
        }
    }
    override fun getContent(): Int {
        return fuelLevel
    }
}