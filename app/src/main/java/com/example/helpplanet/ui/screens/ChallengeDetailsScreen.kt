package com.example.helpplanet.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp

@Composable
fun ChallengeDetailsScreen(
    challengeId: Int,
    onBack: () -> Unit
) {
    var isCompleted by rememberSaveable { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 32.dp, start = 16.dp, end = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Text(
                text = "Desafio #$challengeId",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onBackground
            )

            Text(
                text = "Categoria: Sustentabilidade",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onBackground
            )

            Divider(color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.4f))

            Text(
                text = "Descrição",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground
            )

            Text(
                text = "Este desafio incentiva práticas sustentáveis simples que podem ser aplicadas no dia a dia, ajudando a reduzir impactos ambientais e promover consciência ecológica.",
                color = MaterialTheme.colorScheme.onBackground
            )

            Text(
                text = "Impacto Ambiental",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground
            )

            Text("🌱 Redução de consumo de recursos naturais", color = MaterialTheme.colorScheme.onBackground)
            Text("💧 Economia de água e energia", color = MaterialTheme.colorScheme.onBackground)
            Text("♻️ Menor geração de resíduos", color = MaterialTheme.colorScheme.onBackground)

            Text(
                text = "Duração estimada",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground
            )

            Text("⏱️ 1 dia", color = MaterialTheme.colorScheme.onBackground)

            if (isCompleted) {
                Text(
                    text = "✅ Desafio concluído com sucesso!",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            Button(
                onClick = { isCompleted = true },
                enabled = !isCompleted,
                modifier = Modifier.semantics {
                    contentDescription = "Concluir desafio sustentável"
                }
            ) {
                Text(if (isCompleted) "Concluído" else "Concluir desafio")
            }

            OutlinedButton(
                onClick = onBack,
                modifier = Modifier.semantics {
                    contentDescription = "Voltar para a lista de desafios"
                }
            ) {
                Text("Voltar", color = MaterialTheme.colorScheme.onBackground)
            }
        }
    }
}