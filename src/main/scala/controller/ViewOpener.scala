
import scalafx.scene.Parent
import scalafx.stage.Stage
import scalafx.scene.Scene
import scalafx.scene.Node
import scalafx.event.ActionEvent
import scalafx.scene.input.MouseEvent


class ViewOpener(root: Parent, styles: List[String]) {

  def open(actionEvent: ActionEvent) = {
    val currentStage =
      actionEvent.
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

  def open(mouseEvent: MouseEvent) = {
    val currentStage =
      mouseEvent.
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

}
