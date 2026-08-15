// // package com.athlixcore.view.player.Training_Fitness;

// // import javafx.animation.FadeTransition;
// // import javafx.animation.ParallelTransition;
// // import javafx.animation.ScaleTransition;
// // import javafx.animation.TranslateTransition;
// // import javafx.geometry.Insets;
// // import javafx.geometry.Pos;
// // import javafx.scene.Node;
// // import javafx.scene.control.Button;
// // import javafx.scene.control.Label;
// // import javafx.scene.control.ScrollPane;
// // import javafx.scene.layout.*;
// // import javafx.scene.paint.Color;
// // import javafx.scene.shape.Circle;
// // import javafx.scene.shape.Rectangle;
// // import javafx.util.Duration;

// // public class Fitness_Dashboard {

// //     private StackPane rootContainer;

// //     public Node getView() {
// //         if (rootContainer == null) {
// //             rootContainer = new StackPane();
// //             rootContainer.setStyle("-fx-background-color: #f8fafc;");

// //             VBox mainLayout = new VBox(25);
// //             mainLayout.setPadding(new Insets(20, 40, 40, 40));

// //             // Build UI Sections
// //             Node heroBanner = buildHeroBanner();
// //             Node metricsRow = buildMetricsRow();
// //             Node splitArea = buildMainSplitArea();

// //             mainLayout.getChildren().addAll(heroBanner, metricsRow, splitArea);

// //             // Cascading Entrance Animations
// //             animateNodeEntrance(heroBanner, 50);
// //             animateNodeEntrance(metricsRow, 150);
// //             animateNodeEntrance(splitArea, 250);

// //             ScrollPane scrollPane = new ScrollPane(mainLayout);
// //             scrollPane.setFitToWidth(true);
// //             scrollPane.setStyle("-fx-background-color: transparent; -fx-background: #f8fafc;");
// //             scrollPane.getStylesheets().add("data:text/css,.scroll-pane > .viewport { -fx-background-color: transparent; }");

// //             rootContainer.getChildren().add(scrollPane);
// //         }
// //         return rootContainer;
// //     }

// //     // --- ANIMATION HELPERS ---
// //     private void animateNodeEntrance(Node node, int delayMillis) {
// //         node.setOpacity(0);
// //         node.setTranslateY(25);

// //         FadeTransition ft = new FadeTransition(Duration.millis(600), node);
// //         ft.setToValue(1.0);

// //         TranslateTransition tt = new TranslateTransition(Duration.millis(600), node);
// //         tt.setToY(0);

// //         ParallelTransition pt = new ParallelTransition(ft, tt);
// //         pt.setDelay(Duration.millis(delayMillis));
// //         pt.play();
// //     }

// //     private void addHoverScale(Node node) {
// //         ScaleTransition scaleIn = new ScaleTransition(Duration.millis(150), node);
// //         scaleIn.setToX(1.03); 
// //         scaleIn.setToY(1.03);
        
// //         ScaleTransition scaleOut = new ScaleTransition(Duration.millis(150), node);
// //         scaleOut.setToX(1.0); 
// //         scaleOut.setToY(1.0);

// //         node.setOnMouseEntered(e -> scaleIn.playFromStart());
// //         node.setOnMouseExited(e -> scaleOut.playFromStart());
// //     }

// //     // --- HERO BANNER (Elite Performance Hub) ---
// //     private StackPane buildHeroBanner() {
// //         StackPane bannerPane = new StackPane();
// //         bannerPane.setMinHeight(200);
// //         bannerPane.setStyle("-fx-background-radius: 20; -fx-border-radius: 20; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.15), 20, 0, 0, 5);");

// //         Region bg = new Region();
// //         // Mimicking the twilight stadium background gradient from your image
// //         bg.setStyle("-fx-background-color: linear-gradient(to right, #0f172a, #1e293b, #2e1065); -fx-background-radius: 20;");
        
// //         VBox contentLayout = new VBox(15);
// //         contentLayout.setAlignment(Pos.CENTER_LEFT);
// //         contentLayout.setPadding(new Insets(30, 40, 30, 40));

// //         // Top Tag
// //         Label tag = new Label("FITNESS COMMAND CENTER");
// //         tag.setStyle("-fx-background-color: #10b981; -fx-text-fill: white; -fx-font-size: 10px; -fx-font-weight: bold; -fx-padding: 3 8; -fx-background-radius: 4;");

// //         // Title & Subtitle
// //         Label title = new Label("Elite Performance Hub");
// //         title.setStyle("-fx-font-size: 32px; -fx-font-weight: bold; -fx-text-fill: white;");
        
// //         Label subtitle = new Label("Optimized training data for Vikram Malhotra. Readiness is currently Optimal\nfor high-intensity bowling sessions.");
// //         subtitle.setStyle("-fx-font-size: 13px; -fx-text-fill: #94a3b8;");

// //         // Bottom Stats & Buttons Row
// //         HBox bottomRow = new HBox(30);
// //         bottomRow.setAlignment(Pos.BOTTOM_LEFT);
// //         bottomRow.setPadding(new Insets(10, 0, 0, 0));

// //         // Stats
// //         HBox statsBox = new HBox(25);
// //         statsBox.getChildren().addAll(
// //             createBannerStat("FITNESS\nSCORE", "88/100", "#10b981"),
// //             createBannerStat("RECOVERY", "92%", "#10b981"),
// //             createBannerStat("INJURY\nRISK", "Low", "#34d399")
// //         );

// //         Region spacer = new Region();
// //         HBox.setHgrow(spacer, Priority.ALWAYS);

// //         // Buttons
// //         HBox buttonsBox = new HBox(15);
        
// //         Button syncBtn = new Button("↻ Sync\nWearable");
// //         syncBtn.setStyle("-fx-background-color: #10b981; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 8 20; -fx-text-alignment: center; -fx-cursor: hand;");
// //         addHoverScale(syncBtn);

// //         Button startBtn = new Button("▶ Start\nWorkout");
// //         startBtn.setStyle("-fx-background-color: white; -fx-text-fill: #0f172a; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 8 20; -fx-text-alignment: center; -fx-cursor: hand;");
// //         addHoverScale(startBtn);

// //         Button logBtn = new Button("Log\nNutrition");
// //         logBtn.setStyle("-fx-background-color: rgba(255,255,255,0.15); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 8 20; -fx-text-alignment: center; -fx-cursor: hand;");
// //         addHoverScale(logBtn);

// //         buttonsBox.getChildren().addAll(syncBtn, startBtn, logBtn);

// //         bottomRow.getChildren().addAll(statsBox, spacer, buttonsBox);

