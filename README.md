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

Dependencies
==========

* [guava-libraries](https://code.google.com/p/guava-libraries/)
* [http-request](http://kevinsawicki.github.io/http-request/)
* [slf4j](http://www.slf4j.org/)

Todo
==========

* Exception Handle
* HTTP Basic Authorization Support
* OSGi Support
* Standard API
 - Upload file
 - Get file info
 - Delete file
 - Mkdir
 - Delete dir
 - Get files in dir
 - Get storage info of bucket
* Image Processing
 - Thumbnail
 - Rotate
 - Clip
