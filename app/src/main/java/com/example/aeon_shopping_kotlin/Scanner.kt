package com.example.aeon_shopping_kotlin

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.core.content.PermissionChecker.checkSelfPermission
import com.budiyev.android.codescanner.AutoFocusMode
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ErrorCallback
import com.budiyev.android.codescanner.ScanMode
import kotlinx.android.synthetic.main.activity_scanner.*

private const val CAMERA_REQUEST_CODE=101

class Scanner : AppCompatActivity() {

    private lateinit var codeScanner: CodeScanner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scanner)

        setupPermissions()
        codeScanner()

        val food_content=findViewById<Button>(R.id.food_content)
        food_content.setOnClickListener{
            val intent=Intent(this,Food_Content::class.java)
            startActivity(intent)
        }

        val go_back=findViewById<Button>(R.id.go_back)
        go_back.setOnClickListener {
            val back=Intent(this,Nav_Control::class.java)
            startActivity(back)
        }
    }

    private fun codeScanner(){
        codeScanner= CodeScanner(this,scanner_view)

        codeScanner.apply{
            camera=CodeScanner.CAMERA_BACK
            formats=CodeScanner.ALL_FORMATS

            autoFocusMode=AutoFocusMode.SAFE
            scanMode=ScanMode.CONTINUOUS
            isAutoFocusEnabled=true
            isFlashEnabled=false

            decodeCallback= DecodeCallback {
                runOnUiThread {
                    tv_textView.text=it.text
                }
            }

            errorCallback= ErrorCallback {
                runOnUiThread {
                    Log.e("Main","Camera initialization error: ${it.message}")
                }
            }
        }

        scanner_view.setOnClickListener {
            codeScanner.startPreview()
        }
    }

    override fun onResume(){
        super.onResume()
        codeScanner.startPreview()
    }

    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }

    private fun setupPermissions(){
        val permission= ContextCompat.checkSelfPermission(this,
        android.Manifest.permission.CAMERA)

        if(permission!= PackageManager.PERMISSION_GRANTED){
            makeRequest()
        }
    }

    private fun makeRequest(){
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA),
            CAMERA_REQUEST_CODE)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            CAMERA_REQUEST_CODE->{
                if(grantResults.isEmpty()||grantResults[0]!=PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this,"You need the camera permission to be able to use this app!",Toast.LENGTH_SHORT).show()
                }else{
                    //successful
                }
            }
        }

    }
}