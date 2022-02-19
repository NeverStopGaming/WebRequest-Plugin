package net.neverstopgaming.webrequest.velocity

import com.google.gson.JsonParser
import com.google.gson.stream.JsonWriter
import net.neverstopgaming.webrequest.core.Config
import java.io.File

class VelocityConfig : Config {

    private val defaultConfig = """
    {
        "urls": [
            "https://status.neverstopgaming.net/api/push/yourid"
        ],
        "interval": 60
    }
    """.trimMargin()

    private val config = JsonParser.parseString(getConfigFile().readText()).asJsonObject

    override val urls: Array<String>
        get() = config["urls"].asJsonArray.map { it.asString }.toTypedArray()

    override val interval: Long
        get() = config["interval"].asLong

    override fun getConfigFile(): File {

        val file = File("plugins/WebRequest", "config.json")

        if (!file.exists()) {

            file.parentFile.mkdirs()
            file.createNewFile()

            file.writeText(defaultConfig)
        }

        return file
    }


}