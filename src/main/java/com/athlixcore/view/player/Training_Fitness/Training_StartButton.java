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

// // public class Training_StartButton {

// //     private StackPane rootContainer;
// //     private Runnable onBack;

// //     // Constructor accepts a callback to go back to the previous screen
// //     public Training_StartButton(Runnable onBack) {
// //         this.onBack = onBack;
// //     }

// //     public Node getView() {
// //         if (rootContainer == null) {
// //             rootContainer = new StackPane();
// //             rootContainer.setStyle("-fx-background-color: #f8fafc;");

// //             VBox mainLayout = new VBox(25);
// //             mainLayout.setPadding(new Insets(20, 40, 40, 40));

// //             // Build UI Sections
// //             Node backButtonRow = buildBackButton();
// //             Node headerArea = buildHeaderSection();
// //             Node topMetrics = buildTopMetricsRow();
// //             Node splitArea = buildMainSplitArea();

// //             mainLayout.getChildren().addAll(backButtonRow, headerArea, topMetrics, splitArea);

// //             // Cascading Entrance Animations
// //             animateNodeEntrance(backButtonRow, 0);
// //             animateNodeEntrance(headerArea, 100);
// //             animateNodeEntrance(topMetrics, 200);
// //             animateNodeEntrance(splitArea, 300);

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
// //         scaleIn.setToX(1.03); 
// //         scaleIn.setToY(1.03);
        
// //         ScaleTransition scaleOut = new ScaleTransition(Duration.millis(150), node);
// //         scaleOut.setToX(1.0); 
// //         scaleOut.setToY(1.0);

// //         node.setOnMouseEntered(e -> scaleIn.playFromStart());
// //         node.setOnMouseExited(e -> scaleOut.playFromStart());
// //     }

// //     // --- BACK BUTTON ---
// //     private HBox buildBackButton() {
// //         HBox row = new HBox();
// //         row.setAlignment(Pos.CENTER_LEFT);
        
// //         Button backBtn = new Button("← Back to Dashboard");
// //         backBtn.setStyle("-fx-background-color: white; -fx-text-fill: #475569; -fx-font-weight: bold; -fx-font-size: 13px; -fx-padding: 8 15; -fx-background-radius: 20; -fx-border-color: #e2e8f0; -fx-border-radius: 20; -fx-cursor: hand;");
// //         addHoverScale(backBtn);
        
// //         // Trigger the callback to go back when clicked
// //         backBtn.setOnAction(e -> {
// //             if (onBack != null) onBack.run();
// //         });

// //         row.getChildren().add(backBtn);
// //         return row;
// //     }

// //     // --- HEADER SECTION ---
// //     private HBox buildHeaderSection() {
// //         HBox header = new HBox();
// //         header.setAlignment(Pos.CENTER_LEFT);
// //         header.setPadding(new Insets(10, 0, 0, 0));

// //         // Left Info
// //         VBox leftInfo = new VBox(8);
        
// //         Label dateLbl = new Label("📅 Friday, Oct 25, 2024");
// //         dateLbl.setStyle("-fx-font-size: 12px; -fx-text-fill: #10b981; -fx-font-weight: bold;");
        
// //         Label titleLbl = new Label("Front Foot Dominance & Power Hitting");
// //         titleLbl.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
        
// //         HBox subInfo = new HBox(15);
// //         Label coachLbl = new Label("👤 Coach Sandeep Patil");
// //         coachLbl.setStyle("-fx-text-fill: #64748b; -fx-font-size: 13px;");
// //         Label locLbl = new Label("🏟 Mumbai Elite Cricket");
// //         locLbl.setStyle("-fx-text-fill: #64748b; -fx-font-size: 13px;");
// //         subInfo.getChildren().addAll(coachLbl, locLbl);

// //         Label weatherLbl = new Label("☀️ Sunny, 28°C");
// //         weatherLbl.setStyle("-fx-text-fill: #94a3b8; -fx-font-size: 12px;");

// //         // Header Buttons
// //         HBox btns = new HBox(12);
// //         btns.setPadding(new Insets(10, 0, 0, 0));
        
// //         Button startBtn = new Button("Start\nTraining");
// //         startBtn.setStyle("-fx-background-color: #10b981; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 8 25; -fx-text-alignment: center; -fx-cursor: hand;");
// //         addHoverScale(startBtn);

// //         Button compBtn = new Button("Complete\nSession");
// //         compBtn.setStyle("-fx-background-color: #f1f5f9; -fx-text-fill: #475569; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 8 20; -fx-text-alignment: center; -fx-cursor: hand;");
// //         addHoverScale(compBtn);

// //         Button aiBtn = new Button("🤖 AI\nAnalysis");
// //         aiBtn.setStyle("-fx-background-color: white; -fx-text-fill: #10b981; -fx-border-color: #10b981; -fx-border-radius: 8; -fx-background-radius: 8; -fx-font-weight: bold; -fx-padding: 7 20; -fx-text-alignment: center; -fx-cursor: hand;");
// //         addHoverScale(aiBtn);

// //         btns.getChildren().addAll(startBtn, compBtn, aiBtn);
// //         leftInfo.getChildren().addAll(dateLbl, titleLbl, subInfo, weatherLbl, btns);

// //         Region spacer = new Region();
// //         HBox.setHgrow(spacer, Priority.ALWAYS);

// //         // Right Stats
// //         HBox rightStats = new HBox(30);
// //         rightStats.setAlignment(Pos.CENTER_RIGHT);
// //         rightStats.getChildren().addAll(
// //             createHeaderStat("READINESS", "Optimal", "#10b981"),
// //             createHeaderStat("TODAY'S\nSCORE", "85/100", "#0f172a"),
// //             createHeaderStat("RECOVERY", "92%", "#0f172a")
// //         );

// //         header.getChildren().addAll(leftInfo, spacer, rightStats);
// //         return header;
// //     }

// //     private VBox createHeaderStat(String title, String val, String color) {
// //         VBox box = new VBox(3);
// //         box.setAlignment(Pos.CENTER_RIGHT);
// //         Label t = new Label(title);
// //         t.setStyle("-fx-font-size: 10px; -fx-font-weight: bold; -fx-text-fill: #64748b; -fx-letter-spacing: 1px; -fx-text-alignment: right;");
// //         Label v = new Label(val);
// //         v.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: " + color + ";");
// //         box.getChildren().addAll(t, v);
// //         return box;
// //     }

// //     // --- TOP METRICS ROW ---
// //     private HBox buildTopMetricsRow() {
// //         HBox row = new HBox(20);
        
// //         row.getChildren().addAll(
// //             createMetricCard("2/5", "Completed\nSessions", "3 remaining", true),
// //             createMetricCard("2.5h", "Practice Hours", "⏱", false),
// //             createMetricCard("+4.2", "Skill Score", "📈", true) // Using true just to color the text green for mockup
// //         );
// //         for(Node n : row.getChildren()) {
// //             HBox.setHgrow(n, Priority.ALWAYS);
// //         }
// //         return row;
// //     }

// //     private VBox createMetricCard(String mainVal, String title, String sub, boolean isGreen) {
// //         VBox card = new VBox(10);
// //         card.setAlignment(Pos.CENTER);
// //         card.setPadding(new Insets(20));
// //         card.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
// //         addHoverScale(card);

// //         // Circular element placeholder
// //         StackPane circle = new StackPane();
// //         Circle c = new Circle(25, Color.TRANSPARENT);
// //         c.setStroke(isGreen ? Color.web("#10b981") : Color.web("#e2e8f0"));
// //         c.setStrokeWidth(4);
// //         Label m = new Label(mainVal);
// //         m.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
// //         circle.getChildren().addAll(c, m);

// //         Label t = new Label(title);
// //         t.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-text-fill: #0f172a; -fx-text-alignment: center;");
// //         Label s = new Label(sub);
// //         s.setStyle("-fx-font-size: 11px; -fx-text-fill: #94a3b8;");

// //         card.getChildren().addAll(circle, t, s);
// //         return card;
// //     }

// //     // --- MAIN SPLIT AREA ---
// //     private HBox buildMainSplitArea() {
// //         HBox split = new HBox(30);

// //         // Left Column (Schedule, Skills, Check-in)
// //         VBox leftCol = new VBox(25);
// //         HBox.setHgrow(leftCol, Priority.ALWAYS);
// //         leftCol.getChildren().addAll(
// //             buildScheduleSection(),
// //             buildSkillTrainingSection(),
// //             buildBottomRow()
// //         );

// //         // Right Column (AI, Gear, Video, Coach)
// //         VBox rightCol = new VBox(20);
// //         rightCol.setPrefWidth(320);
// //         rightCol.setMinWidth(320);
// //         rightCol.getChildren().addAll(
// //             buildAIInsightCard(),
// //             buildGearChecklist(),
// //             buildUploadVideoCard(),
// //             buildCoachDeskCard()
// //         );

// //         split.getChildren().addAll(leftCol, rightCol);
// //         return split;
// //     }

// //     // --- LEFT COLUMN COMPONENTS ---
// //     private VBox buildScheduleSection() {
// //         VBox box = new VBox(15);
        
