// // // // package com.athlixcore.view.player;

// // // // import javafx.geometry.Insets;
// // // // import javafx.geometry.Pos;
// // // // import javafx.scene.Node;
// // // // import javafx.scene.control.Button;
// // // // import javafx.scene.control.Label;
// // // // import javafx.scene.control.ScrollPane;
// // // // import javafx.scene.control.TextField;
// // // // import javafx.scene.image.Image;
// // // // import javafx.scene.image.ImageView;
// // // // import javafx.scene.layout.*;
// // // // import javafx.scene.paint.Color;
// // // // import javafx.scene.paint.CycleMethod;
// // // // import javafx.scene.paint.LinearGradient;
// // // // import javafx.scene.paint.Stop;
// // // // import javafx.scene.shape.Circle;
// // // // import javafx.scene.shape.Polygon;
// // // // import javafx.scene.shape.Rectangle;

// // // // public class Traning_dashboard {

// // // //     private StackPane rootContainer;

// // // //     public Node getView() {
// // // //         if (rootContainer == null) {
// // // //             rootContainer = new StackPane();
// // // //             rootContainer.setStyle("-fx-background-color: #f8fafc;");

// // // //             VBox mainLayout = new VBox(25);
// // // //             mainLayout.setPadding(new Insets(20, 30, 40, 30));

// // // //             // Build Sections
// // // //             mainLayout.getChildren().addAll(
// // // //                 buildTopBar(),
// // // //                 buildHeroBanner(),
// // // //                 buildStatsRow(),
// // // //                 buildMainSplitArea()
// // // //             );

// // // //             ScrollPane scrollPane = new ScrollPane(mainLayout);
// // // //             scrollPane.setFitToWidth(true);
// // // //             scrollPane.setStyle("-fx-background-color: transparent; -fx-background: #f8fafc;");
// // // //             scrollPane.getStylesheets().add("data:text/css,.scroll-pane > .viewport { -fx-background-color: transparent; }");

// // // //             rootContainer.getChildren().add(scrollPane);
// // // //         }
// // // //         return rootContainer;
// // // //     }

// // // //     // --- 1. TOP NAVIGATION BAR ---
// // // //     private HBox buildTopBar() {
// // // //         HBox topBar = new HBox(20);
// // // //         topBar.setAlignment(Pos.CENTER_LEFT);

// // // //         // Search Bar
// // // //         HBox searchBox = new HBox(10);
// // // //         searchBox.setAlignment(Pos.CENTER_LEFT);
// // // //         searchBox.setStyle("-fx-background-color: white; -fx-background-radius: 20; -fx-padding: 8 15; -fx-border-color: #e2e8f0; -fx-border-radius: 20;");
// // // //         Label searchIcon = new Label("🔍");
// // // //         searchIcon.setStyle("-fx-text-fill: #94a3b8;");
// // // //         TextField searchField = new TextField();
// // // //         searchField.setPromptText("Search training modules, coaches, or stats...");
// // // //         searchField.setStyle("-fx-background-color: transparent; -fx-border-width: 0; -fx-pref-width: 300px;");
// // // //         searchBox.getChildren().addAll(searchIcon, searchField);

// // // //         Region spacer = new Region();
// // // //         HBox.setHgrow(spacer, Priority.ALWAYS);

// // // //         // Navigation Links
// // // //         HBox navLinks = new HBox(25);
// // // //         navLinks.setAlignment(Pos.CENTER);
// // // //         navLinks.getChildren().addAll(
// // // //             createNavLink("Performance", false),
// // // //             createNavLink("Team", true), // Active tab based on image
// // // //             createNavLink("Resources", false)
// // // //         );

// // // //         // Icons & Avatar
// // // //         Label bellIcon = new Label("🔔");
// // // //         bellIcon.setStyle("-fx-font-size: 18px; -fx-cursor: hand;");
// // // //         Label settingsIcon = new Label("⚙");
// // // //         settingsIcon.setStyle("-fx-font-size: 18px; -fx-cursor: hand;");

// // // //         Circle avatar = new Circle(18);
// // // //         try {
// // // //             avatar.setFill(new javafx.scene.paint.ImagePattern(new Image("https://randomuser.me/api/portraits/men/32.jpg")));
// // // //         } catch (Exception e) {
// // // //             avatar.setFill(Color.GRAY);
// // // //         }

// // // //         topBar.getChildren().addAll(searchBox, spacer, navLinks, bellIcon, settingsIcon, avatar);
// // // //         return topBar;
// // // //     }

// // // //     private VBox createNavLink(String text, boolean isActive) {
// // // //         VBox box = new VBox(5);
// // // //         box.setAlignment(Pos.CENTER);
// // // //         Label lbl = new Label(text);
// // // //         lbl.setStyle(isActive ? "-fx-font-weight: bold; -fx-text-fill: #0f172a;" : "-fx-font-weight: normal; -fx-text-fill: #64748b;");
// // // //         lbl.setStyle(lbl.getStyle() + "-fx-font-size: 14px; -fx-cursor: hand;");
        
// // // //         Region indicator = new Region();
// // // //         indicator.setPrefSize(30, 3);
// // // //         indicator.setStyle(isActive ? "-fx-background-color: #10b981; -fx-background-radius: 2;" : "-fx-background-color: transparent;");
        
// // // //         box.getChildren().addAll(lbl, indicator);
// // // //         return box;
// // // //     }

// // // //     // --- 2. HERO BANNER ---
// // // //     private StackPane buildHeroBanner() {
// // // //         StackPane bannerPane = new StackPane();
// // // //         bannerPane.setMinHeight(220);
// // // //         bannerPane.setStyle("-fx-background-radius: 20; -fx-border-radius: 20; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 20, 0, 0, 5);");

// // // //         // Background Layer (Gradient mimicking the dark indoor nets photo)
// // // //         Region bg = new Region();
// // // //         bg.setStyle("-fx-background-color: linear-gradient(to right, #1e293b, #0f172a); -fx-background-radius: 20;");
        
// // // //         // Content Layer
// // // //         HBox contentLayout = new HBox(30);
// // // //         contentLayout.setAlignment(Pos.CENTER_LEFT);
// // // //         contentLayout.setPadding(new Insets(30, 40, 30, 40));

// // // //         // Profile Avatar Ring
// // // //         StackPane avatarRing = new StackPane();
// // // //         Circle outerRing = new Circle(65, Color.TRANSPARENT);
// // // //         outerRing.setStroke(Color.web("#10b981"));
// // // //         outerRing.setStrokeWidth(3);
        
// // // //         Circle innerAvatar = new Circle(55);
// // // //         try {
// // // //             innerAvatar.setFill(new javafx.scene.paint.ImagePattern(new Image("https://randomuser.me/api/portraits/men/32.jpg")));
// // // //         } catch (Exception e) { innerAvatar.setFill(Color.DARKGRAY); }
// // // //         avatarRing.getChildren().addAll(outerRing, innerAvatar);

// // // //         // Text & Buttons
// // // //         VBox textLayout = new VBox(15);
// // // //         textLayout.setAlignment(Pos.CENTER_LEFT);
        
// // // //         HBox nameRow = new HBox(15);
// // // //         nameRow.setAlignment(Pos.CENTER_LEFT);
// // // //         Label nameLbl = new Label("Aashish Mohan Bhosale");
// // // //         nameLbl.setStyle("-fx-font-size: 26px; -fx-font-weight: bold; -fx-text-fill: white;");
// // // //         Label levelBadge = new Label("Pro Level 8");
// // // //         levelBadge.setStyle("-fx-background-color: rgba(16,185,129,0.2); -fx-text-fill: #34d399; -fx-font-weight: bold; -fx-padding: 4 12; -fx-background-radius: 20; -fx-border-color: #10b981; -fx-border-radius: 20;");
// // // //         nameRow.getChildren().addAll(nameLbl, levelBadge);

// // // //         Label quoteLbl = new Label("\"The harder you work in the nets, the easier it is on the pitch.\"");
// // // //         quoteLbl.setStyle("-fx-font-size: 14px; -fx-font-style: italic; -fx-text-fill: #94a3b8;");

// // // //         HBox actionsRow = new HBox(15);
// // // //         actionsRow.setAlignment(Pos.CENTER_LEFT);

// // // //         VBox aiScoreBox = new VBox(2);
// // // //         aiScoreBox.setStyle("-fx-background-color: rgba(255,255,255,0.1); -fx-padding: 10 20; -fx-background-radius: 10;");
// // // //         Label aiTitle = new Label("AI Improvement Score");
// // // //         aiTitle.setStyle("-fx-text-fill: #cbd5e1; -fx-font-size: 11px;");
// // // //         Label aiValue = new Label("+12.4%");
// // // //         aiValue.setStyle("-fx-text-fill: #34d399; -fx-font-weight: bold; -fx-font-size: 16px;");
// // // //         aiScoreBox.getChildren().addAll(aiTitle, aiValue);

// // // //         Button startBtn = new Button("Start\nTraining");
// // // //         startBtn.setStyle("-fx-background-color: #10b981; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 8 25; -fx-text-alignment: center; -fx-cursor: hand;");
        
// // // //         Button calBtn = new Button("Training\nCalendar");
// // // //         calBtn.setStyle("-fx-background-color: rgba(255,255,255,0.1); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 8 20; -fx-text-alignment: center; -fx-cursor: hand;");

// // // //         Button bookBtn = new Button("Book\nCoach");
// // // //         bookBtn.setStyle("-fx-background-color: rgba(255,255,255,0.1); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 8 20; -fx-text-alignment: center; -fx-cursor: hand;");

// // // //         actionsRow.getChildren().addAll(aiScoreBox, startBtn, calBtn, bookBtn);
// // // //         textLayout.getChildren().addAll(nameRow, quoteLbl, actionsRow);
        
// // // //         contentLayout.getChildren().addAll(avatarRing, textLayout);
// // // //         bannerPane.getChildren().addAll(bg, contentLayout);
        
// // // //         return bannerPane;
// // // //     }

// // // //     // --- 3. STATS ROW ---
// // // //     private HBox buildStatsRow() {
// // // //         HBox row = new HBox(20);
// // // //         row.getChildren().addAll(
// // // //             createCircularStatCard("Overall\nProgress", "82%", 0.82),
// // // //             createIconStatCard("Sessions\nCompleted", "14", "📅"),
// // // //             createIconStatCard("Practice Hours", "48h", "⏱"),
// // // //             createIconStatCardWithGreen("AI Training\nScore", "94", "📊")
// // // //         );
// // // //         for(Node n : row.getChildren()) HBox.setHgrow(n, Priority.ALWAYS);
// // // //         return row;
// // // //     }

// // // //     private HBox createCircularStatCard(String title, String value, double progress) {
// // // //         HBox card = buildBaseCard();
// // // //         VBox texts = new VBox(5, createStatTitle(title), createStatValue(value));
        
// // // //         StackPane circlePane = new StackPane();
// // // //         Circle bgCircle = new Circle(20, Color.TRANSPARENT);
// // // //         bgCircle.setStroke(Color.web("#e2e8f0"));
// // // //         bgCircle.setStrokeWidth(4);
        
// // // //         Circle progCircle = new Circle(20, Color.TRANSPARENT);
// // // //         progCircle.setStroke(Color.web("#10b981"));
// // // //         progCircle.setStrokeWidth(4);
// // // //         progCircle.getStrokeDashArray().addAll(progress * 125, 125.0); // Rough circumference approx
        
// // // //         Label valLbl = new Label(value);
// // // //         valLbl.setStyle("-fx-font-size: 11px; -fx-font-weight: bold;");
// // // //         circlePane.getChildren().addAll(bgCircle, progCircle, valLbl);

// // // //         Region spacer = new Region(); HBox.setHgrow(spacer, Priority.ALWAYS);
// // // //         card.getChildren().addAll(texts, spacer, circlePane);
// // // //         return card;
// // // //     }

// // // //     private HBox createIconStatCard(String title, String value, String icon) {
// // // //         HBox card = buildBaseCard();
// // // //         VBox texts = new VBox(5, createStatTitle(title), createStatValue(value));
// // // //         Region spacer = new Region(); HBox.setHgrow(spacer, Priority.ALWAYS);
// // // //         Label iconLbl = new Label(icon);
// // // //         iconLbl.setStyle("-fx-font-size: 24px; -fx-text-fill: #94a3b8;");
// // // //         card.getChildren().addAll(texts, spacer, iconLbl);
// // // //         return card;
// // // //     }

// // // //     private HBox createIconStatCardWithGreen(String title, String value, String icon) {
// // // //         HBox card = buildBaseCard();
// // // //         VBox texts = new VBox(5, createStatTitle(title), createStatValue(value, "#10b981"));
// // // //         Region spacer = new Region(); HBox.setHgrow(spacer, Priority.ALWAYS);
        
// // // //         StackPane iconPane = new StackPane();
// // // //         iconPane.setStyle("-fx-background-color: #d1fae5; -fx-background-radius: 8; -fx-padding: 8;");
// // // //         Label iconLbl = new Label(icon);
// // // //         iconLbl.setStyle("-fx-font-size: 20px; -fx-text-fill: #10b981;");
// // // //         iconPane.getChildren().add(iconLbl);
        
// // // //         card.getChildren().addAll(texts, spacer, iconPane);
// // // //         return card;
// // // //     }

// // // //     private HBox buildBaseCard() {
// // // //         HBox card = new HBox();
// // // //         card.setAlignment(Pos.CENTER_LEFT);
// // // //         card.setPadding(new Insets(20));
// // // //         card.setStyle("-fx-background-color: white; -fx-background-radius: 12; -fx-border-color: #f1f5f9; -fx-border-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
// // // //         return card;
// // // //     }
    
// // // //     private Label createStatTitle(String text) {
// // // //         Label l = new Label(text);
// // // //         l.setStyle("-fx-font-size: 13px; -fx-text-fill: #64748b;");
// // // //         return l;
// // // //     }
// // // //     private Label createStatValue(String text) { return createStatValue(text, "#0f172a"); }
// // // //     private Label createStatValue(String text, String color) {
// // // //         Label l = new Label(text);
// // // //         l.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: " + color + ";");
// // // //         return l;
// // // //     }

// // // //     // --- 4. MAIN SPLIT CONTENT ---
// // // //     private HBox buildMainSplitArea() {
// // // //         HBox splitLayout = new HBox(30);

// // // //         // LEFT COLUMN (Categories & Analytics)
// // // //         VBox leftCol = new VBox(30);
// // // //         HBox.setHgrow(leftCol, Priority.ALWAYS);
// // // //         leftCol.getChildren().addAll(buildCategoriesSection(), buildAnalyticsSection());

// // // //         // RIGHT COLUMN (Schedule, AI, Widgets)
// // // //         VBox rightCol = new VBox(25);
// // // //         rightCol.setPrefWidth(320);
// // // //         rightCol.setMinWidth(320);
// // // //         rightCol.getChildren().addAll(
// // // //             buildScheduleSection(),
// // // //             buildAIInsightsSection(),
// // // //             buildWeatherEquipmentRow(),
// // // //             buildMessagesSection()
// // // //         );

// // // //         splitLayout.getChildren().addAll(leftCol, rightCol);
// // // //         return splitLayout;
// // // //     }

// // // //     // --- LEFT COLUMN COMPONENTS ---
// // // //     private VBox buildCategoriesSection() {
// // // //         VBox section = new VBox(15);
        
// // // //         HBox header = new HBox();
// // // //         Label title = new Label("Training Categories");
// // // //         title.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: #334155;");
// // // //         Region spacer = new Region(); HBox.setHgrow(spacer, Priority.ALWAYS);
// // // //         Label viewAll = new Label("View All Drills");
// // // //         viewAll.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-text-fill: #10b981; -fx-cursor: hand;");
// // // //         header.getChildren().addAll(title, spacer, viewAll);

// // // //         GridPane grid = new GridPane();
// // // //         grid.setHgap(15); grid.setVgap(15);
// // // //         ColumnConstraints cc = new ColumnConstraints(); cc.setPercentWidth(33.33);
// // // //         grid.getColumnConstraints().addAll(cc, cc, cc);

// // // //         grid.add(createImageCard("Batting Practice", "12 Drills Available", "#4f46e5"), 0, 0);
// // // //         grid.add(createImageCard("Bowling Practice", "8 Drills Available", "#b45309"), 1, 0);
// // // //         grid.add(createImageCard("Strength & Agility", "15 High-Intensity Plans", "#15803d"), 2, 0);
// // // //         grid.add(createImageCard("Fielding Practice", "6 Expert Sessions", "#047857"), 0, 1);
// // // //         grid.add(createImageCard("Video Analysis", "Scan & Compare", "#0f172a"), 1, 1);
        
// // // //         // Custom Drill Card (Dashed)
// // // //         VBox customCard = new VBox(10);
// // // //         customCard.setAlignment(Pos.CENTER);
// // // //         customCard.setMinHeight(130);
// // // //         customCard.setStyle("-fx-background-color: #f8fafc; -fx-border-color: #cbd5e1; -fx-border-style: dashed; -fx-border-width: 2; -fx-background-radius: 12; -fx-border-radius: 12; -fx-cursor: hand;");
// // // //         Label plusIcon = new Label("⊕");
// // // //         plusIcon.setStyle("-fx-font-size: 24px; -fx-text-fill: #64748b;");
// // // //         Label customTxt = new Label("Custom Drill");
// // // //         customTxt.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-text-fill: #64748b;");
// // // //         customCard.getChildren().addAll(plusIcon, customTxt);
// // // //         grid.add(customCard, 2, 1);

