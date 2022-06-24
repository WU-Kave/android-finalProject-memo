package com.example.memo.utils

import android.view.View
import android.view.inputmethod.InputMethodManager
import android.view.inputmethod.InputMethodManager.HIDE_NOT_ALWAYS
import android.content.Context.INPUT_METHOD_SERVICE


fun View.hideKeyboard() = (context.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager)
    .hideSoftInputFromWindow(windowToken, HIDE_NOT_ALWAYS)