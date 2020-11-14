import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils
import java.lang.Exception


class SportApiConnector {
    val httpClient = HttpClients.createDefault()
    val baseUrl = "http://localhost:6700"
    val api_key = "xxxxxxxxxxxxxxxxx"

    fun fetchData(leagueId: String) =
            try {
                val request = HttpGet("$baseUrl/sport/football/playerstats/league?api_key=$api_key&leagueId=$leagueId")
                val entity = httpClient
                        .execute(request)
                        .entity
                EntityUtils.toString(entity)
            } catch (e: Exception) {
                println("Error occurred while fetching data $e")
                null
            }
}