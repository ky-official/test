package com.example.test

import com.google.cloud.storage.BlobId
import com.google.cloud.storage.Storage
import com.google.cloud.storage.StorageOptions
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Controllers {


    lateinit var storage: Storage

    @GetMapping("/")
    @CrossOrigin
    fun testController(): String {


        storage = StorageOptions.newBuilder().setProjectId("notional-portal-292519").build().service
        var blob = storage.get(BlobId.of("testing_bucket_data","doc.txt"))
        return blob.contentType
    }
}