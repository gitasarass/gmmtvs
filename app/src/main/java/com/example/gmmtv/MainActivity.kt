package com.example.gmmtv

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvGmmtv: RecyclerView
    private val list = ArrayList<Artist>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvGmmtv = findViewById(R.id.rv_gmmtv)
        rvGmmtv.setHasFixedSize(true)
        list.addAll(getListArtist())
        showRecyclerList()
    }

    private fun getListArtist(): ArrayList<Artist> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataBorn = resources.getStringArray(R.array.data_born)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataPhoto2 = resources.obtainTypedArray(R.array.data_photo2)
        val dataPhoto3 = resources.obtainTypedArray(R.array.data_photo3)
        val dataDrama = resources.getStringArray(R.array.data_drama)
        val dataPhoto4 = resources.obtainTypedArray(R.array.data_photo4)
        val dataDrama2 = resources.getStringArray(R.array.data_drama2)
        val dataPhoto5 = resources.obtainTypedArray(R.array.data_photo5)
        val dataDrama3 = resources.getStringArray(R.array.data_drama3)
        val listArtist = ArrayList<Artist>()
        for (i in dataName.indices) {
            val artist = Artist(
                dataName[i],
                dataBorn[i],
                dataDescription[i],
                dataPhoto.getResourceId(i, -1),
                dataPhoto2.getResourceId(i, -1),
                dataPhoto3.getResourceId(i,-1),
                dataDrama[i],
                dataPhoto4.getResourceId(i,-1),
                dataDrama2[i],
                dataPhoto5.getResourceId(i,-1),
                dataDrama3[i]
            )
            listArtist.add(artist)
        }

        return listArtist
    }

    private fun showRecyclerList() {
        rvGmmtv.layoutManager = LinearLayoutManager(this)
        val listArtistAdapter = ListArtistAdapter(list)
        rvGmmtv.adapter = listArtistAdapter

        listArtistAdapter.setOnItemClickCallback(object : ListArtistAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Artist) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("DATA", data)
                startActivity(intent)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.action_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_profile -> {
                val akun = "Data akun pengguna"
                val intent = Intent(this, ProfileActivity::class.java)
                intent.putExtra("data_key", akun)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}




