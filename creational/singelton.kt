//Singleton
//Kotlin has a very simple way of creating Singleton object
// object is lazy initialized
object DatabaseManager {
    private var connectionInitialized = false

    init {
        println("initialising: $this")
    }
    
    fun connectToDb() {
        if (connectionInitialized) {
            println("connected to db")
        } else {
            println("connecting to db...")
            connectionInitialized = true
        }
    }
    
    fun disconnect() {
        if (connectionInitialized) {
            println("disconnecting from db...")
            connectionInitialized = false
        } else {
            println("there is no active connection.")
        }
    }
}


fun main() {
    val databaseManager1 = DatabaseManager
    val databaseManager2 = DatabaseManager

    println(databaseManager2 == databaseManager1) // true but if we change object to class we will receive false

    databaseManager1.connectToDb() // connecting to db ...
    databaseManager2.connectToDb() // connected to db
    DatabaseManager.disconnect() // disconnecting from db...
    DatabaseManager.disconnect() // there is no active connection.
}

// also there is a way of initializing Singleton using companion object, but it is more complex and less usable version

class Database private constructor() {
    companion object {
        private var instance: Database? = null

        fun getInstance(): Database? {
            if (instance == null) {
                instance = Database()
            }
            return instance
        }
    }
}

fun main() {

    val instance = Database.getInstance()
    val instance1 = Database.getInstance()
    println(instance)
    println(instance1 == instance)
}

