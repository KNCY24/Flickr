package com.e.flickr.model

class Photos{
    var page: Integer?=null
        get() = field
        set(value) {
            field = value
        }
    var pages: Integer?=null
        get() = field
        set(value) {
            field = value
        }
    var perpage: Integer?=null
        get() = field
        set(value) {
            field = value
        }
    var total: String?=null
        get() = field
        set(value) {
            field = value
        }
    var photo: List<Photo>?=null
        get() = field
        set(value) {
            field = value
        }


    override fun toString(): String {
        return "Photos(page=$page, pages=$pages, perpage=$perpage, total='$total', photo=$photo)"
    }
}