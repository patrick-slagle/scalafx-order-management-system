package controller

import scalafx.Includes._
import javafx.{fxml => jfxf}
import scalafx.scene.{control => jfxsc, layout => jfxsl}
import scalafx.{event => jfxe}
import scalafxml.core.macros.sfxml
import java.time.LocalDate

@sfxml
class CalendarController(private val month: jfxsc.Label) {

  val date = LocalDate.now()
  val m = date.getMonth()
  println(month)

}


