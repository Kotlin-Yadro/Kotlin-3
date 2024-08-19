package ru.otus.cars

import kotlin.random.Random

/**
 * Семёрочка
 */
class Vaz2107 private constructor(color: String) : VazPlatform(color) {
    /**
     * Сам-себе-сборщик ВАЗ 2107.
     */
    companion object : CarBuilder {
        private fun getRandomEngine(): VazEngine {
            return when (Random.nextInt(0, 2)) {
                0 -> VazEngine.LADA_2107(1300)
                else -> VazEngine.LADA_2107(1600)
            }
        }

        override fun build(plates: Car.Plates): Vaz2107 = Vaz2107("Зеленый").apply {
            this.engine = getRandomEngine()
            this.plates = plates
            this.tank = Vaz2107Tank()
            this.tankMouth = LpgMouth(tank)
        }

        /**
         * Проверь, ездит или нет
         */
        fun test(vaz2107: Vaz2107) {
            println("Проверяем, едет ли ВАЗ 2107...")
            vaz2107.currentSpeed = Random.nextInt(0, 60)
        }

        /**
         * Используем вместо STATIC
         */
        const val MODEL = "2107"
    }

    // Переопределяем свойство родителя
    override lateinit var engine: VazEngine
        private set

    /**
     * Семерка едет так
     */
    fun drdrdrdrdr() {
        println("Помчали на $MODEL:")
        if (tank.getFuelContents() > 0) {
            println("Др-др-др-др....")
        } else {
            println("Др-др-др-др....  нет топлива....")
        }
    }

    private var currentSpeed: Int = 0 // Скока жмёт
        private set(value) {
            if (tank.getFuelContents() > 0) {
                field = value
            } else {
                println("нет топлива....")
                field = 0
            }
        }

    /**
     * Доступно сборщику
     * @see [build]
     */
    override lateinit var plates: Car.Plates
        private set

    /**
     * Горловина бензобака
     */
    override lateinit var tankMouth: TankMouth
        private set

    /**
     * Бензобак
     */
    private lateinit var tank: Tank

    // Выводим состояние машины
    override fun toString(): String {
        return "Vaz2107(plates=$plates, wheelAngle=$wheelAngle, currentSpeed=$currentSpeed, fuelContents=${tank.contents})"
    }

    /**
     * Делегируем приборы внутреннему классу
     */
    override val carOutput: CarOutput = VazOutput()

    /**
     * Имеет доступ к внутренним данным ЭТОГО ВАЗ-2107!
     */
    inner class VazOutput : CarOutput {
        override fun getCurrentSpeed(): Int {
            return this@Vaz2107.currentSpeed
        }

        override fun getFuelContents(): Int {
            return this@Vaz2107.tank.getFuelContents()
        }
    }

    /**
     * Бак подходящий Vaz2107
     */
    private inner class Vaz2107Tank : Tank() {
        override val capacity = 39;
    }
}