package com.dmribeiro87.bankcompose.data

import androidx.compose.ui.graphics.Brush

data class Card(
    val cardType: String,
    val cardMember: String,
    val cardName: String,
    val balance: Double,
    val color: Brush
)
