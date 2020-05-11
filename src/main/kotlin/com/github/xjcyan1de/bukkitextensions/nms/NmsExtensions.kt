package com.github.xjcyan1de.bukkitextensions.nms

import org.bukkit.Bukkit

val NMS_VERSION by lazy {
    Bukkit.getServer().javaClass.getPackage().name.substring(23)
}

@Suppress("UNCHECKED_CAST")
fun <T> nms(name: String): Class<T> =
        Class.forName("net.minecraft.server.$NMS_VERSION.$name") as Class<T>

@Suppress("UNCHECKED_CAST")
fun <T> obc(name: String): Class<T> =
        Class.forName("org.bukkit.craftbukkit.$NMS_VERSION.$name") as Class<T>