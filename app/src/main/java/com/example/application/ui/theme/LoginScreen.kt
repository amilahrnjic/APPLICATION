package com.example.application.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.application.R

@Composable
fun LoginScreen() {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Add the image above the "Welcome back, Login!" text
        Box(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .padding(10.dp), // Add padding to create a frame effect
            contentAlignment = Alignment.Center
        ) {
            // Adding a circular frame around the image
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape) // Make the image circular
                    .border(5.dp, MyTheme.LightPurple, CircleShape)
            ) {
                // image
                Image(
                    painter = painterResource(id = R.drawable.slika8),
                    contentDescription = "Your Image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
        }

        Text(
            text = "Welcome back, Login!",
            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold), // Make the text bold
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp)) // Adding space between fields
        TextField(
            value = "",
            onValueChange = { /* TODO */ },
            enabled = true,
            label = {
                Text(text = "email")
            },
            placeholder = {
                Text(text = "example@exmaple.com")
            },
            isError = false
        )

        Spacer(modifier = Modifier.height(8.dp)) // Adding space between fields
        TextField(
            value = "",
            onValueChange = { /* TODO */},
            label = {
                Text(text = "password")
            }
        )
        Spacer(modifier = Modifier.height(16.dp)) // Adding space between fields
        Button(
            onClick = { /* Handle button click */ },
            colors = ButtonDefaults.buttonColors(containerColor = MyTheme.Purple), // Use the custom pink color
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Text(text = "LOGIN", color = Color.White)
        }
        Spacer(modifier = Modifier.height(5.dp)) // Adding space between button and text
        Text(
            text = "Don't have an account yet?",
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 16.dp)
        )
    }
}

/* varijabla na pocetku false mutablestateof, kada user unese pass provjerimo sa funkcijom,
ta funkcija ce pormijeniti pocetnu varijablu - ispod text file pass if variabla = true -> vrati text
 */

@Composable
fun RoundedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label, color = Color.Gray) },
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
            .height(40.dp)
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(15.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    MaterialTheme {
        LoginScreen()
    }
}