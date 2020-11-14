class DataFetchHandler {
    private val sportApiConnector = SportApiConnector()
    private val fileHandler = FileHandler()

    fun fetchData(leagueIds: List<String>) {
        leagueIds.forEach {
            val fetchData = sportApiConnector.fetchData(it)
            if (fetchData != null) {
                fileHandler.createFilePlayerStats(fetchData, it)
            }
        }
    }
}