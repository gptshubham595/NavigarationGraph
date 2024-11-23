package com.oops.navigarationgraph.commons

class APIConstants {
    companion object {
        const val POSTS_BASE_URL = "https://sample_post.com/"

        const val GET_ALL_POSTS_ENDPOINT = "$POSTS_BASE_URL/get_all_posts"

        const val ADD_POSTS_ENDPOINT = "$POSTS_BASE_URL/add_posts"

        const val DELETE_POST_ENDPOINT = "$POSTS_BASE_URL/delete_post"
        const val UPDATE_POST_ENDPOINT = "$POSTS_BASE_URL/update_post"

        const val GET_POST_BY_ID_ENDPOINT = "$POSTS_BASE_URL/get_post_by_id"
    }
}