/**
<h1>A trait used as a factory for constructing scenes</h1>
  */

package controller.commons

import scalafx.Includes._
import scalafx.stage.Stage
import scalafx.scene.Scene
import scalafx.stage.Stage
import scalafx.event.Event

import scalafxml.core.macros.sfxml
import scalafxml.core.{FXMLView, NoDependencyResolver}

trait ViewFactory {

  /**
    The central factory method

    create a new scene
    
    @param event the event that triggered this method call
    @param root the new scene to be generated, represented by a JavaFX Parent
    @param styles the reference to a css stylesheey to be applied
  */
  def viewOpener(event: Event, root: javafx.scene.Parent, styles: List[String]): Unit = {
    val currentStage =
      event.
      getSource.
      asInstanceOf[javafx.scene.Node].
      getScene.
      getWindow.
      asInstanceOf[javafx.stage.Stage]

    val viewScene = new Scene(root) {
      stylesheets = styles
    }
    currentStage.setScene(viewScene)
    currentStage.show()
  }

  /* Some useful methods for classes implementing ViewFactory */

  /**
    Creates a FXMLView object
  */
  def resource(url: String) = {
    val res = getClass.getResource(url)
    FXMLView(res, NoDependencyResolver)
  }

  /**
   Sets up the CSS reference
  */
  def css(url: String) = List(getClass.getResource(url).toExternalForm)

} 
