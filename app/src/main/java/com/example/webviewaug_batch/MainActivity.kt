package com.example.webviewaug_batch

import android.graphics.Bitmap
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        webSettings()
        googleWebView.loadUrl("https://www.google.com")
        googleWebView.webViewClient=MyClient()

    }

    private fun webSettings() {
      val myWebSettings=googleWebView.getSettings()
        myWebSettings.javaScriptEnabled=true
        myWebSettings.loadWithOverviewMode=true
        myWebSettings.useWideViewPort=true
        myWebSettings.domStorageEnabled=true
        myWebSettings.layoutAlgorithm=WebSettings.LayoutAlgorithm.NORMAL
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        googleWebView.saveState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        googleWebView.restoreState(savedInstanceState)
    }
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            when (keyCode) {
                KeyEvent.KEYCODE_BACK -> {
                    if (googleWebView.canGoBack()) {
                        googleWebView.goBack()
                    } else {
                        val dialog = CustomDialog(this@MainActivity)
                        dialog.show()
                        // the following LOC will change the default layout width height to following .. default is very small.. i don't like.
                        dialog.getWindow()?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                    }
                    return true
                }
            }
        }
        return super.onKeyDown(keyCode, event)
    }
    inner class MyClient : WebViewClient() {

        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            return super.shouldOverrideUrlLoading(view, request)
        }
        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
            progreeBar.visibility=View.VISIBLE
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            progreeBar.visibility=View.GONE
        }
    }
}



