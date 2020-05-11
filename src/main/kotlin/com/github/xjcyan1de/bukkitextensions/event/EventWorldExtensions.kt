package com.github.xjcyan1de.bukkitextensions.event

import org.bukkit.World
import org.bukkit.event.block.BlockEvent
import org.bukkit.event.enchantment.EnchantItemEvent
import org.bukkit.event.enchantment.PrepareItemEnchantEvent
import org.bukkit.event.entity.EntityEvent
import org.bukkit.event.hanging.HangingEvent
import org.bukkit.event.inventory.InventoryInteractEvent
import org.bukkit.event.player.PlayerEvent
import org.bukkit.event.vehicle.VehicleEvent

val BlockEvent.world: World get() = block.world
val EnchantItemEvent.world: World get() = enchanter.world
val PrepareItemEnchantEvent.world: World get() = enchanter.world
val EntityEvent.world: World get() = entity.world
val HangingEvent.world: World get() = entity.world
val InventoryInteractEvent.world: World get() = player.world
val PlayerEvent.world: World get() = player.world
val VehicleEvent.world: World get() = vehicle.world