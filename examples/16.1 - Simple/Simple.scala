//| mvnDeps:
//| - com.lihaoyi::castor:0.3.0

import scala.util.{Try, Success, Failure}

class SimpleUploadActor()(using cc: castor.Context) extends castor.SimpleActor[String]:
  var count = 0

  def run(msg: String) =
    _safePost("https://httpbin.org/post", data=msg) match {
      case Right(res) =>
        count += 1
        println(s"response $count ${res.statusCode} " + ujson.read(res)("data"))
      case Left(ex) =>
        println(ex)
    }

    _safePost("https://no.cite.ever/post", data=msg) match {
      case Right(res) =>      
        println(s"resp ${res.statusCode} " + ujson.read(res)("data"))
      case Left(ex) =>
        println(ex)
    }

  private def _safePost(url:String, data: String): Either[Throwable, requests.Response] = 
    println(s"To: $url")
    println(s"Uploading $data")
    Try(requests.post(url, data=data)) match {
      case Success(resp) => Right(resp)
      case Failure(ex) => Left(ex)
    } 

given cc: castor.Context.Test()
val uploader = SimpleUploadActor()
