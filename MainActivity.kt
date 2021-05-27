package com.example.tasklist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var myList: ArrayList<Task>
    private val REQUEST_CODE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myList = ArrayList<Task>()
        for (i in 0 until 3) {
            myList.add(Task(R.id.iv_icon, "Clean your room", "10.2.2020", "Do it tonight"))
            myList.add(Task(R.id.iv_icon, "Repair car", "10.2.2020","Do it tonight"))
            myList.add(Task(R.id.iv_icon, "Take camera to repair shop", "10.2.2020","Do it tonight"))
            myList.add(Task(R.id.iv_icon, "Drive to wishcamper", "10.2.2020","Do it tonight"))
            myList.add(Task(R.id.iv_icon, "Facetime with mom", "10.2.2020","Do it tonight"))
        }

        recycler_view.adapter = TasksAdapter(myList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        //recycler_view.setHasFixedSize(true)
        setRecyclerViewItemTouchListener()

    }

    fun startActivityForResult(view: View) {
        val editText = findViewById<TextView>(R.id.tv_icon)
        val message = editText.text.toString()
        val intent = Intent(this, TaskDetailActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }

    fun setRecyclerViewItemTouchListener() {
        val itemTouchCallback = object :
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                viewHolder1: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, swipeDir: Int) {
                val position = viewHolder.adapterPosition
                myList.removeAt(position)
                recycler_view.adapter!!.notifyItemRemoved(position)
            }
        }
        val itemTouchHelper = ItemTouchHelper(itemTouchCallback)
        itemTouchHelper.attachToRecyclerView(recycler_view)
    }

    //sorts the list by whether the item is completed or not
    fun onCheckboxClicked(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked
            when (view.id) {
                R.id.iv_icon -> {
                    if (checked) {
                        //sort the list
                        val intent = Intent(this, MainActivity::class.java).apply {
                            val sortedListByDone = myList.sortedBy { it.checkBox }
                        }
                        startActivity(intent)
                    }
                }
            }
        }
    }
}

