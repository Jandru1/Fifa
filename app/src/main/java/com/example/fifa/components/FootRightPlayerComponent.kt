package com.example.fifa.components

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.ImageView
import com.example.fifa.R

class FootRightPlayerComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val imageView: ImageView

    var myFoot: String = "Left"
        set(value) {
            field = value
            selectImage()
        }

    /*
        fun setMyFoot(foot: String) {
            myFoot = foot
            selectImage()
        }*/

    init {
        imageView = ImageView(context)
        addView(imageView)

        /*Log.w("ZURDOODIESTRO", "El jugador es $myFoot")
        imageView = if (myFoot == "Right") {
            inflate(context, R.layout.diestro, this)
                .findViewById(R.id.diestro)
        } else{
            inflate(context, R.layout.zurdo, this)
                .findViewById(R.id.zurdo)
        }*/

    }

    @SuppressLint("ResourceType")
    private fun selectImage() {
        imageView.setImageResource(
            if (myFoot == "Right") {
                R.drawable.diestroverde
            } else {
                R.drawable.diestronegro
            }
        )
    }

}
