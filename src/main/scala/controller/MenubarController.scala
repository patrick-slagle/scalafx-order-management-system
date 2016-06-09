package controller

import java.net.URL
import javafx.application.Platform
import javafx.embed.swing.JFXPanel
import javafx.scene.Node
import javafx.{fxml => jfxf}

import scalafx.Includes._
import scalafx.event.ActionEvent
import scalafx.event.Event
import scalafx.scene.image.ImageView
import scalafx.scene.layout.BorderPane
import scalafx.scene.input.MouseEvent
import scalafx.scene.{Parent, Scene, control => jfxsc}
import scalafx.stage.Stage
import scalafxml.core.macros.sfxml
import scalafxml.core.{FXMLView, NoDependencyResolver}

@sfxml
class MenubarController(private val homeImage: ImageView,
                        private val calendarImage: ImageView,
                        private val newFormImage: ImageView) {

  def viewOpener(event: Event, root: javafx.scene.Parent, styles: List[String]) = {
    val currentStage = event.
      getSource.
      asInstanceOf[Node].
      getScene.
      getWindow.
      asInstanceOf[javafx.stage.Stage]

    val viewScene = new Scene(root) {
      stylesheets = styles
    }
    currentStage.setScene(viewScene)
    currentStage.show()
  }

  def resource(url: String) = {
    val res = getClass.getResource(url)
    FXMLView(res, NoDependencyResolver)
  }

  def css(url: String) = List(getClass.getResource(url).toExternalForm)

  homeImage.setOnMouseClicked((mouseEvent: MouseEvent) =>
    viewOpener(
      mouseEvent,
      resource("/scala/main.fxml"),
      css("/scala/css/main.css")
    ))

  calendarImage.setOnMouseClicked((mouseEvent: MouseEvent) =>
    viewOpener(
      mouseEvent,
      resource("/scala/calendar.fxml"),
      css("/scala/css/calendar.css")
    ))

  newFormImage.setOnMouseClicked((me: MouseEvent) => { newFormOpener })
  
  def homeViewOpener(actionEvent: ActionEvent) =
    viewOpener(
      actionEvent,
      resource("/scala/main.fxml"),
      css("/scala/css/main.css")
    )

  def newFormOpener = {
    val resource = getClass.getResource("/scala/form.fxml")
    val formRoot = FXMLView(resource, NoDependencyResolver)
    new JFXPanel()
    Platform.runLater(new Runnable() {

      override def run() {
        val formStage = new Stage {
          scene = new Scene(formRoot) {
            stylesheets = List(getClass.getResource("/scala/css/form.css").toExternalForm)
          }
        }
        formStage.show()
      }
    })
  }

  def calViewOpener(actionEvent: ActionEvent) =
    viewOpener(
      actionEvent,
      resource("/scala/calendar.fxml"),
      css("/scala/calendar.css")
    )
}
