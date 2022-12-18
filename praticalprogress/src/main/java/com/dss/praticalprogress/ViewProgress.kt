package com.dss.praticalprogress

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Gustavo Asevedo on 16/10/2020.
 */
class ViewProgress {

    companion object {
        fun finishLoad(view: View, activity: Activity) {

            DialogUtils.checkRemoveProgress(view, activity)
        }
    }

    private lateinit var targetView: View
    private var progressLayout: Int = 0
    private lateinit var activity: Activity

    fun with(activity: Activity): ViewProgress {
        this.activity = activity
        return this
    }

    fun on(view: View): ViewProgress {
        targetView = view
        return this
    }

    fun setCustomLayout(layoutId: Int): ViewProgress {
        progressLayout = layoutId
        return this
    }

    fun load() {
        progressLayout =
            if (progressLayout == 0) R.layout.dialog_progress_local_white else progressLayout
        runProgressOnView()
    }


    private fun runProgressOnView() {
        val inflater = LayoutInflater.from(activity)

        if (targetView is ViewGroup && targetView !is RecyclerView && targetView !is ScrollView) {
            val inflatedView = inflater.inflate(
                R.layout.dialog_progress_local_white,
                targetView as ViewGroup,
                true
            )
            targetView.isClickable = false

            inflatedView.minimumWidth = targetView.width
            inflatedView.minimumHeight = targetView.height

        } else {
            val inflatedView = inflater.inflate(
                R.layout.dialog_progress_local_white,
                targetView.parent as ViewGroup, true
            )

            inflatedView.minimumWidth = (targetView.parent as ViewGroup).width
            inflatedView.minimumHeight = (targetView.parent as ViewGroup).height

            (targetView.parent as ViewGroup).isClickable = false
        }
    }

}