package com.example.setu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.setu.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
var cases=ArrayList<Resp2>()
    private lateinit var binding:ActivityMainBinding
    private lateinit var adapter: PostAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        GlobalScope.launch(Dispatchers.Main) {
            val response = withContext(Dispatchers.IO) {
                Client.api.getUser()

            }
            val instance1= response.body()?.statewise
            if (instance1 != null) {
                for(i in 0 until instance1.size-1) {
                    instance1.get(i).state?.let {
                        instance1.get(i).confirmed?.let { it1 ->
                            instance1.get(i).recovered?.let { it2 ->
                                instance1.get(i).deaths?.let { it3 ->
                                    Resp2(
                                        it, it1,
                                        it2, it3
                                    )
                                }
                            }
                        }
                    }?.let { cases.add(it) }

                }
            }
adapter= PostAdapter(cases)
            binding.rcCovid.layoutManager=LinearLayoutManager(this@MainActivity)
            binding.rcCovid.adapter=adapter
            Log.d("result", "${response.body()}")
        }

    }


}