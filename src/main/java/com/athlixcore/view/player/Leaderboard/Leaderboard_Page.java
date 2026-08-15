package com.athlixcore.view.player.Leaderboard;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Leaderboard_Page extends StackPane { 

    private BorderPane mainLayout;
    private VBox podiumContainer;
    private HBox tabsContainer;
    private VBox tableRowsContainer;
    private TextField searchField; // Added Search Field reference
    
    private StackPane viewContainer; 

    public Leaderboard_Page(BorderPane mainLayout) {
        this.mainLayout = mainLayout;
        
        // --- LAYER 1: STADIUM BACKGROUND IMAGE ---
        ImageView bgImage = new ImageView();
        try {
            java.io.File file = new java.io.File("src/main/resources/assests/images/stadium.jpg");
            
            if (file.exists()) {
                String bgPath = file.toURI().toString();
                Image image = new Image(bgPath);
                bgImage.setImage(image);
                bgImage.setPreserveRatio(false); 
                bgImage.fitWidthProperty().bind(this.widthProperty());
                bgImage.fitHeightProperty().bind(this.heightProperty());
            } else {
                System.out.println("❌ ERROR: Could not find image at -> " + file.getAbsolutePath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // --- LAYER 2: DARK OVERLAY ---
        Region overlay = new Region();
        overlay.setStyle("-fx-background-color: rgba(15, 23, 42, 0.45);"); 

        // --- LAYER 3: FOREGROUND CONTENT CONTAINER ---
        viewContainer = new StackPane();
        
        this.getChildren().addAll(bgImage, overlay, viewContainer);

        showLeaderboardView("Overall");
    }

    private void showLeaderboardView(String initialCategory) {
        viewContainer.getChildren().clear();

        HBox pageHeader = new HBox(15); // Added spacing
        pageHeader.setAlignment(Pos.CENTER_LEFT);
        
        VBox titleBox = new VBox(5);
        Label mainTitle = new Label("Leaderboard");
        mainTitle.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: white;"); 
        Label subTitle = new Label("Top performers across all formats and categories");
        subTitle.setStyle("-fx-font-size: 14px; -fx-text-fill: #cbd5e1;"); 
        titleBox.getChildren().addAll(mainTitle, subTitle);
        
        Region headerSpacer = new Region();
        HBox.setHgrow(headerSpacer, Priority.ALWAYS);
        
        // --- ADDED: INTERACTIVE SEARCH BAR ---
        searchField = new TextField();
        searchField.setPromptText("Search players...");
        searchField.setPrefWidth(240);
        searchField.setStyle("-fx-background-color: rgba(255,255,255,0.95); -fx-border-color: #cbd5e1; -fx-border-radius: 20; -fx-background-radius: 20; -fx-padding: 8 15 8 35; -fx-font-size: 13px;");
        
        Label searchIcon = new Label("🔍");
        searchIcon.setStyle("-fx-text-fill: #64748b; -fx-font-size: 14px;");
        
        StackPane searchPane = new StackPane(searchField, searchIcon);
        StackPane.setAlignment(searchIcon, Pos.CENTER_LEFT);
        StackPane.setMargin(searchIcon, new Insets(0, 0, 0, 12));

        // Real-time filtering logic
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filterTableRows(newValue);
        });

        ComboBox<String> seasonCombo = new ComboBox<>();
        seasonCombo.getItems().addAll("This Season", "Last Season", "All Time");
        seasonCombo.setValue("📅 This Season");
        seasonCombo.setStyle("-fx-background-color: white; -fx-border-color: #e5e7eb; -fx-border-radius: 8; -fx-background-radius: 8; -fx-padding: 4 10; -fx-font-weight: bold; -fx-text-fill: #374151;");
        
        // Added searchPane to header
        pageHeader.getChildren().addAll(titleBox, headerSpacer, searchPane, seasonCombo);

        VBox leftContent = new VBox(25);
        VBox.setVgrow(leftContent, Priority.ALWAYS);

        tabsContainer = new HBox(10);
        tabsContainer.setAlignment(Pos.CENTER_LEFT);

        podiumContainer = new VBox();
        podiumContainer.setAlignment(Pos.CENTER);

        VBox rankingTable = buildRankingTableContainer();

        leftContent.getChildren().addAll(tabsContainer, podiumContainer, rankingTable);

        VBox contentBox = new VBox(25, pageHeader, leftContent);
        contentBox.setPadding(new Insets(25, 40, 25, 40));

        ScrollPane mainScrollPane = new ScrollPane(contentBox);
        mainScrollPane.setFitToWidth(true);
        mainScrollPane.setStyle("-fx-background-color: transparent; -fx-background-insets: 0; -fx-padding: 0;");
        mainScrollPane.getStylesheets().add("data:text/css,.scroll-pane > .viewport { -fx-background-color: transparent; }");

        viewContainer.getChildren().add(mainScrollPane);

        loadCategoryData(initialCategory);
    }

    // --- ADDED: FILTER ENGINE ---
    private void filterTableRows(String query) {
        String lowerCaseQuery = query.toLowerCase();
        if (tableRowsContainer != null) {
            for (Node node : tableRowsContainer.getChildren()) {
                if (node instanceof HBox) {
                    // We extract the stored player name from the row's properties
                    String playerName = (String) node.getProperties().get("playerName");
                    if (playerName != null) {
                        boolean match = playerName.toLowerCase().contains(lowerCaseQuery);
                        node.setVisible(match);
                        node.setManaged(match);
                    }
                }
            }
        }
    }

    private void loadCategoryData(String category) {
        tabsContainer.getChildren().clear();
        tabsContainer.getChildren().addAll(
            createCategoryTab("🎯 Overall", "Overall", category.equals("Overall")),
            createCategoryTab("🏏 Batsman", "Batsman", category.equals("Batsman")),
            createCategoryTab("⚾ Bowler", "Bowler", category.equals("Bowler")),
            createCategoryTab("⚡ All Rounder", "All Rounder", category.equals("All Rounder")),
            createCategoryTab("🥊 Fielders", "Fielders", category.equals("Fielders"))
        );

        podiumContainer.getChildren().clear();
        buildLightPodium(category);

        tableRowsContainer.getChildren().clear();
        loadTableRowsForCategory(category);

        // Reset search field when switching tabs
        if (searchField != null) {
            searchField.clear();
        }
    }

    private Button createCategoryTab(String displayText, String categoryKey, boolean isActive) {
        Button btn = new Button(displayText);
        btn.setCursor(Cursor.HAND);
        if (isActive) {
            btn.setStyle("-fx-background-color: #16a34a; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 13px; -fx-background-radius: 8; -fx-padding: 8 16;");
        } else {
            btn.setStyle("-fx-background-color: rgba(255,255,255,0.15); -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 13px; -fx-background-radius: 8; -fx-padding: 8 16;");
            btn.setOnMouseEntered(e -> btn.setStyle("-fx-background-color: rgba(255,255,255,0.3); -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 13px; -fx-background-radius: 8; -fx-padding: 8 16;"));
            btn.setOnMouseExited(e -> btn.setStyle("-fx-background-color: rgba(255,255,255,0.15); -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 13px; -fx-background-radius: 8; -fx-padding: 8 16;"));
        }
        btn.setOnAction(e -> loadCategoryData(categoryKey));
        return btn;
    }

    private void buildLightPodium(String category) {
        HBox podiumRow = new HBox(25);
        podiumRow.setAlignment(Pos.CENTER); 
        
        VBox rank1, rank2, rank3;
        
        if (category.equals("Batsman")) {
            rank2 = buildPodiumCard("Surya Kumar Yadav", "2,450", "82.4", "#ffffff", 250, "2", "#94a3b8", "#3b82f6", "/assests/images/surya.jpg", true);
            rank1 = buildPodiumCard("Virat Kohli", "3,125", "89.7", "#fffbeb", 250, "1", "#f59e0b", "#f59e0b", "/assests/images/Virat.jpg", true);
            rank3 = buildPodiumCard("Rohit Sharma", "2,210", "80.2", "#ffffff", 250, "3", "#b45309", "#d97706", "/assests/images/rohit.jpg", false);
        } else {
            rank2 = buildPodiumCard("Surya Kumar Yadav", "2,450", "82.4", "#ffffff", 250, "2", "#94a3b8", "#3b82f6", "/assests/images/surya.jpg", false);
            rank1 = buildPodiumCard("Virat Kohli", "3,125", "89.7", "#fffbeb", 250, "1", "#f59e0b", "#f59e0b", "/assests/images/Virat.jpg", true);
            rank3 = buildPodiumCard("Rohit Sharma", "2,210", "80.2", "#fff5f5", 250, "3", "#b45309", "#d97706", "/assests/images/rohit.jpg", true);
        }
        
        podiumRow.getChildren().addAll(rank2, rank1, rank3);
        podiumContainer.getChildren().add(podiumRow);
    }

    private VBox buildPodiumCard(String name, String points, String rating, String bgColor, double height, String rank, String medalColor, String badgeColor, String imagePath, boolean isOnline) {
        VBox card = new VBox(15);
        card.setAlignment(Pos.CENTER);
        card.setPrefHeight(height);
        card.setMinHeight(height);
        card.setMaxHeight(height);
        HBox.setHgrow(card, Priority.ALWAYS);
        card.setMaxWidth(Double.MAX_VALUE);
        card.setCursor(Cursor.HAND);
        card.setStyle("-fx-background-color: " + bgColor + "; -fx-background-radius: 12; -fx-border-color: #f1f5f9; -fx-border-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.15), 15, 0, 0, 5);");

        Label medal = new Label(rank);
        medal.setPrefSize(30, 30);
        medal.setAlignment(Pos.CENTER);
        medal.setStyle("-fx-background-color: " + medalColor + "; -fx-text-fill: white; -fx-background-radius: 15; -fx-font-weight: bold; -fx-font-size: 14px;");

        Node avatarNode = getPlayerAvatar(name, imagePath, 80, "#1e3a8a", "white");
        Circle statusBadge = new Circle(8);
        statusBadge.setFill(isOnline ? Color.valueOf("#10b981") : Color.valueOf("#9ca3af"));
        statusBadge.setStroke(Color.WHITE);
        statusBadge.setStrokeWidth(2);

        StackPane avatarPane = new StackPane(avatarNode, statusBadge);
        StackPane.setAlignment(statusBadge, Pos.BOTTOM_RIGHT);

        VBox textStack = new VBox(5);
        textStack.setAlignment(Pos.CENTER);
        Label nameLbl = new Label(name);
        nameLbl.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: #111827;");
        Label pointsLbl = new Label(points + " Points");
        pointsLbl.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: #6b7280;");
        textStack.getChildren().addAll(nameLbl, pointsLbl);

        Label ratingBadge = new Label(rating);
        ratingBadge.setPrefSize(50, 30);
        ratingBadge.setAlignment(Pos.CENTER);
        ratingBadge.setStyle("-fx-background-color: " + badgeColor + "; -fx-text-fill: white; -fx-background-radius: 8; -fx-font-weight: bold; -fx-font-size: 13px;");

        card.getChildren().addAll(medal, avatarPane, textStack, ratingBadge);
        
        Tooltip tooltip = new Tooltip();
        VBox tooltipContent = new VBox(5);
        tooltipContent.setStyle("-fx-background-color: #0f172a; -fx-padding: 12 16 12 16; -fx-background-radius: 8; -fx-border-color: #334155; -fx-border-radius: 8;");
        Label ttName = new Label(name);
        ttName.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14px;");
        Label ttRole = new Label(rank.equals("1") ? "★ Current Leader" : "Challenger");
        ttRole.setStyle("-fx-text-fill: #10b981; -fx-font-size: 11px; -fx-font-weight: bold;");
        Label ttStats = new Label("Total Points: " + points + "\nMatch Rating: " + rating);
        ttStats.setStyle("-fx-text-fill: #94a3b8; -fx-font-size: 12px; -fx-line-spacing: 3px;");
        
        tooltipContent.getChildren().addAll(ttName, ttRole, ttStats);
        tooltip.setGraphic(tooltipContent);
        tooltip.setStyle("-fx-background-color: transparent; -fx-padding: 0;"); 
        tooltip.setShowDelay(Duration.millis(150)); 
        Tooltip.install(card, tooltip);

        card.setOnMouseEntered(e -> card.setStyle("-fx-background-color: " + bgColor + "; -fx-background-radius: 12; -fx-border-color: #94a3b8; -fx-border-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 20, 0, 0, 8);"));
        card.setOnMouseExited(e -> card.setStyle("-fx-background-color: " + bgColor + "; -fx-background-radius: 12; -fx-border-color: #f1f5f9; -fx-border-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.15), 15, 0, 0, 5);"));

        card.setOnMouseClicked(e -> {
            viewContainer.getChildren().clear();
            viewContainer.getChildren().add(new LeaderboardPlayerProfile(mainLayout, name, imagePath, () -> showLeaderboardView("Overall")));
        });
        
        return card;
    }

    private VBox buildRankingTableContainer() {
        VBox tableContainer = new VBox(15);
        Label title = new Label("Top 10 Players");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: white;"); 

        VBox table = new VBox(0);
        table.setStyle("-fx-background-color: white; -fx-background-radius: 12; -fx-border-color: #e5e7eb; -fx-border-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 15, 0, 0, 5);");
        
        HBox header = new HBox(10);
        header.setPadding(new Insets(15, 20, 15, 20));
        header.setStyle("-fx-border-color: #e5e7eb; -fx-border-width: 0 0 1 0;");
        header.setAlignment(Pos.CENTER_LEFT);
        header.getChildren().addAll(
            createHeaderLabel("Rank", 60), 
            createHeaderLabel("Player", -1), 
            createHeaderLabel("Matches", 100), 
            createHeaderLabel("Runs", 100), 
            createHeaderLabel("Wickets", 100),
            createHeaderLabel("Points", 100),
            createHeaderLabel("Rating", 80)
        );
        
        tableRowsContainer = new VBox();
        Button viewFullBtn = new Button("View Full Leaderboard →");
        viewFullBtn.setCursor(Cursor.HAND);
        viewFullBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: #2563eb; -fx-font-weight: bold; -fx-padding: 15;");
        viewFullBtn.setMaxWidth(Double.MAX_VALUE);
        viewFullBtn.setOnAction(e -> showFullLeaderboardGrid());

        table.getChildren().addAll(header, tableRowsContainer, viewFullBtn);
        tableContainer.getChildren().addAll(title, table);
        
        return tableContainer;
    }

    private Label createHeaderLabel(String text, double width) {
        Label lbl = new Label(text);
        lbl.setAlignment(Pos.CENTER);
        if(text.equals("Player") || text.equals("Rank")) lbl.setAlignment(Pos.CENTER_LEFT);
        lbl.setStyle("-fx-font-weight: bold; -fx-text-fill: #6b7280; -fx-font-size: 13px;");
        if (width == -1) {
            lbl.setMaxWidth(Double.MAX_VALUE);
            HBox.setHgrow(lbl, Priority.ALWAYS);
        } else {
            lbl.setPrefWidth(width);
        }
        return lbl;
    }

    private void loadTableRowsForCategory(String category) {
        tableRowsContainer.getChildren().addAll(
            buildTableRow("4", "Hardik Pandya", "All Rounder", "18", "512", "15", "2,050", "76.3", "/assests/images/hardik.jpg"),
            buildTableRow("5", "Ravindra Jadeja", "All Rounder", "16", "420", "21", "1,950", "75.2", "/assests/images/jadeja.jpg"),
            buildTableRow("6", "Jasprit Bumrah", "Bowler", "14", "120", "28", "1,880", "74.5", "/assests/images/bumrah.jpg"),
            buildTableRow("7", "KL Rahul", "Batsman", "17", "610", "0", "1,750", "72.1", "/assests/images/rahul.jpg"),
            buildTableRow("8", "Shubman Gill", "Batsman", "16", "580", "0", "1,680", "70.8", "/assests/images/gill.jpg"),
            buildTableRow("9", "Yuzvendra Chahal", "Bowler", "18", "80", "24", "1,640", "69.7", "/assests/images/chahal.jpg"),
            buildTableRow("10", "Mohammed Siraj", "Bowler", "15", "60", "20", "1,520", "68.2", "/assests/images/siraj.jpg")
        );
    }

    private HBox buildTableRow(String rank, String name, String role, String matches, String runs, String wickets, String points, String rating, String imagePath) {
        HBox row = new HBox(10);
        
        // --- ADDED: Store player name in row properties so Search Engine can find it ---
        row.getProperties().put("playerName", name);
        
        row.setPadding(new Insets(12, 20, 12, 20));
        row.setAlignment(Pos.CENTER_LEFT);
        row.setCursor(Cursor.HAND);
        row.setStyle("-fx-background-color: white; -fx-border-color: #f3f4f6; -fx-border-width: 0 0 1 0;");

        Label rankLbl = new Label(rank);
        rankLbl.setPrefWidth(60);
        rankLbl.setStyle("-fx-font-weight: bold; -fx-text-fill: #111827; -fx-font-size: 15px;");

        HBox playerBox = new HBox(15);
        playerBox.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(playerBox, Priority.ALWAYS); 
        playerBox.setAlignment(Pos.CENTER_LEFT);
        
        Node avatarNode = getPlayerAvatar(name, imagePath, 40, "#e2e8f0", "#475569");
        VBox nameDetails = new VBox(2);
        Label nameLbl = new Label(name);
        nameLbl.setStyle("-fx-font-weight: bold; -fx-text-fill: #111827; -fx-font-size: 14px;");
        Label roleLbl = new Label(role);
        roleLbl.setStyle("-fx-text-fill: #9ca3af; -fx-font-size: 12px;");
        nameDetails.getChildren().addAll(nameLbl, roleLbl);
        playerBox.getChildren().addAll(avatarNode, nameDetails);

        Label ptsLbl = new Label(points);
        ptsLbl.setPrefWidth(100);
        ptsLbl.setAlignment(Pos.CENTER);
        ptsLbl.setStyle("-fx-font-weight: bold; -fx-text-fill: #16a34a; -fx-font-size: 14px;");
        
        Label rtgLbl = new Label(rating);
        rtgLbl.setPrefWidth(80);
        rtgLbl.setAlignment(Pos.CENTER);
        rtgLbl.setStyle("-fx-font-weight: bold; -fx-text-fill: #16a34a; -fx-font-size: 14px;");

        row.getChildren().addAll(rankLbl, playerBox, createDataLabel(matches, 100), createDataLabel(runs, 100), createDataLabel(wickets, 100), ptsLbl, rtgLbl);
        
        row.setOnMouseClicked(e -> {
            viewContainer.getChildren().clear();
            viewContainer.getChildren().add(new LeaderboardPlayerProfile(mainLayout, name, imagePath, () -> showLeaderboardView("Overall")));
        });
        
        return row;
    }

    private Label createDataLabel(String text, double width) {
        Label lbl = new Label(text);
        lbl.setPrefWidth(width);
        lbl.setAlignment(Pos.CENTER);
        lbl.setStyle("-fx-text-fill: #4b5563; -fx-font-size: 14px;");
        return lbl;
    }

    private void showFullLeaderboardGrid() {
        viewContainer.getChildren().clear();

        Button backBtn = new Button("← Back to Leaderboard Home");
        backBtn.setCursor(Cursor.HAND);
        backBtn.setStyle("-fx-background-color: rgba(255,255,255,0.8); -fx-text-fill: #2563eb; -fx-font-weight: bold; -fx-font-size: 14px; -fx-padding: 8 15; -fx-background-radius: 8;");
        backBtn.setOnAction(e -> showLeaderboardView("Overall"));

        VBox headerTitleBox = new VBox(5);
        Label mainTitle = new Label("Full Player Leaderboard");
        mainTitle.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: white;");
        Label subTitle = new Label("Browse the complete ranking of all athletes in the league.");
        subTitle.setStyle("-fx-font-size: 14px; -fx-text-fill: #cbd5e1;");
        headerTitleBox.getChildren().addAll(mainTitle, subTitle);

        FlowPane grid = new FlowPane(25, 25);
        
        grid.getChildren().addAll(
            buildFullPlayerCard("1", "Virat Kohli", "Batsman", "3,125", "/assests/images/Virat.jpg"),
            buildFullPlayerCard("2", "Surya Kumar Yadav", "Batsman", "2,450", "/assests/images/surya.jpg"),
            buildFullPlayerCard("3", "Rohit Sharma", "Batsman", "2,210", "/assests/images/rohit.jpg"),
            buildFullPlayerCard("4", "Hardik Pandya", "All Rounder", "2,050", "/assests/images/hardik.jpg"),
            buildFullPlayerCard("5", "Ravindra Jadeja", "All Rounder", "1,950", "/assests/images/jadeja.jpg"),
            buildFullPlayerCard("6", "Jasprit Bumrah", "Bowler", "1,880", "/assests/images/bumrah.jpg"),
            buildFullPlayerCard("7", "KL Rahul", "Batsman", "1,750", "/assests/images/rahul.jpg"),
            buildFullPlayerCard("8", "Shubman Gill", "Batsman", "1,680", "/assests/images/gill.jpg"),
            buildFullPlayerCard("9", "Yuzvendra Chahal", "Bowler", "1,640", "/assests/images/chahal.jpg"),
            buildFullPlayerCard("10", "Mohammed Siraj", "Bowler", "1,520", "/assests/images/siraj.jpg")
        );

        VBox layout = new VBox(25, backBtn, headerTitleBox, grid);
        layout.setPadding(new Insets(25, 40, 25, 40));
        
        ScrollPane scrollPane = new ScrollPane(layout);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color: transparent; -fx-background-insets: 0; -fx-padding: 0;");
        scrollPane.getStylesheets().add("data:text/css,.scroll-pane > .viewport { -fx-background-color: transparent; }");

        viewContainer.getChildren().add(scrollPane);
    }

    private VBox buildFullPlayerCard(String rank, String name, String role, String points, String imgPath) {
        VBox card = new VBox();
        card.setPrefSize(220, 260); 
        card.setCursor(Cursor.HAND);
        Rectangle cardClip = new Rectangle(220, 260);
        cardClip.setArcWidth(24);
        cardClip.setArcHeight(24);
        card.setClip(cardClip);
        card.setStyle("-fx-background-color: white; -fx-background-radius: 12; -fx-border-color: #e5e7eb; -fx-border-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 12, 0, 0, 4);");

        StackPane topHalf = new StackPane();
        topHalf.setPrefSize(220, 150);
        topHalf.setStyle("-fx-background-color: #e2e8f0;");
        
        boolean imageLoaded = false;
        if (imgPath != null && !imgPath.isEmpty()) {
            try {
                String finalPath = null;
                java.net.URL res = getClass().getResource(imgPath);
                if (res != null) finalPath = res.toExternalForm();
                else {
                    java.io.File file = new java.io.File("src/main/resources" + imgPath);
                    if (file.exists()) finalPath = file.toURI().toString();
                }
                if (finalPath != null) {
                    Image img = new Image(finalPath, 220, 150, false, true);
                    if (!img.isError()) {
                        ImageView imgView = new ImageView(img);
                        imgView.setFitWidth(220);
                        imgView.setFitHeight(150);
                        topHalf.getChildren().add(imgView);
                        imageLoaded = true;
                    }
                }
            } catch (Exception e) {}
        }
        if (!imageLoaded) {
            Label initial = new Label(name.substring(0, 1).toUpperCase());
            initial.setStyle("-fx-font-size: 40px; -fx-font-weight: bold; -fx-text-fill: #475569;");
            topHalf.getChildren().add(initial);
        }

        Label rankBadge = new Label("#" + rank);
        rankBadge.setStyle("-fx-background-color: #16a34a; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 4 10; -fx-background-radius: 8;");
        StackPane.setAlignment(rankBadge, Pos.TOP_LEFT);
        StackPane.setMargin(rankBadge, new Insets(10));
        topHalf.getChildren().add(rankBadge);

        VBox bottomHalf = new VBox(5);
        bottomHalf.setPadding(new Insets(15));
        bottomHalf.setAlignment(Pos.CENTER);

        Label nameLbl = new Label(name);
        nameLbl.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: #111827;");
        Label roleLbl = new Label(role);
        roleLbl.setStyle("-fx-text-fill: #6b7280; -fx-font-size: 13px;");
        Label ptsLbl = new Label(points + " PTS");
        ptsLbl.setStyle("-fx-font-weight: bold; -fx-text-fill: #2563eb; -fx-font-size: 14px; -fx-padding: 5 0 0 0;");

        bottomHalf.getChildren().addAll(nameLbl, roleLbl, ptsLbl);
        card.getChildren().addAll(topHalf, bottomHalf);

        card.setOnMouseClicked(e -> {
            viewContainer.getChildren().clear();
            viewContainer.getChildren().add(new LeaderboardPlayerProfile(mainLayout, name, imgPath, () -> showFullLeaderboardGrid()));
        });

        return card;
    }

    private Node getPlayerAvatar(String name, String imgPath, double size, String fallbackBgColor, String fallbackTextColor) {
        StackPane container = new StackPane();
        container.setPrefSize(size, size);
        container.setMaxSize(size, size);
        boolean imageLoaded = false;
        
        if (imgPath != null && !imgPath.isEmpty()) {
            try {
                String finalPath = null;
                java.net.URL res = getClass().getResource(imgPath);
                if (res != null) finalPath = res.toExternalForm();
                else {
                    java.io.File file = new java.io.File("src/main/resources" + imgPath);
                    if (file.exists()) finalPath = file.toURI().toString();
                }
                if (finalPath != null) {
                    Image img = new Image(finalPath, size, size, false, true);
                    if (!img.isError()) {
                        ImageView imgView = new ImageView(img);
                        imgView.setFitWidth(size);
                        imgView.setFitHeight(size);
                        Circle clip = new Circle(size / 2, size / 2, size / 2);
                        imgView.setClip(clip);
                        container.getChildren().add(imgView);
                        imageLoaded = true;
                    }
                }
            } catch (Exception e) {}
        }
        if (!imageLoaded) {
            Label initial = new Label(name.substring(0, 1).toUpperCase());
            initial.setPrefSize(size, size);
            initial.setAlignment(Pos.CENTER);
            initial.setStyle("-fx-background-color: " + fallbackBgColor + "; -fx-text-fill: " + fallbackTextColor + "; -fx-background-radius: " + (size/2) + "; -fx-font-weight: bold; -fx-font-size: " + (size/2.5) + "px;");
            container.getChildren().add(initial);
        }
        return container;
    }
}