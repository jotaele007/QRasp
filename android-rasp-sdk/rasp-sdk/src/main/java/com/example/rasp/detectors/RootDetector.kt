package com.example.rasp.detectors

import android.content.Context
import com.example.rasp.RaspConfig
import com.example.rasp.model.*
import java.io.File

class RootDetector : Detector {

    private val paths = listOf(
        "/system/bin/su",
        "/system/xbin/su",
        "/sbin/su"
    )

    override fun detect(context: Context) =
        if (paths.any { File(it).exists() })
            Threat("ROOT", "Root detected", Severity.CRITICAL)
        else null

    override fun isEnabled(config: RaspConfig) = config.detectRoot
}