// //         contentLayout.getChildren().addAll(tag, title, subtitle, bottomRow);
// //         bannerPane.getChildren().addAll(bg, contentLayout);
        
// //         return bannerPane;
// //     }

// //     private VBox createBannerStat(String labelText, String valueText, String valueColor) {
// //         VBox box = new VBox(2);
// //         Label lbl = new Label(labelText);
// //         lbl.setStyle("-fx-text-fill: #64748b; -fx-font-size: 10px; -fx-font-weight: bold; -fx-letter-spacing: 1px;");
// //         Label val = new Label(valueText);
// //         val.setStyle("-fx-text-fill: " + valueColor + "; -fx-font-weight: bold; -fx-font-size: 24px;");
// //         box.getChildren().addAll(lbl, val);
// //         return box;
// //     }

// //     // --- 5 METRICS ROW ---
// //     private HBox buildMetricsRow() {
// //         HBox row = new HBox(15);
// //         row.getChildren().addAll(
// //             createMetricCard("🔥", "CALORIES", "2,450", "#10b981", 0.75),
// //             createMetricCard("👣", "STEPS", "12,400", "#3b82f6", 0.85),
// //             createMetricCard("🌙", "SLEEP", "7h\n45m", "#8b5cf6", 0.90),
// //             createMetricCard("❤️", "HEART\nRATE", "62 bpm", "#ef4444", 0.60),
// //             createMetricCard("💧", "WATER", "3.2L", "#0ea5e9", 0.80)
// //         );
// //         for(Node n : row.getChildren()) {
// //             HBox.setHgrow(n, Priority.ALWAYS);
// //         }
// //         return row;
// //     }

// //     private VBox createMetricCard(String icon, String title, String value, String color, double progress) {
// //         VBox card = new VBox(10);
// //         card.setAlignment(Pos.CENTER);
// //         card.setPadding(new Insets(20));
// //         card.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4); -fx-cursor: hand;");
// //         addHoverScale(card);

// //         // Circular Icon
// //         StackPane circlePane = new StackPane();
// //         Circle bgCircle = new Circle(24, Color.TRANSPARENT);
// //         bgCircle.setStroke(Color.web("#f1f5f9"));
// //         bgCircle.setStrokeWidth(3);
        
// //         Circle progCircle = new Circle(24, Color.TRANSPARENT);
// //         progCircle.setStroke(Color.web(color));
// //         progCircle.setStrokeWidth(3);
// //         progCircle.getStrokeDashArray().addAll(progress * 150, 150.0);
        
// //         Label iconLbl = new Label(icon);
// //         iconLbl.setStyle("-fx-font-size: 18px;");
// //         circlePane.getChildren().addAll(bgCircle, progCircle, iconLbl);

// //         Label tLbl = new Label(title);
// //         tLbl.setStyle("-fx-font-size: 11px; -fx-font-weight: bold; -fx-text-fill: #64748b; -fx-letter-spacing: 1px; -fx-text-alignment: center;");
        
// //         Label vLbl = new Label(value);
// //         vLbl.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #0f172a; -fx-text-alignment: center;");

// //         card.getChildren().addAll(circlePane, tLbl, vLbl);
// //         return card;
// //     }

// //     // --- MAIN SPLIT AREA (Chart + AI Sidebar) ---
// //     private HBox buildMainSplitArea() {
// //         HBox splitLayout = new HBox(25);

// //         // Left Column (Chart)
// //         VBox leftCol = buildChartSection();
// //         HBox.setHgrow(leftCol, Priority.ALWAYS);

// //         // Right Column (AI Intelligence)
// //         VBox rightCol = buildAISection();
// //         rightCol.setPrefWidth(340);
// //         rightCol.setMinWidth(340);

// //         splitLayout.getChildren().addAll(leftCol, rightCol);
// //         return splitLayout;
// //     }

// //     // --- LEFT CHART SECTION ---
// //     private VBox buildChartSection() {
// //         VBox box = new VBox(20);
// //         box.setPadding(new Insets(25));
// //         box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.04), 15, 0, 0, 5);");
// //         addHoverScale(box);

// //         HBox header = new HBox();
// //         VBox titles = new VBox(3);
// //         Label title = new Label("Weekly Performance Trend");
// //         title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #0f172a;");
// //         Label sub = new Label("Active minutes and training intensity");
// //         sub.setStyle("-fx-font-size: 13px; -fx-text-fill: #64748b;");
// //         titles.getChildren().addAll(title, sub);

// //         Region spacer = new Region();
// //         HBox.setHgrow(spacer, Priority.ALWAYS);

// //         // Legend
// //         HBox legend = new HBox(15);
// //         legend.setAlignment(Pos.CENTER);
// //         legend.getChildren().addAll(
// //             createLegendItem("Active Minutes", "#10b981"),
// //             createLegendItem("Intensity", "#3b82f6")
// //         );

// //         header.getChildren().addAll(titles, spacer, legend);

// //         // Bar Chart Mockup
// //         HBox chart = new HBox(25);
// //         chart.setAlignment(Pos.BOTTOM_CENTER);
// //         chart.setMinHeight(200);
// //         chart.setPadding(new Insets(20, 0, 0, 0));

// //         double[][] data = {
// //             {60, 40}, {140, 100}, {90, 60}, {180, 150}, {130, 110}, {40, 30}, {60, 50}
// //         };
// //         String[] days = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

// //         for (int i = 0; i < data.length; i++) {
// //             VBox barGroup = new VBox(10);
// //             barGroup.setAlignment(Pos.BOTTOM_CENTER);
            
// //             HBox bars = new HBox(4);
// //             bars.setAlignment(Pos.BOTTOM_CENTER);
            
// //             Rectangle bar1 = new Rectangle(18, data[i][0]);
// //             bar1.setArcWidth(6); bar1.setArcHeight(6);
// //             bar1.setFill(Color.web(i == 3 ? "#10b981" : "#d1fae5")); // Highlight THU
            
// //             Rectangle bar2 = new Rectangle(18, data[i][1]);
// //             bar2.setArcWidth(6); bar2.setArcHeight(6);
// //             bar2.setFill(Color.web(i == 3 ? "#3b82f6" : "#dbeafe")); // Highlight THU

// //             bars.getChildren().addAll(bar1, bar2);

// //             Label dayLbl = new Label(days[i]);
// //             dayLbl.setStyle("-fx-font-size: 11px; -fx-font-weight: bold; -fx-text-fill: #64748b;");
            
// //             barGroup.getChildren().addAll(bars, dayLbl);
// //             chart.getChildren().add(barGroup);
// //         }

