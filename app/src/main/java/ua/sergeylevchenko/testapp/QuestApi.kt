import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface QuestApi {

    @GET("/v2/everything")
    fun getNews(
        @Query("q") q: String?,
        @Query("from") from: String?,
        @Query("sortBy") sortBy: String?,
        @Query("apiKey") apiKey: String?,
    ): Single<Response>

}

class Response(
    val status: String?,
    val totalResults: Int,
    val articles: List<Article>,
)

class Article(
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String,

    )
