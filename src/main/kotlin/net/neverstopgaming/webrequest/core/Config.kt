package net.neverstopgaming.webrequest.core

import java.io.File

interface Config{

    val urls : Array<String>

    val interval: Long

    fun getConfigFile(): File

}