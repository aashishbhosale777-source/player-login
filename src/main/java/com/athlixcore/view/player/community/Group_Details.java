

package com.athlixcore.view.player.community;

import com.athlixcore.view.player.Player_Profile; 
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Group_Details extends VBox {

    private BorderPane mainLayout;
    private HBox tabsBox;
    private VBox contentArea;

    public Group_Details(BorderPane mainLayout) {
        this.mainLayout = mainLayout;

        this.setSpacing(25);
        this.setPadding(new Insets(30, 40, 30, 40));
        // Soft, modern off-white background matching the premium theme
        this.setStyle("-fx-background-color: #f8fafc;");

        Button backBtn = new Button("\u2190 Back to Groups");
        backBtn.setCursor(Cursor.HAND);
        backBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: #64748b; -fx-font-weight: bold; -fx-font-size: 15px; -fx-padding: 0;");
        backBtn.setOnMouseEntered(e -> backBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: #0f172a; -fx-font-weight: bold; -fx-font-size: 15px; -fx-padding: 0;"));
        backBtn.setOnMouseExited(e -> backBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: #64748b; -fx-font-weight: bold; -fx-font-size: 15px; -fx-padding: 0;"));
        backBtn.setOnAction(e -> mainLayout.setCenter(new Groups_Page(mainLayout)));

        VBox headerBox = buildPremiumGroupHeader();

        tabsBox = new HBox(15);
        tabsBox.setAlignment(Pos.CENTER_LEFT);
        tabsBox.setPadding(new Insets(10, 0, 10, 0));

        contentArea = new VBox(20);
        
        ScrollPane scrollPane = new ScrollPane(contentArea);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color: transparent; -fx-background-insets: 0; -fx-padding: 0;");
        VBox.setVgrow(scrollPane, Priority.ALWAYS);

        this.getChildren().addAll(backBtn, headerBox, tabsBox, scrollPane);
        loadTab("Events"); // Set default tab to Events
    }

    private void loadTab(String tabName) {
        tabsBox.getChildren().clear();
        tabsBox.getChildren().addAll(
            createTabButton("Posts", tabName.equals("Posts")),
            createTabButton("Members", tabName.equals("Members")),
            createTabButton("Events", tabName.equals("Events")),
            createTabButton("Challenges", tabName.equals("Challenges")),
            createTabButton("Gallery", tabName.equals("Gallery"))
        );

        contentArea.getChildren().clear();
        
        switch (tabName) {
            case "Posts" -> contentArea.getChildren().add(buildPostsList());
            case "Members" -> contentArea.getChildren().add(buildMembersList());
            case "Events" -> contentArea.getChildren().add(buildEventsList());
            case "Challenges" -> contentArea.getChildren().add(buildChallengesList());
            case "Gallery" -> contentArea.getChildren().add(buildGallery());
        }
    }

    private Button createTabButton(String text, boolean isActive) {
        Button btn = new Button(text);
        btn.setCursor(Cursor.HAND);
        if (isActive) {
            btn.setStyle("-fx-background-color: #e0e7ff; -fx-text-fill: #4338ca; -fx-font-weight: bold; -fx-font-size: 14px; -fx-background-radius: 20; -fx-padding: 8 22;");
        } else {
            btn.setStyle("-fx-background-color: transparent; -fx-text-fill: #64748b; -fx-font-weight: bold; -fx-font-size: 14px; -fx-padding: 8 22;");
        }
        btn.setOnAction(e -> loadTab(text));
        return btn;
    }

    private VBox buildPremiumGroupHeader() {
        VBox headerContainer = new VBox(0); // 0 spacing so banner and info connect seamlessly
        headerContainer.setStyle("-fx-background-color: white; -fx-background-radius: 20; -fx-effect: dropshadow(three-pass-box, rgba(15,23,42,0.06), 25, 0, 0, 10);");

        // Premium Banner
        StackPane banner = new StackPane();
        banner.setPrefHeight(160);
        banner.setStyle("-fx-background-color: linear-gradient(to bottom right, #2563eb, #9333ea); -fx-background-radius: 20 20 0 0;");
        
        Label bannerText = new Label("\u26BE Pune Cricket Club Official");
        bannerText.setStyle("-fx-text-fill: white; -fx-font-size: 28px; -fx-font-weight: bold; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 10, 0, 0, 2);");
        banner.getChildren().add(bannerText);

        // Info Section
        HBox infoBox = new HBox(20);
        infoBox.setAlignment(Pos.CENTER_LEFT);
        infoBox.setPadding(new Insets(25, 30, 30, 30));

        VBox textInfo = new VBox(8);
        Label groupName = new Label("Pune Cricket Club");
        groupName.setStyle("-fx-font-size: 26px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
        Label groupStats = new Label("\ud83d\udc65 124 Members  \u2022  \ud83c\udf0e Public Group  \u2022  \ud83d\udccd Maharashtra");
        groupStats.setStyle("-fx-text-fill: #64748b; -fx-font-size: 14px; -fx-font-weight: bold;");
        textInfo.getChildren().addAll(groupName, groupStats);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        // Premium Buttons
        Button messageBtn = new Button("\u2709 Message Group");
        messageBtn.setCursor(Cursor.HAND);
        messageBtn.setStyle("-fx-background-color: #eff6ff; -fx-text-fill: #2563eb; -fx-font-weight: bold; -fx-background-radius: 25; -fx-padding: 10 25; -fx-font-size: 14px; -fx-border-color: #bfdbfe; -fx-border-radius: 25;");
        messageBtn.setOnAction(e -> mainLayout.setCenter(new Message_Page(mainLayout)));
        
        Button exitGroupBtn = new Button("Exit Group");
        exitGroupBtn.setCursor(Cursor.HAND);
        exitGroupBtn.setStyle("-fx-background-color: #fef2f2; -fx-text-fill: #ef4444; -fx-font-weight: bold; -fx-background-radius: 25; -fx-padding: 10 25; -fx-font-size: 14px; -fx-border-color: #fecaca; -fx-border-radius: 25;");

        infoBox.getChildren().addAll(textInfo, spacer, messageBtn, exitGroupBtn);
        headerContainer.getChildren().addAll(banner, infoBox);

        return headerContainer;
    }

    private VBox buildPostsList() {
        VBox postsContainer = new VBox(25);
        postsContainer.setPadding(new Insets(10, 0, 0, 0));

        VBox createPostBox = new VBox(15);
        createPostBox.setPadding(new Insets(20));
        createPostBox.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-border-color: #f1f5f9; -fx-border-radius: 16; -fx-border-width: 1; -fx-effect: dropshadow(three-pass-box, rgba(15,23,42,0.03), 15, 0, 0, 5);");
        
        TextArea postInput = new TextArea();
        postInput.setPromptText("What's on your mind? Share an update with the club...");
        postInput.setPrefRowCount(3);
        postInput.setStyle("-fx-background-color: #f8fafc; -fx-border-color: #e2e8f0; -fx-border-radius: 10; -fx-font-size: 14px;");
        
        Button submitPost = new Button("Post to Group");
        submitPost.setCursor(Cursor.HAND);
        submitPost.setStyle("-fx-background-color: #2563eb; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-padding: 8 25;");
        
        HBox submitBox = new HBox(submitPost);
        submitBox.setAlignment(Pos.CENTER_RIGHT);

        createPostBox.getChildren().addAll(postInput, submitBox);
        
        postsContainer.getChildren().addAll(createPostBox, 
            buildFeedPost("Captain Rahul", "Practice tomorrow at 6 AM sharp. Don't be late!", "#f59e0b"),
            buildFeedPost("Vikram Malhotra", "Does anyone have an extra pair of batting gloves I can borrow?", "#10b981")
        );
        return postsContainer;
    }

    private VBox buildFeedPost(String user, String content, String avatarColor) {
        VBox post = new VBox(15);
        post.setPadding(new Insets(20));
        post.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-border-color: #f1f5f9; -fx-border-radius: 16; -fx-border-width: 1; -fx-effect: dropshadow(three-pass-box, rgba(15,23,42,0.03), 15, 0, 0, 5);");
        
        HBox header = new HBox(12);
        header.setAlignment(Pos.CENTER_LEFT);
        
        Label avatar = new Label(user.substring(0, 1));
        avatar.setPrefSize(40, 40);
        avatar.setAlignment(Pos.CENTER);
        avatar.setStyle("-fx-background-color: " + avatarColor + "; -fx-text-fill: white; -fx-background-radius: 20; -fx-font-weight: bold; -fx-font-size: 16px;");
        
        VBox authorBox = new VBox(2);
        Label author = new Label(user);
        author.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: #0f172a;");
        Label time = new Label("2 hours ago");
        time.setStyle("-fx-text-fill: #94a3b8; -fx-font-size: 12px;");
        authorBox.getChildren().addAll(author, time);

        header.getChildren().addAll(avatar, authorBox);

        Text body = new Text(content);
        body.setStyle("-fx-font-size: 15px; -fx-fill: #334155;");
        
        post.getChildren().addAll(header, body);
        return post;
    }

    private VBox buildMembersList() {
        VBox listContainer = new VBox(15);
        listContainer.setPadding(new Insets(10, 0, 0, 0));

        Label listTitle = new Label("Group Members (124)");
        listTitle.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #0f172a; -fx-padding: 0 0 10 0;");
        listContainer.getChildren().add(listTitle);

        listContainer.getChildren().addAll(
            buildMemberRow("Rohit Sharma", "Captain \u2022 Right-Hand Batsman", true),
            buildMemberRow("Vikram Malhotra", "All-Rounder", false),
            buildMemberRow("Amit Kumar", "Fast Bowler", false)
        );
        return listContainer;
    }

    private HBox buildMemberRow(String name, String role, boolean isAdmin) {
        HBox row = new HBox(20);
        row.setAlignment(Pos.CENTER_LEFT);
        row.setPadding(new Insets(20));
        row.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-border-color: #f1f5f9; -fx-border-radius: 16; -fx-border-width: 1; -fx-effect: dropshadow(three-pass-box, rgba(15,23,42,0.03), 10, 0, 0, 2);");

        Label avatar = new Label(name.substring(0, 1));
        avatar.setPrefSize(50, 50);
        avatar.setAlignment(Pos.CENTER);
        avatar.setStyle("-fx-background-color: linear-gradient(to right, #6366f1, #a855f7); -fx-text-fill: white; -fx-background-radius: 25; -fx-font-weight: bold; -fx-font-size: 20px;");

        VBox info = new VBox(5);
        HBox nameBox = new HBox(8);
        nameBox.setAlignment(Pos.CENTER_LEFT);
        Label nameLbl = new Label(name);
        nameLbl.setStyle("-fx-font-weight: bold; -fx-font-size: 17px; -fx-text-fill: #0f172a;");
        nameBox.getChildren().add(nameLbl);
        
        if (isAdmin) {
            Label adminBadge = new Label("Admin");
            adminBadge.setStyle("-fx-background-color: #fef08a; -fx-text-fill: #854d0e; -fx-font-size: 11px; -fx-font-weight: bold; -fx-padding: 3 8; -fx-background-radius: 8;");
            nameBox.getChildren().add(adminBadge);
        }

        Label roleLbl = new Label(role);
        roleLbl.setStyle("-fx-text-fill: #64748b; -fx-font-size: 14px;");
        info.getChildren().addAll(nameBox, roleLbl);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Button viewProfileBtn = new Button("View Profile");
        viewProfileBtn.setCursor(Cursor.HAND);
        viewProfileBtn.setStyle("-fx-background-color: white; -fx-text-fill: #475569; -fx-font-weight: bold; -fx-border-color: #cbd5e1; -fx-border-radius: 20; -fx-background-radius: 20; -fx-padding: 8 20;");
        viewProfileBtn.setOnMouseEntered(e -> viewProfileBtn.setStyle("-fx-background-color: #f8fafc; -fx-text-fill: #0f172a; -fx-font-weight: bold; -fx-border-color: #94a3b8; -fx-border-radius: 20; -fx-background-radius: 20; -fx-padding: 8 20;"));
        viewProfileBtn.setOnMouseExited(e -> viewProfileBtn.setStyle("-fx-background-color: white; -fx-text-fill: #475569; -fx-font-weight: bold; -fx-border-color: #cbd5e1; -fx-border-radius: 20; -fx-background-radius: 20; -fx-padding: 8 20;"));
        viewProfileBtn.setOnAction(e -> mainLayout.setCenter(new Player_Profile(mainLayout))); 

        row.getChildren().addAll(avatar, info, spacer, viewProfileBtn);
        return row;
    }

    private VBox buildEventsList() {
        VBox container = new VBox(20);
        container.setPadding(new Insets(10, 0, 0, 0));

        Label sectionTitle = new Label("Upcoming Group Events");
        sectionTitle.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
        
        container.getChildren().addAll(
            sectionTitle,
            buildGroupEventCard("Weekend Practice Session", "15 Aug 2026 \u2022 06:30 AM", "Shivaji Park Nets", "Focusing on spin bowling and fielding drills."),
            buildGroupEventCard("Monthly Team Meeting", "20 Aug 2026 \u2022 07:00 PM", "Clubhouse", "Discussing tournament strategies and kit distribution.")
        );
        return container;
    }

    private VBox buildGroupEventCard(String title, String dateTime, String location, String desc) {
        VBox card = new VBox(12);
        card.setPadding(new Insets(25));
        card.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-border-color: #f1f5f9; -fx-border-radius: 16; -fx-border-width: 1; -fx-effect: dropshadow(three-pass-box, rgba(15,23,42,0.03), 15, 0, 0, 5);");
        
        Label titleLbl = new Label(title);
        titleLbl.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
        
        Label timeLocLbl = new Label("\ud83d\udcc5 " + dateTime + "  |  \ud83d\udccd " + location);
        timeLocLbl.setStyle("-fx-font-size: 14px; -fx-text-fill: #3b82f6; -fx-font-weight: bold;");
        
        Label descLbl = new Label(desc);
        descLbl.setStyle("-fx-font-size: 15px; -fx-text-fill: #475569;");
        
        Button joinBtn = new Button("RSVP - Attending \u2713");
        joinBtn.setStyle("-fx-background-color: #dcfce3; -fx-text-fill: #166534; -fx-font-weight: bold; -fx-background-radius: 20; -fx-padding: 8 20;");
        joinBtn.setCursor(Cursor.HAND);
        
        card.getChildren().addAll(titleLbl, timeLocLbl, descLbl, joinBtn);
        return card;
    }

    // --- UPGRADED COVER PHOTO BANNER ---
    private StackPane buildGroupBanner() {
        StackPane bannerCard = new StackPane();
        bannerCard.setPrefHeight(160);
        bannerCard.setMaxWidth(Double.MAX_VALUE);
        bannerCard.setStyle("-fx-background-radius: 16 16 0 0; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0, 0, 4);");

        // 1. Background Image (using your stadium asset)
        Region bgImage = new Region();
        String imgPath = "file:src/main/resources/assests/images/stadium.jpg";
        bgImage.setStyle("-fx-background-image: url('" + imgPath + "'); -fx-background-size: cover; -fx-background-position: center center; -fx-background-radius: 16 16 0 0;");

        // 2. Dark Gradient Overlay for perfect text visibility
        Region overlay = new Region();
        overlay.setStyle("-fx-background-color: linear-gradient(to right, rgba(15,23,42,0.85), rgba(30,58,138,0.75)); -fx-background-radius: 16 16 0 0;");

        // 3. Header Title Content
        HBox content = new HBox(12);
        content.setAlignment(Pos.CENTER);
        content.setPadding(new Insets(20));

        Label iconLbl = new Label("🏏");
        iconLbl.setStyle("-fx-font-size: 24px;");

        Label titleLbl = new Label("Pune Cricket Club Official");
        titleLbl.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: white;");

        content.getChildren().addAll(iconLbl, titleLbl);

        bannerCard.getChildren().addAll(bgImage, overlay, content);
        return bannerCard;
    }

    private VBox buildChallengesList() {
        VBox container = new VBox(20);
        container.setPadding(new Insets(10, 0, 0, 0));

        Label sectionTitle = new Label("Active Match Challenges");
        sectionTitle.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
        
        container.getChildren().addAll(
            sectionTitle,
            buildChallengeCard("Sunday League Match", "Pune Strikers", "T20 Match", "Alandi Ground"),
            buildChallengeCard("Friendly Practice Match", "Mumbai Elite XI", "30 Overs", "Shivaji Park")
        );
        return container;
    }

    private VBox buildChallengeCard(String title, String opponent, String format, String location) {
        VBox card = new VBox(12);
        card.setPadding(new Insets(25));
        card.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-border-color: #f1f5f9; -fx-border-radius: 16; -fx-border-width: 1; -fx-effect: dropshadow(three-pass-box, rgba(15,23,42,0.03), 15, 0, 0, 5);");
        
        Label titleLbl = new Label(title);
        titleLbl.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
        
        Label vsLbl = new Label("\u2694 vs " + opponent + " \u2022 " + format + " \u2022 " + location);
        vsLbl.setStyle("-fx-font-size: 14px; -fx-text-fill: #64748b; -fx-font-weight: bold;");
        
        HBox actions = new HBox(15);
        Button acceptBtn = new Button("Accept Challenge");
        acceptBtn.setStyle("-fx-background-color: #10b981; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-padding: 8 25;");
        acceptBtn.setCursor(Cursor.HAND);
        
        Button viewBtn = new Button("View Details");
        viewBtn.setStyle("-fx-background-color: #f1f5f9; -fx-text-fill: #475569; -fx-font-weight: bold; -fx-background-radius: 20; -fx-padding: 8 25;");
        viewBtn.setCursor(Cursor.HAND);
        
        actions.getChildren().addAll(acceptBtn, viewBtn);
        card.getChildren().addAll(titleLbl, vsLbl, actions);
        return card;
    }

    private VBox buildGallery() {
        VBox container = new VBox(20);
        container.setPadding(new Insets(10, 0, 0, 0));

        FlowPane grid = new FlowPane(20, 20);
        for (int i = 1; i <= 8; i++) {
            StackPane imgPlaceholder = new StackPane();
            imgPlaceholder.setPrefSize(200, 160);
            imgPlaceholder.setStyle("-fx-background-color: #f1f5f9; -fx-background-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(15,23,42,0.04), 8, 0, 0, 2);");
            
            Label icon = new Label("\ud83d\udcf7");
            icon.setStyle("-fx-font-size: 28px; -fx-text-fill: #94a3b8;");
            
            imgPlaceholder.getChildren().add(icon);
            
            // Nice hover effect for gallery images
            imgPlaceholder.setOnMouseEntered(e -> imgPlaceholder.setStyle("-fx-background-color: #e2e8f0; -fx-background-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(15,23,42,0.1), 12, 0, 0, 4); -fx-cursor: hand;"));
            imgPlaceholder.setOnMouseExited(e -> imgPlaceholder.setStyle("-fx-background-color: #f1f5f9; -fx-background-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(15,23,42,0.04), 8, 0, 0, 2);"));
            
            grid.getChildren().add(imgPlaceholder);
        }
        container.getChildren().add(grid);
        return container;
    }
}