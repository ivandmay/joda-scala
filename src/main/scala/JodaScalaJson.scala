import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import play.api.libs.json._

object JodaScalaJson {
  val dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"

  implicit val jodaDateReads: Reads[DateTime] = Reads[DateTime](js =>
    js.validate[String].map[DateTime](dtString =>
      DateTime.parse(dtString, DateTimeFormat.forPattern(dateFormat))
    )
  )

  implicit val jodaDateWrites: Writes[DateTime] = (d: DateTime) => JsString(d.toString(dateFormat))

}
