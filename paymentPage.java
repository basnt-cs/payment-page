package labs.mavenproject8;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import static javafx.scene.effect.BlendMode.GREEN;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private ComboBox<String> cboCity;

    @Override
    public void start(Stage stage) {

        BorderPane pane = new BorderPane();

        ////////Top//////////
        Text tCheckOut = new Text(100, 100, "CHECK OUT");
        tCheckOut.setFont(Font.font("Amasis MT Pro Medium", FontWeight.BOLD, FontPosture.REGULAR, 30));
        tCheckOut.setFill(Color.web("#658354"));
        //layer1.getChildren().addAll(t1);
        StackPane stackPane = new StackPane(tCheckOut);
        stackPane.setAlignment(Pos.TOP_CENTER);
        pane.setTop(stackPane);
        stackPane.setStyle("-fx-background-color: #c7ddb5; -fx-border-color: BLACK; -fx-border-width: 2px;");

        //////////Payment Method/////////////
        Rectangle recPayMethod = new Rectangle();
        recPayMethod.setWidth(350);
        recPayMethod.setHeight(40);
        recPayMethod.setArcWidth(25);
        recPayMethod.setArcHeight(25);
        recPayMethod.setFill(Color.DARKSEAGREEN);
        recPayMethod.setStroke(Color.DARKOLIVEGREEN);

        Text tPayMeth = new Text("Payment Method");
        tPayMeth.setFont(Font.font("Amasis MT Pro Medium", FontWeight.BOLD, FontPosture.REGULAR, 15));
        tPayMeth.setFill(Color.web("#658354"));
        tPayMeth.setTranslateX(5);

        Button ButCredit = new Button("     Credit");
        ButCredit.setStyle("-fx-background-color:#ADBB92;");
        ButCredit.setTranslateX(200);
        ButCredit.setPrefWidth(65); // Set the preferred width

        Image imageCredit = new Image("file:/Users/basnt/Downloads/Descargar_icono_de_vector_de_tarjeta_de_crédito_sobre_fondo_blanco_gratis-removebg-preview.png");
        ImageView credit = new ImageView(imageCredit);
        credit.setFitWidth(21);
        credit.setFitHeight(16);
        credit.setTranslateX(201);

        Button ButCash = new Button("      Cash");
        ButCash.setStyle("-fx-background-color:#ADBB92;");
        ButCash.setTranslateX(280);
        ButCash.setPrefWidth(65);

        Image imageCash = new Image("file:/Users/basnt/Downloads/Cash_currency_icon-removebg-preview.png");
        ImageView cash = new ImageView(imageCash);
        cash.setFitWidth(25);
        cash.setFitHeight(19);
        cash.setTranslateX(282);
        cash.setTranslateY(-2);

        StackPane allPayMeth = new StackPane();
        allPayMeth.setAlignment(Pos.CENTER_LEFT);
        allPayMeth.getChildren().addAll(recPayMethod, tPayMeth, ButCredit, credit, ButCash, cash);

        Rectangle recDeliveryLoc = new Rectangle();
        recDeliveryLoc.setWidth(350);
        recDeliveryLoc.setHeight(40);
        recDeliveryLoc.setArcWidth(25);
        recDeliveryLoc.setArcHeight(25);
        recDeliveryLoc.setFill(Color.DARKSEAGREEN);
        recDeliveryLoc.setStroke(Color.DARKOLIVEGREEN);

        Text tDeliverLoc = new Text("Delivery Location");
        tDeliverLoc.setFont(Font.font("Amasis MT Pro Medium", FontWeight.BOLD, FontPosture.REGULAR, 15));
        tDeliverLoc.setFill(Color.web("#658354"));
        tDeliverLoc.setTranslateX(5);

        //ComboBox cboCity = new ComboBox();
        String[] city = {"Makkah", "Jeddah", "Riyadh", "Khobar"};
        cboCity = new ComboBox<>();
        cboCity.getItems().addAll(city);
        cboCity.setTranslateX(200);
        cboCity.setTranslateY(-50);
        cboCity.setStyle("-fx-background-color:#ADBB92;");

        StackPane allDeliveryLoc = new StackPane();
        allDeliveryLoc.setAlignment(Pos.CENTER_LEFT);
        allDeliveryLoc.getChildren().addAll(recDeliveryLoc, tDeliverLoc, cboCity);

        Text tStreet = new Text("Street");
        tStreet.setFont(Font.font("Amasis MT Pro Medium", FontWeight.BOLD, FontPosture.REGULAR, 15));
        tStreet.setFill(Color.web("#658354"));

        Text tDistrict = new Text("District");
        tDistrict.setFont(Font.font("Amasis MT Pro Medium", FontWeight.BOLD, FontPosture.REGULAR, 15));
        tDistrict.setFill(Color.web("#658354"));

        TextField tfStreet = new TextField();
        TextField tfDistrict = new TextField();
        //ield tfDistrict.setTranslateY(50);
        
        Text actionTarget = new Text();
        Text actionTarget2 = new Text();
        Text actionTarget3 = new Text();

        Text tCard = new Text();
        tCard.setFont(Font.font("Amasis MT Pro Medium", FontWeight.BOLD, FontPosture.REGULAR, 13));
        tCard.setFill(Color.web("#658354"));

        Text tCardHolder = new Text();
        tCardHolder.setFont(Font.font("Amasis MT Pro Medium", FontWeight.BOLD, FontPosture.REGULAR, 13));
        tCardHolder.setFill(Color.web("#658354"));

        Text tCVV = new Text();
        tCVV.setFont(Font.font("Amasis MT Pro Medium", FontWeight.BOLD, FontPosture.REGULAR, 13));
        tCVV.setFill(Color.web("#658354"));

        TextField tfCard = new TextField();
        TextField tfCardHolder = new TextField();
        TextField tfCVV = new TextField();

        Image imMapMakkah = new Image("file:/Users/basnt/OneDrive/الصور/لقطات الشاشة/Screenshot (876).png");
        ImageView mapMakkah = new ImageView();
        mapMakkah.setFitWidth(180);
        mapMakkah.setFitHeight(180);
        mapMakkah.setTranslateX(70);
        mapMakkah.setTranslateY(-40);

        Image imMapJeddah = new Image("file:/Users/basnt/OneDrive/الصور/لقطات الشاشة/Screenshot (877).png");
        ImageView mapJeddah = new ImageView();
        mapJeddah.setFitWidth(180);
        mapJeddah.setFitHeight(180);
        mapJeddah.setTranslateX(70);
        mapJeddah.setTranslateY(-40);

        Image imMapRiyadh = new Image("file:/Users/basnt/OneDrive/الصور/لقطات الشاشة/Screenshot (879).png");
        ImageView mapRiyadh = new ImageView();
        mapRiyadh.setFitWidth(180);
        mapRiyadh.setFitHeight(180);
        mapRiyadh.setTranslateX(70);
        mapRiyadh.setTranslateY(-40);

        Image imMapKhobar = new Image("file:/Users/basnt/OneDrive/الصور/لقطات الشاشة/Screenshot (881).png");
        ImageView mapKhobar = new ImageView();
        mapKhobar.setFitWidth(180);
        mapKhobar.setFitHeight(180);
        mapKhobar.setTranslateX(70);
        mapKhobar.setTranslateY(-40);

        StackPane spCities = new StackPane();
        spCities.getChildren().addAll(mapMakkah, mapJeddah, mapRiyadh, mapKhobar);

        HBox hBoxStreet = new HBox(20);
        hBoxStreet.getChildren().add(tStreet);
        hBoxStreet.getChildren().add(tfStreet);

        HBox hBoxDistrict = new HBox(15);
        hBoxDistrict.getChildren().add(tDistrict);
        hBoxDistrict.getChildren().add(tfDistrict);

        
        VBox vBox = new VBox(40);
        vBox.getChildren().addAll(hBoxStreet);
        vBox.getChildren().addAll(hBoxDistrict);

        HBox hBox = new HBox(10);
        hBox.getChildren().add(vBox);
        hBox.getChildren().add(spCities);
        hBox.setTranslateX(20);
        hBox.setTranslateY(-10);

        HBox hBox3 = new HBox(5);

        StackPane CashAndCredit = new StackPane();



        //////////Order Detailes//////////////////
        Rectangle recOrderDet = new Rectangle();
        recOrderDet.setWidth(300);
        recOrderDet.setHeight(40);
        recOrderDet.setArcWidth(25);
        recOrderDet.setArcHeight(25);
        recOrderDet.setFill(Color.DARKSEAGREEN);
        recOrderDet.setStroke(Color.DARKOLIVEGREEN);

        Text tOrderDet = new Text("Order details");
        tOrderDet.setFont(Font.font("Amasis MT Pro Medium", FontWeight.BOLD, FontPosture.REGULAR, 15));
        tOrderDet.setFill(Color.web("#658354"));
        tPayMeth.setTranslateX(5);

        Rectangle recRecipt = new Rectangle();
        recRecipt.setWidth(300);
        recRecipt.setHeight(100);
        recRecipt.setArcWidth(25);
        recRecipt.setArcHeight(25);
        recRecipt.setFill(Color.TRANSPARENT);
        recRecipt.setStroke(Color.DARKOLIVEGREEN);
        recRecipt.setStrokeWidth(3);

        Text tRecipt = new Text("flower\t\t\t\t\t55.00SAR\nhHerringbone plant\t\t60.00SAR\nPilea\t\t\t\t\t50.00SAR\nshipping fee\t\t\t\t12.00SAR\nTotal\t\t\t\t\t177SAR");
        tRecipt.setFont(Font.font("Amasis MT Pro Medium", FontWeight.BOLD, FontPosture.REGULAR, 15));
        tRecipt.setFill(Color.web("#658354"));
        tRecipt.setTranslateX(5);

//        String receipt = "item1\t22.50SAR\nitem2\t20.00SAR\nitem3\t30.50SAR\nshipping fee\t12.00SAR";
//        exportToNoteFile(receipt);
        //apply it here
        Button ButPayNow = new Button("Pay now");
        //ButPayNow.setStyle("-fx-background-color:#ADBB92;");
        ButPayNow.setStyle("-fx-font-family: Amasis MT Pro Medium; -fx-font-size: 14px; -fx-text-fill: white; -fx-background-color:#ADBB92;");
        //ButPayNow.setTranslateX(280);
        ButPayNow.setPrefWidth(200);
        ButPayNow.setTranslateX(250);
        ButPayNow.setTranslateY(-50);

        StackPane allOrderDet = new StackPane();
        allOrderDet.getChildren().addAll(recOrderDet, tOrderDet);
        allOrderDet.setTranslateY(-50);

        StackPane allRecipt = new StackPane();
        allRecipt.getChildren().addAll(recRecipt, tRecipt);
        allRecipt.setTranslateY(-50);
//
//        VBox bottom = new VBox(10);
//        bottom.setPadding(new Insets(100, 100, 1, 100));
//        bottom.getChildren().add(allOrderDet);
//        bottom.getChildren().add(allRecipt);
//        bottom.setTranslateY(200);

        VBox center = new VBox(15);
        center.setPadding(new Insets(25, 20, 20, 0));
        center.getChildren().add(allPayMeth);
        center.getChildren().add(actionTarget);
        center.getChildren().add(CashAndCredit);
        center.getChildren().addAll(allDeliveryLoc);
        center.getChildren().add(cboCity);
        //center.getChildren().add(mapMakkah);
        center.getChildren().add(hBox);
        //center.setPadding(new Insets(100, 100, 1, 100));
        center.getChildren().add(allOrderDet);
        center.getChildren().add(allRecipt);
        //center.setTranslateY(200);
        //pane.setCenter(center);

        StackPane sP = new StackPane();
        sP.getChildren().addAll(center);
        pane.setCenter(sP);

        ButCredit.setOnAction(e -> {
            CashAndCredit.getChildren().clear();
            actionTarget.setFill(Color.FIREBRICK);
            actionTarget.setText("please write your card info");
            tCard.setText("Card Number");
            tCardHolder.setText("Card Holder Name");
            tCVV.setText("CVV");
            hBox3.getChildren().add(tCard);
            hBox3.getChildren().add(tfCard);
            hBox3.getChildren().add(tCardHolder);
            hBox3.getChildren().add(tfCardHolder);
            hBox3.getChildren().add(tCVV);
            hBox3.getChildren().add(tfCVV);
            center.getChildren().add(ButPayNow);

            CashAndCredit.getChildren().add(hBox3);

        });

        ButCash.setOnAction(e -> {
            CashAndCredit.getChildren().clear();
            actionTarget.setFill(Color.FIREBRICK);
            actionTarget.setText("The payment will be in cash");
            CashAndCredit.getChildren().add(actionTarget2);
            //vbCreditCash.getChildren().add(actionTarget);

        });

        ButPayNow.setOnAction(e -> {
            CashAndCredit.getChildren().clear();
            actionTarget.setFill(Color.FIREBRICK);
            actionTarget.setText("The payment is done");
            actionTarget.setTranslateX(100);
            actionTarget.setTranslateX(-100);
            //CashAndCredit.getChildren().add(actionTarget3);
            center.getChildren().add(actionTarget);
            //vbCreditCash.getChildren().add(actionTarget);

        });

        cboCity.setOnAction(e -> {
            if (cboCity.getSelectionModel().getSelectedItem().equalsIgnoreCase("Makkah")) {
                spCities.getChildren().clear();
                mapMakkah.setImage(imMapMakkah);
                spCities.getChildren().add(mapMakkah);

            } else if (cboCity.getSelectionModel().getSelectedItem().equalsIgnoreCase("Jeddah")) {
                spCities.getChildren().clear();
                mapJeddah.setImage(imMapJeddah);
                spCities.getChildren().add(mapJeddah);

            } else if (cboCity.getSelectionModel().getSelectedItem().equalsIgnoreCase("Riyadh")) {
                spCities.getChildren().clear();
                mapRiyadh.setImage(imMapRiyadh);
                spCities.getChildren().add(mapRiyadh);

            } else if (cboCity.getSelectionModel().getSelectedItem().equalsIgnoreCase("Khobar")) {
                spCities.getChildren().clear();
                mapKhobar.setImage(imMapKhobar);
                spCities.getChildren().add(mapKhobar);
            }
        });

        //apply it here
        try (PrintStream printStream = new PrintStream("C:/Users/basnt/OneDrive/سطح المكتب/recept.txt")) {
            
            printStream.print(tRecipt);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        /////////Scroll Bar/////////
        ScrollPane scroll = new ScrollPane();
        //scroll.setContent(pane);
        //pane.setRight(scroll);

        Scene scene = new Scene(pane, 700, 650);
        stage.setScene(scene);
        stage.setTitle("Exercise 2");
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}
