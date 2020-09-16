package com.example.Restapiexample

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.Restapiexample.Api.ApiViewHolder
import com.example.Restapiexample.Api.ModelClass
import com.example.Restapiexample.InternalLogic.CustomAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var progres:ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView=findViewById<RecyclerView>(R.id.mainRecycler)
        recyclerView.layoutManager=LinearLayoutManager(this)

        progres= ProgressDialog( this)
        progres.setTitle("Loading")
        progres.setMessage("Please wait...")
        progres.setCanceledOnTouchOutside(false)
        progres.show()
        val retrofit= Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl("https://jsonplaceholder.typicode.com/").build()

        val imaseApi=retrofit.create(ApiViewHolder::class.java)

        val getImage=imaseApi.getImage()
        getImage.enqueue(object : Callback<List<ModelClass>>{
            override fun onResponse(
                call: Call<List<ModelClass>>,
                response: Response<List<ModelClass>>
            ) {
                progres.dismiss()
               val items:List<ModelClass> =response.body()!!
                val adapter=CustomAdapter(items,this@MainActivity)
                recyclerView.adapter=adapter
            }

            override fun onFailure(call: Call<List<ModelClass>>, t: Throwable) {
               Toast.makeText(this@MainActivity,"Filed",Toast.LENGTH_SHORT).show()
                progres.dismiss()
            }

        })
    }
}