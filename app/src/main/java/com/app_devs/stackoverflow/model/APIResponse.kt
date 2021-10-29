package com.app_devs.stackoverflow.model

data class APIResponse(
    val items : List<Item>,
    val has_more : Boolean,
    val quota_max : Int,
    val quota_remaining : Int
)
data class Item(
    val tags : List<String>,
    val owner : Owner,
    val is_answered : Boolean,
    val view_count : Int,
    val answer_count : Int,
    val score : Int,
    val last_activity_date : Int,
    val creation_date : Int,
    val question_id : Int,
    val content_license : String,
    val link : String,
    val title : String
)
data class Owner(
    val reputation : Int,
    val user_id : Int,
    val user_type : String,
    val profile_image : String,
    val display_name : String,
    val link : String
)
