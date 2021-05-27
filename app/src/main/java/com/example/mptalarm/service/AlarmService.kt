package com.example.mptalarm.service

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.SyncStateContract
import com.example.mptalarm.reciever.AlarmReciever
import java.util.concurrent.atomic.AtomicInteger

class AlarmService(private val context: Context) {

    val  ACTION_SET_EXACT_ALARM = "ACTION_SET_EXACT_ALARM"
    val  ACTION_SET_REPETITIVE_ALARM = "ACTION_SET_REPETITIVE_ALARM"
    val EXTRA_EXACT_ALARM_TIME = "EXTRA_EXACT_ALARM_TIME"

    private  val seed = AtomicInteger()
    fun getRandomInt() = seed.getAndIncrement() + System.currentTimeMillis().toInt()

    private val alarmManager: AlarmManager? =
            context.getSystemService(Context.ALARM_SERVICE) as AlarmManager?

    fun setExactAlarm(timeInMilles: Long) {
        setAlarm(
                timeInMilles,
                getPendingIntent(
                        getIntent().apply {
                    action = ACTION_SET_EXACT_ALARM
                    putExtra(EXTRA_EXACT_ALARM_TIME, timeInMilles)
                }
            )
        )
    }

    //каждая неделя
    fun setRepetitiveAlarm(timeInMilles: Long) {
        setAlarm(
                timeInMilles,
                getPendingIntent(
                        getIntent().apply {
                            action = ACTION_SET_REPETITIVE_ALARM
                            putExtra(EXTRA_EXACT_ALARM_TIME, timeInMilles)
                        }
                )
        )
    }

    private fun setAlarm(timeInMilles: Long, pendingIntent: PendingIntent) {
        alarmManager?.let {
            if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.M) {
                alarmManager.setExactAndAllowWhileIdle(
                    AlarmManager.RTC_WAKEUP,
                        timeInMilles,
                        pendingIntent
                )
            }
            else {
                alarmManager.setExact(
                        AlarmManager.RTC_WAKEUP,
                        timeInMilles,
                        pendingIntent
                )
            }
        }
    }

    private fun getIntent() = Intent(context, AlarmReciever::class.java)

    private  fun getPendingIntent(intent: Intent) = PendingIntent.getBroadcast(
            context,
            getRandomInt(),
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT
    )
}