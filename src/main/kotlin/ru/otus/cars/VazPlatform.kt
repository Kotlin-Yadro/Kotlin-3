package ru.otus.cars

abstract class VazPlatform(override val color: String) : Car {
    // Положение руля. Доступно только внутри класса и наследникам
    protected var wheelAngle: Int = 0 // Положение руля

    // Реализация интерфейса CarInput
    override fun wheelToRight(degrees: Int) { wheelAngle += degrees }
    // Реализация интерфейса CarInput
    override fun wheelToLeft(degrees: Int) { wheelAngle -= degrees }

    // Получить оборудование
    override fun getEquipment(): String = "Кузов, колеса, движок"

    // Абстрактное свойство двигателя
    abstract val engine: VazEngine

    inner class PetrolMouth : TankMouthAbstract() {
        fun fuelPetrol(litres: Int) {
            println("PetrolMouth.fuelPetrol()")
            tank.receiveFuel(litres)
        }
        override fun fuel(litres: Int) {
            println("PetrolMouth.fuel()")
            open()
            fuelPetrol(litres)
            close()
        }
    }
    inner class LpgMouth : TankMouthAbstract() {
        fun fuelLpg(litres: Int) {
            println("LpgMouth.fuelLpg()")
            tank.receiveFuel(litres)
        }
        override fun fuel(litres: Int) {
            println("LpgMouth.fuel()")
            open()
            fuelLpg(litres)
            close()
        }
    }

    inner class TankGeneral : Tank {
        private var volume: Int = 0
        override fun receiveFuel(litres: Int) {
            volume = litres
        }
        override fun getContents(): Int {
            return volume
        }
    }

}

// Перечисление двигателей ВАЗ
sealed class VazEngine {
    // Объем двигателя можно задать при производстве
    abstract val volume: Int

    data class LADA_2107(override val volume: Int) : VazEngine()
    data class SAMARA_2108(override val volume: Int) : VazEngine()
}

class GeneralTank : Tank {
    private var volume = 0
    override fun receiveFuel(litres: Int) {
        println("GeneralTank.receiveFuel()")
        volume = litres
    }

    override fun getContents(): Int {
        return volume
    }
}
