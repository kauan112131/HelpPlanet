package com.example.helpplanet.ui.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.example.helpplanet.data.model.EcoChallenge


@Composable
fun ChallengeItem(
    challenge: EcoChallenge,
    onClick: () -> Unit
) {
     Card(
         modifier = Modifier
             .fillMaxWidth()
             .clickable { onClick() }
             .semantics {
                 contentDescription = "Desafio ecológico: ${challenge.title}"
             }
     ) {
         Column(modifier = Modifier.padding(16.dp)) {
             Text(
                 text = challenge.title,
                 style = MaterialTheme.typography.titleMedium
             )
             Spacer(modifier = Modifier.height(4.dp))
             Text(
                 text = challenge.description,
                 style = MaterialTheme.typography.bodyMedium
             )
         }
     }
 }