package com.example.nobel.votingapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.ErrorCodes
import com.firebase.ui.auth.IdpResponse
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*






class MainActivity : AppCompatActivity() {
    val RC_SIGN_IN = 123
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnadmin.setOnClickListener({
            val firebaseUser = FirebaseAuth.getInstance().currentUser;
            if (firebaseUser != null) {
                val intent = Intent(this,Adminclass::class.java)
                startActivity(intent)
            }
            else {
                startActivityForResult(
                        AuthUI.getInstance()
                                .createSignInIntentBuilder()
                                .setAvailableProviders(Arrays.asList(
                                        AuthUI.IdpConfig.GoogleBuilder().build()))
                                .build(),
                        RC_SIGN_IN);


            }
        })
        btnpart.setOnClickListener({
            val firebaseUser = FirebaseAuth.getInstance().currentUser;
            if (firebaseUser != null) {
                val intent = Intent(this,Voteintermed::class.java)
                startActivity(intent)

            }
            else {
                startActivityForResult(
                        AuthUI.getInstance()
                                .createSignInIntentBuilder()
                                .setAvailableProviders(Arrays.asList(
                                        AuthUI.IdpConfig.GoogleBuilder().build()))
                                .build(),
                        RC_SIGN_IN);


            }

        })

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val response = IdpResponse.fromResultIntent(data);

            // Successfully signed in
            if (resultCode == RESULT_OK) {

            } else {
                // Sign in failed
                Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show()
                if (response == null) {
                    // User pressed back button
                    return;
                }

                if (response.getError()?.getErrorCode() == ErrorCodes.NO_NETWORK) {
                    Toast.makeText(this, "No Internet Connection", Toast.LENGTH_LONG).show()


                }
            }

        }
    }
}
