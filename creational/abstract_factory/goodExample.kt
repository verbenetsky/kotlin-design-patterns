package org.example.abstract_factory

interface Chair {
    fun getDescription(): String
}

class CheapChair: Chair {
    override fun getDescription(): String {
        return "Cheap chair"
    }
}

class AverageChair: Chair {
    override fun getDescription(): String {
        return "Average chair"
    }
}

class ExpensiveChair: Chair {
    override fun getDescription(): String {
        return "Expensive chair"
    }
}

interface CoffeeTable {
    fun getDescription(): String
}

class CheapCoffeeTable: CoffeeTable {
    override fun getDescription(): String {
        return "Cheap Coffee Table"
    }
}

class AverageCoffeeTable: CoffeeTable {
    override fun getDescription(): String {
        return "Average Coffee Table"
    }
}

class ExpensiveCoffeeTable: CoffeeTable {
    override fun getDescription(): String {
        return "Expensive Coffee Table"
    }
}

interface Sofa {
    fun getDescription(): String
}

class CheapSofa: Sofa {
    override fun getDescription(): String {
        return "Cheap Sofa"
    }
}

class AverageSofa: Sofa {
    override fun getDescription(): String {
        return "Average Sofa"
    }
}

class ExpensiveSofa: Sofa {
    override fun getDescription(): String {
        return "Expensive Sofa"
    }
}

interface FurnitureFactory {
    fun createChair(): Chair
    fun createSofa(): Sofa
    fun createCoffeeTable(): CoffeeTable
}

class CheapFurnitureFactory : FurnitureFactory {
    override fun createChair(): Chair {
        return CheapChair()
    }

    override fun createSofa(): Sofa {
        return CheapSofa()
    }

    override fun createCoffeeTable(): CoffeeTable {
        return CheapCoffeeTable()
    }
}

class AverageFurnitureFactory : FurnitureFactory {
    override fun createChair(): Chair {
        return AverageChair()
    }

    override fun createSofa(): Sofa {
        return AverageSofa()
    }

    override fun createCoffeeTable(): CoffeeTable {
        return AverageCoffeeTable()
    }
}

class ExpensiveFurnitureFactory : FurnitureFactory {
    override fun createChair(): Chair {
        return ExpensiveChair()
    }

    override fun createSofa(): Sofa {
        return ExpensiveSofa()
    }

    override fun createCoffeeTable(): CoffeeTable {
        return ExpensiveCoffeeTable()
    }
}

fun showFurniture(factory: FurnitureFactory) {
    val chair = factory.createChair()
    val sofa = factory.createSofa()
    val coffeeTable = factory.createCoffeeTable()

    println(chair.getDescription())
    println(sofa.getDescription())
    println(coffeeTable.getDescription())
}

fun main() {
    val cheapFactory = CheapFurnitureFactory()
    showFurniture(cheapFactory)

    val averageFactory = AverageFurnitureFactory()
    showFurniture(averageFactory)

    val expensiveFactory = ExpensiveFurnitureFactory()
    showFurniture(expensiveFactory)
}