// // // //         section.getChildren().addAll(header, grid);
// // // //         return section;
// // // //     }

// // // //     private StackPane createImageCard(String title, String subtitle, String fallbackColor) {
// // // //         StackPane card = new StackPane();
// // // //         card.setMinHeight(130);
// // // //         card.setStyle("-fx-background-color: " + fallbackColor + "; -fx-background-radius: 12; -fx-border-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0, 0, 4);");

// // // //         // Gradient Overlay to ensure text readability
// // // //         Region overlay = new Region();
// // // //         overlay.setStyle("-fx-background-color: linear-gradient(to top, rgba(0,0,0,0.9), transparent); -fx-background-radius: 12;");

// // // //         VBox textData = new VBox(3);
// // // //         textData.setAlignment(Pos.BOTTOM_LEFT);
// // // //         textData.setPadding(new Insets(15));
        
// // // //         Label tLbl = new Label(title);
// // // //         tLbl.setStyle("-fx-font-weight: bold; -fx-font-size: 15px; -fx-text-fill: white;");
// // // //         Label sLbl = new Label(subtitle);
// // // //         sLbl.setStyle("-fx-font-size: 12px; -fx-text-fill: #34d399;");
// // // //         textData.getChildren().addAll(tLbl, sLbl);

// // // //         card.getChildren().addAll(overlay, textData);
// // // //         return card;
// // // //     }

// // // //     private VBox buildAnalyticsSection() {
// // // //         VBox box = new VBox(20);
// // // //         box.setPadding(new Insets(25));
// // // //         box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.04), 15, 0, 0, 5);");

// // // //         Label title = new Label("Skill Development Analytics");
// // // //         title.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: #334155;");

// // // //         HBox chartsRow = new HBox(30);
// // // //         chartsRow.setAlignment(Pos.CENTER);

// // // //         // 1. Radar Chart (Custom Drawn)
// // // //         StackPane radarChart = buildRadarChartMock();
        
// // // //         // 2. Bar Chart & Stats
// // // //         VBox rightStats = new VBox(15);
// // // //         rightStats.setAlignment(Pos.CENTER_LEFT);
        
// // // //         Label trendTitle = new Label("SKILL GROWTH TREND");
// // // //         trendTitle.setStyle("-fx-font-size: 11px; -fx-text-fill: #94a3b8; -fx-font-weight: bold;");
// // // //         Label trendVal = new Label("+18% this month");
// // // //         trendVal.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
// // // //         VBox trendBox = new VBox(2, trendTitle, trendVal);

// // // //         // Fake Bar Chart
// // // //         HBox barChart = new HBox(8);
// // // //         barChart.setAlignment(Pos.BOTTOM_CENTER);
// // // //         barChart.setMinHeight(80);
// // // //         double[] heights = {30, 45, 20, 60, 50, 70, 90};
// // // //         for (int i = 0; i < heights.length; i++) {
// // // //             Rectangle bar = new Rectangle(18, heights[i]);
// // // //             bar.setArcWidth(4); bar.setArcHeight(4);
// // // //             bar.setFill(i < 3 ? Color.web("#e2e8f0") : Color.web("#10b981"));
// // // //             barChart.getChildren().add(bar);
// // // //         }

// // // //         // Summary Boxes
// // // //         HBox summaryRow = new HBox(10);
// // // //         summaryRow.getChildren().addAll(
// // // //             createGrowthBox("Top Gaining", "Bowling\nAccuracy", "#10b981"),
// // // //             createGrowthBox("Needs Focus", "Power\nHitting", "#ef4444")
// // // //         );

// // // //         rightStats.getChildren().addAll(trendBox, barChart, summaryRow);
        
// // // //         chartsRow.getChildren().addAll(radarChart, rightStats);
// // // //         box.getChildren().addAll(title, chartsRow);
// // // //         return box;
// // // //     }

// // // //     private StackPane buildRadarChartMock() {
// // // //         StackPane pane = new StackPane();
// // // //         pane.setPrefSize(200, 200);
        
// // // //         // Base Pentagons
// // // //         pane.getChildren().add(createPentagon(90, "#f8fafc", "#cbd5e1"));
// // // //         pane.getChildren().add(createPentagon(60, "transparent", "#e2e8f0"));
// // // //         pane.getChildren().add(createPentagon(30, "transparent", "#e2e8f0"));

// // // //         // Data Polygon
// // // //         Polygon dataPoly = new Polygon();
// // // //         dataPoly.getPoints().addAll(
// // // //             0.0, -70.0,   // Technique (High)
// // // //             60.0, -10.0,  // Power (Med)
// // // //             40.0, 60.0,   // Reflex (Med-High)
// // // //             -30.0, 50.0,  // Stamina (Low)
// // // //             -80.0, -20.0  // Accuracy (High)
// // // //         );
// // // //         dataPoly.setFill(Color.web("rgba(16, 185, 129, 0.4)"));
// // // //         dataPoly.setStroke(Color.web("#10b981"));
// // // //         dataPoly.setStrokeWidth(2);
// // // //         pane.getChildren().add(dataPoly);

// // // //         // Labels
// // // //         pane.getChildren().addAll(
// // // //             positionLabel("TECHNIQUE", 0, -105),
// // // //             positionLabel("POWER", 95, -20),
// // // //             positionLabel("REFLEX", 65, 90),
// // // //             positionLabel("STAMINA", -65, 90),
// // // //             positionLabel("ACCURACY", -95, -20)
// // // //         );

// // // //         return pane;
// // // //     }

// // // //     private Polygon createPentagon(double radius, String fillHex, String strokeHex) {
// // // //         Polygon p = new Polygon();
// // // //         for (int i = 0; i < 5; i++) {
// // // //             double angle = Math.toRadians(-90 + i * 72);
// // // //             p.getPoints().addAll(radius * Math.cos(angle), radius * Math.sin(angle));
// // // //         }
// // // //         p.setFill(Color.web(fillHex));
// // // //         p.setStroke(Color.web(strokeHex));
// // // //         return p;
// // // //     }

// // // //     private Label positionLabel(String text, double tx, double ty) {
// // // //         Label l = new Label(text);
// // // //         l.setStyle("-fx-font-size: 10px; -fx-text-fill: #475569;");
// // // //         l.setTranslateX(tx);
// // // //         l.setTranslateY(ty);
// // // //         return l;
// // // //     }

// // // //     private VBox createGrowthBox(String title, String val, String valColor) {
// // // //         VBox box = new VBox(5);
// // // //         box.setPadding(new Insets(10, 15, 10, 15));
// // // //         box.setStyle("-fx-background-color: #f8fafc; -fx-background-radius: 8;");
// // // //         Label t = new Label(title);
// // // //         t.setStyle("-fx-font-size: 11px; -fx-text-fill: #64748b;");
// // // //         Label v = new Label(val);
// // // //         v.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: " + valColor + ";");
// // // //         box.getChildren().addAll(t, v);
// // // //         return box;
// // // //     }

// // // //     // --- RIGHT COLUMN COMPONENTS ---
// // // //     private VBox buildScheduleSection() {
// // // //         VBox section = new VBox(15);
        
// // // //         HBox header = new HBox();
// // // //         Label title = new Label("Today's Schedule");
// // // //         title.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: #334155;");
// // // //         Region spacer = new Region(); HBox.setHgrow(spacer, Priority.ALWAYS);
// // // //         Label calIcon = new Label("📅");
// // // //         calIcon.setStyle("-fx-text-fill: #10b981; -fx-font-size: 16px;");
// // // //         header.getChildren().addAll(title, spacer, calIcon);

// // // //         VBox list = new VBox(15);
// // // //         list.getChildren().addAll(
// // // //             createScheduleItem("16:00", "PM", "Fast Bowling Mastery", "Coach: Rahul Dravid • Lane 4", true),
// // // //             createScheduleItem("18:30", "PM", "Recovery & Yoga", "Gym Zone B • Session 12", false)
// // // //         );

// // // //         section.getChildren().addAll(header, list);
// // // //         return section;
// // // //     }

// // // //     private HBox createScheduleItem(String time, String ampm, String title, String subtitle, boolean isActive) {
// // // //         HBox item = new HBox(15);
// // // //         item.setAlignment(Pos.CENTER_LEFT);
// // // //         item.setPadding(new Insets(15));
// // // //         item.setStyle("-fx-background-color: " + (isActive ? "#f0fdf4" : "white") + "; -fx-background-radius: 12; -fx-border-color: " + (isActive ? "transparent" : "#f1f5f9") + "; -fx-border-radius: 12;");
        
// // // //         if (isActive) {
// // // //             item.setStyle(item.getStyle() + "-fx-border-width: 0 0 0 4; -fx-border-color: #10b981;");
// // // //         }

// // // //         VBox timeBox = new VBox(0);
// // // //         timeBox.setAlignment(Pos.CENTER);
// // // //         Label t = new Label(time);
// // // //         t.setStyle("-fx-font-weight: bold; -fx-font-size: 15px; -fx-text-fill: #0f172a;");
// // // //         Label ap = new Label(ampm);
// // // //         ap.setStyle("-fx-font-weight: bold; -fx-font-size: 12px; -fx-text-fill: " + (isActive ? "#10b981" : "#94a3b8") + ";");
// // // //         timeBox.getChildren().addAll(t, ap);

// // // //         VBox dataBox = new VBox(3);
// // // //         Label titleLbl = new Label(title);
// // // //         titleLbl.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: #0f172a;");
// // // //         Label subLbl = new Label(subtitle);
// // // //         subLbl.setStyle("-fx-font-size: 12px; -fx-text-fill: #64748b;");
// // // //         dataBox.getChildren().addAll(titleLbl, subLbl);

// // // //         item.getChildren().addAll(timeBox, dataBox);
// // // //         return item;
// // // //     }

// // // //     private VBox buildAIInsightsSection() {
// // // //         VBox card = new VBox(20);
// // // //         card.setPadding(new Insets(25));
// // // //         card.setStyle("-fx-background-color: #0f172a; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 20, 0, 0, 8);");

// // // //         HBox header = new HBox(10);
// // // //         header.setAlignment(Pos.CENTER_LEFT);
// // // //         Label icon = new Label("🧠");
// // // //         Label title = new Label("AI Training Insights");
// // // //         title.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 15px;");
// // // //         header.getChildren().addAll(icon, title);

// // // //         Label quote = new Label("\"Aashish, your wrist position on the off-drive has shifted 3° inward. Today, focus on maintaining a high elbow finish to stabilize your shot direction.\"");
// // // //         quote.setWrapText(true);
// // // //         quote.setStyle("-fx-text-fill: #cbd5e1; -fx-font-size: 13px; -fx-font-style: italic; -fx-line-spacing: 5px;");

// // // //         VBox plansBox = new VBox(10);
// // // //         Label planTitle = new Label("ACTIVE PLANS");
// // // //         planTitle.setStyle("-fx-text-fill: #34d399; -fx-font-size: 11px; -fx-font-weight: bold; -fx-letter-spacing: 1px;");
        
// // // //         plansBox.getChildren().addAll(
// // // //             planTitle,
// // // //             createDarkPlanRow("Power Hitting Fundamentals", "75%", true),
// // // //             createDarkPlanRow("Reverse Swing Mastery", "Coming Soon", false)
// // // //         );

// // // //         Button vrBtn = new Button("Launch VR Simulation");
// // // //         vrBtn.setMaxWidth(Double.MAX_VALUE);
// // // //         vrBtn.setStyle("-fx-background-color: #059669; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 12; -fx-background-radius: 8; -fx-cursor: hand;");

// // // //         card.getChildren().addAll(header, quote, plansBox, vrBtn);
// // // //         return card;
// // // //     }

// // // //     private HBox createDarkPlanRow(String title, String val, boolean isGreenVal) {
// // // //         HBox row = new HBox();
// // // //         Label t = new Label(title);
// // // //         t.setStyle("-fx-text-fill: white; -fx-font-size: 12px;");
// // // //         Region spacer = new Region(); HBox.setHgrow(spacer, Priority.ALWAYS);
// // // //         Label v = new Label(val);
// // // //         v.setStyle("-fx-font-size: 12px; -fx-text-fill: " + (isGreenVal ? "#34d399" : "#64748b") + ";");
// // // //         row.getChildren().addAll(t, spacer, v);
// // // //         return row;
// // // //     }

// // // //     private HBox buildWeatherEquipmentRow() {
// // // //         HBox row = new HBox(15);
        
// // // //         VBox weather = new VBox(5);
// // // //         weather.setAlignment(Pos.CENTER);
// // // //         weather.setPadding(new Insets(15));
// // // //         weather.setStyle("-fx-background-color: white; -fx-background-radius: 12; -fx-border-color: #f1f5f9; -fx-border-radius: 12;");
// // // //         Label wIcon = new Label("☀"); wIcon.setStyle("-fx-text-fill: #10b981; -fx-font-size: 20px;");
// // // //         Label wTemp = new Label("28°C Clear"); wTemp.setStyle("-fx-font-weight: bold; -fx-font-size: 12px;");
// // // //         Label wSub = new Label("Perfect for Nets"); wSub.setStyle("-fx-font-size: 10px; -fx-text-fill: #64748b;");
// // // //         weather.getChildren().addAll(wIcon, wTemp, wSub);
// // // //         HBox.setHgrow(weather, Priority.ALWAYS);

// // // //         VBox equip = new VBox(5);
// // // //         equip.setAlignment(Pos.CENTER);
// // // //         equip.setPadding(new Insets(15));
// // // //         equip.setStyle("-fx-background-color: white; -fx-background-radius: 12; -fx-border-color: #f1f5f9; -fx-border-radius: 12;");
// // // //         Label eIcon = new Label("🏏"); eIcon.setStyle("-fx-text-fill: #10b981; -fx-font-size: 20px;");
// // // //         Label eTitle = new Label("Equipment"); eTitle.setStyle("-fx-font-weight: bold; -fx-font-size: 12px;");
// // // //         Label eSub = new Label("2 items needed"); eSub.setStyle("-fx-font-size: 10px; -fx-text-fill: #64748b;");
// // // //         equip.getChildren().addAll(eIcon, eTitle, eSub);
// // // //         HBox.setHgrow(equip, Priority.ALWAYS);

// // // //         row.getChildren().addAll(weather, equip);
// // // //         return row;
// // // //     }

// // // //     private VBox buildMessagesSection() {
// // // //         VBox section = new VBox(15);
        
// // // //         Label title = new Label("COACH MESSAGES");
// // // //         title.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #64748b; -fx-letter-spacing: 1px;");

// // // //         VBox list = new VBox(15);
// // // //         list.getChildren().addAll(
// // // //             createMessageItem("RD", "Rahul Dravid", "Check your backlift video from yesterday's session.", "#10b981"),
// // // //             createMessageItem("SM", "S. Malinga", "Great yorker consistency. Let's try slow-balls next.", "#6366f1")
// // // //         );

// // // //         section.getChildren().addAll(title, list);
// // // //         return section;
// // // //     }

// // // //     private HBox createMessageItem(String initials, String name, String msg, String color) {
// // // //         HBox item = new HBox(15);
        
// // // //         Label initLbl = new Label(initials);
// // // //         initLbl.setAlignment(Pos.CENTER);
// // // //         initLbl.setMinSize(36, 36);
// // // //         initLbl.setStyle("-fx-background-color: " + color + "33; -fx-text-fill: " + color + "; -fx-font-weight: bold; -fx-font-size: 12px; -fx-background-radius: 18;");

// // // //         VBox texts = new VBox(3);
// // // //         Label nameLbl = new Label(name);
// // // //         nameLbl.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
// // // //         Label msgLbl = new Label(msg);
// // // //         msgLbl.setWrapText(true);
// // // //         msgLbl.setStyle("-fx-font-size: 12px; -fx-text-fill: #64748b;");
// // // //         texts.getChildren().addAll(nameLbl, msgLbl);

// // // //         item.getChildren().addAll(initLbl, texts);
// // // //         return item;
// // // //     }
// // // // }

// // // package com.athlixcore.view.player;

// // // import javafx.geometry.Insets;
// // // import javafx.geometry.Pos;
// // // import javafx.scene.Node;
// // // import javafx.scene.control.Button;
// // // import javafx.scene.control.Label;
// // // import javafx.scene.control.ScrollPane;
// // // import javafx.scene.control.TextField;
// // // import javafx.scene.image.Image;
// // // import javafx.scene.image.ImageView;
// // // import javafx.scene.layout.*;
// // // import javafx.scene.paint.Color;
// // // import javafx.scene.shape.Circle;
// // // import javafx.scene.shape.Polygon;
// // // import javafx.scene.shape.Rectangle;

// // // public class Traning_Fitness {

// // //     private StackPane rootContainer;

// // //     public Node getView() {
// // //         if (rootContainer == null) {
// // //             rootContainer = new StackPane();
// // //             rootContainer.setStyle("-fx-background-color: #f8fafc;");

