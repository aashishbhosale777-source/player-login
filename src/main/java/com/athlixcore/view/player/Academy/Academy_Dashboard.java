

// package com.athlixcore.view.player.Academy;

// import javafx.geometry.Insets;
// import javafx.geometry.Pos;
// import javafx.scene.Node;
// import javafx.scene.control.Button;
// import javafx.scene.control.CheckBox;
// import javafx.scene.control.ComboBox;
// import javafx.scene.control.Label;
// import javafx.scene.control.ScrollPane;
// import javafx.scene.control.TextField;
// import javafx.scene.image.Image;
// import javafx.scene.image.ImageView;
// import javafx.scene.layout.ColumnConstraints;
// import javafx.scene.layout.FlowPane;
// import javafx.scene.layout.GridPane;
// import javafx.scene.layout.HBox;
// import javafx.scene.layout.Priority;
// import javafx.scene.layout.Region;
// import javafx.scene.layout.StackPane;
// import javafx.scene.layout.VBox;
// import javafx.scene.shape.Circle;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.stream.Collectors;

// public class Academy_Dashboard {

//     private StackPane rootContainer;
//     private FlowPane coachesGrid;
//     private List<Coach> allCoaches;

//     // Static tracker for the purchased coach across views
//     public static String purchasedCoachName = null;

//     // Toggle buttons for "View All Coaches" and "My Coaches"
//     private Button viewAllBtn;
//     private Button myCoachesBtn;
//     private boolean showingMyCoachesOnly = false;

//     public Node getView() {
//         if (rootContainer == null) {
//             rootContainer = new StackPane();
//             initializeDummyData();
//             ScrollPane mainScrollPane = buildMainContent();
//             rootContainer.getChildren().add(mainScrollPane);
//         }
//         return rootContainer;
//     }

//     private ScrollPane buildMainContent() {
//         VBox mainLayout = new VBox(25);
//         mainLayout.setPadding(new Insets(30, 30, 80, 30));
//         mainLayout.setStyle("-fx-background-color: #f8fafc;");

//         // --- 1. HEADER SECTION ---
//         HBox header = new HBox();
//         header.setAlignment(Pos.CENTER_LEFT);

//         VBox titleBox = new VBox(5);
//         Label pageTitle = new Label("🎓 Coaching Academy");
//         pageTitle.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
//         Label pageSubtitle = new Label("Find world-class batting, bowling, fielding, and wicket-keeping coaches near you.");
//         pageSubtitle.setStyle("-fx-font-size: 14px; -fx-text-fill: #64748b;");
//         titleBox.getChildren().addAll(pageTitle, pageSubtitle);

//         header.getChildren().add(titleBox);

//         // --- 2. STATISTICS OVERVIEW BLOCK ---
//         GridPane statsGrid = new GridPane();
//         statsGrid.setHgap(20);
//         statsGrid.setVgap(20);
        
//         ColumnConstraints col1 = new ColumnConstraints();
//         col1.setPercentWidth(50);
//         ColumnConstraints col2 = new ColumnConstraints();
//         col2.setPercentWidth(50);
//         statsGrid.getColumnConstraints().addAll(col1, col2);

//         statsGrid.add(createStatCard("Total Coaches", "42", "🏆", 
//             "-fx-background-color: linear-gradient(to right, #f4f7ff, #eef1ff); -fx-border-color: #e2e8f0;"), 0, 0);
            
//         statsGrid.add(createStatCard("My Bookings", purchasedCoachName != null ? "1 Active" : "0", "📋", 
//             "-fx-background-color: linear-gradient(to right, #f2fcf5, #e6f8ed); -fx-border-color: #d1fae5;"), 1, 0);
            
//         statsGrid.add(createStatCard("Ongoing Sessions", "8", "▶", 
//             "-fx-background-color: linear-gradient(to right, #fdf4ff, #f3e8ff); -fx-border-color: #ede9fe;"), 0, 1);
            
//         statsGrid.add(createStatCard("Completed", "156", "⏱", 
//             "-fx-background-color: linear-gradient(to right, #fffdf2, #fefce8); -fx-border-color: #fef08a;"), 1, 1);


//         // --- 3. REFINE / FILTER BLOCK ---
//         HBox filterBlock = new HBox(20);
//         filterBlock.setAlignment(Pos.BOTTOM_LEFT);
//         filterBlock.setPadding(new Insets(20, 25, 20, 25));
//         filterBlock.setStyle("-fx-background-color: white; -fx-background-radius: 12; -fx-border-color: #e2e8f0; -fx-border-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.05), 10, 0, 0, 4);");

//         VBox specBox = new VBox(8);
//         Label specLbl = new Label("Specialty");
//         specLbl.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-text-fill: #475569;");
//         ComboBox<String> specialtyCombo = new ComboBox<>();
//         specialtyCombo.getItems().addAll("All", "Batting", "Bowling", "Fielding", "Wicket Keeping");
//         specialtyCombo.getSelectionModel().selectFirst();
//         specialtyCombo.setPrefWidth(160);
//         specialtyCombo.setStyle("-fx-background-color: #f8fafc; -fx-border-color: #cbd5e1; -fx-border-radius: 6; -fx-padding: 4; -fx-font-size: 14px;");
//         specBox.getChildren().addAll(specLbl, specialtyCombo);

//         VBox locBox = new VBox(8);
//         Label locLbl = new Label("Current Location");
//         locLbl.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-text-fill: #475569;");
//         TextField locationField = new TextField();
//         locationField.setPromptText("e.g. Pune, Maharashtra");
//         locationField.setPrefWidth(250);
//         locationField.setStyle("-fx-background-color: #f8fafc; -fx-border-color: #cbd5e1; -fx-border-radius: 6; -fx-padding: 8; -fx-font-size: 14px;");
//         locBox.getChildren().addAll(locLbl, locationField);

//         VBox distBox = new VBox(8);
//         Label distLbl = new Label("Distance Around You");
//         distLbl.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-text-fill: #475569;");
//         ComboBox<String> distanceCombo = new ComboBox<>();
//         distanceCombo.getItems().addAll("Any", "100 mtrs", "500 mtrs", "1 km", "5 km");
//         distanceCombo.getSelectionModel().select("100 mtrs");
//         distanceCombo.setPrefWidth(140);
//         distanceCombo.setStyle("-fx-background-color: #f8fafc; -fx-border-color: #cbd5e1; -fx-border-radius: 6; -fx-padding: 4; -fx-font-size: 14px;");
//         distBox.getChildren().addAll(distLbl, distanceCombo);

