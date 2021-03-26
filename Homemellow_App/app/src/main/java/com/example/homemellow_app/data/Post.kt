package com.example.homemellow_app.data

import org.w3c.dom.Text

class Post {

    val id : Int = 0
    val posts = Posts(id)

    class Posts(id : Int)
    {
        val image : String = ""

        class Comment
        {
            val id_cmnt : Int = 0
            val user_id : Int = 0
            val body_content : String = ""
        }
    }

}