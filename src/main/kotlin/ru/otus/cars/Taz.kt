package ru.otus.cars

import kotlin.random.Random

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

    override val tankMouth: TankMouth
        get() = throw NotImplementedError("Бак взорвался")

    /**
     * Получить оборудование
     */
    override fun getEquipment(): String = "Крыса"

    override fun refuel() {
        println("Зправляем Taz чем угодно...")
        when(tankMouth) {
            is LpgMouth -> (tankMouth as LpgMouth).fuelLpg(Random.nextInt(0, 60))
            is PetrolMouth -> (tankMouth as PetrolMouth).fuelPetrol(Random.nextInt(0, 60))
        }
    }

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
        return "Taz()"
    }
}