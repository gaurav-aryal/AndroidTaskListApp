package com.example.tasklist

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.TextView
import android.content.Intent
import android.view.View
import android.widget.EditText
import com.example.tasklist.Constants.Companion.TASK_INTENT_CHECKBOX
import com.example.tasklist.Constants.Companion.TASK_INTENT_TEXT
import com.example.tasklist.Constants.Companion.TASK_INTENT_DATE
import com.example.tasklist.Constants.Companion.TASK_INTENT_NOTES
import kotlinx.android.synthetic.main.activity_task_detail.view.*
import java.text.SimpleDateFormat
import java.util.*

class TaskDetailActivity : AppCompatActivity() {

    private val REQUEST_CODE = 101

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_detail)
        // Get the Intent that started this activity and extract the string
        val message = intent.getStringExtra(EXTRA_MESSAGE)

        // Capture the layout's TextView and set the string as its text
        val editText = findViewById<EditText>(R.id.editText).apply {
            editText?.setText(message)
        }

        //date picker
        var dateIsStored= findViewById<TextView>(R.id.DatePicker)
        dateIsStored.text = SimpleDateFormat("dd.MM.yyyy").format(System.currentTimeMillis())

        var cal = Calendar.getInstance()

        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val myFormat = "dd.MM.yyyy" // mention the format you need
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            dateIsStored.text = sdf.format(cal.time)

        }

        dateIsStored.setOnClickListener {
            DatePickerDialog(this@TaskDetailActivity, dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)).show()
        }
    }

    /*fun onSaveButtonClicked(task: Task, index: Int) {
        val intent = Intent(this, TaskDetailActivity::class.java)
        intent.putExtra(TASK_INTENT_CHECKBOX, task.checkBox)
        intent.putExtra(TASK_INTENT_TEXT, task.text)
        intent.putExtra(TASK_INTENT_DATE, task.dateIsStored)
        intent.putExtra(TASK_INTENT_NOTES, task.notes)
        startActivityForResult(intent, REQUEST_CODE)
    }*/


    fun onSaveButtonClicked(view: View) {
        val intent1 = Intent(this, MainActivity::class.java).apply {
            //update the list with edited item and newly added item
        }
        startActivity(intent1)
    }
}
