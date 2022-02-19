package net.neverstopgaming.webrequest.velocity

import com.google.inject.Inject
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent
import com.velocitypowered.api.plugin.Plugin
import com.velocitypowered.api.proxy.ProxyServer
import net.neverstopgaming.webrequest.core.Requester
import org.slf4j.Logger

class VelocityMain @Inject constructor(val server: ProxyServer, private val logger: Logger) {

    private val config = VelocityConfig()

    @Subscribe
    fun onReady(e: ProxyInitializeEvent) {

        logger.debug("Config loaded")

        Requester(config)
        logger.debug("Requester loaded")
    }
}