//         Region spacer = new Region();
//         HBox.setHgrow(spacer, Priority.ALWAYS);

//         Button searchBtn = new Button("🔍 Refine Search");
//         searchBtn.setStyle("-fx-background-color: linear-gradient(to right, #3b82f6, #2563eb); -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 10 24; -fx-background-radius: 8; -fx-cursor: hand; -fx-effect: dropshadow(three-pass-box, rgba(59,130,246,0.3), 6, 0, 0, 2);");
        
//         searchBtn.setOnAction(e -> {
//             filterCoaches(specialtyCombo.getValue(), distanceCombo.getValue());
//         });

//         filterBlock.getChildren().addAll(specBox, locBox, distBox, spacer, searchBtn);

//         // --- 4. SECTION HEADER & TOGGLE BUTTONS ---
//         HBox sectionHeader = new HBox(15);
//         sectionHeader.setAlignment(Pos.CENTER_LEFT);

//         Label sectionTitle = new Label("Recommended for You");
//         sectionTitle.setStyle("-fx-font-weight: bold; -fx-font-size: 20px; -fx-text-fill: #0f172a;");

//         Region headerSpacer = new Region();
//         HBox.setHgrow(headerSpacer, Priority.ALWAYS);

//         HBox toggleBar = new HBox(5);
//         toggleBar.setStyle("-fx-background-color: #e2e8f0; -fx-background-radius: 8; -fx-padding: 3;");

//         viewAllBtn = new Button("View All Coaches");
//         myCoachesBtn = new Button("My Coaches");

//         styleToggleButton(viewAllBtn, true);
//         styleToggleButton(myCoachesBtn, false);

//         viewAllBtn.setOnAction(e -> {
//             showingMyCoachesOnly = false;
//             styleToggleButton(viewAllBtn, true);
//             styleToggleButton(myCoachesBtn, false);
//             filterCoaches(specialtyCombo.getValue(), distanceCombo.getValue());
//         });

//         myCoachesBtn.setOnAction(e -> {
//             showingMyCoachesOnly = true;
//             styleToggleButton(myCoachesBtn, true);
//             styleToggleButton(viewAllBtn, false);
//             filterCoaches(specialtyCombo.getValue(), distanceCombo.getValue());
//         });

//         toggleBar.getChildren().addAll(viewAllBtn, myCoachesBtn);
//         sectionHeader.getChildren().addAll(sectionTitle, headerSpacer, toggleBar);

//         // --- 5. COACHES GRID AREA ---
//         coachesGrid = new FlowPane();
//         coachesGrid.setHgap(25);
//         coachesGrid.setVgap(25);
//         coachesGrid.setAlignment(Pos.TOP_LEFT);

//         filterCoaches("All", "Any");

//         mainLayout.getChildren().addAll(header, statsGrid, filterBlock, sectionHeader, coachesGrid);

//         ScrollPane scrollPane = new ScrollPane(mainLayout);
//         scrollPane.setFitToWidth(true);
//         scrollPane.setStyle("-fx-background-color: transparent; -fx-background: #f8fafc;");
//         scrollPane.getStylesheets().add("data:text/css,.scroll-pane > .viewport { -fx-background-color: transparent; }");

//         return scrollPane;
//     }

//     private void styleToggleButton(Button btn, boolean active) {
//         if (active) {
//             btn.setStyle("-fx-background-color: white; -fx-text-fill: #1e293b; -fx-font-weight: bold; -fx-font-size: 13px; -fx-padding: 8 16; -fx-background-radius: 6; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.08), 5, 0, 0, 1); -fx-cursor: hand;");
//         } else {
//             btn.setStyle("-fx-background-color: transparent; -fx-text-fill: #64748b; -fx-font-weight: bold; -fx-font-size: 13px; -fx-padding: 8 16; -fx-background-radius: 6; -fx-cursor: hand;");
//         }
//     }

//     private HBox createStatCard(String title, String value, String icon, String customStyle) {
//         HBox card = new HBox();
//         card.setAlignment(Pos.CENTER_LEFT);
//         card.setPadding(new Insets(20, 25, 20, 25));
//         card.setMinHeight(100);
//         card.setStyle(customStyle + " -fx-background-radius: 12; -fx-border-radius: 12; -fx-border-width: 1; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 8, 0, 0, 2);");

//         VBox leftContent = new VBox(8);
//         leftContent.setAlignment(Pos.CENTER_LEFT);
//         Label titleLbl = new Label(title);
//         titleLbl.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: #475569;");
//         Label valueLbl = new Label(value);
//         valueLbl.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
//         leftContent.getChildren().addAll(titleLbl, valueLbl);

//         Region spacer = new Region();
//         HBox.setHgrow(spacer, Priority.ALWAYS);

//         Label iconLbl = new Label(icon);
//         iconLbl.setStyle("-fx-font-size: 26px; -fx-text-fill: #1e293b;"); 

//         card.getChildren().addAll(leftContent, spacer, iconLbl);
//         return card;
//     }

//     private void filterCoaches(String specialty, String distanceFilter) {
//         coachesGrid.getChildren().clear();

//         List<Coach> filteredList = allCoaches.stream().filter(c -> {
//             if (showingMyCoachesOnly) {
//                 if (purchasedCoachName == null || !c.name.equals(purchasedCoachName)) {
//                     return false;
//                 }
//             }

//             boolean matchesSpec = specialty.equals("All") || c.specialty.equals(specialty);
//             boolean matchesDist = true;
            
//             if (distanceFilter.equals("100 mtrs") && c.distanceInMeters > 100) {
//                 matchesDist = false;
//             } else if (distanceFilter.equals("500 mtrs") && c.distanceInMeters > 500) {
//                 matchesDist = false;
//             } else if (distanceFilter.equals("1 km") && c.distanceInMeters > 1000) {
//                 matchesDist = false;
//             } else if (distanceFilter.equals("5 km") && c.distanceInMeters > 5000) {
//                 matchesDist = false;
//             }

//             return matchesSpec && matchesDist;
//         }).collect(Collectors.toList());

