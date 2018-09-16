package com.example.nobel.votingapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.part_intermed.*

class Voteintermed: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.part_intermed)

        val ref=FirebaseDatabase.getInstance().getReference("events")
        btnpartsub.setOnClickListener({
            ref.addValueEventListener(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {
                    Toast.makeText(this@Voteintermed,"No event Created",Toast.LENGTH_LONG).show()
                }

                override fun onDataChange(p0: DataSnapshot) {

                    if(p0!!.exists()){
                        lateinit var fdv:FirebaseDataView
                        var flag:Int=0
                        val pass=etinter?.text.toString()
                        for(h in p0.children){

                            if(h.key.toString().compareTo(pass)==0){

                                Toast.makeText(this@Voteintermed,"Event-id Exist",Toast.LENGTH_LONG).show()
                                fdv= FirebaseDataView(h.child("part1").value.toString(),h.child("part2").value.toString(),h.child("part3").value.toString(),h.child("part4").value.toString(),h.child("vp1").value.toString(),h.child("vp2").value.toString(),h.child("vp3").value.toString(),h.child("vp4").value.toString())
                                flag=1
                                break
                            }
                        }
                        if(flag==1){
                            val intent=Intent(this@Voteintermed,Particui::class.java)
                            intent.putExtra("p1",fdv.Part1)
                            intent.putExtra("p2",fdv.Part2)
                            intent.putExtra("p3",fdv.Part3)
                            intent.putExtra("p4",fdv.Part4)
                            intent.putExtra("vp1",fdv.vp1)
                            intent.putExtra("vp2",fdv.vp2)
                            intent.putExtra("vp3",fdv.vp3)
                            intent.putExtra("vp4",fdv.vp4)
                            intent.putExtra("id",pass)
                            startActivity(intent)
                        }
                        if(flag==0){
                            Toast.makeText(this@Voteintermed,"Wrong Event-id",Toast.LENGTH_LONG).show()
                        }
                    }else{
                        Toast.makeText(this@Voteintermed, "NO Event is created2", Toast.LENGTH_LONG).show();
                        return
                    }
                }
            })



        })


    }
}