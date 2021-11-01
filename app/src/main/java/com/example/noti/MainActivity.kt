package com.example.noti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var notName:EditText
    lateinit var notDes:EditText
    lateinit var btnSave: Button
    lateinit var tvDes:TextView
    lateinit var etRet:EditText
    lateinit var btRet:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var db=mydatadase(applicationContext)
        etRet=findViewById(R.id.etRet)
        btRet=findViewById(R.id.btRet)
        notName=findViewById(R.id.etName)
        notDes=findViewById(R.id.etDes)
        tvDes=findViewById(R.id.tvRet)
        btnSave=findViewById(R.id.save)

        btnSave.setOnClickListener {     /////btnSave
            var s1=notName.text.toString()
            var s2=notDes.text.toString()
            var status=db.save(s1,s2)
            Toast.makeText(this, "note saved!"+status, Toast.LENGTH_LONG).show()
        notName.text.clear()
            notDes.text.clear()
        }
        btRet.setOnClickListener {///btnretrave
            var s1=etRet.text.toString()
            var desc=db.retrave(s1)
            tvDes.text=desc

        }

    }


}
