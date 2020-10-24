package com.e.flickr.model

class Photos(val page:Integer,val pages:Integer,val perpage:Integer,val total:String,val photo:List<Photo>){

    override fun toString(): String {
        return "Photos(page=$page, pages=$pages, perpage=$perpage, total='$total', photo=$photo)"
    }
}