// // //             VBox mainLayout = new VBox(25);
// // //             mainLayout.setPadding(new Insets(20, 30, 40, 30));

// // //             // Build Sections
// // //             mainLayout.getChildren().addAll(
// // //                 buildTopBar(),
// // //                 buildHeroBanner(),
// // //                 buildStatsRow(),
// // //                 buildMainSplitArea()
// // //             );

// // //             ScrollPane scrollPane = new ScrollPane(mainLayout);
// // //             scrollPane.setFitToWidth(true);
// // //             scrollPane.setStyle("-fx-background-color: transparent; -fx-background: #f8fafc;");
// // //             scrollPane.getStylesheets().add("data:text/css,.scroll-pane > .viewport { -fx-background-color: transparent; }");

// // //             rootContainer.getChildren().add(scrollPane);
// // //         }
// // //         return rootContainer;
// // //     }

// // //     // --- 1. TOP NAVIGATION BAR ---
// // //     private HBox buildTopBar() {
// // //         HBox topBar = new HBox(20);
// // //         topBar.setAlignment(Pos.CENTER_LEFT);

// // //         // Search Bar
// // //         HBox searchBox = new HBox(10);
// // //         searchBox.setAlignment(Pos.CENTER_LEFT);
// // //         searchBox.setStyle("-fx-background-color: white; -fx-background-radius: 20; -fx-padding: 8 15; -fx-border-color: #e2e8f0; -fx-border-radius: 20;");
// // //         Label searchIcon = new Label("🔍");
// // //         searchIcon.setStyle("-fx-text-fill: #94a3b8;");
// // //         TextField searchField = new TextField();
// // //         searchField.setPromptText("Search training modules, coaches, or stats...");
// // //         searchField.setStyle("-fx-background-color: transparent; -fx-border-width: 0; -fx-pref-width: 300px;");
// // //         searchBox.getChildren().addAll(searchIcon, searchField);

// // //         Region spacer = new Region();
// // //         HBox.setHgrow(spacer, Priority.ALWAYS);

// // //         // Navigation Links
// // //         HBox navLinks = new HBox(25);
// // //         navLinks.setAlignment(Pos.CENTER);
// // //         navLinks.getChildren().addAll(
// // //             createNavLink("Performance", false),
// // //             createNavLink("Team", true), // Active tab based on image
// // //             createNavLink("Resources", false)
// // //         );

// // //         // Icons & Avatar
// // //         Label bellIcon = new Label("🔔");
// // //         bellIcon.setStyle("-fx-font-size: 18px; -fx-cursor: hand;");
// // //         Label settingsIcon = new Label("⚙");
// // //         settingsIcon.setStyle("-fx-font-size: 18px; -fx-cursor: hand;");

// // //         Circle avatar = new Circle(18);
// // //         try {
// // //             avatar.setFill(new javafx.scene.paint.ImagePattern(new Image("https://randomuser.me/api/portraits/men/32.jpg")));
// // //         } catch (Exception e) {
// // //             avatar.setFill(Color.GRAY);
// // //         }

// // //         topBar.getChildren().addAll(searchBox, spacer, navLinks, bellIcon, settingsIcon, avatar);
// // //         return topBar;
// // //     }

// // //     private VBox createNavLink(String text, boolean isActive) {
// // //         VBox box = new VBox(5);
// // //         box.setAlignment(Pos.CENTER);
// // //         Label lbl = new Label(text);
// // //         lbl.setStyle(isActive ? "-fx-font-weight: bold; -fx-text-fill: #0f172a;" : "-fx-font-weight: normal; -fx-text-fill: #64748b;");
// // //         lbl.setStyle(lbl.getStyle() + "-fx-font-size: 14px; -fx-cursor: hand;");
        
// // //         Region indicator = new Region();
// // //         indicator.setPrefSize(30, 3);
// // //         indicator.setStyle(isActive ? "-fx-background-color: #10b981; -fx-background-radius: 2;" : "-fx-background-color: transparent;");
        
// // //         box.getChildren().addAll(lbl, indicator);
// // //         return box;
// // //     }

// // //     // --- 2. HERO BANNER ---
// // //     private StackPane buildHeroBanner() {
// // //         StackPane bannerPane = new StackPane();
// // //         bannerPane.setMinHeight(220);
// // //         bannerPane.setStyle("-fx-background-radius: 20; -fx-border-radius: 20; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 20, 0, 0, 5);");

// // //         // Background Layer (Gradient mimicking the dark indoor nets photo)
// // //         Region bg = new Region();
// // //         bg.setStyle("-fx-background-color: linear-gradient(to right, #1e293b, #0f172a); -fx-background-radius: 20;");
        
// // //         // Content Layer
// // //         HBox contentLayout = new HBox(30);
// // //         contentLayout.setAlignment(Pos.CENTER_LEFT);
// // //         contentLayout.setPadding(new Insets(30, 40, 30, 40));

// // //         // Profile Avatar Ring
// // //         StackPane avatarRing = new StackPane();
// // //         Circle outerRing = new Circle(65, Color.TRANSPARENT);
// // //         outerRing.setStroke(Color.web("#10b981"));
// // //         outerRing.setStrokeWidth(3);
        
// // //         Circle innerAvatar = new Circle(55);
// // //         try {
// // //             innerAvatar.setFill(new javafx.scene.paint.ImagePattern(new Image("https://randomuser.me/api/portraits/men/32.jpg")));
// // //         } catch (Exception e) { innerAvatar.setFill(Color.DARKGRAY); }
// // //         avatarRing.getChildren().addAll(outerRing, innerAvatar);

// // //         // Text & Buttons
// // //         VBox textLayout = new VBox(15);
// // //         textLayout.setAlignment(Pos.CENTER_LEFT);
        
// // //         HBox nameRow = new HBox(15);
// // //         nameRow.setAlignment(Pos.CENTER_LEFT);
// // //         Label nameLbl = new Label("Aashish Mohan Bhosale");
// // //         nameLbl.setStyle("-fx-font-size: 26px; -fx-font-weight: bold; -fx-text-fill: white;");
// // //         Label levelBadge = new Label("Pro Level 8");
// // //         levelBadge.setStyle("-fx-background-color: rgba(16,185,129,0.2); -fx-text-fill: #34d399; -fx-font-weight: bold; -fx-padding: 4 12; -fx-background-radius: 20; -fx-border-color: #10b981; -fx-border-radius: 20;");
// // //         nameRow.getChildren().addAll(nameLbl, levelBadge);

// // //         Label quoteLbl = new Label("\"The harder you work in the nets, the easier it is on the pitch.\"");
// // //         quoteLbl.setStyle("-fx-font-size: 14px; -fx-font-style: italic; -fx-text-fill: #94a3b8;");

// // //         HBox actionsRow = new HBox(15);
// // //         actionsRow.setAlignment(Pos.CENTER_LEFT);

// // //         VBox aiScoreBox = new VBox(2);
// // //         aiScoreBox.setStyle("-fx-background-color: rgba(255,255,255,0.1); -fx-padding: 10 20; -fx-background-radius: 10;");
// // //         Label aiTitle = new Label("AI Improvement Score");
// // //         aiTitle.setStyle("-fx-text-fill: #cbd5e1; -fx-font-size: 11px;");
// // //         Label aiValue = new Label("+12.4%");
// // //         aiValue.setStyle("-fx-text-fill: #34d399; -fx-font-weight: bold; -fx-font-size: 16px;");
// // //         aiScoreBox.getChildren().addAll(aiTitle, aiValue);

// // //         Button startBtn = new Button("Start\nTraining");
// // //         startBtn.setStyle("-fx-background-color: #10b981; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 8 25; -fx-text-alignment: center; -fx-cursor: hand;");
        
// // //         Button calBtn = new Button("Training\nCalendar");
// // //         calBtn.setStyle("-fx-background-color: rgba(255,255,255,0.1); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 8 20; -fx-text-alignment: center; -fx-cursor: hand;");

// // //         Button bookBtn = new Button("Book\nCoach");
// // //         bookBtn.setStyle("-fx-background-color: rgba(255,255,255,0.1); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 8 20; -fx-text-alignment: center; -fx-cursor: hand;");

// // //         actionsRow.getChildren().addAll(aiScoreBox, startBtn, calBtn, bookBtn);
// // //         textLayout.getChildren().addAll(nameRow, quoteLbl, actionsRow);
        
// // //         contentLayout.getChildren().addAll(avatarRing, textLayout);
// // //         bannerPane.getChildren().addAll(bg, contentLayout);
        
// // //         return bannerPane;
// // //     }

// // //     // --- 3. STATS ROW ---
// // //     private HBox buildStatsRow() {
// // //         HBox row = new HBox(20);
// // //         row.getChildren().addAll(
// // //             createCircularStatCard("Overall\nProgress", "82%", 0.82),
// // //             createIconStatCard("Sessions\nCompleted", "14", "📅"),
// // //             createIconStatCard("Practice Hours", "48h", "⏱"),
// // //             createIconStatCardWithGreen("AI Training\nScore", "94", "📊")
// // //         );
// // //         for(Node n : row.getChildren()) HBox.setHgrow(n, Priority.ALWAYS);
// // //         return row;
// // //     }

// // //     private HBox createCircularStatCard(String title, String value, double progress) {
// // //         HBox card = buildBaseCard();
// // //         VBox texts = new VBox(5, createStatTitle(title), createStatValue(value));
        
// // //         StackPane circlePane = new StackPane();
// // //         Circle bgCircle = new Circle(20, Color.TRANSPARENT);
// // //         bgCircle.setStroke(Color.web("#e2e8f0"));
// // //         bgCircle.setStrokeWidth(4);
        
// // //         Circle progCircle = new Circle(20, Color.TRANSPARENT);
// // //         progCircle.setStroke(Color.web("#10b981"));
// // //         progCircle.setStrokeWidth(4);
// // //         progCircle.getStrokeDashArray().addAll(progress * 125, 125.0); // Rough circumference approx
        
// // //         Label valLbl = new Label(value);
// // //         valLbl.setStyle("-fx-font-size: 11px; -fx-font-weight: bold;");
// // //         circlePane.getChildren().addAll(bgCircle, progCircle, valLbl);

// // //         Region spacer = new Region(); HBox.setHgrow(spacer, Priority.ALWAYS);
// // //         card.getChildren().addAll(texts, spacer, circlePane);
// // //         return card;
// // //     }

// // //     private HBox createIconStatCard(String title, String value, String icon) {
// // //         HBox card = buildBaseCard();
// // //         VBox texts = new VBox(5, createStatTitle(title), createStatValue(value));
// // //         Region spacer = new Region(); HBox.setHgrow(spacer, Priority.ALWAYS);
// // //         Label iconLbl = new Label(icon);
// // //         iconLbl.setStyle("-fx-font-size: 24px; -fx-text-fill: #94a3b8;");
// // //         card.getChildren().addAll(texts, spacer, iconLbl);
// // //         return card;
// // //     }

// // //     private HBox createIconStatCardWithGreen(String title, String value, String icon) {
// // //         HBox card = buildBaseCard();
// // //         VBox texts = new VBox(5, createStatTitle(title), createStatValue(value, "#10b981"));
// // //         Region spacer = new Region(); HBox.setHgrow(spacer, Priority.ALWAYS);
        
// // //         StackPane iconPane = new StackPane();
// // //         iconPane.setStyle("-fx-background-color: #d1fae5; -fx-background-radius: 8; -fx-padding: 8;");
// // //         Label iconLbl = new Label(icon);
// // //         iconLbl.setStyle("-fx-font-size: 20px; -fx-text-fill: #10b981;");
// // //         iconPane.getChildren().add(iconLbl);
        
// // //         card.getChildren().addAll(texts, spacer, iconPane);
// // //         return card;
// // //     }

// // //     private HBox buildBaseCard() {
// // //         HBox card = new HBox();
// // //         card.setAlignment(Pos.CENTER_LEFT);
// // //         card.setPadding(new Insets(20));
// // //         card.setStyle("-fx-background-color: white; -fx-background-radius: 12; -fx-border-color: #f1f5f9; -fx-border-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
// // //         return card;
// // //     }
    
// // //     private Label createStatTitle(String text) {
// // //         Label l = new Label(text);
// // //         l.setStyle("-fx-font-size: 13px; -fx-text-fill: #64748b;");
// // //         return l;
// // //     }
// // //     private Label createStatValue(String text) { return createStatValue(text, "#0f172a"); }
// // //     private Label createStatValue(String text, String color) {
// // //         Label l = new Label(text);
// // //         l.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: " + color + ";");
// // //         return l;
// // //     }

// // //     // --- 4. MAIN SPLIT CONTENT ---
// // //     private HBox buildMainSplitArea() {
// // //         HBox splitLayout = new HBox(30);

// // //         // LEFT COLUMN (Categories & Analytics)
// // //         VBox leftCol = new VBox(30);
// // //         HBox.setHgrow(leftCol, Priority.ALWAYS);
// // //         leftCol.getChildren().addAll(buildCategoriesSection(), buildAnalyticsSection());

// // //         // RIGHT COLUMN (Schedule, AI, Widgets)
// // //         VBox rightCol = new VBox(25);
// // //         rightCol.setPrefWidth(320);
// // //         rightCol.setMinWidth(320);
// // //         rightCol.getChildren().addAll(
// // //             buildScheduleSection(),
// // //             buildAIInsightsSection(),
// // //             buildWeatherEquipmentRow(),
// // //             buildMessagesSection()
// // //         );

// // //         splitLayout.getChildren().addAll(leftCol, rightCol);
// // //         return splitLayout;
// // //     }

// // //     // --- LEFT COLUMN COMPONENTS ---
// // //     private VBox buildCategoriesSection() {
// // //         VBox section = new VBox(15);
        
// // //         HBox header = new HBox();
// // //         Label title = new Label("Training Categories");
// // //         title.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: #334155;");
// // //         Region spacer = new Region(); HBox.setHgrow(spacer, Priority.ALWAYS);
// // //         Label viewAll = new Label("View All Drills");
// // //         viewAll.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-text-fill: #10b981; -fx-cursor: hand;");
// // //         header.getChildren().addAll(title, spacer, viewAll);

// // //         GridPane grid = new GridPane();
// // //         grid.setHgap(15); grid.setVgap(15);
// // //         ColumnConstraints cc = new ColumnConstraints(); cc.setPercentWidth(33.33);
// // //         grid.getColumnConstraints().addAll(cc, cc, cc);

// // //         grid.add(createImageCard("Batting Practice", "12 Drills Available", "#4f46e5"), 0, 0);
// // //         grid.add(createImageCard("Bowling Practice", "8 Drills Available", "#b45309"), 1, 0);
// // //         grid.add(createImageCard("Strength & Agility", "15 High-Intensity Plans", "#15803d"), 2, 0);
// // //         grid.add(createImageCard("Fielding Practice", "6 Expert Sessions", "#047857"), 0, 1);
// // //         grid.add(createImageCard("Video Analysis", "Scan & Compare", "#0f172a"), 1, 1);
        
// // //         // Custom Drill Card (Dashed)
// // //         VBox customCard = new VBox(10);
// // //         customCard.setAlignment(Pos.CENTER);
// // //         customCard.setMinHeight(130);
// // //         customCard.setStyle("-fx-background-color: #f8fafc; -fx-border-color: #cbd5e1; -fx-border-style: dashed; -fx-border-width: 2; -fx-background-radius: 12; -fx-border-radius: 12; -fx-cursor: hand;");
// // //         Label plusIcon = new Label("⊕");
// // //         plusIcon.setStyle("-fx-font-size: 24px; -fx-text-fill: #64748b;");
// // //         Label customTxt = new Label("Custom Drill");
// // //         customTxt.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-text-fill: #64748b;");
// // //         customCard.getChildren().addAll(plusIcon, customTxt);
// // //         grid.add(customCard, 2, 1);

// // //         section.getChildren().addAll(header, grid);
// // //         return section;
// // //     }

// // //     private StackPane createImageCard(String title, String subtitle, String fallbackColor) {
// // //         StackPane card = new StackPane();
// // //         card.setMinHeight(130);
// // //         card.setStyle("-fx-background-color: " + fallbackColor + "; -fx-background-radius: 12; -fx-border-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0, 0, 4);");

// // //         // Gradient Overlay to ensure text readability
// // //         Region overlay = new Region();
// // //         overlay.setStyle("-fx-background-color: linear-gradient(to top, rgba(0,0,0,0.9), transparent); -fx-background-radius: 12;");

// // //         VBox textData = new VBox(3);
// // //         textData.setAlignment(Pos.BOTTOM_LEFT);
// // //         textData.setPadding(new Insets(15));
        
// // //         Label tLbl = new Label(title);
// // //         tLbl.setStyle("-fx-font-weight: bold; -fx-font-size: 15px; -fx-text-fill: white;");
// // //         Label sLbl = new Label(subtitle);
// // //         sLbl.setStyle("-fx-font-size: 12px; -fx-text-fill: #34d399;");
// // //         textData.getChildren().addAll(tLbl, sLbl);

// // //         card.getChildren().addAll(overlay, textData);
// // //         return card;
// // //     }

// // //     private VBox buildAnalyticsSection() {
// // //         VBox box = new VBox(20);
// // //         box.setPadding(new Insets(25));
// // //         box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.04), 15, 0, 0, 5);");

