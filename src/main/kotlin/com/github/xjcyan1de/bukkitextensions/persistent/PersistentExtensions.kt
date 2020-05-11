package com.github.xjcyan1de.bukkitextensions.persistent

import org.bukkit.NamespacedKey
import org.bukkit.persistence.PersistentDataContainer
import org.bukkit.persistence.PersistentDataType

operator fun PersistentDataContainer.set(key: NamespacedKey, byte: Byte) = set(key, PersistentDataType.BYTE, byte)
operator fun PersistentDataContainer.set(key: NamespacedKey, short: Short) = set(key, PersistentDataType.SHORT, short)
operator fun PersistentDataContainer.set(key: NamespacedKey, int: Int) = set(key, PersistentDataType.INTEGER, int)
operator fun PersistentDataContainer.set(key: NamespacedKey, long: Long) = set(key, PersistentDataType.LONG, long)
operator fun PersistentDataContainer.set(key: NamespacedKey, float: Float) = set(key, PersistentDataType.FLOAT, float)
operator fun PersistentDataContainer.set(key: NamespacedKey, double: Double) = set(key, PersistentDataType.DOUBLE, double)
operator fun PersistentDataContainer.set(key: NamespacedKey, string: String) = set(key, PersistentDataType.STRING, string)
operator fun PersistentDataContainer.set(key: NamespacedKey, byteArray: ByteArray) = set(key, PersistentDataType.BYTE_ARRAY, byteArray)
operator fun PersistentDataContainer.set(key: NamespacedKey, intArray: IntArray) = set(key, PersistentDataType.INTEGER_ARRAY, intArray)
operator fun PersistentDataContainer.set(key: NamespacedKey, longArray: LongArray) = set(key, PersistentDataType.LONG_ARRAY, longArray)
operator fun PersistentDataContainer.set(key: NamespacedKey, persistentDataContainer: PersistentDataContainer) = set(key, PersistentDataType.TAG_CONTAINER, persistentDataContainer)

@Suppress("IMPLICIT_CAST_TO_ANY", "UNCHECKED_CAST")
operator fun <T> PersistentDataContainer.get(key: NamespacedKey, clazz: Class<T>): T? = when (clazz) {
    Byte::class.java -> get(key, PersistentDataType.BYTE)
    Short::class.java -> get(key, PersistentDataType.SHORT)
    Int::class.java -> get(key, PersistentDataType.INTEGER)
    Long::class.java -> get(key, PersistentDataType.LONG)
    Float::class.java -> get(key, PersistentDataType.FLOAT)
    Double::class.java -> get(key, PersistentDataType.DOUBLE)
    String::class.java -> get(key, PersistentDataType.STRING)
    ByteArray::class.java -> get(key, PersistentDataType.BYTE_ARRAY)
    IntArray::class.java -> get(key, PersistentDataType.INTEGER_ARRAY)
    LongArray::class.java -> get(key, PersistentDataType.LONG_ARRAY)
    PersistentDataContainer::class.java -> get(key, PersistentDataType.TAG_CONTAINER)
    else -> null
} as? T

inline fun <reified T> PersistentDataContainer.get(key: NamespacedKey): T? = get(key, T::class.java)