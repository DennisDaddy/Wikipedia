package org.dennis.wikipedia.activities.providers

import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.httpGet
import com.google.gson.Gson
import org.dennis.wikipedia.activities.models.Urls
import org.dennis.wikipedia.activities.models.WikiResult
import java.io.Reader


class ArticleDataProvider {
    init {
        FuelManager.instance.baseHeaders = mapOf("User-Agent" to "Pluralsight Wikipedia")
    }

    fun search(term: String, skip: Int, take: Int, responseHandler: (result: WikiResult) -> Unit?){
        Urls.getSearchUrl(term, skip, take).httpGet()
                .responseObject(WikiPediaDataDeserializer()){ _, response, result ->

                    if (response.httpStatusCode !=200){
                        throw Exception("Unable to get articles")
                    }

                    val (data, _) = result
                    responseHandler.invoke(data as WikiResult)
                }
    }

    fun getRandom(take: Int, responseHandler: (result: WikiResult) -> Unit?){
        Urls.getRandomUrl(take).httpGet()
                .responseObject(WikiPediaDataDeserializer()){ _, response, result ->

                    if (response.httpStatusCode !=200){
                        throw Exception("Unable to get articles")
                    }

                    val (data, _) = result
                    responseHandler.invoke(data as WikiResult)

                }
    }

    class WikiPediaDataDeserializer : ResponseDeserializable<WikiResult>{
        override fun deserialize(reader: Reader) = Gson().fromJson(reader, WikiResult::class.java)
    }
}