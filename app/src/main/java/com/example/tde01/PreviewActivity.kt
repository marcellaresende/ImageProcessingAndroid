package com.example.tde01

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class PreviewActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PHOTO_URI = "com.example.tde01.EXTRA_PHOTO_URI"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)

        // Obtém a imagem da intenção
        val imageUri = intent.getParcelableExtra<Uri>(EXTRA_PHOTO_URI)



        // Exibe a imagem na ImageView
        val imageView = findViewById<ImageView>(R.id.imageView)
        imageView.setImageURI(imageUri)

        // Define o botão "Compartilhar" para compartilhar a imagem
        val shareButton = findViewById<Button>(R.id.shareButton)
        shareButton.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "image/jpeg"
            shareIntent.putExtra(Intent.EXTRA_STREAM, EXTRA_PHOTO_URI)
            startActivity(Intent.createChooser(shareIntent, "Compartilhar imagem via"))
        }
    }
}
