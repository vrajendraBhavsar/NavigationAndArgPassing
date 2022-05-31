package com.example.navigationandargpassing.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.navigationandargpassing.Screens

@Composable
fun MainScreen(navController: NavController) { // navController to navigate to another screen
    var userName by remember {
        mutableStateOf("")
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 50.dp),

        ) {
        OutlinedTextField(
            value = userName, onValueChange = {
                userName = it
            },
            modifier = Modifier
//                .padding(16.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
//            navController.navigate(route = Screen.DetailScreen.route)
//            navController.navigate(route = Screens.DetailScreen.withArgs(userName))  //Navigate and pass argument with it
            //..
            navController.navigate(route = Screens.DetailScreen.withArgs(userName)) //detail_screen/userText
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "To DetailScreen")
        }
    }
}