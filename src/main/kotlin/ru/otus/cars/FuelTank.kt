package ru.otus.cars

/**
 * Fuel tank
 */
open class FuelTank {
    /**
     * capacity
     */
    open val capacityLiters: Int = 0

    /**
     * fulfilnessLiters
     */
    var fulfilnessLiters: Int = 0

    /**
     * getter
     */
    fun getCurrentAmount(): Int {
        return fulfilnessLiters
    }

    /**
     * Load fuel
     */
    open fun loadFuel(liters: Int): Unit {
        if (fulfilnessLiters + liters > capacityLiters) {
            throw Throwable("Overload")
        }

        fulfilnessLiters += liters
    }

    open val capacity: Int = 39
}