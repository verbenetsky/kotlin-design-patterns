package org.example.facade

data class GameData(
    val path: String,
    val mapDownloaded: Boolean = false,
    val mapLoaded: Boolean = false,
    val soundtrackLoaded: Boolean = false,
    val modsLoaded: Boolean = false,
    val multiplayerConnected: Boolean = false,
    val onlineModeEnabled: Boolean = false,
    val started: Boolean = false
)

class FileReader {
    fun read(path: String): GameData {
        println("Reading game files from: $path")
        return GameData(path = path)
    }
}

class DownloadMap {
    fun downloadMap(gameData: GameData): GameData {
        println("Downloading map...")
        return gameData.copy(mapDownloaded = true)
    }
}

class LoadMap {
    fun loadMap(gameData: GameData): GameData {
        println("Loading map...")
        return gameData.copy(mapLoaded = true)
    }
}

class LoadSoundTrack {
    fun loadSoundTrack(gameData: GameData): GameData {
        println("Loading soundtrack...")
        return gameData.copy(soundtrackLoaded = true)
    }
}

class LoadMods {
    fun loadMods(gameData: GameData): GameData {
        println("Loading mods...")
        return gameData.copy(modsLoaded = true)
    }
}

class ConnectMultiplayerMode {
    fun connectMultiplayer(gameData: GameData): GameData {
        println("Connecting to multiplayer...")
        return gameData.copy(multiplayerConnected = true)
    }
}

class TurnOnOnlineMode {
    fun turnOnOnlineMode(gameData: GameData): GameData {
        println("Turning on online mode...")
        return gameData.copy(onlineModeEnabled = true)
    }
}

class GameStarter {
    fun startGame(gameData: GameData): GameData {
        println("Starting game...")
        return gameData.copy(started = true)
    }
}

class LoadGameFacade(
    private val fileReader: FileReader,
    private val downloadMap: DownloadMap,
    private val loadMap: LoadMap,
    private val loadSoundTrack: LoadSoundTrack,
    private val loadMods: LoadMods,
    private val connectMultiplayerMode: ConnectMultiplayerMode,
    private val turnOnOnlineMode: TurnOnOnlineMode,
    private val gameStarter: GameStarter
) {
    fun loadGame(path: String): GameData {
        var gameData = fileReader.read(path)
        gameData = downloadMap.downloadMap(gameData)
        gameData = loadMap.loadMap(gameData)
        gameData = loadSoundTrack.loadSoundTrack(gameData)
        gameData = loadMods.loadMods(gameData)
        gameData = connectMultiplayerMode.connectMultiplayer(gameData)
        gameData = turnOnOnlineMode.turnOnOnlineMode(gameData)
        gameData = gameStarter.startGame(gameData)

        println("Game is ready!")
        return gameData
    }
}

fun main() {
    val facade = LoadGameFacade(
        FileReader(),
        DownloadMap(),
        LoadMap(),
        LoadSoundTrack(),
        LoadMods(),
        ConnectMultiplayerMode(),
        TurnOnOnlineMode(),
        GameStarter()
    )

    facade.loadGame("game.exe")
}
