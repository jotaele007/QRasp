package com.example.rasp.detectors

import android.content.Context
import android.os.Debug
import com.example.rasp.RaspConfig
import com.example.rasp.model.*

class DebuggerDetector : Detector {
    override fun detect(context: Context) =
        if (Debug.isDebuggerConnected())
            Threat("DEBUGGER", "Debugger attached", Severity.HIGH)
        else null

    override fun isEnabled(config: RaspConfig) = config.detectDebugger
}
