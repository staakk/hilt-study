package com.example.hiltstudy.scopes

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class ViewComponentIdView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : AppCompatTextView(context, attrs, defStyle) {

    @Inject
    @Named("id.view")
    @JvmField var viewComponentId: Int = 0

    init {
        @SuppressLint("SetTextI18n")
        text = "View component id:          $viewComponentId"
    }

}