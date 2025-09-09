package com.ssu.xyvento.weatherapp

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.SearchView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Timestamp
import com.ssu.xyvento.weatherapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {

    //abb782b6da9b97164f9cb62e91c85e7c
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        Fetchweatherdata("jaipur")
        SearchCity()


        val logoutbutton = findViewById<Button>(R.id.btnLogout)

        logoutbutton.setOnClickListener {
            startActivity(Intent(this, Login2_Screen_Activity::class.java))
            finish()
        }
    }


    private fun SearchCity(){
        val searchview = binding.searchView
        searchview.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                if(query != null) {
                    Fetchweatherdata(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
    }

    private fun Fetchweatherdata(cityname: String){
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .build().create(ApiInterface::class.java)

        val response = retrofit.getWeatherData(cityname,"abb782b6da9b97164f9cb62e91c85e7c","metric")
        response.enqueue(object : Callback<weatherapp>{
            override fun onResponse(
                call: Call<weatherapp?>,
                response: Response<weatherapp?>
            ) {
                val responseBody = response.body()
                if(response.isSuccessful&& responseBody!=null){
                    val  temperature = responseBody.main.temp
                    val humidity = responseBody.main.humidity
                    val windSpeed = responseBody.wind.speed
                    val sunrise = responseBody.sys.sunrise
                    val sunset = responseBody.sys.sunset
                    val sealevel = responseBody.main.pressure
                    val condition = responseBody.weather.firstOrNull()?.main?:"unknown"
                    val maxtem = responseBody.main.temp_max
                    val mintemp = responseBody.main.temp_min

                    binding.textTemp.text ="${temperature}°C"
                    binding.textCondition.text =condition
                    binding.textMinMax.text = "Mintemp:${mintemp}°C | Maxtemp: ${maxtem}°C"


                    val tvHumidity = findViewById<TextView>(R.id.tvHumidityValue)
                    val tvWind = findViewById<TextView>(R.id.tvWindValue)
                    val tvRain = findViewById<TextView>(R.id.tvRainValue)
                    val tvSunrise = findViewById<TextView>(R.id.tvSunriseValue)
                    val tvSunset = findViewById<TextView>(R.id.tvSunsetValue)
                    val tvSeaLevel = findViewById<TextView>(R.id.tvSeaLevelValue)

                    binding.tvHumidityValue.text = "$humidity %"
                    binding.tvWindValue.text = "$windSpeed m/s"
                    binding.tvSunriseValue.text = "$sunrise"
                    binding.tvSunsetValue.text = "$sunset"
                    binding.tvSeaLevelValue.text = "$sealevel hpa"
                    binding.textCondition.text = condition
                    binding.textDate.text = date()
                    binding.textday.text = dayname(System.currentTimeMillis())
                    binding.textCity.text = "$cityname"
                    changeimagesaccordintoweatherconditions(condition)
                }
            }


            private fun changeimagesaccordintoweatherconditions(Conditons: String) {
                when (Conditons){
                    "Haze"->{
                        binding.root.setBackgroundResource(R.drawable.haze_background)
                    }
                    "clouds" ->{
                        binding.root.setBackgroundResource(R.drawable.cloude_background)
                    }
                }
            }

            override fun onFailure(
                call: Call<weatherapp?>,
                t: Throwable
            ) {
                TODO("Not yet implemented")
            }
        })

    }
    fun dayname(timestamp: Long):String{
        val sdf = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())
        return sdf.format(Date())
    }
    fun date(): String{
        val sdf = SimpleDateFormat("EEE", Locale.getDefault())
        return sdf.format(Date())
    }
}