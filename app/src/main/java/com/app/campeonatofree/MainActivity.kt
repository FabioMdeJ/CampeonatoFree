package com.app.campeonatofree

//import androidx.navigation.compose
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.campeonatofree.ui.theme.CampeonatoFreeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            var telaAtual by remember { mutableStateOf("inicial") }

            CampeonatoFreeTheme {

                if (telaAtual == "inicial") {
                    TelaInicial(
                        onCriarClick = { telaAtual = "criar" }
                    )
                } else {
                    TelaCriarCampeonato()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TelaInicial(
    modifier: Modifier = Modifier,
    onCriarClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_campenatofree),
            contentDescription = "Logo Campeonato Free",
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Campeonato Free",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = onCriarClick) {
            Text("Criar Campeonato")
        }
    }
}

@Composable
fun TelaCriarCampeonato() {

    var nomeCampeonato by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Criar Campeonato",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = nomeCampeonato,
            onValueChange = {nomeCampeonato = it},
            label = { Text("Nome do campeonato") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {}) {
            Text("Salvar")
        }
    }
}