// //         box.getChildren().addAll(header, chart);
// //         return box;
// //     }

// //     private HBox createLegendItem(String text, String color) {
// //         HBox item = new HBox(5);
// //         item.setAlignment(Pos.CENTER);
// //         Circle dot = new Circle(4, Color.web(color));
// //         Label lbl = new Label(text);
// //         lbl.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #475569;");
// //         item.getChildren().addAll(dot, lbl);
// //         return item;
// //     }

// //     // --- RIGHT AI INTELLIGENCE SECTION ---
// //     private VBox buildAISection() {
// //         VBox box = new VBox(20);
// //         box.setPadding(new Insets(25));
// //         box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.04), 15, 0, 0, 5);");
// //         addHoverScale(box);

// //         // Header
// //         HBox header = new HBox(10);
// //         header.setAlignment(Pos.CENTER_LEFT);
// //         Label icon = new Label("🤖");
// //         icon.setStyle("-fx-text-fill: #10b981; -fx-font-size: 18px;");
// //         Label title = new Label("AI Intelligence");
// //         title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
// //         header.getChildren().addAll(icon, title);

// //         // Readiness Box
// //         VBox readinessBox = new VBox(5);
// //         readinessBox.setPadding(new Insets(15));
// //         readinessBox.setStyle("-fx-background-color: #d1fae5; -fx-background-radius: 12;");
// //         Label rTitle = new Label("PERFORMANCE READINESS");
// //         rTitle.setStyle("-fx-font-size: 10px; -fx-font-weight: bold; -fx-text-fill: #059669; -fx-letter-spacing: 1px;");
// //         Label rVal = new Label("Optimal");
// //         rVal.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: #064e3b;");
// //         readinessBox.getChildren().addAll(rTitle, rVal);

// //         // Stat Rows
// //         VBox list = new VBox(15);
// //         list.getChildren().addAll(
// //             createAIRow("Muscle Fatigue", "LOW", "#10b981", "#d1fae5"),
// //             createAIRow("Recommended Intensity", "HIGH", "#3b82f6", "#dbeafe"),
// //             createAIRow("Sleep Quality", "EXCELLENT", "#10b981", "#d1fae5")
// //         );

// //         // Recovery Timeline
// //         VBox recoveryBox = new VBox(8);
// //         Label recTitle = new Label("Recovery Timeline");
// //         recTitle.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
        
// //         HBox recLabels = new HBox();
// //         Label l1 = new Label("Fatigued");
// //         l1.setStyle("-fx-font-size: 10px; -fx-text-fill: #64748b;");
// //         Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);
// //         Label l2 = new Label("92% Recovered");
// //         l2.setStyle("-fx-font-size: 10px; -fx-font-weight: bold; -fx-text-fill: #10b981;");
// //         recLabels.getChildren().addAll(l1, sp, l2);

// //         // Progress bar visual
// //         StackPane barPane = new StackPane();
// //         barPane.setAlignment(Pos.CENTER_LEFT);
// //         Rectangle bgBar = new Rectangle(280, 6, Color.web("#f1f5f9"));
// //         bgBar.setArcWidth(6); bgBar.setArcHeight(6);
// //         Rectangle progBar = new Rectangle(257, 6, Color.web("#10b981")); // 92% of 280
// //         progBar.setArcWidth(6); progBar.setArcHeight(6);
// //         barPane.getChildren().addAll(bgBar, progBar);

// //         recoveryBox.getChildren().addAll(recTitle, recLabels, barPane);

// //         // Floating '+' Button simulation
// //         HBox bottomBtnRow = new HBox();
// //         bottomBtnRow.setAlignment(Pos.CENTER_RIGHT);
// //         Button addBtn = new Button("+");
// //         addBtn.setStyle("-fx-background-color: #065f46; -fx-text-fill: white; -fx-font-size: 24px; -fx-font-weight: bold; -fx-background-radius: 25; -fx-min-width: 50px; -fx-min-height: 50px; -fx-cursor: hand; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 10, 0, 0, 4);");
// //         addHoverScale(addBtn);
// //         bottomBtnRow.getChildren().add(addBtn);

// //         box.getChildren().addAll(header, readinessBox, list, recoveryBox, bottomBtnRow);
// //         return box;
// //     }

// //     private HBox createAIRow(String label, String status, String textColor, String bgColor) {
// //         HBox row = new HBox();
// //         row.setAlignment(Pos.CENTER_LEFT);
// //         Label l = new Label(label);
// //         l.setStyle("-fx-font-size: 13px; -fx-text-fill: #64748b; -fx-font-weight: bold;");
        
// //         Region spacer = new Region();
// //         HBox.setHgrow(spacer, Priority.ALWAYS);

// //         Label s = new Label(status);
// //         s.setStyle("-fx-font-size: 10px; -fx-font-weight: bold; -fx-text-fill: " + textColor + "; -fx-background-color: " + bgColor + "; -fx-padding: 4 10; -fx-background-radius: 6;");

// //         row.getChildren().addAll(l, spacer, s);
// //         return row;
// //     }
// // }


// package com.athlixcore.view.player.Training_Fitness;

// import javafx.animation.FadeTransition;
// import javafx.animation.ParallelTransition;
// import javafx.animation.ScaleTransition;
// import javafx.animation.TranslateTransition;
// import javafx.geometry.Insets;
// import javafx.geometry.Pos;
// import javafx.scene.Node;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.control.ScrollPane;
// import javafx.scene.layout.*;
// import javafx.scene.paint.Color;
// import javafx.scene.shape.Circle;
// import javafx.scene.shape.Rectangle;
// import javafx.util.Duration;

// public class Fitness_Dashboard {

//     private StackPane rootContainer;

//     public Node getView() {
//         if (rootContainer == null) {
//             rootContainer = new StackPane();
//             rootContainer.setStyle("-fx-background-color: #f8fafc;");

//             buildMainView();
//         }
//         return rootContainer;
//     }
    
//     // Extracted the view building so we can re-call it when coming back
//     private void buildMainView() {
//         VBox mainLayout = new VBox(25);
//         mainLayout.setPadding(new Insets(20, 40, 40, 40));

//         // Build UI Sections
//         Node heroBanner = buildHeroBanner();
//         Node metricsRow = buildMetricsRow();
//         Node splitArea = buildMainSplitArea();

//         mainLayout.getChildren().addAll(heroBanner, metricsRow, splitArea);

//         // Cascading Entrance Animations
//         animateNodeEntrance(heroBanner, 50);
//         animateNodeEntrance(metricsRow, 150);
//         animateNodeEntrance(splitArea, 250);