// // //         Label title = new Label("Skill Development Analytics");
// // //         title.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: #334155;");

// // //         HBox chartsRow = new HBox(30);
// // //         chartsRow.setAlignment(Pos.CENTER);

// // //         // 1. Radar Chart (Custom Drawn)
// // //         StackPane radarChart = buildRadarChartMock();
        
// // //         // 2. Bar Chart & Stats
// // //         VBox rightStats = new VBox(15);
// // //         rightStats.setAlignment(Pos.CENTER_LEFT);
        
// // //         Label trendTitle = new Label("SKILL GROWTH TREND");
// // //         trendTitle.setStyle("-fx-font-size: 11px; -fx-text-fill: #94a3b8; -fx-font-weight: bold;");
// // //         Label trendVal = new Label("+18% this month");
// // //         trendVal.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
// // //         VBox trendBox = new VBox(2, trendTitle, trendVal);

// // //         // Fake Bar Chart
// // //         HBox barChart = new HBox(8);
// // //         barChart.setAlignment(Pos.BOTTOM_CENTER);
// // //         barChart.setMinHeight(80);
// // //         double[] heights = {30, 45, 20, 60, 50, 70, 90};
// // //         for (int i = 0; i < heights.length; i++) {
// // //             Rectangle bar = new Rectangle(18, heights[i]);
// // //             bar.setArcWidth(4); bar.setArcHeight(4);
// // //             bar.setFill(i < 3 ? Color.web("#e2e8f0") : Color.web("#10b981"));
// // //             barChart.getChildren().add(bar);
// // //         }

// // //         // Summary Boxes
// // //         HBox summaryRow = new HBox(10);
// // //         summaryRow.getChildren().addAll(
// // //             createGrowthBox("Top Gaining", "Bowling\nAccuracy", "#10b981"),
// // //             createGrowthBox("Needs Focus", "Power\nHitting", "#ef4444")
// // //         );

// // //         rightStats.getChildren().addAll(trendBox, barChart, summaryRow);
        
// // //         chartsRow.getChildren().addAll(radarChart, rightStats);
// // //         box.getChildren().addAll(title, chartsRow);
// // //         return box;
// // //     }

// // //     private StackPane buildRadarChartMock() {
// // //         StackPane pane = new StackPane();
// // //         pane.setPrefSize(200, 200);
        
// // //         // Base Pentagons
// // //         pane.getChildren().add(createPentagon(90, "#f8fafc", "#cbd5e1"));
// // //         pane.getChildren().add(createPentagon(60, "transparent", "#e2e8f0"));
// // //         pane.getChildren().add(createPentagon(30, "transparent", "#e2e8f0"));

// // //         // Data Polygon
// // //         Polygon dataPoly = new Polygon();
// // //         dataPoly.getPoints().addAll(
// // //             0.0, -70.0,   // Technique (High)
// // //             60.0, -10.0,  // Power (Med)
// // //             40.0, 60.0,   // Reflex (Med-High)
// // //             -30.0, 50.0,  // Stamina (Low)
// // //             -80.0, -20.0  // Accuracy (High)
// // //         );
// // //         dataPoly.setFill(Color.web("rgba(16, 185, 129, 0.4)"));
// // //         dataPoly.setStroke(Color.web("#10b981"));
// // //         dataPoly.setStrokeWidth(2);
// // //         pane.getChildren().add(dataPoly);

// // //         // Labels
// // //         pane.getChildren().addAll(
// // //             positionLabel("TECHNIQUE", 0, -105),
// // //             positionLabel("POWER", 95, -20),
// // //             positionLabel("REFLEX", 65, 90),
// // //             positionLabel("STAMINA", -65, 90),
// // //             positionLabel("ACCURACY", -95, -20)
// // //         );

// // //         return pane;
// // //     }

// // //     private Polygon createPentagon(double radius, String fillHex, String strokeHex) {
// // //         Polygon p = new Polygon();
// // //         for (int i = 0; i < 5; i++) {
// // //             double angle = Math.toRadians(-90 + i * 72);
// // //             p.getPoints().addAll(radius * Math.cos(angle), radius * Math.sin(angle));
// // //         }
// // //         p.setFill(Color.web(fillHex));
// // //         p.setStroke(Color.web(strokeHex));
// // //         return p;
// // //     }

// // //     private Label positionLabel(String text, double tx, double ty) {
// // //         Label l = new Label(text);
// // //         l.setStyle("-fx-font-size: 10px; -fx-text-fill: #475569;");
// // //         l.setTranslateX(tx);
// // //         l.setTranslateY(ty);
// // //         return l;
// // //     }

// // //     private VBox createGrowthBox(String title, String val, String valColor) {
// // //         VBox box = new VBox(5);
// // //         box.setPadding(new Insets(10, 15, 10, 15));
// // //         box.setStyle("-fx-background-color: #f8fafc; -fx-background-radius: 8;");
// // //         Label t = new Label(title);
// // //         t.setStyle("-fx-font-size: 11px; -fx-text-fill: #64748b;");
// // //         Label v = new Label(val);
// // //         v.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: " + valColor + ";");
// // //         box.getChildren().addAll(t, v);
// // //         return box;
// // //     }

// // //     // --- RIGHT COLUMN COMPONENTS ---
// // //     private VBox buildScheduleSection() {
// // //         VBox section = new VBox(15);
        
// // //         HBox header = new HBox();
// // //         Label title = new Label("Today's Schedule");
// // //         title.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: #334155;");
// // //         Region spacer = new Region(); HBox.setHgrow(spacer, Priority.ALWAYS);
// // //         Label calIcon = new Label("📅");
// // //         calIcon.setStyle("-fx-text-fill: #10b981; -fx-font-size: 16px;");
// // //         header.getChildren().addAll(title, spacer, calIcon);

// // //         VBox list = new VBox(15);
// // //         list.getChildren().addAll(
// // //             createScheduleItem("16:00", "PM", "Fast Bowling Mastery", "Coach: Rahul Dravid • Lane 4", true),
// // //             createScheduleItem("18:30", "PM", "Recovery & Yoga", "Gym Zone B • Session 12", false)
// // //         );

// // //         section.getChildren().addAll(header, list);
// // //         return section;
// // //     }

// // //     private HBox createScheduleItem(String time, String ampm, String title, String subtitle, boolean isActive) {
// // //         HBox item = new HBox(15);
// // //         item.setAlignment(Pos.CENTER_LEFT);
// // //         item.setPadding(new Insets(15));
// // //         item.setStyle("-fx-background-color: " + (isActive ? "#f0fdf4" : "white") + "; -fx-background-radius: 12; -fx-border-color: " + (isActive ? "transparent" : "#f1f5f9") + "; -fx-border-radius: 12;");
        
// // //         if (isActive) {
// // //             item.setStyle(item.getStyle() + "-fx-border-width: 0 0 0 4; -fx-border-color: #10b981;");
// // //         }

// // //         VBox timeBox = new VBox(0);
// // //         timeBox.setAlignment(Pos.CENTER);
// // //         Label t = new Label(time);
// // //         t.setStyle("-fx-font-weight: bold; -fx-font-size: 15px; -fx-text-fill: #0f172a;");
// // //         Label ap = new Label(ampm);
// // //         ap.setStyle("-fx-font-weight: bold; -fx-font-size: 12px; -fx-text-fill: " + (isActive ? "#10b981" : "#94a3b8") + ";");
// // //         timeBox.getChildren().addAll(t, ap);

// // //         VBox dataBox = new VBox(3);
// // //         Label titleLbl = new Label(title);
// // //         titleLbl.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: #0f172a;");
// // //         Label subLbl = new Label(subtitle);
// // //         subLbl.setStyle("-fx-font-size: 12px; -fx-text-fill: #64748b;");
// // //         dataBox.getChildren().addAll(titleLbl, subLbl);

// // //         item.getChildren().addAll(timeBox, dataBox);
// // //         return item;
// // //     }

// // //     private VBox buildAIInsightsSection() {
// // //         VBox card = new VBox(20);
// // //         card.setPadding(new Insets(25));
// // //         card.setStyle("-fx-background-color: #0f172a; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 20, 0, 0, 8);");

// // //         HBox header = new HBox(10);
// // //         header.setAlignment(Pos.CENTER_LEFT);
// // //         Label icon = new Label("🧠");
// // //         Label title = new Label("AI Training Insights");
// // //         title.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 15px;");
// // //         header.getChildren().addAll(icon, title);

// // //         Label quote = new Label("\"Aashish, your wrist position on the off-drive has shifted 3° inward. Today, focus on maintaining a high elbow finish to stabilize your shot direction.\"");
// // //         quote.setWrapText(true);
// // //         quote.setStyle("-fx-text-fill: #cbd5e1; -fx-font-size: 13px; -fx-font-style: italic; -fx-line-spacing: 5px;");

// // //         VBox plansBox = new VBox(10);
// // //         Label planTitle = new Label("ACTIVE PLANS");
// // //         planTitle.setStyle("-fx-text-fill: #34d399; -fx-font-size: 11px; -fx-font-weight: bold; -fx-letter-spacing: 1px;");
        
// // //         plansBox.getChildren().addAll(
// // //             planTitle,
// // //             createDarkPlanRow("Power Hitting Fundamentals", "75%", true),
// // //             createDarkPlanRow("Reverse Swing Mastery", "Coming Soon", false)
// // //         );

// // //         Button vrBtn = new Button("Launch VR Simulation");
// // //         vrBtn.setMaxWidth(Double.MAX_VALUE);
// // //         vrBtn.setStyle("-fx-background-color: #059669; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 12; -fx-background-radius: 8; -fx-cursor: hand;");

// // //         card.getChildren().addAll(header, quote, plansBox, vrBtn);
// // //         return card;
// // //     }

// // //     private HBox createDarkPlanRow(String title, String val, boolean isGreenVal) {
// // //         HBox row = new HBox();
// // //         Label t = new Label(title);
// // //         t.setStyle("-fx-text-fill: white; -fx-font-size: 12px;");
// // //         Region spacer = new Region(); HBox.setHgrow(spacer, Priority.ALWAYS);
// // //         Label v = new Label(val);
// // //         v.setStyle("-fx-font-size: 12px; -fx-text-fill: " + (isGreenVal ? "#34d399" : "#64748b") + ";");
// // //         row.getChildren().addAll(t, spacer, v);
// // //         return row;
// // //     }

// // //     private HBox buildWeatherEquipmentRow() {
// // //         HBox row = new HBox(15);
        
// // //         VBox weather = new VBox(5);
// // //         weather.setAlignment(Pos.CENTER);
// // //         weather.setPadding(new Insets(15));
// // //         weather.setStyle("-fx-background-color: white; -fx-background-radius: 12; -fx-border-color: #f1f5f9; -fx-border-radius: 12;");
// // //         Label wIcon = new Label("☀"); wIcon.setStyle("-fx-text-fill: #10b981; -fx-font-size: 20px;");
// // //         Label wTemp = new Label("28°C Clear"); wTemp.setStyle("-fx-font-weight: bold; -fx-font-size: 12px;");
// // //         Label wSub = new Label("Perfect for Nets"); wSub.setStyle("-fx-font-size: 10px; -fx-text-fill: #64748b;");
// // //         weather.getChildren().addAll(wIcon, wTemp, wSub);
// // //         HBox.setHgrow(weather, Priority.ALWAYS);

// // //         VBox equip = new VBox(5);
// // //         equip.setAlignment(Pos.CENTER);
// // //         equip.setPadding(new Insets(15));
// // //         equip.setStyle("-fx-background-color: white; -fx-background-radius: 12; -fx-border-color: #f1f5f9; -fx-border-radius: 12;");
// // //         Label eIcon = new Label("🏏"); eIcon.setStyle("-fx-text-fill: #10b981; -fx-font-size: 20px;");
// // //         Label eTitle = new Label("Equipment"); eTitle.setStyle("-fx-font-weight: bold; -fx-font-size: 12px;");
// // //         Label eSub = new Label("2 items needed"); eSub.setStyle("-fx-font-size: 10px; -fx-text-fill: #64748b;");
// // //         equip.getChildren().addAll(eIcon, eTitle, eSub);
// // //         HBox.setHgrow(equip, Priority.ALWAYS);

// // //         row.getChildren().addAll(weather, equip);
// // //         return row;
// // //     }

// // //     private VBox buildMessagesSection() {
// // //         VBox section = new VBox(15);
        
// // //         Label title = new Label("COACH MESSAGES");
// // //         title.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #64748b; -fx-letter-spacing: 1px;");

// // //         VBox list = new VBox(15);
// // //         list.getChildren().addAll(
// // //             createMessageItem("RD", "Rahul Dravid", "Check your backlift video from yesterday's session.", "#10b981"),
// // //             createMessageItem("SM", "S. Malinga", "Great yorker consistency. Let's try slow-balls next.", "#6366f1")
// // //         );

// // //         section.getChildren().addAll(title, list);
// // //         return section;
// // //     }

// // //     private HBox createMessageItem(String initials, String name, String msg, String color) {
// // //         HBox item = new HBox(15);
        
// // //         Label initLbl = new Label(initials);
// // //         initLbl.setAlignment(Pos.CENTER);
// // //         initLbl.setMinSize(36, 36);
// // //         initLbl.setStyle("-fx-background-color: " + color + "33; -fx-text-fill: " + color + "; -fx-font-weight: bold; -fx-font-size: 12px; -fx-background-radius: 18;");

// // //         VBox texts = new VBox(3);
// // //         Label nameLbl = new Label(name);
// // //         nameLbl.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
// // //         Label msgLbl = new Label(msg);
// // //         msgLbl.setWrapText(true);
// // //         msgLbl.setStyle("-fx-font-size: 12px; -fx-text-fill: #64748b;");
// // //         texts.getChildren().addAll(nameLbl, msgLbl);

// // //         item.getChildren().addAll(initLbl, texts);
// // //         return item;
// // //     }
// // // }

// // package com.athlixcore.view.player;

// // import javafx.geometry.Insets;
// // import javafx.geometry.Pos;
// // import javafx.scene.Node;
// // import javafx.scene.control.Button;
// // import javafx.scene.control.Label;
// // import javafx.scene.control.ScrollPane;
// // import javafx.scene.control.TextField;
// // import javafx.scene.image.Image;
// // import javafx.scene.image.ImageView;
// // import javafx.scene.layout.*;
// // import javafx.scene.paint.Color;
// // import javafx.scene.shape.Circle;
// // import javafx.scene.shape.Polygon;
// // import javafx.scene.shape.Rectangle;

// // public class Traning_dashboard {

// //     private StackPane rootContainer;

// //     public Node getView() {
// //         if (rootContainer == null) {
// //             rootContainer = new StackPane();
// //             rootContainer.setStyle("-fx-background-color: #f8fafc;");

// //             VBox mainLayout = new VBox(25);
// //             mainLayout.setPadding(new Insets(20, 30, 40, 30));

// //             // Build Sections
// //             mainLayout.getChildren().addAll(
// //                 buildTopBar(),
// //                 buildHeroBanner(),
// //                 buildStatsRow(),
// //                 buildMainSplitArea()
// //             );

// //             ScrollPane scrollPane = new ScrollPane(mainLayout);
// //             scrollPane.setFitToWidth(true);
// //             scrollPane.setStyle("-fx-background-color: transparent; -fx-background: #f8fafc;");
// //             scrollPane.getStylesheets().add("data:text/css,.scroll-pane > .viewport { -fx-background-color: transparent; }");

// //             rootContainer.getChildren().add(scrollPane);
// //         }
// //         return rootContainer;
// //     }

// //     // --- 1. TOP NAVIGATION BAR ---
// //     private HBox buildTopBar() {
// //         HBox topBar = new HBox(20);
// //         topBar.setAlignment(Pos.CENTER_LEFT);

// //         // Search Bar
// //         HBox searchBox = new HBox(10);
// //         searchBox.setAlignment(Pos.CENTER_LEFT);
// //         searchBox.setStyle("-fx-background-color: white; -fx-background-radius: 20; -fx-padding: 8 15; -fx-border-color: #e2e8f0; -fx-border-radius: 20;");
// //         Label searchIcon = new Label("🔍");
// //         searchIcon.setStyle("-fx-text-fill: #94a3b8;");
// //         TextField searchField = new TextField();
// //         searchField.setPromptText("Search training modules, coaches, or stats...");
// //         searchField.setStyle("-fx-background-color: transparent; -fx-border-width: 0; -fx-pref-width: 300px;");
// //         searchBox.getChildren().addAll(searchIcon, searchField);

// //         Region spacer = new Region();
// //         HBox.setHgrow(spacer, Priority.ALWAYS);

// //         // Navigation Links
// //         HBox navLinks = new HBox(25);
// //         navLinks.setAlignment(Pos.CENTER);
// //         navLinks.getChildren().addAll(
// //             createNavLink("Performance", false),
// //             createNavLink("Team", true), // Active tab based on image
// //             createNavLink("Resources", false)
// //         );

// //         // Icons & Avatar
// //         Label bellIcon = new Label("🔔");
// //         bellIcon.setStyle("-fx-font-size: 18px; -fx-cursor: hand;");
// //         Label settingsIcon = new Label("⚙");
// //         settingsIcon.setStyle("-fx-font-size: 18px; -fx-cursor: hand;");

