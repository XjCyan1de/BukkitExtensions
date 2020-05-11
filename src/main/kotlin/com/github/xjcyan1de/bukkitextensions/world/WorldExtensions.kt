package com.github.xjcyan1de.bukkitextensions.world

import org.bukkit.Bukkit
import org.bukkit.World

fun World.unload(save: Boolean = true) = Bukkit.unloadWorld(this, save)