//         ScrollPane scrollPane = new ScrollPane(mainLayout);
//         scrollPane.setFitToWidth(true);
//         scrollPane.setStyle("-fx-background-color: transparent; -fx-background: #f8fafc;");
//         scrollPane.getStylesheets().add("data:text/css,.scroll-pane > .viewport { -fx-background-color: transparent; }");

//         rootContainer.getChildren().setAll(scrollPane);
//     }

//     // --- ANIMATION HELPERS ---
//     private void animateNodeEntrance(Node node, int delayMillis) {
//         node.setOpacity(0);
//         node.setTranslateY(25);

//         FadeTransition ft = new FadeTransition(Duration.millis(600), node);
//         ft.setToValue(1.0);

//         TranslateTransition tt = new TranslateTransition(Duration.millis(600), node);
//         tt.setToY(0);

//         ParallelTransition pt = new ParallelTransition(ft, tt);
//         pt.setDelay(Duration.millis(delayMillis));
//         pt.play();
//     }

//     private void addHoverScale(Node node) {
//         ScaleTransition scaleIn = new ScaleTransition(Duration.millis(150), node);
//         scaleIn.setToX(1.03); 
//         scaleIn.setToY(1.03);
        
//         ScaleTransition scaleOut = new ScaleTransition(Duration.millis(150), node);
//         scaleOut.setToX(1.0); 
//         scaleOut.setToY(1.0);

//         node.setOnMouseEntered(e -> scaleIn.playFromStart());
//         node.setOnMouseExited(e -> scaleOut.playFromStart());
//     }

//     // --- HERO BANNER (Elite Performance Hub) ---
//     private StackPane buildHeroBanner() {
//         StackPane bannerPane = new StackPane();
//         bannerPane.setMinHeight(200);
//         bannerPane.setStyle("-fx-background-radius: 20; -fx-border-radius: 20; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.15), 20, 0, 0, 5);");

//         Region bg = new Region();
//         bg.setStyle("-fx-background-color: linear-gradient(to right, #0f172a, #1e293b, #2e1065); -fx-background-radius: 20;");
        
//         VBox contentLayout = new VBox(15);
//         contentLayout.setAlignment(Pos.CENTER_LEFT);
//         contentLayout.setPadding(new Insets(30, 40, 30, 40));

//         // Top Tag
//         Label tag = new Label("FITNESS COMMAND CENTER");
//         tag.setStyle("-fx-background-color: #10b981; -fx-text-fill: white; -fx-font-size: 10px; -fx-font-weight: bold; -fx-padding: 3 8; -fx-background-radius: 4;");

//         // Title & Subtitle
//         Label title = new Label("Elite Performance Hub");
//         title.setStyle("-fx-font-size: 32px; -fx-font-weight: bold; -fx-text-fill: white;");
        
//         Label subtitle = new Label("Optimized training data for Vikram Malhotra. Readiness is currently Optimal\nfor high-intensity bowling sessions.");
//         subtitle.setStyle("-fx-font-size: 13px; -fx-text-fill: #94a3b8;");

//         // Bottom Stats & Buttons Row
//         HBox bottomRow = new HBox(30);
//         bottomRow.setAlignment(Pos.BOTTOM_LEFT);
//         bottomRow.setPadding(new Insets(10, 0, 0, 0));

//         // Stats
//         HBox statsBox = new HBox(25);
//         statsBox.getChildren().addAll(
//             createBannerStat("FITNESS\nSCORE", "88/100", "#10b981"),
//             createBannerStat("RECOVERY", "92%", "#10b981"),
//             createBannerStat("INJURY\nRISK", "Low", "#34d399")
//         );

//         Region spacer = new Region();
//         HBox.setHgrow(spacer, Priority.ALWAYS);

//         // Buttons
//         HBox buttonsBox = new HBox(15);
        
//         Button syncBtn = new Button("↻ Sync\nWearable");
//         syncBtn.setStyle("-fx-background-color: #10b981; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 8 20; -fx-text-alignment: center; -fx-cursor: hand;");
//         addHoverScale(syncBtn);

//         // === START WORKOUT BUTTON CLICK LOGIC ===
//         Button startBtn = new Button("▶ Start\nWorkout");
//         startBtn.setStyle("-fx-background-color: white; -fx-text-fill: #0f172a; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 8 20; -fx-text-alignment: center; -fx-cursor: hand;");
//         addHoverScale(startBtn);

//         startBtn.setOnAction(e -> {
//             // Instantiate the new detailed start workout UI class
//             Fitness_StartWorkoutButton startWorkoutPage = new Fitness_StartWorkoutButton(() -> {
//                 // Callback to re-render the main fitness dashboard when "Back" is clicked
//                 buildMainView();
//                 rootContainer.setOpacity(0);
//                 FadeTransition ft = new FadeTransition(Duration.millis(400), rootContainer);
//                 ft.setToValue(1.0);
//                 ft.play();
//             });

//             // Replaces the current view inside the Root Container with the new Workout Page
//             rootContainer.getChildren().setAll(startWorkoutPage.getView());

//             // Adds a smooth crossfade effect
//             rootContainer.setOpacity(0);
//             FadeTransition ft = new FadeTransition(Duration.millis(400), rootContainer);
//             ft.setToValue(1.0);
//             ft.play();
//         });
//         // ========================================

//         Button logBtn = new Button("Log\nNutrition");
//         logBtn.setStyle("-fx-background-color: rgba(255,255,255,0.15); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 8 20; -fx-text-alignment: center; -fx-cursor: hand;");
//         addHoverScale(logBtn);

//         buttonsBox.getChildren().addAll(syncBtn, startBtn, logBtn);

//         bottomRow.getChildren().addAll(statsBox, spacer, buttonsBox);

//         contentLayout.getChildren().addAll(tag, title, subtitle, bottomRow);
//         bannerPane.getChildren().addAll(bg, contentLayout);
        
//         return bannerPane;
//     }

//     private VBox createBannerStat(String labelText, String valueText, String valueColor) {
//         VBox box = new VBox(2);
//         Label lbl = new Label(labelText);
//         lbl.setStyle("-fx-text-fill: #64748b; -fx-font-size: 10px; -fx-font-weight: bold; -fx-letter-spacing: 1px;");
//         Label val = new Label(valueText);
//         val.setStyle("-fx-text-fill: " + valueColor + "; -fx-font-weight: bold; -fx-font-size: 24px;");
//         box.getChildren().addAll(lbl, val);
//         return box;
//     }

