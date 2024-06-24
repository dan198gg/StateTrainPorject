package com.example.statetrainproject

import android.graphics.drawable.Drawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment


import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.statetrainproject.ui.theme.StateTrainProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            con()
        }
    }
}
@Composable
fun con(){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(5.dp, 250.dp)){
        cyclyes()
    }
}

@Composable
fun cyclyes(quantity:Int=5){
    var context= LocalContext.current
    var text by rememberSaveable {
        mutableStateOf("")
    }
    var cycle by rememberSaveable {
        mutableStateOf(0)
    }
    var color by remember {
        mutableStateOf(Color.Green)
    }
    var color2 by remember {
        mutableStateOf(Color.Gray)
    }
    TextField(value =text , onValueChange ={

                                            if(text.length<=quantity){
                                            text=it
                                            cycle=text.length
                                            Log.i("R",cycle.toString())}
                                            else{
                                                Toast.makeText(context, "превышено допустимое кол-во символов", Toast.LENGTH_SHORT).show()
                                                text=""
                                                cycle=text.length
                                            }}, modifier = Modifier.size(400.dp,65.dp))

    Row(modifier = Modifier
        .size(400.dp, 70.dp)
        .background(Color.Black)) {
        repeat(cycle) {
            Row(modifier = Modifier.size(65.dp)) {
                if (cycle == quantity+1) {
                    color = Color.Red
                } else {
                    color = Color.Green
                }
                Canvas(
                    modifier = Modifier
                        .size(60.dp).align(Alignment.CenterVertically).offset(5.dp,0.dp)
                ) {
                    drawCircle(color)
                }
            }
        }
        repeat(quantity-cycle+1) {
            Row(modifier = Modifier.size(65.dp)) {


                Canvas(
                    modifier = Modifier
                        .size(40.dp).align(Alignment.CenterVertically).offset(15.dp,0.dp)
                ) {
                    drawCircle(color2, center = this.center)
                }
            }
        }

    }
}

