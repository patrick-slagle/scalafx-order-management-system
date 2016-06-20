package controller

import javafx.application.Platform
import javafx.embed.swing.JFXPanel
import javafx.scene.Node
import javafx.{fxml => jfxf}

import scalafx.Includes._
import scalafx.event.{ActionEvent, Event}
import scalafx.scene.image.ImageView
import scalafx.scene.control.MenuItem
import scalafx.scene.input.MouseEvent
import scalafx.scene.{Scene, control => jfxsc}
import scalafx.stage.Stage
import scalafxml.core.macros.sfxml
import scalafxml.core.{FXMLView, NoDependencyResolver}
import commons.ViewFactory

@sfxml
class MenubarController extends ViewFactory {

  def homeViewOpener(actionEvent: ActionEvent) =
    viewOpener(
      actionEvent,
      resource("/scala/main.fxml"),
      css("/scala/css/main.css")
    )

  def handlePopupOpener(actionEvent: ActionEvent) =
    popupOpener("/scala/form.fxml")
    
  def popupOpener(root: String) = {
    new JFXPanel()
    val formRoot = resource(root)
    Platform.runLater(new Runnable() {
      override def run() {
        val formStage = new Stage {
          scene = new Scene(formRoot) {
            stylesheets = css("/scala/css/form.css")
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

  def memoOpener(actionEvent: ActionEvent) =
    viewOpener(
      actionEvent,
      resource("/scala/memo_dialog.fxml"),
      css("/scala/css/form.css")
    )

}

