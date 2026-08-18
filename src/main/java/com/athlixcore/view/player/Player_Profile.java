package com.athlixcore.view.player;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Player_Profile extends VBox {

    private BorderPane mainLayout;
    private HBox tabsContainer;
    private VBox contentContainer;

    public Player_Profile(BorderPane mainLayout) {
        this.mainLayout = mainLayout;

        this.setSpacing(25);
        this.setPadding(new Insets(30, 40, 30, 40));
        // Soft, modern off-white background
        this.setStyle("-fx-background-color: #f8fafc;"); 

        // 1. Ultra-Modern Profile Header Card
        HBox profileCard = buildPremiumProfileCard();

        // 2. Setup the dynamic pill-shaped tabs container
        tabsContainer = new HBox(15);
        tabsContainer.setAlignment(Pos.CENTER_LEFT);
        tabsContainer.setPadding(new Insets(10, 0, 10, 0));

        // 3. Setup the dynamic content container
        contentContainer = new VBox(20);
        VBox.setVgrow(contentContainer, Priority.ALWAYS);

        this.getChildren().addAll(profileCard, tabsContainer, contentContainer);
        
        // Load the default Overview view
        loadTabContent("Overview");
    }

    private HBox buildPremiumProfileCard() {
        HBox card = new HBox(25);
        card.setPadding(new Insets(35));
        card.setAlignment(Pos.CENTER_LEFT);
        // Premium card styling: Pure white, highly rounded corners, large soft shadow
        card.setStyle("-fx-background-color: white; -fx-background-radius: 20; -fx-border-color: #f1f5f9; -fx-border-radius: 20; -fx-border-width: 2; -fx-effect: dropshadow(three-pass-box, rgba(15,23,42,0.06), 25, 0, 0, 10);");

        // Gradient Avatar
        StackPane avatarPane = new StackPane();
        Label avatar = new Label("V");
        avatar.setPrefSize(90, 90);
        avatar.setAlignment(Pos.CENTER);
        // Beautiful vibrant gradient for the avatar
        avatar.setStyle("-fx-background-color: linear-gradient(to bottom right, #6366f1, #d946ef); -fx-text-fill: white; -fx-background-radius: 45; -fx-font-weight: bold; -fx-font-size: 38px; -fx-effect: dropshadow(three-pass-box, rgba(99,102,241,0.4), 15, 0, 0, 5);");
        avatarPane.getChildren().add(avatar);

        // Details (Name, Role, Badges)
        VBox detailsBox = new VBox(10);
        detailsBox.setAlignment(Pos.CENTER_LEFT);
        
        HBox nameBox = new HBox(10);
        nameBox.setAlignment(Pos.CENTER_LEFT);
        Label nameLbl = new Label("Vikram Malhotra");
        nameLbl.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
        Label proBadge = new Label("PRO");
        proBadge.setStyle("-fx-background-color: #fef08a; -fx-text-fill: #a16207; -fx-font-size: 11px; -fx-font-weight: bold; -fx-padding: 3 8; -fx-background-radius: 8;");
        nameBox.getChildren().addAll(nameLbl, proBadge);
        
        Label roleLbl = new Label("\ud83c\udfcf All-Rounder \u2022 Right-Hand Bat \u2022 Off Spin");
        roleLbl.setStyle("-fx-font-size: 15px; -fx-text-fill: #64748b; -fx-font-weight: bold;");

        HBox statsBox = new HBox(20);
        statsBox.getChildren().addAll(
            createProfileStat("1,248", "Followers"),
            createProfileStat("142", "Following"),
            createProfileStat("99.2", "Rating")
        );

        detailsBox.getChildren().addAll(nameBox, roleLbl, statsBox);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        HBox buttonsBox = new HBox(15);
        buttonsBox.setAlignment(Pos.CENTER_RIGHT);

        // --- ENHANCED BUTTON STYLES ---
        
        // Challenge Button (Subtle gray to Emerald)
        Button challengeBtn = new Button("\u2694 Challenge"); 
        String chDefault = "-fx-background-color: white; -fx-text-fill: #475569; -fx-border-color: #cbd5e1; -fx-border-radius: 25; -fx-background-radius: 25; -fx-font-weight: bold; -fx-padding: 10 25; -fx-font-size: 14px;";
        String chActive = "-fx-background-color: #dcfce3; -fx-text-fill: #166534; -fx-border-color: #22c55e; -fx-border-radius: 25; -fx-background-radius: 25; -fx-font-weight: bold; -fx-padding: 10 25; -fx-font-size: 14px;";
        challengeBtn.setStyle(chDefault);
        challengeBtn.setCursor(Cursor.HAND);
        challengeBtn.setOnAction(e -> {
            if (challengeBtn.getText().equals("\u2694 Challenge")) {
                challengeBtn.setText("Challenge Sent \u2713"); challengeBtn.setStyle(chActive);
            } else {
                challengeBtn.setText("\u2694 Challenge"); challengeBtn.setStyle(chDefault);
            }
        });

        // Message Button (Clean white to soft blue)
        Button messageBtn = new Button("\u2709 Message");
        String msgDefault = "-fx-background-color: white; -fx-text-fill: #475569; -fx-border-color: #cbd5e1; -fx-border-radius: 25; -fx-background-radius: 25; -fx-font-weight: bold; -fx-padding: 10 25; -fx-font-size: 14px;";
        String msgActive = "-fx-background-color: #eff6ff; -fx-text-fill: #2563eb; -fx-border-color: #3b82f6; -fx-border-radius: 25; -fx-background-radius: 25; -fx-font-weight: bold; -fx-padding: 10 25; -fx-font-size: 14px;";
        messageBtn.setStyle(msgDefault);
        messageBtn.setCursor(Cursor.HAND);
        messageBtn.setOnAction(e -> {
            if (messageBtn.getText().equals("\u2709 Message")) {
                messageBtn.setText("Chat Opened"); messageBtn.setStyle(msgActive);
            } else {
                messageBtn.setText("\u2709 Message"); messageBtn.setStyle(msgDefault);
            }
        });

        // Follow Button (Stunning Indigo Gradient)
        Button followBtn = new Button("Follow \u2795");
        String folDefault = "-fx-background-color: linear-gradient(to right, #4f46e5, #7c3aed); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 25; -fx-padding: 11 35; -fx-font-size: 14px; -fx-effect: dropshadow(three-pass-box, rgba(99,102,241,0.4), 10, 0, 0, 4);";
        String folActive = "-fx-background-color: white; -fx-text-fill: #4f46e5; -fx-border-color: #4f46e5; -fx-border-radius: 25; -fx-background-radius: 25; -fx-border-width: 2; -fx-font-weight: bold; -fx-padding: 9 25; -fx-font-size: 14px;";
        followBtn.setStyle(folDefault);
        followBtn.setCursor(Cursor.HAND);
        followBtn.setOnAction(e -> {
            if (followBtn.getText().equals("Follow \u2795")) {
                followBtn.setText("Following \u2713"); followBtn.setStyle(folActive);
            } else {
                followBtn.setText("Follow \u2795"); followBtn.setStyle(folDefault);
            }
        });

        buttonsBox.getChildren().addAll(challengeBtn, messageBtn, followBtn);
        card.getChildren().addAll(avatarPane, detailsBox, spacer, buttonsBox);

        return card;
    }

    private VBox createProfileStat(String value, String label) {
        VBox box = new VBox(2);
        Label vLbl = new Label(value);
        vLbl.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
        Label lLbl = new Label(label);
        lLbl.setStyle("-fx-font-size: 12px; -fx-text-fill: #64748b; -fx-font-weight: bold;");
        box.getChildren().addAll(vLbl, lLbl);
        return box;
    }

    private void loadTabContent(String tabName) {
        tabsContainer.getChildren().clear();
        
        // Create modern pill-shaped tabs
        Button overviewBtn = createTabButton("Overview", tabName.equals("Overview"));
        Button matchesBtn = createTabButton("Matches", tabName.equals("Matches"));
        Button statsBtn = createTabButton("Stats", tabName.equals("Stats"));
        Button achievementsBtn = createTabButton("Achievements", tabName.equals("Achievements"));

        overviewBtn.setOnAction(e -> loadTabContent("Overview"));
        matchesBtn.setOnAction(e -> loadTabContent("Matches"));
        statsBtn.setOnAction(e -> loadTabContent("Stats"));
        achievementsBtn.setOnAction(e -> loadTabContent("Achievements"));

        tabsContainer.getChildren().addAll(overviewBtn, matchesBtn, statsBtn, achievementsBtn);

        // Rebuild Content Area
        contentContainer.getChildren().clear();
        
        Label title = new Label();
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
        
        Label bodyText = new Label();
        bodyText.setStyle("-fx-font-size: 15px; -fx-text-fill: #475569; -fx-line-spacing: 5px;");
        bodyText.setWrapText(true);

        // A beautiful grid of data cards instead of an empty box!
        HBox dataCardsBox = new HBox(20);
        dataCardsBox.setPadding(new Insets(10, 0, 0, 0));

        switch (tabName) {
            case "Matches" -> {
                title.setText("Recent Form & Match History");
                bodyText.setText("Vikram has been in excellent form over the last month, winning 4 of the last 5 outings.");
                dataCardsBox.getChildren().addAll(
                    createDataCard("Form", "W W L W W", "#22c55e"),
                    createDataCard("Last Match", "84* (42)", "#3b82f6"),
                    createDataCard("Upcoming", "vs Titans", "#f59e0b")
                );
            }
            case "Stats" -> {
                title.setText("Detailed Performance Metrics");
                bodyText.setText("Consistently dominating both with the bat and the ball in the State Pro League.");
                dataCardsBox.getChildren().addAll(
                    createDataCard("Batting Avg", "45.2", "#6366f1"),
                    createDataCard("Strike Rate", "158.4", "#ec4899"),
                    createDataCard("Economy", "7.2", "#10b981")
                );
            }
            case "Achievements" -> {
                title.setText("Trophy Cabinet");
                bodyText.setText("Major accolades and milestones achieved throughout the athletic career.");
                dataCardsBox.getChildren().addAll(
                    createDataCard("\ud83c\udfc6 MVP", "2024 League", "#eab308"),
                    createDataCard("\ud83e\udd47 Gold", "State Finals", "#eab308"),
                    createDataCard("\ud83c\udfcf Best Bat", "April Series", "#eab308")
                );
            }
            default -> { 
                title.setText("About Vikram");
                bodyText.setText("Experienced all-rounder with over 5 years of competitive club cricket experience in Maharashtra. Known for aggressive top-order batting and reliable middle-overs spin bowling. Currently leading the run-scoring charts for the Elite Strikers academy.");
                dataCardsBox.getChildren().addAll(
                    createDataCard("Matches", "142", "#4f46e5"),
                    createDataCard("Win Rate", "68%", "#0ea5e9"),
                    createDataCard("MoM Awards", "12", "#8b5cf6")
                );
            }
        }

        contentContainer.getChildren().addAll(title, bodyText, dataCardsBox);
    }

    private Button createTabButton(String text, boolean isActive) {
        Button btn = new Button(text);
        btn.setCursor(Cursor.HAND);
        if (isActive) {
            // Modern Blue Pill for active tab
            btn.setStyle("-fx-background-color: #e0e7ff; -fx-text-fill: #4338ca; -fx-font-weight: bold; -fx-font-size: 14px; -fx-background-radius: 20; -fx-padding: 8 22;");
        } else {
            // Clean transparent text for inactive
            btn.setStyle("-fx-background-color: transparent; -fx-text-fill: #64748b; -fx-font-weight: bold; -fx-font-size: 14px; -fx-padding: 8 22;");
        }
        return btn;
    }

    // Helper method to create beautiful colorful data cards for the bottom section!
    private VBox createDataCard(String title, String value, String colorHex) {
        VBox card = new VBox(8);
        card.setAlignment(Pos.CENTER_LEFT);
        card.setPadding(new Insets(20));
        card.setPrefSize(200, 100);
        card.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-border-color: #f1f5f9; -fx-border-width: 1; -fx-border-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(15,23,42,0.03), 10, 0, 0, 4);");

        Label t = new Label(title);
        t.setStyle("-fx-text-fill: #64748b; -fx-font-size: 13px; -fx-font-weight: bold; -fx-letter-spacing: 0.5px;");
        
        Label v = new Label(value);
        v.setStyle("-fx-text-fill: " + colorHex + "; -fx-font-size: 24px; -fx-font-weight: bold;");

        card.getChildren().addAll(t, v);
        return card;
    }
}