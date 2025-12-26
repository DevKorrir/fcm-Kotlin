package dev.korryr.fcm.ui.features

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_UPDATE_CURRENT
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import dev.korryr.fcm.MainActivity
import dev.korryr.fcm.R
import kotlin.math.log
import kotlin.random.Random

const val TAG = "FCM"

class MessagingService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d(TAG, "Refreshed token: $token")
    }

    fun onMessageRecieved(message: RemoteMessage){
        super.onMessageReceived(message)

        message.notification?.let {
            Log.d(TAG, "Message Notification Body: ${it.body}")
            showNotification(it)

    }

    }

    private fun handleDataMessage(){
        Log.d(TAG, "handleDataMessage")
    }

    fun showNotification(
        message: RemoteMessage.Notification
    ) {
        val intent = Intent(this, MainActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        }

        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE or FLAG_UPDATE_CURRENT)

        val channelId = "Default"

        val notificationBuilder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(message.title)
            .setContentText(message.body)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)
            .build()

        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channelName = "Firebase Messaging"

        if ( android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(channel)
        }

        manager.notify(Random.nextInt(), notificationBuilder)
    }




}