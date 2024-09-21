package ru.otus.cars

interface GasStationI{
    fun loadLPG(car: Car, liters: Int){
        car.receiveFuel(liters);
    }
    fun loadPetrol(car: Car, liters: Int){
        car.receiveFuel(liters);
    }
    fun loadDiesel(car: Car, liters: Int){
        car.receiveFuel(liters);
    }
}
class GasStation : GasStationI{
    fun loadCar(car: Car, liters: Int) {
        try {
            when(car.tank.fuelType){
                Tank.FuelType.FTLPG -> {
                    this.loadLPG(car,liters)
                }

                Tank.FuelType.FTDISEL -> {
                    this.loadDiesel(car, liters)
                }

                Tank.FuelType.FTPETROL -> {
                    this.loadPetrol(car, liters)
                }
            }
        }
        catch (e: NotImplementedError){
            println("Exception : " + e.message)
        }
    }
}