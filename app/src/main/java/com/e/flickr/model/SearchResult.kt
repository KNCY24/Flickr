package com.e.flickr.model

class SearchResult {
    var photos: Photos?=null
        get() = field
        set(value) {
            field = value
        }
    var stat: String?=null
        get() = field
        set(value) {
            field = value
        }

    override fun toString(): String {
        return "SearchResult(photos=$photos, stat='$stat')"
    }
}