//         if (filteredList.isEmpty()) {
//             Label noResultLbl = new Label(showingMyCoachesOnly ? "You haven't purchased any coaches yet." : "No coaches found matching your criteria.");
//             noResultLbl.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #94a3b8; -fx-padding: 40;");
//             coachesGrid.getChildren().add(noResultLbl);
//         } else {
//             for (Coach coach : filteredList) {
//                 coachesGrid.getChildren().add(createCoachCard(coach));
//             }
//         }
//     }

//     private VBox createCoachCard(Coach coach) {
//         boolean isPurchased = (purchasedCoachName != null && purchasedCoachName.equals(coach.name));

//         VBox card = new VBox(12);
//         card.setAlignment(Pos.TOP_CENTER);
//         card.setPadding(new Insets(25, 20, 25, 20));
//         card.setPrefWidth(260);
        
//         if (isPurchased) {
//             card.setStyle("-fx-background-color: #f0fdf4; -fx-background-radius: 12; -fx-border-color: #10b981; -fx-border-width: 2; -fx-border-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(16,185,129,0.25), 12, 0, 0, 4);");
//         } else {
//             card.setStyle("-fx-background-color: white; -fx-background-radius: 12; -fx-border-color: #e2e8f0; -fx-border-radius: 12;");
//         }

//         // Avatar
//         ImageView avatar = new ImageView();
//         try { 
//             Image img = new Image(coach.avatarUrl, 80, 80, true, true, true); 
//             avatar.setImage(img); 
//         } catch (Exception e) {}
//         avatar.setFitWidth(80);
//         avatar.setFitHeight(80);
//         avatar.setClip(new Circle(40, 40, 40));
//         avatar.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0, 0, 4);");

//         // Name & Purchased Tag
//         Label nameLbl = new Label(coach.name);
//         nameLbl.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");

//         VBox cardHeaderBox = new VBox(4, nameLbl);
//         cardHeaderBox.setAlignment(Pos.CENTER);

//         if (isPurchased) {
//             Label purchasedBadge = new Label("✓ PURCHASED COACH");
//             purchasedBadge.setStyle("-fx-background-color: #d1fae5; -fx-text-fill: #065f46; -fx-font-size: 10px; -fx-font-weight: bold; -fx-padding: 3 8; -fx-background-radius: 10;");
//             cardHeaderBox.getChildren().add(purchasedBadge);
//         }

//         // Specialty Badge
//         Label specBadge = new Label(coach.specialty);
//         switch (coach.specialty) {
//             case "Batting":
//                 specBadge.setStyle("-fx-background-color: #dbeafe; -fx-text-fill: #1d4ed8; -fx-font-size: 11px; -fx-font-weight: bold; -fx-padding: 4 10; -fx-background-radius: 12;");
//                 break;
//             case "Bowling":
//                 specBadge.setStyle("-fx-background-color: #dcfce7; -fx-text-fill: #15803d; -fx-font-size: 11px; -fx-font-weight: bold; -fx-padding: 4 10; -fx-background-radius: 12;");
//                 break;
//             case "Fielding":
//                 specBadge.setStyle("-fx-background-color: #fef9c3; -fx-text-fill: #a16207; -fx-font-size: 11px; -fx-font-weight: bold; -fx-padding: 4 10; -fx-background-radius: 12;");
//                 break;
//             case "Wicket Keeping":
//                 specBadge.setStyle("-fx-background-color: #f3e8ff; -fx-text-fill: #7e22ce; -fx-font-size: 11px; -fx-font-weight: bold; -fx-padding: 4 10; -fx-background-radius: 12;");
//                 break;
//         }

//         Label locLbl = new Label("📍 " + coach.distanceText + " away");
//         locLbl.setStyle("-fx-font-size: 13px; -fx-text-fill: #64748b;");

//         Label ratingLbl = new Label("⭐ " + coach.rating + " / 5.0");
//         ratingLbl.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-text-fill: #f59e0b;");

//         // Action Button
//         Button actionBtn = new Button(isPurchased ? "Manage Sessions" : "View Profile");
//         actionBtn.setMaxWidth(Double.MAX_VALUE);
        
//         String btnDefaultStyle = isPurchased ? 
//             "-fx-background-color: linear-gradient(to right, #10b981, #059669); -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 10 20; -fx-background-radius: 8; -fx-cursor: hand; -fx-effect: dropshadow(three-pass-box, rgba(16,185,129,0.4), 8, 0, 0, 4);" :
//             "-fx-background-color: linear-gradient(to right, #6366f1, #8b5cf6); -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 10 20; -fx-background-radius: 8; -fx-cursor: hand; -fx-effect: dropshadow(three-pass-box, rgba(99,102,241,0.4), 8, 0, 0, 4);";
            
//         actionBtn.setStyle(btnDefaultStyle);

//         actionBtn.setOnAction(e -> {
//             if (isPurchased) {
//                 // If purchased, clicking "Manage Sessions" opens the Daily Tasks view
//                 rootContainer.getChildren().setAll(buildDailyTasksView(coach));
//             } else {
//                 // Otherwise, opens the normal profile view
//                 Coach_Discovery profilePage = new Coach_Discovery(
//                     coach.name, 
//                     coach.specialty, 
//                     coach.distanceText, 
//                     coach.rating, 
//                     coach.avatarUrl,
//                     () -> {
//                         rootContainer.getChildren().setAll(buildMainContent()); 
//                     }
//                 );
//                 rootContainer.getChildren().setAll(profilePage.getView());
//             }
//         });

//         card.getChildren().addAll(avatar, cardHeaderBox, specBadge, locLbl, ratingLbl, new Region(), actionBtn);
//         return card;
//     }

//     // --- DAILY TASKS & TRAINING SCHEDULE VIEW ---
//     private Node buildDailyTasksView(Coach coach) {
//         VBox container = new VBox(25);
//         container.setPadding(new Insets(30, 40, 80, 40));
//         container.setStyle("-fx-background-color: #f8fafc;");

//         // Top Navigation Bar (Back & View Profile Buttons)
//         HBox topNav = new HBox(15);
//         topNav.setAlignment(Pos.CENTER_LEFT);

//         Button backBtn = new Button("❮ Back to Academy");
//         backBtn.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #3b82f6; -fx-font-weight: bold; -fx-font-size: 14px; -fx-padding: 8 18; -fx-background-radius: 20; -fx-border-color: #e2e8f0; -fx-border-radius: 20; -fx-cursor: hand;");
//         backBtn.setOnAction(e -> rootContainer.getChildren().setAll(buildMainContent()));

