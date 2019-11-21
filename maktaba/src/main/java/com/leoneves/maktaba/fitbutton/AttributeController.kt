package com.leoneves.maktaba.fitbutton

import android.graphics.Color
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import com.leoneves.maktaba.R
import com.leoneves.maktaba.fitbutton.model.FButton
import com.leoneves.maktaba.fitbutton.model.IconPosition
import com.leoneves.maktaba.fitbutton.model.Shape
import com.leoneves.maktaba.fitbutton.util.Util.dpToPx
import com.leoneves.maktaba.fitbutton.util.Util.txtPxToSp

/**
 * The [FitButton] attrs controller
 * @author Ivan V on 25.03.2019.
 * @version 1.0
 */
internal class AttributeController(private val view: View, private val attrs: AttributeSet?) {

    /**
     * @return initialized [FButton]
     */
    lateinit var button: FButton

    init {
        initAttr()
    }

    private fun initAttr() {
        val typedArray = view.context.obtainStyledAttributes(attrs, R.styleable.FitButton)
        // Init button image
        val icon = typedArray.getDrawable(R.styleable.FitButton_fb_icon)
        val iconColor = typedArray.getColor(R.styleable.FitButton_fb_iconColor, Color.TRANSPARENT)
        val iconWidth = typedArray.getDimension(
                R.styleable.FitButton_fb_iconWidth, icon?.intrinsicWidth?.toFloat() ?: 0f
        )
        val iconHeight = typedArray.getDimension(
                R.styleable.FitButton_fb_iconHeight, icon?.intrinsicHeight?.toFloat() ?: 0f
        )
        val iconMarginStart = typedArray.getDimension(R.styleable.FitButton_fb_iconMarginStart, 0f)
        val iconMarginTop = typedArray.getDimension(R.styleable.FitButton_fb_iconMarginTop, 0f)
        val iconMarginEnd = typedArray.getDimension(R.styleable.FitButton_fb_iconMarginEnd, 0f)
        val iconMarginBottom = typedArray.getDimension(R.styleable.FitButton_fb_iconMarginBottom, 0f)
        val iconPosition = typedArray.getInt(R.styleable.FitButton_fb_iconPosition, IconPosition.CENTER.position)
        val iconVisibility = typedArray.getInt(R.styleable.FitButton_fb_iconVisibility, View.VISIBLE)

        // Init divider
        val divColor = typedArray.getColor(R.styleable.FitButton_fb_divColor, Color.DKGRAY)
        val divWidth = typedArray.getDimension(R.styleable.FitButton_fb_divWidth, 0f)
        val divHeight = typedArray.getDimension(R.styleable.FitButton_fb_divHeight, 0f)
        val divMarginTop = typedArray.getDimension(R.styleable.FitButton_fb_divMarginTop, 0f)
        val divMarginBottom = typedArray.getDimension(R.styleable.FitButton_fb_divMarginBottom, 0f)
        val divMarginStart = typedArray.getDimension(R.styleable.FitButton_fb_divMarginStart, 0f)
        val divMarginEnd = typedArray.getDimension(R.styleable.FitButton_fb_divMarginEnd, 0f)
        val divVisibility = typedArray.getInt(R.styleable.FitButton_fb_divVisibility, View.VISIBLE)

        // Init button text
        val text = typedArray.getString(R.styleable.FitButton_fb_text)
        val textPaddingStart = typedArray.getDimension(R.styleable.FitButton_fb_textPaddingStart, 0f)
        val textPaddingTop = typedArray.getDimension(R.styleable.FitButton_fb_textPaddingTop, 0f)
        val textPaddingEnd = typedArray.getDimension(R.styleable.FitButton_fb_textPaddingEnd, 0f)
        val textPaddingBottom = typedArray.getDimension(R.styleable.FitButton_fb_textPaddingBottom, 0f)
        val fontRes = typedArray.getResourceId(R.styleable.FitButton_fb_fontFamilyRes, 0)
        val textStyle = typedArray.getInt(R.styleable.FitButton_fb_textStyle, Typeface.NORMAL)
        val textSize = typedArray.getDimension(R.styleable.FitButton_fb_textSize, txtPxToSp(16f))
        val textColor = typedArray.getColor(R.styleable.FitButton_fb_textColor, Color.DKGRAY)
        val textAllCaps = typedArray.getBoolean(R.styleable.FitButton_fb_textAllCaps, false)
        val textVisibility = typedArray.getInt(R.styleable.FitButton_fb_textVisibility, View.VISIBLE)

        // Init button
        val btnColor = typedArray.getColor(R.styleable.FitButton_fb_backgroundColor, 0)
        val disableColor = typedArray.getColor(R.styleable.FitButton_fb_disableColor, 0)
        val elDisableColor = typedArray.getColor(R.styleable.FitButton_fb_disableElementsColor, 0)
        val cornerRadius = typedArray.getDimension(R.styleable.FitButton_fb_cornerRadius, 0f)
        val enableRipple = typedArray.getBoolean(R.styleable.FitButton_fb_enableRipple, true)
        val rippleColor = typedArray.getColor(R.styleable.FitButton_fb_rippleColor, Color.parseColor("#42FFFFFF"))
        val shape = typedArray.getInt(R.styleable.FitButton_fb_shape, Shape.RECTANGLE.shape)
        val enable = typedArray.getBoolean(R.styleable.FitButton_android_enabled, true)
        val borderColor = typedArray.getColor(R.styleable.FitButton_fb_borderColor, Color.TRANSPARENT)
        val borderWidth = typedArray.getDimension(R.styleable.FitButton_fb_borderWidth, 0f)
        val elevation = typedArray.getDimension(R.styleable.FitButton_fb_shadow, dpToPx(2f))

        button = FButton(icon,
                iconColor,
                iconWidth,
                iconHeight,
                iconMarginStart,
                iconMarginTop,
                iconMarginEnd,
                iconMarginBottom,
                IconPosition.values().first { ic -> ic.position == iconPosition },
                iconVisibility,
                divColor,
                divWidth,
                divHeight,
                divMarginTop,
                divMarginBottom,
                divMarginStart,
                divMarginEnd,
                divVisibility,
                text,
                textPaddingStart,
                textPaddingTop,
                textPaddingEnd,
                textPaddingBottom,
                fontRes,
                null,
                textStyle,
                textSize,
                textColor,
                textAllCaps,
                textVisibility,
                MATCH_PARENT,
                WRAP_CONTENT,
                btnColor,
                disableColor,
                elDisableColor,
                cornerRadius,
                enableRipple,
                rippleColor,
                Shape.values().first { s -> s.shape == shape },
                enable,
                borderColor,
                borderWidth,
                elevation)

        typedArray.recycle()
    }

}