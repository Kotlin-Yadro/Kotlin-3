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

    override var tankMouth: TankMouth = TankMouth.TazMouth

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
        return "Taz(руля нет, приборов нет, номера сняты,, fuel=${tankMouth.getContents()})"
    }
}