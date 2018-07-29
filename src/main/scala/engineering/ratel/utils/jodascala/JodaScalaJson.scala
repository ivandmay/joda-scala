package engineering.ratel.utils.jodascala

import org.joda.time.{DateTime, DateTimeZone}
import org.joda.time.format.{DateTimeFormat, DateTimeFormatter}
import play.api.libs.json._

object JodaScalaJson {

  val dateFormat: DateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z'Z")

  implicit val jodaDateReads: Reads[DateTime] = Reads[DateTime](js =>
    js.validate[String].map[DateTime](dtString =>
      DateTime.parse(dtString, dateFormat)
    )
  )

  implicit val jodaDateWrites: Writes[DateTime] = (d: DateTime) => {
    JsString(
      d.withZone(DateTimeZone.UTC)
        .toString(dateFormat)
    )
  }

}
