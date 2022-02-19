package net.neverstopgaming.webrequest.core

import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import okhttp3.Request

@OptIn(DelicateCoroutinesApi::class)
class Requester(config: Config) {

    private val client = OkHttpClient()

    init {

        GlobalScope.launch {

            while (this.isActive){

                for(url in config.urls) {
                    val request = Request.Builder().url(url).build()

                    client.newCall(request).execute()

                    delay(config.interval * 1000)
                }
            }
        }
    }
}