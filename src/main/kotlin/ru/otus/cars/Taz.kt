package ru.otus.cars

object Taz: Car {
    /**
     * Номерной знак
     */
    override lateinit var plates: Car.Plates

    /**
     * Gas tank
     */
    private val tank: FuelTank = TazTank()

    /**
     * Горловина бензобака
     */
    override var tankMouth: TankMouth = PetrolMouth(tank)

    /**
     * Цвет машины
     */
    override val color: String = "Ржавый"

    /**
     * Следит за машиной
     */
    override val carOutput: CarOutput
        get() = throw NotImplementedError("Приборов нет")

    /**
     * Получить оборудование
     */
    override fun getEquipment(): String = "Крыса"

    /**
     * Руль вправо на [degrees] градусов
     */
    override fun wheelToRight(degrees: Int) {
        throw NotImplementedError("Руля нет")
    }

    /**
     * Руль влево на [degrees] градусов
     */
    override fun wheelToLeft(degrees: Int) {
        throw NotImplementedError("Руля нет")
    }

    override fun toString(): String {
        return "Taz: " + this.tankMouth
    }

    /**
     * ТАЗ может иметь любую систему, но его бак взрывается
     */
    private class TazTank :FuelTank() {
        override fun loadFuel(liters: Int): Unit {
            throw Throwable("Бак взорвался")
        }
    }
}