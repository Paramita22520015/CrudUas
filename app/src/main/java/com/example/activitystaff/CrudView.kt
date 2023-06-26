package com.example.activitystaff

interface CrudView {
    //get data
    fun onSuccessGet(data: List<DataItem>?)
    fun onFailedGet(msg : String)

    //Untuk Delete
    fun onSuccessDelete(msg: String)
    fun onErrorDelete(msg: String)

    //Untuk Add
    fun onSuccessAdd(msg : String)
    fun onErrorAdd(msg: String)

    //Untuk Update
    fun onSuccessUpdate(msg : String)
    fun onErrorUpdate(msg : String)

}