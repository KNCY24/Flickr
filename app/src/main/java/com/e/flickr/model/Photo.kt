package com.e.flickr.model

class Photo{
    var id: String ?=null
        get() = field
        set(value) {
            field = value
        }
    var owner : String?=null
        get() = field
        set(value) {
            field = value
        }
    var secret: String?=null
        get() = field
        set(value) {
            field = value
        }
    var server : String?=null
        get() = field
        set(value) {
            field = value
        }
    var farm: String?=null
        get() = field
        set(value) {
            field = value
        }
    var title: String?=null
        get() = field
        set(value) {
            field = value
        }
    var ispublic: Integer?=null
        get() = field
        set(value) {
            field = value
        }
    var isfirend: Integer?=null
        get() = field
        set(value) {
            field = value
        }
    var isfamily: Integer?=null
        get() = field
        set(value) {
            field = value
        }

    override fun toString(): String {
        return "Photo(id='$id', owner='$owner', secret='$secret', server='$server', farm='$farm', title='$title', ispublic=$ispublic, isfirend=$isfirend, isfamily=$isfamily)"
    }

}