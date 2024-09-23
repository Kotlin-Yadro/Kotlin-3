package ru.otus.cars

/**
 *  горловина бензобака
 */
sealed class TankMouth : Tank {

    object PetrolMouth : TankMouth()
    object LgpMouth : TankMouth()
    object TazMouth : TankMouth()

    private var fuelLevel = 0

    fun open() {
        println("Открыт бак")

    }

    fun close() {
        println("Закрыт бак")

    }

    override fun getContents(): Int {
        return fuelLevel
    }

    override fun receiveFuel(liters: Int) {
        when (this) {
            is LgpMouth -> {
                println("Принимает $liters л. газа")
                this.fuelLevel += liters
            }

            is PetrolMouth -> {
                println("Заливаем $liters л. бензина")
                this.fuelLevel += liters
            }

            is TazMouth -> throw AppError.BangException

        }
    }
}
