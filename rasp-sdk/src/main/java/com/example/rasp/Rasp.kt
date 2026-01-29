package com.example.rasp

import android.content.Context
import com.example.rasp.detectors.*
import com.example.rasp.model.Threat

object Rasp {

    private val detectors = listOf(
        DebuggerDetector(),
        RootDetector(),
        EmulatorDetector(),
        HookDetector(),
        TamperDetector()
    )

    fun check(context: Context, config: RaspConfig): List<Threat> {
        val threats = mutableListOf<Threat>()

        detectors.forEach {
            if (it.isEnabled(config)) {
                it.detect(context)?.let { threat -> threats.add(threat) }
            }
        }

        if (threats.isNotEmpty() && config.killAppOnThreat) {
            android.os.Process.killProcess(android.os.Process.myPid())
        }

        return threats
    }
}
