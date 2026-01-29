package com.example.rasp.detectors

import android.content.Context
import com.example.rasp.RaspConfig
import com.example.rasp.model.*

class TamperDetector : Detector {
    override fun detect(context: Context): Threat? {
        val expected = "YOUR_RELEASE_SIGNATURE_HASH"
        val actual = context.packageManager
            .getPackageInfo(context.packageName, 0)
            .signatures.first().toCharsString()

        return if (!actual.contains(expected))
            Threat("TAMPER", "Signature mismatch", Severity.CRITICAL)
        else null
    }

    override fun isEnabled(config: RaspConfig) = config.detectTampering
}
