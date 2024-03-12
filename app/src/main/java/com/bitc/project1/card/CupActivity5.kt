package com.bitc.project1.card

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.ImageView
import androidx.core.content.FileProvider
import com.bitc.project1.R
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.UUID

class CupActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cup5)


        val btnShare: ImageView = findViewById(R.id.btnShare)

        btnShare.setOnClickListener {
            captureAndShare()
        }
    }

    private fun captureAndShare() {
        val rootView: View = window.decorView.findViewById(android.R.id.content)
        val screenshot: Bitmap = getScreenShot(rootView)

        val imageFile = saveScreenshot(screenshot)

        shareImage(imageFile)
    }

    private fun getScreenShot(view: View): Bitmap {
        view.isDrawingCacheEnabled = true
        val bitmap = Bitmap.createBitmap(view.drawingCache)
        view.isDrawingCacheEnabled = false
        return bitmap
    }

    private fun saveScreenshot(bitmap: Bitmap): File {
        val storageDir: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val imageFile = File.createTempFile(
            "screenshot_${UUID.randomUUID()}",
            ".png",
            storageDir
        )

        try {
            val stream = FileOutputStream(imageFile)
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
            stream.flush()
            stream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return imageFile
    }

    private fun shareImage(imageFile: File) {
        val imageUri = FileProvider.getUriForFile(
            this,
            "${packageName}.provider",
            imageFile
        )

        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_STREAM, imageUri)
            type = "image/png"
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }

}