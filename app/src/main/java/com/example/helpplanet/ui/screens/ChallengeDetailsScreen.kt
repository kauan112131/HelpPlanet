package com.example.helpplanet.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp

@Composable
fun ChallengeDetailsScreen(
    challengeId: Int,
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(
            text = "Detalhes do Desafio #$challengeId",
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = "Este desafio ajuda a promover hábitos sustentáveis no dia a dia."
        )

        Button(
            onClick = onBack,
            modifier = Modifier.semantics {
                contentDescription = "Voltar para a lista de desafios"
            }
        ) {
            Text("Voltar")
        }
    }
}
