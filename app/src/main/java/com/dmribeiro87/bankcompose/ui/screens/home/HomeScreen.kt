package com.dmribeiro87.bankcompose.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dmribeiro87.bankcompose.components.BottomNavigationBar
import com.dmribeiro87.bankcompose.ui.screens.home.sections.CardSection
import com.dmribeiro87.bankcompose.ui.screens.home.sections.CurrencySection
import com.dmribeiro87.bankcompose.ui.screens.home.sections.FinanceSection
import com.dmribeiro87.bankcompose.ui.screens.home.sections.WalletSection


@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    Scaffold(
        bottomBar = {
            BottomNavigationBar()
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues)
        ) {
            WalletSection()
            CardSection()
            Spacer(modifier = Modifier.height(16.dp))
            FinanceSection()
            CurrencySection()
        }

    }
}