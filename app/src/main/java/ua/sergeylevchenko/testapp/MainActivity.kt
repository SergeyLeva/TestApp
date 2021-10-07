package ua.sergeylevchenko.testapp


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        (applicationContext as QuestApp).questApi.getNews("tesla",
            "2021-09-07",
            "publishedAt",
            "535489b925414a8bb48a9e4d7725ae2a")

            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("SUCCESS", "${it.status} ${it.totalResults} ${it.articles}")
            }, {
                Log.e("ERROR", "hui", it)
            }
            )

    }
}

