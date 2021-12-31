package com.bigtigerflow.jetpackcomposedemo

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bigtigerflow.jetpackcomposedemo.ui.theme.JetpackComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeDemoTheme {

                MessageCard(msg = Message("Jetpack Compose 博物馆", "我们开始更新啦"))
            }
        }
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewMessageCard() {
    JetpackComposeDemoTheme() {
        MessageCard(msg = Message("Jetpack Compose 博物馆", "我们开始更新啦"))
    }
}

data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message) {
    androidx.compose.material.Surface(
        shape = shapes.medium,
        elevation = 5.dp,
        modifier = Modifier.padding(all = 8.dp)
    ) {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                painterResource(id = R.drawable.rocky8_icon),
                contentDescription = "profile picture",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colors.secondary, shape = CircleShape)
            )
            Spacer(modifier = Modifier.padding(horizontal = 8.dp))

            Column {
                Text(
                    text = msg.author,
                    color = colors.secondaryVariant,
                    style = typography.subtitle2
                )
                Spacer(modifier = Modifier.padding(vertical = 4.dp))
                Text(
                    text = msg.body,
                    style = typography.body2
                )
            }
        }
    }
}