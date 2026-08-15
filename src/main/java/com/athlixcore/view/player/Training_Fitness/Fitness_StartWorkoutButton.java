// // // // package com.athlixcore.view.player.Training_Fitness;

// // // // import javafx.animation.FadeTransition;
// // // // import javafx.animation.ParallelTransition;
// // // // import javafx.animation.ScaleTransition;
// // // // import javafx.animation.TranslateTransition;
// // // // import javafx.geometry.Insets;
// // // // import javafx.geometry.Pos;
// // // // import javafx.scene.Node;
// // // // import javafx.scene.control.Button;
// // // // import javafx.scene.control.Label;
// // // // import javafx.scene.control.ScrollPane;
// // // // import javafx.scene.layout.*;
// // // // import javafx.scene.paint.Color;
// // // // import javafx.scene.shape.Circle;
// // // // import javafx.scene.shape.Line;
// // // // import javafx.scene.shape.Rectangle;
// // // // import javafx.util.Duration;

// // // // public class Fitness_StartWorkoutButton {

// // // //     private StackPane rootContainer;
// // // //     private Runnable onBack;

// // // //     public Fitness_StartWorkoutButton(Runnable onBack) {
// // // //         this.onBack = onBack;
// // // //     }

// // // //     public Node getView() {
// // // //         if (rootContainer == null) {
// // // //             rootContainer = new StackPane();
// // // //             rootContainer.setStyle("-fx-background-color: #f8fafc;");

// // // //             VBox mainLayout = new VBox(25);
// // // //             mainLayout.setPadding(new Insets(20, 40, 40, 40));

// // // //             // --- UI Sections ---
// // // //             Node backButtonRow = buildBackButton();
            
// // // //             // Row 1: Workout Log & Health Metrics
// // // //             HBox row1 = new HBox(25);
// // // //             Node workoutLog = buildWorkoutLog();
// // // //             HBox.setHgrow(workoutLog, Priority.ALWAYS);
// // // //             Node healthMetrics = buildHealthMetrics();
// // // //             row1.getChildren().addAll(workoutLog, healthMetrics);

// // // //             // Row 2: Sleep Cycles & Fatigue
// // // //             HBox row2 = new HBox(25);
// // // //             Node sleepCycles = buildSleepCycles();
// // // //             HBox.setHgrow(sleepCycles, Priority.ALWAYS);
// // // //             Node fatigueSoreness = buildFatigueSoreness();
// // // //             row2.getChildren().addAll(sleepCycles, fatigueSoreness);

// // // //             // Row 3: Daily Goals, Timeline & Daily Coach
// // // //             HBox row3 = new HBox(25);
// // // //             HBox bottomLeftSplit = new HBox(25);
// // // //             HBox.setHgrow(bottomLeftSplit, Priority.ALWAYS);
// // // //             Node dailyGoals = buildDailyGoals();
// // // //             Node timeline = buildActivityTimeline();
// // // //             HBox.setHgrow(dailyGoals, Priority.ALWAYS);
// // // //             HBox.setHgrow(timeline, Priority.ALWAYS);
// // // //             bottomLeftSplit.getChildren().addAll(dailyGoals, timeline);
            
// // // //             Node dailyCoach = buildDailyCoach();
// // // //             row3.getChildren().addAll(bottomLeftSplit, dailyCoach);

// // // //             mainLayout.getChildren().addAll(backButtonRow, row1, row2, row3);

// // // //             // --- Entrance Animations ---
// // // //             animateNodeEntrance(backButtonRow, 0);
// // // //             animateNodeEntrance(row1, 100);
// // // //             animateNodeEntrance(row2, 200);
// // // //             animateNodeEntrance(row3, 300);

// // // //             ScrollPane scrollPane = new ScrollPane(mainLayout);
// // // //             scrollPane.setFitToWidth(true);
// // // //             scrollPane.setStyle("-fx-background-color: transparent; -fx-background: #f8fafc;");
// // // //             scrollPane.getStylesheets().add("data:text/css,.scroll-pane > .viewport { -fx-background-color: transparent; }");

// // // //             rootContainer.getChildren().add(scrollPane);
// // // //         }
// // // //         return rootContainer;
// // // //     }

// // // //     private void animateNodeEntrance(Node node, int delayMillis) {
// // // //         node.setOpacity(0);
// // // //         node.setTranslateY(25);
// // // //         FadeTransition ft = new FadeTransition(Duration.millis(500), node);
// // // //         ft.setToValue(1.0);
// // // //         TranslateTransition tt = new TranslateTransition(Duration.millis(500), node);
// // // //         tt.setToY(0);
// // // //         ParallelTransition pt = new ParallelTransition(ft, tt);
// // // //         pt.setDelay(Duration.millis(delayMillis));
// // // //         pt.play();
// // // //     }

// // // //     private void addHoverScale(Node node) {
// // // //         ScaleTransition scaleIn = new ScaleTransition(Duration.millis(150), node);
// // // //         scaleIn.setToX(1.02); scaleIn.setToY(1.02);
// // // //         ScaleTransition scaleOut = new ScaleTransition(Duration.millis(150), node);
// // // //         scaleOut.setToX(1.0); scaleOut.setToY(1.0);
// // // //         node.setOnMouseEntered(e -> scaleIn.playFromStart());
// // // //         node.setOnMouseExited(e -> scaleOut.playFromStart());
// // // //     }

// // // //     private HBox buildBackButton() {
// // // //         HBox row = new HBox();
// // // //         row.setAlignment(Pos.CENTER_LEFT);
// // // //         Button backBtn = new Button("← Back to Fitness Dashboard");
// // // //         backBtn.setStyle("-fx-background-color: white; -fx-text-fill: #475569; -fx-font-weight: bold; -fx-font-size: 13px; -fx-padding: 8 15; -fx-background-radius: 20; -fx-border-color: #e2e8f0; -fx-border-radius: 20; -fx-cursor: hand;");
// // // //         addHoverScale(backBtn);
// // // //         backBtn.setOnAction(e -> { if (onBack != null) onBack.run(); });
// // // //         row.getChildren().add(backBtn);
// // // //         return row;
// // // //     }

// // // //     // --- ROW 1 COMPONENTS ---
// // // //     private VBox buildWorkoutLog() {
// // // //         VBox box = new VBox(15);
// // // //         box.setPadding(new Insets(25));
// // // //         box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
// // // //         addHoverScale(box);

// // // //         HBox header = new HBox();
// // // //         Label title = new Label("Workout Log");
// // // //         title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #0f172a;");
// // // //         Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);
// // // //         Label toggle = new Label("Today   History");
// // // //         toggle.setStyle("-fx-background-color: #f1f5f9; -fx-padding: 5 12; -fx-background-radius: 15; -fx-font-size: 11px; -fx-font-weight: bold; -fx-text-fill: #64748b;");
// // // //         header.getChildren().addAll(title, sp, toggle);

// // // //         VBox list = new VBox(12);
// // // //         list.getChildren().addAll(
// // // //             createWorkoutItem("🏏", "#d1fae5", "#10b981", "Batting Practice - Technical", "Duration: 45m • Intensity: Medium", "142", "380"),
// // // //             createWorkoutItem("🏃", "#fee2e2", "#ef4444", "Sprint Training - Max Effort", "Duration: 20m • Intensity: High", "168", "410")
// // // //         );
// // // //         box.getChildren().addAll(header, list);
// // // //         return box;
// // // //     }

// // // //     private HBox createWorkoutItem(String icon, String bgHex, String iconHex, String title, String sub, String hr, String kcal) {
// // // //         HBox row = new HBox(15);
// // // //         row.setAlignment(Pos.CENTER_LEFT);
// // // //         row.setPadding(new Insets(15));
// // // //         row.setStyle("-fx-background-color: white; -fx-border-color: #f1f5f9; -fx-border-radius: 12; -fx-background-radius: 12;");

// // // //         StackPane iconPane = new StackPane();
// // // //         Circle c = new Circle(20, Color.web(bgHex));
// // // //         Label i = new Label(icon); i.setStyle("-fx-text-fill: " + iconHex + ";");
// // // //         iconPane.getChildren().addAll(c, i);

// // // //         VBox texts = new VBox(3);
// // // //         Label t = new Label(title); t.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: #0f172a;");
// // // //         Label s = new Label(sub); s.setStyle("-fx-font-size: 11px; -fx-text-fill: #64748b;");
// // // //         texts.getChildren().addAll(t, s);

// // // //         Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);

// // // //         VBox hrBox = new VBox(); hrBox.setAlignment(Pos.CENTER);
// // // //         Label hrV = new Label(hr); hrV.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
// // // //         Label hrL = new Label("Avg HR"); hrL.setStyle("-fx-font-size: 10px; -fx-text-fill: #94a3b8;");
// // // //         hrBox.getChildren().addAll(hrV, hrL);

// // // //         VBox kcalBox = new VBox(); kcalBox.setAlignment(Pos.CENTER);
// // // //         Label kcV = new Label(kcal); kcV.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
// // // //         Label kcL = new Label("kcal"); kcL.setStyle("-fx-font-size: 10px; -fx-text-fill: #94a3b8;");
// // // //         kcalBox.getChildren().addAll(kcV, kcL);

// // // //         Label arrow = new Label(">"); arrow.setStyle("-fx-text-fill: #cbd5e1; -fx-font-size: 18px;");

// // // //         row.getChildren().addAll(iconPane, texts, sp, hrBox, kcalBox, arrow);
// // // //         return row;
// // // //     }

// // // //     private VBox buildHealthMetrics() {
// // // //         VBox box = new VBox(15);
// // // //         box.setPrefWidth(320); box.setMinWidth(320);
// // // //         box.setPadding(new Insets(25));
// // // //         box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
// // // //         addHoverScale(box);

// // // //         Label title = new Label("Health Metrics");
// // // //         title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #0f172a;");

// // // //         GridPane grid = new GridPane();
// // // //         grid.setHgap(10); grid.setVgap(10);
// // // //         ColumnConstraints cc = new ColumnConstraints(); cc.setPercentWidth(50);
// // // //         grid.getColumnConstraints().addAll(cc, cc);

// // // //         grid.add(createMetricSquare("WEIGHT", "78.5", "kg", "-0.2 from\nyesterday", "#10b981"), 0, 0);
// // // //         grid.add(createMetricSquare("BMI", "23.4", "", "Optimal\nRange", "#64748b"), 1, 0);
// // // //         grid.add(createMetricSquare("BLOOD\nPRESSURE", "118/76", "", "Perfect", "#10b981"), 0, 1);
// // // //         grid.add(createMetricSquare("SPO2", "99", "%", "Healthy", "#64748b"), 1, 1);

// // // //         Button manualBtn = new Button("+ Manual Metric Entry");
// // // //         manualBtn.setMaxWidth(Double.MAX_VALUE);
// // // //         manualBtn.setStyle("-fx-background-color: transparent; -fx-border-color: #cbd5e1; -fx-border-style: dashed; -fx-border-radius: 8; -fx-text-fill: #64748b; -fx-font-weight: bold; -fx-padding: 8; -fx-cursor: hand;");

// // // //         box.getChildren().addAll(title, grid, manualBtn);
// // // //         return box;
// // // //     }

// // // //     private VBox createMetricSquare(String title, String val, String unit, String sub, String subColor) {
// // // //         VBox box = new VBox(5);
// // // //         box.setAlignment(Pos.CENTER);
// // // //         box.setPadding(new Insets(15));
// // // //         box.setStyle("-fx-background-color: #f8fafc; -fx-background-radius: 12;");
        
// // // //         Label t = new Label(title); t.setStyle("-fx-font-size: 10px; -fx-font-weight: bold; -fx-text-fill: #64748b; -fx-text-alignment: center;");
        
// // // //         HBox valBox = new HBox(2); valBox.setAlignment(Pos.BOTTOM_CENTER);
// // // //         Label v = new Label(val); v.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
// // // //         Label u = new Label(unit); u.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #0f172a; -fx-translate-y: -4px;");
// // // //         valBox.getChildren().addAll(v, u);

// // // //         Label s = new Label(sub); s.setStyle("-fx-font-size: 9px; -fx-text-fill: " + subColor + "; -fx-text-alignment: center;");
// // // //         box.getChildren().addAll(t, valBox, s);
// // // //         return box;
// // // //     }

// // // //     // --- ROW 2 COMPONENTS ---
// // // //     private VBox buildSleepCycles() {
// // // //         VBox box = new VBox(15);
// // // //         box.setPadding(new Insets(25));
// // // //         box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
// // // //         addHoverScale(box);

// // // //         HBox header = new HBox();
// // // //         VBox titles = new VBox(2);
// // // //         Label title = new Label("Sleep Cycles"); title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #0f172a;");
// // // //         Label sub = new Label("Efficiency: 94% • 11:20 PM - 07:15 AM"); sub.setStyle("-fx-font-size: 12px; -fx-text-fill: #64748b;");
// // // //         titles.getChildren().addAll(title, sub);
// // // //         Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);
// // // //         Label moon = new Label("🌙"); moon.setStyle("-fx-text-fill: #94a3b8; -fx-font-size: 20px;");
// // // //         header.getChildren().addAll(titles, sp, moon);

// // // //         // Chart Fake
// // // //         HBox chart = new HBox(8);
// // // //         chart.setAlignment(Pos.BOTTOM_CENTER);
// // // //         chart.setMinHeight(140);
        
// // // //         String deep = "#0f172a", rem = "#a7f3d0", light = "#bfdbfe";
// // // //         double[] heights = {80, 120, 90, 60, 110, 50, 80};
// // // //         String[] colors = {light, deep, rem, light, deep, rem, light};

// // // //         for (int i = 0; i < heights.length; i++) {
// // // //             Rectangle bar = new Rectangle(30, heights[i]);
// // // //             bar.setArcWidth(4); bar.setArcHeight(4);
// // // //             bar.setFill(Color.web(colors[i]));
// // // //             chart.getChildren().add(bar);
// // // //         }

// // // //         HBox legend = new HBox(15);
// // // //         legend.setAlignment(Pos.CENTER_LEFT);
// // // //         legend.getChildren().addAll(
// // // //             createLegendDot("Deep (1h 45m)", deep),
// // // //             createLegendDot("REM (2h 10m)", rem),
// // // //             createLegendDot("Light (3h 30m)", light)
// // // //         );

// // // //         box.getChildren().addAll(header, chart, legend);
// // // //         return box;
// // // //     }

// // // //     private HBox createLegendDot(String txt, String hex) {
// // // //         HBox box = new HBox(5); box.setAlignment(Pos.CENTER);
// // // //         Circle c = new Circle(4, Color.web(hex));
// // // //         Label l = new Label(txt); l.setStyle("-fx-font-size: 11px; -fx-font-weight: bold; -fx-text-fill: #64748b;");
// // // //         box.getChildren().addAll(c, l);
// // // //         return box;
// // // //     }

// // // //     private VBox buildFatigueSoreness() {
// // // //         VBox box = new VBox(15);
// // // //         box.setPrefWidth(320); box.setMinWidth(320);
// // // //         box.setPadding(new Insets(25));
// // // //         box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
// // // //         addHoverScale(box);

// // // //         Label title = new Label("Fatigue & Soreness");
// // // //         title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #0f172a;");

// // // //         HBox split = new HBox(15);
// // // //         VBox leftBars = new VBox(15); HBox.setHgrow(leftBars, Priority.ALWAYS);
        
// // // //         leftBars.getChildren().addAll(
// // // //             createFatigueBar("Mental Fatigue", "Low", "#10b981", 0.3),
// // // //             createFatigueBar("Muscle Soreness", "Moderate", "#eab308", 0.6)
// // // //         );

// // // //         VBox alert = new VBox(5);
// // // //         alert.setPadding(new Insets(10));
// // // //         alert.setStyle("-fx-border-color: #fecaca; -fx-border-radius: 8; -fx-background-radius: 8;");
// // // //         Label aTitle = new Label("ALERT"); aTitle.setStyle("-fx-text-fill: #ef4444; -fx-font-weight: bold; -fx-font-size: 10px;");
// // // //         Label aDesc = new Label("Right Hamstring tension noted. Recommended stretching: Dynamic Leg Swings.");
// // // //         aDesc.setWrapText(true); aDesc.setStyle("-fx-font-size: 11px; -fx-text-fill: #475569;");
// // // //         alert.getChildren().addAll(aTitle, aDesc);
// // // //         leftBars.getChildren().add(alert);

// // // //         VBox rightBody = new VBox(10);
// // // //         rightBody.setAlignment(Pos.CENTER);
// // // //         rightBody.setPrefWidth(80);
// // // //         rightBody.setStyle("-fx-background-color: #f8fafc; -fx-background-radius: 12;");
// // // //         Label silhouette = new Label("🧍"); silhouette.setStyle("-fx-font-size: 40px; -fx-text-fill: #cbd5e1;");
// // // //         Label bStatus = new Label("BODY STATUS"); bStatus.setStyle("-fx-font-size: 9px; -fx-font-weight: bold; -fx-text-fill: #94a3b8;");
// // // //         HBox dots = new HBox(3); dots.setAlignment(Pos.CENTER);
// // // //         dots.getChildren().addAll(new Circle(3, Color.web("#10b981")), new Circle(3, Color.web("#eab308")), new Circle(3, Color.web("#10b981")));
// // // //         rightBody.getChildren().addAll(silhouette, bStatus, dots);

