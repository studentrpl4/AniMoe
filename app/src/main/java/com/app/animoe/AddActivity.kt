package com.app.animoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {

    lateinit var ref : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        ref = FirebaseDatabase.getInstance().getReference("anime")

        btnAdd.setOnClickListener {
            savedata()
        }
    }

    private fun savedata() {
        val nama = inputAnime.text.toString()

        val animeId = ref.push().key.toString()
        val anime = Anime(animeId,nama)


        ref.child(animeId).setValue(anime).addOnCompleteListener {
            Toast.makeText(this, "Successs",Toast.LENGTH_SHORT).show()
            inputAnime.setText("")
        }
    }
}