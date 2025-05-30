package com.dazt.platzimusic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.dazt.platzimusic.data.FakeTaskLocalDataSource
import com.dazt.platzimusic.domain.Task
import com.dazt.platzimusic.ui.theme.MyAppTheme
import java.util.UUID

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyAppTheme {
                var text by remember {
                    mutableStateOf("")
                }
                val fake = FakeTaskLocalDataSource()

                LaunchedEffect(true) {
                    fake.taskFlow.collect {
                        text = it.toString()
                    }
                }

                LaunchedEffect(true) {
                    fake.addTask(Task(UUID.randomUUID().toString(), "Title1"))
                }
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Text(
                        text = text,
                        modifier = Modifier
                            .padding(top = innerPadding.calculateTopPadding())
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}