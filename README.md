Upyun-Java
==========

Java client library for upyun storage.

Usage
==========

```java
//AUTO Select endpoint; Global Config for Upyun Service.
UpyunConfig config = new UpyunConfig(username, password, bucketName);

//Get File From Upyun
GetObjectService service = new GetObjectService(config);
UpyunObject obj = client.getObject(path); //path should be started with slash

//InputStream that you can manipulate, do not forget close it via UpyunObject.close().
InputStream in = obj.getContent();
```

Exception Handle
==========
This library never throw any checked exceptions, using `UpyunException` which extends `RuntimeException` instead.
 `UpyunException` encapsulates all HTTP status code and message returned by Upyun server. You can also access the `IOException`
 which comes from network failure.

HTTP Status Code | Returned Error Code
---------------- | -------------------
200 | OK
400 | Bad Request
401 | Unauthorized
401 | Sign error
401 | Need Date Header
401 | Date offset error
403 | Not Access
403 | File size too max
403 | Not a Picture File
403 | Picture Size too max
403 | Bucket full
403 | Bucket blocked
403 | User blocked
403 | Image Rotate Invalid Parameters
403 | Image Crop Invalid Parameters
404 | Not Found
406 | Not Acceptable(path)
503 | System Error

Dependencies
==========

* [guava-libraries](https://code.google.com/p/guava-libraries/)
* [http-request](http://kevinsawicki.github.io/http-request/)
* [slf4j](http://www.slf4j.org/)

OSGi Support
==========
I'm using [Virgo](http://eclipse.org) now, virgo using logback as logging system. It is proved that out library
runs correctly in Virgo because virgo set logback bundle as a fragment of slf4j.

But in regular OSGi runtime, slf4j-api bundle cannot find any implementation of `Logger` because of the missing
Import-Package, I'll working on this issue.

Todo
==========

* HTTP Basic Authorization Support
* Standard API
 - Delete dir
 - Get files in dir
 - Get storage info of bucket
* Image Processing
 - Thumbnail
 - Rotate
 - Clip
