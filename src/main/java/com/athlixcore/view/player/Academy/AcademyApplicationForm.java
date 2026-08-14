

package com.athlixcore.view.player.Academy;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class AcademyApplicationForm {

    private String coachName;
    private Runnable onCancel;
    private Runnable onSubmit;

    public AcademyApplicationForm(String coachName, Runnable onCancel, Runnable onSubmit) {
        this.coachName = coachName;
        this.onCancel = onCancel;
        this.onSubmit = onSubmit;
    }

    public StackPane getView() {
        // Dark semi-transparent backdrop glass
        Region glass = new Region();
        glass.setStyle("-fx-background-color: rgba(15, 23, 42, 0.8);");

        // The main container stack holding the active card (form or success screen)
        StackPane cardContainer = new StackPane();
        cardContainer.setAlignment(Pos.CENTER);
        cardContainer.setMaxSize(480, 560);

        // --- 1. FORM CARD (Initial View) ---
        VBox formCard = new VBox(15);
        formCard.setAlignment(Pos.TOP_LEFT);
        formCard.setPadding(new Insets(35));
        formCard.setStyle(
            "-fx-background-color: linear-gradient(to bottom right, #1e293b, #0f172a); " +
            "-fx-background-radius: 22; " +
            "-fx-border-color: rgba(16, 185, 129, 0.3); " +
            "-fx-border-radius: 22; " +
            "-fx-border-width: 1.5; " +
            "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 50, 0, 0, 20);"
        );

        // Form Header with Professional Logo
        HBox iconHeader = new HBox(15);
        iconHeader.setAlignment(Pos.CENTER_LEFT);
        
        ImageView logoView = new ImageView();
        try {
            Image logoImg = new Image("https://cdn-icons-png.flaticon.com/512/3048/3048122.png", 44, 44, true, true, true);
            logoView.setImage(logoImg);
        } catch (Exception e) {}
        logoView.setFitWidth(44);
        logoView.setFitHeight(44);
        
        StackPane logoContainer = new StackPane(logoView);
        logoContainer.setMinSize(52, 52);
        logoContainer.setMaxSize(52, 52);
        logoContainer.setStyle(
            "-fx-background-color: linear-gradient(to bottom right, #334155, #1e293b); " +
            "-fx-background-radius: 14; " +
            "-fx-border-color: rgba(52, 211, 153, 0.3); " +
            "-fx-border-radius: 14; " +
            "-fx-effect: dropshadow(three-pass-box, rgba(16,185,129,0.3), 10, 0, 0, 3);"
        );

        VBox headerBox = new VBox(3);
        Label formTitle = new Label("Coaching Application");
        formTitle.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: white;");
        Label formSubtitle = new Label("Secure training with " + coachName);
        formSubtitle.setStyle("-fx-font-size: 13px; -fx-text-fill: #34d399; -fx-font-weight: bold;");
        headerBox.getChildren().addAll(formTitle, formSubtitle);
        
        iconHeader.getChildren().addAll(logoContainer, headerBox);

        // Form Fields
        VBox nameBox = new VBox(5);
        Label nameLbl = new Label("Player Full Name");
        nameLbl.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #94a3b8;");
        TextField playerNameField = new TextField(""); 
        playerNameField.setStyle(getDarkFieldStyle());
        nameBox.getChildren().addAll(nameLbl, playerNameField);

        VBox ageBox = createDarkFormField("Age", "Enter your age");
        VBox phoneBox = createDarkFormField("Contact Number", "Enter your phone number");
        
        VBox skillBox = new VBox(5);
        Label skillLbl = new Label("Current Skill Level");
        skillLbl.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #94a3b8;");
        ComboBox<String> skillCombo = new ComboBox<>();
        skillCombo.getItems().addAll("Beginner", "Intermediate", "Advanced", "Professional");
        skillCombo.getSelectionModel().selectFirst();
        skillCombo.setMaxWidth(Double.MAX_VALUE);
        skillCombo.setStyle("-fx-background-color: #0f172a; -fx-border-color: #334155; -fx-border-radius: 8; -fx-padding: 6; -fx-font-size: 14px; -fx-text-fill: white;");
        skillBox.getChildren().addAll(skillLbl, skillCombo);

        VBox goalBox = createDarkFormField("Primary Goal", "What do you want to achieve? (e.g. Better swing)");

        // Buttons Container
        HBox buttonRow = new HBox(15);
        buttonRow.setAlignment(Pos.CENTER_RIGHT);
        buttonRow.setPadding(new Insets(10, 0, 0, 0));

        Button cancelBtn = new Button("Cancel");
        cancelBtn.setStyle("-fx-background-color: #1e293b; -fx-text-fill: #cbd5e1; -fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 10 24; -fx-background-radius: 8; -fx-cursor: hand; -fx-border-color: #475569; -fx-border-radius: 8;");

        Button submitBtn = new Button("Submit Application");
        submitBtn.setStyle("-fx-background-color: linear-gradient(to right, #10b981, #059669); -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 10 24; -fx-background-radius: 8; -fx-cursor: hand; -fx-effect: dropshadow(three-pass-box, rgba(16,185,129,0.4), 10, 0, 0, 4);");

        buttonRow.getChildren().addAll(cancelBtn, submitBtn);
        formCard.getChildren().addAll(iconHeader, nameBox, ageBox, skillBox, phoneBox, goalBox, buttonRow);

        // --- 2. SUCCESS CARD (Second View) ---
        VBox successCard = new VBox(20);
        successCard.setAlignment(Pos.CENTER);
        successCard.setPadding(new Insets(40));
        successCard.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 30, 0, 0, 10);");
        successCard.setVisible(false); // Hidden initially

        Label checkIcon = new Label("✔");
        checkIcon.setAlignment(Pos.CENTER);
        checkIcon.setStyle("-fx-background-color: #22c55e; -fx-text-fill: white; -fx-font-size: 40px; -fx-font-weight: bold; -fx-background-radius: 50; -fx-min-width: 80px; -fx-min-height: 80px;");

        Label successTitle = new Label("Purchase Successful!");
        successTitle.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");

        Label successText = new Label("You have successfully purchased a coaching package with " + coachName + ". Your sessions are now ready to be scheduled.");
        successText.setWrapText(true);
        successText.setStyle("-fx-font-size: 14px; -fx-text-fill: #64748b; -fx-text-alignment: center;");
        successText.setAlignment(Pos.CENTER);

        Button dashboardBtn = new Button("View Dashboard");
        dashboardBtn.setStyle("-fx-background-color: #3b82f6; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 10 30; -fx-background-radius: 8; -fx-cursor: hand;");

        successCard.getChildren().addAll(checkIcon, successTitle, successText, dashboardBtn);

        // Add both cards into the container stack
        cardContainer.getChildren().addAll(formCard, successCard);

        // Assemble the Full Popup Layer
        StackPane popupLayer = new StackPane();
        popupLayer.setAlignment(Pos.CENTER);
        popupLayer.getChildren().addAll(glass, cardContainer);

        // --- Actions ---
        cancelBtn.setOnAction(e -> {
            FadeTransition ft = new FadeTransition(Duration.millis(200), popupLayer);
            ft.setToValue(0.0);
            ft.setOnFinished(event -> {
                if (onCancel != null) onCancel.run();
            });
            ft.play();
        });

        // Transition from Form to Success Card smoothly
        submitBtn.setOnAction(e -> {
            FadeTransition fadeOut = new FadeTransition(Duration.millis(200), formCard);
            fadeOut.setToValue(0.0);
            fadeOut.setOnFinished(event -> {
                formCard.setVisible(false);
                successCard.setVisible(true);
                successCard.setOpacity(0.0);
                
                FadeTransition fadeIn = new FadeTransition(Duration.millis(250), successCard);
                fadeIn.setToValue(1.0);
                fadeIn.play();
            });
            fadeOut.play();
        });

        dashboardBtn.setOnAction(e -> {
            // Record that this coach has been purchased in the dashboard tracker
            Academy_Dashboard.purchasedCoachName = coachName;
            
            FadeTransition ft = new FadeTransition(Duration.millis(200), popupLayer);
            ft.setToValue(0.0);
            ft.setOnFinished(event -> {
                if (onSubmit != null) onSubmit.run();
            });
            ft.play();
        });

        // Entrance Animation
        popupLayer.setOpacity(0.0);
        FadeTransition ft = new FadeTransition(Duration.millis(300), popupLayer);
        ft.setToValue(1.0);
        ft.play();

        ScaleTransition st = new ScaleTransition(Duration.millis(300), cardContainer);
        st.setFromX(0.85); st.setFromY(0.85);
        st.setToX(1.0); st.setToY(1.0);
        st.play();

        return popupLayer;
    }

    private VBox createDarkFormField(String label, String placeholder) {
        VBox box = new VBox(5);
        Label lbl = new Label(label);
        lbl.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #94a3b8;");
        TextField field = new TextField();
        field.setPromptText(placeholder);
        field.setStyle(getDarkFieldStyle());
        box.getChildren().addAll(lbl, field);
        return box;
    }

    private String getDarkFieldStyle() {
        return "-fx-background-color: #0f172a; " +
               "-fx-border-color: #334155; " +
               "-fx-border-radius: 8; " +
               "-fx-background-radius: 8; " +
               "-fx-padding: 10; " +
               "-fx-font-size: 14px; " +
               "-fx-text-fill: white; " +
               "-fx-prompt-text-fill: #64748b;";
    }
}