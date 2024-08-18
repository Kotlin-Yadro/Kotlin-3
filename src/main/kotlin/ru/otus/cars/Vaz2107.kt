package ru.otus.cars

import ru.otus.cars.fuel_system.Tank
import ru.otus.cars.fuel_system.TankMouth
import kotlin.random.Random

// Интересно litersFromFactory будет всегда (пока жив объект Vaz2107) висеть в стеке?
// Или при выходе из конструктора litersFromFactory потеряется?

/**
 * Семёрочка
 */
class Vaz2107 private constructor(
    color: String,
    litersFromFactory: Int
) : VazPlatform(color) {
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

        override fun build(plates: Car.Plates): Vaz2107 = Vaz2107(
            "Зеленый",
            5, // Хватит доехать до ближайшей АЗС
        ).apply {
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

    /**
     * Доступно сборщику
     * @see [build]
     */
    override lateinit var plates: Car.Plates
        private set

    // Выводим состояние машины
    override fun toString(): String {
        return "Vaz2107(plates=$plates, wheelAngle=$wheelAngle, currentSpeed=$currentSpeed) ${super.toString()}"
    }

    /**
     * Делегируем приборы внутреннему классу
     */
    override val carOutput: CarOutput

    override val tank: Tank

    /**
     * Имеет доступ к внутренним данным ЭТОГО ВАЗ-2107!
     */
    inner class VazOutput(litres: Int = 0) : Tank(
        litres,
        39, // https://www.bolshoyvopros.ru/questions/3120600-skolko-litrov-benzobak-vaz-2107.html :)
        tankMouth = TankMouth.TankMouthVaz2107()
    ),
        CarOutput {
        override fun getCurrentSpeed(): Int {
            return this@Vaz2107.currentSpeed
        }
    }

    init {
        val vazOutput = VazOutput(litersFromFactory)
        carOutput = vazOutput
        tank = vazOutput
    }
}