// //         HBox header = new HBox();
// //         Label title = new Label("Today's Schedule");
// //         title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
// //         Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);
// //         Label badge = new Label("12 Day Streak");
// //         badge.setStyle("-fx-background-color: #d1fae5; -fx-text-fill: #10b981; -fx-font-weight: bold; -fx-font-size: 11px; -fx-padding: 4 10; -fx-background-radius: 12;");
// //         header.getChildren().addAll(title, sp, badge);

// //         VBox list = new VBox(10);
// //         list.getChildren().addAll(
// //             createScheduleRow("08:00\nAM", "Morning Batting Nets", "Technical: Vertical Bat Drills • 90 mins", "Medium", ""),
// //             createScheduleRow("11:30\nAM", "Mid-day Agility Drills", "Fitness: SAQ Drills & Reactivity • 60 mins", "Hard", "Start"),
// //             createScheduleRow("05:00\nPM", "Evening Tactical Analysis", "Review: Opponent Weakness Mapping • 45 mins", "Easy", "🔒")
// //         );

// //         box.getChildren().addAll(header, list);
// //         return box;
// //     }

// //     private HBox createScheduleRow(String time, String title, String sub, String tag, String action) {
// //         HBox row = new HBox(15);
// //         row.setAlignment(Pos.CENTER_LEFT);
// //         row.setPadding(new Insets(15));
// //         row.setStyle("-fx-background-color: white; -fx-background-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.02), 8, 0, 0, 2);");
// //         addHoverScale(row);

// //         Label timeLbl = new Label(time);
// //         timeLbl.setStyle("-fx-font-weight: bold; -fx-font-size: 13px; -fx-text-fill: #475569; -fx-text-alignment: center;");

// //         VBox texts = new VBox(3);
// //         Label t = new Label("• " + title);
// //         t.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: #0f172a;");
// //         Label s = new Label(sub);
// //         s.setStyle("-fx-font-size: 12px; -fx-text-fill: #64748b;");
// //         texts.getChildren().addAll(t, s);

// //         Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);

// //         Label tagLbl = new Label(tag);
// //         tagLbl.setStyle("-fx-background-color: #f1f5f9; -fx-text-fill: #64748b; -fx-font-weight: bold; -fx-font-size: 11px; -fx-padding: 4 10; -fx-background-radius: 6;");

// //         row.getChildren().addAll(timeLbl, texts, sp, tagLbl);

// //         if (!action.isEmpty()) {
// //             if (action.equals("Start")) {
// //                 Button btn = new Button(action);
// //                 btn.setStyle("-fx-background-color: #10b981; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 11px; -fx-background-radius: 6; -fx-cursor: hand;");
// //                 row.getChildren().add(btn);
// //             } else {
// //                 Label lck = new Label(action);
// //                 lck.setStyle("-fx-text-fill: #94a3b8; -fx-font-size: 14px;");
// //                 row.getChildren().add(lck);
// //             }
// //         }

// //         return row;
// //     }

// //     private VBox buildSkillTrainingSection() {
// //         VBox box = new VBox(15);
        
// //         HBox header = new HBox(20);
// //         header.setAlignment(Pos.CENTER_LEFT);
// //         Label title = new Label("Skill Specific Training");
// //         title.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
        
// //         HBox tabs = new HBox(10);
// //         tabs.getChildren().addAll(
// //             createMiniTab("Batting", true), createMiniTab("Bowling", false), 
// //             createMiniTab("Fielding", false), createMiniTab("Keeper", false)
// //         );
// //         header.getChildren().addAll(title, tabs);

// //         HBox cards = new HBox(15);
// //         cards.getChildren().addAll(
// //             createVideoCard("Cover Drive Fundamentals", "4 Sets x 15 Reps", "⭐ Coach Choice"),
// //             createVideoCard("Straight Drive Control", "3 Sets x 20 Reps", "⏱ Last: 8.5/10")
// //         );
// //         for(Node n : cards.getChildren()) HBox.setHgrow(n, Priority.ALWAYS);

// //         box.getChildren().addAll(header, cards);
// //         return box;
// //     }

// //     private Label createMiniTab(String text, boolean isActive) {
// //         Label l = new Label(text);
// //         if (isActive) l.setStyle("-fx-background-color: white; -fx-text-fill: #0f172a; -fx-font-weight: bold; -fx-font-size: 11px; -fx-padding: 4 12; -fx-background-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.05), 5, 0, 0, 2); -fx-cursor: hand;");
// //         else l.setStyle("-fx-text-fill: #64748b; -fx-font-weight: bold; -fx-font-size: 11px; -fx-padding: 4 12; -fx-cursor: hand;");
// //         return l;
// //     }

// //     private StackPane createVideoCard(String title, String sub, String tag) {
// //         StackPane card = new StackPane();
// //         card.setMinHeight(160);
// //         card.setStyle("-fx-background-color: #cbd5e1; -fx-background-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.05), 10, 0, 0, 4);");
// //         addHoverScale(card);

// //         Region overlay = new Region();
// //         overlay.setStyle("-fx-background-color: linear-gradient(to top, rgba(0,0,0,0.8), transparent); -fx-background-radius: 12;");

// //         VBox content = new VBox(5);
// //         content.setAlignment(Pos.BOTTOM_LEFT);
// //         content.setPadding(new Insets(15));
        
// //         Label t = new Label(title);
// //         t.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14px;");
// //         Label s = new Label(sub);
// //         s.setStyle("-fx-text-fill: #cbd5e1; -fx-font-size: 11px;");
// //         Label tg = new Label(tag);
// //         tg.setStyle("-fx-text-fill: #34d399; -fx-font-size: 11px; -fx-font-weight: bold;");
        
// //         content.getChildren().addAll(t, s, tg);
// //         card.getChildren().addAll(overlay, content);
// //         return card;
// //     }

// //     private HBox buildBottomRow() {
// //         HBox row = new HBox(20);

// //         // Check-in Box
// //         VBox checkin = new VBox(15);
// //         checkin.setAlignment(Pos.CENTER);
// //         checkin.setPadding(new Insets(20));
// //         checkin.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
        
// //         Label ciTitle = new Label("Check-in");
// //         ciTitle.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: #0f172a;");
        
// //         StackPane qrBox = new StackPane();
// //         qrBox.setPrefSize(100, 100);
// //         qrBox.setStyle("-fx-border-color: #10b981; -fx-border-style: dashed; -fx-border-radius: 8; -fx-background-color: #f0fdf4; -fx-background-radius: 8;");
// //         Label qrIcon = new Label("📱");
// //         qrIcon.setStyle("-fx-font-size: 30px; -fx-text-fill: #10b981;");
// //         qrBox.getChildren().add(qrIcon);

// //         Button scanBtn = new Button("Scan QR");
// //         scanBtn.setStyle("-fx-background-color: #f1f5f9; -fx-text-fill: #0f172a; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 8 20; -fx-cursor: hand;");
// //         addHoverScale(scanBtn);

// //         checkin.getChildren().addAll(ciTitle, qrBox, scanBtn);

// //         // Activity Feed
// //         VBox activity = new VBox(15);
// //         activity.setPadding(new Insets(20));
// //         activity.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
// //         HBox.setHgrow(activity, Priority.ALWAYS);

// //         Label actTitle = new Label("Training Activity Feed");
// //         actTitle.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: #0f172a;");

// //         VBox actList = new VBox(15);
// //         actList.getChildren().addAll(
// //             createActivityItem("✓", "Completed: Morning Batting Nets", "09:45 AM", "#10b981"),
// //             createActivityItem("🍴", "Nutritional Intake Logged", "08:15 AM", "#94a3b8"),
// //             createActivityItem("→", "Checked-in at Mumbai Elite Academy", "07:55 AM", "#0f172a")
// //         );
        
// //         activity.getChildren().addAll(actTitle, actList);
// //         row.getChildren().addAll(checkin, activity);
// //         return row;
// //     }

// //     private HBox createActivityItem(String icon, String title, String time, String colorHex) {
// //         HBox item = new HBox(15);
// //         item.setAlignment(Pos.TOP_LEFT);

// //         Circle iconBg = new Circle(14, Color.web(colorHex));
// //         Label iLbl = new Label(icon);
// //         iLbl.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 12px;");
// //         StackPane iconPane = new StackPane(iconBg, iLbl);

// //         VBox texts = new VBox(3);
// //         Label tLbl = new Label(title);
// //         tLbl.setStyle("-fx-font-weight: bold; -fx-font-size: 13px; -fx-text-fill: #0f172a;");
// //         Label timeLbl = new Label(time);
// //         timeLbl.setStyle("-fx-font-size: 11px; -fx-text-fill: #94a3b8;");
// //         texts.getChildren().addAll(tLbl, timeLbl);

// //         item.getChildren().addAll(iconPane, texts);
// //         return item;
// //     }

// //     // --- RIGHT COLUMN COMPONENTS ---
// //     private VBox buildAIInsightCard() {
// //         VBox card = new VBox(15);
// //         card.setPadding(new Insets(25));
// //         card.setStyle("-fx-background-color: #0f172a; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.15), 20, 0, 0, 8);");
// //         addHoverScale(card);

