package com.example.numfac.view.dialogs

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.numfac.R
import kotlinx.android.synthetic.main.fragment_dialog.*

class DownloadSizeDialog : DialogFragment(), View.OnClickListener {

    val LOG_TAG = "myLogs"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_dialog, container)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog_text_view.text = curNumber.toString()
        btnMinus.setOnClickListener(this)
        btnPlus.setOnClickListener(this)
        btnAccept.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v) {
            btnMinus -> {
                if (curNumber > 1)
                    curNumber--
                dialog_text_view.text = curNumber.toString()
            }
            btnPlus -> {
                if (curNumber < MAX_REQUEST_SIZE)
                    curNumber++
                dialog_text_view.text = curNumber.toString()
            }
            btnAccept -> {
                sendResult(REPLY_CODE)
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

    companion object {
        //TODO make with shared preferences
        private var curNumber = 5
        //-------------------------------
        const val MAX_REQUEST_SIZE =50
        const val REPLY_CODE = 228
    }
}
