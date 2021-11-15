package com.example.webviewaug_batch

import android.app.Dialog
import android.app.PendingIntent.getActivity
import android.content.Context
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.customexitdialog.*

class CustomDialog(context: Context):Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.customexitdialog)

        NegativeBTN.setOnClickListener {
            dismiss()
        }
        PositveBTN.setOnClickListener {
            //context.finish();


        }
    }

//    override fun onClick(v: View?) {
//    }
}