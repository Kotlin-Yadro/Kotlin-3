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
        println("Др-др-др-др....")
    }

    private var currentSpeed: Int = 0 // Скока жмёт

    private var lpgMouth: LpgMouth = LpgMouth()

    /**
     * Доступно сборщику
     * @see [build]
     */
    override lateinit var plates: Car.Plates
        private set

    override var tankMouth: TankMouth = lpgMouth
        private set

    // Выводим состояние машины
    override fun toString(): String {
        return "Vaz2107(plates=$plates, wheelAngle=$wheelAngle, currentSpeed=$currentSpeed, fuelContents=${carOutput.getFuelContents()})"
    }

    /**
     * Делегируем приборы внутреннему классу
     */
    override val carOutput: CarOutput = VazOutput()

    inner class VazTank : Tank {
        override val mouth: TankMouth = this@Vaz2107.tankMouth
        private var contents: Int = 0;
        override fun getContents(): Int {
            return  this.contents;
        }
        override fun receiveFuel(liters: Int) {
            this.contents += liters;
        }
    }
    /**
     * Имеет доступ к внутренним данным ЭТОГО ВАЗ-2107!
     */
    inner class VazOutput : CarOutput {
        override val tank: Tank = VazTank()
        override fun getCurrentSpeed(): Int {
            return this@Vaz2107.currentSpeed
        }
        override fun getFuelContents(): Int {
            return this.tank.getContents()
        }
    }

    inner class LpgMouth : TankMouth {
        override fun open() {
            TODO("Not yet implemented")
        }
        override fun close() {
            TODO("Not yet implemented")
        }
        fun fuelLpg(liters: Int) {
            this@Vaz2107.carOutput.tank.receiveFuel(liters)

        }
    }
}