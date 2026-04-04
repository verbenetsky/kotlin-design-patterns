package builder.bad_example

data class House(
    val doorType: DoorType,
    val stories: Int,
    val roofType: RoofType,
    val poolSize: PoolSize?,
    val garden: Boolean,
    val garage: Boolean,
    val cameras: Boolean
) {
    enum class DoorType { SINGLE, DOUBLE }
    enum class RoofType { FLAT, SPIKE }
    enum class PoolSize { LARGE, MEDIUM }
}

fun main() {
    val house = House(
        doorType = House.DoorType.DOUBLE,
        stories = 2,
        roofType = House.RoofType.FLAT,
        poolSize = House.PoolSize.MEDIUM,
        garden = true,
        garage = true,
        cameras = true
    )

    val house1 = House(
        doorType = House.DoorType.SINGLE,
        stories = 1,
        roofType = House.RoofType.SPIKE,
        poolSize = null,
        garden = false,
        garage = false,
        cameras = false
    )

    println(house)
    println(house1)
}
