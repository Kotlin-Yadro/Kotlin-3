package ru.otus.cars

class Taz: Car {
    /**
     * Номерной знак
     */
    override lateinit var plates: Car.Plates

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
     * Бензобак
     */
    private val tank: Tank = TazTank()

    /**
     * Горловина бензобака
     */
    override var tankMouth: TankMouth = PetrolMouth(tank)

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
        return "Taz(color=$color)"
    }

    /**
     * ТАЗ может иметь любую систему, но его бак взрывается
     */
    private inner class TazTank : Tank() {
        override fun receiveFuel(liters: Int): Unit {
            throw Throwable("Бак взорвался")
        }
    }
}