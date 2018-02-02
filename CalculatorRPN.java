import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javax.swing.*;

public class CalculatorRPN extends Application {

    Button button, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonPlus, buttonMinus, buttonMult, buttonDiv, buttonOpen, buttonClose, buttonPercentage;
    static TextField expressionField;
    public static String mathExpression;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("SilverlinedCalculator");
        expressionField = new TextField();
        expressionField.setMinWidth(170);
        buttonsInit();

        HBox topText = new HBox();
        topText.getChildren().add(expressionField);

        HBox bottomButton = new HBox();
        bottomButton.getChildren().addAll(button, buttonOpen, buttonClose, buttonPercentage);

        VBox leftButtons = new VBox();
        leftButtons.getChildren().addAll(buttonPlus, buttonMinus, buttonMult, buttonDiv);

        FlowPane centerButtons = new FlowPane();
        centerButtons.getChildren().addAll(button1, button2, button3, button4, button5, button6, button7, button8, button9);

        BorderPane coreLayout = new BorderPane();
        coreLayout.setTop(topText);
        coreLayout.setBottom(bottomButton);
        coreLayout.setCenter(centerButtons);
        coreLayout.setLeft(leftButtons);

        Scene scene = new Scene(coreLayout, 180, 210);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void buttonsInit() {
        button = new Button("Result");
        button1 = new Button("1");
        button2 = new Button("2");
        button3 = new Button("3");
        button4 = new Button("4");
        button5 = new Button("5");
        button6 = new Button("6");
        button7 = new Button("7");
        button8 = new Button("8");
        button9 = new Button("9");
        buttonPlus = new Button("+");
        buttonMinus = new Button("-");
        buttonMult = new Button("*");
        buttonDiv = new Button("/");
        buttonOpen = new Button("(");
        buttonClose = new Button(")");
        buttonPercentage = new Button("%");
        button.setMinHeight(40);
        button1.setMinHeight(40);
        button2.setMinHeight(40);
        button3.setMinHeight(40);
        button4.setMinHeight(40);
        button5.setMinHeight(40);
        button6.setMinHeight(40);
        button7.setMinHeight(40);
        button8.setMinHeight(40);
        button9.setMinHeight(40);
        buttonPlus.setMinHeight(30);
        buttonMinus.setMinHeight(30);
        buttonMult.setMinHeight(30);
        buttonDiv.setMinHeight(30);
        button1.setMinWidth(40);
        button2.setMinWidth(40);
        button3.setMinWidth(40);
        button4.setMinWidth(40);
        button5.setMinWidth(40);
        button6.setMinWidth(40);
        button7.setMinWidth(40);
        button8.setMinWidth(40);
        button9.setMinWidth(40);;
        buttonPlus.setMinWidth(30);
        buttonMinus.setMinWidth(30);
        buttonMult.setMinWidth(30);
        buttonDiv.setMinWidth(30);
        button1.setOnAction(e -> expressionField.appendText("1"));
        button2.setOnAction(e -> expressionField.appendText("2"));
        button3.setOnAction(e -> expressionField.appendText("3"));
        button4.setOnAction(e -> expressionField.appendText("4"));
        button5.setOnAction(e -> expressionField.appendText("5"));
        button6.setOnAction(e -> expressionField.appendText("6"));
        button7.setOnAction(e -> expressionField.appendText("7"));
        button8.setOnAction(e -> expressionField.appendText("8"));
        button9.setOnAction(e -> expressionField.appendText("9"));
        buttonPlus.setOnAction(e -> expressionField.appendText("+"));
        buttonMinus.setOnAction(e -> expressionField.appendText("-"));
        buttonMult.setOnAction(e -> expressionField.appendText("*"));
        buttonDiv.setOnAction(e -> expressionField.appendText("/"));
        buttonOpen.setOnAction(e -> expressionField.appendText("("));
        buttonClose.setOnAction(e -> expressionField.appendText(")"));
        buttonPercentage.setOnAction(e -> expressionField.appendText("%"));
        button.setOnAction(e -> {
            mathExpression = expressionField.getText();
            RPN.main();
        });
    }
}
