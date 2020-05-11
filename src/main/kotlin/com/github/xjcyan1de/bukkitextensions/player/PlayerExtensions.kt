package com.github.xjcyan1de.bukkitextensions.player

import org.bukkit.Location
import org.bukkit.Particle
import org.bukkit.Sound
import org.bukkit.SoundCategory
import org.bukkit.attribute.Attribute
import org.bukkit.entity.Player

@JvmOverloads
fun Player.playSound(
        sound: Sound,
        pitch: Number = 1.0f,
        volume: Number = Float.MAX_VALUE,
        category: SoundCategory = SoundCategory.MASTER,
        location: Location = this.location
) = playSound(location, sound, category, volume.toFloat(), pitch.toFloat())

@JvmOverloads
fun Player.spawnParticle(location: Location, particle: Particle, count: Int = 1) =
        spawnParticle(particle, location, count)

fun Player.clearTitle() =
        sendTitle(" ", " ", 0, 20, 0)

fun Player.clearEffects() = activePotionEffects.forEach {
    removePotionEffect(it.type)
}

fun Player.heal(heal: Double) {
    val maxHealth = getAttribute(Attribute.GENERIC_MAX_HEALTH)!!.value
    health = if (heal + health > maxHealth) maxHealth else heal + health
}

fun Player.heal() {
    health = getAttribute(Attribute.GENERIC_MAX_HEALTH)!!.value
}

fun Player.feed() {
    saturation = 20.0f
    foodLevel = 20
}

fun Player.kill() {
    health = 0.0
}

fun Player.resetWalkSpeed() {
    walkSpeed = 0.2f
}

fun Player.resetFlySpeed() {
    flySpeed = 0.1f
}