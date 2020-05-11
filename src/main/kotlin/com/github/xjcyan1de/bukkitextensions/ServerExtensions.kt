package com.github.xjcyan1de.bukkitextensions

import org.bukkit.Bukkit
import org.bukkit.Server
import org.bukkit.scheduler.BukkitScheduler

val SERVER: Server
    get() = Bukkit.getServer()

val isPrimaryThread: Boolean
    get() = SERVER.isPrimaryThread

val SCHEDULER: BukkitScheduler
    get() = SERVER.scheduler