// //         Label header = new Label("✨ AI DAILY INSIGHT");
// //         header.setStyle("-fx-text-fill: #34d399; -fx-font-weight: bold; -fx-font-size: 10px; -fx-letter-spacing: 1px;");

// //         Label title = new Label("Focus on wrist stability");
// //         title.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 16px;");

// //         Label desc = new Label("Your last session showed a 12% dip in power during the last 20 balls. Prioritize wrist-strengthening warm-ups today.");
// //         desc.setWrapText(true);
// //         desc.setStyle("-fx-text-fill: #94a3b8; -fx-font-size: 12px; -fx-line-spacing: 4px;");

// //         VBox predBox = new VBox(5);
// //         predBox.setPadding(new Insets(15));
// //         predBox.setStyle("-fx-background-color: rgba(16,185,129,0.1); -fx-border-color: #10b981; -fx-border-radius: 8; -fx-background-radius: 8;");
// //         Label pTitle = new Label("NEXT SESSION PREDICTION");
// //         pTitle.setStyle("-fx-text-fill: #10b981; -fx-font-size: 9px; -fx-font-weight: bold; -fx-letter-spacing: 1px;");
// //         Label pVal = new Label("High-Intensity Yorkers & Slingshot Drills");
// //         pVal.setStyle("-fx-text-fill: white; -fx-font-size: 13px; -fx-font-weight: bold;");
// //         predBox.getChildren().addAll(pTitle, pVal);

// //         card.getChildren().addAll(header, title, desc, predBox);
// //         return card;
// //     }

// //     private VBox buildGearChecklist() {
// //         VBox box = new VBox(15);
// //         box.setPadding(new Insets(20));
// //         box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
        
// //         Label title = new Label("Gear Checklist");
// //         title.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: #0f172a;");

// //         VBox list = new VBox(12);
// //         list.getChildren().addAll(
// //             createCheckItem("Match Bat (Grade 1)", true),
// //             createCheckItem("Elite Padding & Gloves", true),
// //             createCheckItem("Helmet & Safety Gear", false),
// //             createCheckItem("Hydration & Recovery", false)
// //         );

// //         box.getChildren().addAll(title, list);
// //         return box;
// //     }

// //     private HBox createCheckItem(String text, boolean isChecked) {
// //         HBox row = new HBox(10);
// //         row.setAlignment(Pos.CENTER_LEFT);
// //         Label box = new Label(isChecked ? "☑" : "☐");
// //         box.setStyle("-fx-text-fill: " + (isChecked ? "#10b981" : "#94a3b8") + "; -fx-font-size: 18px;");
// //         Label txt = new Label(text);
// //         txt.setStyle("-fx-font-size: 13px; -fx-text-fill: #475569;");
// //         row.getChildren().addAll(box, txt);
// //         return row;
// //     }

// //     private VBox buildUploadVideoCard() {
// //         VBox box = new VBox(10);
// //         box.setAlignment(Pos.CENTER);
// //         box.setPadding(new Insets(20));
// //         box.setStyle("-fx-background-color: #f8fafc; -fx-border-color: #cbd5e1; -fx-border-style: dashed; -fx-border-width: 2; -fx-background-radius: 16; -fx-border-radius: 16; -fx-cursor: hand;");
// //         addHoverScale(box);

// //         Label icon = new Label("☁");
// //         icon.setStyle("-fx-font-size: 24px; -fx-text-fill: #64748b;");
        
// //         Label txt = new Label("Upload Practice Video\nAI processing for stance & swing path");
// //         txt.setStyle("-fx-font-size: 11px; -fx-text-fill: #64748b; -fx-text-alignment: center;");
        
// //         StackPane barPane = new StackPane();
// //         barPane.setAlignment(Pos.CENTER_LEFT);
// //         Rectangle bgBar = new Rectangle(200, 4, Color.web("#e2e8f0"));
// //         Rectangle progBar = new Rectangle(140, 4, Color.web("#10b981"));
// //         barPane.getChildren().addAll(bgBar, progBar);

// //         Label progTxt = new Label("Analyzing Frame 422... 67%");
// //         progTxt.setStyle("-fx-font-size: 10px; -fx-text-fill: #10b981; -fx-font-weight: bold;");

// //         box.getChildren().addAll(icon, txt, barPane, progTxt);
// //         return box;
// //     }

// //     private VBox buildCoachDeskCard() {
// //         VBox box = new VBox(15);
// //         box.setPadding(new Insets(20));
// //         box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");

// //         Label title = new Label("Coach's Desk");
// //         title.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: #0f172a;");

// //         VBox quoteBox = new VBox(10);
// //         quoteBox.setPadding(new Insets(0, 0, 0, 15));
// //         quoteBox.setStyle("-fx-border-color: #10b981; -fx-border-width: 0 0 0 3;");
        
// //         Label date = new Label("Oct 24 • Evening Review");
// //         date.setStyle("-fx-font-size: 11px; -fx-text-fill: #94a3b8;");
        
// //         Label quote = new Label("\"Vikram, your back-lift is becoming too diagonal. Keep it straight to avoid getting caught at slips on outswingers.\"");
// //         quote.setWrapText(true);
// //         quote.setStyle("-fx-font-size: 13px; -fx-font-style: italic; -fx-text-fill: #475569;");

// //         Label author = new Label("— Coach Sandeep Patil");
// //         author.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");

// //         quoteBox.getChildren().addAll(date, quote, author);
// //         box.getChildren().addAll(title, quoteBox);
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
// import javafx.scene.layout.*;
// import javafx.scene.paint.Color;
// import javafx.scene.shape.Circle;
// import javafx.scene.shape.Rectangle;
// import javafx.stage.FileChooser;
// import javafx.util.Duration;
// import java.io.File;

// public class Training_StartButton {

//     private StackPane rootContainer;
//     private Runnable onBack;

//     // Constructor accepts a callback to go back to the previous screen
//     public Training_StartButton(Runnable onBack) {
//         this.onBack = onBack;
//     }

//     public Node getView() {
//         if (rootContainer == null) {
//             rootContainer = new StackPane();
//             rootContainer.setStyle("-fx-background-color: #f8fafc;");

//             VBox mainLayout = new VBox(25);
//             mainLayout.setPadding(new Insets(20, 40, 40, 40));

//             // Build UI Sections
//             Node backButtonRow = buildBackButton();
//             Node headerArea = buildHeaderSection();
//             Node topMetrics = buildTopMetricsRow();
//             Node splitArea = buildMainSplitArea();

//             mainLayout.getChildren().addAll(backButtonRow, headerArea, topMetrics, splitArea);

//             // Cascading Entrance Animations
//             animateNodeEntrance(backButtonRow, 0);
//             animateNodeEntrance(headerArea, 100);
//             animateNodeEntrance(topMetrics, 200);
//             animateNodeEntrance(splitArea, 300);

//             ScrollPane scrollPane = new ScrollPane(mainLayout);
//             scrollPane.setFitToWidth(true);
//             scrollPane.setStyle("-fx-background-color: transparent; -fx-background: #f8fafc;");
//             scrollPane.getStylesheets().add("data:text/css,.scroll-pane > .viewport { -fx-background-color: transparent; }");

//             rootContainer.getChildren().add(scrollPane);
//         }
//         return rootContainer;
//     }

//     // --- ANIMATION HELPERS ---
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
//         scaleIn.setToX(1.03); 
//         scaleIn.setToY(1.03);
        
//         ScaleTransition scaleOut = new ScaleTransition(Duration.millis(150), node);
//         scaleOut.setToX(1.0); 
//         scaleOut.setToY(1.0);

//         node.setOnMouseEntered(e -> scaleIn.playFromStart());
//         node.setOnMouseExited(e -> scaleOut.playFromStart());
//     }

//     // --- BACK BUTTON ---
//     private HBox buildBackButton() {
//         HBox row = new HBox();
//         row.setAlignment(Pos.CENTER_LEFT);
        
//         Button backBtn = new Button("← Back to Dashboard");
//         backBtn.setStyle("-fx-background-color: white; -fx-text-fill: #475569; -fx-font-weight: bold; -fx-font-size: 13px; -fx-padding: 8 15; -fx-background-radius: 20; -fx-border-color: #e2e8f0; -fx-border-radius: 20; -fx-cursor: hand;");
//         addHoverScale(backBtn);
        
//         // Trigger the callback to go back when clicked
//         backBtn.setOnAction(e -> {
//             if (onBack != null) onBack.run();
//         });

//         row.getChildren().add(backBtn);
//         return row;
//     }

//     // --- HEADER SECTION ---
//     private HBox buildHeaderSection() {
//         HBox header = new HBox();
//         header.setAlignment(Pos.CENTER_LEFT);
//         header.setPadding(new Insets(10, 0, 0, 0));

//         // Left Info
//         VBox leftInfo = new VBox(8);
        
//         Label dateLbl = new Label("📅 Friday, Oct 25, 2024");
//         dateLbl.setStyle("-fx-font-size: 12px; -fx-text-fill: #10b981; -fx-font-weight: bold;");
        
//         Label titleLbl = new Label("Front Foot Dominance & Power Hitting");
//         titleLbl.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
        
