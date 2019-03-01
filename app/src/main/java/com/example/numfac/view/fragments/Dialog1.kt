package com.example.numfac.view.fragments

import androidx.fragment.app.DialogFragment
import android.content.DialogInterface
import com.example.numfac.R
import android.os.Bundle
import kotlinx.android.synthetic.main.fragment_dialog.*
import android.util.Log
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import java.lang.Integer.parseInt
import android.content.Intent
import android.widget.ImageButton
import android.widget.TextView


class Dialog1 : DialogFragment(), View.OnClickListener {

    val LOG_TAG = "myLogs"
    private var curNumber = 5

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog.setTitle("Title!")
        val v = inflater.inflate(R.layout.fragment_dialog, container)
        val tvDialog = v?.findViewById<View>(R.id.dialog_text_view) as TextView
        curNumber = parseInt(tvDialog.text.toString())
        val btnMinus = v?.findViewById<View>(R.id.btnMinus) as Button
        val btnPlus = v.findViewById<View>(R.id.btnPlus) as Button
        val btnAccept = v.findViewById<View>(R.id.btnAccept) as ImageButton

        btnMinus.setOnClickListener(this)
        btnPlus.setOnClickListener(this)
        btnAccept.setOnClickListener(this)
        return v
    }

    override fun onClick(v: View) {
        when (v) {
            btnMinus -> {
                if (curNumber > 1)
                    curNumber--
                dialog_text_view.text = curNumber.toString()
            }
            btnPlus -> {
                if (curNumber < 50)
                    curNumber++
                dialog_text_view.text = curNumber.toString()
            }
            btnAccept -> {
                sendResult(228)
                dismiss()
            }
        }
    }

    override fun onDismiss(dialog: DialogInterface?) {
        super.onDismiss(dialog)
        Log.d(LOG_TAG, "Dialog 1: onDismiss")
    }

    override fun onCancel(dialog: DialogInterface?) {
        super.onCancel(dialog)
        Log.d(LOG_TAG, "Dialog 1: onCancel")
    }

    private fun sendResult(REQUEST_CODE: Int) {
        val intent = Intent()
        intent.putExtra("EDIT_TEXT_BUNDLE_KEY", curNumber)
        targetFragment?.onActivityResult(
            targetRequestCode, REQUEST_CODE, intent
        )
    }
}