// // // //         split.getChildren().addAll(leftBars, rightBody);
// // // //         box.getChildren().addAll(title, split);
// // // //         return box;
// // // //     }

// // // //     private VBox createFatigueBar(String title, String val, String color, double pct) {
// // // //         VBox box = new VBox(5);
// // // //         HBox texts = new HBox();
// // // //         Label t = new Label(title); t.setStyle("-fx-font-weight: bold; -fx-font-size: 11px; -fx-text-fill: #0f172a;");
// // // //         Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);
// // // //         Label v = new Label(val); v.setStyle("-fx-font-weight: bold; -fx-font-size: 11px; -fx-text-fill: " + color + ";");
// // // //         texts.getChildren().addAll(t, sp, v);

// // // //         StackPane barPane = new StackPane(); barPane.setAlignment(Pos.CENTER_LEFT);
// // // //         Rectangle bg = new Rectangle(140, 6, Color.web("#f1f5f9")); bg.setArcWidth(6); bg.setArcHeight(6);
// // // //         Rectangle prog = new Rectangle(140 * pct, 6, Color.web(color)); prog.setArcWidth(6); prog.setArcHeight(6);
// // // //         barPane.getChildren().addAll(bg, prog);

// // // //         box.getChildren().addAll(texts, barPane);
// // // //         return box;
// // // //     }

// // // //     // --- ROW 3 COMPONENTS ---
// // // //     private VBox buildDailyGoals() {
// // // //         VBox box = new VBox(15);
// // // //         box.setPadding(new Insets(25));
// // // //         box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
// // // //         addHoverScale(box);

// // // //         Label title = new Label("Daily Goals");
// // // //         title.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: #0f172a;");

// // // //         VBox list = new VBox(12);
// // // //         list.getChildren().addAll(
// // // //             createInteractiveCheck("Complete 3.5L Water", true),
// // // //             createInteractiveCheck("High Intensity Drills", true),
// // // //             createInteractiveCheck("8h Restoration Sleep", false),
// // // //             createInteractiveCheck("Log Evening Macros", false)
// // // //         );

// // // //         box.getChildren().addAll(title, list);
// // // //         return box;
// // // //     }

// // // //     private HBox createInteractiveCheck(String text, boolean isChecked) {
// // // //         HBox row = new HBox(10);
// // // //         row.setAlignment(Pos.CENTER_LEFT);
// // // //         boolean[] state = { isChecked };
// // // //         Label box = new Label(state[0] ? "☑" : "☐");
// // // //         box.setStyle("-fx-text-fill: " + (state[0] ? "#10b981" : "#94a3b8") + "; -fx-font-size: 18px;");
// // // //         Label txt = new Label(text);
// // // //         txt.setStyle("-fx-font-size: 13px; -fx-text-fill: #475569;");
// // // //         row.setOnMouseClicked(e -> {
// // // //             state[0] = !state[0];
// // // //             box.setText(state[0] ? "☑" : "☐");
// // // //             box.setStyle("-fx-text-fill: " + (state[0] ? "#10b981" : "#94a3b8") + "; -fx-font-size: 18px;");
// // // //         });
// // // //         row.getChildren().addAll(box, txt);
// // // //         return row;
// // // //     }

// // // //     private VBox buildActivityTimeline() {
// // // //         VBox box = new VBox(15);
// // // //         box.setPadding(new Insets(25));
// // // //         box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
// // // //         addHoverScale(box);

// // // //         Label title = new Label("Activity Timeline");
// // // //         title.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: #0f172a;");

// // // //         VBox list = new VBox(0);
// // // //         list.getChildren().addAll(
// // // //             createTimelineItem("07:15 AM", "Sleep Synced from WHOOP", "Score: 84 (Great Recovery)", true, true),
// // // //             createTimelineItem("10:30 AM", "Morning Technical Practice", "45m Batting Drills completed", true, true),
// // // //             createTimelineItem("05:00 PM (Planned)", "Recovery Protocol", "Stretching and Foam Rolling", false, false)
// // // //         );

// // // //         box.getChildren().addAll(title, list);
// // // //         return box;
// // // //     }

// // // //     private HBox createTimelineItem(String time, String title, String sub, boolean isDone, boolean hasLine) {
// // // //         HBox row = new HBox(15);
// // // //         row.setAlignment(Pos.TOP_LEFT);

// // // //         // Graphic Column (Dot + Line)
// // // //         VBox graphic = new VBox(2);
// // // //         graphic.setAlignment(Pos.TOP_CENTER);
        
// // // //         Circle dot = new Circle(6, Color.WHITE);
// // // //         dot.setStroke(isDone ? Color.web("#10b981") : Color.web("#cbd5e1"));
// // // //         dot.setStrokeWidth(3);
        
// // // //         graphic.getChildren().add(dot);
        
// // // //         if (hasLine) {
// // // //             Line line = new Line(0, 0, 0, 30);
// // // //             line.setStroke(Color.web("#e2e8f0"));
// // // //             line.setStrokeWidth(2);
// // // //             graphic.getChildren().add(line);
// // // //         }

// // // //         // Text Column
// // // //         VBox texts = new VBox(2);
// // // //         texts.setPadding(new Insets(0, 0, 15, 0));
// // // //         Label tm = new Label(time); tm.setStyle("-fx-font-size: 10px; -fx-font-weight: bold; -fx-text-fill: #64748b;");
// // // //         Label t = new Label(title); t.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
// // // //         if(!isDone) t.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-text-fill: #94a3b8;");
// // // //         Label s = new Label(sub); s.setStyle("-fx-font-size: 11px; -fx-text-fill: #94a3b8;");
// // // //         texts.getChildren().addAll(tm, t, s);

// // // //         row.getChildren().addAll(graphic, texts);
// // // //         return row;
// // // //     }

// // // //     private VBox buildDailyCoach() {
// // // //         VBox box = new VBox(20);
// // // //         box.setPrefWidth(320); box.setMinWidth(320);
// // // //         box.setPadding(new Insets(25));
// // // //         box.setStyle("-fx-background-color: #0f172a; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.15), 15, 0, 0, 8);");
// // // //         addHoverScale(box);

// // // //         HBox header = new HBox(10);
// // // //         header.setAlignment(Pos.CENTER_LEFT);
// // // //         Label icon = new Label("✨"); icon.setStyle("-fx-text-fill: #10b981; -fx-font-size: 18px;");
// // // //         VBox titles = new VBox();
// // // //         Label t1 = new Label("Daily Coach"); t1.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: white;");
// // // //         Label t2 = new Label("ACTIVE INSIGHT"); t2.setStyle("-fx-font-size: 9px; -fx-font-weight: bold; -fx-text-fill: #34d399; -fx-letter-spacing: 1px;");
// // // //         titles.getChildren().addAll(t1, t2);
// // // //         header.getChildren().addAll(icon, titles);

// // // //         VBox statusBox = new VBox(5);
// // // //         Label st1 = new Label("MATCH READINESS"); st1.setStyle("-fx-font-size: 10px; -fx-text-fill: #94a3b8; -fx-font-weight: bold; -fx-letter-spacing: 1px;");
// // // //         HBox stRow = new HBox(5); stRow.setAlignment(Pos.CENTER_LEFT);
// // // //         Label st2 = new Label("Optimum"); st2.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: white;");
// // // //         Label check = new Label("☑"); check.setStyle("-fx-text-fill: #10b981; -fx-font-size: 20px;");
// // // //         stRow.getChildren().addAll(st2, check);
// // // //         statusBox.getChildren().addAll(st1, stRow);

// // // //         Label quote = new Label("\"Your HRV trend is up 12% this week. Today is the perfect time for high-intensity power training. Ensure you hit your calorie surplus by +200 today.\"");
// // // //         quote.setWrapText(true);
// // // //         quote.setStyle("-fx-text-fill: #cbd5e1; -fx-font-size: 13px; -fx-font-style: italic; -fx-line-spacing: 5px;");

// // // //         Region sp = new Region(); VBox.setVgrow(sp, Priority.ALWAYS);

// // // //         Button askBtn = new Button("Ask AI Assistant");
// // // //         askBtn.setMaxWidth(Double.MAX_VALUE);
// // // //         askBtn.setStyle("-fx-background-color: transparent; -fx-border-color: #10b981; -fx-border-radius: 8; -fx-text-fill: #10b981; -fx-font-weight: bold; -fx-padding: 10; -fx-cursor: hand;");
// // // //         addHoverScale(askBtn);

// // // //         box.getChildren().addAll(header, statusBox, quote, sp, askBtn);
// // // //         return box;
// // // //     }
// // // // }

// // // package com.athlixcore.view.player;

// // // import javafx.animation.FadeTransition;
// // // import javafx.animation.ParallelTransition;
// // // import javafx.animation.ScaleTransition;
// // // import javafx.animation.TranslateTransition;
// // // import javafx.geometry.Insets;
// // // import javafx.geometry.Pos;
// // // import javafx.scene.Node;
// // // import javafx.scene.Scene;
// // // import javafx.scene.control.Button;
// // // import javafx.scene.control.Label;
// // // import javafx.scene.control.ScrollPane;
// // // import javafx.scene.control.TextField;
// // // import javafx.scene.layout.*;
// // // import javafx.scene.paint.Color;
// // // import javafx.scene.shape.Circle;
// // // import javafx.scene.shape.Line;
// // // import javafx.scene.shape.Rectangle;
// // // import javafx.stage.Modality;
// // // import javafx.stage.Stage;
// // // import javafx.util.Duration;

// // // public class Fitness_StartWorkoutButton {

// // //     private StackPane rootContainer;
// // //     private Runnable onBack;

// // //     // --- Dynamic Labels for Health Metrics ---
// // //     private Label weightLabel = new Label("78.5");
// // //     private Label bmiLabel = new Label("23.4");
// // //     private Label bpLabel = new Label("118/76");
// // //     private Label spo2Label = new Label("99");

// // //     public Fitness_StartWorkoutButton(Runnable onBack) {
// // //         this.onBack = onBack;
// // //     }

// // //     public Node getView() {
// // //         if (rootContainer == null) {
// // //             rootContainer = new StackPane();
// // //             rootContainer.setStyle("-fx-background-color: #f8fafc;");

// // //             VBox mainLayout = new VBox(25);
// // //             mainLayout.setPadding(new Insets(20, 40, 40, 40));

// // //             // --- UI Sections ---
// // //             Node backButtonRow = buildBackButton();
            
// // //             // Row 1: Workout Log & Health Metrics
// // //             HBox row1 = new HBox(25);
// // //             Node workoutLog = buildWorkoutLog();
// // //             HBox.setHgrow(workoutLog, Priority.ALWAYS);
// // //             Node healthMetrics = buildHealthMetrics();
// // //             row1.getChildren().addAll(workoutLog, healthMetrics);

// // //             // Row 2: Sleep Cycles & Fatigue
// // //             HBox row2 = new HBox(25);
// // //             Node sleepCycles = buildSleepCycles();
// // //             HBox.setHgrow(sleepCycles, Priority.ALWAYS);
// // //             Node fatigueSoreness = buildFatigueSoreness();
// // //             row2.getChildren().addAll(sleepCycles, fatigueSoreness);

// // //             // Row 3: Daily Goals, Timeline & Daily Coach
// // //             HBox row3 = new HBox(25);
            
// // //             VBox dailyGoals = buildDailyGoals();
// // //             HBox.setHgrow(dailyGoals, Priority.ALWAYS);
            
// // //             VBox timeline = buildActivityTimeline();
// // //             HBox.setHgrow(timeline, Priority.ALWAYS);
            
// // //             Node dailyCoach = buildDailyCoach();
// // //             row3.getChildren().addAll(dailyGoals, timeline, dailyCoach);

// // //             mainLayout.getChildren().addAll(backButtonRow, row1, row2, row3);

// // //             // --- Entrance Animations ---
// // //             animateNodeEntrance(backButtonRow, 0);
// // //             animateNodeEntrance(row1, 100);
// // //             animateNodeEntrance(row2, 200);
// // //             animateNodeEntrance(row3, 300);

// // //             ScrollPane scrollPane = new ScrollPane(mainLayout);
// // //             scrollPane.setFitToWidth(true);
// // //             scrollPane.setStyle("-fx-background-color: transparent; -fx-background: #f8fafc;");
// // //             scrollPane.getStylesheets().add("data:text/css,.scroll-pane > .viewport { -fx-background-color: transparent; }");

// // //             rootContainer.getChildren().add(scrollPane);
// // //         }
// // //         return rootContainer;
// // //     }

// // //     // --- ANIMATIONS ---
// // //     private void animateNodeEntrance(Node node, int delayMillis) {
// // //         node.setOpacity(0);
// // //         node.setTranslateY(25);
// // //         FadeTransition ft = new FadeTransition(Duration.millis(500), node);
// // //         ft.setToValue(1.0);
// // //         TranslateTransition tt = new TranslateTransition(Duration.millis(500), node);
// // //         tt.setToY(0);
// // //         ParallelTransition pt = new ParallelTransition(ft, tt);
// // //         pt.setDelay(Duration.millis(delayMillis));
// // //         pt.play();
// // //     }

// // //     private void addHoverScale(Node node) {
// // //         ScaleTransition scaleIn = new ScaleTransition(Duration.millis(150), node);
// // //         scaleIn.setToX(1.02); scaleIn.setToY(1.02);
// // //         ScaleTransition scaleOut = new ScaleTransition(Duration.millis(150), node);
// // //         scaleOut.setToX(1.0); scaleOut.setToY(1.0);
// // //         node.setOnMouseEntered(e -> scaleIn.playFromStart());
// // //         node.setOnMouseExited(e -> scaleOut.playFromStart());
// // //     }

// // //     // --- BACK BUTTON ---
// // //     private HBox buildBackButton() {
// // //         HBox row = new HBox();
// // //         row.setAlignment(Pos.CENTER_LEFT);
// // //         Button backBtn = new Button("← Back to Elite Performance Hub");
// // //         backBtn.setStyle("-fx-background-color: white; -fx-text-fill: #475569; -fx-font-weight: bold; -fx-font-size: 13px; -fx-padding: 8 15; -fx-background-radius: 20; -fx-border-color: #e2e8f0; -fx-border-radius: 20; -fx-cursor: hand;");
// // //         addHoverScale(backBtn);
// // //         backBtn.setOnAction(e -> { if (onBack != null) onBack.run(); });
// // //         row.getChildren().add(backBtn);
// // //         return row;
// // //     }

// // //     // --- ROW 1 COMPONENTS ---
// // //     private VBox buildWorkoutLog() {
// // //         VBox box = new VBox(20);
// // //         box.setPadding(new Insets(25));
// // //         box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
// // //         addHoverScale(box);

// // //         HBox header = new HBox();
// // //         Label title = new Label("Workout Log");
// // //         title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #0f172a;");
// // //         Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);
        
// // //         Label toggle = new Label("Today   History");
// // //         toggle.setStyle("-fx-background-color: #f1f5f9; -fx-padding: 6 14; -fx-background-radius: 15; -fx-font-size: 11px; -fx-font-weight: bold; -fx-text-fill: #64748b; -fx-cursor: hand;");
// // //         header.getChildren().addAll(title, sp, toggle);

// // //         VBox list = new VBox(15);
// // //         list.getChildren().addAll(
// // //             createWorkoutItem("🏏", "#d1fae5", "#10b981", "Batting Practice - Technical", "Duration: 45m • Intensity: Medium", "142", "380"),
// // //             createWorkoutItem("🏃", "#fee2e2", "#ef4444", "Sprint Training - Max Effort", "Duration: 20m • Intensity: High", "168", "410")
// // //         );
// // //         box.getChildren().addAll(header, list);
// // //         return box;
// // //     }

// // //     private HBox createWorkoutItem(String icon, String bgHex, String iconHex, String title, String sub, String hr, String kcal) {
// // //         HBox row = new HBox(15);
// // //         row.setAlignment(Pos.CENTER_LEFT);
// // //         row.setPadding(new Insets(15, 20, 15, 20));
// // //         row.setStyle("-fx-background-color: white; -fx-border-color: #f1f5f9; -fx-border-width: 2; -fx-border-radius: 12; -fx-background-radius: 12;");

// // //         StackPane iconPane = new StackPane();
// // //         Circle c = new Circle(20, Color.web(bgHex));
// // //         Label i = new Label(icon); i.setStyle("-fx-text-fill: " + iconHex + "; -fx-font-size: 16px;");
// // //         iconPane.getChildren().addAll(c, i);

// // //         VBox texts = new VBox(3);
// // //         Label t = new Label(title); t.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: #0f172a;");
// // //         Label s = new Label(sub); s.setStyle("-fx-font-size: 11px; -fx-text-fill: #64748b;");
// // //         texts.getChildren().addAll(t, s);

// // //         Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);

// // //         VBox hrBox = new VBox(); hrBox.setAlignment(Pos.CENTER);
// // //         Label hrV = new Label(hr); hrV.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: #0f172a;");
// // //         Label hrL = new Label("Avg HR"); hrL.setStyle("-fx-font-size: 10px; -fx-text-fill: #94a3b8; -fx-font-weight: bold;");
// // //         hrBox.getChildren().addAll(hrV, hrL);

