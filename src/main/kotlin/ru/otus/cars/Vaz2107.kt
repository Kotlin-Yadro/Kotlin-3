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
            // Устанавливаем топливную систему
            this.carTank = VazTank()
            this.tankMouth = Vaz2107TankMouth()
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

    /**
     * Доступно сборщику
     * @see [build]
     */
    override lateinit var plates: Car.Plates
        private set

    // Выводим состояние машины
    override fun toString(): String {
        return "Vaz2107(plates=$plates, wheelAngle=$wheelAngle," +
                "currentSpeed=$currentSpeed, fuel=${carTank.getContents()})"
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
            return this@Vaz2107.carTank.getContents()
        }
    }

    /**
     * Бензобак, устанавливается сборщиком
     * @see [build]
     */
    private lateinit var carTank: Tank

    /**
     * Горловина бензобака, устанавливается сборщиком
     * @see [build]
     */
    override lateinit var tankMouth: TankMouth
        private set

    /**
     * Топливный бак ВАЗ-2107
     */
    inner class VazTank : Tank {
        private var contents: Int = 0

        override fun getContents(): Int = contents

        override fun receiveFuel(liters: Int) {
            contents = liters
        }
    }

    /**
     * Горловина бака ВАЗ-2107 (семёрка ездит на газу)
     */
    inner class Vaz2107TankMouth : LgpMouth() {
        override fun fuelLgp(liters: Int) {
            open()
            super.fuelLgp(liters)
            this@Vaz2107.carTank.receiveFuel(liters)
            close()
        }
    }
}