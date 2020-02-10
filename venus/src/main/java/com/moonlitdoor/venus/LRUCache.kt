package com.moonlitdoor.venus

import java.util.LinkedHashMap


class LRUCache<K, V>(private val cacheSize: Int) : LinkedHashMap<K, V>(16, 0.75f, true) {

    override fun removeEldestEntry(p0: MutableMap.MutableEntry<K, V>?): Boolean {
        return size >= cacheSize
    }


}