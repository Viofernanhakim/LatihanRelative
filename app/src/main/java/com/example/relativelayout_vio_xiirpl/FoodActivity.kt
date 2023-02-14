package com.example.relativelayout_vio_xiirpl

import CategoriesAdapter
import android.media.tv.AdResponse
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.relativelayout_vio_xiirpl.MODEL.CategoriesModel
import org.json.JSONException
import org.json.JSONObject

class FoodActivity : AppCompatActivity() {
    lateinit var categoriesAdapter: CategoriesAdapter
    lateinit var categoriesModel: CategoriesModel
    lateinit var categoriesList: ArrayList<CategoriesModel>
    lateinit var rvCategories: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)
        var categoryList = arrayList()
        rvCategories = findViewById(R.id.rv_food)
        var LayoutManager= GridLayoutManager(this,2,
            RecyclerView,VERTICAL,false)
        rvCategories.layoutManager = layoutManager
        rvCategories.setHasFixedSize(true)

        categories
    }



    private val categories : Unit
        get() {
            AndroidNetworking.get(api.categories)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(object: JSONObjectRequestListener{
                    override fun onResponse(response: JSONObject?) {
                        try {
                            var foodArray = response?.getJSONArray("categories")
                            for (i in 0 until < foodArray!!.length()){
                                var temp = foodArray.getJSONObject(i)
                                var dataApi = CategoriesModel()
                                dataApi.strCategory = temp.getString("strCategory")
                                dataApi.strCategoryThump = temp.getString("strCategoryThump")
                                dataApi.strCategoryDescription = temp.
                                getString("strCategoryDescription")

                                categoryList.add(dataApi)
                                showCategories()
                            }
                        }
                        catch (e: JSONException){
                            e.printStackTrace()
                            Toast.makeText(this@FoodActivity,"Object not found",
                                Toast.LENGTH_SHORT).show()
                        }
                    }
                    override fun onError(anError: ANError?) {
                        Toast.makeText(this@FoodActivity,"")
                    }
                })
        }
    private fun showCategories() {
        categoriesAdapter = CategoriesAdapter(this,categoriesList)
        rvCategories.adapter = categoriesAdapter
    }
}