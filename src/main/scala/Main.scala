
import javafx.{fxml => jfxf, scene => jfxs}

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafxml.core.{FXMLView, NoDependencyResolver}


object Main extends JFXApp {

  val res= getClass.getResource("scala/main.fxml")
  val root = FXMLView(res, NoDependencyResolver)

  stage = new JFXApp.PrimaryStage {
    scene = new Scene(root) {
      stylesheets = List(getClass.getResource("/scala/css/main.css").toExternalForm)
    }
  }
}
    