// // //         VBox kcalBox = new VBox(); kcalBox.setAlignment(Pos.CENTER);
// // //         Label kcV = new Label(kcal); kcV.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: #0f172a;");
// // //         Label kcL = new Label("kcal"); kcL.setStyle("-fx-font-size: 10px; -fx-text-fill: #94a3b8; -fx-font-weight: bold;");
// // //         kcalBox.getChildren().addAll(kcV, kcL);

// // //         Label arrow = new Label(">"); arrow.setStyle("-fx-text-fill: #cbd5e1; -fx-font-size: 18px; -fx-font-weight: bold; -fx-padding: 0 0 0 10;");

// // //         row.getChildren().addAll(iconPane, texts, sp, hrBox, kcalBox, arrow);
// // //         return row;
// // //     }

// // //     // === MODIFIED: HEALTH METRICS WITH BUTTON FUNCTIONALITY ===
// // //     private VBox buildHealthMetrics() {
// // //         VBox box = new VBox(20);
// // //         box.setPrefWidth(320); box.setMinWidth(320);
// // //         box.setPadding(new Insets(25));
// // //         box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
// // //         addHoverScale(box);

// // //         Label title = new Label("Health Metrics");
// // //         title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #0f172a;");

// // //         GridPane grid = new GridPane();
// // //         grid.setHgap(15); grid.setVgap(15);
// // //         ColumnConstraints cc = new ColumnConstraints(); cc.setPercentWidth(50);
// // //         grid.getColumnConstraints().addAll(cc, cc);

// // //         // Uses the dynamic global labels defined at the top of the class
// // //         grid.add(createDynamicMetricSquare("WEIGHT", weightLabel, "kg", "-0.2 from\nyesterday", "#10b981"), 0, 0);
// // //         grid.add(createDynamicMetricSquare("BMI", bmiLabel, "", "Optimal\nRange", "#64748b"), 1, 0);
// // //         grid.add(createDynamicMetricSquare("BLOOD\nPRESSURE", bpLabel, "", "Perfect", "#10b981"), 0, 1);
// // //         grid.add(createDynamicMetricSquare("SPO2", spo2Label, "%", "Healthy", "#64748b"), 1, 1);

// // //         Button manualBtn = new Button("+ Manual Metric Entry");
// // //         manualBtn.setMaxWidth(Double.MAX_VALUE);
// // //         manualBtn.setStyle("-fx-background-color: transparent; -fx-border-color: #cbd5e1; -fx-border-style: dashed; -fx-border-radius: 8; -fx-text-fill: #64748b; -fx-font-weight: bold; -fx-padding: 10; -fx-cursor: hand;");
        
// // //         // Open the manual entry popup on click
// // //         manualBtn.setOnAction(e -> openManualMetricEntryDialog());

// // //         box.getChildren().addAll(title, grid, manualBtn);
// // //         return box;
// // //     }

// // //     private VBox createDynamicMetricSquare(String title, Label valLabel, String unit, String sub, String subColor) {
// // //         VBox box = new VBox(5);
// // //         box.setAlignment(Pos.CENTER);
// // //         box.setPadding(new Insets(15));
// // //         box.setStyle("-fx-background-color: #f8fafc; -fx-background-radius: 12;");
        
// // //         Label t = new Label(title); 
// // //         t.setStyle("-fx-font-size: 10px; -fx-font-weight: bold; -fx-text-fill: #64748b; -fx-text-alignment: center; -fx-letter-spacing: 1px;");
        
// // //         HBox valBox = new HBox(2); 
// // //         valBox.setAlignment(Pos.BOTTOM_CENTER);
        
// // //         valLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
        
// // //         Label u = new Label(unit); 
// // //         u.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #0f172a; -fx-translate-y: -4px;");
// // //         valBox.getChildren().addAll(valLabel, u);

// // //         Label s = new Label(sub); 
// // //         s.setStyle("-fx-font-size: 9px; -fx-text-fill: " + subColor + "; -fx-text-alignment: center; -fx-font-weight: bold;");
// // //         box.getChildren().addAll(t, valBox, s);
// // //         return box;
// // //     }

// // //     // --- POPUP DIALOG LOGIC ---
// // //     private void openManualMetricEntryDialog() {
// // //         Stage dialog = new Stage();
// // //         dialog.initModality(Modality.APPLICATION_MODAL);
// // //         dialog.setTitle("Manual Metric Entry");

// // //         VBox layout = new VBox(15);
// // //         layout.setPadding(new Insets(25));
// // //         layout.setStyle("-fx-background-color: white;");

// // //         Label title = new Label("Update Health Metrics");
// // //         title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");

// // //         // Input Fields (pre-filled with current values)
// // //         TextField wField = createStyledTextField(weightLabel.getText(), "Weight (kg)");
// // //         TextField bmiField = createStyledTextField(bmiLabel.getText(), "BMI");
// // //         TextField bpField = createStyledTextField(bpLabel.getText(), "Blood Pressure");
// // //         TextField spo2Field = createStyledTextField(spo2Label.getText(), "SPO2 (%)");

// // //         Button saveBtn = new Button("Save Metrics");
// // //         saveBtn.setMaxWidth(Double.MAX_VALUE);
// // //         saveBtn.setStyle("-fx-background-color: #10b981; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 10; -fx-background-radius: 8; -fx-cursor: hand;");
// // //         addHoverScale(saveBtn);
        
// // //         // Save action directly updates the labels on the dashboard UI
// // //         saveBtn.setOnAction(e -> {
// // //             weightLabel.setText(wField.getText());
// // //             bmiLabel.setText(bmiField.getText());
// // //             bpLabel.setText(bpField.getText());
// // //             spo2Label.setText(spo2Field.getText());
// // //             dialog.close();
// // //         });

// // //         layout.getChildren().addAll(
// // //             title, 
// // //             createInputRow("Weight (kg):", wField), 
// // //             createInputRow("BMI:", bmiField), 
// // //             createInputRow("Blood Pressure:", bpField), 
// // //             createInputRow("SPO2 (%):", spo2Field), 
// // //             saveBtn
// // //         );

// // //         Scene scene = new Scene(layout, 350, 450);
// // //         dialog.setScene(scene);
// // //         dialog.show();
// // //     }

// // //     private TextField createStyledTextField(String text, String prompt) {
// // //         TextField tf = new TextField(text);
// // //         tf.setPromptText(prompt);
// // //         tf.setStyle("-fx-background-color: #f8fafc; -fx-border-color: #cbd5e1; -fx-border-radius: 8; -fx-background-radius: 8; -fx-padding: 10; -fx-font-size: 14px;");
// // //         return tf;
// // //     }

// // //     private VBox createInputRow(String label, TextField field) {
// // //         VBox box = new VBox(5);
// // //         Label l = new Label(label);
// // //         l.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #475569;");
// // //         box.getChildren().addAll(l, field);
// // //         return box;
// // //     }
// // //     // ==========================================================

// // //     // --- ROW 2 COMPONENTS ---
// // //     private VBox buildSleepCycles() {
// // //         VBox box = new VBox(15);
// // //         box.setPadding(new Insets(25));
// // //         box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
// // //         addHoverScale(box);

// // //         HBox header = new HBox();
// // //         VBox titles = new VBox(2);
// // //         Label title = new Label("Sleep Cycles"); title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #0f172a;");
// // //         Label sub = new Label("Efficiency: 94% • 11:20 PM - 07:15 AM"); sub.setStyle("-fx-font-size: 12px; -fx-text-fill: #64748b;");
// // //         titles.getChildren().addAll(title, sub);
// // //         Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);
// // //         Label moon = new Label("🌙"); moon.setStyle("-fx-text-fill: #0f172a; -fx-font-size: 20px;");
// // //         header.getChildren().addAll(titles, sp, moon);

// // //         // Chart Fake
// // //         HBox chart = new HBox(12);
// // //         chart.setAlignment(Pos.BOTTOM_CENTER);
// // //         chart.setMinHeight(180);
// // //         chart.setPadding(new Insets(15, 0, 0, 0));
        
// // //         String deep = "#0f172a", rem = "#6ee7b7", light = "#93c5fd", wake = "#fca5a5";
// // //         double[] heights = {100, 140, 110, 80, 130, 40, 90, 120};
// // //         String[] colors = {rem, deep, rem, light, deep, rem, wake, light};

// // //         for (int i = 0; i < heights.length; i++) {
// // //             Rectangle bar = new Rectangle(40, heights[i]);
// // //             bar.setFill(Color.web(colors[i]));
// // //             chart.getChildren().add(bar);
// // //         }

// // //         HBox legend = new HBox(25);
// // //         legend.setAlignment(Pos.CENTER);
// // //         legend.setPadding(new Insets(10, 0, 0, 0));
// // //         legend.getChildren().addAll(
// // //             createLegendDot("Deep (1h 45m)", deep),
// // //             createLegendDot("REM (2h 10m)", rem),
// // //             createLegendDot("Light (3h 30m)", light)
// // //         );

// // //         box.getChildren().addAll(header, chart, legend);
// // //         return box;
// // //     }

// // //     private HBox createLegendDot(String txt, String hex) {
// // //         HBox box = new HBox(8); box.setAlignment(Pos.CENTER);
// // //         Circle c = new Circle(5, Color.web(hex));
// // //         Label l = new Label(txt); l.setStyle("-fx-font-size: 11px; -fx-font-weight: bold; -fx-text-fill: #475569;");
// // //         box.getChildren().addAll(c, l);
// // //         return box;
// // //     }

// // //     private VBox buildFatigueSoreness() {
// // //         VBox box = new VBox(20);
// // //         box.setPrefWidth(320); box.setMinWidth(320);
// // //         box.setPadding(new Insets(25));
// // //         box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
// // //         addHoverScale(box);

// // //         Label title = new Label("Fatigue & Soreness");
// // //         title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #0f172a;");

// // //         HBox split = new HBox(20);
// // //         VBox leftBars = new VBox(20); HBox.setHgrow(leftBars, Priority.ALWAYS);
        
// // //         leftBars.getChildren().addAll(
// // //             createFatigueBar("Mental Fatigue", "Low", "#10b981", 0.25),
// // //             createFatigueBar("Muscle Soreness", "Moderate", "#eab308", 0.6)
// // //         );

// // //         VBox alert = new VBox(8);
// // //         alert.setPadding(new Insets(15));
// // //         alert.setStyle("-fx-border-color: #fecaca; -fx-border-width: 1.5; -fx-border-radius: 8; -fx-background-color: #fef2f2; -fx-background-radius: 8;");
// // //         Label aTitle = new Label("ALERT"); aTitle.setStyle("-fx-text-fill: #ef4444; -fx-font-weight: bold; -fx-font-size: 10px; -fx-letter-spacing: 1px;");
// // //         Label aDesc = new Label("Right Hamstring tension noted. Recommended stretching: Dynamic Leg Swings.");
// // //         aDesc.setWrapText(true); aDesc.setStyle("-fx-font-size: 12px; -fx-text-fill: #475569; -fx-line-spacing: 4px;");
// // //         alert.getChildren().addAll(aTitle, aDesc);
// // //         leftBars.getChildren().add(alert);

// // //         VBox rightBody = new VBox(10);
// // //         rightBody.setAlignment(Pos.CENTER);
// // //         rightBody.setPrefWidth(90);
// // //         rightBody.setStyle("-fx-background-color: #f1f5f9; -fx-background-radius: 12;");
// // //         Label silhouette = new Label("🧍"); silhouette.setStyle("-fx-font-size: 45px; -fx-text-fill: #94a3b8;");
// // //         Label bStatus = new Label("BODY STATUS"); bStatus.setStyle("-fx-font-size: 9px; -fx-font-weight: bold; -fx-text-fill: #64748b; -fx-letter-spacing: 1px;");
// // //         HBox dots = new HBox(4); dots.setAlignment(Pos.CENTER);
// // //         dots.getChildren().addAll(new Circle(3, Color.web("#10b981")), new Circle(3, Color.web("#eab308")), new Circle(3, Color.web("#10b981")));
// // //         rightBody.getChildren().addAll(silhouette, bStatus, dots);

// // //         split.getChildren().addAll(leftBars, rightBody);
// // //         box.getChildren().addAll(title, split);
// // //         return box;
// // //     }

// // //     private VBox createFatigueBar(String title, String val, String color, double pct) {
// // //         VBox box = new VBox(5);
// // //         HBox texts = new HBox();
// // //         Label t = new Label(title); t.setStyle("-fx-font-weight: bold; -fx-font-size: 12px; -fx-text-fill: #0f172a;");
// // //         Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);
// // //         Label v = new Label(val); v.setStyle("-fx-font-weight: bold; -fx-font-size: 12px; -fx-text-fill: " + color + ";");
// // //         texts.getChildren().addAll(t, sp, v);

// // //         StackPane barPane = new StackPane(); barPane.setAlignment(Pos.CENTER_LEFT);
// // //         Rectangle bg = new Rectangle(140, 8, Color.web("#f1f5f9")); bg.setArcWidth(8); bg.setArcHeight(8);
// // //         Rectangle prog = new Rectangle(140 * pct, 8, Color.web(color)); prog.setArcWidth(8); prog.setArcHeight(8);
// // //         barPane.getChildren().addAll(bg, prog);

// // //         box.getChildren().addAll(texts, barPane);
// // //         return box;
// // //     }

// // //     // --- ROW 3 COMPONENTS ---
// // //     private VBox buildDailyGoals() {
// // //         VBox box = new VBox(20);
// // //         box.setPadding(new Insets(25));
// // //         box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
// // //         addHoverScale(box);

// // //         Label title = new Label("Daily Goals");
// // //         title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #0f172a;");

// // //         VBox list = new VBox(15);
// // //         list.getChildren().addAll(
// // //             createInteractiveCheck("Complete 3.5L Water", true),
// // //             createInteractiveCheck("High Intensity Drills", true),
// // //             createInteractiveCheck("8h Restoration Sleep", false),
// // //             createInteractiveCheck("Log Evening Macros", false)
// // //         );

// // //         box.getChildren().addAll(title, list);
// // //         return box;
// // //     }

// // //     private HBox createInteractiveCheck(String text, boolean isChecked) {
// // //         HBox row = new HBox(12);
// // //         row.setAlignment(Pos.CENTER_LEFT);
// // //         row.setStyle("-fx-cursor: hand;");
// // //         boolean[] state = { isChecked };
        
// // //         Label box = new Label(state[0] ? "☑" : "☐");
// // //         box.setStyle("-fx-text-fill: " + (state[0] ? "#10b981" : "#cbd5e1") + "; -fx-font-size: 22px;");
        
// // //         Label txt = new Label(text);
// // //         txt.setStyle("-fx-font-size: 14px; -fx-text-fill: #475569;");
        
// // //         row.setOnMouseClicked(e -> {
// // //             state[0] = !state[0];
// // //             box.setText(state[0] ? "☑" : "☐");
// // //             box.setStyle("-fx-text-fill: " + (state[0] ? "#10b981" : "#cbd5e1") + "; -fx-font-size: 22px;");
// // //         });
// // //         row.getChildren().addAll(box, txt);
// // //         return row;
// // //     }

// // //     private VBox buildActivityTimeline() {
// // //         VBox box = new VBox(20);
// // //         box.setPadding(new Insets(25));
// // //         box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
// // //         addHoverScale(box);

// // //         Label title = new Label("Activity Timeline");
// // //         title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #0f172a;");

// // //         VBox list = new VBox(0);
// // //         list.getChildren().addAll(
// // //             createTimelineItem("07:15 AM", "Sleep Synced from WHOOP", "Score: 84 (Great Recovery)", true, true),
// // //             createTimelineItem("10:30 AM", "Morning Technical Practice", "45m Batting Drills completed", true, true),
// // //             createTimelineItem("05:00 PM (Planned)", "Recovery Protocol", "Stretching and Foam Rolling", false, false)
// // //         );

// // //         box.getChildren().addAll(title, list);
// // //         return box;
// // //     }

// // //     private HBox createTimelineItem(String time, String title, String sub, boolean isDone, boolean hasLine) {
// // //         HBox row = new HBox(15);
// // //         row.setAlignment(Pos.TOP_LEFT);

// // //         VBox graphic = new VBox(2);
// // //         graphic.setAlignment(Pos.TOP_CENTER);
        
// // //         Circle dot = new Circle(7, Color.WHITE);
// // //         dot.setStroke(isDone ? Color.web("#10b981") : Color.web("#e2e8f0"));
// // //         dot.setStrokeWidth(3);
// // //         graphic.getChildren().add(dot);
        
// // //         if (hasLine) {
// // //             Line line = new Line(0, 0, 0, 40);
// // //             line.setStroke(Color.web("#f1f5f9"));
// // //             line.setStrokeWidth(2);
// // //             graphic.getChildren().add(line);
// // //         }

// // //         VBox texts = new VBox(4);
// // //         texts.setPadding(new Insets(0, 0, 15, 0));
// // //         Label tm = new Label(time); tm.setStyle("-fx-font-size: 11px; -fx-font-weight: bold; -fx-text-fill: #64748b;");
// // //         Label t = new Label(title); t.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: " + (isDone ? "#0f172a" : "#94a3b8") + ";");
// // //         Label s = new Label(sub); s.setStyle("-fx-font-size: 12px; -fx-text-fill: #94a3b8;");
// // //         texts.getChildren().addAll(tm, t, s);

// // //         row.getChildren().addAll(graphic, texts);
// // //         return row;
// // //     }

// // //     private VBox buildDailyCoach() {
// // //         VBox box = new VBox(20);
// // //         box.setPrefWidth(320); box.setMinWidth(320);
// // //         box.setPadding(new Insets(25));
// // //         box.setStyle("-fx-background-color: #0f172a; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.15), 15, 0, 0, 8);");
// // //         addHoverScale(box);

// // //         HBox header = new HBox(10);
// // //         header.setAlignment(Pos.CENTER_LEFT);
// // //         Label icon = new Label("✨"); icon.setStyle("-fx-text-fill: #10b981; -fx-font-size: 20px;");
// // //         VBox titles = new VBox();
// // //         Label t1 = new Label("Daily Coach"); t1.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: white;");
// // //         Label t2 = new Label("ACTIVE INSIGHT"); t2.setStyle("-fx-font-size: 10px; -fx-font-weight: bold; -fx-text-fill: #34d399; -fx-letter-spacing: 1px;");
// // //         titles.getChildren().addAll(t1, t2);
// // //         header.getChildren().addAll(icon, titles);

// // //         VBox statusBox = new VBox(5);
// // //         Label st1 = new Label("MATCH READINESS"); st1.setStyle("-fx-font-size: 11px; -fx-text-fill: #94a3b8; -fx-font-weight: bold; -fx-letter-spacing: 1px;");
// // //         HBox stRow = new HBox(8); stRow.setAlignment(Pos.CENTER_LEFT);
// // //         Label st2 = new Label("Optimum"); st2.setStyle("-fx-font-size: 26px; -fx-font-weight: bold; -fx-text-fill: white;");
// // //         Label check = new Label("☑"); check.setStyle("-fx-text-fill: #10b981; -fx-font-size: 24px;");
// // //         stRow.getChildren().addAll(st2, check);
// // //         statusBox.getChildren().addAll(st1, stRow);

// // //         Label quote = new Label("\"Your HRV trend is up 12% this week. Today is the perfect time for high-intensity power training. Ensure you hit your calorie surplus by +200 today.\"");
// // //         quote.setWrapText(true);
// // //         quote.setStyle("-fx-text-fill: #cbd5e1; -fx-font-size: 14px; -fx-font-style: italic; -fx-line-spacing: 6px;");

// // //         Region sp = new Region(); VBox.setVgrow(sp, Priority.ALWAYS);

// // //         Button askBtn = new Button("Ask AI Assistant");
// // //         askBtn.setMaxWidth(Double.MAX_VALUE);
// // //         askBtn.setStyle("-fx-background-color: transparent; -fx-border-color: #10b981; -fx-border-radius: 8; -fx-text-fill: #10b981; -fx-font-weight: bold; -fx-padding: 12; -fx-font-size: 14px; -fx-cursor: hand;");
// // //         addHoverScale(askBtn);

// // //         box.getChildren().addAll(header, statusBox, quote, sp, askBtn);
// // //         return box;
// // //     }
// // // }

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
// // import javafx.scene.control.TextField;
// // import javafx.scene.layout.*;
// // import javafx.scene.paint.Color;
// // import javafx.scene.shape.Circle;
// // import javafx.scene.shape.Line;
// // import javafx.scene.shape.Rectangle;
// // import javafx.util.Duration;

// // public class Fitness_StartWorkoutButton {

// //     private StackPane rootContainer;
// //     private Runnable onBack;

// //     // --- Dynamic Labels for Health Metrics ---
// //     private Label weightLabel = new Label("78.5");
// //     private Label bmiLabel = new Label("23.4");
// //     private Label bpLabel = new Label("118/76");
// //     private Label spo2Label = new Label("99");

// //     public Fitness_StartWorkoutButton(Runnable onBack) {
// //         this.onBack = onBack;
// //     }

// //     public Node getView() {
// //         if (rootContainer == null) {
// //             rootContainer = new StackPane();
// //             rootContainer.setStyle("-fx-background-color: #f8fafc;");

// //             VBox mainLayout = new VBox(25);
// //             mainLayout.setPadding(new Insets(20, 40, 40, 40));

// //             // --- UI Sections ---
// //             Node backButtonRow = buildBackButton();
            
// //             // Row 1: Workout Log & Health Metrics
// //             HBox row1 = new HBox(25);
// //             Node workoutLog = buildWorkoutLog();
// //             HBox.setHgrow(workoutLog, Priority.ALWAYS);
// //             Node healthMetrics = buildHealthMetrics();
// //             row1.getChildren().addAll(workoutLog, healthMetrics);

// //             // Row 2: Sleep Cycles & Fatigue
// //             HBox row2 = new HBox(25);
// //             Node sleepCycles = buildSleepCycles();
// //             HBox.setHgrow(sleepCycles, Priority.ALWAYS);
// //             Node fatigueSoreness = buildFatigueSoreness();
// //             row2.getChildren().addAll(sleepCycles, fatigueSoreness);

// //             // Row 3: Daily Goals, Timeline & Daily Coach
// //             HBox row3 = new HBox(25);
            
// //             VBox dailyGoals = buildDailyGoals();
// //             HBox.setHgrow(dailyGoals, Priority.ALWAYS);
            
// //             VBox timeline = buildActivityTimeline();
// //             HBox.setHgrow(timeline, Priority.ALWAYS);
            
// //             Node dailyCoach = buildDailyCoach();
// //             row3.getChildren().addAll(dailyGoals, timeline, dailyCoach);

// //             mainLayout.getChildren().addAll(backButtonRow, row1, row2, row3);

// //             // --- Entrance Animations ---
// //             animateNodeEntrance(backButtonRow, 0);
// //             animateNodeEntrance(row1, 100);
// //             animateNodeEntrance(row2, 200);
// //             animateNodeEntrance(row3, 300);

// //             ScrollPane scrollPane = new ScrollPane(mainLayout);
// //             scrollPane.setFitToWidth(true);
// //             scrollPane.setStyle("-fx-background-color: transparent; -fx-background: #f8fafc;");
// //             scrollPane.getStylesheets().add("data:text/css,.scroll-pane > .viewport { -fx-background-color: transparent; }");

// //             rootContainer.getChildren().add(scrollPane);
// //         }
// //         return rootContainer;
// //     }

// //     // --- ANIMATIONS ---
// //     private void animateNodeEntrance(Node node, int delayMillis) {
// //         node.setOpacity(0);
// //         node.setTranslateY(25);
// //         FadeTransition ft = new FadeTransition(Duration.millis(500), node);
// //         ft.setToValue(1.0);
// //         TranslateTransition tt = new TranslateTransition(Duration.millis(500), node);
// //         tt.setToY(0);
// //         ParallelTransition pt = new ParallelTransition(ft, tt);
// //         pt.setDelay(Duration.millis(delayMillis));
// //         pt.play();
// //     }

// //     private void addHoverScale(Node node) {
// //         ScaleTransition scaleIn = new ScaleTransition(Duration.millis(150), node);
// //         scaleIn.setToX(1.02); scaleIn.setToY(1.02);
// //         ScaleTransition scaleOut = new ScaleTransition(Duration.millis(150), node);
// //         scaleOut.setToX(1.0); scaleOut.setToY(1.0);
// //         node.setOnMouseEntered(e -> scaleIn.playFromStart());
// //         node.setOnMouseExited(e -> scaleOut.playFromStart());
// //     }

// //     // --- BACK BUTTON ---
// //     private HBox buildBackButton() {
// //         HBox row = new HBox();
// //         row.setAlignment(Pos.CENTER_LEFT);
// //         Button backBtn = new Button("← Back to Elite Performance Hub");
// //         backBtn.setStyle("-fx-background-color: white; -fx-text-fill: #475569; -fx-font-weight: bold; -fx-font-size: 13px; -fx-padding: 8 15; -fx-background-radius: 20; -fx-border-color: #e2e8f0; -fx-border-radius: 20; -fx-cursor: hand;");
// //         addHoverScale(backBtn);
// //         backBtn.setOnAction(e -> { if (onBack != null) onBack.run(); });
// //         row.getChildren().add(backBtn);
// //         return row;
// //     }

// //     // --- ROW 1 COMPONENTS ---
// //     private VBox buildWorkoutLog() {
// //         VBox box = new VBox(20);
// //         box.setPadding(new Insets(25));
// //         box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
// //         addHoverScale(box);

// //         HBox header = new HBox();
// //         Label title = new Label("Workout Log");
// //         title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #0f172a;");
// //         Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);
        
// //         Label toggle = new Label("Today   History");
// //         toggle.setStyle("-fx-background-color: #f1f5f9; -fx-padding: 6 14; -fx-background-radius: 15; -fx-font-size: 11px; -fx-font-weight: bold; -fx-text-fill: #64748b; -fx-cursor: hand;");
// //         header.getChildren().addAll(title, sp, toggle);

// //         VBox list = new VBox(15);
// //         list.getChildren().addAll(
// //             createWorkoutItem("🏏", "#d1fae5", "#10b981", "Batting Practice - Technical", "Duration: 45m • Intensity: Medium", "142", "380"),
// //             createWorkoutItem("🏃", "#fee2e2", "#ef4444", "Sprint Training - Max Effort", "Duration: 20m • Intensity: High", "168", "410")
// //         );
// //         box.getChildren().addAll(header, list);
// //         return box;
// //     }

// //     private HBox createWorkoutItem(String icon, String bgHex, String iconHex, String title, String sub, String hr, String kcal) {
// //         HBox row = new HBox(15);
// //         row.setAlignment(Pos.CENTER_LEFT);
// //         row.setPadding(new Insets(15, 20, 15, 20));
// //         row.setStyle("-fx-background-color: white; -fx-border-color: #f1f5f9; -fx-border-width: 2; -fx-border-radius: 12; -fx-background-radius: 12;");

// //         StackPane iconPane = new StackPane();
// //         Circle c = new Circle(20, Color.web(bgHex));
// //         Label i = new Label(icon); i.setStyle("-fx-text-fill: " + iconHex + "; -fx-font-size: 16px;");
// //         iconPane.getChildren().addAll(c, i);

// //         VBox texts = new VBox(3);
// //         Label t = new Label(title); t.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: #0f172a;");
// //         Label s = new Label(sub); s.setStyle("-fx-font-size: 11px; -fx-text-fill: #64748b;");
// //         texts.getChildren().addAll(t, s);

// //         Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);

// //         VBox hrBox = new VBox(); hrBox.setAlignment(Pos.CENTER);
// //         Label hrV = new Label(hr); hrV.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: #0f172a;");
// //         Label hrL = new Label("Avg HR"); hrL.setStyle("-fx-font-size: 10px; -fx-text-fill: #94a3b8; -fx-font-weight: bold;");
// //         hrBox.getChildren().addAll(hrV, hrL);

// //         VBox kcalBox = new VBox(); kcalBox.setAlignment(Pos.CENTER);
// //         Label kcV = new Label(kcal); kcV.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: #0f172a;");
// //         Label kcL = new Label("kcal"); kcL.setStyle("-fx-font-size: 10px; -fx-text-fill: #94a3b8; -fx-font-weight: bold;");
// //         kcalBox.getChildren().addAll(kcV, kcL);

// //         Label arrow = new Label(">"); arrow.setStyle("-fx-text-fill: #cbd5e1; -fx-font-size: 18px; -fx-font-weight: bold; -fx-padding: 0 0 0 10;");

// //         row.getChildren().addAll(iconPane, texts, sp, hrBox, kcalBox, arrow);
// //         return row;
// //     }

// //     private VBox buildHealthMetrics() {
// //         VBox box = new VBox(20);
// //         box.setPrefWidth(320); box.setMinWidth(320);
// //         box.setPadding(new Insets(25));
// //         box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
// //         addHoverScale(box);

// //         Label title = new Label("Health Metrics");
// //         title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #0f172a;");

// //         GridPane grid = new GridPane();
// //         grid.setHgap(15); grid.setVgap(15);
// //         ColumnConstraints cc = new ColumnConstraints(); cc.setPercentWidth(50);
// //         grid.getColumnConstraints().addAll(cc, cc);

// //         // Uses the dynamic global labels defined at the top of the class
// //         grid.add(createDynamicMetricSquare("WEIGHT", weightLabel, "kg", "-0.2 from\nyesterday", "#10b981"), 0, 0);
// //         grid.add(createDynamicMetricSquare("BMI", bmiLabel, "", "Optimal\nRange", "#64748b"), 1, 0);
// //         grid.add(createDynamicMetricSquare("BLOOD\nPRESSURE", bpLabel, "", "Perfect", "#10b981"), 0, 1);
// //         grid.add(createDynamicMetricSquare("SPO2", spo2Label, "%", "Healthy", "#64748b"), 1, 1);

// //         Button manualBtn = new Button("+ Manual Metric Entry");
// //         manualBtn.setMaxWidth(Double.MAX_VALUE);
// //         manualBtn.setStyle("-fx-background-color: transparent; -fx-border-color: #cbd5e1; -fx-border-style: dashed; -fx-border-radius: 8; -fx-text-fill: #64748b; -fx-font-weight: bold; -fx-padding: 10; -fx-cursor: hand;");
        
// //         // Open the manual entry popup on click (Now integrated directly into the layout)
// //         manualBtn.setOnAction(e -> openManualMetricEntryDialog());

// //         box.getChildren().addAll(title, grid, manualBtn);
// //         return box;
// //     }

// //     private VBox createDynamicMetricSquare(String title, Label valLabel, String unit, String sub, String subColor) {
// //         VBox box = new VBox(5);
// //         box.setAlignment(Pos.CENTER);
// //         box.setPadding(new Insets(15));
// //         box.setStyle("-fx-background-color: #f8fafc; -fx-background-radius: 12;");
        
// //         Label t = new Label(title); 
// //         t.setStyle("-fx-font-size: 10px; -fx-font-weight: bold; -fx-text-fill: #64748b; -fx-text-alignment: center; -fx-letter-spacing: 1px;");
        
// //         HBox valBox = new HBox(2); 
// //         valBox.setAlignment(Pos.BOTTOM_CENTER);
        
// //         valLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
        
// //         Label u = new Label(unit); 
// //         u.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #0f172a; -fx-translate-y: -4px;");
// //         valBox.getChildren().addAll(valLabel, u);

// //         Label s = new Label(sub); 
// //         s.setStyle("-fx-font-size: 9px; -fx-text-fill: " + subColor + "; -fx-text-alignment: center; -fx-font-weight: bold;");
// //         box.getChildren().addAll(t, valBox, s);
// //         return box;
// //     }

// //     // === IN-SCENE POPUP OVERLAY DIALOG LOGIC ===
// //     private void openManualMetricEntryDialog() {
// //         // Create a semi-transparent dark overlay
// //         StackPane overlay = new StackPane();
// //         overlay.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4);");
// //         overlay.setAlignment(Pos.CENTER);

// //         // The central dialog box
// //         VBox dialogBox = new VBox(20);
// //         dialogBox.setPadding(new Insets(30));
// //         dialogBox.setMaxWidth(350);
// //         dialogBox.setMaxHeight(Region.USE_PREF_SIZE);
// //         dialogBox.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.25), 20, 0, 0, 8);");

// //         Label title = new Label("Update Health Metrics");
// //         title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");

// //         // Input Fields (pre-filled with current UI values)
// //         TextField wField = createStyledTextField(weightLabel.getText(), "Weight (kg)");
// //         TextField bmiField = createStyledTextField(bmiLabel.getText(), "BMI");
// //         TextField bpField = createStyledTextField(bpLabel.getText(), "Blood Pressure");
// //         TextField spo2Field = createStyledTextField(spo2Label.getText(), "SPO2 (%)");

// //         HBox buttonRow = new HBox(15);
// //         buttonRow.setAlignment(Pos.CENTER_RIGHT);

// //         Button cancelBtn = new Button("Cancel");
// //         cancelBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: #64748b; -fx-font-weight: bold; -fx-padding: 8 15; -fx-cursor: hand;");
        
// //         Button saveBtn = new Button("Save Metrics");
// //         saveBtn.setStyle("-fx-background-color: #10b981; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 8 20; -fx-background-radius: 8; -fx-cursor: hand;");
        
// //         addHoverScale(cancelBtn);
// //         addHoverScale(saveBtn);
        
// //         // Save action directly updates the labels on the dashboard UI and removes overlay
// //         saveBtn.setOnAction(e -> {
// //             weightLabel.setText(wField.getText());
// //             bmiLabel.setText(bmiField.getText());
// //             bpLabel.setText(bpField.getText());
// //             spo2Label.setText(spo2Field.getText());
// //             closeOverlay(overlay);
// //         });

// //         // Cancel removes overlay without saving
// //         cancelBtn.setOnAction(e -> closeOverlay(overlay));

// //         buttonRow.getChildren().addAll(cancelBtn, saveBtn);

// //         dialogBox.getChildren().addAll(
// //             title, 
// //             createInputRow("Weight (kg):", wField), 
// //             createInputRow("BMI:", bmiField), 
// //             createInputRow("Blood Pressure:", bpField), 
// //             createInputRow("SPO2 (%):", spo2Field), 
// //             buttonRow
// //         );

