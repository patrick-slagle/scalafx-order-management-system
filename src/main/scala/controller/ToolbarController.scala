package controller

import scalafx.Includes._
import scalafx.scene.image.ImageView
import scalafx.scene.input.MouseEvent
import scalafxml.core.macros.sfxml

import commons.ViewFactory

@sfxml
class ToolbarController(private val homeImage: ImageView,
                        private val calImage: ImageView,
                        private val formImage: ImageView) extends ViewFactory {
  
  homeImage onMouseClicked = (mouseEvent: MouseEvent) =>
    viewOpener(
      mouseEvent,
      resource("/scala/main.fxml"),
      css("/scala/css/main.css")
    )

  calImage onMouseClicked = (mouseEvent: MouseEvent) =>
    viewOpener(
      mouseEvent,
      resource("/scala/calendar.fxml"),
      css("/scala/css/calendar.css")
    )
 
  //formImage.setOnMouseClicked((me: MouseEvent) => { popupOpener("/scala/form.fxml") })

}
