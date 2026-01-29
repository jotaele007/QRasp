package com.example.rasp.model

data class Threat(
    val id: String,
    val description: String,
    val severity: Severity
)

enum class Severity {
    LOW, MEDIUM, HIGH, CRITICAL
}
