package com.example.fifa.presentation.login
import android.graphics.Paint.Align
import android.widget.Toast
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.TextField
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fifa.R
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

const val LOGIN_TEXT_FIELD_PASSWORD = "LOGIN_TEXT_FIELD_PASSWORD"
const val LOGIN_TEXT_FIELD_EMAIL = "LOGIN_TEXT_FIELD_EMAIL"

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit
    ) {

    val laligaFont = FontFamily(Font(R.font.laligafuente))

    val ctx = LocalContext.current


    var email by remember {
        // mutableStateOf("")
        mutableStateOf("agomezo456@gmail.com")
    }

    var password by remember {
        mutableStateOf("MyPassword")
        //mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.pedriojos),
            contentDescription = "pedri",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
    }


    Column(
        modifier = Modifier
            .fillMaxSize(),
           // .background(Color.Transparent),
    //    verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    )

    {

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
        )

        Row(
            modifier = Modifier
        ) {
            Image(
                modifier = Modifier.size(150.dp),
                painter = painterResource(id = R.drawable.laligalogo),
                contentDescription = "laliga",
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            TextField(
                modifier = Modifier
                    .testTag(LOGIN_TEXT_FIELD_EMAIL)
                    .background(Color.White),
                value = email,
                onValueChange = {
                    email = it
                },
                placeholder = {
                    androidx.compose.material.Text("Email")
                },
                textStyle = androidx.compose.ui.text.TextStyle(
                    fontFamily = laligaFont,
                ),
                leadingIcon = {
                    Image(
                        imageVector = Icons.Default.Email,
                        contentDescription = ""
                    )
                }
            )
        }
        Row() {
            TextField(
                modifier = Modifier
                    .testTag(LOGIN_TEXT_FIELD_PASSWORD)
                    .background(Color.White),
                value = password,
                onValueChange = {
                    password = it
                },
                placeholder = {
                    androidx.compose.material.Text("Email")
                },
                textStyle = androidx.compose.ui.text.TextStyle(
                    fontFamily = laligaFont
                ),
                leadingIcon = {
                    Image(
                        imageVector = Icons.Default.Lock,
                        contentDescription = ""
                    )
                }
            )
        }
        Spacer(
            modifier = Modifier
                .size(10.dp)
        )

        Button(
            onClick = {
                if(email.lowercase() == "agomezo456@gmail.io".lowercase() && password.lowercase() == "MyPassword".lowercase()) onLoginSuccess()
                else Toast.makeText(ctx, "Login incorrecto. Vuelva a intentarlo", Toast.LENGTH_SHORT).show()
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.rojoLogoLaliga))

        ) {
            androidx.compose.material.Text(
                text = "Login",
                style = androidx.compose.ui.text.TextStyle(
                    fontFamily = laligaFont
                ),
                color = Color.White
            )
        }

        /*Button(
            onClick = {
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            androidx.compose.material.Text(
                text = "Forgot",
                color = Color.Black,
                style = androidx.compose.ui.text.TextStyle(
                    fontFamily = laligaFont
                ),
            )
        }*/
    }
}
@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        onLoginSuccess = {
        }
    )
}

@Composable
fun Animation() {
    Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        content = {
            val infiniteTransition = rememberInfiniteTransition()
            val rotation by infiniteTransition.animateFloat(
                initialValue = 0f,
                targetValue = 360f,
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        durationMillis = 600,
                        easing = FastOutLinearInEasing
                    )
                )
            )
            Image(painter = painterResource(id = R.drawable.jabulani), contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .rotate(rotation))
        }
    )

}



//FUENTE DE LA LIGA
//BOTON FORGOT FUERA
//COLOR DE LOGIN?
//EMAIL Y PASSWORD?
//