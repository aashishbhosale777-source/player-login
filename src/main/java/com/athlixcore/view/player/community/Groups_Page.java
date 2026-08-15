package com.athlixcore.view.player.community;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.util.Duration;

import java.io.File;

public class Groups_Page extends StackPane {

    private BorderPane mainLayout;
    private VBox groupsListContainer;

    public Groups_Page(BorderPane mainLayout) {
        this.mainLayout = mainLayout;

        // --- BASE LAYOUT ---
        VBox pageLayout = new VBox(0);
        pageLayout.setStyle("-fx-background-color: #f5f7fb;");

        // Top Navigation Menu
        HBox topMenu = buildTopMenu();

        // Main Content Area
        VBox contentArea = new VBox(25);
        contentArea.setPadding(new Insets(35, 40, 40, 40));
        contentArea.setMaxWidth(Double.MAX_VALUE);

        // Header (Title + Create Button)
        HBox header = buildHeader();

        // Groups List
        groupsListContainer = new VBox(15);
        groupsListContainer.setMaxWidth(Double.MAX_VALUE);
        
        // Populate the groups with logos and data
        groupsListContainer.getChildren().addAll(
            createGroupCard(
                "Pune Cricket Club", "124 Members", "Public", 
                "A community for all local Pune players to organize matches and practice.", 
                "https://dummyimage.com/150x150/1e3a8a/ffffff.png&text=PCC", true
            ),
            createGroupCard(
                "Mumbai Elite Strikers", "89 Members", "Private", 
                "Invite-only group for division A players and professionals.", 
                "https://dummyimage.com/150x150/047857/ffffff.png&text=MES", false
            ),
            createGroupCard(
                "Weekend Warriors XI", "15 Members", "Public", 
                "Casual Sunday cricket organizers looking for friendly opponents.", 
                "https://dummyimage.com/150x150/b45309/ffffff.png&text=WW", false
            ),
            createGroupCard(
                "Spin Bowling Masterclass", "340 Members", "Public", 
                "Discuss techniques, variations, and drills for spin bowlers.", 
                "https://dummyimage.com/150x150/7c3aed/ffffff.png&text=SBM", true
            )
        );

        contentArea.getChildren().addAll(header, groupsListContainer);
        pageLayout.getChildren().addAll(topMenu, contentArea);

        // ScrollPane Setup
        ScrollPane pageScroll = new ScrollPane(pageLayout);
        pageScroll.setFitToWidth(true);
        pageScroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        pageScroll.setStyle("-fx-background-color: transparent; -fx-background-insets: 0; -fx-padding: 0;");
        pageScroll.getStylesheets().add("data:text/css,.scroll-pane > .viewport { -fx-background-color: transparent; }");

        this.getChildren().add(pageScroll);

        // --- TRIGGER CASCADE ENTRY ANIMATIONS ---
        applyCascadeAnimation(groupsListContainer, 100);
    }

    // =========================================================================
    // TOP MENU
    // =========================================================================
    private HBox buildTopMenu() {
        HBox menu = new HBox(8);
        menu.setAlignment(Pos.CENTER_LEFT);
        menu.setPadding(new Insets(18, 35, 14, 35));
        menu.setStyle("-fx-background-color: white; -fx-border-color: #e5e7eb; -fx-border-width: 0 0 1 0;");

        Label communityLabel = new Label("Community");
        communityLabel.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: #111827; -fx-padding: 0 25 0 0;");

        Button homeBtn = createMenuTab("⌂  Home", false);
        Button followingBtn = createMenuTab("♡  Following", false);
        Button groupsBtn = createMenuTab("◈  Groups", true); // GROUPS IS ACTIVE
        Button eventsBtn = createMenuTab("◷  Events", false);

        // ROUTING
        homeBtn.setOnAction(e -> mainLayout.setCenter(new Community_Dashboard(mainLayout)));
        followingBtn.setOnAction(e -> mainLayout.setCenter(new Community_Following_Page(mainLayout)));
        groupsBtn.setOnAction(e -> mainLayout.setCenter(new Groups_Page(mainLayout)));
        eventsBtn.setOnAction(e -> mainLayout.setCenter(new Community_Events_Page(mainLayout)));

        menu.getChildren().addAll(communityLabel, homeBtn, followingBtn, groupsBtn, eventsBtn);
        return menu;
    }

