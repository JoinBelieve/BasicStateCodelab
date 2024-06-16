package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        var count by rememberSaveable {
            mutableIntStateOf(0)
        }
        if (count > 0) {
            var showTask by remember {
                mutableStateOf(true)
            }
            if (showTask) {
                WellnessTaskItem(
                    taskName = "Have you taken your 15 minute walk today?",
                    checked = false,
                    onClose = {},
                    onCheckedChange = {}
                )
            }
            Text(
                text = "You've had $count glasses.", modifier = modifier.padding(16.dp)
            )
        }
        Row(
            Modifier.padding(top = 8.dp)
        ) {
            Button(
                onClick = {
                    count++
                },
                enabled = count < 10
            ) {
                Text(text = "Add one")
            }
            Button(
                onClick = { count = 0 }, Modifier.padding(start = 8.dp)
            ) {
                Text(text = "Clear water count")
            }
        }

    }
}