// //         overlay.getChildren().add(dialogBox);
        
// //         // Fade in the overlay
// //         overlay.setOpacity(0);
// //         rootContainer.getChildren().add(overlay);
        
// //         FadeTransition ft = new FadeTransition(Duration.millis(250), overlay);
// //         ft.setToValue(1.0);
// //         ft.play();
// //     }

// //     private void closeOverlay(StackPane overlay) {
// //         FadeTransition ft = new FadeTransition(Duration.millis(200), overlay);
// //         ft.setToValue(0);
// //         ft.setOnFinished(evt -> rootContainer.getChildren().remove(overlay));
// //         ft.play();
// //     }

// //     private TextField createStyledTextField(String text, String prompt) {
// //         TextField tf = new TextField(text);
// //         tf.setPromptText(prompt);
// //         tf.setStyle("-fx-background-color: #f8fafc; -fx-border-color: #cbd5e1; -fx-border-radius: 8; -fx-background-radius: 8; -fx-padding: 10; -fx-font-size: 14px;");
// //         return tf;
// //     }

// //     private VBox createInputRow(String label, TextField field) {
// //         VBox box = new VBox(5);
// //         Label l = new Label(label);
// //         l.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #475569;");
// //         box.getChildren().addAll(l, field);
// //         return box;
// //     }
// //     // ==========================================================

// //     // --- ROW 2 COMPONENTS ---
// //     private VBox buildSleepCycles() {
// //         VBox box = new VBox(15);
// //         box.setPadding(new Insets(25));
// //         box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
// //         addHoverScale(box);

// //         HBox header = new HBox();
// //         VBox titles = new VBox(2);
// //         Label title = new Label("Sleep Cycles"); title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #0f172a;");
// //         Label sub = new Label("Efficiency: 94% • 11:20 PM - 07:15 AM"); sub.setStyle("-fx-font-size: 12px; -fx-text-fill: #64748b;");
// //         titles.getChildren().addAll(title, sub);
// //         Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);
// //         Label moon = new Label("🌙"); moon.setStyle("-fx-text-fill: #0f172a; -fx-font-size: 20px;");
// //         header.getChildren().addAll(titles, sp, moon);

// //         // Chart Fake
// //         HBox chart = new HBox(12);
// //         chart.setAlignment(Pos.BOTTOM_CENTER);
// //         chart.setMinHeight(180);
// //         chart.setPadding(new Insets(15, 0, 0, 0));
        
// //         String deep = "#0f172a", rem = "#6ee7b7", light = "#93c5fd", wake = "#fca5a5";
// //         double[] heights = {100, 140, 110, 80, 130, 40, 90, 120};
// //         String[] colors = {rem, deep, rem, light, deep, rem, wake, light};

// //         for (int i = 0; i < heights.length; i++) {
// //             Rectangle bar = new Rectangle(40, heights[i]);
// //             bar.setFill(Color.web(colors[i]));
// //             chart.getChildren().add(bar);
// //         }

// //         HBox legend = new HBox(25);
// //         legend.setAlignment(Pos.CENTER);
// //         legend.setPadding(new Insets(10, 0, 0, 0));
// //         legend.getChildren().addAll(
// //             createLegendDot("Deep (1h 45m)", deep),
// //             createLegendDot("REM (2h 10m)", rem),
// //             createLegendDot("Light (3h 30m)", light)
// //         );

// //         box.getChildren().addAll(header, chart, legend);
// //         return box;
// //     }

// //     private HBox createLegendDot(String txt, String hex) {
// //         HBox box = new HBox(8); box.setAlignment(Pos.CENTER);
// //         Circle c = new Circle(5, Color.web(hex));
// //         Label l = new Label(txt); l.setStyle("-fx-font-size: 11px; -fx-font-weight: bold; -fx-text-fill: #475569;");
// //         box.getChildren().addAll(c, l);
// //         return box;
// //     }

// //     private VBox buildFatigueSoreness() {
// //         VBox box = new VBox(20);
// //         box.setPrefWidth(320); box.setMinWidth(320);
// //         box.setPadding(new Insets(25));
// //         box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
// //         addHoverScale(box);

// //         Label title = new Label("Fatigue & Soreness");
// //         title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #0f172a;");

// //         HBox split = new HBox(20);
// //         VBox leftBars = new VBox(20); HBox.setHgrow(leftBars, Priority.ALWAYS);
        
// //         leftBars.getChildren().addAll(
// //             createFatigueBar("Mental Fatigue", "Low", "#10b981", 0.25),
// //             createFatigueBar("Muscle Soreness", "Moderate", "#eab308", 0.6)
// //         );

// //         VBox alert = new VBox(8);
// //         alert.setPadding(new Insets(15));
// //         alert.setStyle("-fx-border-color: #fecaca; -fx-border-width: 1.5; -fx-border-radius: 8; -fx-background-color: #fef2f2; -fx-background-radius: 8;");
// //         Label aTitle = new Label("ALERT"); aTitle.setStyle("-fx-text-fill: #ef4444; -fx-font-weight: bold; -fx-font-size: 10px; -fx-letter-spacing: 1px;");
// //         Label aDesc = new Label("Right Hamstring tension noted. Recommended stretching: Dynamic Leg Swings.");
// //         aDesc.setWrapText(true); aDesc.setStyle("-fx-font-size: 12px; -fx-text-fill: #475569; -fx-line-spacing: 4px;");
// //         alert.getChildren().addAll(aTitle, aDesc);
// //         leftBars.getChildren().add(alert);

// //         VBox rightBody = new VBox(10);
// //         rightBody.setAlignment(Pos.CENTER);
// //         rightBody.setPrefWidth(90);
// //         rightBody.setStyle("-fx-background-color: #f1f5f9; -fx-background-radius: 12;");
// //         Label silhouette = new Label("🧍"); silhouette.setStyle("-fx-font-size: 45px; -fx-text-fill: #94a3b8;");
// //         Label bStatus = new Label("BODY STATUS"); bStatus.setStyle("-fx-font-size: 9px; -fx-font-weight: bold; -fx-text-fill: #64748b; -fx-letter-spacing: 1px;");
// //         HBox dots = new HBox(4); dots.setAlignment(Pos.CENTER);
// //         dots.getChildren().addAll(new Circle(3, Color.web("#10b981")), new Circle(3, Color.web("#eab308")), new Circle(3, Color.web("#10b981")));
// //         rightBody.getChildren().addAll(silhouette, bStatus, dots);

// //         split.getChildren().addAll(leftBars, rightBody);
// //         box.getChildren().addAll(title, split);
// //         return box;
// //     }

// //     private VBox createFatigueBar(String title, String val, String color, double pct) {
// //         VBox box = new VBox(5);
// //         HBox texts = new HBox();
// //         Label t = new Label(title); t.setStyle("-fx-font-weight: bold; -fx-font-size: 12px; -fx-text-fill: #0f172a;");
// //         Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);
// //         Label v = new Label(val); v.setStyle("-fx-font-weight: bold; -fx-font-size: 12px; -fx-text-fill: " + color + ";");
// //         texts.getChildren().addAll(t, sp, v);

// //         StackPane barPane = new StackPane(); barPane.setAlignment(Pos.CENTER_LEFT);
// //         Rectangle bg = new Rectangle(140, 8, Color.web("#f1f5f9")); bg.setArcWidth(8); bg.setArcHeight(8);
// //         Rectangle prog = new Rectangle(140 * pct, 8, Color.web(color)); prog.setArcWidth(8); prog.setArcHeight(8);
// //         barPane.getChildren().addAll(bg, prog);

// //         box.getChildren().addAll(texts, barPane);
// //         return box;
// //     }

// //     // --- ROW 3 COMPONENTS ---
// //     private VBox buildDailyGoals() {
// //         VBox box = new VBox(20);
// //         box.setPadding(new Insets(25));
// //         box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
// //         addHoverScale(box);

// //         Label title = new Label("Daily Goals");
// //         title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #0f172a;");

// //         VBox list = new VBox(15);
// //         list.getChildren().addAll(
// //             createInteractiveCheck("Complete 3.5L Water", true),
// //             createInteractiveCheck("High Intensity Drills", true),
// //             createInteractiveCheck("8h Restoration Sleep", false),
// //             createInteractiveCheck("Log Evening Macros", false)
// //         );

// //         box.getChildren().addAll(title, list);
// //         return box;
// //     }

// //     private HBox createInteractiveCheck(String text, boolean isChecked) {
// //         HBox row = new HBox(12);
// //         row.setAlignment(Pos.CENTER_LEFT);
// //         row.setStyle("-fx-cursor: hand;");
// //         boolean[] state = { isChecked };
        
// //         Label box = new Label(state[0] ? "☑" : "☐");
// //         box.setStyle("-fx-text-fill: " + (state[0] ? "#10b981" : "#cbd5e1") + "; -fx-font-size: 22px;");
        
// //         Label txt = new Label(text);
// //         txt.setStyle("-fx-font-size: 14px; -fx-text-fill: #475569;");
        
// //         row.setOnMouseClicked(e -> {
// //             state[0] = !state[0];
// //             box.setText(state[0] ? "☑" : "☐");
// //             box.setStyle("-fx-text-fill: " + (state[0] ? "#10b981" : "#cbd5e1") + "; -fx-font-size: 22px;");
// //         });
// //         row.getChildren().addAll(box, txt);
// //         return row;
// //     }

// //     private VBox buildActivityTimeline() {
// //         VBox box = new VBox(20);
// //         box.setPadding(new Insets(25));
// //         box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
// //         addHoverScale(box);

// //         Label title = new Label("Activity Timeline");
// //         title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #0f172a;");

// //         VBox list = new VBox(0);
// //         list.getChildren().addAll(
// //             createTimelineItem("07:15 AM", "Sleep Synced from WHOOP", "Score: 84 (Great Recovery)", true, true),
// //             createTimelineItem("10:30 AM", "Morning Technical Practice", "45m Batting Drills completed", true, true),
// //             createTimelineItem("05:00 PM (Planned)", "Recovery Protocol", "Stretching and Foam Rolling", false, false)
// //         );

// //         box.getChildren().addAll(title, list);
// //         return box;
// //     }

// //     private HBox createTimelineItem(String time, String title, String sub, boolean isDone, boolean hasLine) {
// //         HBox row = new HBox(15);
// //         row.setAlignment(Pos.TOP_LEFT);

// //         VBox graphic = new VBox(2);
// //         graphic.setAlignment(Pos.TOP_CENTER);
        
// //         Circle dot = new Circle(7, Color.WHITE);
// //         dot.setStroke(isDone ? Color.web("#10b981") : Color.web("#e2e8f0"));
// //         dot.setStrokeWidth(3);
// //         graphic.getChildren().add(dot);
        
// //         if (hasLine) {
// //             Line line = new Line(0, 0, 0, 40);
// //             line.setStroke(Color.web("#f1f5f9"));
// //             line.setStrokeWidth(2);
// //             graphic.getChildren().add(line);
// //         }

// //         VBox texts = new VBox(4);
// //         texts.setPadding(new Insets(0, 0, 15, 0));
// //         Label tm = new Label(time); tm.setStyle("-fx-font-size: 11px; -fx-font-weight: bold; -fx-text-fill: #64748b;");
// //         Label t = new Label(title); t.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: " + (isDone ? "#0f172a" : "#94a3b8") + ";");
// //         Label s = new Label(sub); s.setStyle("-fx-font-size: 12px; -fx-text-fill: #94a3b8;");
// //         texts.getChildren().addAll(tm, t, s);

// //         row.getChildren().addAll(graphic, texts);
// //         return row;
// //     }

// //     private VBox buildDailyCoach() {
// //         VBox box = new VBox(20);
// //         box.setPrefWidth(320); box.setMinWidth(320);
// //         box.setPadding(new Insets(25));
// //         box.setStyle("-fx-background-color: #0f172a; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.15), 15, 0, 0, 8);");
// //         addHoverScale(box);

// //         HBox header = new HBox(10);
// //         header.setAlignment(Pos.CENTER_LEFT);
// //         Label icon = new Label("✨"); icon.setStyle("-fx-text-fill: #10b981; -fx-font-size: 20px;");
// //         VBox titles = new VBox();
// //         Label t1 = new Label("Daily Coach"); t1.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: white;");
// //         Label t2 = new Label("ACTIVE INSIGHT"); t2.setStyle("-fx-font-size: 10px; -fx-font-weight: bold; -fx-text-fill: #34d399; -fx-letter-spacing: 1px;");
// //         titles.getChildren().addAll(t1, t2);
// //         header.getChildren().addAll(icon, titles);

// //         VBox statusBox = new VBox(5);
// //         Label st1 = new Label("MATCH READINESS"); st1.setStyle("-fx-font-size: 11px; -fx-text-fill: #94a3b8; -fx-font-weight: bold; -fx-letter-spacing: 1px;");
// //         HBox stRow = new HBox(8); stRow.setAlignment(Pos.CENTER_LEFT);
// //         Label st2 = new Label("Optimum"); st2.setStyle("-fx-font-size: 26px; -fx-font-weight: bold; -fx-text-fill: white;");
// //         Label check = new Label("☑"); check.setStyle("-fx-text-fill: #10b981; -fx-font-size: 24px;");
// //         stRow.getChildren().addAll(st2, check);
// //         statusBox.getChildren().addAll(st1, stRow);

// //         Label quote = new Label("\"Your HRV trend is up 12% this week. Today is the perfect time for high-intensity power training. Ensure you hit your calorie surplus by +200 today.\"");
// //         quote.setWrapText(true);
// //         quote.setStyle("-fx-text-fill: #cbd5e1; -fx-font-size: 14px; -fx-font-style: italic; -fx-line-spacing: 6px;");

// //         Region sp = new Region(); VBox.setVgrow(sp, Priority.ALWAYS);

// //         Button askBtn = new Button("Ask AI Assistant");
// //         askBtn.setMaxWidth(Double.MAX_VALUE);
// //         askBtn.setStyle("-fx-background-color: transparent; -fx-border-color: #10b981; -fx-border-radius: 8; -fx-text-fill: #10b981; -fx-font-weight: bold; -fx-padding: 12; -fx-font-size: 14px; -fx-cursor: hand;");
// //         addHoverScale(askBtn);

// //         box.getChildren().addAll(header, statusBox, quote, sp, askBtn);
// //         return box;
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
// import javafx.scene.control.TextField;
// import javafx.scene.layout.*;
// import javafx.scene.paint.Color;
// import javafx.scene.shape.Circle;
// import javafx.scene.shape.Line;
// import javafx.scene.shape.Rectangle;
// import javafx.util.Duration;

// public class Fitness_StartWorkoutButton {

//     private StackPane rootContainer;
//     private Runnable onBack;

//     // --- Dynamic Labels for Health Metrics ---
//     private Label weightLabel = new Label("78.5");
//     private Label bmiLabel = new Label("23.4");
//     private Label bpLabel = new Label("118/76");
//     private Label spo2Label = new Label("99");

//     public Fitness_StartWorkoutButton(Runnable onBack) {
//         this.onBack = onBack;
//     }

//     public Node getView() {
//         if (rootContainer == null) {
//             rootContainer = new StackPane();
//             rootContainer.setStyle("-fx-background-color: #f8fafc;");

//             VBox mainLayout = new VBox(25);
//             mainLayout.setPadding(new Insets(20, 40, 40, 40));

//             // --- UI Sections ---
//             Node backButtonRow = buildBackButton();
            
//             // Row 1: Workout Log & Health Metrics
//             HBox row1 = new HBox(25);
//             Node workoutLog = buildWorkoutLog();
//             HBox.setHgrow(workoutLog, Priority.ALWAYS);
//             Node healthMetrics = buildHealthMetrics();
//             row1.getChildren().addAll(workoutLog, healthMetrics);

//             // Row 2: Sleep Cycles & Fatigue
//             HBox row2 = new HBox(25);
//             Node sleepCycles = buildSleepCycles();
//             HBox.setHgrow(sleepCycles, Priority.ALWAYS);
//             Node fatigueSoreness = buildFatigueSoreness();
//             row2.getChildren().addAll(sleepCycles, fatigueSoreness);

//             // Row 3: Daily Goals, Timeline & Daily Coach
//             HBox row3 = new HBox(25);
            
//             VBox dailyGoals = buildDailyGoals();
//             HBox.setHgrow(dailyGoals, Priority.ALWAYS);
            
//             VBox timeline = buildActivityTimeline();
//             HBox.setHgrow(timeline, Priority.ALWAYS);
            
//             Node dailyCoach = buildDailyCoach();
//             row3.getChildren().addAll(dailyGoals, timeline, dailyCoach);

//             mainLayout.getChildren().addAll(backButtonRow, row1, row2, row3);

//             // --- Entrance Animations ---
//             animateNodeEntrance(backButtonRow, 0);
//             animateNodeEntrance(row1, 100);
//             animateNodeEntrance(row2, 200);
//             animateNodeEntrance(row3, 300);

//             ScrollPane scrollPane = new ScrollPane(mainLayout);
//             scrollPane.setFitToWidth(true);
//             scrollPane.setStyle("-fx-background-color: transparent; -fx-background: #f8fafc;");
//             scrollPane.getStylesheets().add("data:text/css,.scroll-pane > .viewport { -fx-background-color: transparent; }");