//         HBox subInfo = new HBox(15);
//         Label coachLbl = new Label("👤 Coach Sandeep Patil");
//         coachLbl.setStyle("-fx-text-fill: #64748b; -fx-font-size: 13px;");
//         Label locLbl = new Label("🏟 Mumbai Elite Cricket");
//         locLbl.setStyle("-fx-text-fill: #64748b; -fx-font-size: 13px;");
//         subInfo.getChildren().addAll(coachLbl, locLbl);

//         Label weatherLbl = new Label("☀️ Sunny, 28°C");
//         weatherLbl.setStyle("-fx-text-fill: #94a3b8; -fx-font-size: 12px;");

//         // Header Buttons
//         HBox btns = new HBox(12);
//         btns.setPadding(new Insets(10, 0, 0, 0));
        
//         Button startBtn = new Button("Start\nTraining");
//         startBtn.setStyle("-fx-background-color: #10b981; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 8 25; -fx-text-alignment: center; -fx-cursor: hand;");
//         addHoverScale(startBtn);

//         Button compBtn = new Button("Complete\nSession");
//         compBtn.setStyle("-fx-background-color: #f1f5f9; -fx-text-fill: #475569; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 8 20; -fx-text-alignment: center; -fx-cursor: hand;");
//         addHoverScale(compBtn);

//         Button aiBtn = new Button("🤖 AI\nAnalysis");
//         aiBtn.setStyle("-fx-background-color: white; -fx-text-fill: #10b981; -fx-border-color: #10b981; -fx-border-radius: 8; -fx-background-radius: 8; -fx-font-weight: bold; -fx-padding: 7 20; -fx-text-alignment: center; -fx-cursor: hand;");
//         addHoverScale(aiBtn);

//         btns.getChildren().addAll(startBtn, compBtn, aiBtn);
//         leftInfo.getChildren().addAll(dateLbl, titleLbl, subInfo, weatherLbl, btns);

//         Region spacer = new Region();
//         HBox.setHgrow(spacer, Priority.ALWAYS);

//         // Right Stats
//         HBox rightStats = new HBox(30);
//         rightStats.setAlignment(Pos.CENTER_RIGHT);
//         rightStats.getChildren().addAll(
//             createHeaderStat("READINESS", "Optimal", "#10b981"),
//             createHeaderStat("TODAY'S\nSCORE", "85/100", "#0f172a"),
//             createHeaderStat("RECOVERY", "92%", "#0f172a")
//         );

//         header.getChildren().addAll(leftInfo, spacer, rightStats);
//         return header;
//     }

//     private VBox createHeaderStat(String title, String val, String color) {
//         VBox box = new VBox(3);
//         box.setAlignment(Pos.CENTER_RIGHT);
//         Label t = new Label(title);
//         t.setStyle("-fx-font-size: 10px; -fx-font-weight: bold; -fx-text-fill: #64748b; -fx-letter-spacing: 1px; -fx-text-alignment: right;");
//         Label v = new Label(val);
//         v.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: " + color + ";");
//         box.getChildren().addAll(t, v);
//         return box;
//     }

//     // --- TOP METRICS ROW ---
//     private HBox buildTopMetricsRow() {
//         HBox row = new HBox(20);
        
//         row.getChildren().addAll(
//             createMetricCard("2/5", "Completed\nSessions", "3 remaining", true),
//             createMetricCard("2.5h", "Practice Hours", "⏱", false),
//             createMetricCard("+4.2", "Skill Score", "📈", true)
//         );
//         for(Node n : row.getChildren()) {
//             HBox.setHgrow(n, Priority.ALWAYS);
//         }
//         return row;
//     }

//     private VBox createMetricCard(String mainVal, String title, String sub, boolean isGreen) {
//         VBox card = new VBox(10);
//         card.setAlignment(Pos.CENTER);
//         card.setPadding(new Insets(20));
//         card.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
//         addHoverScale(card);

//         StackPane circle = new StackPane();
//         Circle c = new Circle(25, Color.TRANSPARENT);
//         c.setStroke(isGreen ? Color.web("#10b981") : Color.web("#e2e8f0"));
//         c.setStrokeWidth(4);
//         Label m = new Label(mainVal);
//         m.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
//         circle.getChildren().addAll(c, m);

//         Label t = new Label(title);
//         t.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-text-fill: #0f172a; -fx-text-alignment: center;");
//         Label s = new Label(sub);
//         s.setStyle("-fx-font-size: 11px; -fx-text-fill: #94a3b8;");

//         card.getChildren().addAll(circle, t, s);
//         return card;
//     }

//     // --- MAIN SPLIT AREA ---
//     private HBox buildMainSplitArea() {
//         HBox split = new HBox(30);

//         // Left Column (Schedule, Skills, Activity)
//         VBox leftCol = new VBox(25);
//         HBox.setHgrow(leftCol, Priority.ALWAYS);
//         leftCol.getChildren().addAll(
//             buildScheduleSection(),
//             buildSkillTrainingSection(),
//             buildActivityFeedSection() // Replaced the split row containing QR code
//         );

//         // Right Column (AI, Gear, Video, Coach)
//         VBox rightCol = new VBox(20);
//         rightCol.setPrefWidth(320);
//         rightCol.setMinWidth(320);
//         rightCol.getChildren().addAll(
//             buildAIInsightCard(),
//             buildGearChecklist(),
//             buildUploadVideoCard(),
//             buildCoachDeskCard()
//         );

//         split.getChildren().addAll(leftCol, rightCol);
//         return split;
//     }

//     // --- LEFT COLUMN COMPONENTS ---
//     private VBox buildScheduleSection() {
//         VBox box = new VBox(15);
        
//         HBox header = new HBox();
//         Label title = new Label("Today's Schedule");
//         title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
//         Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);
//         Label badge = new Label("12 Day Streak");
//         badge.setStyle("-fx-background-color: #d1fae5; -fx-text-fill: #10b981; -fx-font-weight: bold; -fx-font-size: 11px; -fx-padding: 4 10; -fx-background-radius: 12;");
//         header.getChildren().addAll(title, sp, badge);

//         VBox list = new VBox(10);
//         list.getChildren().addAll(
//             createScheduleRow("08:00\nAM", "Morning Batting Nets", "Technical: Vertical Bat Drills • 90 mins", "Medium", ""),
//             createScheduleRow("11:30\nAM", "Mid-day Agility Drills", "Fitness: SAQ Drills & Reactivity • 60 mins", "Hard", "Start"),
//             createScheduleRow("05:00\nPM", "Evening Tactical Analysis", "Review: Opponent Weakness Mapping • 45 mins", "Easy", "🔒")
//         );

//         box.getChildren().addAll(header, list);
//         return box;
//     }

//     private HBox createScheduleRow(String time, String title, String sub, String tag, String action) {
//         HBox row = new HBox(15);
//         row.setAlignment(Pos.CENTER_LEFT);
//         row.setPadding(new Insets(15));
//         row.setStyle("-fx-background-color: white; -fx-background-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.02), 8, 0, 0, 2);");
//         addHoverScale(row);

//         Label timeLbl = new Label(time);
//         timeLbl.setStyle("-fx-font-weight: bold; -fx-font-size: 13px; -fx-text-fill: #475569; -fx-text-alignment: center;");

//         VBox texts = new VBox(3);
//         Label t = new Label("• " + title);
//         t.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: #0f172a;");
//         Label s = new Label(sub);
//         s.setStyle("-fx-font-size: 12px; -fx-text-fill: #64748b;");
//         texts.getChildren().addAll(t, s);

//         Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);

//         Label tagLbl = new Label(tag);
//         tagLbl.setStyle("-fx-background-color: #f1f5f9; -fx-text-fill: #64748b; -fx-font-weight: bold; -fx-font-size: 11px; -fx-padding: 4 10; -fx-background-radius: 6;");

//         row.getChildren().addAll(timeLbl, texts, sp, tagLbl);

//         if (!action.isEmpty()) {
//             if (action.equals("Start")) {
//                 Button btn = new Button(action);
//                 btn.setStyle("-fx-background-color: #10b981; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 11px; -fx-background-radius: 6; -fx-cursor: hand;");
//                 row.getChildren().add(btn);
//             } else {
//                 Label lck = new Label(action);
//                 lck.setStyle("-fx-text-fill: #94a3b8; -fx-font-size: 14px;");
//                 row.getChildren().add(lck);
//             }
//         }

//         return row;
//     }

//     // === MODIFIED INTERACTIVE SKILL TRAINING TABS ===
//     private VBox buildSkillTrainingSection() {
//         VBox box = new VBox(15);
        
//         HBox header = new HBox(20);
//         header.setAlignment(Pos.CENTER_LEFT);
//         Label title = new Label("Skill Specific Training");
//         title.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
        
//         HBox tabs = new HBox(10);
        
//         // Tab Labels (functioning as buttons)
//         Label batTab = createMiniTab("Batting");
//         Label bowlTab = createMiniTab("Bowling");
//         Label fieldTab = createMiniTab("Fielding");
//         Label keepTab = createMiniTab("Keeper");
        
//         tabs.getChildren().addAll(batTab, bowlTab, fieldTab, keepTab);
//         header.getChildren().addAll(title, tabs);

