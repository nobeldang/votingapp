package com.example.nobel.votingapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.participantsui.*

class Particui: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.participantsui)
        val i=intent
        var value1=Integer.parseInt(i.getStringExtra("vp1"))
        var value2=Integer.parseInt(i.getStringExtra("vp2"))
        var value3=Integer.parseInt(i.getStringExtra("vp3"))
        var value4=Integer.parseInt(i.getStringExtra("vp4"))
        val ref=FirebaseDatabase.getInstance().getReference("events")
        val id=i.getStringExtra("id")
        tvp2.text=i.getStringExtra("p2")+"\n"+"VOTE"+value2
        tvp1.text=i.getStringExtra("p1")+"\n"+"VOTE"+value1
        tvp3.text=i.getStringExtra("p3")+"\n"+"VOTE"+value3
        tvp4.text=i.getStringExtra("p4")+"\n"+"VOTE"+value4


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

