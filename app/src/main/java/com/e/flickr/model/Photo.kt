package com.e.flickr.model

class Photo(val id:String,val owner:String,val secret:String,val server:String,val farm:String,val title:String,val ispublic:Integer,val isfirend:Integer,val isfamily:Integer){

    override fun toString(): String {
        return "Photo(id='$id', owner='$owner', secret='$secret', server='$server', farm='$farm', title='$title', ispublic=$ispublic, isfirend=$isfirend, isfamily=$isfamily)"
    }

}