// //         Circle avatar = new Circle(18);
// //         try {
// //             avatar.setFill(new javafx.scene.paint.ImagePattern(new Image("https://randomuser.me/api/portraits/men/32.jpg")));
// //         } catch (Exception e) {
// //             avatar.setFill(Color.GRAY);
// //         }

// //         topBar.getChildren().addAll(searchBox, spacer, navLinks, bellIcon, settingsIcon, avatar);
// //         return topBar;
// //     }

// //     private VBox createNavLink(String text, boolean isActive) {
// //         VBox box = new VBox(5);
// //         box.setAlignment(Pos.CENTER);
// //         Label lbl = new Label(text);
// //         lbl.setStyle(isActive ? "-fx-font-weight: bold; -fx-text-fill: #0f172a;" : "-fx-font-weight: normal; -fx-text-fill: #64748b;");
// //         lbl.setStyle(lbl.getStyle() + "-fx-font-size: 14px; -fx-cursor: hand;");
        
// //         Region indicator = new Region();
// //         indicator.setPrefSize(30, 3);
// //         indicator.setStyle(isActive ? "-fx-background-color: #10b981; -fx-background-radius: 2;" : "-fx-background-color: transparent;");
        
// //         box.getChildren().addAll(lbl, indicator);
// //         return box;
// //     }

// //     // --- 2. HERO BANNER ---
// //     private StackPane buildHeroBanner() {
// //         StackPane bannerPane = new StackPane();
// //         bannerPane.setMinHeight(220);
// //         bannerPane.setStyle("-fx-background-radius: 20; -fx-border-radius: 20; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 20, 0, 0, 5);");

// //         // Background Layer (Gradient mimicking the dark indoor nets photo)
// //         Region bg = new Region();
// //         bg.setStyle("-fx-background-color: linear-gradient(to right, #1e293b, #0f172a); -fx-background-radius: 20;");
        
// //         // Content Layer
// //         HBox contentLayout = new HBox(30);
// //         contentLayout.setAlignment(Pos.CENTER_LEFT);
// //         contentLayout.setPadding(new Insets(30, 40, 30, 40));

// //         // Profile Avatar Ring
// //         StackPane avatarRing = new StackPane();
// //         Circle outerRing = new Circle(65, Color.TRANSPARENT);
// //         outerRing.setStroke(Color.web("#10b981"));
// //         outerRing.setStrokeWidth(3);
        
// //         Circle innerAvatar = new Circle(55);
// //         try {
// //             innerAvatar.setFill(new javafx.scene.paint.ImagePattern(new Image("https://randomuser.me/api/portraits/men/32.jpg")));
// //         } catch (Exception e) { innerAvatar.setFill(Color.DARKGRAY); }
// //         avatarRing.getChildren().addAll(outerRing, innerAvatar);

// //         // Text & Buttons
// //         VBox textLayout = new VBox(15);
// //         textLayout.setAlignment(Pos.CENTER_LEFT);
        
// //         HBox nameRow = new HBox(15);
// //         nameRow.setAlignment(Pos.CENTER_LEFT);
// //         Label nameLbl = new Label("Aashish Mohan Bhosale");
// //         nameLbl.setStyle("-fx-font-size: 26px; -fx-font-weight: bold; -fx-text-fill: white;");
// //         Label levelBadge = new Label("Pro Level 8");
// //         levelBadge.setStyle("-fx-background-color: rgba(16,185,129,0.2); -fx-text-fill: #34d399; -fx-font-weight: bold; -fx-padding: 4 12; -fx-background-radius: 20; -fx-border-color: #10b981; -fx-border-radius: 20;");
// //         nameRow.getChildren().addAll(nameLbl, levelBadge);

// //         Label quoteLbl = new Label("\"The harder you work in the nets, the easier it is on the pitch.\"");
// //         quoteLbl.setStyle("-fx-font-size: 14px; -fx-font-style: italic; -fx-text-fill: #94a3b8;");

// //         HBox actionsRow = new HBox(15);
// //         actionsRow.setAlignment(Pos.CENTER_LEFT);

// //         VBox aiScoreBox = new VBox(2);
// //         aiScoreBox.setStyle("-fx-background-color: rgba(255,255,255,0.1); -fx-padding: 10 20; -fx-background-radius: 10;");
// //         Label aiTitle = new Label("AI Improvement Score");
// //         aiTitle.setStyle("-fx-text-fill: #cbd5e1; -fx-font-size: 11px;");
// //         Label aiValue = new Label("+12.4%");
// //         aiValue.setStyle("-fx-text-fill: #34d399; -fx-font-weight: bold; -fx-font-size: 16px;");
// //         aiScoreBox.getChildren().addAll(aiTitle, aiValue);

// //         Button startBtn = new Button("Start\nTraining");
// //         startBtn.setStyle("-fx-background-color: #10b981; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 8 25; -fx-text-alignment: center; -fx-cursor: hand;");
        
// //         Button calBtn = new Button("Training\nCalendar");
// //         calBtn.setStyle("-fx-background-color: rgba(255,255,255,0.1); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 8 20; -fx-text-alignment: center; -fx-cursor: hand;");

// //         Button bookBtn = new Button("Book\nCoach");
// //         bookBtn.setStyle("-fx-background-color: rgba(255,255,255,0.1); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 8 20; -fx-text-alignment: center; -fx-cursor: hand;");

// //         actionsRow.getChildren().addAll(aiScoreBox, startBtn, calBtn, bookBtn);
// //         textLayout.getChildren().addAll(nameRow, quoteLbl, actionsRow);
        
// //         contentLayout.getChildren().addAll(avatarRing, textLayout);
// //         bannerPane.getChildren().addAll(bg, contentLayout);
        
// //         return bannerPane;
// //     }

// //     // --- 3. STATS ROW ---
// //     private HBox buildStatsRow() {
// //         HBox row = new HBox(20);
// //         row.getChildren().addAll(
// //             createCircularStatCard("Overall\nProgress", "82%", 0.82),
// //             createIconStatCard("Sessions\nCompleted", "14", "📅"),
// //             createIconStatCard("Practice Hours", "48h", "⏱"),
// //             createIconStatCardWithGreen("AI Training\nScore", "94", "📊")
// //         );
// //         for(Node n : row.getChildren()) HBox.setHgrow(n, Priority.ALWAYS);
// //         return row;
// //     }

// //     private HBox createCircularStatCard(String title, String value, double progress) {
// //         HBox card = buildBaseCard();
// //         VBox texts = new VBox(5, createStatTitle(title), createStatValue(value));
        
// //         StackPane circlePane = new StackPane();
// //         Circle bgCircle = new Circle(20, Color.TRANSPARENT);
// //         bgCircle.setStroke(Color.web("#e2e8f0"));
// //         bgCircle.setStrokeWidth(4);
        
// //         Circle progCircle = new Circle(20, Color.TRANSPARENT);
// //         progCircle.setStroke(Color.web("#10b981"));
// //         progCircle.setStrokeWidth(4);
// //         progCircle.getStrokeDashArray().addAll(progress * 125, 125.0); // Rough circumference approx
        
// //         Label valLbl = new Label(value);
// //         valLbl.setStyle("-fx-font-size: 11px; -fx-font-weight: bold;");
// //         circlePane.getChildren().addAll(bgCircle, progCircle, valLbl);

// //         Region spacer = new Region(); HBox.setHgrow(spacer, Priority.ALWAYS);
// //         card.getChildren().addAll(texts, spacer, circlePane);
// //         return card;
// //     }

// //     private HBox createIconStatCard(String title, String value, String icon) {
// //         HBox card = buildBaseCard();
// //         VBox texts = new VBox(5, createStatTitle(title), createStatValue(value));
// //         Region spacer = new Region(); HBox.setHgrow(spacer, Priority.ALWAYS);
// //         Label iconLbl = new Label(icon);
// //         iconLbl.setStyle("-fx-font-size: 24px; -fx-text-fill: #94a3b8;");
// //         card.getChildren().addAll(texts, spacer, iconLbl);
// //         return card;
// //     }

// //     private HBox createIconStatCardWithGreen(String title, String value, String icon) {
// //         HBox card = buildBaseCard();
// //         VBox texts = new VBox(5, createStatTitle(title), createStatValue(value, "#10b981"));
// //         Region spacer = new Region(); HBox.setHgrow(spacer, Priority.ALWAYS);
        
// //         StackPane iconPane = new StackPane();
// //         iconPane.setStyle("-fx-background-color: #d1fae5; -fx-background-radius: 8; -fx-padding: 8;");
// //         Label iconLbl = new Label(icon);
// //         iconLbl.setStyle("-fx-font-size: 20px; -fx-text-fill: #10b981;");
// //         iconPane.getChildren().add(iconLbl);
        
// //         card.getChildren().addAll(texts, spacer, iconPane);
// //         return card;
// //     }

// //     private HBox buildBaseCard() {
// //         HBox card = new HBox();
// //         card.setAlignment(Pos.CENTER_LEFT);
// //         card.setPadding(new Insets(20));
// //         card.setStyle("-fx-background-color: white; -fx-background-radius: 12; -fx-border-color: #f1f5f9; -fx-border-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
// //         return card;
// //     }
    
// //     private Label createStatTitle(String text) {
// //         Label l = new Label(text);
// //         l.setStyle("-fx-font-size: 13px; -fx-text-fill: #64748b;");
// //         return l;
// //     }
// //     private Label createStatValue(String text) { return createStatValue(text, "#0f172a"); }
// //     private Label createStatValue(String text, String color) {
// //         Label l = new Label(text);
// //         l.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: " + color + ";");
// //         return l;
// //     }

// //     // --- 4. MAIN SPLIT CONTENT ---
// //     private HBox buildMainSplitArea() {
// //         HBox splitLayout = new HBox(30);

// //         // LEFT COLUMN (Categories & Analytics)
// //         VBox leftCol = new VBox(30);
// //         HBox.setHgrow(leftCol, Priority.ALWAYS);
// //         leftCol.getChildren().addAll(buildCategoriesSection(), buildAnalyticsSection());

// //         // RIGHT COLUMN (Schedule, AI, Widgets)
// //         VBox rightCol = new VBox(25);
// //         rightCol.setPrefWidth(320);
// //         rightCol.setMinWidth(320);
// //         rightCol.getChildren().addAll(
// //             buildScheduleSection(),
// //             buildAIInsightsSection(),
// //             buildWeatherEquipmentRow(),
// //             buildMessagesSection()
// //         );

// //         splitLayout.getChildren().addAll(leftCol, rightCol);
// //         return splitLayout;
// //     }

// //     // --- LEFT COLUMN COMPONENTS ---
// //     private VBox buildCategoriesSection() {
// //         VBox section = new VBox(15);
        
// //         HBox header = new HBox();
// //         Label title = new Label("Training Categories");
// //         title.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: #334155;");
// //         Region spacer = new Region(); HBox.setHgrow(spacer, Priority.ALWAYS);
// //         Label viewAll = new Label("View All Drills");
// //         viewAll.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-text-fill: #10b981; -fx-cursor: hand;");
// //         header.getChildren().addAll(title, spacer, viewAll);

// //         GridPane grid = new GridPane();
// //         grid.setHgap(15); grid.setVgap(15);
// //         ColumnConstraints cc = new ColumnConstraints(); cc.setPercentWidth(33.33);
// //         grid.getColumnConstraints().addAll(cc, cc, cc);

// //         grid.add(createImageCard("Batting Practice", "12 Drills Available", "#4f46e5"), 0, 0);
// //         grid.add(createImageCard("Bowling Practice", "8 Drills Available", "#b45309"), 1, 0);
// //         grid.add(createImageCard("Strength & Agility", "15 High-Intensity Plans", "#15803d"), 2, 0);
// //         grid.add(createImageCard("Fielding Practice", "6 Expert Sessions", "#047857"), 0, 1);
// //         grid.add(createImageCard("Video Analysis", "Scan & Compare", "#0f172a"), 1, 1);
        
// //         // Custom Drill Card (Dashed)
// //         VBox customCard = new VBox(10);
// //         customCard.setAlignment(Pos.CENTER);
// //         customCard.setMinHeight(130);
// //         customCard.setStyle("-fx-background-color: #f8fafc; -fx-border-color: #cbd5e1; -fx-border-style: dashed; -fx-border-width: 2; -fx-background-radius: 12; -fx-border-radius: 12; -fx-cursor: hand;");
// //         Label plusIcon = new Label("⊕");
// //         plusIcon.setStyle("-fx-font-size: 24px; -fx-text-fill: #64748b;");
// //         Label customTxt = new Label("Custom Drill");
// //         customTxt.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-text-fill: #64748b;");
// //         customCard.getChildren().addAll(plusIcon, customTxt);
// //         grid.add(customCard, 2, 1);

// //         section.getChildren().addAll(header, grid);
// //         return section;
// //     }

// //     private StackPane createImageCard(String title, String subtitle, String fallbackColor) {
// //         StackPane card = new StackPane();
// //         card.setMinHeight(130);
// //         card.setStyle("-fx-background-color: " + fallbackColor + "; -fx-background-radius: 12; -fx-border-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0, 0, 4);");

// //         // Gradient Overlay to ensure text readability
// //         Region overlay = new Region();
// //         overlay.setStyle("-fx-background-color: linear-gradient(to top, rgba(0,0,0,0.9), transparent); -fx-background-radius: 12;");

// //         VBox textData = new VBox(3);
// //         textData.setAlignment(Pos.BOTTOM_LEFT);
// //         textData.setPadding(new Insets(15));
        
// //         Label tLbl = new Label(title);
// //         tLbl.setStyle("-fx-font-weight: bold; -fx-font-size: 15px; -fx-text-fill: white;");
// //         Label sLbl = new Label(subtitle);
// //         sLbl.setStyle("-fx-font-size: 12px; -fx-text-fill: #34d399;");
// //         textData.getChildren().addAll(tLbl, sLbl);

// //         card.getChildren().addAll(overlay, textData);
// //         return card;
// //     }

// //     private VBox buildAnalyticsSection() {
// //         VBox box = new VBox(20);
// //         box.setPadding(new Insets(25));
// //         box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.04), 15, 0, 0, 5);");

// //         Label title = new Label("Skill Development Analytics");
// //         title.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: #334155;");

// //         HBox chartsRow = new HBox(30);
// //         chartsRow.setAlignment(Pos.CENTER);

// //         // 1. Radar Chart (Custom Drawn)
// //         StackPane radarChart = buildRadarChartMock();
        
// //         // 2. Bar Chart & Stats
// //         VBox rightStats = new VBox(15);
// //         rightStats.setAlignment(Pos.CENTER_LEFT);
        
// //         Label trendTitle = new Label("SKILL GROWTH TREND");
// //         trendTitle.setStyle("-fx-font-size: 11px; -fx-text-fill: #94a3b8; -fx-font-weight: bold;");
// //         Label trendVal = new Label("+18% this month");
// //         trendVal.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
// //         VBox trendBox = new VBox(2, trendTitle, trendVal);

// //         // Fake Bar Chart
// //         HBox barChart = new HBox(8);
// //         barChart.setAlignment(Pos.BOTTOM_CENTER);
// //         barChart.setMinHeight(80);
// //         double[] heights = {30, 45, 20, 60, 50, 70, 90};
// //         for (int i = 0; i < heights.length; i++) {
// //             Rectangle bar = new Rectangle(18, heights[i]);
// //             bar.setArcWidth(4); bar.setArcHeight(4);
// //             bar.setFill(i < 3 ? Color.web("#e2e8f0") : Color.web("#10b981"));
// //             barChart.getChildren().add(bar);
// //         }

// //         // Summary Boxes
// //         HBox summaryRow = new HBox(10);
// //         summaryRow.getChildren().addAll(
// //             createGrowthBox("Top Gaining", "Bowling\nAccuracy", "#10b981"),
// //             createGrowthBox("Needs Focus", "Power\nHitting", "#ef4444")
// //         );

// //         rightStats.getChildren().addAll(trendBox, barChart, summaryRow);
        
// //         chartsRow.getChildren().addAll(radarChart, rightStats);
// //         box.getChildren().addAll(title, chartsRow);
// //         return box;
// //     }

// //     private StackPane buildRadarChartMock() {
// //         StackPane pane = new StackPane();
// //         pane.setPrefSize(200, 200);
        
// //         // Base Pentagons
// //         pane.getChildren().add(createPentagon(90, "#f8fafc", "#cbd5e1"));
// //         pane.getChildren().add(createPentagon(60, "transparent", "#e2e8f0"));
// //         pane.getChildren().add(createPentagon(30, "transparent", "#e2e8f0"));

// //         // Data Polygon
// //         Polygon dataPoly = new Polygon();
// //         dataPoly.getPoints().addAll(
// //             0.0, -70.0,   // Technique (High)
// //             60.0, -10.0,  // Power (Med)
// //             40.0, 60.0,   // Reflex (Med-High)
// //             -30.0, 50.0,  // Stamina (Low)
// //             -80.0, -20.0  // Accuracy (High)
// //         );
// //         dataPoly.setFill(Color.web("rgba(16, 185, 129, 0.4)"));
// //         dataPoly.setStroke(Color.web("#10b981"));
// //         dataPoly.setStrokeWidth(2);
// //         pane.getChildren().add(dataPoly);

