package org.arexdev.rickmortyapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform