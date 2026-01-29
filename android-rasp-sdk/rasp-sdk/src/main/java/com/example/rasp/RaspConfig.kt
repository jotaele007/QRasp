package com.example.rasp

data class RaspConfig(
    val detectDebugger: Boolean = true,
    val detectRoot: Boolean = true,
    val detectEmulator: Boolean = true,
    val detectHooking: Boolean = true,
    val detectTampering: Boolean = true,
    val killAppOnThreat: Boolean = false
)
