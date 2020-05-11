package com.github.xjcyan1de.bukkitextensions.entity

import org.bukkit.entity.EntityType

val EntityType.isPassive: Boolean
    get() = when (this) {
        EntityType.BAT,
        EntityType.CAVE_SPIDER,
        EntityType.ENDERMAN,
        EntityType.PIG_ZOMBIE,
        EntityType.SPIDER,
        EntityType.WOLF,
        EntityType.POLAR_BEAR -> true
        else -> false
    }

val EntityType.isAngry: Boolean
    get() = when (this) {
        EntityType.BLAZE,
        EntityType.ELDER_GUARDIAN,
        EntityType.WITHER_SKELETON,
        EntityType.STRAY,
        EntityType.ENDER_DRAGON,
        EntityType.GHAST,
        EntityType.GIANT,
        EntityType.MAGMA_CUBE,
        EntityType.SILVERFISH,
        EntityType.SKELETON,
        EntityType.SLIME,
        EntityType.WITCH,
        EntityType.WITHER,
        EntityType.ZOMBIE,
        EntityType.HUSK,
        EntityType.ZOMBIE_VILLAGER,
        EntityType.SKELETON_HORSE,
        EntityType.ZOMBIE_HORSE,
        EntityType.ENDERMITE,
        EntityType.GUARDIAN,
        EntityType.EVOKER,
        EntityType.VEX,
        EntityType.VINDICATOR,
        EntityType.ILLUSIONER,
        EntityType.SHULKER,
        EntityType.PHANTOM,
        EntityType.DROWNED -> true
        else -> false
    }

val EntityType.isFriendly: Boolean
    get() = when (this) {
        EntityType.CHICKEN,
        EntityType.COW,
        EntityType.CREEPER,
        EntityType.HORSE,
        EntityType.MUSHROOM_COW,
        EntityType.OCELOT,
        EntityType.PIG,
        EntityType.SHEEP,
        EntityType.SQUID,
        EntityType.VILLAGER,
        EntityType.RABBIT,
        EntityType.DONKEY,
        EntityType.MULE,
        EntityType.LLAMA,
        EntityType.PARROT -> true
        else -> false
    }

val EntityType.isProjectile: Boolean
    get() = when (this) {
        EntityType.ARROW,
        EntityType.FIREBALL,
        EntityType.FISHING_HOOK,
        EntityType.SMALL_FIREBALL,
        EntityType.SNOWBALL,
        EntityType.WITHER_SKULL,
        EntityType.SPECTRAL_ARROW,
        EntityType.SHULKER_BULLET,
        EntityType.DRAGON_FIREBALL,
        EntityType.EVOKER_FANGS,
        EntityType.LLAMA_SPIT,
        EntityType.EGG,
        EntityType.ENDER_PEARL,
        EntityType.ENDER_SIGNAL,
        EntityType.SPLASH_POTION,
        EntityType.THROWN_EXP_BOTTLE,
        EntityType.TRIDENT -> true
        else -> false
    }

val EntityType.isVehicle: Boolean
    get() = when (this) {
        EntityType.MINECART,
        EntityType.MINECART_CHEST,
        EntityType.MINECART_COMMAND,
        EntityType.MINECART_FURNACE,
        EntityType.MINECART_HOPPER,
        EntityType.MINECART_MOB_SPAWNER,
        EntityType.MINECART_TNT,
        EntityType.BOAT -> true
        else -> false
    }

val EntityType.isMisc: Boolean
    get() = when (this) {
        EntityType.AREA_EFFECT_CLOUD,
        EntityType.IRON_GOLEM,
        EntityType.SNOWMAN,
        EntityType.PLAYER,
        EntityType.ARMOR_STAND,
        EntityType.EXPERIENCE_ORB,
        EntityType.PRIMED_TNT,
        EntityType.PAINTING,
        EntityType.ITEM_FRAME,
        EntityType.LEASH_HITCH,
        EntityType.FIREBALL,
        EntityType.DROPPED_ITEM -> true
        else -> false
    }