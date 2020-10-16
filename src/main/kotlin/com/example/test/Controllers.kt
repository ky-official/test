package com.example.test

import com.google.cloud.storage.BlobId
import com.google.cloud.storage.Storage
import com.google.cloud.storage.StorageOptions
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.io.File


@RestController
class Controllers {


    lateinit var storage: Storage

    @GetMapping("/")
    @CrossOrigin
    fun testController(): String {

        storage = StorageOptions.newBuilder().setProjectId("notional-portal-292519").build().service
        var blob = storage.get(BlobId.of("testing_bucket_data","doc.txt"))

        var temp = File("/tmp/doc.txt")
//        println("${temp.isDirectory} that temp is a directory")

        blob.downloadTo(temp.toPath())
        var txt = File("/tmp/doc.txt")



        return txt.toString()
    }
}