package com.github.xjcyan1de.bukkitextensions.inventory

import org.bukkit.event.inventory.InventoryType
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

operator fun Inventory.get(index: Int) = getItem(index)

operator fun Inventory.set(index: Int, itemStack: ItemStack?) = setItem(index, itemStack)

val InventoryType.width: Int
    get() = when (this) {
        InventoryType.CHEST, InventoryType.PLAYER, InventoryType.ENDER_CHEST, InventoryType.SHULKER_BOX, InventoryType.BARREL -> 9
        InventoryType.DISPENSER, InventoryType.DROPPER, InventoryType.WORKBENCH, InventoryType.CRAFTING, InventoryType.ANVIL -> 3
        InventoryType.HOPPER -> 5
        else -> 1
    }

fun InventoryType.getPosition(pos: Int): Pair<Int, Int> {
    val y = pos / width
    val x = pos - y * width
    return x + 1 to y + 1
}

fun InventoryType.getIndex(x: Int, y: Int) = (y - 1) * width + (x - 1)