//     // --- 5 METRICS ROW ---
//     private HBox buildMetricsRow() {
//         HBox row = new HBox(15);
//         row.getChildren().addAll(
//             createMetricCard("🔥", "CALORIES", "2,450", "#10b981", 0.75),
//             createMetricCard("👣", "STEPS", "12,400", "#3b82f6", 0.85),
//             createMetricCard("🌙", "SLEEP", "7h\n45m", "#8b5cf6", 0.90),
//             createMetricCard("❤️", "HEART\nRATE", "62 bpm", "#ef4444", 0.60),
//             createMetricCard("💧", "WATER", "3.2L", "#0ea5e9", 0.80)
//         );
//         for(Node n : row.getChildren()) {
//             HBox.setHgrow(n, Priority.ALWAYS);
//         }
//         return row;
//     }

//     private VBox createMetricCard(String icon, String title, String value, String color, double progress) {
//         VBox card = new VBox(10);
//         card.setAlignment(Pos.CENTER);
//         card.setPadding(new Insets(20));
//         card.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4); -fx-cursor: hand;");
//         addHoverScale(card);

//         // Circular Icon
//         StackPane circlePane = new StackPane();
//         Circle bgCircle = new Circle(24, Color.TRANSPARENT);
//         bgCircle.setStroke(Color.web("#f1f5f9"));
//         bgCircle.setStrokeWidth(3);
        
//         Circle progCircle = new Circle(24, Color.TRANSPARENT);
//         progCircle.setStroke(Color.web(color));
//         progCircle.setStrokeWidth(3);
//         progCircle.getStrokeDashArray().addAll(progress * 150, 150.0);
        
//         Label iconLbl = new Label(icon);
//         iconLbl.setStyle("-fx-font-size: 18px;");
//         circlePane.getChildren().addAll(bgCircle, progCircle, iconLbl);

//         Label tLbl = new Label(title);
//         tLbl.setStyle("-fx-font-size: 11px; -fx-font-weight: bold; -fx-text-fill: #64748b; -fx-letter-spacing: 1px; -fx-text-alignment: center;");
        
//         Label vLbl = new Label(value);
//         vLbl.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #0f172a; -fx-text-alignment: center;");

//         card.getChildren().addAll(circlePane, tLbl, vLbl);
//         return card;
//     }

//     // --- MAIN SPLIT AREA (Chart + AI Sidebar) ---
//     private HBox buildMainSplitArea() {
//         HBox splitLayout = new HBox(25);

//         // Left Column (Chart)
//         VBox leftCol = buildChartSection();
//         HBox.setHgrow(leftCol, Priority.ALWAYS);

//         // Right Column (AI Intelligence)
//         VBox rightCol = buildAISection();
//         rightCol.setPrefWidth(340);
//         rightCol.setMinWidth(340);

//         splitLayout.getChildren().addAll(leftCol, rightCol);
//         return splitLayout;
//     }

//     // --- LEFT CHART SECTION ---
//     private VBox buildChartSection() {
//         VBox box = new VBox(20);
//         box.setPadding(new Insets(25));
//         box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.04), 15, 0, 0, 5);");
//         addHoverScale(box);

//         HBox header = new HBox();
//         VBox titles = new VBox(3);
//         Label title = new Label("Weekly Performance Trend");
//         title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #0f172a;");
//         Label sub = new Label("Active minutes and training intensity");
//         sub.setStyle("-fx-font-size: 13px; -fx-text-fill: #64748b;");
//         titles.getChildren().addAll(title, sub);

//         Region spacer = new Region();
//         HBox.setHgrow(spacer, Priority.ALWAYS);

//         // Legend
//         HBox legend = new HBox(15);
//         legend.setAlignment(Pos.CENTER);
//         legend.getChildren().addAll(
//             createLegendItem("Active Minutes", "#10b981"),
//             createLegendItem("Intensity", "#3b82f6")
//         );

//         header.getChildren().addAll(titles, spacer, legend);

//         // Bar Chart Mockup
//         HBox chart = new HBox(25);
//         chart.setAlignment(Pos.BOTTOM_CENTER);
//         chart.setMinHeight(200);
//         chart.setPadding(new Insets(20, 0, 0, 0));

//         double[][] data = {
//             {60, 40}, {140, 100}, {90, 60}, {180, 150}, {130, 110}, {40, 30}, {60, 50}
//         };
//         String[] days = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

//         for (int i = 0; i < data.length; i++) {
//             VBox barGroup = new VBox(10);
//             barGroup.setAlignment(Pos.BOTTOM_CENTER);
            
//             HBox bars = new HBox(4);
//             bars.setAlignment(Pos.BOTTOM_CENTER);
            
//             Rectangle bar1 = new Rectangle(18, data[i][0]);
//             bar1.setArcWidth(6); bar1.setArcHeight(6);
//             bar1.setFill(Color.web(i == 3 ? "#10b981" : "#d1fae5")); // Highlight THU
            
//             Rectangle bar2 = new Rectangle(18, data[i][1]);
//             bar2.setArcWidth(6); bar2.setArcHeight(6);
//             bar2.setFill(Color.web(i == 3 ? "#3b82f6" : "#dbeafe")); // Highlight THU

//             bars.getChildren().addAll(bar1, bar2);

//             Label dayLbl = new Label(days[i]);
//             dayLbl.setStyle("-fx-font-size: 11px; -fx-font-weight: bold; -fx-text-fill: #64748b;");
            
//             barGroup.getChildren().addAll(bars, dayLbl);
//             chart.getChildren().add(barGroup);
//         }

//         box.getChildren().addAll(header, chart);
//         return box;
//     }

//     private HBox createLegendItem(String text, String color) {
//         HBox item = new HBox(5);
//         item.setAlignment(Pos.CENTER);
//         Circle dot = new Circle(4, Color.web(color));
//         Label lbl = new Label(text);
//         lbl.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #475569;");
//         item.getChildren().addAll(dot, lbl);
//         return item;
//     }

//     // --- RIGHT AI INTELLIGENCE SECTION ---
//     private VBox buildAISection() {
//         VBox box = new VBox(20);
//         box.setPadding(new Insets(25));
//         box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.04), 15, 0, 0, 5);");
//         addHoverScale(box);

//         // Header
//         HBox header = new HBox(10);
//         header.setAlignment(Pos.CENTER_LEFT);
//         Label icon = new Label("🤖");
//         icon.setStyle("-fx-text-fill: #10b981; -fx-font-size: 18px;");
//         Label title = new Label("AI Intelligence");
//         title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
//         header.getChildren().addAll(icon, title);

