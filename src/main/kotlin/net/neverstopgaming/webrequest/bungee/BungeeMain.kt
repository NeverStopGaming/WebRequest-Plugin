package net.neverstopgaming.webrequest.bungee

import net.md_5.bungee.api.plugin.Plugin
import net.neverstopgaming.webrequest.core.Requester

class BungeeMain : Plugin() {

    private val config = BungeeConfig(this)

    override fun onEnable() {

        logger.info("Config Loaded")

        Requester(config)
        logger.info("Requester Loaded")
    }
}