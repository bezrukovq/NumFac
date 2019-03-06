package com.example.numfac.view.dialogs

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.numfac.R
import com.example.numfac.model.PaginationPreferences
import kotlinx.android.synthetic.main.fragment_dialog.*

class DownloadSizeDialog : DialogFragment(), View.OnClickListener {

    val LOG_TAG = "myLogs"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_dialog, container)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog_text_view.text = PaginationPreferences.paginationSize.toString()
        btn_minus.setOnClickListener(this)
        btn_plus.setOnClickListener(this)
        btn_accept.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v) {
            btn_minus -> {
                if (PaginationPreferences.paginationSize > 1)
                    PaginationPreferences.paginationSize--
                dialog_text_view.text = PaginationPreferences.paginationSize.toString()
            }
            btn_plus -> {
                if (PaginationPreferences.paginationSize < MAX_REQUEST_SIZE)
                    PaginationPreferences.paginationSize++
                dialog_text_view.text = PaginationPreferences.paginationSize.toString()
            }
            btn_accept -> dismiss()
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

    companion object {
        const val MAX_REQUEST_SIZE = 50
    }
}
