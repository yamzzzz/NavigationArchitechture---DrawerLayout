package com.yamikrish.app.navigationDemo.repository

import com.yamikrish.app.navigationDemo.model.Post
import com.yamikrish.app.navigationDemo.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/* 
 * Created by Yamini on 14/5/18.
 */
 
interface APIInterface{
    @GET("posts")
    fun getPosts(): Call<List<Post>>

    @GET("posts/{postId}")
    fun getPostById(@Path(value = "postId", encoded = true)  postId : Int): Call<Post>

    @GET("users/1")
    fun getUser(): Call<User>
}