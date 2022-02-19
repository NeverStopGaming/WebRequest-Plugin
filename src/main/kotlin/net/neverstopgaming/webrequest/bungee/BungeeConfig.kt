package net.neverstopgaming.webrequest.bungee

import net.md_5.bungee.config.Configuration
import net.md_5.bungee.config.ConfigurationProvider
import net.md_5.bungee.config.YamlConfiguration
import net.neverstopgaming.webrequest.core.Config
import java.io.File


class BungeeConfig(private val bungeeMain: BungeeMain) : Config {

    private val defaultConfig = """
    ############################################################################################
    #     _   _                     ____  _               ____                 _               #
    #    | \ | | _____   _____ _ __/ ___|| |_ ___  _ __  / ___| __ _ _ __ ___ (_)_ __   __ _   #
    #    |  \| |/ _ \ \ / / _ \ '__\___ \| __/ _ \| '_ \| |  _ / _` | '_ ` _ \| | '_ \ / _` |  #
    #    | |\  |  __/\ V /  __/ |   ___) | || (_) | |_) | |_| | (_| | | | | | | | | | | (_| |  #
    #    |_| \_|\___| \_/ \___|_|  |____/ \__\___/| .__/ \____|\__,_|_| |_| |_|_|_| |_|\__, |  #
    #                                             |_|                                  |___/   #
    ############################################################################################

    urls:
    - https://status.neverstopgaming.net/api/push/yourid

    # the interval in seconds to request the urls
    interval: 60
    """.trimMargin()

    private var config: Configuration
        = ConfigurationProvider.getProvider(YamlConfiguration::class.java).load(getConfigFile())

    override val urls: Array<String>
        get() = config.getStringList("urls").toTypedArray()

    override val interval: Long
        get() = config.getLong("interval")

    override fun getConfigFile() : File {

        val file = File(bungeeMain.dataFolder, "config.yml")

        if(!file.exists()) {

            bungeeMain.dataFolder.mkdirs()
            file.createNewFile()

            file.writeText(defaultConfig)

        }

        return file
    }


}