// //         // Labels
// //         pane.getChildren().addAll(
// //             positionLabel("TECHNIQUE", 0, -105),
// //             positionLabel("POWER", 95, -20),
// //             positionLabel("REFLEX", 65, 90),
// //             positionLabel("STAMINA", -65, 90),
// //             positionLabel("ACCURACY", -95, -20)
// //         );

// //         return pane;
// //     }

// //     private Polygon createPentagon(double radius, String fillHex, String strokeHex) {
// //         Polygon p = new Polygon();
// //         for (int i = 0; i < 5; i++) {
// //             double angle = Math.toRadians(-90 + i * 72);
// //             p.getPoints().addAll(radius * Math.cos(angle), radius * Math.sin(angle));
// //         }
// //         p.setFill(Color.web(fillHex));
// //         p.setStroke(Color.web(strokeHex));
// //         return p;
// //     }

// //     private Label positionLabel(String text, double tx, double ty) {
// //         Label l = new Label(text);
// //         l.setStyle("-fx-font-size: 10px; -fx-text-fill: #475569;");
// //         l.setTranslateX(tx);
// //         l.setTranslateY(ty);
// //         return l;
// //     }

// //     private VBox createGrowthBox(String title, String val, String valColor) {
// //         VBox box = new VBox(5);
// //         box.setPadding(new Insets(10, 15, 10, 15));
// //         box.setStyle("-fx-background-color: #f8fafc; -fx-background-radius: 8;");
// //         Label t = new Label(title);
// //         t.setStyle("-fx-font-size: 11px; -fx-text-fill: #64748b;");
// //         Label v = new Label(val);
// //         v.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: " + valColor + ";");
// //         box.getChildren().addAll(t, v);
// //         return box;
// //     }

// //     // --- RIGHT COLUMN COMPONENTS ---
// //     private VBox buildScheduleSection() {
// //         VBox section = new VBox(15);
        
// //         HBox header = new HBox();
// //         Label title = new Label("Today's Schedule");
// //         title.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: #334155;");
// //         Region spacer = new Region(); HBox.setHgrow(spacer, Priority.ALWAYS);
// //         Label calIcon = new Label("📅");
// //         calIcon.setStyle("-fx-text-fill: #10b981; -fx-font-size: 16px;");
// //         header.getChildren().addAll(title, spacer, calIcon);

// //         VBox list = new VBox(15);
// //         list.getChildren().addAll(
// //             createScheduleItem("16:00", "PM", "Fast Bowling Mastery", "Coach: Rahul Dravid • Lane 4", true),
// //             createScheduleItem("18:30", "PM", "Recovery & Yoga", "Gym Zone B • Session 12", false)
// //         );

// //         section.getChildren().addAll(header, list);
// //         return section;
// //     }

// //     private HBox createScheduleItem(String time, String ampm, String title, String subtitle, boolean isActive) {
// //         HBox item = new HBox(15);
// //         item.setAlignment(Pos.CENTER_LEFT);
// //         item.setPadding(new Insets(15));
// //         item.setStyle("-fx-background-color: " + (isActive ? "#f0fdf4" : "white") + "; -fx-background-radius: 12; -fx-border-color: " + (isActive ? "transparent" : "#f1f5f9") + "; -fx-border-radius: 12;");
        
// //         if (isActive) {
// //             item.setStyle(item.getStyle() + "-fx-border-width: 0 0 0 4; -fx-border-color: #10b981;");
// //         }

// //         VBox timeBox = new VBox(0);
// //         timeBox.setAlignment(Pos.CENTER);
// //         Label t = new Label(time);
// //         t.setStyle("-fx-font-weight: bold; -fx-font-size: 15px; -fx-text-fill: #0f172a;");
// //         Label ap = new Label(ampm);
// //         ap.setStyle("-fx-font-weight: bold; -fx-font-size: 12px; -fx-text-fill: " + (isActive ? "#10b981" : "#94a3b8") + ";");
// //         timeBox.getChildren().addAll(t, ap);

// //         VBox dataBox = new VBox(3);
// //         Label titleLbl = new Label(title);
// //         titleLbl.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: #0f172a;");
// //         Label subLbl = new Label(subtitle);
// //         subLbl.setStyle("-fx-font-size: 12px; -fx-text-fill: #64748b;");
// //         dataBox.getChildren().addAll(titleLbl, subLbl);

// //         item.getChildren().addAll(timeBox, dataBox);
// //         return item;
// //     }

// //     private VBox buildAIInsightsSection() {
// //         VBox card = new VBox(20);
// //         card.setPadding(new Insets(25));
// //         card.setStyle("-fx-background-color: #0f172a; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 20, 0, 0, 8);");

// //         HBox header = new HBox(10);
// //         header.setAlignment(Pos.CENTER_LEFT);
// //         Label icon = new Label("🧠");
// //         Label title = new Label("AI Training Insights");
// //         title.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 15px;");
// //         header.getChildren().addAll(icon, title);

// //         Label quote = new Label("\"Aashish, your wrist position on the off-drive has shifted 3° inward. Today, focus on maintaining a high elbow finish to stabilize your shot direction.\"");
// //         quote.setWrapText(true);
// //         quote.setStyle("-fx-text-fill: #cbd5e1; -fx-font-size: 13px; -fx-font-style: italic; -fx-line-spacing: 5px;");

// //         VBox plansBox = new VBox(10);
// //         Label planTitle = new Label("ACTIVE PLANS");
// //         planTitle.setStyle("-fx-text-fill: #34d399; -fx-font-size: 11px; -fx-font-weight: bold; -fx-letter-spacing: 1px;");
        
// //         plansBox.getChildren().addAll(
// //             planTitle,
// //             createDarkPlanRow("Power Hitting Fundamentals", "75%", true),
// //             createDarkPlanRow("Reverse Swing Mastery", "Coming Soon", false)
// //         );

// //         Button vrBtn = new Button("Launch VR Simulation");
// //         vrBtn.setMaxWidth(Double.MAX_VALUE);
// //         vrBtn.setStyle("-fx-background-color: #059669; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 12; -fx-background-radius: 8; -fx-cursor: hand;");

// //         card.getChildren().addAll(header, quote, plansBox, vrBtn);
// //         return card;
// //     }

// //     private HBox createDarkPlanRow(String title, String val, boolean isGreenVal) {
// //         HBox row = new HBox();
// //         Label t = new Label(title);
// //         t.setStyle("-fx-text-fill: white; -fx-font-size: 12px;");
// //         Region spacer = new Region(); HBox.setHgrow(spacer, Priority.ALWAYS);
// //         Label v = new Label(val);
// //         v.setStyle("-fx-font-size: 12px; -fx-text-fill: " + (isGreenVal ? "#34d399" : "#64748b") + ";");
// //         row.getChildren().addAll(t, spacer, v);
// //         return row;
// //     }

// //     private HBox buildWeatherEquipmentRow() {
// //         HBox row = new HBox(15);
        
// //         VBox weather = new VBox(5);
// //         weather.setAlignment(Pos.CENTER);
// //         weather.setPadding(new Insets(15));
// //         weather.setStyle("-fx-background-color: white; -fx-background-radius: 12; -fx-border-color: #f1f5f9; -fx-border-radius: 12;");
// //         Label wIcon = new Label("☀"); wIcon.setStyle("-fx-text-fill: #10b981; -fx-font-size: 20px;");
// //         Label wTemp = new Label("28°C Clear"); wTemp.setStyle("-fx-font-weight: bold; -fx-font-size: 12px;");
// //         Label wSub = new Label("Perfect for Nets"); wSub.setStyle("-fx-font-size: 10px; -fx-text-fill: #64748b;");
// //         weather.getChildren().addAll(wIcon, wTemp, wSub);
// //         HBox.setHgrow(weather, Priority.ALWAYS);

// //         VBox equip = new VBox(5);
// //         equip.setAlignment(Pos.CENTER);
// //         equip.setPadding(new Insets(15));
// //         equip.setStyle("-fx-background-color: white; -fx-background-radius: 12; -fx-border-color: #f1f5f9; -fx-border-radius: 12;");
// //         Label eIcon = new Label("🏏"); eIcon.setStyle("-fx-text-fill: #10b981; -fx-font-size: 20px;");
// //         Label eTitle = new Label("Equipment"); eTitle.setStyle("-fx-font-weight: bold; -fx-font-size: 12px;");
// //         Label eSub = new Label("2 items needed"); eSub.setStyle("-fx-font-size: 10px; -fx-text-fill: #64748b;");
// //         equip.getChildren().addAll(eIcon, eTitle, eSub);
// //         HBox.setHgrow(equip, Priority.ALWAYS);

// //         row.getChildren().addAll(weather, equip);
// //         return row;
// //     }

// //     private VBox buildMessagesSection() {
// //         VBox section = new VBox(15);
        
// //         Label title = new Label("COACH MESSAGES");
// //         title.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #64748b; -fx-letter-spacing: 1px;");

// //         VBox list = new VBox(15);
// //         list.getChildren().addAll(
// //             createMessageItem("RD", "Rahul Dravid", "Check your backlift video from yesterday's session.", "#10b981"),
// //             createMessageItem("SM", "S. Malinga", "Great yorker consistency. Let's try slow-balls next.", "#6366f1")
// //         );

// //         section.getChildren().addAll(title, list);
// //         return section;
// //     }

// //     private HBox createMessageItem(String initials, String name, String msg, String color) {
// //         HBox item = new HBox(15);
        
// //         Label initLbl = new Label(initials);
// //         initLbl.setAlignment(Pos.CENTER);
// //         initLbl.setMinSize(36, 36);
// //         initLbl.setStyle("-fx-background-color: " + color + "33; -fx-text-fill: " + color + "; -fx-font-weight: bold; -fx-font-size: 12px; -fx-background-radius: 18;");

// //         VBox texts = new VBox(3);
// //         Label nameLbl = new Label(name);
// //         nameLbl.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
// //         Label msgLbl = new Label(msg);
// //         msgLbl.setWrapText(true);
// //         msgLbl.setStyle("-fx-font-size: 12px; -fx-text-fill: #64748b;");
// //         texts.getChildren().addAll(nameLbl, msgLbl);

// //         item.getChildren().addAll(initLbl, texts);
// //         return item;
// //     }
// // }

// package com.athlixcore.view.player;

// import javafx.geometry.Insets;
// import javafx.geometry.Pos;
// import javafx.scene.Node;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.control.ScrollPane;
// import javafx.scene.control.TextField;
// import javafx.scene.image.Image;
// import javafx.scene.layout.*;
// import javafx.scene.paint.Color;
// import javafx.scene.shape.Circle;
// import javafx.scene.shape.Polygon;
// import javafx.scene.shape.Rectangle;

// public class Traning_dashboard {

//     private StackPane rootContainer;

//     public Node getView() {
//         if (rootContainer == null) {
//             rootContainer = new StackPane();
//             rootContainer.setStyle("-fx-background-color: #f8fafc;");

//             VBox mainLayout = new VBox(25);
//             mainLayout.setPadding(new Insets(20, 40, 40, 40));

//             // Build UI Sections
//             mainLayout.getChildren().addAll(
//                 buildTopBar(),
//                 buildHeroBanner(),
//                 buildStatsRow(),
//                 buildMainSplitArea()
//             );

//             ScrollPane scrollPane = new ScrollPane(mainLayout);
//             scrollPane.setFitToWidth(true);
//             scrollPane.setStyle("-fx-background-color: transparent; -fx-background: #f8fafc;");
//             scrollPane.getStylesheets().add("data:text/css,.scroll-pane > .viewport { -fx-background-color: transparent; }");

//             rootContainer.getChildren().add(scrollPane);
//         }
//         return rootContainer;
//     }

//     // --- TOP NAVIGATION ---
//     private HBox buildTopBar() {
//         HBox topBar = new HBox(20);
//         topBar.setAlignment(Pos.CENTER_LEFT);

//         HBox searchBox = new HBox(10);
//         searchBox.setAlignment(Pos.CENTER_LEFT);
//         searchBox.setStyle("-fx-background-color: white; -fx-background-radius: 20; -fx-padding: 8 15; -fx-border-color: #e2e8f0; -fx-border-radius: 20;");
//         Label searchIcon = new Label("🔍");
//         searchIcon.setStyle("-fx-text-fill: #94a3b8;");
//         TextField searchField = new TextField();
//         searchField.setPromptText("Search training modules, coaches, or stats...");
//         searchField.setStyle("-fx-background-color: transparent; -fx-border-width: 0; -fx-pref-width: 300px;");
//         searchBox.getChildren().addAll(searchIcon, searchField);

//         Region spacer = new Region();
//         HBox.setHgrow(spacer, Priority.ALWAYS);

//         HBox navLinks = new HBox(25);
//         navLinks.setAlignment(Pos.CENTER);
//         navLinks.getChildren().addAll(
//             createNavLink("Performance", false),
//             createNavLink("Team", true), 
//             createNavLink("Resources", false)
//         );

//         Label bellIcon = new Label("🔔");
//         bellIcon.setStyle("-fx-font-size: 18px; -fx-cursor: hand;");
//         Label settingsIcon = new Label("⚙");
//         settingsIcon.setStyle("-fx-font-size: 18px; -fx-cursor: hand;");

//         Circle avatar = new Circle(18);
//         try { avatar.setFill(new javafx.scene.paint.ImagePattern(new Image("https://randomuser.me/api/portraits/men/32.jpg"))); } 
//         catch (Exception e) { avatar.setFill(Color.GRAY); }

//         topBar.getChildren().addAll(searchBox, spacer, navLinks, bellIcon, settingsIcon, avatar);
//         return topBar;
//     }

//     private VBox createNavLink(String text, boolean isActive) {
//         VBox box = new VBox(5);
//         box.setAlignment(Pos.CENTER);
//         Label lbl = new Label(text);
//         lbl.setStyle(isActive ? "-fx-font-weight: bold; -fx-text-fill: #0f172a; -fx-font-size: 14px; -fx-cursor: hand;" : "-fx-font-weight: normal; -fx-text-fill: #64748b; -fx-font-size: 14px; -fx-cursor: hand;");
//         Region indicator = new Region();
//         indicator.setPrefSize(30, 3);
//         indicator.setStyle(isActive ? "-fx-background-color: #10b981; -fx-background-radius: 2;" : "-fx-background-color: transparent;");
//         box.getChildren().addAll(lbl, indicator);
//         return box;
//     }

//     // --- HERO BANNER ---
//     private StackPane buildHeroBanner() {
//         StackPane bannerPane = new StackPane();
//         bannerPane.setMinHeight(220);
//         bannerPane.setStyle("-fx-background-radius: 20; -fx-border-radius: 20; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 20, 0, 0, 5);");

//         Region bg = new Region();
//         bg.setStyle("-fx-background-color: linear-gradient(to right, #1e293b, #0f172a); -fx-background-radius: 20;");
        
//         HBox contentLayout = new HBox(30);
//         contentLayout.setAlignment(Pos.CENTER_LEFT);
//         contentLayout.setPadding(new Insets(30, 40, 30, 40));

//         StackPane avatarRing = new StackPane();
//         Circle outerRing = new Circle(65, Color.TRANSPARENT);
//         outerRing.setStroke(Color.web("#10b981"));
//         outerRing.setStrokeWidth(3);
//         Circle innerAvatar = new Circle(55);
//         try { innerAvatar.setFill(new javafx.scene.paint.ImagePattern(new Image("https://randomuser.me/api/portraits/men/32.jpg"))); } 
//         catch (Exception e) { innerAvatar.setFill(Color.DARKGRAY); }
//         avatarRing.getChildren().addAll(outerRing, innerAvatar);

//         VBox textLayout = new VBox(15);
//         textLayout.setAlignment(Pos.CENTER_LEFT);
        
//         HBox nameRow = new HBox(15);
//         nameRow.setAlignment(Pos.CENTER_LEFT);
//         Label nameLbl = new Label("Aashish Mohan Bhosale");
//         nameLbl.setStyle("-fx-font-size: 26px; -fx-font-weight: bold; -fx-text-fill: white;");
//         Label levelBadge = new Label("Pro Level 8");
//         levelBadge.setStyle("-fx-background-color: rgba(16,185,129,0.2); -fx-text-fill: #34d399; -fx-font-weight: bold; -fx-padding: 4 12; -fx-background-radius: 20; -fx-border-color: #10b981; -fx-border-radius: 20;");
//         nameRow.getChildren().addAll(nameLbl, levelBadge);

//         Label quoteLbl = new Label("\"The harder you work in the nets, the easier it is on the pitch.\"");
//         quoteLbl.setStyle("-fx-font-size: 14px; -fx-font-style: italic; -fx-text-fill: #94a3b8;");

//         HBox actionsRow = new HBox(15);
//         actionsRow.setAlignment(Pos.CENTER_LEFT);

//         VBox aiScoreBox = new VBox(2);
//         aiScoreBox.setStyle("-fx-background-color: rgba(255,255,255,0.1); -fx-padding: 10 20; -fx-background-radius: 10;");
//         Label aiTitle = new Label("AI Improvement Score");
//         aiTitle.setStyle("-fx-text-fill: #cbd5e1; -fx-font-size: 11px;");
//         Label aiValue = new Label("+12.4%");
//         aiValue.setStyle("-fx-text-fill: #34d399; -fx-font-weight: bold; -fx-font-size: 16px;");
//         aiScoreBox.getChildren().addAll(aiTitle, aiValue);

