import org.joda.time.DateTime
import scala.concurrent.duration._

object JodaScala {

  implicit class ImplicitHelpers (date: DateTime) {
    def + (duration: Duration): DateTime = date.plus(duration.toMillis)

    def - (duration: Duration): DateTime = date.minus(duration.toMillis)

    def > (that: DateTime): Boolean = date.isAfter(that)

    def < (that: DateTime): Boolean = date.isBefore(that)

    def == (that: DateTime): Boolean = date.isEqual(that)

    def >= (that: DateTime): Boolean = date > that || date == that

    def <= (that: DateTime): Boolean = date < that || date == that
  }
}
