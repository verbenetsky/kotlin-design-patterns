package builder

// the idea of builder pattern is to separate the construction of an object from its representation

interface IHouseBuilder {
    fun setStories(stories: Int): IHouseBuilder
    fun setDoorType(doorType: House.DoorType): IHouseBuilder
    fun setRoofType(roofType: House.RoofType): IHouseBuilder
    fun setPoolSize(poolSize: House.PoolSize): IHouseBuilder
    fun setGarden(garden: Boolean = true): IHouseBuilder
    fun setGarage(garage: Boolean = true): IHouseBuilder
    fun setCameras(cameras: Boolean = true): IHouseBuilder
    fun build(): House
}

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

class HouseBuilder : IHouseBuilder {

    private var stories: Int = 0
    private var doorType: House.DoorType = House.DoorType.SINGLE
    private var roofType: House.RoofType = House.RoofType.FLAT
    private var poolSize: House.PoolSize? = null
    private var garden: Boolean = false
    private var garage: Boolean = false
    private var cameras: Boolean = false

    override fun setStories(stories: Int): IHouseBuilder {
        this.stories = stories
        return this
    }

    override fun setDoorType(doorType: House.DoorType): IHouseBuilder {
        this.doorType = doorType
        return this
    }

    override fun setRoofType(roofType: House.RoofType): IHouseBuilder {
        this.roofType = roofType
        return this
    }

    override fun setPoolSize(poolSize: House.PoolSize): IHouseBuilder {
        this.poolSize = poolSize
        return this
    }

    override fun setGarden(garden: Boolean): IHouseBuilder {
        this.garden = garden
        return this
    }

    override fun setGarage(garage: Boolean): IHouseBuilder {
        this.garage = garage
        return this
    }

    override fun setCameras(cameras: Boolean): IHouseBuilder {
        this.cameras = cameras
        return this
    }

    override fun build(): House {
        return House(
            doorType = doorType,
            stories = stories,
            roofType = roofType,
            poolSize = poolSize,
            garden = garden,
            garage = garage,
            cameras = cameras
        )
    }
}

fun main() {
    val house = HouseBuilder()
        .setStories(2)
        .setRoofType(House.RoofType.FLAT)
        .setDoorType(House.DoorType.DOUBLE)
        .setPoolSize(House.PoolSize.MEDIUM)
        .setGarden()
        .setGarage()
        .setCameras()
        .build()

    val house1 = HouseBuilder()
        .setStories(1)
        .setRoofType(House.RoofType.SPIKE)
        .setDoorType(House.DoorType.SINGLE)
        .build()

    println(house)
    println(house1)
}
