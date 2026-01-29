package com.example.rasp.detectors

import android.content.Context
import com.example.rasp.RaspConfig
import com.example.rasp.model.Threat

interface Detector {
    fun detect(context: Context): Threat?
    fun isEnabled(config: RaspConfig): Boolean
}
