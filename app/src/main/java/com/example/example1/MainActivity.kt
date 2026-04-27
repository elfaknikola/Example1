package com.example.example1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.example1.ui.theme.Example1Theme

class MainActivity : ComponentActivity() {
    var repeat:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(this, "ON CREATE!", Toast.LENGTH_SHORT).show()
        if (savedInstanceState != null) {
            repeat = savedInstanceState.getInt("no")
        }
        repeat++;
        setContent {
            Example1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(getString(R.string.txt))
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "ON START!", Toast.LENGTH_SHORT).show()
    }
    //, onStop, onDestroy
    override fun onResume(){
        super.onResume()
        Toast.makeText(this, "ON RESUME!", Toast.LENGTH_SHORT).show()
    }

    override fun onPause(){
        Toast.makeText(this, "ON PAUSE!", Toast.LENGTH_SHORT).show()
        super.onPause()
    }

    override fun onRestart(){
        super.onRestart()
        Toast.makeText(this, "ON RESTART!", Toast.LENGTH_SHORT).show()
    }

    override fun onStop(){
        Toast.makeText(this, "ON STOP!", Toast.LENGTH_SHORT).show()
        super.onStop()
    }

    override fun onDestroy() {
        Toast.makeText(this, "ON DESTOROY!", Toast.LENGTH_SHORT).show()
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("no", repeat)
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Lifecycle examples for $name!",
        fontSize = 25.sp,
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Example1Theme {
        Greeting("Android")
    }
}