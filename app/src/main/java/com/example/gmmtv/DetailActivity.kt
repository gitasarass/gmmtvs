package com.example.gmmtv

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvDetailName: TextView = findViewById(R.id.tv_item_name)
        val tvDetailDescription: TextView = findViewById(R.id.tv_item_description)
        val tvDetailBorn: TextView = findViewById(R.id.tv_item_born)
        val ivDetailPhoto: ImageView = findViewById(R.id.img_item_photo)
        val ivDetailPhoto2: ImageView = findViewById(R.id.img_item_photo2)
        val ivDetailPhoto3: ImageView = findViewById(R.id.img_item_photo3)
        val tvDetailDrama: TextView = findViewById(R.id.tv_item_drama)
        val ivDetailPhoto4: ImageView = findViewById(R.id.img_item_photo4)
        val tvDetailDrama2: TextView = findViewById(R.id.tv_item_drama2)
        val ivDetailPhoto5: ImageView = findViewById(R.id.img_item_photo5)
        val tvDetailDrama3: TextView = findViewById(R.id.tv_item_drama3)

        val data = intent.getParcelableExtra<Artist>("DATA")
        Log.d("DATA", data?.name.toString())


        if (data != null) {
            tvDetailName.text = data.name
            tvDetailDescription.text = data.description
            tvDetailBorn.text = data.born
            val tvDetailPop: TextView = findViewById(R.id.tv_dramapop)
            tvDetailPop.text = getString(R.string.gmmtv_pop)
            ivDetailPhoto.setImageResource(data.photo)
            ivDetailPhoto2.setImageResource(data.photo2)
            ivDetailPhoto3.setImageResource(data.photo3)
            tvDetailDrama.text = data.drama
            ivDetailPhoto4.setImageResource(data.photo4)
            tvDetailDrama2.text = data.drama2
            ivDetailPhoto5.setImageResource(data.photo5)
            tvDetailDrama3.text = data.drama3
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_share -> {
                shareContent()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun shareContent() {
        val data = intent.getParcelableExtra<Artist>("DATA")
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"

        val title = data?.name
        val description = data?.description

        shareIntent.putExtra(Intent.EXTRA_SUBJECT, title)
        shareIntent.putExtra(Intent.EXTRA_TEXT, description)
        startActivity(Intent.createChooser(shareIntent, "Share via"))
    }
}