//         Button viewProfileBtn = new Button("👤 View Coach Profile");
//         viewProfileBtn.setStyle("-fx-background-color: #f1f5f9; -fx-text-fill: #0f172a; -fx-font-weight: bold; -fx-font-size: 14px; -fx-padding: 8 18; -fx-background-radius: 20; -fx-border-color: #cbd5e1; -fx-border-radius: 20; -fx-cursor: hand;");
//         viewProfileBtn.setOnAction(e -> {
//             Coach_Discovery profilePage = new Coach_Discovery(
//                 coach.name, coach.specialty, coach.distanceText, coach.rating, coach.avatarUrl,
//                 () -> rootContainer.getChildren().setAll(buildDailyTasksView(coach))
//             );
//             rootContainer.getChildren().setAll(profilePage.getView());
//         });

//         Region navSpacer = new Region();
//         HBox.setHgrow(navSpacer, Priority.ALWAYS);
//         topNav.getChildren().addAll(backBtn, navSpacer, viewProfileBtn);

//         // Header Banner for Daily Tasks
//         VBox banner = new VBox(10);
//         banner.setPadding(new Insets(30));
//         banner.setStyle("-fx-background-color: linear-gradient(to right, #0f172a, #1e293b); -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(15,23,42,0.2), 15, 0, 0, 5);");
        
//         Label badge = new Label("ACTIVE TRAINING PROGRAM");
//         badge.setStyle("-fx-background-color: #1e293b; -fx-text-fill: #10b981; -fx-font-weight: bold; -fx-font-size: 11px; -fx-padding: 4 10; -fx-background-radius: 8;");
        
//         Label title = new Label("Daily Tasks & Schedule with " + coach.name);
//         title.setStyle("-fx-text-fill: white; -fx-font-size: 26px; -fx-font-weight: bold;");
        
//         Label subtitle = new Label("Complete your daily milestones below to maintain peak performance and track progress.");
//         subtitle.setStyle("-fx-text-fill: #94a3b8; -fx-font-size: 14px;");
        
//         banner.getChildren().addAll(badge, title, subtitle);

//         // Task Cards List Container
//         VBox taskList = new VBox(15);
//         taskList.getChildren().addAll(
//             createTaskCard("🌅 Morning Warmup & Mobility", "15 minutes dynamic stretching, shoulder rotations, and core activation.", "08:00 AM", true),
//             createTaskCard("🏏 Technical Net Practice", "Focus on defensive stance and power hitting against off-spin deliveries (50 balls).", "10:30 AM", false),
//             createTaskCard("💪 Strength & Conditioning", "Lower body focus: Squats (3 sets x 12 reps), lunges, and agility ladder drills.", "04:00 PM", false),
//             createTaskCard("📊 Video Analysis & Review", "Review match footage with " + coach.name + " to analyze trigger movements.", "07:00 PM", false)
//         );

//         container.getChildren().addAll(topNav, banner, taskList);

//         ScrollPane scrollPane = new ScrollPane(container);
//         scrollPane.setFitToWidth(true);
//         scrollPane.setStyle("-fx-background-color: transparent; -fx-background: #f8fafc;");
//         scrollPane.getStylesheets().add("data:text/css,.scroll-pane > .viewport { -fx-background-color: transparent; }");

//         return scrollPane;
//     }

//     private HBox createTaskCard(String taskTitle, String taskDesc, String timeSlot, boolean isCompleted) {
//         HBox card = new HBox(20);
//         card.setAlignment(Pos.CENTER_LEFT);
//         card.setPadding(new Insets(20, 25, 20, 25));
//         card.setStyle("-fx-background-color: white; -fx-background-radius: 12; -fx-border-color: #e2e8f0; -fx-border-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 8, 0, 0, 2);");

//         CheckBox checkBox = new CheckBox();
//         checkBox.setSelected(isCompleted);
//         checkBox.setStyle("-fx-cursor: hand; -fx-font-size: 16px;");

//         VBox textContent = new VBox(4);
//         HBox.setHgrow(textContent, Priority.ALWAYS);
        
//         Label titleLbl = new Label(taskTitle);
//         titleLbl.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
        
//         Label descLbl = new Label(taskDesc);
//         descLbl.setStyle("-fx-font-size: 13px; -fx-text-fill: #64748b;");
//         descLbl.setWrapText(true);
        
//         textContent.getChildren().addAll(titleLbl, descLbl);

//         Label timeLbl = new Label("⏰ " + timeSlot);
//         timeLbl.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #10b981; -fx-background-color: #d1fae5; -fx-padding: 5 10; -fx-background-radius: 8;");

//         card.getChildren().addAll(checkBox, textContent, timeLbl);
//         return card;
//     }

//     private void initializeDummyData() {
//         allCoaches = new ArrayList<>();
//         allCoaches.add(new Coach("Rahul Dravid", "Batting", "80 mtrs", 80, 4.9, "https://randomuser.me/api/portraits/men/32.jpg"));
//         allCoaches.add(new Coach("Zaheer Khan", "Bowling", "95 mtrs", 95, 4.8, "https://randomuser.me/api/portraits/men/46.jpg"));
//         allCoaches.add(new Coach("MS Dhoni", "Wicket Keeping", "50 mtrs", 50, 5.0, "https://randomuser.me/api/portraits/men/22.jpg"));
//         allCoaches.add(new Coach("Rishabh Pant", "Wicket Keeping", "90 mtrs", 90, 4.8, "https://randomuser.me/api/portraits/men/75.jpg"));
//         allCoaches.add(new Coach("Mohammad Kaif", "Fielding", "150 mtrs", 150, 4.7, "https://randomuser.me/api/portraits/men/55.jpg"));
//         allCoaches.add(new Coach("Jasprit Bumrah", "Bowling", "300 mtrs", 300, 4.6, "https://randomuser.me/api/portraits/men/60.jpg"));
//         allCoaches.add(new Coach("Virat Kohli", "Batting", "1.2 km", 1200, 4.9, "https://randomuser.me/api/portraits/men/15.jpg"));
//         allCoaches.add(new Coach("Ravindra Jadeja", "Fielding", "2 km", 2000, 4.9, "https://randomuser.me/api/portraits/men/85.jpg"));
//     }

//     private static class Coach {
//         String name;
//         String specialty;
//         String distanceText;
//         int distanceInMeters;
//         double rating;
//         String avatarUrl;