//         // Readiness Box
//         VBox readinessBox = new VBox(5);
//         readinessBox.setPadding(new Insets(15));
//         readinessBox.setStyle("-fx-background-color: #d1fae5; -fx-background-radius: 12;");
//         Label rTitle = new Label("PERFORMANCE READINESS");
//         rTitle.setStyle("-fx-font-size: 10px; -fx-font-weight: bold; -fx-text-fill: #059669; -fx-letter-spacing: 1px;");
//         Label rVal = new Label("Optimal");
//         rVal.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: #064e3b;");
//         readinessBox.getChildren().addAll(rTitle, rVal);

//         // Stat Rows
//         VBox list = new VBox(15);
//         list.getChildren().addAll(
//             createAIRow("Muscle Fatigue", "LOW", "#10b981", "#d1fae5"),
//             createAIRow("Recommended Intensity", "HIGH", "#3b82f6", "#dbeafe"),
//             createAIRow("Sleep Quality", "EXCELLENT", "#10b981", "#d1fae5")
//         );

//         // Recovery Timeline
//         VBox recoveryBox = new VBox(8);
//         Label recTitle = new Label("Recovery Timeline");
//         recTitle.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
        
//         HBox recLabels = new HBox();
//         Label l1 = new Label("Fatigued");
//         l1.setStyle("-fx-font-size: 10px; -fx-text-fill: #64748b;");
//         Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);
//         Label l2 = new Label("92% Recovered");
//         l2.setStyle("-fx-font-size: 10px; -fx-font-weight: bold; -fx-text-fill: #10b981;");
//         recLabels.getChildren().addAll(l1, sp, l2);

//         // Progress bar visual
//         StackPane barPane = new StackPane();
//         barPane.setAlignment(Pos.CENTER_LEFT);
//         Rectangle bgBar = new Rectangle(280, 6, Color.web("#f1f5f9"));
//         bgBar.setArcWidth(6); bgBar.setArcHeight(6);
//         Rectangle progBar = new Rectangle(257, 6, Color.web("#10b981")); // 92% of 280
//         progBar.setArcWidth(6); progBar.setArcHeight(6);
//         barPane.getChildren().addAll(bgBar, progBar);

//         recoveryBox.getChildren().addAll(recTitle, recLabels, barPane);

//         // Floating '+' Button simulation
//         HBox bottomBtnRow = new HBox();
//         bottomBtnRow.setAlignment(Pos.CENTER_RIGHT);
//         Button addBtn = new Button("+");
//         addBtn.setStyle("-fx-background-color: #065f46; -fx-text-fill: white; -fx-font-size: 24px; -fx-font-weight: bold; -fx-background-radius: 25; -fx-min-width: 50px; -fx-min-height: 50px; -fx-cursor: hand; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 10, 0, 0, 4);");
//         addHoverScale(addBtn);
//         bottomBtnRow.getChildren().add(addBtn);

//         box.getChildren().addAll(header, readinessBox, list, recoveryBox, bottomBtnRow);
//         return box;
//     }

//     private HBox createAIRow(String label, String status, String textColor, String bgColor) {
//         HBox row = new HBox();
//         row.setAlignment(Pos.CENTER_LEFT);
//         Label l = new Label(label);
//         l.setStyle("-fx-font-size: 13px; -fx-text-fill: #64748b; -fx-font-weight: bold;");
        
//         Region spacer = new Region();
//         HBox.setHgrow(spacer, Priority.ALWAYS);

//         Label s = new Label(status);
//         s.setStyle("-fx-font-size: 10px; -fx-font-weight: bold; -fx-text-fill: " + textColor + "; -fx-background-color: " + bgColor + "; -fx-padding: 4 10; -fx-background-radius: 6;");

