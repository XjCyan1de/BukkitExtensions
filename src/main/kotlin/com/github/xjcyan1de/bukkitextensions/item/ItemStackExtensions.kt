package com.github.xjcyan1de.bukkitextensions.item

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.Damageable
import org.bukkit.inventory.meta.ItemMeta
import org.bukkit.inventory.meta.LeatherArmorMeta
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
fun ItemStack?.isNullOrAir(): Boolean {
    contract {
        returns(false) implies (this@isNullOrAir is ItemStack)
    }
    return this == null || this.type == Material.AIR || this.type == Material.CAVE_AIR || this.type == Material.VOID_AIR
}

infix fun ItemStack?.equalsIgnoreAmount(item: ItemStack?): Boolean {
    return if (!this.isNullOrAir() && !item.isNullOrAir()) {
        if (this.isSimilar(item)) {
            true
        } else {
            type == item.type && Bukkit.getItemFactory().equals(itemMeta, item.itemMeta)
        }
    } else {
        false
    }
}

inline fun ItemStack.meta(block: ItemMeta.() -> Unit): ItemStack = apply {
    itemMeta = itemMeta.apply(block)
}

var ItemStack.displayName: String
    get() = if (hasItemMeta() && itemMeta.hasDisplayName()) itemMeta.displayName else ""
    set(value) {
        meta {
            setDisplayName(value)
        }
    }

var ItemStack.localizedName: String
    get() = if (hasItemMeta() && itemMeta.hasLocalizedName()) itemMeta.localizedName else ""
    set(value) {
        meta {
            setLocalizedName(value)
        }
    }

var ItemStack.text: List<String>
    get() {
        val displayName = displayName
        val lore = lore
        return if (displayName.isEmpty() && (lore == null || lore.isEmpty())) {
            emptyList()
        } else {
            ArrayList<String>(1 + (lore?.size ?: 0)).apply {
                add(displayName)
                if (lore != null) {
                    addAll(lore)
                }
            }
        }
    }
    set(value) {
        if (value.isEmpty()) {
            meta {
                setDisplayName(null)
                lore = null
            }
        } else {
            meta {
                if (value.isNotEmpty()) {
                    setDisplayName(ChatColor.RESET.toString() + value[0])
                }
                if (value.size > 1) {
                    lore = value.subList(1, value.size).map { ChatColor.RESET.toString() + it }
                }
            }
        }
    }

fun ItemStack.setText(text: Iterable<String>) {
    this.text = text.toList()
}

fun ItemStack.setText(vararg text: String) {
    this.text = text.toList()
}

fun ItemStack.setText(text: String) {
    this.text = text.split("\n")
}

var ItemStack.damage: Int
    get() = if (itemMeta is Damageable) (itemMeta as Damageable).damage else 0
    set(value) {
        meta { if (this is Damageable) damage = value }
    }

val ItemStack.maxDamage
    get() = if (!isNullOrAir()) 0 else damage

var ItemStack.damagePercent: Double
    get() {
        if (!isNullOrAir()) {
            return 0.0
        }
        if (maxDamage == 0) {
            return 1.0
        }
        return 1.0 - damage.toDouble() / maxDamage.toDouble()
    }
    set(value) {
        meta {
            val percent = if (value > 1.0) 1.0 else if (value < 0.0) 0.0 else value
            if (damage != 0) {
                damage = (maxDamage.toDouble() * (1.0 - percent)).toInt()
            }
        }
    }

fun ItemStack.hideAttributes() = addItemFlags(*ItemFlag.values())

fun ItemStack.showAttributes() = removeItemFlags(*ItemFlag.values())

fun ItemStack.setColor(color: Color) {
    when (type) {
        Material.LEATHER_HELMET,
        Material.LEATHER_CHESTPLATE,
        Material.LEATHER_LEGGINGS,
        Material.LEATHER_BOOTS,
        Material.LEATHER_HORSE_ARMOR -> {
            meta {
                this as LeatherArmorMeta
                setColor(color)
            }
        }
        else -> {
            // NOTHING
        }
    }
}

