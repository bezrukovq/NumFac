package com.example.numfac.view.dialogs

import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.numfac.R
import com.example.numfac.view.PaginationPreferences
import kotlinx.android.synthetic.main.fragment_dialog.*


class DownloadSizeDialog : DialogFragment(), View.OnClickListener {

    val LOG_TAG = "myLogs"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_dialog, container)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog_text_view.text = PaginationPreferences.paginationSize.toString()
        btnMinus.setOnClickListener(this)
        btnPlus.setOnClickListener(this)
        btnAccept.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v) {
            btnMinus -> {
                if (PaginationPreferences.paginationSize > 1)
                    PaginationPreferences.paginationSize--
                dialog_text_view.text = PaginationPreferences.paginationSize.toString()
            }
            btnPlus -> {
                if (PaginationPreferences.paginationSize < MAX_REQUEST_SIZE)
                    PaginationPreferences.paginationSize++
                dialog_text_view.text = PaginationPreferences.paginationSize.toString()
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
        intent.putExtra("EDIT_TEXT_BUNDLE_KEY", PaginationPreferences.paginationSize)
        targetFragment?.onActivityResult(
            targetRequestCode, REQUEST_CODE, intent
        )
    }

    companion object {
        const val MAX_REQUEST_SIZE = 50
        const val REPLY_CODE = 228
    }
}
