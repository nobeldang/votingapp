package com.example.nobel.votingapp


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.adminui.*
import android.content.Intent
import com.google.firebase.database.FirebaseDatabase








class Adminclass: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.adminui)


        btnsubmit.setOnClickListener({
            val name1=etname1?.text.toString().trim()
            val name2=etname2?.text.toString().trim()
            val name3=etname3?.text.toString().trim()
            val name4=etname4?.text.toString().trim()
            val mRootRef = FirebaseDatabase.getInstance().getReference("events")
            val id= mRootRef.push().key as String
            val cell=FDcell(name1,name2,name3,name4,0,0,0,0)
            mRootRef.child(id).setValue(cell).addOnCompleteListener{
                Toast.makeText(this, "Thanks for creating an event", Toast.LENGTH_LONG).show();
            }


            val i = Intent(this, MainActivity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(i)
        })



    }
}