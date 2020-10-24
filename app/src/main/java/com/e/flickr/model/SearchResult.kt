package com.e.flickr.model

class SearchResult(val photos: Photos,val stat:String) {

    override fun toString(): String {
        return "SearchResult(photos=$photos, stat='$stat')"
    }
}