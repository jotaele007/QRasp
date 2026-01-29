package com.example.rasp.detectors

import android.content.Context
import com.example.rasp.RaspConfig
import com.example.rasp.model.*
import java.io.BufferedReader
import java.io.FileReader

class HookDetector : Detector {
    override fun detect(context: Context): Threat? =
        try {
            BufferedReader(FileReader("/proc/self/maps")).useLines {
                if (it.any { line -> line.contains("frida") || line.contains("xposed") })
                    Threat("HOOK", "Hooking detected", Severity.CRITICAL)
                else null
            }
        } catch (e: Exception) { null }

    override fun isEnabled(config: RaspConfig) = config.detectHooking
}