//         Button startBtn = new Button("Start\nTraining");
//         startBtn.setStyle("-fx-background-color: #10b981; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 8 25; -fx-text-alignment: center; -fx-cursor: hand;");
        
//         Button calBtn = new Button("Training\nCalendar");
//         calBtn.setStyle("-fx-background-color: rgba(255,255,255,0.1); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 8 20; -fx-text-alignment: center; -fx-cursor: hand;");

//         Button bookBtn = new Button("Book\nCoach");
//         bookBtn.setStyle("-fx-background-color: rgba(255,255,255,0.1); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 8 20; -fx-text-alignment: center; -fx-cursor: hand;");

//         actionsRow.getChildren().addAll(aiScoreBox, startBtn, calBtn, bookBtn);
//         textLayout.getChildren().addAll(nameRow, quoteLbl, actionsRow);
        
//         contentLayout.getChildren().addAll(avatarRing, textLayout);
//         bannerPane.getChildren().addAll(bg, contentLayout);
        
//         return bannerPane;
//     }

//     // --- STATS CARDS ---
//     private HBox buildStatsRow() {
//         HBox row = new HBox(20);
//         row.getChildren().addAll(
//             createCircularStatCard("Overall\nProgress", "82%", 0.82),
//             createIconStatCard("Sessions\nCompleted", "14", "📅"),
//             createIconStatCard("Practice Hours", "48h", "⏱"),
//             createIconStatCardWithGreen("AI Training\nScore", "94", "📊")
//         );
//         for(Node n : row.getChildren()) HBox.setHgrow(n, Priority.ALWAYS);
//         return row;
//     }

//     private HBox createCircularStatCard(String title, String value, double progress) {
//         HBox card = buildBaseCard();
//         VBox texts = new VBox(5, createStatTitle(title), createStatValue(value));
        
//         StackPane circlePane = new StackPane();
//         Circle bgCircle = new Circle(22, Color.TRANSPARENT);
//         bgCircle.setStroke(Color.web("#f1f5f9"));
//         bgCircle.setStrokeWidth(4);
        
//         Circle progCircle = new Circle(22, Color.TRANSPARENT);
//         progCircle.setStroke(Color.web("#10b981"));
//         progCircle.setStrokeWidth(4);
//         progCircle.getStrokeDashArray().addAll(progress * 138, 138.0);
        
//         Label valLbl = new Label(value);
//         valLbl.setStyle("-fx-font-size: 11px; -fx-font-weight: bold;");
//         circlePane.getChildren().addAll(bgCircle, progCircle, valLbl);

//         Region spacer = new Region(); HBox.setHgrow(spacer, Priority.ALWAYS);
//         card.getChildren().addAll(texts, spacer, circlePane);
//         return card;
//     }

//     private HBox createIconStatCard(String title, String value, String icon) {
//         HBox card = buildBaseCard();
//         VBox texts = new VBox(5, createStatTitle(title), createStatValue(value));
//         Region spacer = new Region(); HBox.setHgrow(spacer, Priority.ALWAYS);
//         Label iconLbl = new Label(icon);
//         iconLbl.setStyle("-fx-font-size: 24px; -fx-text-fill: #94a3b8;");
//         card.getChildren().addAll(texts, spacer, iconLbl);
//         return card;
//     }

//     private HBox createIconStatCardWithGreen(String title, String value, String icon) {
//         HBox card = buildBaseCard();
//         VBox texts = new VBox(5, createStatTitle(title), createStatValue(value, "#10b981"));
//         Region spacer = new Region(); HBox.setHgrow(spacer, Priority.ALWAYS);
        
//         StackPane iconPane = new StackPane();
//         iconPane.setStyle("-fx-background-color: #d1fae5; -fx-background-radius: 8; -fx-padding: 8;");
//         Label iconLbl = new Label(icon);
//         iconLbl.setStyle("-fx-font-size: 20px; -fx-text-fill: #10b981;");
//         iconPane.getChildren().add(iconLbl);
        
//         card.getChildren().addAll(texts, spacer, iconPane);
//         return card;
//     }

//     private HBox buildBaseCard() {
//         HBox card = new HBox();
//         card.setAlignment(Pos.CENTER_LEFT);
//         card.setPadding(new Insets(20));
//         card.setStyle("-fx-background-color: white; -fx-background-radius: 12; -fx-border-color: #f1f5f9; -fx-border-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
//         return card;
//     }
    
//     private Label createStatTitle(String text) {
//         Label l = new Label(text);
//         l.setStyle("-fx-font-size: 13px; -fx-text-fill: #64748b;");
//         return l;
//     }
//     private Label createStatValue(String text) { return createStatValue(text, "#0f172a"); }
//     private Label createStatValue(String text, String color) {
//         Label l = new Label(text);
//         l.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: " + color + ";");
//         return l;
//     }

//     // --- MAIN SPLIT (LEFT + RIGHT) ---
//     private HBox buildMainSplitArea() {
//         HBox splitLayout = new HBox(30);

//         // LEFT COLUMN
//         VBox leftCol = new VBox(30);
//         HBox.setHgrow(leftCol, Priority.ALWAYS);
//         leftCol.getChildren().addAll(buildCategoriesSection(), buildAnalyticsSection());

//         // RIGHT COLUMN
//         VBox rightCol = new VBox(25);
//         rightCol.setPrefWidth(320);
//         rightCol.setMinWidth(320);
//         rightCol.getChildren().addAll(
//             buildScheduleSection(),
//             buildAIInsightsSection(),
//             buildWeatherEquipmentRow(),
//             buildMessagesSection()
//         );

//         splitLayout.getChildren().addAll(leftCol, rightCol);
//         return splitLayout;
//     }

//     // --- CATEGORIES GRID ---
//     private VBox buildCategoriesSection() {
//         VBox section = new VBox(15);
//         HBox header = new HBox();
//         Label title = new Label("Training Categories");
//         title.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: #334155;");
//         Region spacer = new Region(); HBox.setHgrow(spacer, Priority.ALWAYS);
//         Label viewAll = new Label("View All Drills");
//         viewAll.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-text-fill: #10b981; -fx-cursor: hand;");
//         header.getChildren().addAll(title, spacer, viewAll);

//         GridPane grid = new GridPane();
//         grid.setHgap(15); grid.setVgap(15);
//         ColumnConstraints cc = new ColumnConstraints(); cc.setPercentWidth(33.33);
//         grid.getColumnConstraints().addAll(cc, cc, cc);

//         grid.add(createImageCard("Batting Practice", "12 Drills Available", "#4f46e5"), 0, 0);
//         grid.add(createImageCard("Bowling Practice", "8 Drills Available", "#b45309"), 1, 0);
//         grid.add(createImageCard("Strength & Agility", "15 High-Intensity Plans", "#15803d"), 2, 0);
//         grid.add(createImageCard("Fielding Practice", "6 Expert Sessions", "#047857"), 0, 1);
//         grid.add(createImageCard("Video Analysis", "Scan & Compare", "#0f172a"), 1, 1);
        
//         VBox customCard = new VBox(10);
//         customCard.setAlignment(Pos.CENTER);
//         customCard.setMinHeight(130);
//         customCard.setStyle("-fx-background-color: #f8fafc; -fx-border-color: #cbd5e1; -fx-border-style: dashed; -fx-border-width: 2; -fx-background-radius: 12; -fx-border-radius: 12; -fx-cursor: hand;");
//         Label plusIcon = new Label("⊕");
//         plusIcon.setStyle("-fx-font-size: 24px; -fx-text-fill: #64748b;");
//         Label customTxt = new Label("Custom Drill");
//         customTxt.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-text-fill: #64748b;");
//         customCard.getChildren().addAll(plusIcon, customTxt);
//         grid.add(customCard, 2, 1);

//         section.getChildren().addAll(header, grid);
//         return section;
//     }

//     private StackPane createImageCard(String title, String subtitle, String fallbackColor) {
//         StackPane card = new StackPane();
//         card.setMinHeight(130);
//         card.setStyle("-fx-background-color: " + fallbackColor + "; -fx-background-radius: 12; -fx-border-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0, 0, 4);");

//         Region overlay = new Region();
//         overlay.setStyle("-fx-background-color: linear-gradient(to top, rgba(0,0,0,0.9), transparent); -fx-background-radius: 12;");

//         VBox textData = new VBox(3);
//         textData.setAlignment(Pos.BOTTOM_LEFT);
//         textData.setPadding(new Insets(15));
//         Label tLbl = new Label(title);
//         tLbl.setStyle("-fx-font-weight: bold; -fx-font-size: 15px; -fx-text-fill: white;");
//         Label sLbl = new Label(subtitle);
//         sLbl.setStyle("-fx-font-size: 12px; -fx-text-fill: #34d399;");
//         textData.getChildren().addAll(tLbl, sLbl);

//         card.getChildren().addAll(overlay, textData);
//         return card;
//     }

//     // --- ANALYTICS (RADAR & BAR CHARTS) ---
//     private VBox buildAnalyticsSection() {
//         VBox box = new VBox(20);
//         box.setPadding(new Insets(25));
//         box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.04), 15, 0, 0, 5);");

//         Label title = new Label("Skill Development Analytics");
//         title.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: #334155;");

//         HBox chartsRow = new HBox(30);
//         chartsRow.setAlignment(Pos.CENTER);

//         StackPane radarChart = buildRadarChartMock();
        
//         VBox rightStats = new VBox(15);
//         rightStats.setAlignment(Pos.CENTER_LEFT);
        
//         Label trendTitle = new Label("SKILL GROWTH TREND");
//         trendTitle.setStyle("-fx-font-size: 11px; -fx-text-fill: #94a3b8; -fx-font-weight: bold;");
//         Label trendVal = new Label("+18% this month");
//         trendVal.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
//         VBox trendBox = new VBox(2, trendTitle, trendVal);

//         HBox barChart = new HBox(8);
//         barChart.setAlignment(Pos.BOTTOM_CENTER);
//         barChart.setMinHeight(80);
//         double[] heights = {30, 45, 20, 60, 50, 70, 90};
//         for (int i = 0; i < heights.length; i++) {
//             Rectangle bar = new Rectangle(18, heights[i]);
//             bar.setArcWidth(4); bar.setArcHeight(4);
//             bar.setFill(i < 3 ? Color.web("#e2e8f0") : Color.web("#10b981"));
//             barChart.getChildren().add(bar);
//         }

//         HBox summaryRow = new HBox(10);
//         summaryRow.getChildren().addAll(
//             createGrowthBox("Top Gaining", "Bowling\nAccuracy", "#10b981"),
//             createGrowthBox("Needs Focus", "Power\nHitting", "#ef4444")
//         );

//         rightStats.getChildren().addAll(trendBox, barChart, summaryRow);
//         chartsRow.getChildren().addAll(radarChart, rightStats);
//         box.getChildren().addAll(title, chartsRow);
//         return box;
//     }

//     private StackPane buildRadarChartMock() {
//         StackPane pane = new StackPane();
//         pane.setPrefSize(200, 200);
        
//         pane.getChildren().add(createPentagon(90, "#f8fafc", "#cbd5e1"));
//         pane.getChildren().add(createPentagon(60, "transparent", "#e2e8f0"));
//         pane.getChildren().add(createPentagon(30, "transparent", "#e2e8f0"));

//         Polygon dataPoly = new Polygon();
//         dataPoly.getPoints().addAll(
//             0.0, -70.0,   // Technique
//             60.0, -10.0,  // Power
//             40.0, 60.0,   // Reflex
//             -30.0, 50.0,  // Stamina
//             -80.0, -20.0  // Accuracy
//         );
//         dataPoly.setFill(Color.web("rgba(16, 185, 129, 0.4)"));
//         dataPoly.setStroke(Color.web("#10b981"));
//         dataPoly.setStrokeWidth(2);
//         pane.getChildren().add(dataPoly);

//         pane.getChildren().addAll(
//             positionLabel("TECHNIQUE", 0, -105),
//             positionLabel("POWER", 95, -20),
//             positionLabel("REFLEX", 65, 90),
//             positionLabel("STAMINA", -65, 90),
//             positionLabel("ACCURACY", -95, -20)
//         );

//         return pane;
//     }

//     private Polygon createPentagon(double radius, String fillHex, String strokeHex) {
//         Polygon p = new Polygon();
//         for (int i = 0; i < 5; i++) {
//             double angle = Math.toRadians(-90 + i * 72);
//             p.getPoints().addAll(radius * Math.cos(angle), radius * Math.sin(angle));
//         }
//         p.setFill(Color.web(fillHex));
//         p.setStroke(Color.web(strokeHex));
//         return p;
//     }

//     private Label positionLabel(String text, double tx, double ty) {
//         Label l = new Label(text);
//         l.setStyle("-fx-font-size: 10px; -fx-text-fill: #475569;");
//         l.setTranslateX(tx);
//         l.setTranslateY(ty);
//         return l;
//     }

//     private VBox createGrowthBox(String title, String val, String valColor) {
//         VBox box = new VBox(5);
//         box.setPadding(new Insets(10, 15, 10, 15));
//         box.setStyle("-fx-background-color: #f8fafc; -fx-background-radius: 8;");
//         Label t = new Label(title);
//         t.setStyle("-fx-font-size: 11px; -fx-text-fill: #64748b;");
//         Label v = new Label(val);
//         v.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: " + valColor + ";");
//         box.getChildren().addAll(t, v);
//         return box;
//     }

//     // --- RIGHT SIDEBAR SCHEDULE & AI ---
//     private VBox buildScheduleSection() {
//         VBox section = new VBox(15);
//         HBox header = new HBox();
//         Label title = new Label("Today's Schedule");
//         title.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: #334155;");
//         Region spacer = new Region(); HBox.setHgrow(spacer, Priority.ALWAYS);
//         Label calIcon = new Label("📅");
//         calIcon.setStyle("-fx-text-fill: #10b981; -fx-font-size: 16px;");
//         header.getChildren().addAll(title, spacer, calIcon);

//         VBox list = new VBox(15);
//         list.getChildren().addAll(
//             createScheduleItem("16:00", "PM", "Fast Bowling Mastery", "Coach: Rahul Dravid • Lane 4", true),
//             createScheduleItem("18:30", "PM", "Recovery & Yoga", "Gym Zone B • Session 12", false)
//         );

//         section.getChildren().addAll(header, list);
//         return section;
//     }

//     private HBox createScheduleItem(String time, String ampm, String title, String subtitle, boolean isActive) {
//         HBox item = new HBox(15);
//         item.setAlignment(Pos.CENTER_LEFT);
//         item.setPadding(new Insets(15));
//         item.setStyle("-fx-background-color: " + (isActive ? "#f0fdf4" : "white") + "; -fx-background-radius: 12; -fx-border-color: " + (isActive ? "transparent" : "#f1f5f9") + "; -fx-border-radius: 12;");
//         if (isActive) item.setStyle(item.getStyle() + "-fx-border-width: 0 0 0 4; -fx-border-color: #10b981;");

//         VBox timeBox = new VBox(0);
//         timeBox.setAlignment(Pos.CENTER);
//         Label t = new Label(time);
//         t.setStyle("-fx-font-weight: bold; -fx-font-size: 15px; -fx-text-fill: #0f172a;");
//         Label ap = new Label(ampm);
//         ap.setStyle("-fx-font-weight: bold; -fx-font-size: 12px; -fx-text-fill: " + (isActive ? "#10b981" : "#94a3b8") + ";");
//         timeBox.getChildren().addAll(t, ap);

//         VBox dataBox = new VBox(3);
//         Label titleLbl = new Label(title);
//         titleLbl.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: #0f172a;");
//         Label subLbl = new Label(subtitle);
//         subLbl.setStyle("-fx-font-size: 12px; -fx-text-fill: #64748b;");
//         dataBox.getChildren().addAll(titleLbl, subLbl);

//         item.getChildren().addAll(timeBox, dataBox);
//         return item;
//     }

//     private VBox buildAIInsightsSection() {
//         VBox card = new VBox(20);
//         card.setPadding(new Insets(25));
//         card.setStyle("-fx-background-color: #0f172a; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 20, 0, 0, 8);");

//         HBox header = new HBox(10);
//         header.setAlignment(Pos.CENTER_LEFT);
//         Label icon = new Label("🧠");
//         Label title = new Label("AI Training Insights");
//         title.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 15px;");
//         header.getChildren().addAll(icon, title);

//         Label quote = new Label("\"Aashish, your wrist position on the off-drive has shifted 3° inward. Today, focus on maintaining a high elbow finish to stabilize your shot direction.\"");
//         quote.setWrapText(true);
//         quote.setStyle("-fx-text-fill: #cbd5e1; -fx-font-size: 13px; -fx-font-style: italic; -fx-line-spacing: 5px;");

//         VBox plansBox = new VBox(10);
//         Label planTitle = new Label("ACTIVE PLANS");
//         planTitle.setStyle("-fx-text-fill: #34d399; -fx-font-size: 11px; -fx-font-weight: bold; -fx-letter-spacing: 1px;");
//         plansBox.getChildren().addAll(
//             planTitle,
//             createDarkPlanRow("Power Hitting Fundamentals", "75%", true),
//             createDarkPlanRow("Reverse Swing Mastery", "Coming Soon", false)
//         );

