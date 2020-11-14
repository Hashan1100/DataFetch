import com.google.gson.Gson
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader

class FileHandler {
    fun fetchAvailableDataLeagueDataIds() = File("/FootballDataJson").walkTopDown().map {
        try {
            val inputStreamReader = InputStreamReader(FileInputStream(it.absoluteFile))
            val fromJson = Gson().fromJson(inputStreamReader, PlayerData::class.java)
            if (fromJson.data?.first()?.leagueId != null) {
                fromJson.data.first()?.leagueId?: ""
            } else {
                null
            }
        } catch (e: Exception) {
            null
        }
    }.toList().filterNotNull()

    fun createFilePlayerStats(playerData: String, leagueName: String) {
        try {
            File("<path>${leagueName}-name.json").printWriter().use { out ->
                out.print(playerData)
            }
        } catch (e: java.lang.Exception) {
            println("Error occurred $e")
        }
    }
}

data class LeagueSeason(val leagueId: String, val season: String)