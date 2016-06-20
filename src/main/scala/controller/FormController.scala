package controller

import javafx.scene._
import javafx.stage.Stage

import scalafx.event.ActionEvent
import scalafx.scene.control.CheckBox
import scalafx.scene.layout.StackPane
import scalafxml.core.macros.sfxml
import scalafxml.core.{FXMLView, NoDependencyResolver}


@sfxml
class FormController(private val cakeCB: CheckBox,
                     private val cookiesCB: CheckBox,
                     private val cupcakesCB: CheckBox,
                     private val otherCB: CheckBox,
                     private val cakeAndCookiesOpts: StackPane,
                     private val cupckAndOtherOpts: StackPane) {

  def submitOrder(actionEvent: ActionEvent) {
    val source = actionEvent.getSource.asInstanceOf[Node].getScene.getWindow.asInstanceOf[Stage]
    source.hide;
  }

  def cakeboxSelected(actionEvent: ActionEvent) {
    if(cakeCB.selected.value) {
      val resource = getClass.getResource("/scala/cake_box_selected.fxml")
      val root = FXMLView(resource, NoDependencyResolver)
      cakeAndCookiesOpts.children.add(root)
      } else cakeAndCookiesOpts.children.clear
  }

  def cookiesBoxSelected(actionEvent: ActionEvent) {
    val resource = getClass.getResource("/scala/cookies_box_selected.fxml")
    val root = FXMLView(resource, NoDependencyResolver)
    val components = cakeAndCookiesOpts.children
    def addToCakePane(iter: Int) {
      if(components.isEmpty) components.add(root)
      else if(components.get(iter).getId == "cakePane") {
        val pane =  components.get(iter).asInstanceOf[javafx.scene.layout.Pane]
        pane.minWidth(500)
        pane.getChildren.add(root)
      } else addToCakePane(iter + 1)
    }
    if(cookiesCB.selected.value) addToCakePane(0)
    else cakeAndCookiesOpts.children.clear
  }

  def cupcakesBoxSelected(actionEvent: ActionEvent) {
    if(cupcakesCB.selected.value) {
      val resource = getClass.getResource("/scala/cupcakes_box_selected.fxml")
      val root = FXMLView(resource, NoDependencyResolver)
      cupckAndOtherOpts.children.add(root)
    } else cupckAndOtherOpts.children.clear
  }

  def otherBoxSelected(actionEvent: ActionEvent) {
    val resource = getClass.getResource("/scala/other_box_selected.fxml")
    val root = FXMLView(resource, NoDependencyResolver)
    val components = cupckAndOtherOpts.children
    def addToCupCakePane(iter: Int) {
      if(components.isEmpty) components.add(root)
      else if(components.get(iter).getId == "cupcakesPane") {
        val pane =  components.get(iter).asInstanceOf[javafx.scene.layout.Pane]
        pane.minWidth(500)
        pane.getChildren.add(root)
      } else addToCupCakePane(iter + 1)
    }
    if(otherCB.selected.value) addToCupCakePane(0)
    else cupckAndOtherOpts.children.clear
  }

}



