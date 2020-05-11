package com.github.xjcyan1de.bukkitextensions.event

import org.bukkit.block.Block
import org.bukkit.entity.Player
import org.bukkit.event.Event
import org.bukkit.event.EventPriority
import org.bukkit.event.HandlerList
import org.bukkit.event.Listener
import org.bukkit.event.entity.ItemDespawnEvent
import org.bukkit.event.entity.ItemMergeEvent
import org.bukkit.event.entity.ItemSpawnEvent
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.event.inventory.InventoryInteractEvent
import org.bukkit.event.player.PlayerDropItemEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.Plugin

fun Listener.unregister() = HandlerList.unregisterAll(this)

@Suppress("UNCHECKED_CAST")
fun <T : Event> Plugin.eventHandler(
        eventClass: Class<T>,
        priority: EventPriority = EventPriority.NORMAL,
        ignoreCanceled: Boolean = false,
        handler: T.(Listener) -> Unit
) = server.pluginManager.registerEvent(eventClass, object : Listener {}, priority, { listener, event ->
    if (event::class.java == eventClass) handler(event as T, listener)
}, this, ignoreCanceled)

inline fun <reified T : Event> Plugin.eventHandler(
        priority: EventPriority = EventPriority.NORMAL,
        ignoreCanceled: Boolean = false,
        noinline handler: T.(Listener) -> Unit
) = eventHandler(T::class.java, priority, ignoreCanceled, handler)

fun Plugin.registerEvents(listener: Listener) = server.pluginManager.registerEvents(listener, this)

val InventoryInteractEvent.player
    get() = this.whoClicked as Player

val PlayerInteractEvent.placedBlock: Block?
    get() = this.clickedBlock?.getRelative(this.blockFace)
val PlayerDeathEvent.player: Player
    get() = entity

var PlayerDropItemEvent.itemStack: ItemStack
    get() = itemDrop.itemStack
    set(value) {
        itemDrop.setItemStack(value)
    }
var ItemSpawnEvent.itemStack: ItemStack
    get() = entity.itemStack
    set(value) {
        entity.setItemStack(value)
    }
var ItemDespawnEvent.itemStack: ItemStack
    get() = entity.itemStack
    set(value) {
        entity.setItemStack(value)
    }
var ItemMergeEvent.itemStack: ItemStack
    get() = entity.itemStack
    set(value) {
        entity.setItemStack(value)
    }