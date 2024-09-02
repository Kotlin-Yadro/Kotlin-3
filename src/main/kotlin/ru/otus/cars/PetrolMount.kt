package ru.otus.cars

class PetrolMouth(private val tank: FuelTank) : TankMouth {
    private var isOpened: Boolean = false

    override fun open() {
        println("petrol mount opened")
        isOpened = true
    }

    override fun close() {
        println("petrol mount closed")
        isOpened = false
    }

    fun loadPetrol(liters: Int) {
        if (!isOpened) {
            throw Throwable("TankMouth closed")
        }

        tank.loadFuel(liters)
    }

    override fun toString(): String {
        return "petrol " + this.tank.fulfilnessLiters
    }
}