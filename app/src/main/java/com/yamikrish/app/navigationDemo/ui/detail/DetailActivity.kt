package com.yamikrish.app.navigationDemo.ui.detail

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.yamikrish.app.navigationDemo.R
import com.yamikrish.app.navigationDemo.model.Post
import kotlinx.android.synthetic.main.detail_page.*

/* 
 * Created by Yamini on 15/5/18.
 */

class DetailActivity : AppCompatActivity() {

    private lateinit var viewModel: DetailViewModel
    lateinit var post: Post

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_page)
        val id = DetailActivityArgs.fromBundle(intent.extras).id
        val factory = CustomViewModelFactory(id)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.let {
            it.title = getString(R.string.post_detail)
            it.setDisplayShowHomeEnabled(true)
            it.setDisplayHomeAsUpEnabled(true)
        }

        viewModel = ViewModelProviders.of(this, factory).get(DetailViewModel::class.java)

        viewModel.fetchPostById().observe(this, object : Observer<Post> {
            override fun onChanged(t: Post?) {
                postTitle.text = t?.title
                description.text = t?.body
            }

        })
    }

    class CustomViewModelFactory(private val test: Int) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return DetailViewModel(test) as T
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return  true;
    }
}
