package com.mohaberabi.kmpessentials

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mohaberabi.kmpessentials.theme.AppTheme
import com.mohaberabi.kmpessentials.theme.ThemeMode
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import thekmpessentials.composeapp.generated.resources.Res
import thekmpessentials.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {

    val datastore = rememberDataStore()
    val themeSource = rememberThemeSource(prefs = datastore)

    val theme by themeSource.getThemeMode().collectAsStateWithLifecycle(ThemeMode.System)


    val scope = rememberCoroutineScope()
    AppTheme(
        mode = theme
    ) {

        Scaffold { padding ->
            Column(
                modifier = Modifier.fillMaxSize().padding(padding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    "Change Your Theme ",
                    style = MaterialTheme.typography.headlineLarge,
                    textAlign = TextAlign.Center
                )
                ThemeMode.entries.forEach { mode ->
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            mode.name,
                            style = MaterialTheme.typography.titleSmall
                        )
                        RadioButton(
                            selected = mode == theme,
                            onClick = {
                                scope.launch {
                                    themeSource.changeTheme(mode)
                                }
                            }
                        )
                    }

                }
            }
        }

    }
}