//             rootContainer.getChildren().add(scrollPane);
//         }
//         return rootContainer;
//     }

//     // --- ANIMATIONS ---
//     private void animateNodeEntrance(Node node, int delayMillis) {
//         node.setOpacity(0);
//         node.setTranslateY(25);
//         FadeTransition ft = new FadeTransition(Duration.millis(500), node);
//         ft.setToValue(1.0);
//         TranslateTransition tt = new TranslateTransition(Duration.millis(500), node);
//         tt.setToY(0);
//         ParallelTransition pt = new ParallelTransition(ft, tt);
//         pt.setDelay(Duration.millis(delayMillis));
//         pt.play();
//     }

//     private void addHoverScale(Node node) {
//         ScaleTransition scaleIn = new ScaleTransition(Duration.millis(150), node);
//         scaleIn.setToX(1.02); scaleIn.setToY(1.02);
//         ScaleTransition scaleOut = new ScaleTransition(Duration.millis(150), node);
//         scaleOut.setToX(1.0); scaleOut.setToY(1.0);
//         node.setOnMouseEntered(e -> scaleIn.playFromStart());
//         node.setOnMouseExited(e -> scaleOut.playFromStart());
//     }

//     // --- BACK BUTTON ---
//     private HBox buildBackButton() {
//         HBox row = new HBox();
//         row.setAlignment(Pos.CENTER_LEFT);
//         Button backBtn = new Button("← Back to Elite Performance Hub");
//         backBtn.setStyle("-fx-background-color: white; -fx-text-fill: #475569; -fx-font-weight: bold; -fx-font-size: 13px; -fx-padding: 8 15; -fx-background-radius: 20; -fx-border-color: #e2e8f0; -fx-border-radius: 20; -fx-cursor: hand;");
//         addHoverScale(backBtn);
//         backBtn.setOnAction(e -> { if (onBack != null) onBack.run(); });
//         row.getChildren().add(backBtn);
//         return row;
//     }

//     // --- ROW 1 COMPONENTS ---
//     private VBox buildWorkoutLog() {
//         VBox box = new VBox(20);
//         box.setPadding(new Insets(25));
//         box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
//         addHoverScale(box);

//         HBox header = new HBox();
//         Label title = new Label("Workout Log");
//         title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #0f172a;");
//         Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);
        
//         Label toggle = new Label("Today   History");
//         toggle.setStyle("-fx-background-color: #f1f5f9; -fx-padding: 6 14; -fx-background-radius: 15; -fx-font-size: 11px; -fx-font-weight: bold; -fx-text-fill: #64748b; -fx-cursor: hand;");
//         header.getChildren().addAll(title, sp, toggle);

//         VBox list = new VBox(15);
//         list.getChildren().addAll(
//             createWorkoutItem("🏏", "#d1fae5", "#10b981", "Batting Practice - Technical", "Duration: 45m • Intensity: Medium", "142", "380"),
//             createWorkoutItem("🏃", "#fee2e2", "#ef4444", "Sprint Training - Max Effort", "Duration: 20m • Intensity: High", "168", "410")
//         );
//         box.getChildren().addAll(header, list);
//         return box;
//     }

//     private HBox createWorkoutItem(String icon, String bgHex, String iconHex, String title, String sub, String hr, String kcal) {
//         HBox row = new HBox(15);
//         row.setAlignment(Pos.CENTER_LEFT);
//         row.setPadding(new Insets(15, 20, 15, 20));
//         row.setStyle("-fx-background-color: white; -fx-border-color: #f1f5f9; -fx-border-width: 2; -fx-border-radius: 12; -fx-background-radius: 12;");

//         StackPane iconPane = new StackPane();
//         Circle c = new Circle(20, Color.web(bgHex));
//         Label i = new Label(icon); i.setStyle("-fx-text-fill: " + iconHex + "; -fx-font-size: 16px;");
//         iconPane.getChildren().addAll(c, i);

//         VBox texts = new VBox(3);
//         Label t = new Label(title); t.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: #0f172a;");
//         Label s = new Label(sub); s.setStyle("-fx-font-size: 11px; -fx-text-fill: #64748b;");
//         texts.getChildren().addAll(t, s);

//         Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);

//         VBox hrBox = new VBox(); hrBox.setAlignment(Pos.CENTER);
//         Label hrV = new Label(hr); hrV.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: #0f172a;");
//         Label hrL = new Label("Avg HR"); hrL.setStyle("-fx-font-size: 10px; -fx-text-fill: #94a3b8; -fx-font-weight: bold;");
//         hrBox.getChildren().addAll(hrV, hrL);

//         VBox kcalBox = new VBox(); kcalBox.setAlignment(Pos.CENTER);
//         Label kcV = new Label(kcal); kcV.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: #0f172a;");
//         Label kcL = new Label("kcal"); kcL.setStyle("-fx-font-size: 10px; -fx-text-fill: #94a3b8; -fx-font-weight: bold;");
//         kcalBox.getChildren().addAll(kcV, kcL);

//         Label arrow = new Label(">"); arrow.setStyle("-fx-text-fill: #cbd5e1; -fx-font-size: 18px; -fx-font-weight: bold; -fx-padding: 0 0 0 10;");

//         row.getChildren().addAll(iconPane, texts, sp, hrBox, kcalBox, arrow);
//         return row;
//     }

//     private VBox buildHealthMetrics() {
//         VBox box = new VBox(20);
//         box.setPrefWidth(320); box.setMinWidth(320);
//         box.setPadding(new Insets(25));
//         box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
//         addHoverScale(box);

//         Label title = new Label("Health Metrics");
//         title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #0f172a;");

//         GridPane grid = new GridPane();
//         grid.setHgap(15); grid.setVgap(15);
//         ColumnConstraints cc = new ColumnConstraints(); cc.setPercentWidth(50);
//         grid.getColumnConstraints().addAll(cc, cc);

//         grid.add(createDynamicMetricSquare("WEIGHT", weightLabel, "kg", "-0.2 from\nyesterday", "#10b981"), 0, 0);
//         grid.add(createDynamicMetricSquare("BMI", bmiLabel, "", "Optimal\nRange", "#64748b"), 1, 0);
//         grid.add(createDynamicMetricSquare("BLOOD\nPRESSURE", bpLabel, "", "Perfect", "#10b981"), 0, 1);
//         grid.add(createDynamicMetricSquare("SPO2", spo2Label, "%", "Healthy", "#64748b"), 1, 1);

//         Button manualBtn = new Button("+ Manual Metric Entry");
//         manualBtn.setMaxWidth(Double.MAX_VALUE);
//         manualBtn.setStyle("-fx-background-color: transparent; -fx-border-color: #cbd5e1; -fx-border-style: dashed; -fx-border-radius: 8; -fx-text-fill: #64748b; -fx-font-weight: bold; -fx-padding: 10; -fx-cursor: hand;");
        
//         manualBtn.setOnAction(e -> openManualMetricEntryDialog());

//         box.getChildren().addAll(title, grid, manualBtn);
//         return box;
//     }

//     private VBox createDynamicMetricSquare(String title, Label valLabel, String unit, String sub, String subColor) {
//         VBox box = new VBox(5);
//         box.setAlignment(Pos.CENTER);
//         box.setPadding(new Insets(15));
//         box.setStyle("-fx-background-color: #f8fafc; -fx-background-radius: 12;");
        
//         Label t = new Label(title); 
//         t.setStyle("-fx-font-size: 10px; -fx-font-weight: bold; -fx-text-fill: #64748b; -fx-text-alignment: center; -fx-letter-spacing: 1px;");
        
//         HBox valBox = new HBox(2); 
//         valBox.setAlignment(Pos.BOTTOM_CENTER);
//         valLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
//         Label u = new Label(unit); 
//         u.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #0f172a; -fx-translate-y: -4px;");
//         valBox.getChildren().addAll(valLabel, u);

//         Label s = new Label(sub); 
//         s.setStyle("-fx-font-size: 9px; -fx-text-fill: " + subColor + "; -fx-text-alignment: center; -fx-font-weight: bold;");
//         box.getChildren().addAll(t, valBox, s);
//         return box;
//     }

//     // --- MANUAL ENTRY DIALOG OVERLAY ---
//     private void openManualMetricEntryDialog() {
//         StackPane overlay = new StackPane();
//         overlay.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4);");
//         overlay.setAlignment(Pos.CENTER);

//         VBox dialogBox = new VBox(20);
//         dialogBox.setPadding(new Insets(30));
//         dialogBox.setMaxWidth(350);
//         dialogBox.setMaxHeight(Region.USE_PREF_SIZE);
//         dialogBox.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.25), 20, 0, 0, 8);");

//         Label title = new Label("Update Health Metrics");
//         title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");

//         TextField wField = createStyledTextField(weightLabel.getText(), "Weight (kg)");
//         TextField bmiField = createStyledTextField(bmiLabel.getText(), "BMI");
//         TextField bpField = createStyledTextField(bpLabel.getText(), "Blood Pressure");
//         TextField spo2Field = createStyledTextField(spo2Label.getText(), "SPO2 (%)");

//         HBox buttonRow = new HBox(15);
//         buttonRow.setAlignment(Pos.CENTER_RIGHT);

//         Button cancelBtn = new Button("Cancel");
//         cancelBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: #64748b; -fx-font-weight: bold; -fx-padding: 8 15; -fx-cursor: hand;");
        
//         Button saveBtn = new Button("Save Metrics");
//         saveBtn.setStyle("-fx-background-color: #10b981; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 8 20; -fx-background-radius: 8; -fx-cursor: hand;");
        
//         addHoverScale(cancelBtn); addHoverScale(saveBtn);
        
//         saveBtn.setOnAction(e -> {
//             weightLabel.setText(wField.getText());
//             bmiLabel.setText(bmiField.getText());
//             bpLabel.setText(bpField.getText());
//             spo2Label.setText(spo2Field.getText());
//             closeOverlay(overlay);
//         });

//         cancelBtn.setOnAction(e -> closeOverlay(overlay));
//         buttonRow.getChildren().addAll(cancelBtn, saveBtn);

//         dialogBox.getChildren().addAll(
//             title, 
//             createInputRow("Weight (kg):", wField), 
//             createInputRow("BMI:", bmiField), 
//             createInputRow("Blood Pressure:", bpField), 
//             createInputRow("SPO2 (%):", spo2Field), 
//             buttonRow
//         );

//         overlay.getChildren().add(dialogBox);
//         overlay.setOpacity(0);
//         rootContainer.getChildren().add(overlay);
//         FadeTransition ft = new FadeTransition(Duration.millis(250), overlay);
//         ft.setToValue(1.0);
//         ft.play();
//     }

//     private void closeOverlay(StackPane overlay) {
//         FadeTransition ft = new FadeTransition(Duration.millis(200), overlay);
//         ft.setToValue(0);
//         ft.setOnFinished(evt -> rootContainer.getChildren().remove(overlay));
//         ft.play();
//     }

//     private TextField createStyledTextField(String text, String prompt) {
//         TextField tf = new TextField(text);
//         tf.setPromptText(prompt);
//         tf.setStyle("-fx-background-color: #f8fafc; -fx-border-color: #cbd5e1; -fx-border-radius: 8; -fx-background-radius: 8; -fx-padding: 10; -fx-font-size: 14px;");
//         return tf;
//     }

//     private VBox createInputRow(String label, TextField field) {
//         VBox box = new VBox(5);
//         Label l = new Label(label);
//         l.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #475569;");
//         box.getChildren().addAll(l, field);
//         return box;
//     }

//     // --- ROW 2 COMPONENTS ---
//     private VBox buildSleepCycles() {
//         VBox box = new VBox(15);
//         box.setPadding(new Insets(25));
//         box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
//         addHoverScale(box);

//         HBox header = new HBox();
//         VBox titles = new VBox(2);
//         Label title = new Label("Sleep Cycles"); title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #0f172a;");
//         Label sub = new Label("Efficiency: 94% • 11:20 PM - 07:15 AM"); sub.setStyle("-fx-font-size: 12px; -fx-text-fill: #64748b;");
//         titles.getChildren().addAll(title, sub);
//         Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);
//         Label moon = new Label("🌙"); moon.setStyle("-fx-text-fill: #0f172a; -fx-font-size: 20px;");
//         header.getChildren().addAll(titles, sp, moon);

//         HBox chart = new HBox(12);
//         chart.setAlignment(Pos.BOTTOM_CENTER);
//         chart.setMinHeight(180);
//         chart.setPadding(new Insets(15, 0, 0, 0));
        
//         String deep = "#0f172a", rem = "#6ee7b7", light = "#93c5fd", wake = "#fca5a5";
//         double[] heights = {100, 140, 110, 80, 130, 40, 90, 120};
//         String[] colors = {rem, deep, rem, light, deep, rem, wake, light};

//         for (int i = 0; i < heights.length; i++) {
//             Rectangle bar = new Rectangle(40, heights[i]);
//             bar.setFill(Color.web(colors[i]));
//             chart.getChildren().add(bar);
//         }

//         HBox legend = new HBox(25);
//         legend.setAlignment(Pos.CENTER);
//         legend.setPadding(new Insets(10, 0, 0, 0));
//         legend.getChildren().addAll(
//             createLegendDot("Deep (1h 45m)", deep),
//             createLegendDot("REM (2h 10m)", rem),
//             createLegendDot("Light (3h 30m)", light)
//         );

//         box.getChildren().addAll(header, chart, legend);
//         return box;
//     }

//     private HBox createLegendDot(String txt, String hex) {
//         HBox box = new HBox(8); box.setAlignment(Pos.CENTER);
//         Circle c = new Circle(5, Color.web(hex));
//         Label l = new Label(txt); l.setStyle("-fx-font-size: 11px; -fx-font-weight: bold; -fx-text-fill: #475569;");
//         box.getChildren().addAll(c, l);
//         return box;
//     }

//     private VBox buildFatigueSoreness() {
//         VBox box = new VBox(20);
//         box.setPrefWidth(320); box.setMinWidth(320);
//         box.setPadding(new Insets(25));
//         box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
//         addHoverScale(box);

//         Label title = new Label("Fatigue & Soreness");
//         title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #0f172a;");

//         HBox split = new HBox(20);
//         VBox leftBars = new VBox(20); HBox.setHgrow(leftBars, Priority.ALWAYS);
        
//         leftBars.getChildren().addAll(
//             createFatigueBar("Mental Fatigue", "Low", "#10b981", 0.25),
//             createFatigueBar("Muscle Soreness", "Moderate", "#eab308", 0.6)
//         );

//         VBox alert = new VBox(8);
//         alert.setPadding(new Insets(15));
//         alert.setStyle("-fx-border-color: #fecaca; -fx-border-width: 1.5; -fx-border-radius: 8; -fx-background-color: #fef2f2; -fx-background-radius: 8;");
//         Label aTitle = new Label("ALERT"); aTitle.setStyle("-fx-text-fill: #ef4444; -fx-font-weight: bold; -fx-font-size: 10px; -fx-letter-spacing: 1px;");
//         Label aDesc = new Label("Right Hamstring tension noted. Recommended stretching: Dynamic Leg Swings.");
//         aDesc.setWrapText(true); aDesc.setStyle("-fx-font-size: 12px; -fx-text-fill: #475569; -fx-line-spacing: 4px;");
//         alert.getChildren().addAll(aTitle, aDesc);
//         leftBars.getChildren().add(alert);

//         VBox rightBody = new VBox(10);
//         rightBody.setAlignment(Pos.CENTER);
//         rightBody.setPrefWidth(90);
//         rightBody.setStyle("-fx-background-color: #f1f5f9; -fx-background-radius: 12;");
//         Label silhouette = new Label("🧍"); silhouette.setStyle("-fx-font-size: 45px; -fx-text-fill: #94a3b8;");
//         Label bStatus = new Label("BODY STATUS"); bStatus.setStyle("-fx-font-size: 9px; -fx-font-weight: bold; -fx-text-fill: #64748b; -fx-letter-spacing: 1px;");
//         HBox dots = new HBox(4); dots.setAlignment(Pos.CENTER);
//         dots.getChildren().addAll(new Circle(3, Color.web("#10b981")), new Circle(3, Color.web("#eab308")), new Circle(3, Color.web("#10b981")));
//         rightBody.getChildren().addAll(silhouette, bStatus, dots);

//         split.getChildren().addAll(leftBars, rightBody);
//         box.getChildren().addAll(title, split);
//         return box;
//     }

//     private VBox createFatigueBar(String title, String val, String color, double pct) {
//         VBox box = new VBox(5);
//         HBox texts = new HBox();
//         Label t = new Label(title); t.setStyle("-fx-font-weight: bold; -fx-font-size: 12px; -fx-text-fill: #0f172a;");
//         Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);
//         Label v = new Label(val); v.setStyle("-fx-font-weight: bold; -fx-font-size: 12px; -fx-text-fill: " + color + ";");
//         texts.getChildren().addAll(t, sp, v);

