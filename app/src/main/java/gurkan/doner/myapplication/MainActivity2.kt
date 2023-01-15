package gurkan.doner.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {

    private lateinit var  newRecyclerView: RecyclerView
    private lateinit var listTemplate: ListTemplate
    private lateinit var itemArrayList: ArrayList<ListTemplate>
    private fun getUserData(){


        val item1 = ListTemplate("deneme",1,"182503021","182503021","182503021","deneme","deneme","deneme")
        val item2 = ListTemplate("deneme",2,"182503021","182503021","182503021","deneme","deneme","deneme")

        newRecyclerView.adapter = RecyclerViewAdapter(itemArrayList)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        

        newRecyclerView = findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)

        getUserData()

    }
}



