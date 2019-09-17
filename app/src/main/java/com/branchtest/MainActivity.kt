package com.branchtest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.branch.referral.Branch
import org.json.JSONObject
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    public override fun onStart() {
        super.onStart()
        val branch = Branch.getInstance()

        // Branch init
        branch.initSession({ referringParams, error ->
            if (error == null) {
                // params are the deep linked params associated with the link that the user clicked -> was re-directed to this app
                // params will be empty if no data found
                // ... insert custom logic here ...

                Log.i("BRANCH SDK", referringParams.toString())
                val sessionParams = Branch.getInstance().latestReferringParams
                val installParams = Branch.getInstance().firstReferringParams
            } else {
                Log.i("BRANCH SDK", error.message)
            }
        }, this.intent.data, this)
    }

    override fun onNewIntent(intent: Intent?) {
        this.intent = intent
        super.onNewIntent(intent)
    }

}
