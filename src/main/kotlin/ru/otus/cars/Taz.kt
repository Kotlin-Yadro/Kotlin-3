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
    override val carOutput: CarOutput = TazOutput()

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

    override val tank: Tank = BangTank()
    override val tankMouth: TankMouth = TazMouth()

    override fun toString(): String {
        return "Taz(currentFuel=${carOutput.getFuelContents()})"
    }

    class TazOutput : CarOutput {
        override fun getCurrentSpeed(): Int {
            return 0
        }

        override fun getFuelContents(): Int {
            return tank.getContents()
        }
    }

    class TazMouth : TankMouthAbstract() {
        override fun fuel(litres: Int) {
            println("TazMouth.fuel()")
            open()
            tank.receiveFuel(litres)
            close()
        }
    }

    class BangTank: Tank {
        private var volume: Int = 0
        override fun receiveFuel(litres: Int) {
            println("BangTank.receiveFuel()")
            throw Exception("Bang!")
        }

        override fun getContents(): Int {
            return volume
        }

    }
}