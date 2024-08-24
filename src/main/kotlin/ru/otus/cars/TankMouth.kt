package ru.otus.cars

sealed class TankMouth: Tank {
    class PetrolMouth : TankMouth()
    class GasMouth : TankMouth()
    class TazMouth : TankMouth() {
        override fun receiveFuel(liters: Int) {
            throw NotImplementedError("Кабадумммм")
        }
    }

    private var mouthState: Boolean = false

    private var currentFuelLevel: Int = 0

    open fun open() {
        mouthState = true
    }

    open fun close() {
        mouthState = false
    }

    open fun isOpen(): Boolean {
        return mouthState
    }

    override fun getContents(): Int {
        return currentFuelLevel
    }

    override fun receiveFuel(liters: Int) {
        if (liters > 0) currentFuelLevel = liters
    }
}