//         // Container to hold dynamic cards
//         HBox cardsContainer = new HBox(15);
//         for(Node n : cardsContainer.getChildren()) HBox.setHgrow(n, Priority.ALWAYS);

//         // Set initial state
//         setTabActiveState(batTab, true);
//         setTabActiveState(bowlTab, false);
//         setTabActiveState(fieldTab, false);
//         setTabActiveState(keepTab, false);
//         loadSkillCards(cardsContainer, "Batting");

//         // Action Listeners for interactivity
//         batTab.setOnMouseClicked(e -> {
//             setTabActiveState(batTab, true); setTabActiveState(bowlTab, false); setTabActiveState(fieldTab, false); setTabActiveState(keepTab, false);
//             loadSkillCards(cardsContainer, "Batting");
//         });
//         bowlTab.setOnMouseClicked(e -> {
//             setTabActiveState(batTab, false); setTabActiveState(bowlTab, true); setTabActiveState(fieldTab, false); setTabActiveState(keepTab, false);
//             loadSkillCards(cardsContainer, "Bowling");
//         });
//         fieldTab.setOnMouseClicked(e -> {
//             setTabActiveState(batTab, false); setTabActiveState(bowlTab, false); setTabActiveState(fieldTab, true); setTabActiveState(keepTab, false);
//             loadSkillCards(cardsContainer, "Fielding");
//         });
//         keepTab.setOnMouseClicked(e -> {
//             setTabActiveState(batTab, false); setTabActiveState(bowlTab, false); setTabActiveState(fieldTab, false); setTabActiveState(keepTab, true);
//             loadSkillCards(cardsContainer, "Keeper");
//         });

//         box.getChildren().addAll(header, cardsContainer);
//         return box;
//     }

//     private Label createMiniTab(String text) {
//         Label l = new Label(text);
//         l.setStyle("-fx-text-fill: #64748b; -fx-font-weight: bold; -fx-font-size: 11px; -fx-padding: 6 16; -fx-background-radius: 12; -fx-cursor: hand;");
//         return l;
//     }

//     private void setTabActiveState(Label tab, boolean isActive) {
//         if (isActive) {
//             tab.setStyle("-fx-background-color: white; -fx-text-fill: #0f172a; -fx-font-weight: bold; -fx-font-size: 11px; -fx-padding: 6 16; -fx-background-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.08), 5, 0, 0, 2); -fx-cursor: hand;");
//         } else {
//             tab.setStyle("-fx-background-color: transparent; -fx-text-fill: #64748b; -fx-font-weight: bold; -fx-font-size: 11px; -fx-padding: 6 16; -fx-background-radius: 12; -fx-cursor: hand;");
//         }
//     }

//     private void loadSkillCards(HBox container, String category) {
//         container.getChildren().clear();
        
//         StackPane card1, card2;
        
//         switch (category) {
//             case "Bowling":
//                 card1 = createVideoCard("Inswing Mechanics", "3 Sets x 12 Reps", "⭐ Coach Choice");
//                 card2 = createVideoCard("Yorker Accuracy", "4 Sets x 15 Reps", "⏱ Last: 7.5/10");
//                 break;
//             case "Fielding":
//                 card1 = createVideoCard("Diving Interceptions", "5 Sets x 10 Reps", "🔥 High Intensity");
//                 card2 = createVideoCard("Direct Hit Drills", "3 Sets x 20 Reps", "⏱ Last: 9/10");
//                 break;
//             case "Keeper":
//                 card1 = createVideoCard("Spin Reaction Drills", "4 Sets x 30 Reps", "⭐ Coach Choice");
//                 card2 = createVideoCard("Leg-side Diving", "3 Sets x 15 Reps", "⏱ Last: 8/10");
//                 break;
//             default: // Batting
//                 card1 = createVideoCard("Cover Drive Fundamentals", "4 Sets x 15 Reps", "⭐ Coach Choice");
//                 card2 = createVideoCard("Straight Drive Control", "3 Sets x 20 Reps", "⏱ Last: 8.5/10");
//                 break;
//         }

//         HBox.setHgrow(card1, Priority.ALWAYS);
//         HBox.setHgrow(card2, Priority.ALWAYS);
//         container.getChildren().addAll(card1, card2);

//         // Smooth fade on tab switch
//         container.setOpacity(0);
//         FadeTransition ft = new FadeTransition(Duration.millis(300), container);
//         ft.setToValue(1.0);
//         ft.play();
//     }

//     private StackPane createVideoCard(String title, String sub, String tag) {
//         StackPane card = new StackPane();
//         card.setMinHeight(160);
//         card.setStyle("-fx-background-color: #cbd5e1; -fx-background-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.05), 10, 0, 0, 4);");
//         addHoverScale(card);

//         Region overlay = new Region();
//         overlay.setStyle("-fx-background-color: linear-gradient(to top, rgba(0,0,0,0.8), transparent); -fx-background-radius: 12;");

//         VBox content = new VBox(5);
//         content.setAlignment(Pos.BOTTOM_LEFT);
//         content.setPadding(new Insets(15));
        
//         Label t = new Label(title);
//         t.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14px;");
//         Label s = new Label(sub);
//         s.setStyle("-fx-text-fill: #cbd5e1; -fx-font-size: 11px;");
//         Label tg = new Label(tag);
//         tg.setStyle("-fx-text-fill: #34d399; -fx-font-size: 11px; -fx-font-weight: bold;");
        
//         content.getChildren().addAll(t, s, tg);
//         card.getChildren().addAll(overlay, content);
//         return card;
//     }

//     // === MODIFIED: REMOVED QR BLOCK, ACTIVITY TAKES FULL WIDTH ===
//     private VBox buildActivityFeedSection() {
//         VBox activity = new VBox(15);
//         activity.setPadding(new Insets(20));
//         activity.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
        
//         Label actTitle = new Label("Training Activity Feed");
//         actTitle.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: #0f172a;");

//         VBox actList = new VBox(15);
//         actList.getChildren().addAll(
//             createActivityItem("✓", "Completed: Morning Batting Nets", "09:45 AM", "#10b981"),
//             createActivityItem("🍴", "Nutritional Intake Logged", "08:15 AM", "#94a3b8"),
//             createActivityItem("→", "Checked-in at Mumbai Elite Academy", "07:55 AM", "#0f172a")
//         );
        
//         activity.getChildren().addAll(actTitle, actList);
//         return activity;
//     }

//     private HBox createActivityItem(String icon, String title, String time, String colorHex) {
//         HBox item = new HBox(15);
//         item.setAlignment(Pos.TOP_LEFT);

//         Circle iconBg = new Circle(14, Color.web(colorHex));
//         Label iLbl = new Label(icon);
//         iLbl.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 12px;");
//         StackPane iconPane = new StackPane(iconBg, iLbl);

//         VBox texts = new VBox(3);
//         Label tLbl = new Label(title);
//         tLbl.setStyle("-fx-font-weight: bold; -fx-font-size: 13px; -fx-text-fill: #0f172a;");
//         Label timeLbl = new Label(time);
//         timeLbl.setStyle("-fx-font-size: 11px; -fx-text-fill: #94a3b8;");
//         texts.getChildren().addAll(tLbl, timeLbl);

//         item.getChildren().addAll(iconPane, texts);
//         return item;
//     }

//     // --- RIGHT COLUMN COMPONENTS ---
//     private VBox buildAIInsightCard() {
//         VBox card = new VBox(15);
//         card.setPadding(new Insets(25));
//         card.setStyle("-fx-background-color: #0f172a; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.15), 20, 0, 0, 8);");
//         addHoverScale(card);

//         Label header = new Label("✨ AI DAILY INSIGHT");
//         header.setStyle("-fx-text-fill: #34d399; -fx-font-weight: bold; -fx-font-size: 10px; -fx-letter-spacing: 1px;");

//         Label title = new Label("Focus on wrist stability");
//         title.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 16px;");

//         Label desc = new Label("Your last session showed a 12% dip in power during the last 20 balls. Prioritize wrist-strengthening warm-ups today.");
//         desc.setWrapText(true);
//         desc.setStyle("-fx-text-fill: #94a3b8; -fx-font-size: 12px; -fx-line-spacing: 4px;");

//         VBox predBox = new VBox(5);
//         predBox.setPadding(new Insets(15));
//         predBox.setStyle("-fx-background-color: rgba(16,185,129,0.1); -fx-border-color: #10b981; -fx-border-radius: 8; -fx-background-radius: 8;");
//         Label pTitle = new Label("NEXT SESSION PREDICTION");
//         pTitle.setStyle("-fx-text-fill: #10b981; -fx-font-size: 9px; -fx-font-weight: bold; -fx-letter-spacing: 1px;");
//         Label pVal = new Label("High-Intensity Yorkers & Slingshot Drills");
//         pVal.setStyle("-fx-text-fill: white; -fx-font-size: 13px; -fx-font-weight: bold;");
//         predBox.getChildren().addAll(pTitle, pVal);

//         card.getChildren().addAll(header, title, desc, predBox);
//         return card;
//     }

