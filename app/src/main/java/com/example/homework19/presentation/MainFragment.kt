package com.example.homework19.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.homework19.databinding.FragmentMainBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    var binding: FragmentMainBinding? = null

    val listOfPictures = listOf(
        "https://rasteniadacha.ru/wp-content/uploads/2021/12/sukkulenty-32.jpg",
        "https://stroy-podskazka.ru/images/article/orig/2019/02/kak-vyrastit-sukkulenty-iz-semyan.jpg",
        "https://na-dache.pro/uploads/posts/2021-05/1620260002_61-p-sukkulenti-foto-69.jpg",
        "https://lafoy.ru/photo_l/sukkulenty-foto-60-3914.jpg",
        "https://domverhdnom.ru/images/wp-content/uploads/2021/12/sukkulenty-2.jpg",
        "https://rasteniadacha.ru/wp-content/uploads/2021/12/sukkulenty-33.jpg",
        "https://tempusliberum.ru/wp-content/uploads/e/4/6/e460ddddfac94508c9dd35bbe8407cb7.jpeg"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setListeners()
    }

    private fun setListeners() {
        binding?.btnShowRandomPicture?.setOnClickListener {
            Observable.just(
                loadImageWithGlide(
                    imageView = ivPicture,
                    imageURL = listOfPictures.random()
                )
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ throw Exception("Exception") }, { error ->
                    Log.e("Exception", error.localizedMessage)
                })
        }
    }

    private fun loadImageWithGlide(imageURL: String, imageView: ImageView) {
        Glide.with(this)
            .load(imageURL)
            .into(imageView)
    }

    override fun onDestroyView() {
        binding = null

        super.onDestroyView()
    }
}