//         public Coach(String name, String specialty, String distanceText, int distanceInMeters, double rating, String avatarUrl) {
//             this.name = name;
//             this.specialty = specialty;
//             this.distanceText = distanceText;
//             this.distanceInMeters = distanceInMeters;
//             this.rating = rating;
//             this.avatarUrl = avatarUrl;
//         }
//     }
// }

package com.athlixcore.view.player.Academy;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Academy_Dashboard {

    private StackPane rootContainer;
    private FlowPane coachesGrid;
    private List<Coach> allCoaches;

    // Static tracker for the purchased coach across views
    public static String purchasedCoachName = null;

    // Toggle buttons for "View All Coaches" and "My Coaches"
    private Button viewAllBtn;
    private Button myCoachesBtn;
    private boolean showingMyCoachesOnly = false;

    public Node getView() {
        if (rootContainer == null) {
            rootContainer = new StackPane();
            initializeDummyData();
            ScrollPane mainScrollPane = buildMainContent();
            rootContainer.getChildren().add(mainScrollPane);
        }
        return rootContainer;
    }

    // Helper for smooth view switching
    private void switchView(Node newView) {
        newView.setOpacity(0);
        rootContainer.getChildren().setAll(newView);
        FadeTransition ft = new FadeTransition(Duration.millis(300), newView);
        ft.setToValue(1.0);
        ft.play();
    }

    private ScrollPane buildMainContent() {
        VBox mainLayout = new VBox(25);
        mainLayout.setPadding(new Insets(30, 30, 80, 30));
        mainLayout.setStyle("-fx-background-color: #f8fafc;");

        // --- 1. HEADER SECTION ---
        HBox header = new HBox();
        header.setAlignment(Pos.CENTER_LEFT);

        VBox titleBox = new VBox(5);
        Label pageTitle = new Label("🎓 Coaching Academy");
        pageTitle.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
        Label pageSubtitle = new Label("Find world-class batting, bowling, fielding, and wicket-keeping coaches near you.");
        pageSubtitle.setStyle("-fx-font-size: 14px; -fx-text-fill: #64748b;");
        titleBox.getChildren().addAll(pageTitle, pageSubtitle);

        header.getChildren().add(titleBox);

        // --- 2. STATISTICS OVERVIEW BLOCK ---
        GridPane statsGrid = new GridPane();
        statsGrid.setHgap(20);
        statsGrid.setVgap(20);
        
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(50);
        statsGrid.getColumnConstraints().addAll(col1, col2);

        statsGrid.add(createStatCard("Total Coaches", "42", "🏆", 
            "-fx-background-color: linear-gradient(to right, #f4f7ff, #eef1ff); -fx-border-color: #e2e8f0;"), 0, 0);
            
        statsGrid.add(createStatCard("My Bookings", purchasedCoachName != null ? "1 Active" : "0", "📋", 
            "-fx-background-color: linear-gradient(to right, #f2fcf5, #e6f8ed); -fx-border-color: #d1fae5;"), 1, 0);
            
        statsGrid.add(createStatCard("Ongoing Sessions", "8", "▶", 
            "-fx-background-color: linear-gradient(to right, #fdf4ff, #f3e8ff); -fx-border-color: #ede9fe;"), 0, 1);
            
        statsGrid.add(createStatCard("Completed", "156", "⏱", 
            "-fx-background-color: linear-gradient(to right, #fffdf2, #fefce8); -fx-border-color: #fef08a;"), 1, 1);

        // --- 3. REFINE / FILTER BLOCK ---
        HBox filterBlock = new HBox(20);
        filterBlock.setAlignment(Pos.BOTTOM_LEFT);
        filterBlock.setPadding(new Insets(20, 25, 20, 25));
        filterBlock.setStyle("-fx-background-color: white; -fx-background-radius: 12; -fx-border-color: #e2e8f0; -fx-border-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.05), 10, 0, 0, 4);");

        VBox specBox = new VBox(8);
        Label specLbl = new Label("Specialty");
        specLbl.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-text-fill: #475569;");
        ComboBox<String> specialtyCombo = new ComboBox<>();
        specialtyCombo.getItems().addAll("All", "Batting", "Bowling", "Fielding", "Wicket Keeping");
        specialtyCombo.getSelectionModel().selectFirst();
        specialtyCombo.setPrefWidth(160);
        specialtyCombo.setStyle("-fx-background-color: #f8fafc; -fx-border-color: #cbd5e1; -fx-border-radius: 6; -fx-padding: 4; -fx-font-size: 14px;");
        specBox.getChildren().addAll(specLbl, specialtyCombo);

        VBox locBox = new VBox(8);
        Label locLbl = new Label("Current Location");
        locLbl.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-text-fill: #475569;");
        TextField locationField = new TextField();
        locationField.setPromptText("e.g. Pune, Maharashtra");
        locationField.setPrefWidth(250);
        locationField.setStyle("-fx-background-color: #f8fafc; -fx-border-color: #cbd5e1; -fx-border-radius: 6; -fx-padding: 8; -fx-font-size: 14px;");
        locBox.getChildren().addAll(locLbl, locationField);

        VBox distBox = new VBox(8);
        Label distLbl = new Label("Distance Around You");
        distLbl.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-text-fill: #475569;");
        ComboBox<String> distanceCombo = new ComboBox<>();
        distanceCombo.getItems().addAll("Any", "100 mtrs", "500 mtrs", "1 km", "5 km");
        distanceCombo.getSelectionModel().select("100 mtrs");
        distanceCombo.setPrefWidth(140);
        distanceCombo.setStyle("-fx-background-color: #f8fafc; -fx-border-color: #cbd5e1; -fx-border-radius: 6; -fx-padding: 4; -fx-font-size: 14px;");
        distBox.getChildren().addAll(distLbl, distanceCombo);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Button searchBtn = new Button("🔍 Refine Search");
        searchBtn.setStyle("-fx-background-color: linear-gradient(to right, #3b82f6, #2563eb); -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 10 24; -fx-background-radius: 8; -fx-cursor: hand; -fx-effect: dropshadow(three-pass-box, rgba(59,130,246,0.3), 6, 0, 0, 2);");
        
        searchBtn.setOnAction(e -> {
            filterCoaches(specialtyCombo.getValue(), distanceCombo.getValue());
        });

        filterBlock.getChildren().addAll(specBox, locBox, distBox, spacer, searchBtn);

        // --- 4. SECTION HEADER & TOGGLE BUTTONS ---
        HBox sectionHeader = new HBox(15);
        sectionHeader.setAlignment(Pos.CENTER_LEFT);

        Label sectionTitle = new Label("Recommended for You");
        sectionTitle.setStyle("-fx-font-weight: bold; -fx-font-size: 20px; -fx-text-fill: #0f172a;");

        Region headerSpacer = new Region();
        HBox.setHgrow(headerSpacer, Priority.ALWAYS);

        HBox toggleBar = new HBox(5);
        toggleBar.setStyle("-fx-background-color: #e2e8f0; -fx-background-radius: 8; -fx-padding: 3;");

        viewAllBtn = new Button("View All Coaches");
        myCoachesBtn = new Button("My Coaches");

        styleToggleButton(viewAllBtn, true);
        styleToggleButton(myCoachesBtn, false);

        viewAllBtn.setOnAction(e -> {
            showingMyCoachesOnly = false;
            styleToggleButton(viewAllBtn, true);
            styleToggleButton(myCoachesBtn, false);
            filterCoaches(specialtyCombo.getValue(), distanceCombo.getValue());
        });

        myCoachesBtn.setOnAction(e -> {
            showingMyCoachesOnly = true;
            styleToggleButton(myCoachesBtn, true);
            styleToggleButton(viewAllBtn, false);
            filterCoaches(specialtyCombo.getValue(), distanceCombo.getValue());
        });

        toggleBar.getChildren().addAll(viewAllBtn, myCoachesBtn);
        sectionHeader.getChildren().addAll(sectionTitle, headerSpacer, toggleBar);

        // --- 5. COACHES GRID AREA ---
        coachesGrid = new FlowPane();
        coachesGrid.setHgap(25);
        coachesGrid.setVgap(25);
        coachesGrid.setAlignment(Pos.TOP_LEFT);

        filterCoaches("All", "Any");

        mainLayout.getChildren().addAll(header, statsGrid, filterBlock, sectionHeader, coachesGrid);

        ScrollPane scrollPane = new ScrollPane(mainLayout);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color: transparent; -fx-background: #f8fafc;");
        scrollPane.getStylesheets().add("data:text/css,.scroll-pane > .viewport { -fx-background-color: transparent; }");

        return scrollPane;
    }

    private void styleToggleButton(Button btn, boolean active) {
        if (active) {
            btn.setStyle("-fx-background-color: white; -fx-text-fill: #1e293b; -fx-font-weight: bold; -fx-font-size: 13px; -fx-padding: 8 16; -fx-background-radius: 6; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.08), 5, 0, 0, 1); -fx-cursor: hand;");
        } else {
            btn.setStyle("-fx-background-color: transparent; -fx-text-fill: #64748b; -fx-font-weight: bold; -fx-font-size: 13px; -fx-padding: 8 16; -fx-background-radius: 6; -fx-cursor: hand;");
        }
    }

    private HBox createStatCard(String title, String value, String icon, String customStyle) {
        HBox card = new HBox();
        card.setAlignment(Pos.CENTER_LEFT);
        card.setPadding(new Insets(20, 25, 20, 25));
        card.setMinHeight(100);
        card.setStyle(customStyle + " -fx-background-radius: 12; -fx-border-radius: 12; -fx-border-width: 1; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 8, 0, 0, 2);");

        addHoverScale(card); // Add hover animation

        VBox leftContent = new VBox(8);
        leftContent.setAlignment(Pos.CENTER_LEFT);
        Label titleLbl = new Label(title);
        titleLbl.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: #475569;");
        Label valueLbl = new Label(value);
        valueLbl.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
        leftContent.getChildren().addAll(titleLbl, valueLbl);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Label iconLbl = new Label(icon);
        iconLbl.setStyle("-fx-font-size: 26px; -fx-text-fill: #1e293b;"); 

        card.getChildren().addAll(leftContent, spacer, iconLbl);
        return card;
    }

    private void filterCoaches(String specialty, String distanceFilter) {
        coachesGrid.getChildren().clear();

        List<Coach> filteredList = allCoaches.stream().filter(c -> {
            if (showingMyCoachesOnly) {
                if (purchasedCoachName == null || !c.name.equals(purchasedCoachName)) {
                    return false;
                }
            }

            boolean matchesSpec = specialty.equals("All") || c.specialty.equals(specialty);
            boolean matchesDist = true;
            
            if (distanceFilter.equals("100 mtrs") && c.distanceInMeters > 100) {
                matchesDist = false;
            } else if (distanceFilter.equals("500 mtrs") && c.distanceInMeters > 500) {
                matchesDist = false;
            } else if (distanceFilter.equals("1 km") && c.distanceInMeters > 1000) {
                matchesDist = false;
            } else if (distanceFilter.equals("5 km") && c.distanceInMeters > 5000) {
                matchesDist = false;
            }

            return matchesSpec && matchesDist;
        }).collect(Collectors.toList());

        if (filteredList.isEmpty()) {
            Label noResultLbl = new Label(showingMyCoachesOnly ? "You haven't purchased any coaches yet." : "No coaches found matching your criteria.");
            noResultLbl.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #94a3b8; -fx-padding: 40;");
            coachesGrid.getChildren().add(noResultLbl);
        } else {
            // Apply cascading slide and fade animation to coach cards
            int delay = 0;
            for (Coach coach : filteredList) {
                VBox card = createCoachCard(coach);
                card.setOpacity(0);
                card.setTranslateY(20);
                coachesGrid.getChildren().add(card);

                FadeTransition ft = new FadeTransition(Duration.millis(400), card);
                ft.setToValue(1.0);
                TranslateTransition tt = new TranslateTransition(Duration.millis(400), card);
                tt.setToY(0);

                ParallelTransition pt = new ParallelTransition(ft, tt);
                pt.setDelay(Duration.millis(delay));
                pt.play();
                
                delay += 50; // cascade effect
            }
        }
    }

    private VBox createCoachCard(Coach coach) {
        boolean isPurchased = (purchasedCoachName != null && purchasedCoachName.equals(coach.name));

        VBox card = new VBox(12);
        card.setAlignment(Pos.TOP_CENTER);
        card.setPadding(new Insets(25, 20, 25, 20));
        card.setPrefWidth(260);
        
        if (isPurchased) {
            card.setStyle("-fx-background-color: #f0fdf4; -fx-background-radius: 12; -fx-border-color: #10b981; -fx-border-width: 2; -fx-border-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(16,185,129,0.25), 12, 0, 0, 4);");
        } else {
            card.setStyle("-fx-background-color: white; -fx-background-radius: 12; -fx-border-color: #e2e8f0; -fx-border-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.02), 10, 0, 0, 2);");
        }

        addHoverScale(card); // Add hover animation

        // Avatar
        ImageView avatar = new ImageView();
        try { 
            Image img = new Image(coach.avatarUrl, 80, 80, true, true, true); 
            avatar.setImage(img); 
        } catch (Exception e) {}
        avatar.setFitWidth(80);
        avatar.setFitHeight(80);
        avatar.setClip(new Circle(40, 40, 40));
        avatar.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0, 0, 4);");

        // Name & Purchased Tag
        Label nameLbl = new Label(coach.name);
        nameLbl.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");

        VBox cardHeaderBox = new VBox(4, nameLbl);
        cardHeaderBox.setAlignment(Pos.CENTER);

        if (isPurchased) {
            Label purchasedBadge = new Label("✓ PURCHASED COACH");
            purchasedBadge.setStyle("-fx-background-color: #d1fae5; -fx-text-fill: #065f46; -fx-font-size: 10px; -fx-font-weight: bold; -fx-padding: 3 8; -fx-background-radius: 10;");
            cardHeaderBox.getChildren().add(purchasedBadge);
        }

        // Specialty Badge
        Label specBadge = new Label(coach.specialty);
        switch (coach.specialty) {
            case "Batting":
                specBadge.setStyle("-fx-background-color: #dbeafe; -fx-text-fill: #1d4ed8; -fx-font-size: 11px; -fx-font-weight: bold; -fx-padding: 4 10; -fx-background-radius: 12;");
                break;
            case "Bowling":
                specBadge.setStyle("-fx-background-color: #dcfce7; -fx-text-fill: #15803d; -fx-font-size: 11px; -fx-font-weight: bold; -fx-padding: 4 10; -fx-background-radius: 12;");
                break;
            case "Fielding":
                specBadge.setStyle("-fx-background-color: #fef9c3; -fx-text-fill: #a16207; -fx-font-size: 11px; -fx-font-weight: bold; -fx-padding: 4 10; -fx-background-radius: 12;");
                break;
            case "Wicket Keeping":
                specBadge.setStyle("-fx-background-color: #f3e8ff; -fx-text-fill: #7e22ce; -fx-font-size: 11px; -fx-font-weight: bold; -fx-padding: 4 10; -fx-background-radius: 12;");
                break;
        }

        Label locLbl = new Label("📍 " + coach.distanceText + " away");
        locLbl.setStyle("-fx-font-size: 13px; -fx-text-fill: #64748b;");

        Label ratingLbl = new Label("⭐ " + coach.rating + " / 5.0");
        ratingLbl.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-text-fill: #f59e0b;");

        // Action Button
        Button actionBtn = new Button(isPurchased ? "Manage Sessions" : "View Profile");
        actionBtn.setMaxWidth(Double.MAX_VALUE);
        
        String btnDefaultStyle = isPurchased ? 
            "-fx-background-color: linear-gradient(to right, #10b981, #059669); -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 10 20; -fx-background-radius: 8; -fx-cursor: hand; -fx-effect: dropshadow(three-pass-box, rgba(16,185,129,0.4), 8, 0, 0, 4);" :
            "-fx-background-color: linear-gradient(to right, #6366f1, #8b5cf6); -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 10 20; -fx-background-radius: 8; -fx-cursor: hand; -fx-effect: dropshadow(three-pass-box, rgba(99,102,241,0.4), 8, 0, 0, 4);";
            
        actionBtn.setStyle(btnDefaultStyle);

        actionBtn.setOnAction(e -> {
            if (isPurchased) {
                switchView(buildDailyTasksView(coach));
            } else {
                Coach_Discovery profilePage = new Coach_Discovery(
                    coach.name, 
                    coach.specialty, 
                    coach.distanceText, 
                    coach.rating, 
                    coach.avatarUrl,
                    () -> switchView(buildMainContent()) 
                );
                switchView(profilePage.getView());
            }
        });

        card.getChildren().addAll(avatar, cardHeaderBox, specBadge, locLbl, ratingLbl, new Region(), actionBtn);
        return card;
    }

    // --- DAILY TASKS & TRAINING SCHEDULE VIEW ---
    private Node buildDailyTasksView(Coach coach) {
        VBox container = new VBox(25);
        container.setPadding(new Insets(30, 40, 80, 40));
        container.setStyle("-fx-background-color: #f8fafc;");

        // Top Navigation Bar
        HBox topNav = new HBox(15);
        topNav.setAlignment(Pos.CENTER_LEFT);

        Button backBtn = new Button("❮ Back to Academy");
        backBtn.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #3b82f6; -fx-font-weight: bold; -fx-font-size: 14px; -fx-padding: 8 18; -fx-background-radius: 20; -fx-border-color: #e2e8f0; -fx-border-radius: 20; -fx-cursor: hand;");
        backBtn.setOnAction(e -> switchView(buildMainContent()));

        Button viewProfileBtn = new Button("👤 View Coach Profile");
        viewProfileBtn.setStyle("-fx-background-color: #f1f5f9; -fx-text-fill: #0f172a; -fx-font-weight: bold; -fx-font-size: 14px; -fx-padding: 8 18; -fx-background-radius: 20; -fx-border-color: #cbd5e1; -fx-border-radius: 20; -fx-cursor: hand;");
        viewProfileBtn.setOnAction(e -> {
            Coach_Discovery profilePage = new Coach_Discovery(
                coach.name, coach.specialty, coach.distanceText, coach.rating, coach.avatarUrl,
                () -> switchView(buildDailyTasksView(coach))
            );
            switchView(profilePage.getView());
        });

        Region navSpacer = new Region();
        HBox.setHgrow(navSpacer, Priority.ALWAYS);
        topNav.getChildren().addAll(backBtn, navSpacer, viewProfileBtn);

        // Header Banner for Daily Tasks
        VBox banner = new VBox(10);
        banner.setPadding(new Insets(30));
        banner.setStyle("-fx-background-color: linear-gradient(to right, #0f172a, #1e293b); -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(15,23,42,0.2), 15, 0, 0, 5);");
        
        Label badge = new Label("ACTIVE TRAINING PROGRAM");
        badge.setStyle("-fx-background-color: #1e293b; -fx-text-fill: #10b981; -fx-font-weight: bold; -fx-font-size: 11px; -fx-padding: 4 10; -fx-background-radius: 8;");
        
        Label title = new Label("Daily Tasks & Schedule with " + coach.name);
        title.setStyle("-fx-text-fill: white; -fx-font-size: 26px; -fx-font-weight: bold;");
        
        Label subtitle = new Label("Complete your daily milestones below to maintain peak performance and track progress.");
        subtitle.setStyle("-fx-text-fill: #94a3b8; -fx-font-size: 14px;");
        
        banner.getChildren().addAll(badge, title, subtitle);

        // Task Cards List Container
        VBox taskList = new VBox(15);
        Node[] tasks = {
            createTaskCard("🌅 Morning Warmup & Mobility", "15 minutes dynamic stretching, shoulder rotations, and core activation.", "08:00 AM", true),
            createTaskCard("🏏 Technical Net Practice", "Focus on defensive stance and power hitting against off-spin deliveries (50 balls).", "10:30 AM", false),
            createTaskCard("💪 Strength & Conditioning", "Lower body focus: Squats (3 sets x 12 reps), lunges, and agility ladder drills.", "04:00 PM", false),
            createTaskCard("📊 Video Analysis & Review", "Review match footage with " + coach.name + " to analyze trigger movements.", "07:00 PM", false)
        };

        // Animate tasks sliding in
        int delay = 0;
        for (Node task : tasks) {
            task.setOpacity(0);
            task.setTranslateX(-20);
            taskList.getChildren().add(task);

            FadeTransition ft = new FadeTransition(Duration.millis(400), task);
            ft.setToValue(1.0);
            TranslateTransition tt = new TranslateTransition(Duration.millis(400), task);
            tt.setToX(0);

            ParallelTransition pt = new ParallelTransition(ft, tt);
            pt.setDelay(Duration.millis(delay));
            pt.play();
            delay += 100;
        }

        container.getChildren().addAll(topNav, banner, taskList);

        ScrollPane scrollPane = new ScrollPane(container);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color: transparent; -fx-background: #f8fafc;");
        scrollPane.getStylesheets().add("data:text/css,.scroll-pane > .viewport { -fx-background-color: transparent; }");

        return scrollPane;
    }

    private HBox createTaskCard(String taskTitle, String taskDesc, String timeSlot, boolean isCompleted) {
        HBox card = new HBox(20);
        card.setAlignment(Pos.CENTER_LEFT);
        card.setPadding(new Insets(20, 25, 20, 25));
        card.setStyle("-fx-background-color: white; -fx-background-radius: 12; -fx-border-color: #e2e8f0; -fx-border-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 8, 0, 0, 2);");

        addHoverScale(card); // Add hover animation

        CheckBox checkBox = new CheckBox();
        checkBox.setSelected(isCompleted);
        checkBox.setStyle("-fx-cursor: hand; -fx-font-size: 16px;");

        VBox textContent = new VBox(4);
        HBox.setHgrow(textContent, Priority.ALWAYS);
        
        Label titleLbl = new Label(taskTitle);
        titleLbl.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
        
        Label descLbl = new Label(taskDesc);
        descLbl.setStyle("-fx-font-size: 13px; -fx-text-fill: #64748b;");
        descLbl.setWrapText(true);
        
        textContent.getChildren().addAll(titleLbl, descLbl);

        Label timeLbl = new Label("⏰ " + timeSlot);
        timeLbl.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #10b981; -fx-background-color: #d1fae5; -fx-padding: 5 10; -fx-background-radius: 8;");

        card.getChildren().addAll(checkBox, textContent, timeLbl);
        return card;
    }

    // Hover Animation Helper
    private void addHoverScale(Node node) {
        ScaleTransition scaleIn = new ScaleTransition(Duration.millis(150), node);
        scaleIn.setToX(1.02); 
        scaleIn.setToY(1.02);
        
        ScaleTransition scaleOut = new ScaleTransition(Duration.millis(150), node);
        scaleOut.setToX(1.0); 
        scaleOut.setToY(1.0);

        node.setOnMouseEntered(e -> scaleIn.playFromStart());
        node.setOnMouseExited(e -> scaleOut.playFromStart());
    }

    private void initializeDummyData() {
        allCoaches = new ArrayList<>();
        allCoaches.add(new Coach("Rahul Dravid", "Batting", "80 mtrs", 80, 4.9, "https://randomuser.me/api/portraits/men/32.jpg"));
        allCoaches.add(new Coach("Zaheer Khan", "Bowling", "95 mtrs", 95, 4.8, "https://randomuser.me/api/portraits/men/46.jpg"));
        allCoaches.add(new Coach("MS Dhoni", "Wicket Keeping", "50 mtrs", 50, 5.0, "https://randomuser.me/api/portraits/men/22.jpg"));
        allCoaches.add(new Coach("Rishabh Pant", "Wicket Keeping", "90 mtrs", 90, 4.8, "https://randomuser.me/api/portraits/men/75.jpg"));
        allCoaches.add(new Coach("Mohammad Kaif", "Fielding", "150 mtrs", 150, 4.7, "https://randomuser.me/api/portraits/men/55.jpg"));
        allCoaches.add(new Coach("Jasprit Bumrah", "Bowling", "300 mtrs", 300, 4.6, "https://randomuser.me/api/portraits/men/60.jpg"));
        allCoaches.add(new Coach("Virat Kohli", "Batting", "1.2 km", 1200, 4.9, "https://randomuser.me/api/portraits/men/15.jpg"));
        allCoaches.add(new Coach("Ravindra Jadeja", "Fielding", "2 km", 2000, 4.9, "https://randomuser.me/api/portraits/men/85.jpg"));
    }

    private static class Coach {
        String name;
        String specialty;
        String distanceText;
        int distanceInMeters;
        double rating;
        String avatarUrl;

        public Coach(String name, String specialty, String distanceText, int distanceInMeters, double rating, String avatarUrl) {
            this.name = name;
            this.specialty = specialty;
            this.distanceText = distanceText;
            this.distanceInMeters = distanceInMeters;
            this.rating = rating;
            this.avatarUrl = avatarUrl;
        }
    }
}