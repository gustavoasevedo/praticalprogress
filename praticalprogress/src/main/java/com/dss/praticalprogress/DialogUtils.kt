package com.dss.praticalprogress

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ProgressBar
import android.widget.ScrollView
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Gustavo Asevedo on 16/10/2020.
 */

object DialogUtils {
    fun checkRemoveProgress(view: View, activity: Activity) {

        if (view is ViewGroup && view !is RecyclerView && view !is ScrollView) {
            removeProgress(view)
            view.isClickable = true
        } else {
            removeProgress(view.parent as ViewGroup)
            (view.parent as ViewGroup).isClickable = false
        }

        activity.window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }

    private fun removeProgress(rootview: ViewGroup) {
        for (count in 0 until rootview.childCount) {
            var progressRemoved = false
            if (rootview[count] is ViewGroup) {
                val childView = rootview[count] as ViewGroup
                for (countChild in 0 until childView.childCount) {
                    val view = childView[countChild]
                    if (view is ProgressBar) {
                        rootview.removeViewAt(count)
                        progressRemoved = true
                        break
                    }
                }
            }
            if (progressRemoved) break
        }
    }
}