//     // === MODIFIED: INTERACTIVE CHECKBOXES ===
//     private VBox buildGearChecklist() {
//         VBox box = new VBox(15);
//         box.setPadding(new Insets(20));
//         box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
        
//         Label title = new Label("Gear Checklist");
//         title.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: #0f172a;");

//         VBox list = new VBox(12);
//         list.getChildren().addAll(
//             createInteractiveCheckItem("Match Bat (Grade 1)", true),
//             createInteractiveCheckItem("Elite Padding & Gloves", true),
//             createInteractiveCheckItem("Helmet & Safety Gear", false),
//             createInteractiveCheckItem("Hydration & Recovery", false)
//         );

//         box.getChildren().addAll(title, list);
//         return box;
//     }

//     private HBox createInteractiveCheckItem(String text, boolean initiallyChecked) {
//         HBox row = new HBox(10);
//         row.setAlignment(Pos.CENTER_LEFT);
//         row.setStyle("-fx-cursor: hand;");
        
//         // Single element array trick to hold mutable boolean in lambda
//         boolean[] checkedState = { initiallyChecked };
        
//         Label box = new Label(checkedState[0] ? "☑" : "☐");
//         box.setStyle("-fx-text-fill: " + (checkedState[0] ? "#10b981" : "#94a3b8") + "; -fx-font-size: 18px;");
        
//         Label txt = new Label(text);
//         txt.setStyle("-fx-font-size: 13px; -fx-text-fill: #475569;");
        
//         // Click listener to toggle the checkbox
//         row.setOnMouseClicked(e -> {
//             checkedState[0] = !checkedState[0];
//             box.setText(checkedState[0] ? "☑" : "☐");
//             box.setStyle("-fx-text-fill: " + (checkedState[0] ? "#10b981" : "#94a3b8") + "; -fx-font-size: 18px;");
//         });

//         row.getChildren().addAll(box, txt);
//         return row;
//     }

//     // === MODIFIED: UPLOAD VIDEO WITH FILE MANAGER LOGIC ===
//     private VBox buildUploadVideoCard() {
//         VBox box = new VBox(10);
//         box.setAlignment(Pos.CENTER);
//         box.setPadding(new Insets(20));
//         box.setStyle("-fx-background-color: #f8fafc; -fx-border-color: #cbd5e1; -fx-border-style: dashed; -fx-border-width: 2; -fx-background-radius: 16; -fx-border-radius: 16; -fx-cursor: hand;");
//         addHoverScale(box);

//         Label icon = new Label("☁");
//         icon.setStyle("-fx-font-size: 24px; -fx-text-fill: #64748b;");
        
//         Label txt = new Label("Upload Practice Video\nAI processing for stance & swing path");
//         txt.setStyle("-fx-font-size: 11px; -fx-text-fill: #64748b; -fx-text-alignment: center;");
        
//         StackPane barPane = new StackPane();
//         barPane.setAlignment(Pos.CENTER_LEFT);
//         Rectangle bgBar = new Rectangle(200, 4, Color.web("#e2e8f0"));
//         Rectangle progBar = new Rectangle(0, 4, Color.web("#10b981")); // Start at 0%
//         barPane.getChildren().addAll(bgBar, progBar);

//         Label progTxt = new Label("Click to upload");
//         progTxt.setStyle("-fx-font-size: 10px; -fx-text-fill: #94a3b8; -fx-font-weight: bold;");

//         // Action Listener for opening file manager
//         box.setOnMouseClicked(e -> {
//             FileChooser fileChooser = new FileChooser();
//             fileChooser.setTitle("Select Practice Video");
//             fileChooser.getExtensionFilters().addAll(
//                 new FileChooser.ExtensionFilter("Video Files", "*.mp4", "*.avi", "*.mkv", "*.mov")
//             );
            
//             // Show Open Dialog
//             File selectedFile = fileChooser.showOpenDialog(rootContainer.getScene().getWindow());
            
//             if (selectedFile != null) {
//                 txt.setText("Selected: " + selectedFile.getName());
//                 progTxt.setText("Analyzing Frame 422... 67%");
//                 progTxt.setStyle("-fx-font-size: 10px; -fx-text-fill: #10b981; -fx-font-weight: bold;");
//                 progBar.setWidth(140); // Visually update progress bar to 67%
//             }
//         });

//         box.getChildren().addAll(icon, txt, barPane, progTxt);
//         return box;
//     }

//     private VBox buildCoachDeskCard() {
//         VBox box = new VBox(15);
//         box.setPadding(new Insets(20));
//         box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");

//         Label title = new Label("Coach's Desk");
//         title.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: #0f172a;");

//         VBox quoteBox = new VBox(10);
//         quoteBox.setPadding(new Insets(0, 0, 0, 15));
//         quoteBox.setStyle("-fx-border-color: #10b981; -fx-border-width: 0 0 0 3;");
        
//         Label date = new Label("Oct 24 • Evening Review");
//         date.setStyle("-fx-font-size: 11px; -fx-text-fill: #94a3b8;");
        
//         Label quote = new Label("\"Vikram, your back-lift is becoming too diagonal. Keep it straight to avoid getting caught at slips on outswingers.\"");
//         quote.setWrapText(true);
//         quote.setStyle("-fx-font-size: 13px; -fx-font-style: italic; -fx-text-fill: #475569;");

//         Label author = new Label("— Coach Sandeep Patil");
//         author.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");

//         quoteBox.getChildren().addAll(date, quote, author);
//         box.getChildren().addAll(title, quoteBox);
//         return box;
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
import javafx.stage.FileChooser;
import javafx.util.Duration;
import java.io.File;

public class Training_StartButton {

    private StackPane rootContainer;
    private Runnable onBack;

    // Constructor accepts a callback to go back to the previous screen
    public Training_StartButton(Runnable onBack) {
        this.onBack = onBack;
    }

    public Node getView() {
        if (rootContainer == null) {
            rootContainer = new StackPane();
            rootContainer.setStyle("-fx-background-color: #f8fafc;");

            VBox mainLayout = new VBox(25);
            mainLayout.setPadding(new Insets(20, 40, 40, 40));

            // Build UI Sections
            Node backButtonRow = buildBackButton();
            Node headerArea = buildHeaderSection();
            Node topMetrics = buildTopMetricsRow();
            Node splitArea = buildMainSplitArea();

            mainLayout.getChildren().addAll(backButtonRow, headerArea, topMetrics, splitArea);

            // Cascading Entrance Animations
            animateNodeEntrance(backButtonRow, 0);
            animateNodeEntrance(headerArea, 100);
            animateNodeEntrance(topMetrics, 200);
            animateNodeEntrance(splitArea, 300);

            ScrollPane scrollPane = new ScrollPane(mainLayout);
            scrollPane.setFitToWidth(true);
            scrollPane.setStyle("-fx-background-color: transparent; -fx-background: #f8fafc;");
            scrollPane.getStylesheets().add("data:text/css,.scroll-pane > .viewport { -fx-background-color: transparent; }");

            rootContainer.getChildren().add(scrollPane);
        }
        return rootContainer;
    }

    // --- ANIMATION HELPERS ---
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
        scaleIn.setToX(1.03); 
        scaleIn.setToY(1.03);
        
        ScaleTransition scaleOut = new ScaleTransition(Duration.millis(150), node);
        scaleOut.setToX(1.0); 
        scaleOut.setToY(1.0);