//         row.getChildren().addAll(l, spacer, s);
//         return row;
//     }
// }


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
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Fitness_Dashboard {

    private StackPane rootContainer;

    public Node getView() {
        if (rootContainer == null) {
            rootContainer = new StackPane();
            rootContainer.setStyle("-fx-background-color: #f8fafc;");

            buildMainView();
        }
        return rootContainer;
    }
    
    // Extracted the view building so we can re-call it when coming back
    private void buildMainView() {
        VBox mainLayout = new VBox(25);
        mainLayout.setPadding(new Insets(20, 40, 40, 40));

        // Build UI Sections
        Node heroBanner = buildHeroBanner();
        Node metricsRow = buildMetricsRow();
        Node splitArea = buildMainSplitArea();

        mainLayout.getChildren().addAll(heroBanner, metricsRow, splitArea);

        // Cascading Entrance Animations
        animateNodeEntrance(heroBanner, 50);
        animateNodeEntrance(metricsRow, 150);
        animateNodeEntrance(splitArea, 250);

        ScrollPane scrollPane = new ScrollPane(mainLayout);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color: transparent; -fx-background: #f8fafc;");
        scrollPane.getStylesheets().add("data:text/css,.scroll-pane > .viewport { -fx-background-color: transparent; }");

        rootContainer.getChildren().setAll(scrollPane);
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

    // --- HERO BANNER (Elite Performance Hub) ---
    private StackPane buildHeroBanner() {
        StackPane bannerPane = new StackPane();
        bannerPane.setMinHeight(200);
        bannerPane.setStyle("-fx-background-radius: 20; -fx-border-radius: 20; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.15), 20, 0, 0, 5);");

        Region bg = new Region();
        bg.setStyle("-fx-background-color: linear-gradient(to right, #0f172a, #1e293b, #2e1065); -fx-background-radius: 20;");
        
        VBox contentLayout = new VBox(15);
        contentLayout.setAlignment(Pos.CENTER_LEFT);
        contentLayout.setPadding(new Insets(30, 40, 30, 40));

        // Top Tag
        Label tag = new Label("FITNESS COMMAND CENTER");
        tag.setStyle("-fx-background-color: #10b981; -fx-text-fill: white; -fx-font-size: 10px; -fx-font-weight: bold; -fx-padding: 3 8; -fx-background-radius: 4;");

        // Title & Subtitle
        Label title = new Label("Elite Performance Hub");
        title.setStyle("-fx-font-size: 32px; -fx-font-weight: bold; -fx-text-fill: white;");
        
        Label subtitle = new Label("Optimized training data for Vikram Malhotra. Readiness is currently Optimal\nfor high-intensity bowling sessions.");
        subtitle.setStyle("-fx-font-size: 13px; -fx-text-fill: #94a3b8;");

        // Bottom Stats & Buttons Row
        HBox bottomRow = new HBox(30);
        bottomRow.setAlignment(Pos.BOTTOM_LEFT);
        bottomRow.setPadding(new Insets(10, 0, 0, 0));

        // Stats
        HBox statsBox = new HBox(25);
        statsBox.getChildren().addAll(
            createBannerStat("FITNESS\nSCORE", "88/100", "#10b981"),
            createBannerStat("RECOVERY", "92%", "#10b981"),
            createBannerStat("INJURY\nRISK", "Low", "#34d399")
        );

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        // Buttons
        HBox buttonsBox = new HBox(15);
        
        Button syncBtn = new Button("↻ Sync\nWearable");
        syncBtn.setStyle("-fx-background-color: #10b981; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 8 20; -fx-text-alignment: center; -fx-cursor: hand;");
        addHoverScale(syncBtn);

        // === START WORKOUT BUTTON CLICK LOGIC ===
        Button startBtn = new Button("▶ Start\nWorkout");
        startBtn.setStyle("-fx-background-color: white; -fx-text-fill: #0f172a; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 8 20; -fx-text-alignment: center; -fx-cursor: hand;");
        addHoverScale(startBtn);

        startBtn.setOnAction(e -> {
            // Instantiate the new detailed start workout UI class
            Fitness_StartWorkoutButton startWorkoutPage = new Fitness_StartWorkoutButton(() -> {
                buildMainView();
                rootContainer.setOpacity(0);
                FadeTransition ft = new FadeTransition(Duration.millis(400), rootContainer);
                ft.setToValue(1.0);
                ft.play();
            });

            rootContainer.getChildren().setAll(startWorkoutPage.getView());

            rootContainer.setOpacity(0);
            FadeTransition ft = new FadeTransition(Duration.millis(400), rootContainer);
            ft.setToValue(1.0);
            ft.play();
        });
        // ========================================

        // === LOG NUTRITION BUTTON CLICK LOGIC ===
        Button logBtn = new Button("Log\nNutrition");
        logBtn.setStyle("-fx-background-color: rgba(255,255,255,0.15); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 8 20; -fx-text-alignment: center; -fx-cursor: hand;");
        addHoverScale(logBtn);

        logBtn.setOnAction(e -> {
            // Instantiate the new Nutrition UI class
            Fitness_LogNutritionButton nutritionPage = new Fitness_LogNutritionButton(() -> {
                // Callback to re-render the main fitness dashboard when "Back" is clicked
                buildMainView();
                rootContainer.setOpacity(0);
                FadeTransition ft = new FadeTransition(Duration.millis(400), rootContainer);
                ft.setToValue(1.0);
                ft.play();
            });

            // Replaces the current view inside the Root Container with the new Nutrition Page
            rootContainer.getChildren().setAll(nutritionPage.getView());

            // Adds a smooth crossfade effect
            rootContainer.setOpacity(0);
            FadeTransition ft = new FadeTransition(Duration.millis(400), rootContainer);
            ft.setToValue(1.0);
            ft.play();
        });
        // ========================================

        buttonsBox.getChildren().addAll(syncBtn, startBtn, logBtn);

        bottomRow.getChildren().addAll(statsBox, spacer, buttonsBox);

        contentLayout.getChildren().addAll(tag, title, subtitle, bottomRow);
        bannerPane.getChildren().addAll(bg, contentLayout);
        
        return bannerPane;
    }

    private VBox createBannerStat(String labelText, String valueText, String valueColor) {
        VBox box = new VBox(2);
        Label lbl = new Label(labelText);
        lbl.setStyle("-fx-text-fill: #64748b; -fx-font-size: 10px; -fx-font-weight: bold; -fx-letter-spacing: 1px;");
        Label val = new Label(valueText);
        val.setStyle("-fx-text-fill: " + valueColor + "; -fx-font-weight: bold; -fx-font-size: 24px;");
        box.getChildren().addAll(lbl, val);
        return box;
    }

    // --- 5 METRICS ROW ---
    private HBox buildMetricsRow() {
        HBox row = new HBox(15);
        row.getChildren().addAll(
            createMetricCard("🔥", "CALORIES", "2,450", "#10b981", 0.75),
            createMetricCard("👣", "STEPS", "12,400", "#3b82f6", 0.85),
            createMetricCard("🌙", "SLEEP", "7h\n45m", "#8b5cf6", 0.90),
            createMetricCard("❤️", "HEART\nRATE", "62 bpm", "#ef4444", 0.60),
            createMetricCard("💧", "WATER", "3.2L", "#0ea5e9", 0.80)
        );
        for(Node n : row.getChildren()) {
            HBox.setHgrow(n, Priority.ALWAYS);
        }
        return row;
    }

    private VBox createMetricCard(String icon, String title, String value, String color, double progress) {
        VBox card = new VBox(10);
        card.setAlignment(Pos.CENTER);
        card.setPadding(new Insets(20));
        card.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4); -fx-cursor: hand;");
        addHoverScale(card);

        // Circular Icon
        StackPane circlePane = new StackPane();
        Circle bgCircle = new Circle(24, Color.TRANSPARENT);
        bgCircle.setStroke(Color.web("#f1f5f9"));
        bgCircle.setStrokeWidth(3);
        
        Circle progCircle = new Circle(24, Color.TRANSPARENT);
        progCircle.setStroke(Color.web(color));
        progCircle.setStrokeWidth(3);
        progCircle.getStrokeDashArray().addAll(progress * 150, 150.0);
        
        Label iconLbl = new Label(icon);
        iconLbl.setStyle("-fx-font-size: 18px;");
        circlePane.getChildren().addAll(bgCircle, progCircle, iconLbl);

        Label tLbl = new Label(title);
        tLbl.setStyle("-fx-font-size: 11px; -fx-font-weight: bold; -fx-text-fill: #64748b; -fx-letter-spacing: 1px; -fx-text-alignment: center;");
        
        Label vLbl = new Label(value);
        vLbl.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #0f172a; -fx-text-alignment: center;");

        card.getChildren().addAll(circlePane, tLbl, vLbl);
        return card;
    }

    // --- MAIN SPLIT AREA (Chart + AI Sidebar) ---
    private HBox buildMainSplitArea() {
        HBox splitLayout = new HBox(25);

        // Left Column (Chart)
        VBox leftCol = buildChartSection();
        HBox.setHgrow(leftCol, Priority.ALWAYS);

        // Right Column (AI Intelligence)
        VBox rightCol = buildAISection();
        rightCol.setPrefWidth(340);
        rightCol.setMinWidth(340);

        splitLayout.getChildren().addAll(leftCol, rightCol);
        return splitLayout;
    }

    // --- LEFT CHART SECTION ---
    private VBox buildChartSection() {
        VBox box = new VBox(20);
        box.setPadding(new Insets(25));
        box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.04), 15, 0, 0, 5);");
        addHoverScale(box);

        HBox header = new HBox();
        VBox titles = new VBox(3);
        Label title = new Label("Weekly Performance Trend");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #0f172a;");
        Label sub = new Label("Active minutes and training intensity");
        sub.setStyle("-fx-font-size: 13px; -fx-text-fill: #64748b;");
        titles.getChildren().addAll(title, sub);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        // Legend
        HBox legend = new HBox(15);
        legend.setAlignment(Pos.CENTER);
        legend.getChildren().addAll(
            createLegendItem("Active Minutes", "#10b981"),
            createLegendItem("Intensity", "#3b82f6")
        );

        header.getChildren().addAll(titles, spacer, legend);

        // Bar Chart Mockup
        HBox chart = new HBox(25);
        chart.setAlignment(Pos.BOTTOM_CENTER);
        chart.setMinHeight(200);
        chart.setPadding(new Insets(20, 0, 0, 0));

        double[][] data = {
            {60, 40}, {140, 100}, {90, 60}, {180, 150}, {130, 110}, {40, 30}, {60, 50}
        };
        String[] days = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

        for (int i = 0; i < data.length; i++) {
            VBox barGroup = new VBox(10);
            barGroup.setAlignment(Pos.BOTTOM_CENTER);
            
            HBox bars = new HBox(4);
            bars.setAlignment(Pos.BOTTOM_CENTER);
            
            Rectangle bar1 = new Rectangle(18, data[i][0]);
            bar1.setArcWidth(6); bar1.setArcHeight(6);
            bar1.setFill(Color.web(i == 3 ? "#10b981" : "#d1fae5")); // Highlight THU
            
            Rectangle bar2 = new Rectangle(18, data[i][1]);
            bar2.setArcWidth(6); bar2.setArcHeight(6);
            bar2.setFill(Color.web(i == 3 ? "#3b82f6" : "#dbeafe")); // Highlight THU

            bars.getChildren().addAll(bar1, bar2);

            Label dayLbl = new Label(days[i]);
            dayLbl.setStyle("-fx-font-size: 11px; -fx-font-weight: bold; -fx-text-fill: #64748b;");
            
            barGroup.getChildren().addAll(bars, dayLbl);
            chart.getChildren().add(barGroup);
        }

        box.getChildren().addAll(header, chart);
        return box;
    }

    private HBox createLegendItem(String text, String color) {
        HBox item = new HBox(5);
        item.setAlignment(Pos.CENTER);
        Circle dot = new Circle(4, Color.web(color));
        Label lbl = new Label(text);
        lbl.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #475569;");
        item.getChildren().addAll(dot, lbl);
        return item;
    }

    // --- RIGHT AI INTELLIGENCE SECTION ---
    private VBox buildAISection() {
        VBox box = new VBox(20);
        box.setPadding(new Insets(25));
        box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.04), 15, 0, 0, 5);");
        addHoverScale(box);

        // Header
        HBox header = new HBox(10);
        header.setAlignment(Pos.CENTER_LEFT);
        Label icon = new Label("🤖");
        icon.setStyle("-fx-text-fill: #10b981; -fx-font-size: 18px;");
        Label title = new Label("AI Intelligence");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
        header.getChildren().addAll(icon, title);

        // Readiness Box
        VBox readinessBox = new VBox(5);
        readinessBox.setPadding(new Insets(15));
        readinessBox.setStyle("-fx-background-color: #d1fae5; -fx-background-radius: 12;");
        Label rTitle = new Label("PERFORMANCE READINESS");
        rTitle.setStyle("-fx-font-size: 10px; -fx-font-weight: bold; -fx-text-fill: #059669; -fx-letter-spacing: 1px;");
        Label rVal = new Label("Optimal");
        rVal.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: #064e3b;");
        readinessBox.getChildren().addAll(rTitle, rVal);

        // Stat Rows
        VBox list = new VBox(15);
        list.getChildren().addAll(
            createAIRow("Muscle Fatigue", "LOW", "#10b981", "#d1fae5"),
            createAIRow("Recommended Intensity", "HIGH", "#3b82f6", "#dbeafe"),
            createAIRow("Sleep Quality", "EXCELLENT", "#10b981", "#d1fae5")
        );

        // Recovery Timeline
        VBox recoveryBox = new VBox(8);
        Label recTitle = new Label("Recovery Timeline");
        recTitle.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
        
        HBox recLabels = new HBox();
        Label l1 = new Label("Fatigued");
        l1.setStyle("-fx-font-size: 10px; -fx-text-fill: #64748b;");
        Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);
        Label l2 = new Label("92% Recovered");
        l2.setStyle("-fx-font-size: 10px; -fx-font-weight: bold; -fx-text-fill: #10b981;");
        recLabels.getChildren().addAll(l1, sp, l2);

        // Progress bar visual
        StackPane barPane = new StackPane();
        barPane.setAlignment(Pos.CENTER_LEFT);
        Rectangle bgBar = new Rectangle(280, 6, Color.web("#f1f5f9"));
        bgBar.setArcWidth(6); bgBar.setArcHeight(6);
        Rectangle progBar = new Rectangle(257, 6, Color.web("#10b981")); // 92% of 280
        progBar.setArcWidth(6); progBar.setArcHeight(6);
        barPane.getChildren().addAll(bgBar, progBar);

        recoveryBox.getChildren().addAll(recTitle, recLabels, barPane);

        // Floating '+' Button simulation
        HBox bottomBtnRow = new HBox();
        bottomBtnRow.setAlignment(Pos.CENTER_RIGHT);
        Button addBtn = new Button("+");
        addBtn.setStyle("-fx-background-color: #065f46; -fx-text-fill: white; -fx-font-size: 24px; -fx-font-weight: bold; -fx-background-radius: 25; -fx-min-width: 50px; -fx-min-height: 50px; -fx-cursor: hand; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 10, 0, 0, 4);");
        addHoverScale(addBtn);
        bottomBtnRow.getChildren().add(addBtn);

        box.getChildren().addAll(header, readinessBox, list, recoveryBox, bottomBtnRow);
        return box;
    }

    private HBox createAIRow(String label, String status, String textColor, String bgColor) {
        HBox row = new HBox();
        row.setAlignment(Pos.CENTER_LEFT);
        Label l = new Label(label);
        l.setStyle("-fx-font-size: 13px; -fx-text-fill: #64748b; -fx-font-weight: bold;");
        
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Label s = new Label(status);
        s.setStyle("-fx-font-size: 10px; -fx-font-weight: bold; -fx-text-fill: " + textColor + "; -fx-background-color: " + bgColor + "; -fx-padding: 4 10; -fx-background-radius: 6;");

        row.getChildren().addAll(l, spacer, s);
        return row;
    }
}