//         Button vrBtn = new Button("Launch VR Simulation");
//         vrBtn.setMaxWidth(Double.MAX_VALUE);
//         vrBtn.setStyle("-fx-background-color: #059669; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 12; -fx-background-radius: 8; -fx-cursor: hand;");

//         card.getChildren().addAll(header, quote, plansBox, vrBtn);
//         return card;
//     }

//     private HBox createDarkPlanRow(String title, String val, boolean isGreenVal) {
//         HBox row = new HBox();
//         Label t = new Label(title);
//         t.setStyle("-fx-text-fill: white; -fx-font-size: 12px;");
//         Region spacer = new Region(); HBox.setHgrow(spacer, Priority.ALWAYS);
//         Label v = new Label(val);
//         v.setStyle("-fx-font-size: 12px; -fx-text-fill: " + (isGreenVal ? "#34d399" : "#64748b") + ";");
//         row.getChildren().addAll(t, spacer, v);
//         return row;
//     }

//     private HBox buildWeatherEquipmentRow() {
//         HBox row = new HBox(15);
//         VBox weather = new VBox(5);
//         weather.setAlignment(Pos.CENTER);
//         weather.setPadding(new Insets(15));
//         weather.setStyle("-fx-background-color: white; -fx-background-radius: 12; -fx-border-color: #f1f5f9; -fx-border-radius: 12;");
//         Label wIcon = new Label("☀"); wIcon.setStyle("-fx-text-fill: #10b981; -fx-font-size: 20px;");
//         Label wTemp = new Label("28°C Clear"); wTemp.setStyle("-fx-font-weight: bold; -fx-font-size: 12px;");
//         Label wSub = new Label("Perfect for Nets"); wSub.setStyle("-fx-font-size: 10px; -fx-text-fill: #64748b;");
//         weather.getChildren().addAll(wIcon, wTemp, wSub);
//         HBox.setHgrow(weather, Priority.ALWAYS);

//         VBox equip = new VBox(5);
//         equip.setAlignment(Pos.CENTER);
//         equip.setPadding(new Insets(15));
//         equip.setStyle("-fx-background-color: white; -fx-background-radius: 12; -fx-border-color: #f1f5f9; -fx-border-radius: 12;");
//         Label eIcon = new Label("🏏"); eIcon.setStyle("-fx-text-fill: #10b981; -fx-font-size: 20px;");
//         Label eTitle = new Label("Equipment"); eTitle.setStyle("-fx-font-weight: bold; -fx-font-size: 12px;");
//         Label eSub = new Label("2 items needed"); eSub.setStyle("-fx-font-size: 10px; -fx-text-fill: #64748b;");
//         equip.getChildren().addAll(eIcon, eTitle, eSub);
//         HBox.setHgrow(equip, Priority.ALWAYS);

//         row.getChildren().addAll(weather, equip);
//         return row;
//     }

//     private VBox buildMessagesSection() {
//         VBox section = new VBox(15);
//         Label title = new Label("COACH MESSAGES");
//         title.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #64748b; -fx-letter-spacing: 1px;");

//         VBox list = new VBox(15);
//         list.getChildren().addAll(
//             createMessageItem("RD", "Rahul Dravid", "Check your backlift video from yesterday's session.", "#10b981"),
//             createMessageItem("SM", "S. Malinga", "Great yorker consistency. Let's try slow-balls next.", "#6366f1")
//         );

//         section.getChildren().addAll(title, list);
//         return section;
//     }

//     private HBox createMessageItem(String initials, String name, String msg, String color) {
//         HBox item = new HBox(15);
//         Label initLbl = new Label(initials);
//         initLbl.setAlignment(Pos.CENTER);
//         initLbl.setMinSize(36, 36);
//         initLbl.setStyle("-fx-background-color: " + color + "33; -fx-text-fill: " + color + "; -fx-font-weight: bold; -fx-font-size: 12px; -fx-background-radius: 18;");

//         VBox texts = new VBox(3);
//         Label nameLbl = new Label(name);
//         nameLbl.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
//         Label msgLbl = new Label(msg);
//         msgLbl.setWrapText(true);
//         msgLbl.setStyle("-fx-font-size: 12px; -fx-text-fill: #64748b;");
//         texts.getChildren().addAll(nameLbl, msgLbl);

//         item.getChildren().addAll(initLbl, texts);
//         return item;
//     }
// }

package com.athlixcore.view.player.Traning_Fitness;

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

public class Traning_dashboard {

    private StackPane rootContainer;

    public Node getView() {
        if (rootContainer == null) {
            rootContainer = new StackPane();
            rootContainer.setStyle("-fx-background-color: #f8fafc;");

            VBox mainLayout = new VBox(25);
            mainLayout.setPadding(new Insets(20, 40, 40, 40));

            // Build UI Sections
            mainLayout.getChildren().addAll(
                buildTopBar(),
                buildHeroBanner(),
                buildStatsRow(),
                buildMainSplitArea()
            );

            ScrollPane scrollPane = new ScrollPane(mainLayout);
            scrollPane.setFitToWidth(true);
            scrollPane.setStyle("-fx-background-color: transparent; -fx-background: #f8fafc;");
            scrollPane.getStylesheets().add("data:text/css,.scroll-pane > .viewport { -fx-background-color: transparent; }");

            rootContainer.getChildren().add(scrollPane);
        }
        return rootContainer;
    }

    // --- TOP NAVIGATION ---
    private HBox buildTopBar() {
        HBox topBar = new HBox(20);
        topBar.setAlignment(Pos.CENTER_LEFT);

        HBox searchBox = new HBox(10);
        searchBox.setAlignment(Pos.CENTER_LEFT);
        searchBox.setStyle("-fx-background-color: white; -fx-background-radius: 20; -fx-padding: 8 15; -fx-border-color: #e2e8f0; -fx-border-radius: 20;");
        Label searchIcon = new Label("🔍");
        searchIcon.setStyle("-fx-text-fill: #94a3b8;");
        TextField searchField = new TextField();
        searchField.setPromptText("Search training modules, coaches, or stats...");
        searchField.setStyle("-fx-background-color: transparent; -fx-border-width: 0; -fx-pref-width: 300px;");
        searchBox.getChildren().addAll(searchIcon, searchField);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        HBox navLinks = new HBox(25);
        navLinks.setAlignment(Pos.CENTER);
        navLinks.getChildren().addAll(
            createNavLink("Performance", false),
            createNavLink("Team", true), 
            createNavLink("Resources", false)
        );

        Label bellIcon = new Label("🔔");
        bellIcon.setStyle("-fx-font-size: 18px; -fx-cursor: hand;");
        Label settingsIcon = new Label("⚙");
        settingsIcon.setStyle("-fx-font-size: 18px; -fx-cursor: hand;");

        Circle avatar = new Circle(18);
        try { avatar.setFill(new javafx.scene.paint.ImagePattern(new Image("https://randomuser.me/api/portraits/men/32.jpg"))); } 
        catch (Exception e) { avatar.setFill(Color.GRAY); }

        topBar.getChildren().addAll(searchBox, spacer, navLinks, bellIcon, settingsIcon, avatar);
        return topBar;
    }

    private VBox createNavLink(String text, boolean isActive) {
        VBox box = new VBox(5);
        box.setAlignment(Pos.CENTER);
        Label lbl = new Label(text);
        lbl.setStyle(isActive ? "-fx-font-weight: bold; -fx-text-fill: #0f172a; -fx-font-size: 14px; -fx-cursor: hand;" : "-fx-font-weight: normal; -fx-text-fill: #64748b; -fx-font-size: 14px; -fx-cursor: hand;");
        Region indicator = new Region();
        indicator.setPrefSize(30, 3);
        indicator.setStyle(isActive ? "-fx-background-color: #10b981; -fx-background-radius: 2;" : "-fx-background-color: transparent;");
        box.getChildren().addAll(lbl, indicator);
        return box;
    }

    // --- HERO BANNER ---
    private StackPane buildHeroBanner() {
        StackPane bannerPane = new StackPane();
        bannerPane.setMinHeight(220);
        bannerPane.setStyle("-fx-background-radius: 20; -fx-border-radius: 20; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 20, 0, 0, 5);");

        Region bg = new Region();
        bg.setStyle("-fx-background-color: linear-gradient(to right, #1e293b, #0f172a); -fx-background-radius: 20;");
        
        HBox contentLayout = new HBox(30);
        contentLayout.setAlignment(Pos.CENTER_LEFT);
        contentLayout.setPadding(new Insets(30, 40, 30, 40));

        StackPane avatarRing = new StackPane();
        Circle outerRing = new Circle(65, Color.TRANSPARENT);
        outerRing.setStroke(Color.web("#10b981"));
        outerRing.setStrokeWidth(3);
        Circle innerAvatar = new Circle(55);
        try { innerAvatar.setFill(new javafx.scene.paint.ImagePattern(new Image("https://randomuser.me/api/portraits/men/32.jpg"))); } 
        catch (Exception e) { innerAvatar.setFill(Color.DARKGRAY); }
        avatarRing.getChildren().addAll(outerRing, innerAvatar);

        VBox textLayout = new VBox(15);
        textLayout.setAlignment(Pos.CENTER_LEFT);
        
        HBox nameRow = new HBox(15);
        nameRow.setAlignment(Pos.CENTER_LEFT);
        Label nameLbl = new Label("Aashish Mohan Bhosale");
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
        
        Button calBtn = new Button("Training\nCalendar");
        calBtn.setStyle("-fx-background-color: rgba(255,255,255,0.1); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 8 20; -fx-text-alignment: center; -fx-cursor: hand;");

        Button bookBtn = new Button("Book\nCoach");
        bookBtn.setStyle("-fx-background-color: rgba(255,255,255,0.1); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 8 20; -fx-text-alignment: center; -fx-cursor: hand;");

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
        for(Node n : row.getChildren()) HBox.setHgrow(n, Priority.ALWAYS);
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

        Region spacer = new Region(); HBox.setHgrow(spacer, Priority.ALWAYS);
        card.getChildren().addAll(texts, spacer, circlePane);
        return card;
    }

    private HBox createIconStatCard(String title, String value, String icon) {
        HBox card = buildBaseCard();
        VBox texts = new VBox(5, createStatTitle(title), createStatValue(value));
        Region spacer = new Region(); HBox.setHgrow(spacer, Priority.ALWAYS);
        Label iconLbl = new Label(icon);
        iconLbl.setStyle("-fx-font-size: 24px; -fx-text-fill: #94a3b8;");
        card.getChildren().addAll(texts, spacer, iconLbl);
        return card;
    }

    private HBox createIconStatCardWithGreen(String title, String value, String icon) {
        HBox card = buildBaseCard();
        VBox texts = new VBox(5, createStatTitle(title), createStatValue(value, "#10b981"));
        Region spacer = new Region(); HBox.setHgrow(spacer, Priority.ALWAYS);
        
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

    // --- MAIN SPLIT (LEFT + RIGHT) ---
    private HBox buildMainSplitArea() {
        HBox splitLayout = new HBox(30);

        // LEFT COLUMN
        VBox leftCol = new VBox(30);
        HBox.setHgrow(leftCol, Priority.ALWAYS);
        leftCol.getChildren().addAll(buildCategoriesSection(), buildAnalyticsSection());

        // RIGHT COLUMN
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

    // --- CATEGORIES GRID ---
    private VBox buildCategoriesSection() {
        VBox section = new VBox(15);
        HBox header = new HBox();
        Label title = new Label("Training Categories");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: #334155;");
        Region spacer = new Region(); HBox.setHgrow(spacer, Priority.ALWAYS);
        Label viewAll = new Label("View All Drills");
        viewAll.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-text-fill: #10b981; -fx-cursor: hand;");
        header.getChildren().addAll(title, spacer, viewAll);

        GridPane grid = new GridPane();
        grid.setHgap(15); grid.setVgap(15);
        ColumnConstraints cc = new ColumnConstraints(); cc.setPercentWidth(33.33);
        grid.getColumnConstraints().addAll(cc, cc, cc);

        grid.add(createImageCard("Batting Practice", "12 Drills Available", "#4f46e5"), 0, 0);
        grid.add(createImageCard("Bowling Practice", "8 Drills Available", "#b45309"), 1, 0);
        grid.add(createImageCard("Strength & Agility", "15 High-Intensity Plans", "#15803d"), 2, 0);
        grid.add(createImageCard("Fielding Practice", "6 Expert Sessions", "#047857"), 0, 1);
        grid.add(createImageCard("Video Analysis", "Scan & Compare", "#0f172a"), 1, 1);
        
        VBox customCard = new VBox(10);
        customCard.setAlignment(Pos.CENTER);
        customCard.setMinHeight(130);
        customCard.setStyle("-fx-background-color: #f8fafc; -fx-border-color: #cbd5e1; -fx-border-style: dashed; -fx-border-width: 2; -fx-background-radius: 12; -fx-border-radius: 12; -fx-cursor: hand;");
        Label plusIcon = new Label("⊕");
        plusIcon.setStyle("-fx-font-size: 24px; -fx-text-fill: #64748b;");
        Label customTxt = new Label("Custom Drill");
        customTxt.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-text-fill: #64748b;");
        customCard.getChildren().addAll(plusIcon, customTxt);
        grid.add(customCard, 2, 1);

        section.getChildren().addAll(header, grid);
        return section;
    }

    private StackPane createImageCard(String title, String subtitle, String fallbackColor) {
        StackPane card = new StackPane();
        card.setMinHeight(130);
        card.setStyle("-fx-background-color: " + fallbackColor + "; -fx-background-radius: 12; -fx-border-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0, 0, 4);");

        Region overlay = new Region();
        overlay.setStyle("-fx-background-color: linear-gradient(to top, rgba(0,0,0,0.9), transparent); -fx-background-radius: 12;");

        VBox textData = new VBox(3);
        textData.setAlignment(Pos.BOTTOM_LEFT);
        textData.setPadding(new Insets(15));
        Label tLbl = new Label(title);
        tLbl.setStyle("-fx-font-weight: bold; -fx-font-size: 15px; -fx-text-fill: white;");
        Label sLbl = new Label(subtitle);
        sLbl.setStyle("-fx-font-size: 12px; -fx-text-fill: #34d399;");
        textData.getChildren().addAll(tLbl, sLbl);

        card.getChildren().addAll(overlay, textData);
        return card;
    }

    // --- ANALYTICS (RADAR & BAR CHARTS) ---
    private VBox buildAnalyticsSection() {
        VBox box = new VBox(20);
        box.setPadding(new Insets(25));
        box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.04), 15, 0, 0, 5);");

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
            bar.setArcWidth(4); bar.setArcHeight(4);
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
        box.setStyle("-fx-background-color: #f8fafc; -fx-background-radius: 8;");
        Label t = new Label(title);
        t.setStyle("-fx-font-size: 11px; -fx-text-fill: #64748b;");
        Label v = new Label(val);
        v.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: " + valColor + ";");
        box.getChildren().addAll(t, v);
        return box;
    }

    // --- RIGHT SIDEBAR SCHEDULE & AI ---
    private VBox buildScheduleSection() {
        VBox section = new VBox(15);
        HBox header = new HBox();
        Label title = new Label("Today's Schedule");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: #334155;");
        Region spacer = new Region(); HBox.setHgrow(spacer, Priority.ALWAYS);
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

        card.getChildren().addAll(header, quote, plansBox, vrBtn);
        return card;
    }

    private HBox createDarkPlanRow(String title, String val, boolean isGreenVal) {
        HBox row = new HBox();
        Label t = new Label(title);
        t.setStyle("-fx-text-fill: white; -fx-font-size: 12px;");
        Region spacer = new Region(); HBox.setHgrow(spacer, Priority.ALWAYS);
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
        Label wIcon = new Label("☀"); wIcon.setStyle("-fx-text-fill: #10b981; -fx-font-size: 20px;");
        Label wTemp = new Label("28°C Clear"); wTemp.setStyle("-fx-font-weight: bold; -fx-font-size: 12px;");
        Label wSub = new Label("Perfect for Nets"); wSub.setStyle("-fx-font-size: 10px; -fx-text-fill: #64748b;");
        weather.getChildren().addAll(wIcon, wTemp, wSub);
        HBox.setHgrow(weather, Priority.ALWAYS);

        VBox equip = new VBox(5);
        equip.setAlignment(Pos.CENTER);
        equip.setPadding(new Insets(15));
        equip.setStyle("-fx-background-color: white; -fx-background-radius: 12; -fx-border-color: #f1f5f9; -fx-border-radius: 12;");
        Label eIcon = new Label("🏏"); eIcon.setStyle("-fx-text-fill: #10b981; -fx-font-size: 20px;");
        Label eTitle = new Label("Equipment"); eTitle.setStyle("-fx-font-weight: bold; -fx-font-size: 12px;");
        Label eSub = new Label("2 items needed"); eSub.setStyle("-fx-font-size: 10px; -fx-text-fill: #64748b;");
        equip.getChildren().addAll(eIcon, eTitle, eSub);
        HBox.setHgrow(equip, Priority.ALWAYS);

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
        return item;
    }
}