package ru.otus.cars

/**
 * Машина целиком
 */
interface Car : CarInput {
    /**
     * бензобак
     */
    val tank : Tank

    /**
     * Номерной знак
     */
    val plates: Plates

    /**
     * Цвет машины
     */
    val color: String

    /**
     * Следит за машиной
     */
    val carOutput: CarOutput

    /**
     * Получить оборудование
     */
    fun getEquipment(): String

    /**
     * Внутренний статический класс - номерой знак
     */
    data class Plates(val number: String, val region: Int)

    /**
     * заправить машину
     */
    fun receiveFuel(liters : Int)
}