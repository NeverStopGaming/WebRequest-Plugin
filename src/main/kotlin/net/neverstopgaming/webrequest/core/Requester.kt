package net.neverstopgaming.webrequest.core

import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import okhttp3.Request

@OptIn(DelicateCoroutinesApi::class)
class Requester(config: Config) {

    private val client = OkHttpClient()

    init {

        GlobalScope.launch {

            val requestes = arrayListOf<Request>()

            for(url in config.urls) {
                requestes.add(Request.Builder().url(url).build())
            }

            while (this.isActive){

                for (request in requestes) {

                    client.newCall(request).execute()
                    client.dispatcher.executorService.shutdown()

                    delay(config.interval * 1000)
                }
            }
        }
    }
}