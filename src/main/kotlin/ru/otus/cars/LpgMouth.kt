package ru.otus.cars

open class LpgMouth(private val tank: Tank) : TankMouth {
    private var isOpened: Boolean = false

    override fun open(): Unit {
        println("Люк газовой заправки открыт")
        isOpened = true
    }

    override fun close(): Unit {
        println("Люк газовой заправки закрыт")
        isOpened = false
    }

    fun fuelLpg(liters: Int) : Unit {
        if (!isOpened) {
            throw Throwable("TankMouth closed")
        }

        tank.receiveFuel(liters)
    }
}
