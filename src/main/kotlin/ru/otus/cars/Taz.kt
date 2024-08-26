package ru.otus.cars

object Taz: Car {
    /**
     * Номерной знак
     */
    override val plates: Car.Plates
        get() = throw NotImplementedError("Номера сняты")

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

    /**
     * Неисправный бензобак таза
     */
    private val carTank: Tank = TazTank()

    /**
     * Горловина бензобака Таза
     */
    override val tankMouth: TankMouth = TazTankMouth()

    /**
     * Топливный бак Таза (взрывается при попытке заправить)
     */
    class TazTank : Tank {
        private var contents: Int = 0

        override fun getContents(): Int = contents

        override fun receiveFuel(liters: Int) {
            throw NotImplementedError("Бак взрывается!")
        }
    }

    /**
     * Горловина бака Таза
     */
    class TazTankMouth : PetrolMouth() {
        override fun fuelPetrol(liters: Int) {
            open()
            super.fuelPetrol(liters)
            carTank.receiveFuel(liters)
            close()
        }
    }
}