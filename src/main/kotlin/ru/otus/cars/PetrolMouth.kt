package ru.otus.cars

class PetrolMouth(val tank: Tank) : TankMouth {
    private var isOpened: Boolean = false

    override fun open(): Unit {
        println("Люк безина открыт")
        isOpened = true
    }

    override fun close(): Unit {
        println("Люк безина закрыт")
        isOpened = false
    }

    fun fuelPetrol(liters: Int) : Unit {
        if (!isOpened) {
            throw Throwable("TankMouth closed")
        }

        tank.receiveFuel(liters)
    }
}