    private Button createMenuTab(String text, boolean active) {
        Button button = new Button(text);
        button.setCursor(Cursor.HAND);

        if (active) {
            button.setStyle("-fx-background-color: #eef2ff; -fx-text-fill: #2563eb; -fx-font-weight: bold; -fx-font-size: 14px; -fx-background-radius: 10; -fx-padding: 10 18; -fx-border-color: #2563eb; -fx-border-width: 0 0 2 0; -fx-border-radius: 0;");
        } else {
            button.setStyle("-fx-background-color: transparent; -fx-text-fill: #64748b; -fx-font-weight: bold; -fx-font-size: 14px; -fx-background-radius: 10; -fx-padding: 10 18;");
            button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: #f1f5f9; -fx-text-fill: #111827; -fx-font-weight: bold; -fx-font-size: 14px; -fx-background-radius: 10; -fx-padding: 10 18;"));
            button.setOnMouseExited(e -> button.setStyle("-fx-background-color: transparent; -fx-text-fill: #64748b; -fx-font-weight: bold; -fx-font-size: 14px; -fx-background-radius: 10; -fx-padding: 10 18;"));
        }
        return button;
    }

    // =========================================================================
    // PAGE HEADER & CREATE BUTTON
    // =========================================================================
    private HBox buildHeader() {
        HBox header = new HBox();
        header.setAlignment(Pos.CENTER_LEFT);

        VBox titleBox = new VBox(5);
        Label title = new Label("Community Groups");
        title.setStyle("-fx-font-size: 26px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
        
        Label subtitle = new Label("Discover, join, or create your own cricket communities.");
        subtitle.setStyle("-fx-font-size: 14px; -fx-text-fill: #64748b;");
        
        titleBox.getChildren().addAll(title, subtitle);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Button createBtn = new Button("+ Create Group");
        createBtn.setCursor(Cursor.HAND);
        createBtn.setStyle("-fx-background-color: #2563eb; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14px; -fx-background-radius: 25; -fx-padding: 10 25; -fx-effect: dropshadow(three-pass-box, rgba(37,99,235,0.3), 10, 0, 0, 4);");
        
        applyButtonHoverEffect(createBtn, "-fx-background-color: #1d4ed8; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14px; -fx-background-radius: 25; -fx-padding: 10 25; -fx-effect: dropshadow(three-pass-box, rgba(37,99,235,0.5), 15, 0, 0, 6);", "-fx-background-color: #2563eb; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14px; -fx-background-radius: 25; -fx-padding: 10 25; -fx-effect: dropshadow(three-pass-box, rgba(37,99,235,0.3), 10, 0, 0, 4);");

        // WIRED: Open the Bright In-App Modal
        createBtn.setOnAction(e -> showCreateGroupModal());

        header.getChildren().addAll(titleBox, spacer, createBtn);
        return header;
    }

    // =========================================================================
    // CLEAN, LIGHT-THEMED IN-APP MODAL FOR CREATING GROUPS
    // =========================================================================
    private void showCreateGroupModal() {
        // 1. Transparent Dark Overlay
        StackPane overlay = new StackPane();
        overlay.setStyle("-fx-background-color: rgba(15, 23, 42, 0.6);"); 
        overlay.setAlignment(Pos.CENTER);

        // 2. Clean Light Modal Card
        VBox root = new VBox(20);
        root.setPadding(new Insets(35));
        root.setMaxWidth(500); 
        root.setMaxHeight(Region.USE_PREF_SIZE); 
        root.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 16; -fx-border-color: #e2e8f0; -fx-border-radius: 16; -fx-border-width: 1; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.15), 30, 0, 0, 10);");

        // Header
        Label title = new Label("Create New Group");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");

        Label subtitle = new Label("Gather players, organize matches, and build your community.");
        subtitle.setStyle("-fx-text-fill: #64748b; -fx-font-size: 14px;");

        // Inputs
        VBox form = new VBox(15);
        
        TextField nameInput = new TextField();
        nameInput.setPromptText("Group Name (e.g. Pune City Strikers)");
        nameInput.setStyle("-fx-background-color: #f8fafc; -fx-text-fill: #0f172a; -fx-border-color: #cbd5e1; -fx-border-radius: 8; -fx-background-radius: 8; -fx-padding: 12; -fx-font-size: 14px; -fx-focus-color: transparent; -fx-faint-focus-color: transparent;");

        TextArea descInput = new TextArea();
        descInput.setPromptText("What is this group about?");
        descInput.setPrefRowCount(3);
        descInput.setWrapText(true);
        descInput.setStyle("-fx-control-inner-background: #f8fafc; -fx-text-fill: #0f172a; -fx-border-color: #cbd5e1; -fx-border-radius: 8; -fx-background-radius: 8; -fx-font-size: 14px; -fx-focus-color: transparent; -fx-faint-focus-color: transparent;");

        // Privacy Toggle
        HBox privacyToggle = new HBox(10);
        privacyToggle.setAlignment(Pos.CENTER_LEFT);
        Label privLabel = new Label("Privacy:");
        privLabel.setStyle("-fx-text-fill: #334155; -fx-font-size: 14px; -fx-font-weight: bold;");
        
        Button publicBtn = new Button("🔓 Public");
        Button privateBtn = new Button("🔒 Private");
        
        String activeToggle = "-fx-background-color: #2563eb; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 6; -fx-padding: 8 16; -fx-cursor: hand;";
        String inactiveToggle = "-fx-background-color: #f1f5f9; -fx-text-fill: #64748b; -fx-border-color: #e2e8f0; -fx-border-radius: 6; -fx-background-radius: 6; -fx-padding: 8 16; -fx-cursor: hand;";
        
        publicBtn.setStyle(activeToggle);
        privateBtn.setStyle(inactiveToggle);
        
        final boolean[] isPublic = {true}; // State tracker

        publicBtn.setOnAction(e -> {
            isPublic[0] = true;
            publicBtn.setStyle(activeToggle);
            privateBtn.setStyle(inactiveToggle);
        });

        privateBtn.setOnAction(e -> {
            isPublic[0] = false;
            privateBtn.setStyle(activeToggle);
            publicBtn.setStyle(inactiveToggle);
        });

        privacyToggle.getChildren().addAll(privLabel, publicBtn, privateBtn);

        // Logo Upload
        HBox uploadRow = new HBox(12);
        uploadRow.setAlignment(Pos.CENTER_LEFT);

        Button uploadButton = new Button("📷 Upload Group Logo");
        uploadButton.setCursor(Cursor.HAND);
        uploadButton.setStyle("-fx-background-color: #eef2ff; -fx-text-fill: #2563eb; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 10 15;");

        Label fileLabel = new Label("No logo selected");
        fileLabel.setStyle("-fx-text-fill: #64748b; -fx-font-size: 12px;");
        
        final File[] selectedFile = {null};
        uploadButton.setOnAction(e -> {
            FileChooser chooser = new FileChooser();
            chooser.setTitle("Choose Group Logo");
            chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
            File file = chooser.showOpenDialog(mainLayout.getScene().getWindow());
            if (file != null) {
                selectedFile[0] = file;
                fileLabel.setText(file.getName());
                fileLabel.setStyle("-fx-text-fill: #10b981; -fx-font-size: 12px; -fx-font-weight: bold;"); 
            }
        });

        uploadRow.getChildren().addAll(uploadButton, fileLabel);
        form.getChildren().addAll(nameInput, descInput, privacyToggle, uploadRow);

        // Action Buttons
        Button cancelButton = new Button("Cancel");
        cancelButton.setCursor(Cursor.HAND);
        cancelButton.setStyle("-fx-background-color: #f1f5f9; -fx-text-fill: #475569; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 10 25;");

        Button submitButton = new Button("Create Group");
        submitButton.setCursor(Cursor.HAND);
        submitButton.setStyle("-fx-background-color: #2563eb; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 10 25; -fx-effect: dropshadow(three-pass-box, rgba(37,99,235,0.3), 10, 0, 0, 4);");

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        HBox bottom = new HBox(15);
        bottom.setAlignment(Pos.CENTER_RIGHT);
        bottom.setPadding(new Insets(10, 0, 0, 0));
        bottom.getChildren().addAll(cancelButton, spacer, submitButton);

        // Logic
        cancelButton.setOnAction(e -> this.getChildren().remove(overlay));

        submitButton.setOnAction(e -> {
            String gName = nameInput.getText().trim();
            if (gName.isEmpty()) {
                nameInput.setPromptText("Group Name is required!");
                nameInput.setStyle("-fx-background-color: #fef2f2; -fx-text-fill: #0f172a; -fx-border-color: #ef4444; -fx-border-radius: 8; -fx-background-radius: 8; -fx-padding: 12; -fx-font-size: 14px; -fx-focus-color: transparent;");
                return;
            }

            String gDesc = descInput.getText().trim();
            if(gDesc.isEmpty()) gDesc = "A new community group on AthliX.";
            
            String privString = isPublic[0] ? "Public" : "Private";
            
            // Create a dynamic initials URL if no image uploaded
            String init = gName.length() >= 2 ? gName.substring(0, 2).toUpperCase() : gName.toUpperCase();
            String logoLink = "https://dummyimage.com/150x150/2563eb/ffffff.png&text=" + init;

            // Generate new card and add it to the top
            HBox newGroupCard = createGroupCard(gName, "1 Member", privString, gDesc, logoLink, true);
            groupsListContainer.getChildren().add(0, newGroupCard);

            // Animate entry of new card
            newGroupCard.setOpacity(0);
            newGroupCard.setTranslateY(-20);
            FadeTransition ftNew = new FadeTransition(Duration.millis(400), newGroupCard);
            ftNew.setToValue(1);
            TranslateTransition ttNew = new TranslateTransition(Duration.millis(400), newGroupCard);
            ttNew.setToY(0);
            ftNew.play();
            ttNew.play();

            // Close modal
            this.getChildren().remove(overlay);
        });

        root.getChildren().addAll(title, subtitle, form, bottom);

        // Slide/Fade Modal Entry Animation
        root.setOpacity(0);
        root.setTranslateY(40);
        FadeTransition ft = new FadeTransition(Duration.millis(350), root);
        ft.setToValue(1);
        TranslateTransition tt = new TranslateTransition(Duration.millis(350), root);
        tt.setToY(0);

        overlay.getChildren().add(root);
        this.getChildren().add(overlay);
        
        ft.play();
        tt.play();
    }


    // =========================================================================
    // GROUP CARD BUILDER 
    // =========================================================================
    private HBox createGroupCard(String name, String members, String type, String desc, String logoUrl, boolean isMember) {
        HBox card = new HBox(20);
        card.setAlignment(Pos.CENTER_LEFT);
        card.setPadding(new Insets(20, 25, 20, 25));
        card.setMaxWidth(Double.MAX_VALUE);
        card.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-border-color: #e2e8f0; -fx-border-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(15,23,42,0.04), 10, 0, 0, 3);");
        
        applyCardHoverAnimation(card);

        // 1. Group Logo (Image) 
        StackPane logoBox = new StackPane();
        logoBox.setPrefSize(70, 70);
        logoBox.setMinSize(70, 70);
        logoBox.setStyle("-fx-background-color: #e2e8f0; -fx-background-radius: 35;");
        
        ImageView logo = new ImageView();
        try {
            Image img = new Image(logoUrl, 70, 70, false, true, true);
            logo.setImage(img);
        } catch (Exception e) {}
        logo.setFitWidth(70);
        logo.setFitHeight(70);
        logo.setPreserveRatio(true);
        Circle clip = new Circle(35, 35, 35);
        logo.setClip(clip);
        logoBox.getChildren().add(logo);

        // 2. Text Details
        VBox details = new VBox(6);
        details.setAlignment(Pos.CENTER_LEFT);

        Label nameLbl = new Label(name);
        nameLbl.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");

        HBox statsRow = new HBox(8);
        statsRow.setAlignment(Pos.CENTER_LEFT);
        Label membersLbl = new Label(members);
        membersLbl.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-text-fill: #2563eb;");
        
        Label dot = new Label("•");
        dot.setStyle("-fx-text-fill: #cbd5e1;");

        Label typeLbl = new Label(type);
        if (type.equals("Public")) {
            typeLbl.setStyle("-fx-font-size: 11px; -fx-font-weight: bold; -fx-text-fill: #10b981; -fx-background-color: #dcfce3; -fx-padding: 3 8; -fx-background-radius: 6;");
        } else {
            typeLbl.setStyle("-fx-font-size: 11px; -fx-font-weight: bold; -fx-text-fill: #ea580c; -fx-background-color: #ffedd5; -fx-padding: 3 8; -fx-background-radius: 6;");
        }
        
        statsRow.getChildren().addAll(membersLbl, dot, typeLbl);

        Label descLbl = new Label(desc);
        descLbl.setStyle("-fx-font-size: 13px; -fx-text-fill: #64748b;");
        
        details.getChildren().addAll(nameLbl, statsRow, descLbl);

        // 3. Spacer
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        // 4. Action Button
        Button actionBtn = new Button(isMember ? "View Group" : "Join Group");
        actionBtn.setCursor(Cursor.HAND);
        
        if (isMember) {
            String baseStyle = "-fx-background-color: white; -fx-border-color: #cbd5e1; -fx-text-fill: #334155; -fx-font-weight: bold; -fx-font-size: 14px; -fx-border-radius: 20; -fx-background-radius: 20; -fx-padding: 8 22;";
            String hoverStyle = "-fx-background-color: #f8fafc; -fx-border-color: #94a3b8; -fx-text-fill: #0f172a; -fx-font-weight: bold; -fx-font-size: 14px; -fx-border-radius: 20; -fx-background-radius: 20; -fx-padding: 8 22;";
            actionBtn.setStyle(baseStyle);
            applyButtonHoverEffect(actionBtn, hoverStyle, baseStyle);
            
            // Route to Group Details
            actionBtn.setOnAction(e -> mainLayout.setCenter(new Group_Details(mainLayout)));
        } else {
            String baseStyle = "-fx-background-color: #f1f5f9; -fx-text-fill: #0f172a; -fx-font-weight: bold; -fx-font-size: 14px; -fx-background-radius: 20; -fx-padding: 8 22;";
            String hoverStyle = "-fx-background-color: #2563eb; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14px; -fx-background-radius: 20; -fx-padding: 8 22;";
            actionBtn.setStyle(baseStyle);
            applyButtonHoverEffect(actionBtn, hoverStyle, baseStyle);
            
            // Simulate Join
            actionBtn.setOnAction(e -> {
                actionBtn.setText("View Group");
                actionBtn.setStyle("-fx-background-color: white; -fx-border-color: #cbd5e1; -fx-text-fill: #334155; -fx-font-weight: bold; -fx-font-size: 14px; -fx-border-radius: 20; -fx-background-radius: 20; -fx-padding: 8 22;");
                applyButtonHoverEffect(actionBtn, "-fx-background-color: #f8fafc; -fx-border-color: #94a3b8; -fx-text-fill: #0f172a; -fx-font-weight: bold; -fx-font-size: 14px; -fx-border-radius: 20; -fx-background-radius: 20; -fx-padding: 8 22;", "-fx-background-color: white; -fx-border-color: #cbd5e1; -fx-text-fill: #334155; -fx-font-weight: bold; -fx-font-size: 14px; -fx-border-radius: 20; -fx-background-radius: 20; -fx-padding: 8 22;");
            });
        }

        card.getChildren().addAll(logoBox, details, spacer, actionBtn);
        return card;
    }

    // =========================================================================
    // ANIMATION ENGINE
    // =========================================================================
    
    // Smooth Fade and Slide Up Entry
    private void applyCascadeAnimation(VBox container, int delayOffset) {
        for (int i = 0; i < container.getChildren().size(); i++) {
            Node node = container.getChildren().get(i);
            
            node.setOpacity(0);
            node.setTranslateY(25);

            FadeTransition ft = new FadeTransition(Duration.millis(400), node);
            ft.setToValue(1);
            ft.setDelay(Duration.millis((i * 80) + delayOffset));

            TranslateTransition tt = new TranslateTransition(Duration.millis(400), node);
            tt.setToY(0);
            tt.setDelay(Duration.millis((i * 80) + delayOffset));

            ft.play();
            tt.play();
        }
    }

    // Smooth Pop-up scale on Hover
    private void applyCardHoverAnimation(Node card) {
        ScaleTransition scaleIn = new ScaleTransition(Duration.millis(150), card);
        scaleIn.setToX(1.015);
        scaleIn.setToY(1.015);

        ScaleTransition scaleOut = new ScaleTransition(Duration.millis(150), card);
        scaleOut.setToX(1.0);
        scaleOut.setToY(1.0);

        card.setOnMouseEntered(e -> {
            scaleIn.playFromStart();
            card.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-border-color: #cbd5e1; -fx-border-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(37,99,235,0.15), 15, 0, 0, 5);");
        });
        
        card.setOnMouseExited(e -> {
            scaleOut.playFromStart();
            card.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-border-color: #e2e8f0; -fx-border-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(15,23,42,0.04), 10, 0, 0, 3);");
        });
    }

    // Smooth Button Color Transition
    private void applyButtonHoverEffect(Button btn, String hoverStyle, String defaultStyle) {
        btn.setOnMouseEntered(e -> btn.setStyle(hoverStyle));
        btn.setOnMouseExited(e -> btn.setStyle(defaultStyle));
    }
}