        node.setOnMouseEntered(e -> scaleIn.playFromStart());
        node.setOnMouseExited(e -> scaleOut.playFromStart());
    }

    // --- BACK BUTTON ---
    private HBox buildBackButton() {
        HBox row = new HBox();
        row.setAlignment(Pos.CENTER_LEFT);
        
        Button backBtn = new Button("← Back to Dashboard");
        backBtn.setStyle("-fx-background-color: white; -fx-text-fill: #475569; -fx-font-weight: bold; -fx-font-size: 13px; -fx-padding: 8 15; -fx-background-radius: 20; -fx-border-color: #e2e8f0; -fx-border-radius: 20; -fx-cursor: hand;");
        addHoverScale(backBtn);
        
        // Trigger the callback to go back when clicked
        backBtn.setOnAction(e -> {
            if (onBack != null) onBack.run();
        });

        row.getChildren().add(backBtn);
        return row;
    }

    // --- HEADER SECTION ---
    private HBox buildHeaderSection() {
        HBox header = new HBox();
        header.setAlignment(Pos.CENTER_LEFT);
        header.setPadding(new Insets(10, 0, 0, 0));

        // Left Info
        VBox leftInfo = new VBox(8);
        
        Label dateLbl = new Label("📅 Friday, Oct 25, 2024");
        dateLbl.setStyle("-fx-font-size: 12px; -fx-text-fill: #10b981; -fx-font-weight: bold;");
        
        Label titleLbl = new Label("Front Foot Dominance & Power Hitting");
        titleLbl.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
        
        HBox subInfo = new HBox(15);
        Label coachLbl = new Label("👤 Coach Sandeep Patil");
        coachLbl.setStyle("-fx-text-fill: #64748b; -fx-font-size: 13px;");
        Label locLbl = new Label("🏟 Mumbai Elite Cricket");
        locLbl.setStyle("-fx-text-fill: #64748b; -fx-font-size: 13px;");
        subInfo.getChildren().addAll(coachLbl, locLbl);

        Label weatherLbl = new Label("☀️ Sunny, 28°C");
        weatherLbl.setStyle("-fx-text-fill: #94a3b8; -fx-font-size: 12px;");

        // Header Buttons
        HBox btns = new HBox(12);
        btns.setPadding(new Insets(10, 0, 0, 0));
        
        Button startBtn = new Button("Start\nTraining");
        startBtn.setStyle("-fx-background-color: #10b981; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 8 25; -fx-text-alignment: center; -fx-cursor: hand;");
        addHoverScale(startBtn);

        Button compBtn = new Button("Complete\nSession");
        compBtn.setStyle("-fx-background-color: #f1f5f9; -fx-text-fill: #475569; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 8 20; -fx-text-alignment: center; -fx-cursor: hand;");
        addHoverScale(compBtn);

        Button aiBtn = new Button("🤖 AI\nAnalysis");
        aiBtn.setStyle("-fx-background-color: white; -fx-text-fill: #10b981; -fx-border-color: #10b981; -fx-border-radius: 8; -fx-background-radius: 8; -fx-font-weight: bold; -fx-padding: 7 20; -fx-text-alignment: center; -fx-cursor: hand;");
        addHoverScale(aiBtn);

        btns.getChildren().addAll(startBtn, compBtn, aiBtn);
        leftInfo.getChildren().addAll(dateLbl, titleLbl, subInfo, weatherLbl, btns);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        // Right Stats
        HBox rightStats = new HBox(30);
        rightStats.setAlignment(Pos.CENTER_RIGHT);
        rightStats.getChildren().addAll(
            createHeaderStat("READINESS", "Optimal", "#10b981"),
            createHeaderStat("TODAY'S\nSCORE", "85/100", "#0f172a"),
            createHeaderStat("RECOVERY", "92%", "#0f172a")
        );

        header.getChildren().addAll(leftInfo, spacer, rightStats);
        return header;
    }

    private VBox createHeaderStat(String title, String val, String color) {
        VBox box = new VBox(3);
        box.setAlignment(Pos.CENTER_RIGHT);
        Label t = new Label(title);
        t.setStyle("-fx-font-size: 10px; -fx-font-weight: bold; -fx-text-fill: #64748b; -fx-letter-spacing: 1px; -fx-text-alignment: right;");
        Label v = new Label(val);
        v.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: " + color + ";");
        box.getChildren().addAll(t, v);
        return box;
    }

    // --- TOP METRICS ROW ---
    private HBox buildTopMetricsRow() {
        HBox row = new HBox(20);
        
        row.getChildren().addAll(
            createMetricCard("2/5", "Completed\nSessions", "3 remaining", true),
            createMetricCard("2.5h", "Practice Hours", "⏱", false),
            createMetricCard("+4.2", "Skill Score", "📈", true)
        );
        for(Node n : row.getChildren()) {
            HBox.setHgrow(n, Priority.ALWAYS);
        }
        return row;
    }

    private VBox createMetricCard(String mainVal, String title, String sub, boolean isGreen) {
        VBox card = new VBox(10);
        card.setAlignment(Pos.CENTER);
        card.setPadding(new Insets(20));
        card.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
        addHoverScale(card);

        StackPane circle = new StackPane();
        Circle c = new Circle(25, Color.TRANSPARENT);
        c.setStroke(isGreen ? Color.web("#10b981") : Color.web("#e2e8f0"));
        c.setStrokeWidth(4);
        Label m = new Label(mainVal);
        m.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
        circle.getChildren().addAll(c, m);

        Label t = new Label(title);
        t.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-text-fill: #0f172a; -fx-text-alignment: center;");
        Label s = new Label(sub);
        s.setStyle("-fx-font-size: 11px; -fx-text-fill: #94a3b8;");

        card.getChildren().addAll(circle, t, s);
        return card;
    }

    // --- MAIN SPLIT AREA ---
    private HBox buildMainSplitArea() {
        HBox split = new HBox(30);

        // Left Column (Schedule, Skills, Activity)
        VBox leftCol = new VBox(25);
        HBox.setHgrow(leftCol, Priority.ALWAYS);
        leftCol.getChildren().addAll(
            buildScheduleSection(),
            buildSkillTrainingSection(),
            buildActivityFeedSection() 
        );

        // Right Column (AI, Gear, Video, Coach)
        VBox rightCol = new VBox(20);
        rightCol.setPrefWidth(320);
        rightCol.setMinWidth(320);
        rightCol.getChildren().addAll(
            buildAIInsightCard(),
            buildGearChecklist(),
            buildUploadVideoCard(),
            buildCoachDeskCard()
        );

        split.getChildren().addAll(leftCol, rightCol);
        return split;
    }

    // --- LEFT COLUMN COMPONENTS ---
    private VBox buildScheduleSection() {
        VBox box = new VBox(15);
        
        HBox header = new HBox();
        Label title = new Label("Today's Schedule");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
        Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);
        Label badge = new Label("12 Day Streak");
        badge.setStyle("-fx-background-color: #d1fae5; -fx-text-fill: #10b981; -fx-font-weight: bold; -fx-font-size: 11px; -fx-padding: 4 10; -fx-background-radius: 12;");
        header.getChildren().addAll(title, sp, badge);

        VBox list = new VBox(10);
        list.getChildren().addAll(
            createScheduleRow("08:00\nAM", "Morning Batting Nets", "Technical: Vertical Bat Drills • 90 mins", "Medium", ""),
            createScheduleRow("11:30\nAM", "Mid-day Agility Drills", "Fitness: SAQ Drills & Reactivity • 60 mins", "Hard", "Start"),
            createScheduleRow("05:00\nPM", "Evening Tactical Analysis", "Review: Opponent Weakness Mapping • 45 mins", "Easy", "🔒")
        );

        box.getChildren().addAll(header, list);
        return box;
    }

    private HBox createScheduleRow(String time, String title, String sub, String tag, String action) {
        HBox row = new HBox(15);
        row.setAlignment(Pos.CENTER_LEFT);
        row.setPadding(new Insets(15));
        row.setStyle("-fx-background-color: white; -fx-background-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.02), 8, 0, 0, 2);");
        addHoverScale(row);

        Label timeLbl = new Label(time);
        timeLbl.setStyle("-fx-font-weight: bold; -fx-font-size: 13px; -fx-text-fill: #475569; -fx-text-alignment: center;");

        VBox texts = new VBox(3);
        Label t = new Label("• " + title);
        t.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: #0f172a;");
        Label s = new Label(sub);
        s.setStyle("-fx-font-size: 12px; -fx-text-fill: #64748b;");
        texts.getChildren().addAll(t, s);

        Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);

        Label tagLbl = new Label(tag);
        tagLbl.setStyle("-fx-background-color: #f1f5f9; -fx-text-fill: #64748b; -fx-font-weight: bold; -fx-font-size: 11px; -fx-padding: 4 10; -fx-background-radius: 6;");

        row.getChildren().addAll(timeLbl, texts, sp, tagLbl);

        if (!action.isEmpty()) {
            if (action.equals("Start")) {
                Button btn = new Button(action);
                btn.setStyle("-fx-background-color: #10b981; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 11px; -fx-background-radius: 6; -fx-cursor: hand;");
                row.getChildren().add(btn);
            } else {
                Label lck = new Label(action);
                lck.setStyle("-fx-text-fill: #94a3b8; -fx-font-size: 14px;");
                row.getChildren().add(lck);
            }
        }

        return row;
    }

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

    private void loadSkillCards(HBox container, String category) {
        container.getChildren().clear();
        
        StackPane card1, card2;
        
        // High quality placeholder image URLs corresponding to the sports themes
        switch (category) {
            case "Bowling":
                card1 = createVideoCard("Inswing Mechanics", "3 Sets x 12 Reps", "⭐ Coach Choice", "https://images.unsplash.com/photo-1587280501635-68a0e82cd5ff?w=400&h=200&fit=crop");
                card2 = createVideoCard("Yorker Accuracy", "4 Sets x 15 Reps", "⏱ Last: 7.5/10", "https://images.unsplash.com/photo-1518063319789-7217e6706b04?w=400&h=200&fit=crop");
                break;
            case "Fielding":
                card1 = createVideoCard("Diving Interceptions", "5 Sets x 10 Reps", "🔥 High Intensity", "https://images.unsplash.com/photo-1540747913346-19e32dc3e97e?w=400&h=200&fit=crop");
                card2 = createVideoCard("Direct Hit Drills", "3 Sets x 20 Reps", "⏱ Last: 9/10", "https://images.unsplash.com/photo-1593786480164-9a3b68074d6c?w=400&h=200&fit=crop");
                break;
            case "Keeper":
                card1 = createVideoCard("Spin Reaction Drills", "4 Sets x 30 Reps", "⭐ Coach Choice", "https://images.unsplash.com/photo-1550262174-cb233d596645?w=400&h=200&fit=crop");
                card2 = createVideoCard("Leg-side Diving", "3 Sets x 15 Reps", "⏱ Last: 8/10", "https://images.unsplash.com/photo-1624526267942-ab0f0b580898?w=400&h=200&fit=crop");
                break;
            default: // Batting
                card1 = createVideoCard("Cover Drive Fundamentals", "4 Sets x 15 Reps", "⭐ Coach Choice", "https://images.unsplash.com/photo-1607734834519-d8576ae60ea6?w=400&h=200&fit=crop");
                card2 = createVideoCard("Straight Drive Control", "3 Sets x 20 Reps", "⏱ Last: 8.5/10", "https://images.unsplash.com/photo-1531415074968-036ba1b575da?w=400&h=200&fit=crop");
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

    private StackPane createVideoCard(String title, String sub, String tag, String imageUrl) {
        StackPane card = new StackPane();
        card.setMinHeight(160);
        
        // Base style string 
        String cardStyle = "-fx-background-color: #cbd5e1; -fx-background-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.05), 10, 0, 0, 4);";
        
        // Append image to background if provided
        if (imageUrl != null && !imageUrl.isEmpty()) {
            cardStyle += "-fx-background-image: url('" + imageUrl + "'); -fx-background-size: cover; -fx-background-position: center center;";
        }
        card.setStyle(cardStyle);
        addHoverScale(card);

        // Dark gradient overlay for text readability
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

    private VBox buildActivityFeedSection() {
        VBox activity = new VBox(15);
        activity.setPadding(new Insets(20));
        activity.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
        
        Label actTitle = new Label("Training Activity Feed");
        actTitle.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: #0f172a;");

        VBox actList = new VBox(15);
        actList.getChildren().addAll(
            createActivityItem("✓", "Completed: Morning Batting Nets", "09:45 AM", "#10b981"),
            createActivityItem("🍴", "Nutritional Intake Logged", "08:15 AM", "#94a3b8"),
            createActivityItem("→", "Checked-in at Mumbai Elite Academy", "07:55 AM", "#0f172a")
        );
        
        activity.getChildren().addAll(actTitle, actList);
        return activity;
    }

    private HBox createActivityItem(String icon, String title, String time, String colorHex) {
        HBox item = new HBox(15);
        item.setAlignment(Pos.TOP_LEFT);

        Circle iconBg = new Circle(14, Color.web(colorHex));
        Label iLbl = new Label(icon);
        iLbl.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 12px;");
        StackPane iconPane = new StackPane(iconBg, iLbl);

        VBox texts = new VBox(3);
        Label tLbl = new Label(title);
        tLbl.setStyle("-fx-font-weight: bold; -fx-font-size: 13px; -fx-text-fill: #0f172a;");
        Label timeLbl = new Label(time);
        timeLbl.setStyle("-fx-font-size: 11px; -fx-text-fill: #94a3b8;");
        texts.getChildren().addAll(tLbl, timeLbl);

        item.getChildren().addAll(iconPane, texts);
        return item;
    }

    // --- RIGHT COLUMN COMPONENTS ---
    private VBox buildAIInsightCard() {
        VBox card = new VBox(15);
        card.setPadding(new Insets(25));
        card.setStyle("-fx-background-color: #0f172a; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.15), 20, 0, 0, 8);");
        addHoverScale(card);

        Label header = new Label("✨ AI DAILY INSIGHT");
        header.setStyle("-fx-text-fill: #34d399; -fx-font-weight: bold; -fx-font-size: 10px; -fx-letter-spacing: 1px;");

        Label title = new Label("Focus on wrist stability");
        title.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 16px;");

        Label desc = new Label("Your last session showed a 12% dip in power during the last 20 balls. Prioritize wrist-strengthening warm-ups today.");
        desc.setWrapText(true);
        desc.setStyle("-fx-text-fill: #94a3b8; -fx-font-size: 12px; -fx-line-spacing: 4px;");

        VBox predBox = new VBox(5);
        predBox.setPadding(new Insets(15));
        predBox.setStyle("-fx-background-color: rgba(16,185,129,0.1); -fx-border-color: #10b981; -fx-border-radius: 8; -fx-background-radius: 8;");
        Label pTitle = new Label("NEXT SESSION PREDICTION");
        pTitle.setStyle("-fx-text-fill: #10b981; -fx-font-size: 9px; -fx-font-weight: bold; -fx-letter-spacing: 1px;");
        Label pVal = new Label("High-Intensity Yorkers & Slingshot Drills");
        pVal.setStyle("-fx-text-fill: white; -fx-font-size: 13px; -fx-font-weight: bold;");
        predBox.getChildren().addAll(pTitle, pVal);

        card.getChildren().addAll(header, title, desc, predBox);
        return card;
    }

    private VBox buildGearChecklist() {
        VBox box = new VBox(15);
        box.setPadding(new Insets(20));
        box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");
        
        Label title = new Label("Gear Checklist");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: #0f172a;");

        VBox list = new VBox(12);
        list.getChildren().addAll(
            createInteractiveCheckItem("Match Bat (Grade 1)", true),
            createInteractiveCheckItem("Elite Padding & Gloves", true),
            createInteractiveCheckItem("Helmet & Safety Gear", false),
            createInteractiveCheckItem("Hydration & Recovery", false)
        );

        box.getChildren().addAll(title, list);
        return box;
    }

    private HBox createInteractiveCheckItem(String text, boolean initiallyChecked) {
        HBox row = new HBox(10);
        row.setAlignment(Pos.CENTER_LEFT);
        row.setStyle("-fx-cursor: hand;");
        
        boolean[] checkedState = { initiallyChecked };
        
        Label box = new Label(checkedState[0] ? "☑" : "☐");
        box.setStyle("-fx-text-fill: " + (checkedState[0] ? "#10b981" : "#94a3b8") + "; -fx-font-size: 18px;");
        
        Label txt = new Label(text);
        txt.setStyle("-fx-font-size: 13px; -fx-text-fill: #475569;");
        
        row.setOnMouseClicked(e -> {
            checkedState[0] = !checkedState[0];
            box.setText(checkedState[0] ? "☑" : "☐");
            box.setStyle("-fx-text-fill: " + (checkedState[0] ? "#10b981" : "#94a3b8") + "; -fx-font-size: 18px;");
        });

        row.getChildren().addAll(box, txt);
        return row;
    }

    private VBox buildUploadVideoCard() {
        VBox box = new VBox(10);
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(20));
        box.setStyle("-fx-background-color: #f8fafc; -fx-border-color: #cbd5e1; -fx-border-style: dashed; -fx-border-width: 2; -fx-background-radius: 16; -fx-border-radius: 16; -fx-cursor: hand;");
        addHoverScale(box);

        Label icon = new Label("☁");
        icon.setStyle("-fx-font-size: 24px; -fx-text-fill: #64748b;");
        
        Label txt = new Label("Upload Practice Video\nAI processing for stance & swing path");
        txt.setStyle("-fx-font-size: 11px; -fx-text-fill: #64748b; -fx-text-alignment: center;");
        
        StackPane barPane = new StackPane();
        barPane.setAlignment(Pos.CENTER_LEFT);
        Rectangle bgBar = new Rectangle(200, 4, Color.web("#e2e8f0"));
        Rectangle progBar = new Rectangle(0, 4, Color.web("#10b981"));
        barPane.getChildren().addAll(bgBar, progBar);

        Label progTxt = new Label("Click to upload");
        progTxt.setStyle("-fx-font-size: 10px; -fx-text-fill: #94a3b8; -fx-font-weight: bold;");

        box.setOnMouseClicked(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Practice Video");
            fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Video Files", "*.mp4", "*.avi", "*.mkv", "*.mov")
            );
            
            File selectedFile = fileChooser.showOpenDialog(rootContainer.getScene().getWindow());
            
            if (selectedFile != null) {
                txt.setText("Selected: " + selectedFile.getName());
                progTxt.setText("Analyzing Frame 422... 67%");
                progTxt.setStyle("-fx-font-size: 10px; -fx-text-fill: #10b981; -fx-font-weight: bold;");
                progBar.setWidth(140);
            }
        });

        box.getChildren().addAll(icon, txt, barPane, progTxt);
        return box;
    }

    private VBox buildCoachDeskCard() {
        VBox box = new VBox(15);
        box.setPadding(new Insets(20));
        box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 10, 0, 0, 4);");

        Label title = new Label("Coach's Desk");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: #0f172a;");

        VBox quoteBox = new VBox(10);
        quoteBox.setPadding(new Insets(0, 0, 0, 15));
        quoteBox.setStyle("-fx-border-color: #10b981; -fx-border-width: 0 0 0 3;");
        
        Label date = new Label("Oct 24 • Evening Review");
        date.setStyle("-fx-font-size: 11px; -fx-text-fill: #94a3b8;");
        
        Label quote = new Label("\"Vikram, your back-lift is becoming too diagonal. Keep it straight to avoid getting caught at slips on outswingers.\"");
        quote.setWrapText(true);
        quote.setStyle("-fx-font-size: 13px; -fx-font-style: italic; -fx-text-fill: #475569;");

        Label author = new Label("— Coach Sandeep Patil");
        author.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");

        quoteBox.getChildren().addAll(date, quote, author);
        box.getChildren().addAll(title, quoteBox);
        return box;
    }
}