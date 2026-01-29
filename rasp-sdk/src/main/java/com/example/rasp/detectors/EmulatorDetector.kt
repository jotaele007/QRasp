package com.example.rasp.detectors

import android.content.Context
import android.os.Build
import com.example.rasp.RaspConfig
import com.example.rasp.model.*

class EmulatorDetector : Detector {
    override fun detect(context: Context) =
        if (
            Build.FINGERPRINT.contains("generic") ||
            Build.MODEL.contains("Emulator") ||
            Build.BRAND.startsWith("generic")
        )
            Threat("EMULATOR", "Emulator detected", Severity.MEDIUM)
        else null

    override fun isEnabled(config: RaspConfig) = config.detectEmulator
}
