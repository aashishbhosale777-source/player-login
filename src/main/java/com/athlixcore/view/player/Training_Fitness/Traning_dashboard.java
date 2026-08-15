package com.athlixcore.view.player.Training_Fitness;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Traning_dashboard {

    private BorderPane rootContainer;
    private StackPane contentArea;
    private Button trainingTabBtn;
    private Button fitnessTabBtn;

    public Node getView() {
        if (rootContainer == null) {
            rootContainer = new BorderPane();
            rootContainer.setStyle("-fx-background-color: #f8fafc;");

            // Create the fixed Top Bar (Search + Training/Fitness Toggle + Profile)
            Node topBar = buildTopBar();
            rootContainer.setTop(topBar);

            // Create the dynamic Content Area for switching between Training & Fitness
            contentArea = new StackPane();
            rootContainer.setCenter(contentArea);

            // Load Training by default
            loadTrainingView();
        }
        return rootContainer;
    }

    // --- ANIMATION HELPERS ---
    private void animateNodeEntrance(Node node, int delayMillis) {
        node.setOpacity(0);
        node.setTranslateY(25);

        FadeTransition ft = new FadeTransition(Duration.millis(600), node);
        ft.setToValue(1.0);

        TranslateTransition tt = new TranslateTransition(Duration.millis(600), node);
        tt.setToY(0);

        ParallelTransition pt = new ParallelTransition(ft, tt);
        pt.setDelay(Duration.millis(delayMillis));
        pt.play();
    }

    private void addHoverScale(Node node) {
        ScaleTransition scaleIn = new ScaleTransition(Duration.millis(150), node);
        scaleIn.setToX(1.03); 
        scaleIn.setToY(1.03);
        
        ScaleTransition scaleOut = new ScaleTransition(Duration.millis(150), node);
        scaleOut.setToX(1.0); 
        scaleOut.setToY(1.0);

        node.setOnMouseEntered(e -> scaleIn.playFromStart());
        node.setOnMouseExited(e -> scaleOut.playFromStart());
    }

    // --- MAIN TOP BAR WITH TRAINING / FITNESS TOGGLE ---
    private HBox buildTopBar() {
        HBox topBar = new HBox(25);
        topBar.setAlignment(Pos.CENTER_LEFT);
        topBar.setPadding(new Insets(20, 40, 10, 40));
        topBar.setStyle("-fx-background-color: #f8fafc;");

        // Search Bar
        HBox searchBox = new HBox(10);
        searchBox.setAlignment(Pos.CENTER_LEFT);
        searchBox.setStyle("-fx-background-color: white; -fx-background-radius: 25; -fx-padding: 10 20; -fx-border-color: #e2e8f0; -fx-border-radius: 25;");
        
        Label searchIcon = new Label("🔍");
        searchIcon.setStyle("-fx-text-fill: #94a3b8;");
        
        TextField searchField = new TextField();
        searchField.setPromptText("Search training modules, coaches, or stats...");
        searchField.setStyle("-fx-background-color: transparent; -fx-border-width: 0; -fx-pref-width: 320px; -fx-prompt-text-fill: #94a3b8; -fx-font-size: 14px;");
        searchBox.getChildren().addAll(searchIcon, searchField);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        // --- TRAINING & FITNESS TOGGLE BUTTONS ---
        HBox toggleContainer = new HBox(5);
        toggleContainer.setAlignment(Pos.CENTER);
        toggleContainer.setStyle("-fx-background-color: #e2e8f0; -fx-background-radius: 25; -fx-padding: 4;");

        trainingTabBtn = new Button("Training");
        fitnessTabBtn = new Button("Fitness");

        styleMainToggleButton(trainingTabBtn, true);
        styleMainToggleButton(fitnessTabBtn, false);

        trainingTabBtn.setOnAction(e -> {
            styleMainToggleButton(trainingTabBtn, true);
            styleMainToggleButton(fitnessTabBtn, false);
            loadTrainingView();
        });

        fitnessTabBtn.setOnAction(e -> {
            styleMainToggleButton(fitnessTabBtn, true);
            styleMainToggleButton(trainingTabBtn, false);
            loadFitnessView();
        });

        toggleContainer.getChildren().addAll(trainingTabBtn, fitnessTabBtn);

        // Avatar (FIXED: USING LOCAL IMAGE FOR INSTANT LOAD)
        Circle avatar = new Circle(20);
        try { 
            avatar.setFill(new javafx.scene.paint.ImagePattern(new Image("file:src/main/resources/assests/images/Virat.jpg", false))); 
        } catch (Exception e) { 
            avatar.setFill(Color.GRAY); 
        }
        addHoverScale(avatar);

        HBox rightControls = new HBox(18);
        rightControls.setAlignment(Pos.CENTER);
        rightControls.getChildren().addAll(toggleContainer);

        topBar.getChildren().addAll(spacer, rightControls);
        return topBar;
    }

    private void styleMainToggleButton(Button btn, boolean isActive) {
        if (isActive) {
            btn.setStyle("-fx-background-color: white; -fx-text-fill: #10b981; -fx-font-weight: bold; -fx-font-size: 14px; -fx-padding: 8 30; -fx-background-radius: 20; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 5, 0, 0, 2); -fx-cursor: hand;");
        } else {
            btn.setStyle("-fx-background-color: transparent; -fx-text-fill: #475569; -fx-font-weight: bold; -fx-font-size: 14px; -fx-padding: 8 30; -fx-background-radius: 20; -fx-cursor: hand;");
        }
    }

    // --- VIEW LOADERS ---
    private void loadTrainingView() {
        VBox layout = new VBox(25);
        layout.setPadding(new Insets(20, 40, 40, 40));

        Node heroBanner = buildHeroBanner();
        Node statsRow = buildStatsRow();
        Node splitArea = buildMainSplitArea();

        layout.getChildren().addAll(heroBanner, statsRow, splitArea);

        animateNodeEntrance(heroBanner, 50);
        animateNodeEntrance(statsRow, 150);
        animateNodeEntrance(splitArea, 250);

        ScrollPane scrollPane = new ScrollPane(layout);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color: transparent; -fx-background: #f8fafc;");
        scrollPane.getStylesheets().add("data:text/css,.scroll-pane > .viewport { -fx-background-color: transparent; }");

        contentArea.getChildren().setAll(scrollPane);

        contentArea.setOpacity(0);
        FadeTransition ft = new FadeTransition(Duration.millis(400), contentArea);
        ft.setToValue(1.0);
        ft.play();
    }

    private void loadFitnessView() {
        Fitness_Dashboard fitnessPage = new Fitness_Dashboard();
        contentArea.getChildren().setAll(fitnessPage.getView());
        contentArea.setOpacity(0);
        FadeTransition ft = new FadeTransition(Duration.millis(400), contentArea);
        ft.setToValue(1.0);
        ft.play();
    }

    // --- HERO BANNER ---
    private StackPane buildHeroBanner() {
        StackPane bannerPane = new StackPane();
        bannerPane.setMinHeight(220);
        bannerPane.setStyle("-fx-background-radius: 20; -fx-border-radius: 20; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.15), 20, 0, 0, 5);");

        Region bg = new Region();
        bg.setStyle("-fx-background-color: linear-gradient(to right, #1e293b, #0f172a); -fx-background-radius: 20;");
        
        HBox contentLayout = new HBox(30);
        contentLayout.setAlignment(Pos.CENTER_LEFT);
        contentLayout.setPadding(new Insets(30, 40, 30, 40));

        // Avatar (FIXED: USING LOCAL IMAGE FOR INSTANT LOAD)
        StackPane avatarRing = new StackPane();
        Circle outerRing = new Circle(65, Color.TRANSPARENT);
        outerRing.setStroke(Color.web("#10b981"));
        outerRing.setStrokeWidth(3);
        Circle innerAvatar = new Circle(55);
        try { 
            innerAvatar.setFill(new javafx.scene.paint.ImagePattern(new Image("file:src/main/resources/assests/images/Virat.jpg", false))); 
        } 
        catch (Exception e) { innerAvatar.setFill(Color.DARKGRAY); }
        avatarRing.getChildren().addAll(outerRing, innerAvatar);
        addHoverScale(avatarRing);

        VBox textLayout = new VBox(15);
        textLayout.setAlignment(Pos.CENTER_LEFT);
        
        HBox nameRow = new HBox(15);
        nameRow.setAlignment(Pos.CENTER_LEFT);
        Label nameLbl = new Label("Vikram Malhotra");
        nameLbl.setStyle("-fx-font-size: 26px; -fx-font-weight: bold; -fx-text-fill: white;");
        Label levelBadge = new Label("Pro Level 8");
        levelBadge.setStyle("-fx-background-color: rgba(16,185,129,0.2); -fx-text-fill: #34d399; -fx-font-weight: bold; -fx-padding: 4 12; -fx-background-radius: 20; -fx-border-color: #10b981; -fx-border-radius: 20;");
        nameRow.getChildren().addAll(nameLbl, levelBadge);

        Label quoteLbl = new Label("\"The harder you work in the nets, the easier it is on the pitch.\"");
        quoteLbl.setStyle("-fx-font-size: 14px; -fx-font-style: italic; -fx-text-fill: #94a3b8;");

        HBox actionsRow = new HBox(15);
        actionsRow.setAlignment(Pos.CENTER_LEFT);

        VBox aiScoreBox = new VBox(2);
        aiScoreBox.setStyle("-fx-background-color: rgba(255,255,255,0.1); -fx-padding: 10 20; -fx-background-radius: 10;");
        Label aiTitle = new Label("AI Improvement Score");
        aiTitle.setStyle("-fx-text-fill: #cbd5e1; -fx-font-size: 11px;");
        Label aiValue = new Label("+12.4%");
        aiValue.setStyle("-fx-text-fill: #34d399; -fx-font-weight: bold; -fx-font-size: 16px;");
        aiScoreBox.getChildren().addAll(aiTitle, aiValue);

        Button startBtn = new Button("Start\nTraining");
        startBtn.setStyle("-fx-background-color: #10b981; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 8 25; -fx-text-alignment: center; -fx-cursor: hand;");
        addHoverScale(startBtn);
        
        startBtn.setOnAction(e -> {
            Training_StartButton startPage = new Training_StartButton(() -> {
                loadTrainingView();
            });
            contentArea.getChildren().setAll(startPage.getView());
            contentArea.setOpacity(0);
            FadeTransition ft = new FadeTransition(javafx.util.Duration.millis(400), contentArea);
            ft.setToValue(1.0);
            ft.play();
        });
        
        Button calBtn = new Button("Training\nCalendar");
        calBtn.setStyle("-fx-background-color: rgba(255,255,255,0.1); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 8 20; -fx-text-alignment: center; -fx-cursor: hand;");
        addHoverScale(calBtn);

        Button bookBtn = new Button("Book\nCoach");
        bookBtn.setStyle("-fx-background-color: rgba(255,255,255,0.1); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 8 20; -fx-text-alignment: center; -fx-cursor: hand;");
        addHoverScale(bookBtn);

        actionsRow.getChildren().addAll(aiScoreBox, startBtn, calBtn, bookBtn);
        textLayout.getChildren().addAll(nameRow, quoteLbl, actionsRow);
        
        contentLayout.getChildren().addAll(avatarRing, textLayout);
        bannerPane.getChildren().addAll(bg, contentLayout);
        
        return bannerPane;
    }

    // --- STATS CARDS ---
    private HBox buildStatsRow() {
        HBox row = new HBox(20);
        row.getChildren().addAll(
            createCircularStatCard("Overall\nProgress", "82%", 0.82),
            createIconStatCard("Sessions\nCompleted", "14", "📅"),
            createIconStatCard("Practice Hours", "48h", "⏱"),
            createIconStatCardWithGreen("AI Training\nScore", "94", "📊")
        );
        for (Node n : row.getChildren()) HBox.setHgrow(n, Priority.ALWAYS);
        return row;
    }

    private HBox createCircularStatCard(String title, String value, double progress) {
        HBox card = buildBaseCard();
        VBox texts = new VBox(5, createStatTitle(title), createStatValue(value));
        
        StackPane circlePane = new StackPane();
        Circle bgCircle = new Circle(22, Color.TRANSPARENT);
        bgCircle.setStroke(Color.web("#f1f5f9"));
        bgCircle.setStrokeWidth(4);
        
        Circle progCircle = new Circle(22, Color.TRANSPARENT);
        progCircle.setStroke(Color.web("#10b981"));
        progCircle.setStrokeWidth(4);
        progCircle.getStrokeDashArray().addAll(progress * 138, 138.0);
        
        Label valLbl = new Label(value);
        valLbl.setStyle("-fx-font-size: 11px; -fx-font-weight: bold;");
        circlePane.getChildren().addAll(bgCircle, progCircle, valLbl);

        Region spacer = new Region(); 
        HBox.setHgrow(spacer, Priority.ALWAYS);
        card.getChildren().addAll(texts, spacer, circlePane);
        return card;
    }

    private HBox createIconStatCard(String title, String value, String icon) {
        HBox card = buildBaseCard();
        VBox texts = new VBox(5, createStatTitle(title), createStatValue(value));
        Region spacer = new Region(); 
        HBox.setHgrow(spacer, Priority.ALWAYS);
        Label iconLbl = new Label(icon);
        iconLbl.setStyle("-fx-font-size: 24px; -fx-text-fill: #94a3b8;");
        card.getChildren().addAll(texts, spacer, iconLbl);
        return card;
    }

    private HBox createIconStatCardWithGreen(String title, String value, String icon) {
        HBox card = buildBaseCard();
        VBox texts = new VBox(5, createStatTitle(title), createStatValue(value, "#10b981"));
        Region spacer = new Region(); 
        HBox.setHgrow(spacer, Priority.ALWAYS);
        
        StackPane iconPane = new StackPane();
        iconPane.setStyle("-fx-background-color: #d1fae5; -fx-background-radius: 8; -fx-padding: 8;");
        Label iconLbl = new Label(icon);
        iconLbl.setStyle("-fx-font-size: 20px; -fx-text-fill: #10b981;");
        iconPane.getChildren().add(iconLbl);
        
        card.getChildren().addAll(texts, spacer, iconPane);
        return card;
    }

    private HBox buildBaseCard() {
        HBox card = new HBox();
        card.setAlignment(Pos.CENTER_LEFT);
        card.setPadding(new Insets(20));
        card.setStyle("-fx-background-color: white; -fx-background-radius: 12; -fx-border-color: #f1f5f9; -fx-border-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
        addHoverScale(card);
        return card;
    }
    
    private Label createStatTitle(String text) {
        Label l = new Label(text);
        l.setStyle("-fx-font-size: 13px; -fx-text-fill: #64748b;");
        return l;
    }
    
    private Label createStatValue(String text) { return createStatValue(text, "#0f172a"); }
    private Label createStatValue(String text, String color) {
        Label l = new Label(text);
        l.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: " + color + ";");
        return l;
    }

    // --- MAIN SPLIT AREA ---
    private HBox buildMainSplitArea() {
        HBox splitLayout = new HBox(30);

        VBox leftCol = new VBox(30);
        HBox.setHgrow(leftCol, Priority.ALWAYS);
        leftCol.getChildren().addAll(buildSkillTrainingSection(), buildAnalyticsSection());

        VBox rightCol = new VBox(25);
        rightCol.setPrefWidth(320);
        rightCol.setMinWidth(320);
        rightCol.getChildren().addAll(
            buildScheduleSection(),
            buildAIInsightsSection(),
            buildWeatherEquipmentRow(),
            buildMessagesSection()
        );

        splitLayout.getChildren().addAll(leftCol, rightCol);
        return splitLayout;
    }

    // === SKILL SPECIFIC TRAINING WITH IMAGES & INTERACTIVE TABS ===
    private VBox buildSkillTrainingSection() {
        VBox box = new VBox(15);
        
        HBox header = new HBox(20);
        header.setAlignment(Pos.CENTER_LEFT);
        Label title = new Label("Skill Specific Training");
        title.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
        
        HBox tabs = new HBox(10);
        
        Label batTab = createMiniTab("Batting");
        Label bowlTab = createMiniTab("Bowling");
        Label fieldTab = createMiniTab("Fielding");
        Label keepTab = createMiniTab("Keeper");
        
        tabs.getChildren().addAll(batTab, bowlTab, fieldTab, keepTab);
        header.getChildren().addAll(title, tabs);

        HBox cardsContainer = new HBox(15);
        for(Node n : cardsContainer.getChildren()) HBox.setHgrow(n, Priority.ALWAYS);

        setTabActiveState(batTab, true);
        setTabActiveState(bowlTab, false);
        setTabActiveState(fieldTab, false);
        setTabActiveState(keepTab, false);
        loadSkillCards(cardsContainer, "Batting");

        batTab.setOnMouseClicked(e -> {
            setTabActiveState(batTab, true); setTabActiveState(bowlTab, false); setTabActiveState(fieldTab, false); setTabActiveState(keepTab, false);
            loadSkillCards(cardsContainer, "Batting");
        });
        bowlTab.setOnMouseClicked(e -> {
            setTabActiveState(batTab, false); setTabActiveState(bowlTab, true); setTabActiveState(fieldTab, false); setTabActiveState(keepTab, false);
            loadSkillCards(cardsContainer, "Bowling");
        });
        fieldTab.setOnMouseClicked(e -> {
            setTabActiveState(batTab, false); setTabActiveState(bowlTab, false); setTabActiveState(fieldTab, true); setTabActiveState(keepTab, false);
            loadSkillCards(cardsContainer, "Fielding");
        });
        keepTab.setOnMouseClicked(e -> {
            setTabActiveState(batTab, false); setTabActiveState(bowlTab, false); setTabActiveState(fieldTab, false); setTabActiveState(keepTab, true);
            loadSkillCards(cardsContainer, "Keeper");
        });

        box.getChildren().addAll(header, cardsContainer);
        return box;
    }

    private Label createMiniTab(String text) {
        Label l = new Label(text);
        l.setStyle("-fx-text-fill: #64748b; -fx-font-weight: bold; -fx-font-size: 11px; -fx-padding: 6 16; -fx-background-radius: 12; -fx-cursor: hand;");
        return l;
    }

    private void setTabActiveState(Label tab, boolean isActive) {
        if (isActive) {
            tab.setStyle("-fx-background-color: white; -fx-text-fill: #0f172a; -fx-font-weight: bold; -fx-font-size: 11px; -fx-padding: 6 16; -fx-background-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.08), 5, 0, 0, 2); -fx-cursor: hand;");
        } else {
            tab.setStyle("-fx-background-color: transparent; -fx-text-fill: #64748b; -fx-font-weight: bold; -fx-font-size: 11px; -fx-padding: 6 16; -fx-background-radius: 12; -fx-cursor: hand;");
        }
    }

    // FIXED: REMOVED ALL UNSPLASH URLS AND REPLACED WITH LOCAL FALLBACKS FOR INSTANT LOADING
    private void loadSkillCards(HBox container, String category) {
        container.getChildren().clear();
        StackPane card1, card2;
        
        // Define your local image path here. 
        // We are using stadium.jpg as a safe fallback since we know it exists on your machine.
        String localImagePath = "file:src/main/resources/assests/images/Stadium1.jpg";
        String localImagePath1 = "file:src/main/resources/assests/images/ball3.jpg";
        
        switch (category) {
            case "Bowling":
                card1 = createVideoCard("Inswing Mechanics", "3 Sets x 12 Reps", "⭐ Coach Choice", localImagePath);
                card2 = createVideoCard("Yorker Accuracy", "4 Sets x 15 Reps", "⏱ Last: 7.5/10", localImagePath1);
                break;
            case "Fielding":
                card1 = createVideoCard("Diving Interceptions", "5 Sets x 10 Reps", "🔥 High Intensity", localImagePath);
                card2 = createVideoCard("Direct Hit Drills", "3 Sets x 20 Reps", "⏱ Last: 9/10", localImagePath);
                break;
            case "Keeper":
                card1 = createVideoCard("Spin Reaction Drills", "4 Sets x 30 Reps", "⭐ Coach Choice", localImagePath);
                card2 = createVideoCard("Leg-side Diving", "3 Sets x 15 Reps", "⏱ Last: 8/10", localImagePath);
                break;
            default: // Batting
                card1 = createVideoCard("Cover Drive Fundamentals", "4 Sets x 15 Reps", "⭐ Coach Choice", localImagePath);
                card2 = createVideoCard("Straight Drive Control", "3 Sets x 20 Reps", "⏱ Last: 8.5/10", localImagePath);
                break;
        }

        HBox.setHgrow(card1, Priority.ALWAYS);
        HBox.setHgrow(card2, Priority.ALWAYS);
        container.getChildren().addAll(card1, card2);

        container.setOpacity(0);
        FadeTransition ft = new FadeTransition(Duration.millis(300), container);
        ft.setToValue(1.0);
        ft.play();
    }

    private StackPane createVideoCard(String title, String sub, String tag, String localImagePath) {
        StackPane card = new StackPane();
        card.setMinHeight(160);
        
        String style = "-fx-background-color: #cbd5e1; -fx-background-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.05), 10, 0, 0, 4);";
        
        // Use local image loading
        style += "-fx-background-image: url('" + localImagePath + "'); -fx-background-size: cover; -fx-background-position: center center; -fx-background-radius: 12;";
        
        card.setStyle(style);
        addHoverScale(card);

        Region overlay = new Region();
        overlay.setStyle("-fx-background-color: linear-gradient(to top, rgba(0,0,0,0.85), transparent); -fx-background-radius: 12;");

        VBox content = new VBox(5);
        content.setAlignment(Pos.BOTTOM_LEFT);
        content.setPadding(new Insets(15));
        
        Label t = new Label(title);
        t.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14px;");
        Label s = new Label(sub);
        s.setStyle("-fx-text-fill: #cbd5e1; -fx-font-size: 11px;");
        Label tg = new Label(tag);
        tg.setStyle("-fx-text-fill: #34d399; -fx-font-size: 11px; -fx-font-weight: bold;");
        
        content.getChildren().addAll(t, s, tg);
        card.getChildren().addAll(overlay, content);
        return card;
    }

    // --- ANALYTICS ---
    private VBox buildAnalyticsSection() {
        VBox box = new VBox(20);
        box.setPadding(new Insets(25));
        box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.04), 15, 0, 0, 5);");
        addHoverScale(box);

        Label title = new Label("Skill Development Analytics");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: #334155;");

        HBox chartsRow = new HBox(30);
        chartsRow.setAlignment(Pos.CENTER);

        StackPane radarChart = buildRadarChartMock();
        
        VBox rightStats = new VBox(15);
        rightStats.setAlignment(Pos.CENTER_LEFT);
        
        Label trendTitle = new Label("SKILL GROWTH TREND");
        trendTitle.setStyle("-fx-font-size: 11px; -fx-text-fill: #94a3b8; -fx-font-weight: bold;");
        Label trendVal = new Label("+18% this month");
        trendVal.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
        VBox trendBox = new VBox(2, trendTitle, trendVal);

        HBox barChart = new HBox(8);
        barChart.setAlignment(Pos.BOTTOM_CENTER);
        barChart.setMinHeight(80);
        double[] heights = {30, 45, 20, 60, 50, 70, 90};
        for (int i = 0; i < heights.length; i++) {
            Rectangle bar = new Rectangle(18, heights[i]);
            bar.setArcWidth(4); 
            bar.setArcHeight(4);
            bar.setFill(i < 3 ? Color.web("#e2e8f0") : Color.web("#10b981"));
            barChart.getChildren().add(bar);
        }

        HBox summaryRow = new HBox(10);
        summaryRow.getChildren().addAll(
            createGrowthBox("Top Gaining", "Bowling\nAccuracy", "#10b981"),
            createGrowthBox("Needs Focus", "Power\nHitting", "#ef4444")
        );

        rightStats.getChildren().addAll(trendBox, barChart, summaryRow);
        chartsRow.getChildren().addAll(radarChart, rightStats);
        box.getChildren().addAll(title, chartsRow);
        return box;
    }

    private StackPane buildRadarChartMock() {
        StackPane pane = new StackPane();
        pane.setPrefSize(200, 200);
        
        pane.getChildren().add(createPentagon(90, "#f8fafc", "#cbd5e1"));
        pane.getChildren().add(createPentagon(60, "transparent", "#e2e8f0"));
        pane.getChildren().add(createPentagon(30, "transparent", "#e2e8f0"));

        Polygon dataPoly = new Polygon();
        dataPoly.getPoints().addAll(
            0.0, -70.0,   // Technique
            60.0, -10.0,  // Power
            40.0, 60.0,   // Reflex
            -30.0, 50.0,  // Stamina
            -80.0, -20.0  // Accuracy
        );
        dataPoly.setFill(Color.web("rgba(16, 185, 129, 0.4)"));
        dataPoly.setStroke(Color.web("#10b981"));
        dataPoly.setStrokeWidth(2);
        pane.getChildren().add(dataPoly);

        pane.getChildren().addAll(
            positionLabel("TECHNIQUE", 0, -105),
            positionLabel("POWER", 95, -20),
            positionLabel("REFLEX", 65, 90),
            positionLabel("STAMINA", -65, 90),
            positionLabel("ACCURACY", -95, -20)
        );

        return pane;
    }

    private Polygon createPentagon(double radius, String fillHex, String strokeHex) {
        Polygon p = new Polygon();
        for (int i = 0; i < 5; i++) {
            double angle = Math.toRadians(-90 + i * 72);
            p.getPoints().addAll(radius * Math.cos(angle), radius * Math.sin(angle));
        }
        p.setFill(Color.web(fillHex));
        p.setStroke(Color.web(strokeHex));
        return p;
    }

    private Label positionLabel(String text, double tx, double ty) {
        Label l = new Label(text);
        l.setStyle("-fx-font-size: 10px; -fx-text-fill: #475569;");
        l.setTranslateX(tx);
        l.setTranslateY(ty);
        return l;
    }

    private VBox createGrowthBox(String title, String val, String valColor) {
        VBox box = new VBox(5);
        box.setPadding(new Insets(10, 15, 10, 15));
        box.setStyle("-fx-background-color: #f8fafc; -background-radius: 8;");
        Label t = new Label(title);
        t.setStyle("-fx-font-size: 11px; -fx-text-fill: #64748b;");
        Label v = new Label(val);
        v.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: " + valColor + ";");
        box.getChildren().addAll(t, v);
        return box;
    }

    // --- SCHEDULE & AI SECTION ---
    private VBox buildScheduleSection() {
        VBox section = new VBox(15);
        HBox header = new HBox();
        Label title = new Label("Today's Schedule");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: #334155;");
        Region spacer = new Region(); 
        HBox.setHgrow(spacer, Priority.ALWAYS);
        Label calIcon = new Label("📅");
        calIcon.setStyle("-fx-text-fill: #10b981; -fx-font-size: 16px;");
        header.getChildren().addAll(title, spacer, calIcon);

        VBox list = new VBox(15);
        list.getChildren().addAll(
            createScheduleItem("16:00", "PM", "Fast Bowling Mastery", "Coach: Rahul Dravid • Lane 4", true),
            createScheduleItem("18:30", "PM", "Recovery & Yoga", "Gym Zone B • Session 12", false)
        );

        section.getChildren().addAll(header, list);
        return section;
    }

    private HBox createScheduleItem(String time, String ampm, String title, String subtitle, boolean isActive) {
        HBox item = new HBox(15);
        item.setAlignment(Pos.CENTER_LEFT);
        item.setPadding(new Insets(15));
        item.setStyle("-fx-background-color: " + (isActive ? "#f0fdf4" : "white") + "; -fx-background-radius: 12; -fx-border-color: " + (isActive ? "transparent" : "#f1f5f9") + "; -fx-border-radius: 12;");
        if (isActive) item.setStyle(item.getStyle() + "-fx-border-width: 0 0 0 4; -fx-border-color: #10b981;");
        addHoverScale(item);

        VBox timeBox = new VBox(0);
        timeBox.setAlignment(Pos.CENTER);
        Label t = new Label(time);
        t.setStyle("-fx-font-weight: bold; -fx-font-size: 15px; -fx-text-fill: #0f172a;");
        Label ap = new Label(ampm);
        ap.setStyle("-fx-font-weight: bold; -fx-font-size: 12px; -fx-text-fill: " + (isActive ? "#10b981" : "#94a3b8") + ";");
        timeBox.getChildren().addAll(t, ap);

        VBox dataBox = new VBox(3);
        Label titleLbl = new Label(title);
        titleLbl.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: #0f172a;");
        Label subLbl = new Label(subtitle);
        subLbl.setStyle("-fx-font-size: 12px; -fx-text-fill: #64748b;");
        dataBox.getChildren().addAll(titleLbl, subLbl);

        item.getChildren().addAll(timeBox, dataBox);
        return item;
    }

    private VBox buildAIInsightsSection() {
        VBox card = new VBox(20);
        card.setPadding(new Insets(25));
        card.setStyle("-fx-background-color: #0f172a; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 20, 0, 0, 8);");
        addHoverScale(card);

        HBox header = new HBox(10);
        header.setAlignment(Pos.CENTER_LEFT);
        Label icon = new Label("🧠");
        Label title = new Label("AI Training Insights");
        title.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 15px;");
        header.getChildren().addAll(icon, title);

        Label quote = new Label("\"Aashish, your wrist position on the off-drive has shifted 3° inward. Today, focus on maintaining a high elbow finish to stabilize your shot direction.\"");
        quote.setWrapText(true);
        quote.setStyle("-fx-text-fill: #cbd5e1; -fx-font-size: 13px; -fx-font-style: italic; -fx-line-spacing: 5px;");

        VBox plansBox = new VBox(10);
        Label planTitle = new Label("ACTIVE PLANS");
        planTitle.setStyle("-fx-text-fill: #34d399; -fx-font-size: 11px; -fx-font-weight: bold; -fx-letter-spacing: 1px;");
        plansBox.getChildren().addAll(
            planTitle,
            createDarkPlanRow("Power Hitting Fundamentals", "75%", true),
            createDarkPlanRow("Reverse Swing Mastery", "Coming Soon", false)
        );

        Button vrBtn = new Button("Launch VR Simulation");
        vrBtn.setMaxWidth(Double.MAX_VALUE);
        vrBtn.setStyle("-fx-background-color: #059669; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 12; -fx-background-radius: 8; -fx-cursor: hand;");
        addHoverScale(vrBtn);

        card.getChildren().addAll(header, quote, plansBox, vrBtn);
        return card;
    }

    private HBox createDarkPlanRow(String title, String val, boolean isGreenVal) {
        HBox row = new HBox();
        Label t = new Label(title);
        t.setStyle("-fx-text-fill: white; -fx-font-size: 12px;");
        Region spacer = new Region(); 
        HBox.setHgrow(spacer, Priority.ALWAYS);
        Label v = new Label(val);
        v.setStyle("-fx-font-size: 12px; -fx-text-fill: " + (isGreenVal ? "#34d399" : "#64748b") + ";");
        row.getChildren().addAll(t, spacer, v);
        return row;
    }

    private HBox buildWeatherEquipmentRow() {
        HBox row = new HBox(15);
        VBox weather = new VBox(5);
        weather.setAlignment(Pos.CENTER);
        weather.setPadding(new Insets(15));
        weather.setStyle("-fx-background-color: white; -fx-background-radius: 12; -fx-border-color: #f1f5f9; -fx-border-radius: 12;");
        Label wIcon = new Label("☀"); 
        wIcon.setStyle("-fx-text-fill: #10b981; -fx-font-size: 20px;");
        Label wTemp = new Label("28°C Clear"); 
        wTemp.setStyle("-fx-font-weight: bold; -fx-font-size: 12px;");
        Label wSub = new Label("Perfect for Nets"); 
        wSub.setStyle("-fx-font-size: 10px; -fx-text-fill: #64748b;");
        weather.getChildren().addAll(wIcon, wTemp, wSub);
        HBox.setHgrow(weather, Priority.ALWAYS);
        addHoverScale(weather);

        VBox equip = new VBox(5);
        equip.setAlignment(Pos.CENTER);
        equip.setPadding(new Insets(15));
        equip.setStyle("-fx-background-color: white; -fx-background-radius: 12; -fx-border-color: #f1f5f9; -fx-border-radius: 12;");
        Label eIcon = new Label("🏏"); 
        eIcon.setStyle("-fx-text-fill: #10b981; -fx-font-size: 20px;");
        Label eTitle = new Label("Equipment"); 
        eTitle.setStyle("-fx-font-weight: bold; -fx-font-size: 12px;");
        Label eSub = new Label("2 items needed"); 
        eSub.setStyle("-fx-font-size: 10px; -fx-text-fill: #64748b;");
        equip.getChildren().addAll(eIcon, eTitle, eSub);
        HBox.setHgrow(equip, Priority.ALWAYS);
        addHoverScale(equip);

        row.getChildren().addAll(weather, equip);
        return row;
    }

    private VBox buildMessagesSection() {
        VBox section = new VBox(15);
        Label title = new Label("COACH MESSAGES");
        title.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #64748b; -fx-letter-spacing: 1px;");

        VBox list = new VBox(15);
        list.getChildren().addAll(
            createMessageItem("RD", "Rahul Dravid", "Check your backlift video from yesterday's session.", "#10b981"),
            createMessageItem("SM", "S. Malinga", "Great yorker consistency. Let's try slow-balls next.", "#6366f1")
        );

        section.getChildren().addAll(title, list);
        return section;
    }

    private HBox createMessageItem(String initials, String name, String msg, String color) {
        HBox item = new HBox(15);
        Label initLbl = new Label(initials);
        initLbl.setAlignment(Pos.CENTER);
        initLbl.setMinSize(36, 36);
        initLbl.setStyle("-fx-background-color: " + color + "33; -fx-text-fill: " + color + "; -fx-font-weight: bold; -fx-font-size: 12px; -fx-background-radius: 18;");

        VBox texts = new VBox(3);
        Label nameLbl = new Label(name);
        nameLbl.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
        Label msgLbl = new Label(msg);
        msgLbl.setWrapText(true);
        msgLbl.setStyle("-fx-font-size: 12px; -fx-text-fill: #64748b;");
        texts.getChildren().addAll(nameLbl, msgLbl);

        item.getChildren().addAll(initLbl, texts);
        addHoverScale(item);
        return item;
    }
}
