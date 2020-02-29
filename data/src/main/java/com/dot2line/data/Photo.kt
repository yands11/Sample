package com.dot2line.data

import kotlinx.serialization.Serializable

@Serializable
data class Photo(
    val id: String,
    val created_at: String,
    val updated_at: String,
    val promoted_at: String? = null,
    val width: Int,
    val height: Int,
    val color: String,
    val description: String? = null,
    val alt_description: String,
    val urls: Urls,
    val links: Links,
    val categories: List<String>,
    val likes: Int,
    val liked_by_user: Boolean,
    val current_user_collections: List<String>,
    val user: User
)

@Serializable
data class Urls(
    val full: String,
    val raw: String,
    val regular: String,
    val small: String,
    val thumb: String
)

@Serializable
data class Links(
    val self: String,
    val html: String,
    val photos: String? = null,
    val likes: String? = null,
    val portfolio: String? = null,
    val following: String? = null,
    val followers: String? = null,
    val download: String? = null,
    val download_location: String? = null
)

@Serializable
data class User(
    val id: String,
    val updated_at: String,
    val username: String,
    val name: String,
    val first_name: String? = null,
    val last_name: String? = null,
    val twitter_username: String? = null,
    val portfolio_url: String? = null,
    val bio: String? = null,
    val location: String? = null,
    val links: Links,
    val profile_image: ProfileImage,
    val instagram_username: String? = null,
    val total_collections: Int,
    val total_likes: Int,
    val total_photos: Int,
    val accepted_tos: Boolean
)

@Serializable
data class ProfileImage(
    val large: String,
    val medium: String,
    val small: String
)