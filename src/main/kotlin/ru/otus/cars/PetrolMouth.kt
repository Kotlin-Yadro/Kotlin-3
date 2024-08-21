package ru.otus.cars

class PetrolMouth(private val tank: Tank) : TankMouth {
    private var isOpened: Boolean = false

    override fun open() {
        println("Люк безина открыт")
        isOpened = true
    }

    override fun close() {
        println("Люк безина закрыт")
        isOpened = false
    }

    fun fuelPetrol(liters: Int) {
        if (!isOpened) {
            throw Throwable("TankMouth closed")
        }

        tank.receiveFuel(liters)
    }
}
