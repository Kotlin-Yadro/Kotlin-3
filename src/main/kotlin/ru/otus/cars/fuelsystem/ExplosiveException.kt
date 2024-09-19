package ru.otus.cars.fuelsystem

class ExplosiveException(private val fuelType: Fuel): Exception() {
    override val message: String
        get() = "\'$fuelType\' fuel type is expected... Got wrong fuel... o_O\nBoom!!!"
}