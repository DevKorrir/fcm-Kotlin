package dev.korryr.fcm.ui.features

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier

@Composable
fun Request(
    modifier: Modifier = Modifier,
    openDialog: MutableState<Boolean>,
    onConfirm: () -> Unit,
) {
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
                onConfirm()
            },
            title = {
                Text(text = "Permission Request")
            },
            text = {
                Text(text = "Push notification permission required to get latest news.")
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Warning,
                    contentDescription = "Warning"
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                        onConfirm()
                    }
                ) {
                    Text(text = "Confirm")
                }
            },
        )
    }
}