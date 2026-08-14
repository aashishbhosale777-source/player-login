package com.athlixcore.view.player.Leaderboard;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LeaderboardPlayerProfile extends ScrollPane {

    private BorderPane mainLayout;
    private String playerName;
    private String imgPath;
    private Runnable onBack;

    private HBox subTabs;
    private VBox dynamicContentArea;

    public LeaderboardPlayerProfile(BorderPane mainLayout, String playerName, String imgPath, Runnable onBack) {
        this.mainLayout = mainLayout;
        this.playerName = playerName;
        this.imgPath = imgPath;
        this.onBack = onBack;

        this.setFitToWidth(true);
        this.setStyle("-fx-background-color: linear-gradient(to bottom right, #f8fafc, #e2e8f0); -fx-background-insets: 0; -fx-padding: 0;");
        this.getStylesheets().add("data:text/css,.scroll-pane > .viewport { -fx-background-color: transparent; }");

        VBox pageLayout = new VBox();

        VBox headerArea = buildDarkHeader();

        dynamicContentArea = new VBox();
        dynamicContentArea.setPadding(new Insets(30, 40, 50, 40)); 
        dynamicContentArea.setAlignment(Pos.TOP_LEFT);

        pageLayout.getChildren().addAll(headerArea, dynamicContentArea);
        this.setContent(pageLayout);
        
        switchTab("Overview");
    }

    // =========================================================================
    // HEADER & TAB ENGINE (UPDATED BACKGROUND COLOR)
    // =========================================================================
    private VBox buildDarkHeader() {
        VBox headerContainer = new VBox();
        // Updated to the richer, deeper dark navy from your image
        headerContainer.setStyle("-fx-background-color: #1d1f1fb6;"); 
        headerContainer.setPadding(new Insets(20, 40, 0, 40));

        HBox topRow = new HBox();
        topRow.setAlignment(Pos.CENTER_LEFT);

        Button backBtn = new Button("←");
        backBtn.setCursor(Cursor.HAND);
        backBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 20px; -fx-padding: 0;");
        backBtn.setOnAction(e -> {
            if (onBack != null) onBack.run();
        });

        Region spacer1 = new Region();
        HBox.setHgrow(spacer1, Priority.ALWAYS);

        Button followBtn = new Button("Follow");
        followBtn.setCursor(Cursor.HAND);
        followBtn.setStyle("-fx-background-color: transparent; -fx-border-color: #475569; -fx-border-radius: 20; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 6 20; -fx-font-size: 13px;");
        
        topRow.getChildren().addAll(backBtn, spacer1, followBtn);

        HBox middleRow = new HBox();
        middleRow.setAlignment(Pos.BOTTOM_LEFT);
        middleRow.setPadding(new Insets(20, 0, 0, 0));

        String[] nameParts = playerName.split(" ", 2);
        String firstName = nameParts.length > 0 ? nameParts[0] : "";
        String lastName = nameParts.length > 1 ? nameParts[1].toUpperCase() : "";

        VBox nameBox = new VBox(5);
        Label lblFirst = new Label(firstName);
        lblFirst.setStyle("-fx-text-fill: #e2e8f0; -fx-font-size: 26px;");
        Label lblLast = new Label(lastName);
        lblLast.setStyle("-fx-text-fill: white; -fx-font-size: 32px; -fx-font-weight: bold;");
        
        Label lblSub = new Label("IN IND • 26 yrs");
        lblSub.setStyle("-fx-text-fill: #94a3b8; -fx-font-size: 13px; -fx-padding: 10 0 0 0;");
        
        nameBox.getChildren().addAll(lblFirst, lblLast, lblSub);

        Region spacer2 = new Region();
        HBox.setHgrow(spacer2, Priority.ALWAYS);

        Node avatar = getPlayerAvatar(playerName, imgPath, 130, "#334155", "white");
        middleRow.getChildren().addAll(nameBox, spacer2, avatar);

        subTabs = new HBox(30);
        subTabs.setPadding(new Insets(20, 0, 0, 0));
        subTabs.setStyle("-fx-border-color: #334155; -fx-border-width: 0 0 1 0;");
        
        subTabs.getChildren().addAll(
            createHeaderTab("Overview", true),
            createHeaderTab("Matches", false),
            createHeaderTab("News", false),
            createHeaderTab("Player Info", false)
        );

        headerContainer.getChildren().addAll(topRow, middleRow, subTabs);
        return headerContainer;
    }

    private Label createHeaderTab(String text, boolean active) {
        Label l = new Label(text);
        l.setCursor(Cursor.HAND);
        updateTabStyle(l, active);
        l.setOnMouseClicked(e -> switchTab(text));
        return l;
    }

    private void updateTabStyle(Label l, boolean active) {
        if (active) {
            l.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-border-color: #f87171; -fx-border-width: 0 0 3 0; -fx-padding: 10 5; -fx-font-size: 15px;");
        } else {
            l.setStyle("-fx-text-fill: #94a3b8; -fx-font-weight: bold; -fx-padding: 10 5; -fx-font-size: 15px; -fx-border-color: transparent; -fx-border-width: 0 0 3 0;");
        }
    }

    private void switchTab(String selectedTabName) {
        for (Node node : subTabs.getChildren()) {
            if (node instanceof Label) {
                Label lbl = (Label) node;
                updateTabStyle(lbl, lbl.getText().equals(selectedTabName));
            }
        }

        dynamicContentArea.getChildren().clear();
        switch (selectedTabName) {
            case "Overview":
                dynamicContentArea.getChildren().add(buildOverviewContent());
                break;
            case "Matches":
                dynamicContentArea.getChildren().add(buildMatchesContent());
                break;
            case "Player Info":
                dynamicContentArea.getChildren().add(buildPlayerInfoContent());
                break;
            default:
                dynamicContentArea.getChildren().add(buildPlaceholderContent(selectedTabName));
                break;
        }
    }

    // =========================================================================
    // OVERVIEW TAB
    // =========================================================================
    private HBox buildOverviewContent() {
        HBox mainSplit = new HBox(30);

        VBox leftCol = new VBox(30);
        HBox.setHgrow(leftCol, Priority.ALWAYS); 

        HBox badges = new HBox(10);
        badges.getChildren().addAll(
            createPillBadge("🏏 right handed Batter"),
            createPillBadge("#1 Batter in ODI"),
            createPillBadge("#7 Batter in Test")
        );

        VBox recentFormBox = new VBox(15);
        HBox rfHeader = new HBox();
        Label rfTitle = new Label("Recent Form ");
        rfTitle.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #1e293b;");
        Label rfSub = new Label("(last played on 07 Aug)");
        rfSub.setStyle("-fx-font-size: 14px; -fx-text-fill: #64748b;");
        rfHeader.getChildren().addAll(rfTitle, rfSub);

        HBox rfCards = new HBox(15);
        rfCards.getChildren().addAll(
            createFormCard("44 (54)", "vs SL-XI, Test"),
            createFormCard("77 (84)", "vs ENG, ODI"),
            createFormCard("31 (30)", "vs ENG, ODI"),
            createFormCard("8 (12)", "vs ENG, ODI")
        );
        recentFormBox.getChildren().addAll(rfHeader, rfCards);

        VBox careerBox = new VBox(15);
        Label cbTitle = new Label("Batting Career (right handed)");
        cbTitle.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #1e293b;");
        
        HBox careerButtons = new HBox(10);
        VBox dynamicStatsArea = new VBox(); 

        Button btnODI = createCareerBtn("ODI", false, careerButtons, dynamicStatsArea);
        Button btnT20 = createCareerBtn("T20I", false, careerButtons, dynamicStatsArea);
        Button btnTest = createCareerBtn("Test", true, careerButtons, dynamicStatsArea);
        Button btnIPL = createCareerBtn("IPL", false, careerButtons, dynamicStatsArea);

        careerButtons.getChildren().addAll(btnODI, btnT20, btnTest, btnIPL);
        careerBox.getChildren().addAll(cbTitle, careerButtons, dynamicStatsArea);

        updateBattingStatsDisplay("Test", dynamicStatsArea);

        leftCol.getChildren().addAll(badges, recentFormBox, careerBox);

        VBox rightCol = new VBox(25);
        rightCol.setPrefWidth(450);
        rightCol.setMinWidth(450);

        rightCol.getChildren().addAll(
            buildEnhancedRadarChart(),
            buildComparePlayersWidget()
        );

        mainSplit.getChildren().addAll(leftCol, rightCol);
        return mainSplit;
    }

    private Label createPillBadge(String text) {
        Label l = new Label(text);
        l.setStyle("-fx-background-color: white; -fx-border-color: #e2e8f0; -fx-border-radius: 20; -fx-background-radius: 20; -fx-padding: 8 18; -fx-text-fill: #334155; -fx-font-weight: bold; -fx-font-size: 13px; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.02), 5, 0, 0, 2);");
        return l;
    }

    private VBox createFormCard(String score, String match) {
        VBox box = new VBox(8);
        box.setAlignment(Pos.CENTER);
        box.setPrefHeight(110);
        HBox.setHgrow(box, Priority.ALWAYS); 
        box.setCursor(Cursor.HAND);
        box.setStyle("-fx-background-color: white; -fx-border-color: #e2e8f0; -fx-border-radius: 12; -fx-background-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.04), 8, 0, 0, 3);");
        
        Label lScore = new Label(score);
        lScore.setStyle("-fx-text-fill: #2563eb; -fx-font-weight: bold; -fx-font-size: 20px;");
        Label lMatch = new Label(match);
        lMatch.setStyle("-fx-text-fill: #64748b; -fx-font-size: 13px;");
        
        box.getChildren().addAll(lScore, lMatch);

        box.setOnMouseEntered(e -> box.setStyle("-fx-background-color: #f8fafc; -fx-border-color: #94a3b8; -fx-border-radius: 12; -fx-background-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.08), 12, 0, 0, 4);"));
        box.setOnMouseExited(e -> box.setStyle("-fx-background-color: white; -fx-border-color: #e2e8f0; -fx-border-radius: 12; -fx-background-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.04), 8, 0, 0, 3);"));
        box.setOnMouseClicked(e -> showRecentFormDetails(score, match));

        return box;
    }

    private void showRecentFormDetails(String score, String matchStr) {
        Stage modal = new Stage();
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.setTitle("Innings Breakdown");

        VBox root = new VBox(25);
        root.setPadding(new Insets(35));
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: white;");

        Label title = new Label(matchStr);
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #64748b;");

        String runs = score.contains(" ") ? score.split(" ")[0] : score;
        String balls = score.contains("(") ? score.substring(score.indexOf("(")) : "";

        Label runLabel = new Label(runs);
        runLabel.setStyle("-fx-font-size: 64px; -fx-font-weight: bold; -fx-text-fill: #1d4ed8;");
        Label ballsLabel = new Label(balls);
        ballsLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: #94a3b8;");

        HBox scoreBox = new HBox(10, runLabel, ballsLabel);
        scoreBox.setAlignment(Pos.BASELINE_CENTER);

        HBox boundaries = new HBox(30);
        boundaries.setAlignment(Pos.CENTER);
        boundaries.setPadding(new Insets(20));
        boundaries.setStyle("-fx-background-color: #f8fafc; -fx-background-radius: 12; -fx-border-color: #e2e8f0; -fx-border-radius: 12;");
        boundaries.getChildren().addAll(
            createModalStatBlock("Fours (4s)", "5"),
            createModalStatBlock("Sixes (6s)", "2"),
            createModalStatBlock("Strike Rate", "81.4")
        );

        Button closeBtn = new Button("Close");
        closeBtn.setCursor(Cursor.HAND);
        closeBtn.setStyle("-fx-background-color: #0f172a; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 10 40; -fx-font-size: 14px;");
        closeBtn.setOnAction(e -> modal.close());

        root.getChildren().addAll(title, scoreBox, boundaries, closeBtn);
        Scene scene = new Scene(root, 450, 400);
        modal.setScene(scene);
        modal.showAndWait();
    }

    private VBox createModalStatBlock(String label, String value) {
        VBox box = new VBox(5);
        box.setAlignment(Pos.CENTER);
        Label l = new Label(label);
        l.setStyle("-fx-font-size: 12px; -fx-text-fill: #64748b; -fx-font-weight: bold; -fx-text-transform: uppercase;");
        Label v = new Label(value);
        v.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
        box.getChildren().addAll(l, v);
        return box;
    }

    private Button createCareerBtn(String text, boolean active, HBox container, VBox statsArea) {
        Button b = new Button(text);
        updateCareerBtnStyle(b, active);
        b.setCursor(Cursor.HAND);
        
        b.setOnAction(e -> {
            for (Node n : container.getChildren()) {
                if (n instanceof Button) {
                    updateCareerBtnStyle((Button) n, false);
                }
            }
            updateCareerBtnStyle(b, true);
            updateBattingStatsDisplay(text, statsArea);
        });
        return b;
    }

    private void updateCareerBtnStyle(Button b, boolean active) {
        if (active) {
            b.setStyle("-fx-background-color: #1d4ed8; -fx-text-fill: white; -fx-font-weight: bold; -fx-border-radius: 8; -fx-background-radius: 8; -fx-padding: 10 25; -fx-font-size: 13px;");
        } else {
            b.setStyle("-fx-background-color: white; -fx-border-color: #e2e8f0; -fx-text-fill: #64748b; -fx-border-radius: 8; -fx-background-radius: 8; -fx-padding: 10 25; -fx-font-size: 13px;");
        }
    }

    private void updateBattingStatsDisplay(String format, VBox statsArea) {
        statsArea.getChildren().clear();

        String mat="0", runs="0", avg="0", sr="0", hs="0", hundreds="0";
        if (format.equals("Test")) { mat="113"; runs="8848"; avg="49.15"; sr="55.56"; hs="254*"; hundreds="29"; }
        else if (format.equals("ODI")) { mat="292"; runs="13848"; avg="58.67"; sr="93.62"; hs="183"; hundreds="50"; }
        else if (format.equals("T20I")) { mat="117"; runs="4008"; avg="52.73"; sr="137.96"; hs="122*"; hundreds="1"; }
        else if (format.equals("IPL")) { mat="237"; runs="7263"; avg="37.24"; sr="130.02"; hs="113"; hundreds="7"; }
        else if (format.equals("ODI WC")) { mat="37"; runs="1795"; avg="59.83"; sr="88.20"; hs="117"; hundreds="5"; }

        HBox row1 = new HBox(40);
        row1.getChildren().addAll(
            buildStatGridBlock("Matches", mat),
            buildStatGridBlock("Runs", runs),
            buildStatGridBlock("Average", avg)
        );

        HBox row2 = new HBox(40);
        row2.getChildren().addAll(
            buildStatGridBlock("Strike Rate", sr),
            buildStatGridBlock("Highest", hs),
            buildStatGridBlock("Centuries", hundreds)
        );

        VBox grid = new VBox(25, row1, row2);
        grid.setPadding(new Insets(25));
        grid.setStyle("-fx-background-color: white; -fx-background-radius: 12; -fx-border-color: #e2e8f0; -fx-border-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 8, 0, 0, 2);");

        statsArea.getChildren().add(grid);
    }

    private VBox buildStatGridBlock(String label, String value) {
        VBox box = new VBox(5);
        box.setAlignment(Pos.CENTER_LEFT);
        box.setPrefWidth(120); 
        Label l = new Label(label);
        l.setStyle("-fx-font-size: 13px; -fx-text-fill: #94a3b8; -fx-font-weight: bold; -fx-text-transform: uppercase;");
        Label v = new Label(value);
        v.setStyle("-fx-font-size: 26px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
        box.getChildren().addAll(l, v);
        return box;
    }


    // =========================================================================
    // MATCHES TAB (INTERACTIVE FILTER BUTTONS)
    // =========================================================================
    private VBox buildMatchesContent() {
        VBox layout = new VBox(15);
        layout.setMaxWidth(Double.MAX_VALUE); 

        // 1. FILTER BAR WITH SEARCH FIELD
        HBox filterBox = new HBox(10);
        filterBox.setAlignment(Pos.CENTER_LEFT);
        filterBox.setPadding(new Insets(0, 0, 15, 0));

        // Create the buttons and pass the container so they can update each other
        Button btnAll = createMatchesFilterBtn("All", true, filterBox);
        Button btnODI = createMatchesFilterBtn("ODI", false, filterBox);
        Button btnT20I = createMatchesFilterBtn("T20I", false, filterBox);
        Button btnTest = createMatchesFilterBtn("TEST", false, filterBox);
        Button btnIPL = createMatchesFilterBtn("IPL", false, filterBox);

        filterBox.getChildren().addAll(btnAll, btnODI, btnT20I, btnTest, btnIPL);
        
        Region fSp = new Region(); 
        HBox.setHgrow(fSp, Priority.ALWAYS);
        
        TextField searchField = new TextField();
        searchField.setPromptText("Search matches...");
        searchField.setPrefWidth(250);
        searchField.setStyle("-fx-background-color: white; -fx-border-color: #cbd5e1; -fx-border-radius: 20; -fx-background-radius: 20; -fx-padding: 8 15 8 35; -fx-font-size: 13px;");
        
        Label searchIcon = new Label("🔍");
        searchIcon.setStyle("-fx-text-fill: #94a3b8; -fx-font-size: 14px;");
        
        StackPane searchPane = new StackPane(searchField, searchIcon);
        StackPane.setAlignment(searchIcon, Pos.CENTER_LEFT);
        StackPane.setMargin(searchIcon, new Insets(0, 0, 0, 12));

        filterBox.getChildren().addAll(fSp, searchPane);

        // 2. MATCH SERIES ACCORDIONS
        VBox matchesList = new VBox(0); 
        matchesList.setStyle("-fx-background-color: white; -fx-border-color: #f1f5f9; -fx-border-radius: 12; -fx-background-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 8, 0, 0, 2);");
        
        matchesList.getChildren().addAll(
            buildInteractiveSeriesCard("IND vs AFG -2026", "06 Jun - 20 Jun • Played for IND", true),
            buildInteractiveSeriesCard("IPL 2026", "28 Mar - 31 May • Played for RR", false),
            buildInteractiveSeriesCard("Ranji Elite 2025-26", "15 Oct - 28 Feb • Played for MUM", false),
            buildInteractiveSeriesCard("SA vs IND 2025", "14 Nov - 19 Dec • Played for IND", false)
        );

        layout.getChildren().addAll(filterBox, matchesList);
        return layout;
    }

    private Button createMatchesFilterBtn(String text, boolean active, HBox container) {
        Button b = new Button(text);
        updateMatchesFilterBtnStyle(b, active);
        b.setCursor(Cursor.HAND);

        // Functionality: Click to activate this button and deactivate others
        b.setOnAction(e -> {
            for (Node n : container.getChildren()) {
                if (n instanceof Button) {
                    updateMatchesFilterBtnStyle((Button) n, false);
                }
            }
            updateMatchesFilterBtnStyle(b, true);
        });

        return b;
    }

    private void updateMatchesFilterBtnStyle(Button b, boolean active) {
        if (active) {
            // Pill shape, deep blue
            b.setStyle("-fx-background-color: #1e3a8a; -fx-text-fill: white; -fx-font-weight: bold; -fx-border-radius: 25; -fx-background-radius: 25; -fx-padding: 8 25; -fx-font-size: 13px;");
        } else {
            // Pill shape, white with gray border
            b.setStyle("-fx-background-color: white; -fx-border-color: #e2e8f0; -fx-text-fill: #94a3b8; -fx-border-radius: 25; -fx-background-radius: 25; -fx-padding: 8 25; -fx-font-size: 13px;");
        }
    }

    private VBox buildInteractiveSeriesCard(String title, String sub, boolean initiallyExpanded) {
        VBox card = new VBox();
        card.setStyle("-fx-border-color: #f1f5f9; -fx-border-width: 0 0 1 0;");

        // The Clickable Header
        HBox header = new HBox(15);
        header.setAlignment(Pos.CENTER_LEFT);
        header.setPadding(new Insets(20));
        header.setCursor(Cursor.HAND);

        Label icon = new Label("🏆");
        icon.setPrefSize(40, 40);
        icon.setAlignment(Pos.CENTER);
        icon.setStyle("-fx-background-color: #f8fafc; -fx-background-radius: 8; -fx-font-size: 20px;");

        VBox titleBox = new VBox(4);
        Label lTitle = new Label(title);
        lTitle.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: #1e40af;");
        Label lSub = new Label(sub);
        lSub.setStyle("-fx-text-fill: #64748b; -fx-font-size: 13px;");
        titleBox.getChildren().addAll(lTitle, lSub);

        Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);
        
        Label chevron = new Label(initiallyExpanded ? "▲" : "▼");
        chevron.setStyle("-fx-text-fill: #94a3b8; -fx-font-size: 16px; -fx-font-weight: bold;");

        header.getChildren().addAll(icon, titleBox, sp, chevron);

        // The Dropdown Details Area
        VBox details = new VBox(20);
        details.setPadding(new Insets(0, 20, 20, 20)); 
        details.setVisible(initiallyExpanded);
        details.setManaged(initiallyExpanded);

        // Populate beautiful format groups
        if (title.contains("IND vs AFG")) {
            details.getChildren().addAll(
                buildFormatGroup("ODI", "114", "2", "120.00", "114.00", new String[][]{
                    {"110 (86)*", "20 Jun", "3rd ODI vs AFG"},
                    {"4 (9)", "17 Jun", "2nd ODI vs AFG"}
                }),
                buildFormatGroup("TEST", "24", "1", "75.00", "24.00", new String[][]{
                    {"24 (32)", "06 Jun", "Only Test, 1st Inn"}
                })
            );
        } else if (title.contains("IPL")) {
             details.getChildren().addAll(
                buildFormatGroup("T20", "410", "14", "165.40", "41.00", new String[][]{
                    {"85 (42)", "31 May", "Final Match vs CSK"},
                    {"22 (15)", "28 May", "Qualifier 2 vs MI"}
                })
            );
        } else {
             details.getChildren().add(new Label("Detailed stats will appear here."));
        }

        // Toggle Animation Logic
        header.setOnMouseClicked(e -> {
            boolean isVis = details.isVisible();
            details.setVisible(!isVis);
            details.setManaged(!isVis);
            chevron.setText(isVis ? "▼" : "▲");
        });

        card.getChildren().addAll(header, details);
        return card;
    }

    private HBox buildFormatGroup(String format, String runs, String inns, String sr, String avg, String[][] innings) {
        HBox row = new HBox(0); 

        Label lblFormat = new Label(format);
        lblFormat.setStyle("-fx-text-fill: #94a3b8; -fx-font-size: 11px; -fx-font-weight: bold; -fx-letter-spacing: 1px;");
        lblFormat.setRotate(-90);
        javafx.scene.Group group = new javafx.scene.Group(lblFormat);
        StackPane badgePane = new StackPane(group);
        badgePane.setPrefWidth(35);
        badgePane.setStyle("-fx-background-color: #f8fafc; -fx-border-color: #e2e8f0; -fx-border-width: 1 0 1 1; -fx-border-radius: 12 0 0 12;");

        VBox statsContainer = new VBox(15);
        statsContainer.setPadding(new Insets(20));
        HBox.setHgrow(statsContainer, Priority.ALWAYS);
        statsContainer.setStyle("-fx-background-color: #f8fafc; -fx-border-color: #e2e8f0; -fx-border-width: 1 1 1 0; -fx-border-radius: 0 12 12 0;");

        HBox aggRow = new HBox(0);
        aggRow.setAlignment(Pos.CENTER);
        aggRow.getChildren().addAll(
            createMatchStat(runs, "runs", true),
            createMatchStat(inns, "Inns", true),
            createMatchStat(sr, "Strike Rate", true),
            createMatchStat(avg, "Average", false)
        );

        HBox th = new HBox();
        th.setPadding(new Insets(10, 0, 0, 0));
        th.setStyle("-fx-border-color: #e2e8f0; -fx-border-width: 0 0 1 0; -fx-padding: 0 0 10 0;");
        Label lScoreH = new Label("Score"); lScoreH.setPrefWidth(120); lScoreH.setStyle("-fx-text-fill:#94a3b8; -fx-font-size:12px;");
        Label lDateH = new Label("Date"); lDateH.setPrefWidth(100); lDateH.setStyle("-fx-text-fill:#94a3b8; -fx-font-size:12px;");
        Label lMatchH = new Label("Match"); lMatchH.setAlignment(Pos.CENTER_RIGHT); lMatchH.setStyle("-fx-text-fill:#94a3b8; -fx-font-size:12px;");
        Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);
        th.getChildren().addAll(lScoreH, lDateH, sp, lMatchH);

        statsContainer.getChildren().addAll(aggRow, th);

        for(String[] inn : innings) {
            HBox tr = new HBox();
            tr.setPadding(new Insets(8, 0, 5, 0));
            Label lScore = new Label(inn[0]); lScore.setPrefWidth(120); lScore.setStyle("-fx-font-weight:bold; -fx-font-size:14px; -fx-text-fill:#1e293b;");
            Label lDate = new Label(inn[1]); lDate.setPrefWidth(100); lDate.setStyle("-fx-text-fill:#64748b; -fx-font-size:13px;");
            Label lMatchInfo = new Label(inn[2]); lMatchInfo.setAlignment(Pos.CENTER_RIGHT); lMatchInfo.setStyle("-fx-text-fill:#2563eb; -fx-font-size:13px;");
            Region rsp = new Region(); HBox.setHgrow(rsp, Priority.ALWAYS);
            tr.getChildren().addAll(lScore, lDate, rsp, lMatchInfo);
            statsContainer.getChildren().add(tr);
        }

        row.getChildren().addAll(badgePane, statsContainer);
        return row;
    }

    private VBox createMatchStat(String val, String title, boolean showDivider) {
        VBox b = new VBox(2);
        b.setAlignment(Pos.CENTER);
        b.setPrefWidth(120);
        if (showDivider) {
            b.setStyle("-fx-border-color: #e2e8f0; -fx-border-width: 0 1 0 0;");
        }
        Label v = new Label(val);
        v.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: #1e293b;");
        Label t = new Label(title);
        t.setStyle("-fx-font-size: 12px; -fx-text-fill: #94a3b8;");
        b.getChildren().addAll(v, t);
        return b;
    }

    // =========================================================================
    // PLAYER INFO TAB
    // =========================================================================
    private VBox buildPlayerInfoContent() {
        VBox layout = new VBox(30);
        layout.setMaxWidth(Double.MAX_VALUE); 

        VBox personalCard = new VBox(0);
        personalCard.setStyle("-fx-background-color: white; -fx-background-radius: 12; -fx-border-color: #e5e7eb; -fx-border-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.04), 10, 0, 0, 2);");
        
        Label pTitle = new Label("Personal Information");
        pTitle.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: white; -fx-background-color: #1e293b; -fx-padding: 15 20; -fx-background-radius: 12 12 0 0;");
        pTitle.setMaxWidth(Double.MAX_VALUE);

        VBox pContent = new VBox(5);
        pContent.setPadding(new Insets(20));
        pContent.getChildren().addAll(
            createInfoRow("Full Name:", playerName),
            createInfoRow("Born:", "05 Nov 1988 (35 years) • Delhi, India"),
            createInfoRow("Height:", "5ft 9in (1.75m)"),
            createInfoRow("Nationality:", "Indian")
        );
        personalCard.getChildren().addAll(pTitle, pContent);

        VBox roleCard = new VBox(0);
        roleCard.setStyle("-fx-background-color: white; -fx-background-radius: 12; -fx-border-color: #e5e7eb; -fx-border-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.04), 10, 0, 0, 2);");
        
        Label rTitle = new Label("Playing Role & Style");
        rTitle.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: white; -fx-background-color: #2563eb; -fx-padding: 15 20; -fx-background-radius: 12 12 0 0;");
        rTitle.setMaxWidth(Double.MAX_VALUE);

        VBox rContent = new VBox(5);
        rContent.setPadding(new Insets(20));
        rContent.getChildren().addAll(
            createInfoRow("Role:", "Top-order Batter"),
            createInfoRow("Batting Style:", "Right-hand Bat"),
            createInfoRow("Bowling Style:", "Right-arm Medium"),
            createInfoRow("Signature Shot:", "Cover Drive / Flick")
        );
        roleCard.getChildren().addAll(rTitle, rContent);

        HBox splitCards = new HBox(30);
        HBox.setHgrow(personalCard, Priority.ALWAYS);
        HBox.setHgrow(roleCard, Priority.ALWAYS);
        splitCards.getChildren().addAll(personalCard, roleCard);

        VBox bioCard = new VBox(15);
        bioCard.setPadding(new Insets(25));
        bioCard.setStyle("-fx-background-color: white; -fx-background-radius: 12; -fx-border-color: #e5e7eb; -fx-border-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.04), 10, 0, 0, 2);");
        
        Label bTitle = new Label("Biography");
        bTitle.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #1e293b;");
        
        Label bText = new Label("A modern-day master, " + playerName + " is widely regarded as one of the greatest batsmen in the history of the sport. Known for his incredible consistency, unmatched run-chasing ability, and aggressive leadership, he has broken numerous records across all formats. His journey from a talented U19 prodigy to a global sporting icon is a testament to his sheer dedication, fitness, and passion for the game.");
        bText.setWrapText(true);
        bText.setStyle("-fx-font-size: 15px; -fx-text-fill: #475569; -fx-line-spacing: 6px;");

        bioCard.getChildren().addAll(bTitle, bText);

        layout.getChildren().addAll(splitCards, bioCard);
        return layout;
    }

    private HBox createInfoRow(String key, String value) {
        HBox row = new HBox();
        row.setPadding(new Insets(12, 0, 12, 0));
        row.setStyle("-fx-border-color: #f1f5f9; -fx-border-width: 0 0 1 0;");

        Label lKey = new Label(key);
        lKey.setPrefWidth(120);
        lKey.setStyle("-fx-text-fill: #64748b; -fx-font-size: 15px;");

        Label lVal = new Label(value);
        lVal.setStyle("-fx-text-fill: #1e293b; -fx-font-size: 15px; -fx-font-weight: bold;");

        row.getChildren().addAll(lKey, lVal);
        return row;
    }

    // =========================================================================
    // RIGHT COLUMN WIDGETS & UTILS
    // =========================================================================
    private VBox buildEnhancedRadarChart() {
        VBox widget = new VBox(20);
        widget.setPadding(new Insets(25));
        widget.setStyle("-fx-background-color: white; -fx-background-radius: 12; -fx-border-color: #e5e7eb; -fx-border-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 8, 0, 0, 2);");

        Label title = new Label("Performance Radar");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #0f172a;");

        Pane chartPane = new Pane();
        chartPane.setPrefSize(400, 260); 
        chartPane.setMinSize(400, 260);

        double centerX = 200.0;
        double centerY = 130.0;
        double maxRadius = 90.0;

        chartPane.getChildren().add(createDashedPentagon(centerX, centerY, maxRadius));       
        chartPane.getChildren().add(createDashedPentagon(centerX, centerY, maxRadius * 0.66)); 
        chartPane.getChildren().add(createDashedPentagon(centerX, centerY, maxRadius * 0.33)); 

        Polygon dataWeb = new Polygon();
        dataWeb.getPoints().addAll(new Double[]{
            centerX, centerY - (maxRadius * 0.89),                                  
            centerX + (maxRadius * 0.45 * 0.951), centerY - (maxRadius * 0.45 * 0.309), 
            centerX + (maxRadius * 0.78 * 0.587), centerY + (maxRadius * 0.78 * 0.809), 
            centerX - (maxRadius * 0.88 * 0.587), centerY + (maxRadius * 0.88 * 0.809), 
            centerX - (maxRadius * 0.90 * 0.951), centerY - (maxRadius * 0.90 * 0.309)  
        });
        
        dataWeb.setStyle("-fx-fill: rgba(37, 99, 235, 0.25); -fx-stroke: #2563eb; -fx-stroke-width: 3; -fx-stroke-line-join: round;");
        chartPane.getChildren().add(dataWeb);

        chartPane.getChildren().addAll(
            createChartLabel("Batting\n89", centerX - 20, centerY - maxRadius - 35, Pos.CENTER),
            createChartLabel("Bowling\n45", centerX + maxRadius + 15, centerY - 20, Pos.CENTER_LEFT),
            createChartLabel("Fielding\n78", centerX + maxRadius * 0.587 + 15, centerY + maxRadius * 0.809, Pos.CENTER_LEFT),
            createChartLabel("Consistency\n88", centerX - maxRadius * 0.587 - 75, centerY + maxRadius * 0.809, Pos.CENTER_RIGHT),
            createChartLabel("Impact\n90", centerX - maxRadius - 50, centerY - 20, Pos.CENTER_RIGHT)
        );

        widget.getChildren().addAll(title, chartPane);
        return widget;
    }

    private Polygon createDashedPentagon(double cx, double cy, double r) {
        Polygon p = new Polygon();
        p.getPoints().addAll(new Double[]{
            cx, cy - r,                            
            cx + (r * 0.951), cy - (r * 0.309),    
            cx + (r * 0.587), cy + (r * 0.809),    
            cx - (r * 0.587), cy + (r * 0.809),    
            cx - (r * 0.951), cy - (r * 0.309)     
        });
        p.setStyle("-fx-fill: transparent; -fx-stroke: #cbd5e1; -fx-stroke-width: 1.5; -fx-stroke-dash-array: 6 6;");
        return p;
    }

    private Label createChartLabel(String text, double x, double y, Pos alignment) {
        Label l = new Label(text);
        l.setStyle("-fx-font-size: 11px; -fx-font-weight: bold; -fx-text-fill: #1e293b; -fx-text-alignment: center;");
        l.setLayoutX(x);
        l.setLayoutY(y);
        l.setAlignment(alignment);
        return l;
    }

    private VBox buildComparePlayersWidget() {
        VBox widget = new VBox(15);
        widget.setPadding(new Insets(20));
        widget.setStyle("-fx-background-color: white; -fx-background-radius: 12; -fx-border-color: #e5e7eb; -fx-border-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 8, 0, 0, 2);");

        Label title = new Label("Compare Players");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #0f172a;");

        ComboBox<String> select = new ComboBox<>();
        select.getItems().addAll("Rohit Sharma", "Surya Kumar Yadav", "Hardik Pandya", "Jasprit Bumrah");
        select.setPromptText("Select Player...");
        select.setStyle("-fx-background-color: white; -fx-border-color: #cbd5e1; -fx-border-radius: 6; -fx-padding: 4; -fx-font-size: 14px;");
        select.setMaxWidth(Double.MAX_VALUE);
        select.setCursor(Cursor.HAND);

        Button cmpBtn = new Button("Compare Head-to-Head");
        cmpBtn.setMaxWidth(Double.MAX_VALUE);
        cmpBtn.setCursor(Cursor.HAND);
        cmpBtn.setStyle("-fx-background-color: #0f172a; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 6; -fx-padding: 12; -fx-font-size: 14px;");

        cmpBtn.setOnAction(e -> {
            String selected = select.getValue();
            if (selected != null) {
                showHeadToHeadComparison(playerName, selected);
            }
        });

        widget.getChildren().addAll(title, select, cmpBtn);
        return widget;
    }

    private void showHeadToHeadComparison(String player1, String player2) {
        Stage modal = new Stage();
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.setTitle("Head-to-Head Comparison");

        VBox root = new VBox(30);
        root.setPadding(new Insets(40, 50, 40, 50));
        root.setAlignment(Pos.TOP_CENTER);
        root.setStyle("-fx-background-color: linear-gradient(to bottom right, #0f172a, #1e293b);");

        Label title = new Label("HEAD-TO-HEAD ANALYSIS");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white; -fx-letter-spacing: 2px;");

        HBox playersBox = new HBox(40);
        playersBox.setAlignment(Pos.CENTER);

        VBox p1Box = new VBox(10);
        p1Box.setAlignment(Pos.CENTER);
        String p1ImageStr = "/assests/images/" + player1.split(" ")[0].toLowerCase() + ".jpg";
        Node p1Avatar = getPlayerAvatar(player1, p1ImageStr, 100, "#3b82f6", "white");
        Label p1Name = new Label(player1);
        p1Name.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: white;");
        p1Box.getChildren().addAll(p1Avatar, p1Name);

        Label vsBadge = new Label("VS");
        vsBadge.setPrefSize(50, 50);
        vsBadge.setAlignment(Pos.CENTER);
        vsBadge.setStyle("-fx-background-color: #ef4444; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 18px; -fx-background-radius: 25; -fx-effect: dropshadow(three-pass-box, rgba(239,68,68,0.5), 15, 0, 0, 0);");

        VBox p2Box = new VBox(10);
        p2Box.setAlignment(Pos.CENTER);
        String p2ImageStr = "/assests/images/" + player2.split(" ")[0].toLowerCase() + ".jpg";
        Node p2Avatar = getPlayerAvatar(player2, p2ImageStr, 100, "#10b981", "white");
        Label p2Name = new Label(player2);
        p2Name.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: white;");
        p2Box.getChildren().addAll(p2Avatar, p2Name);

        playersBox.getChildren().addAll(p1Box, vsBadge, p2Box);

        VBox statsBox = new VBox(15);
        statsBox.setPadding(new Insets(30));
        statsBox.setStyle("-fx-background-color: rgba(255,255,255,0.05); -fx-background-radius: 16; -fx-border-color: rgba(255,255,255,0.1); -fx-border-radius: 16;");

        statsBox.getChildren().addAll(
            buildStatRow("Matches Played", "128", "112", true),
            buildStatRow("Total Runs", "6,523", "4,120", true),
            buildStatRow("Batting Average", "58.4", "45.2", true),
            buildStatRow("Strike Rate", "138.2", "142.5", false),
            buildStatRow("Wickets", "4", "86", false)
        );

        Button closeBtn = new Button("Close Comparison");
        closeBtn.setStyle("-fx-background-color: transparent; -fx-border-color: #64748b; -fx-border-radius: 8; -fx-text-fill: #cbd5e1; -fx-font-weight: bold; -fx-padding: 10 40; -fx-font-size: 14px;");
        closeBtn.setCursor(Cursor.HAND);
        closeBtn.setOnAction(e -> modal.close());

        root.getChildren().addAll(title, playersBox, statsBox, closeBtn);
        
        Scene scene = new Scene(root, 600, 650);
        modal.setScene(scene);
        modal.showAndWait();
    }

    private HBox buildStatRow(String statName, String val1, String val2, boolean p1Wins) {
        HBox row = new HBox();
        row.setAlignment(Pos.CENTER);
        
        Label lVal1 = new Label(val1);
        lVal1.setPrefWidth(120);
        lVal1.setAlignment(Pos.CENTER);
        lVal1.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: " + (p1Wins ? "#22c55e" : "white") + ";");

        Label lStat = new Label(statName);
        lStat.setPrefWidth(160);
        lStat.setAlignment(Pos.CENTER);
        lStat.setStyle("-fx-font-size: 13px; -fx-text-fill: #94a3b8; -fx-font-weight: bold; -fx-text-transform: uppercase;");

        Label lVal2 = new Label(val2);
        lVal2.setPrefWidth(120);
        lVal2.setAlignment(Pos.CENTER);
        lVal2.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: " + (!p1Wins ? "#22c55e" : "white") + ";");

        row.getChildren().addAll(lVal1, lStat, lVal2);
        return row;
    }

    private VBox buildPlaceholderContent(String tabName) {
        VBox widget = new VBox(15);
        widget.setPadding(new Insets(50));
        widget.setAlignment(Pos.CENTER);

        Label title = new Label(tabName + " Updates");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 20px; -fx-text-fill: #1e293b;");
        Label sub = new Label("Data for this section is currently being compiled.");
        sub.setStyle("-fx-text-fill: #64748b; -fx-font-size: 14px;");

        widget.getChildren().addAll(title, sub);
        return widget;
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