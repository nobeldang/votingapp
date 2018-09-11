package com.example.nobel.votingapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.participantsui.*

class Particui: AppCompatActivity() {
    private var value1=0
    private var value2=0
    private var value3=0
    private var value4=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.participantsui)
        val i=intent
        val ref=FirebaseDatabase.getInstance().getReference("events")
        val id=i.getStringExtra("id")
        ref.addValueEventListener(object :ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                Log.d("hel3","fucking hang")
                value1=Integer.parseInt(p0.child(id).child("vp1").value.toString())
                value2=Integer.parseInt(p0.child(id).child("vp2").value.toString())
                value3=Integer.parseInt(p0.child(id).child("vp3").value.toString())
                value4=Integer.parseInt(p0.child(id).child("vp4").value.toString())
            }
        })
        tvp1.text=i.getStringExtra("p1")+"\n"+"VOTE"+value1.toString()
        tvp2.text=i.getStringExtra("p2")+"\n"+"VOTE"+value2.toString()
        tvp3.text=i.getStringExtra("p3")+"\n"+"VOTE"+value3.toString()
        tvp4.text=i.getStringExtra("p4")+"\n"+"VOTE"+value4.toString()

            tvp1.setOnClickListener {

                value1++
                ref.child(id).child("vp1").setValue(value1)
                tvp1.text=i.getStringExtra("p1")+"\n"+"VOTE: "+value1

            }
        tvp2.setOnClickListener {

            value2++
            ref.child(id).child("vp2").setValue(value2)
            tvp2.text=i.getStringExtra("p2")+"\n"+"VOTE: "+value2

        }
        tvp3.setOnClickListener {

            value3++
            ref.child(id).child("vp3").setValue(value3)
            tvp3.text=i.getStringExtra("p3")+"\n"+"VOTE: "+value3

        }
        tvp4.setOnClickListener {

            value4++
            ref.child(id).child("vp4").setValue(value4)
            tvp4.text=i.getStringExtra("p4")+"\n"+"VOTE: "+value4

        }



       }


    }

