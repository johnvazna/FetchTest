package com.johnvazna.core.bases

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.LinearLayout
import com.johnvazna.core.R

/** */
@SuppressLint("InflateParams")
class BaseLoading {

    private var loader: Custom? = null

    fun showDialog(
        context: Context?, isCancelable: Boolean
    ) {
        if (context != null) {
            try {
                loader = Custom(context)
                loader?.let { Loader ->
                    Loader.setCanceledOnTouchOutside(true)
                    Loader.setCancelable(isCancelable)
                    Loader.show()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun hideDialog() {
        if (loader != null && loader?.isShowing!!) {
            loader = try {
                loader?.dismiss()
                null
            } catch (e: Exception) {
                null
            }
        }
    }
}

class Custom(context: Context) : Dialog(context) {
    @SuppressLint("PrivateResource")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_loading)
        window?.setLayout(
            LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
        )
        window?.setBackgroundDrawableResource(com.google.android.material.R.color.mtrl_btn_transparent_bg_color)
    }
}
