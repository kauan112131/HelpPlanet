package com.example.helpplanet.ui.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.helpplanet.data.model.EcoChallenge
import com.example.helpplanet.viewmodel.WeatherUiState
import com.example.helpplanet.viewmodel.WeatherViewModel
import com.example.helpplanet.ui.components.ChallengeItem
import androidx.compose.ui.Alignment



@Composable
fun HomeScreen(
    weatherViewModel: WeatherViewModel = viewModel(),
    onChallengeClick: (Int) -> Unit
) {
    val uiState by weatherViewModel.uiState.collectAsState()


    LaunchedEffect(Unit) {
        weatherViewModel.loadWeather(-8.05, -34.9)
    }


    when (uiState) {
        is WeatherUiState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }


        is WeatherUiState.Error -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Erro ao carregar desafios")
            }
        }


        is WeatherUiState.Success -> {
            val challenges = listOf(
                EcoChallenge(1, "Economizar água", "Reduza o tempo do banho hoje"),
                EcoChallenge(2, "Reduzir plástico", "Evite copos descartáveis"),
                EcoChallenge(3, "Economizar energia", "Desligue aparelhos da tomada")
            )


            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(challenges) { challenge ->
                    ChallengeItem(
                        challenge = challenge,
                        onClick = {
                            onChallengeClick(challenge.id)
                        }
                    )
                }
            }
        }
    }
}