//         StackPane barPane = new StackPane(); barPane.setAlignment(Pos.CENTER_LEFT);
//         Rectangle bg = new Rectangle(140, 8, Color.web("#f1f5f9")); bg.setArcWidth(8); bg.setArcHeight(8);
//         Rectangle prog = new Rectangle(140 * pct, 8, Color.web(color)); prog.setArcWidth(8); prog.setArcHeight(8);
//         barPane.getChildren().addAll(bg, prog);

//         box.getChildren().addAll(texts, barPane);
//         return box;
//     }

//     // --- ROW 3 COMPONENTS ---
//     private VBox buildDailyGoals() {
//         VBox box = new VBox(20);
//         box.setPadding(new Insets(25));
//         box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
//         addHoverScale(box);

//         Label title = new Label("Daily Goals");
//         title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #0f172a;");

//         VBox list = new VBox(15);
//         list.getChildren().addAll(
//             createInteractiveCheck("Complete 3.5L Water", true),
//             createInteractiveCheck("High Intensity Drills", true),
//             createInteractiveCheck("8h Restoration Sleep", false),
//             createInteractiveCheck("Log Evening Macros", false)
//         );

//         box.getChildren().addAll(title, list);
//         return box;
//     }

//     private HBox createInteractiveCheck(String text, boolean isChecked) {
//         HBox row = new HBox(12);
//         row.setAlignment(Pos.CENTER_LEFT);
//         row.setStyle("-fx-cursor: hand;");
//         boolean[] state = { isChecked };
        
//         Label box = new Label(state[0] ? "☑" : "☐");
//         box.setStyle("-fx-text-fill: " + (state[0] ? "#10b981" : "#cbd5e1") + "; -fx-font-size: 22px;");
        
//         Label txt = new Label(text);
//         txt.setStyle("-fx-font-size: 14px; -fx-text-fill: #475569;");
        
//         row.setOnMouseClicked(e -> {
//             state[0] = !state[0];
//             box.setText(state[0] ? "☑" : "☐");
//             box.setStyle("-fx-text-fill: " + (state[0] ? "#10b981" : "#cbd5e1") + "; -fx-font-size: 22px;");
//         });
//         row.getChildren().addAll(box, txt);
//         return row;
//     }

//     private VBox buildActivityTimeline() {
//         VBox box = new VBox(20);
//         box.setPadding(new Insets(25));
//         box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
//         addHoverScale(box);

//         Label title = new Label("Activity Timeline");
//         title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #0f172a;");

//         VBox list = new VBox(0);
//         list.getChildren().addAll(
//             createTimelineItem("07:15 AM", "Sleep Synced from WHOOP", "Score: 84 (Great Recovery)", true, true),
//             createTimelineItem("10:30 AM", "Morning Technical Practice", "45m Batting Drills completed", true, true),
//             createTimelineItem("05:00 PM (Planned)", "Recovery Protocol", "Stretching and Foam Rolling", false, false)
//         );

//         box.getChildren().addAll(title, list);
//         return box;
//     }

//     private HBox createTimelineItem(String time, String title, String sub, boolean isDone, boolean hasLine) {
//         HBox row = new HBox(15);
//         row.setAlignment(Pos.TOP_LEFT);

//         VBox graphic = new VBox(2);
//         graphic.setAlignment(Pos.TOP_CENTER);
        
//         Circle dot = new Circle(7, Color.WHITE);
//         dot.setStroke(isDone ? Color.web("#10b981") : Color.web("#e2e8f0"));
//         dot.setStrokeWidth(3);
//         graphic.getChildren().add(dot);
        
//         if (hasLine) {
//             Line line = new Line(0, 0, 0, 40);
//             line.setStroke(Color.web("#f1f5f9"));
//             line.setStrokeWidth(2);
//             graphic.getChildren().add(line);
//         }

//         VBox texts = new VBox(4);
//         texts.setPadding(new Insets(0, 0, 15, 0));
//         Label tm = new Label(time); tm.setStyle("-fx-font-size: 11px; -fx-font-weight: bold; -fx-text-fill: #64748b;");
//         Label t = new Label(title); t.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: " + (isDone ? "#0f172a" : "#94a3b8") + ";");
//         Label s = new Label(sub); s.setStyle("-fx-font-size: 12px; -fx-text-fill: #94a3b8;");
//         texts.getChildren().addAll(tm, t, s);

//         row.getChildren().addAll(graphic, texts);
//         return row;
//     }

//     private VBox buildDailyCoach() {
//         VBox box = new VBox(20);
//         box.setPrefWidth(320); box.setMinWidth(320);
//         box.setPadding(new Insets(25));
//         box.setStyle("-fx-background-color: #0f172a; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.15), 15, 0, 0, 8);");
//         addHoverScale(box);

//         HBox header = new HBox(10);
//         header.setAlignment(Pos.CENTER_LEFT);
//         Label icon = new Label("✨"); icon.setStyle("-fx-text-fill: #10b981; -fx-font-size: 20px;");
//         VBox titles = new VBox();
//         Label t1 = new Label("Daily Coach"); t1.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: white;");
//         Label t2 = new Label("ACTIVE INSIGHT"); t2.setStyle("-fx-font-size: 10px; -fx-font-weight: bold; -fx-text-fill: #34d399; -fx-letter-spacing: 1px;");
//         titles.getChildren().addAll(t1, t2);
//         header.getChildren().addAll(icon, titles);

//         VBox statusBox = new VBox(5);
//         Label st1 = new Label("MATCH READINESS"); st1.setStyle("-fx-font-size: 11px; -fx-text-fill: #94a3b8; -fx-font-weight: bold; -fx-letter-spacing: 1px;");
//         HBox stRow = new HBox(8); stRow.setAlignment(Pos.CENTER_LEFT);
//         Label st2 = new Label("Optimum"); st2.setStyle("-fx-font-size: 26px; -fx-font-weight: bold; -fx-text-fill: white;");
//         Label check = new Label("☑"); check.setStyle("-fx-text-fill: #10b981; -fx-font-size: 24px;");
//         stRow.getChildren().addAll(st2, check);
//         statusBox.getChildren().addAll(st1, stRow);

//         Label quote = new Label("\"Your HRV trend is up 12% this week. Today is the perfect time for high-intensity power training. Ensure you hit your calorie surplus by +200 today.\"");
//         quote.setWrapText(true);
//         quote.setStyle("-fx-text-fill: #cbd5e1; -fx-font-size: 14px; -fx-font-style: italic; -fx-line-spacing: 6px;");

//         Region sp = new Region(); VBox.setVgrow(sp, Priority.ALWAYS);

//         // === AI CHAT BUTTON LOGIC ===
//         Button askBtn = new Button("Ask AI Assistant");
//         askBtn.setMaxWidth(Double.MAX_VALUE);
//         askBtn.setStyle("-fx-background-color: transparent; -fx-border-color: #10b981; -fx-border-radius: 8; -fx-text-fill: #10b981; -fx-font-weight: bold; -fx-padding: 12; -fx-font-size: 14px; -fx-cursor: hand;");
//         addHoverScale(askBtn);
        
//         // Open the AI Chat Overlay on click
//         askBtn.setOnAction(e -> openAIChatDialog());

//         box.getChildren().addAll(header, statusBox, quote, sp, askBtn);
//         return box;
//     }

//     // === IN-SCENE AI CHAT OVERLAY DIALOG ===
//     private void openAIChatDialog() {
//         StackPane overlay = new StackPane();
//         overlay.setStyle("-fx-background-color: rgba(0, 0, 0, 0.5);");
//         overlay.setAlignment(Pos.CENTER);

//         VBox chatBox = new VBox(15);
//         chatBox.setPadding(new Insets(20));
//         chatBox.setMaxWidth(400);
//         chatBox.setMaxHeight(500);
//         chatBox.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.25), 20, 0, 0, 8);");

//         // Header
//         HBox header = new HBox();
//         header.setAlignment(Pos.CENTER_LEFT);
//         Label title = new Label("✨ AI Coach Assistant");
//         title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
//         Region spacer = new Region(); HBox.setHgrow(spacer, Priority.ALWAYS);
//         Button closeBtn = new Button("✕");
//         closeBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: #94a3b8; -fx-font-size: 16px; -fx-cursor: hand;");
//         closeBtn.setOnAction(e -> closeOverlay(overlay));
//         header.getChildren().addAll(title, spacer, closeBtn);

//         // Chat History Area
//         VBox chatHistory = new VBox(15);
//         chatHistory.setPadding(new Insets(10, 10, 10, 5));
//         ScrollPane scrollPane = new ScrollPane(chatHistory);
//         scrollPane.setFitToWidth(true);
//         scrollPane.setStyle("-fx-background-color: transparent; -fx-background: white; -fx-border-color: transparent;");
//         scrollPane.getStylesheets().add("data:text/css,.scroll-pane > .viewport { -fx-background-color: transparent; }");
//         VBox.setVgrow(scrollPane, Priority.ALWAYS);

//         // Initial Greeting
//         addChatMessage(chatHistory, "Hello! I'm your AI Coach. How can I help you optimize your training today?", false);

//         // Input Area
//         HBox inputArea = new HBox(10);
//         inputArea.setAlignment(Pos.CENTER);
//         TextField inputField = new TextField();
//         inputField.setPromptText("Ask about your metrics...");
//         inputField.setStyle("-fx-background-color: #f8fafc; -fx-border-color: #cbd5e1; -fx-border-radius: 20; -fx-background-radius: 20; -fx-padding: 10 15; -fx-font-size: 13px;");
//         HBox.setHgrow(inputField, Priority.ALWAYS);
        
//         Button sendBtn = new Button("Send");
//         sendBtn.setStyle("-fx-background-color: #10b981; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-padding: 8 20; -fx-cursor: hand;");
//         addHoverScale(sendBtn);

//         // Send Message Logic
//         Runnable sendMessage = () -> {
//             String text = inputField.getText().trim();
//             if (!text.isEmpty()) {
//                 // Add User Message
//                 addChatMessage(chatHistory, text, true);
//                 inputField.clear();
                
//                 // Simulate AI Response immediately
//                 addChatMessage(chatHistory, "Based on your recent data, prioritizing active recovery and mobility work will yield the best results tomorrow.", false);
                
//                 // Auto-scroll to bottom
//                 scrollPane.layout();
//                 scrollPane.setVvalue(1.0);
//             }
//         };

//         sendBtn.setOnAction(e -> sendMessage.run());
//         inputField.setOnAction(e -> sendMessage.run()); // Allows pressing Enter to send

//         inputArea.getChildren().addAll(inputField, sendBtn);
//         chatBox.getChildren().addAll(header, scrollPane, inputArea);
        
//         overlay.getChildren().add(chatBox);
//         overlay.setOpacity(0);
//         rootContainer.getChildren().add(overlay);
        
//         FadeTransition ft = new FadeTransition(Duration.millis(300), overlay);
//         ft.setToValue(1.0);
//         ft.play();
//     }

//     private void addChatMessage(VBox chatHistory, String message, boolean isUser) {
//         HBox row = new HBox();
//         Label msgLabel = new Label(message);
//         msgLabel.setWrapText(true);
//         msgLabel.setMaxWidth(260); // Constrain bubble width
//         msgLabel.setPadding(new Insets(10, 15, 10, 15));
        
//         if (isUser) {
//             row.setAlignment(Pos.CENTER_RIGHT);
//             msgLabel.setStyle("-fx-background-color: #10b981; -fx-text-fill: white; -fx-background-radius: 15 15 0 15; -fx-font-size: 13px;");
//         } else {
//             row.setAlignment(Pos.CENTER_LEFT);
//             msgLabel.setStyle("-fx-background-color: #f1f5f9; -fx-text-fill: #0f172a; -fx-background-radius: 15 15 15 0; -fx-font-size: 13px;");
//         }
        
