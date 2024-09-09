package ru.otus.cars

enum class FuelType {
    GAS, PETROL, DIESEL
}

sealed class TankMouth(val fuelType: FuelType): Tank {
    class TankMouthVaz2107: TankMouth(FuelType.GAS)
    class TankMouthVaz2108: TankMouth(FuelType.PETROL)
    class TankMouthTaz: TankMouth(FuelType.DIESEL) {
        override fun open() {
            throw NotImplementedError("Not supported... Going to explode")
        }
    }

    private var mouthState: Boolean = false

    private var currentFuelLevel: Double = 0.0

    /**
     * Scale our fuel level depending on fuel type
     */
    private val fuelScale: () -> Double = {
        when (fuelType) {
            FuelType.GAS -> 0.5
            FuelType.PETROL -> 1.0
            FuelType.DIESEL -> 0.7
        }
    }

    open fun isOpened(): Boolean {
        return mouthState
    }

    @Throws(Error::class)
    open fun open() {
        if (mouthState) {
            throw Error("Already opened")
        }
        mouthState = true
    }

    @Throws(Error::class)
    open fun close() {
        if (!mouthState) {
            throw Error("Already closed")
        }
        mouthState = false
    }

    override fun getContents(): Double {
        return currentFuelLevel
    }

    @Throws(IllegalArgumentException::class)
    override fun receiveFuel(liters: Int) {
        when {
            liters > 0 -> currentFuelLevel += (liters * fuelScale())
            liters <= 0 -> throw IllegalArgumentException("Not valid liters value")
        }
    }
}