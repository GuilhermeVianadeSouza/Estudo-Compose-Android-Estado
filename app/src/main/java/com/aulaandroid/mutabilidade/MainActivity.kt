package com.aulaandroid.mutabilidade

import android.R
import android.R.attr.contentDescription
import android.R.attr.onClick
import android.R.attr.x
import android.os.Bundle
import android.text.Layout
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.J
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aulaandroid.mutabilidade.ui.theme.MutabilidadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MutabilidadeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   TesteEstadosScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MutabilidadeTheme {
        Greeting("Android")
    }
}



@Composable
fun TesteEstadosScreen(modifier: Modifier = Modifier) {
    var backgroundColor by remember {
        mutableStateOf(Color(111,11,11))
    }
    Column(
        modifier  = modifier
            .background(backgroundColor)
            .fillMaxSize()
        , horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        var nome by remember {
            mutableStateOf("")
        }
        var idade by remember {
            mutableStateOf("")
        }
        var email by remember {
            mutableStateOf("")
        }
        var iCompose by remember {
            mutableStateOf(false)
        }
        var xml by remember{
            mutableStateOf(false)
        }
        var botaoRemender by remember {
            mutableStateOf(false)
        }
        var ios by remember{
            mutableStateOf(false)
        }
        var sOperacional by remember{
            mutableStateOf("")
        }

        TextField(
            value = nome,
            onValueChange = { novoValor ->
                Log.i("Teste", novoValor)
                nome = novoValor
            },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words
            ),
            placeholder = {
                Text(text = "Digite seu nome e sobrenome")
            },
            label = {
                Text(text = "Digite o nome completo.")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Icone Pessoa",
                    tint = Color(242, 201, 110)

                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Icone Pessoa",
                    tint = Color(242, 201, 110)
                )
            }
        )

        Spacer(modifier = Modifier.height(15.dp))

        TextField(
            value = idade,
            onValueChange = { novoValor ->
                Log.i("Teste", novoValor)
                idade = novoValor
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            label = {
                Text(text = "idade")
            },
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color(154, 112, 213),
                unfocusedTextColor = Color(87, 97, 21),
                unfocusedPlaceholderColor = Color(56, 43, 225)
            ),
            singleLine = true,
            shape = RoundedCornerShape(100.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { novoValor ->
                email = novoValor
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Digite seu e-mail valido")
            },
            placeholder = {
                Text(text = "Digite seu email")
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color(154, 112, 213),
                unfocusedTextColor = Color(87, 97, 21),
                unfocusedPlaceholderColor = Color(56, 43, 225),
                focusedBorderColor = Color(73, 53, 21),
                unfocusedLabelColor = Color(87, 43, 152)
            )
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = iCompose,
                onCheckedChange = {iCompose = it}
            )
            Text(text = "iCompose")
        }

        Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
            Checkbox(
                checked = xml,
                onCheckedChange = {xml = it}
            )
            Text(text = "xml")
         }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            RadioButton(
                selected = sOperacional == "Android",
                onClick = {
                    sOperacional = "Android"
                }
            )
            Text(text = "Android")
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            RadioButton(
                selected = sOperacional == "ios",
                onClick = {
                  sOperacional = "ios"
                }
            )
            Text(text = "IOS")
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ){
            Button(
                onClick = {
                    backgroundColor = Color(1, 1, 208, 255)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Magenta,
                    Color.Cyan
                ),
                border = BorderStroke(width = 8.dp, Color.DarkGray),
                shape = RoundedCornerShape(topStart = 10.dp, bottomEnd = 10.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Done,
                    contentDescription = "Ta joia padrao"
                )
                Text(text = "clique aqui")
            }

            OutlinedButton(
                onClick = {
                    backgroundColor = Color(255, 0, 255, 255)
                }
            ) {
                Text(text = "Another button")
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            var favoritado by remember {
                mutableStateOf(false)
            }

            if (favoritado){
                Icon(
                    modifier = Modifier.clickable{
                        favoritado = false
                    },
                    imageVector = Icons.Default.Warning,
                    contentDescription = "perigo"
                )
            } else {
                Icon(
                    modifier = Modifier.clickable{
                        favoritado = true
                    },
                    imageVector = Icons.Default.Build,
                    contentDescription = "construindo"
                )
            }
        }
    }
}