//         row.getChildren().add(msgLabel);
//         chatHistory.getChildren().add(row);
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
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Fitness_StartWorkoutButton {

    private StackPane rootContainer;
    private Runnable onBack;

    // --- Dynamic Labels for Health Metrics ---
    private Label weightLabel = new Label("78.5");
    private Label bmiLabel = new Label("23.4");
    private Label bpLabel = new Label("118/76");
    private Label spo2Label = new Label("99");

    public Fitness_StartWorkoutButton(Runnable onBack) {
        this.onBack = onBack;
    }

    public Node getView() {
        if (rootContainer == null) {
            rootContainer = new StackPane();
            rootContainer.setStyle("-fx-background-color: #f8fafc;");

            VBox mainLayout = new VBox(25);
            mainLayout.setPadding(new Insets(20, 40, 40, 40));

            // --- UI Sections ---
            Node backButtonRow = buildBackButton();
            
            // Row 1: Workout Log & Health Metrics
            HBox row1 = new HBox(25);
            Node workoutLog = buildWorkoutLog();
            HBox.setHgrow(workoutLog, Priority.ALWAYS);
            Node healthMetrics = buildHealthMetrics();
            row1.getChildren().addAll(workoutLog, healthMetrics);

            // Row 2: Sleep Cycles & Fatigue
            HBox row2 = new HBox(25);
            Node sleepCycles = buildSleepCycles();
            HBox.setHgrow(sleepCycles, Priority.ALWAYS);
            Node fatigueSoreness = buildFatigueSoreness();
            row2.getChildren().addAll(sleepCycles, fatigueSoreness);

            // Row 3: Daily Goals & Timeline (Daily Coach removed)
            HBox row3 = new HBox(25);
            
            VBox dailyGoals = buildDailyGoals();
            HBox.setHgrow(dailyGoals, Priority.ALWAYS);
            
            VBox timeline = buildActivityTimeline();
            HBox.setHgrow(timeline, Priority.ALWAYS);
            
            row3.getChildren().addAll(dailyGoals, timeline);

            mainLayout.getChildren().addAll(backButtonRow, row1, row2, row3);

            // --- Entrance Animations ---
            animateNodeEntrance(backButtonRow, 0);
            animateNodeEntrance(row1, 100);
            animateNodeEntrance(row2, 200);
            animateNodeEntrance(row3, 300);

            ScrollPane scrollPane = new ScrollPane(mainLayout);
            scrollPane.setFitToWidth(true);
            scrollPane.setStyle("-fx-background-color: transparent; -fx-background: #f8fafc;");
            scrollPane.getStylesheets().add("data:text/css,.scroll-pane > .viewport { -fx-background-color: transparent; }");

            rootContainer.getChildren().add(scrollPane);
        }
        return rootContainer;
    }

    // --- ANIMATIONS ---
    private void animateNodeEntrance(Node node, int delayMillis) {
        node.setOpacity(0);
        node.setTranslateY(25);
        FadeTransition ft = new FadeTransition(Duration.millis(500), node);
        ft.setToValue(1.0);
        TranslateTransition tt = new TranslateTransition(Duration.millis(500), node);
        tt.setToY(0);
        ParallelTransition pt = new ParallelTransition(ft, tt);
        pt.setDelay(Duration.millis(delayMillis));
        pt.play();
    }

    private void addHoverScale(Node node) {
        ScaleTransition scaleIn = new ScaleTransition(Duration.millis(150), node);
        scaleIn.setToX(1.02); scaleIn.setToY(1.02);
        ScaleTransition scaleOut = new ScaleTransition(Duration.millis(150), node);
        scaleOut.setToX(1.0); scaleOut.setToY(1.0);
        node.setOnMouseEntered(e -> scaleIn.playFromStart());
        node.setOnMouseExited(e -> scaleOut.playFromStart());
    }

    // --- BACK BUTTON ---
    private HBox buildBackButton() {
        HBox row = new HBox();
        row.setAlignment(Pos.CENTER_LEFT);
        Button backBtn = new Button("← Back to Elite Performance Hub");
        backBtn.setStyle("-fx-background-color: white; -fx-text-fill: #475569; -fx-font-weight: bold; -fx-font-size: 13px; -fx-padding: 8 15; -fx-background-radius: 20; -fx-border-color: #e2e8f0; -fx-border-radius: 20; -fx-cursor: hand;");
        addHoverScale(backBtn);
        backBtn.setOnAction(e -> { if (onBack != null) onBack.run(); });
        row.getChildren().add(backBtn);
        return row;
    }

    // --- ROW 1 COMPONENTS ---
    private VBox buildWorkoutLog() {
        VBox box = new VBox(20);
        box.setPadding(new Insets(25));
        box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
        addHoverScale(box);

        HBox header = new HBox();
        Label title = new Label("Workout Log");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #0f172a;");
        Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);
        
        Label toggle = new Label("Today   History");
        toggle.setStyle("-fx-background-color: #f1f5f9; -fx-padding: 6 14; -fx-background-radius: 15; -fx-font-size: 11px; -fx-font-weight: bold; -fx-text-fill: #64748b; -fx-cursor: hand;");
        header.getChildren().addAll(title, sp, toggle);

        VBox list = new VBox(15);
        list.getChildren().addAll(
            createWorkoutItem("🏏", "#d1fae5", "#10b981", "Batting Practice - Technical", "Duration: 45m • Intensity: Medium", "142", "380"),
            createWorkoutItem("🏃", "#fee2e2", "#ef4444", "Sprint Training - Max Effort", "Duration: 20m • Intensity: High", "168", "410")
        );
        box.getChildren().addAll(header, list);
        return box;
    }

    private HBox createWorkoutItem(String icon, String bgHex, String iconHex, String title, String sub, String hr, String kcal) {
        HBox row = new HBox(15);
        row.setAlignment(Pos.CENTER_LEFT);
        row.setPadding(new Insets(15, 20, 15, 20));
        row.setStyle("-fx-background-color: white; -fx-border-color: #f1f5f9; -fx-border-width: 2; -fx-border-radius: 12; -fx-background-radius: 12;");

        StackPane iconPane = new StackPane();
        Circle c = new Circle(20, Color.web(bgHex));
        Label i = new Label(icon); i.setStyle("-fx-text-fill: " + iconHex + "; -fx-font-size: 16px;");
        iconPane.getChildren().addAll(c, i);

        VBox texts = new VBox(3);
        Label t = new Label(title); t.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: #0f172a;");
        Label s = new Label(sub); s.setStyle("-fx-font-size: 11px; -fx-text-fill: #64748b;");
        texts.getChildren().addAll(t, s);

        Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);

        VBox hrBox = new VBox(); hrBox.setAlignment(Pos.CENTER);
        Label hrV = new Label(hr); hrV.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: #0f172a;");
        Label hrL = new Label("Avg HR"); hrL.setStyle("-fx-font-size: 10px; -fx-text-fill: #94a3b8; -fx-font-weight: bold;");
        hrBox.getChildren().addAll(hrV, hrL);

        VBox kcalBox = new VBox(); kcalBox.setAlignment(Pos.CENTER);
        Label kcV = new Label(kcal); kcV.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: #0f172a;");
        Label kcL = new Label("kcal"); kcL.setStyle("-fx-font-size: 10px; -fx-text-fill: #94a3b8; -fx-font-weight: bold;");
        kcalBox.getChildren().addAll(kcV, kcL);

        Label arrow = new Label(">"); arrow.setStyle("-fx-text-fill: #cbd5e1; -fx-font-size: 18px; -fx-font-weight: bold; -fx-padding: 0 0 0 10;");

        row.getChildren().addAll(iconPane, texts, sp, hrBox, kcalBox, arrow);
        return row;
    }

    private VBox buildHealthMetrics() {
        VBox box = new VBox(20);
        box.setPrefWidth(320); box.setMinWidth(320);
        box.setPadding(new Insets(25));
        box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
        addHoverScale(box);

        Label title = new Label("Health Metrics");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #0f172a;");

        GridPane grid = new GridPane();
        grid.setHgap(15); grid.setVgap(15);
        ColumnConstraints cc = new ColumnConstraints(); cc.setPercentWidth(50);
        grid.getColumnConstraints().addAll(cc, cc);

        // Uses the dynamic global labels defined at the top of the class
        grid.add(createDynamicMetricSquare("WEIGHT", weightLabel, "kg", "-0.2 from\nyesterday", "#10b981"), 0, 0);
        grid.add(createDynamicMetricSquare("BMI", bmiLabel, "", "Optimal\nRange", "#64748b"), 1, 0);
        grid.add(createDynamicMetricSquare("BLOOD\nPRESSURE", bpLabel, "", "Perfect", "#10b981"), 0, 1);
        grid.add(createDynamicMetricSquare("SPO2", spo2Label, "%", "Healthy", "#64748b"), 1, 1);

        Button manualBtn = new Button("+ Manual Metric Entry");
        manualBtn.setMaxWidth(Double.MAX_VALUE);
        manualBtn.setStyle("-fx-background-color: transparent; -fx-border-color: #cbd5e1; -fx-border-style: dashed; -fx-border-radius: 8; -fx-text-fill: #64748b; -fx-font-weight: bold; -fx-padding: 10; -fx-cursor: hand;");
        
        manualBtn.setOnAction(e -> openManualMetricEntryDialog());

        box.getChildren().addAll(title, grid, manualBtn);
        return box;
    }

    private VBox createDynamicMetricSquare(String title, Label valLabel, String unit, String sub, String subColor) {
        VBox box = new VBox(5);
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(15));
        box.setStyle("-fx-background-color: #f8fafc; -fx-background-radius: 12;");
        
        Label t = new Label(title); 
        t.setStyle("-fx-font-size: 10px; -fx-font-weight: bold; -fx-text-fill: #64748b; -fx-text-alignment: center; -fx-letter-spacing: 1px;");
        
        HBox valBox = new HBox(2); 
        valBox.setAlignment(Pos.BOTTOM_CENTER);
        valLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
        Label u = new Label(unit); 
        u.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #0f172a; -fx-translate-y: -4px;");
        valBox.getChildren().addAll(valLabel, u);

        Label s = new Label(sub); 
        s.setStyle("-fx-font-size: 9px; -fx-text-fill: " + subColor + "; -fx-text-alignment: center; -fx-font-weight: bold;");
        box.getChildren().addAll(t, valBox, s);
        return box;
    }

    // --- MANUAL ENTRY DIALOG OVERLAY ---
    private void openManualMetricEntryDialog() {
        StackPane overlay = new StackPane();
        overlay.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4);");
        overlay.setAlignment(Pos.CENTER);

        VBox dialogBox = new VBox(20);
        dialogBox.setPadding(new Insets(30));
        dialogBox.setMaxWidth(350);
        dialogBox.setMaxHeight(Region.USE_PREF_SIZE);
        dialogBox.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.25), 20, 0, 0, 8);");

        Label title = new Label("Update Health Metrics");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");

        TextField wField = createStyledTextField(weightLabel.getText(), "Weight (kg)");
        TextField bmiField = createStyledTextField(bmiLabel.getText(), "BMI");
        TextField bpField = createStyledTextField(bpLabel.getText(), "Blood Pressure");
        TextField spo2Field = createStyledTextField(spo2Label.getText(), "SPO2 (%)");

        HBox buttonRow = new HBox(15);
        buttonRow.setAlignment(Pos.CENTER_RIGHT);

        Button cancelBtn = new Button("Cancel");
        cancelBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: #64748b; -fx-font-weight: bold; -fx-padding: 8 15; -fx-cursor: hand;");
        
        Button saveBtn = new Button("Save Metrics");
        saveBtn.setStyle("-fx-background-color: #10b981; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 8 20; -fx-background-radius: 8; -fx-cursor: hand;");
        
        addHoverScale(cancelBtn); addHoverScale(saveBtn);
        
        saveBtn.setOnAction(e -> {
            weightLabel.setText(wField.getText());
            bmiLabel.setText(bmiField.getText());
            bpLabel.setText(bpField.getText());
            spo2Label.setText(spo2Field.getText());
            closeOverlay(overlay);
        });

        cancelBtn.setOnAction(e -> closeOverlay(overlay));
        buttonRow.getChildren().addAll(cancelBtn, saveBtn);

        dialogBox.getChildren().addAll(
            title, 
            createInputRow("Weight (kg):", wField), 
            createInputRow("BMI:", bmiField), 
            createInputRow("Blood Pressure:", bpField), 
            createInputRow("SPO2 (%):", spo2Field), 
            buttonRow
        );

        overlay.getChildren().add(dialogBox);
        overlay.setOpacity(0);
        rootContainer.getChildren().add(overlay);
        FadeTransition ft = new FadeTransition(Duration.millis(250), overlay);
        ft.setToValue(1.0);
        ft.play();
    }

    private void closeOverlay(StackPane overlay) {
        FadeTransition ft = new FadeTransition(Duration.millis(200), overlay);
        ft.setToValue(0);
        ft.setOnFinished(evt -> rootContainer.getChildren().remove(overlay));
        ft.play();
    }

    private TextField createStyledTextField(String text, String prompt) {
        TextField tf = new TextField(text);
        tf.setPromptText(prompt);
        tf.setStyle("-fx-background-color: #f8fafc; -fx-border-color: #cbd5e1; -fx-border-radius: 8; -fx-background-radius: 8; -fx-padding: 10; -fx-font-size: 14px;");
        return tf;
    }

    private VBox createInputRow(String label, TextField field) {
        VBox box = new VBox(5);
        Label l = new Label(label);
        l.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #475569;");
        box.getChildren().addAll(l, field);
        return box;
    }

    // --- ROW 2 COMPONENTS ---
    private VBox buildSleepCycles() {
        VBox box = new VBox(15);
        box.setPadding(new Insets(25));
        box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
        addHoverScale(box);

        HBox header = new HBox();
        VBox titles = new VBox(2);
        Label title = new Label("Sleep Cycles"); title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #0f172a;");
        Label sub = new Label("Efficiency: 94% • 11:20 PM - 07:15 AM"); sub.setStyle("-fx-font-size: 12px; -fx-text-fill: #64748b;");
        titles.getChildren().addAll(title, sub);
        Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);
        Label moon = new Label("🌙"); moon.setStyle("-fx-text-fill: #0f172a; -fx-font-size: 20px;");
        header.getChildren().addAll(titles, sp, moon);

        HBox chart = new HBox(12);
        chart.setAlignment(Pos.BOTTOM_CENTER);
        chart.setMinHeight(180);
        chart.setPadding(new Insets(15, 0, 0, 0));
        
        String deep = "#0f172a", rem = "#6ee7b7", light = "#93c5fd", wake = "#fca5a5";
        double[] heights = {100, 140, 110, 80, 130, 40, 90, 120};
        String[] colors = {rem, deep, rem, light, deep, rem, wake, light};

        for (int i = 0; i < heights.length; i++) {
            Rectangle bar = new Rectangle(40, heights[i]);
            bar.setFill(Color.web(colors[i]));
            chart.getChildren().add(bar);
        }

        HBox legend = new HBox(25);
        legend.setAlignment(Pos.CENTER);
        legend.setPadding(new Insets(10, 0, 0, 0));
        legend.getChildren().addAll(
            createLegendDot("Deep (1h 45m)", deep),
            createLegendDot("REM (2h 10m)", rem),
            createLegendDot("Light (3h 30m)", light)
        );

        box.getChildren().addAll(header, chart, legend);
        return box;
    }

    private HBox createLegendDot(String txt, String hex) {
        HBox box = new HBox(8); box.setAlignment(Pos.CENTER);
        Circle c = new Circle(5, Color.web(hex));
        Label l = new Label(txt); l.setStyle("-fx-font-size: 11px; -fx-font-weight: bold; -fx-text-fill: #475569;");
        box.getChildren().addAll(c, l);
        return box;
    }

    private VBox buildFatigueSoreness() {
        VBox box = new VBox(20);
        box.setPrefWidth(320); box.setMinWidth(320);
        box.setPadding(new Insets(25));
        box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
        addHoverScale(box);

        Label title = new Label("Fatigue & Soreness");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #0f172a;");

        HBox split = new HBox(20);
        VBox leftBars = new VBox(20); HBox.setHgrow(leftBars, Priority.ALWAYS);
        
        leftBars.getChildren().addAll(
            createFatigueBar("Mental Fatigue", "Low", "#10b981", 0.25),
            createFatigueBar("Muscle Soreness", "Moderate", "#eab308", 0.6)
        );

        VBox alert = new VBox(8);
        alert.setPadding(new Insets(15));
        alert.setStyle("-fx-border-color: #fecaca; -fx-border-width: 1.5; -fx-border-radius: 8; -fx-background-color: #fef2f2; -fx-background-radius: 8;");
        Label aTitle = new Label("ALERT"); aTitle.setStyle("-fx-text-fill: #ef4444; -fx-font-weight: bold; -fx-font-size: 10px; -fx-letter-spacing: 1px;");
        Label aDesc = new Label("Right Hamstring tension noted. Recommended stretching: Dynamic Leg Swings.");
        aDesc.setWrapText(true); aDesc.setStyle("-fx-font-size: 12px; -fx-text-fill: #475569; -fx-line-spacing: 4px;");
        alert.getChildren().addAll(aTitle, aDesc);
        leftBars.getChildren().add(alert);

        VBox rightBody = new VBox(10);
        rightBody.setAlignment(Pos.CENTER);
        rightBody.setPrefWidth(90);
        rightBody.setStyle("-fx-background-color: #f1f5f9; -fx-background-radius: 12;");
        Label silhouette = new Label("🧍"); silhouette.setStyle("-fx-font-size: 45px; -fx-text-fill: #94a3b8;");
        Label bStatus = new Label("BODY STATUS"); bStatus.setStyle("-fx-font-size: 9px; -fx-font-weight: bold; -fx-text-fill: #64748b; -fx-letter-spacing: 1px;");
        HBox dots = new HBox(4); dots.setAlignment(Pos.CENTER);
        dots.getChildren().addAll(new Circle(3, Color.web("#10b981")), new Circle(3, Color.web("#eab308")), new Circle(3, Color.web("#10b981")));
        rightBody.getChildren().addAll(silhouette, bStatus, dots);

        split.getChildren().addAll(leftBars, rightBody);
        box.getChildren().addAll(title, split);
        return box;
    }

    private VBox createFatigueBar(String title, String val, String color, double pct) {
        VBox box = new VBox(5);
        HBox texts = new HBox();
        Label t = new Label(title); t.setStyle("-fx-font-weight: bold; -fx-font-size: 12px; -fx-text-fill: #0f172a;");
        Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);
        Label v = new Label(val); v.setStyle("-fx-font-weight: bold; -fx-font-size: 12px; -fx-text-fill: " + color + ";");
        texts.getChildren().addAll(t, sp, v);

        StackPane barPane = new StackPane(); barPane.setAlignment(Pos.CENTER_LEFT);
        Rectangle bg = new Rectangle(140, 8, Color.web("#f1f5f9")); bg.setArcWidth(8); bg.setArcHeight(8);
        Rectangle prog = new Rectangle(140 * pct, 8, Color.web(color)); prog.setArcWidth(8); prog.setArcHeight(8);
        barPane.getChildren().addAll(bg, prog);

        box.getChildren().addAll(texts, barPane);
        return box;
    }

    // --- ROW 3 COMPONENTS ---
    private VBox buildDailyGoals() {
        VBox box = new VBox(20);
        box.setPadding(new Insets(25));
        box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
        addHoverScale(box);

        Label title = new Label("Daily Goals");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #0f172a;");

        VBox list = new VBox(15);
        list.getChildren().addAll(
            createInteractiveCheck("Complete 3.5L Water", true),
            createInteractiveCheck("High Intensity Drills", true),
            createInteractiveCheck("8h Restoration Sleep", false),
            createInteractiveCheck("Log Evening Macros", false)
        );

        box.getChildren().addAll(title, list);
        return box;
    }

    private HBox createInteractiveCheck(String text, boolean isChecked) {
        HBox row = new HBox(12);
        row.setAlignment(Pos.CENTER_LEFT);
        row.setStyle("-fx-cursor: hand;");
        boolean[] state = { isChecked };
        
        Label box = new Label(state[0] ? "☑" : "☐");
        box.setStyle("-fx-text-fill: " + (state[0] ? "#10b981" : "#cbd5e1") + "; -fx-font-size: 22px;");
        
        Label txt = new Label(text);
        txt.setStyle("-fx-font-size: 14px; -fx-text-fill: #475569;");
        
        row.setOnMouseClicked(e -> {
            state[0] = !state[0];
            box.setText(state[0] ? "☑" : "☐");
            box.setStyle("-fx-text-fill: " + (state[0] ? "#10b981" : "#cbd5e1") + "; -fx-font-size: 22px;");
        });
        row.getChildren().addAll(box, txt);
        return row;
    }

    private VBox buildActivityTimeline() {
        VBox box = new VBox(20);
        box.setPadding(new Insets(25));
        box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
        addHoverScale(box);

        Label title = new Label("Activity Timeline");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #0f172a;");

        VBox list = new VBox(0);
        list.getChildren().addAll(
            createTimelineItem("07:15 AM", "Sleep Synced from WHOOP", "Score: 84 (Great Recovery)", true, true),
            createTimelineItem("10:30 AM", "Morning Technical Practice", "45m Batting Drills completed", true, true),
            createTimelineItem("05:00 PM (Planned)", "Recovery Protocol", "Stretching and Foam Rolling", false, false)
        );

        box.getChildren().addAll(title, list);
        return box;
    }

    private HBox createTimelineItem(String time, String title, String sub, boolean isDone, boolean hasLine) {
        HBox row = new HBox(15);
        row.setAlignment(Pos.TOP_LEFT);

        VBox graphic = new VBox(2);
        graphic.setAlignment(Pos.TOP_CENTER);
        
        Circle dot = new Circle(7, Color.WHITE);
        dot.setStroke(isDone ? Color.web("#10b981") : Color.web("#e2e8f0"));
        dot.setStrokeWidth(3);
        graphic.getChildren().add(dot);
        
        if (hasLine) {
            Line line = new Line(0, 0, 0, 40);
            line.setStroke(Color.web("#f1f5f9"));
            line.setStrokeWidth(2);
            graphic.getChildren().add(line);
        }

        VBox texts = new VBox(4);
        texts.setPadding(new Insets(0, 0, 15, 0));
        Label tm = new Label(time); tm.setStyle("-fx-font-size: 11px; -fx-font-weight: bold; -fx-text-fill: #64748b;");
        Label t = new Label(title); t.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: " + (isDone ? "#0f172a" : "#94a3b8") + ";");
        Label s = new Label(sub); s.setStyle("-fx-font-size: 12px; -fx-text-fill: #94a3b8;");
        texts.getChildren().addAll(tm, t, s);

        row.getChildren().addAll(graphic, texts);
        return row;
    }
}