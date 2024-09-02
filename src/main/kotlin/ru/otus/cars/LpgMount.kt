package ru.otus.cars


class LpgMount(private val tank: FuelTank) : TankMouth {
    private var isOpened: Boolean = false

    override fun open() {
        println("горловина открыта")
        isOpened = true
    }

    override fun close() {
        println("горловина закрыта")
        isOpened = false
    }

    fun loadNaturalGas(liters: Int) {
        if (!isOpened) {
            throw Throwable("TankMouth closed")
        }

        tank.loadFuel(liters)
    }

    override fun toString(): String {
        return "natural gas " + this.tank.fulfilnessLiters
    }
}