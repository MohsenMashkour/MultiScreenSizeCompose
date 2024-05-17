package com.mkrdeveloper.multiscreensizecompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen(modifier: Modifier) {
val windowSize = rememberWindowSize()
    when(windowSize.width){
        WindowType.SMALL -> ProfileScreenPortrait(modifier)
        else -> ProfileScreenLandscape(modifier)
    }
}

@Composable
fun ProfileScreenPortrait(modifier: Modifier) {

    Column(
        modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Box(modifier = modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "",
                modifier = modifier.size(200.dp)
            )
        }
        PersonalData("Name", "MkrDeveloper")
        PersonalData("Email", "john.mckinley@examplepetstore.com")
        PersonalData("Phone", "0123456789")
    }
}

@Composable
fun ProfileScreenLandscape(modifier: Modifier) {

    Row(
        modifier
            .fillMaxSize()
            .padding(start = 16.dp)
    ) {
        Box(modifier = modifier
            .fillMaxHeight()
            .padding(16.dp), contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "",
                modifier = modifier.size(400.dp)
            )
        }
        Column(modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)) {
            PersonalData("Name", "MkrDeveloper")
            PersonalData("Email", "john.mckinley@examplepetstore.com")
            PersonalData("Phone", "0123456789")
        }
    }
}

@Composable
fun PersonalData(title: String, content: String) {
    Column(Modifier.padding(12.dp)) {
        Text(text = title, fontWeight = FontWeight.Bold)
        Text(text = content)
        Spacer(modifier = Modifier.height(6.dp))
    }
}