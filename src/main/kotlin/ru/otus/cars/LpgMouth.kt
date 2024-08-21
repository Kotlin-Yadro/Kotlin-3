package ru.otus.cars

class LpgMouth(private val tank: Tank) : TankMouth {
    private var isOpened: Boolean = false

    override fun open() {
        println("Люк газовой заправки открыт")
        isOpened = true
    }

    override fun close() {
        println("Люк газовой заправки закрыт")
        isOpened = false
    }

    fun fuelLpg(liters: Int) {
        if (!isOpened) {
            throw Throwable("TankMouth closed")
        }

        tank.receiveFuel(liters)
    }
}
