package com.example.callnotes

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.graphics.Color
import android.graphics.PixelFormat
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.telephony.TelephonyManager
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import androidx.core.app.NotificationCompat

class CallReceiver : BroadcastReceiver() {

    private data class Row(val name: String, val date: String, val notes: String)

    companion object {
        private var overlay: View? = null
        private const val CHANNEL_ID = "client_calls"
    }

    override fun onReceive(context: Context, intent: Intent) {
