
package com.athlixcore.view.player;

import com.athlixcore.view.player.Scorecard.ScorecardPage;
import com.athlixcore.view.player.Tournament.Tournament_dashboard.TournamentPage; 
import com.athlixcore.view.player.Academy.Academy_Dashboard;
import com.athlixcore.view.player.Dashboard.Player_Dashboard;
import com.athlixcore.view.player.Leaderboard.Leaderboard_Page;
import com.athlixcore.view.player.community.Community_Dashboard;
import com.athlixcore.view.player.Training_Fitness.Traning_dashboard;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PlayerHomePage extends Application {

    public static Stage homePageStage;

    @Override
    public void start(Stage stage) throws Exception {

        homePageStage = stage;

        // OUTER CONTAINER (Holds Sidebar on the Left, and Content on the Right)
        BorderPane mainLayout = new BorderPane();
        mainLayout.setStyle("-fx-background-color: #f8fafc;");

        // INNER CONTAINER (Holds TopBar on top, changing pages in the center)
        BorderPane borderPane = new BorderPane();

        // ==========================================
        // 1. SIDEBAR (Left side, Full Height)
        // ==========================================
        VBox sideBar = new VBox(10);
        sideBar.setPadding(new Insets(24, 18, 18, 18));
        sideBar.setPrefWidth(260);
        sideBar.setStyle("-fx-background-color: #ffffff; -fx-border-color: #e5e7eb; -fx-border-width: 0 1 0 0;");

        // Brand Logo & Title
        Label logoBadge = new Label("A");
        logoBadge.setAlignment(Pos.CENTER);
        logoBadge.setPrefSize(42, 42);
        logoBadge.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #3b82f6; -fx-background-radius: 12px;");

        Label title = new Label("Player");
        title.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: #111827;");  

        HBox brandBox = new HBox(12, logoBadge, title);
        brandBox.setAlignment(Pos.CENTER_LEFT);
        brandBox.setPadding(new Insets(0, 0, 20, 5)); // Extra space below the logo

        Label menuLabel = new Label("Main Menu");
        menuLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: #6b6b6b;");
        menuLabel.setPadding(new Insets(0, 0, 0, 5));

        ListView<String> listView = new ListView<>();
        listView.getItems().addAll("Dashboard", "Community", "Tournament", "Scorecard", "Academy", "Traning / Fitness", "Leaderboard", "Notifications", "Profile", "Setting", "Logout");
        listView.setFixedCellSize(44);
        listView.setPrefHeight(listView.getItems().size() * 44 + 16);
        listView.setMaxHeight(listView.getPrefHeight());
        listView.setStyle("-fx-background-color: transparent; -fx-control-inner-background: #ffffff; -fx-padding: 4px; -fx-background-insets: 0; -fx-focus-color: transparent; -fx-border-color: transparent;");

        listView.setCellFactory(lv -> {
            ListCell<String> cell = new ListCell<>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText(null);
                        setStyle("");
                    } else {
                        setText(item);
                        if (isSelected()) {
                            setStyle("-fx-padding: 10 14 10 14; -fx-background-color: #eff6ff; -fx-background-radius: 14; -fx-text-fill: #1d4ed8; -fx-font-weight: bold; -fx-font-size: 15px;");
                        } else {
                            setStyle("-fx-padding: 10 14 10 14; -fx-background-color: transparent; -fx-text-fill: #1f2937; -fx-font-size: 15px;");
                        }
                    }
                }
            };
            cell.hoverProperty().addListener((obs, wasHovered, isHovered) -> {
                if (!cell.isEmpty() && !cell.isSelected()) {
                    cell.setStyle(isHovered
                            ? "-fx-padding: 10 14 10 14; -fx-background-color: #f8fafc; -fx-background-radius: 14; -fx-text-fill: #1d4ed8; -fx-font-size: 15px;"
                            : "-fx-padding: 10 14 10 14; -fx-background-color: transparent; -fx-text-fill: #1f2937; -fx-font-size: 15px;");
                }
            });
            return cell;
        });

        sideBar.getChildren().addAll(brandBox, menuLabel, listView);
        mainLayout.setLeft(sideBar); 

        // ==========================================
        // 2. TOP BAR (Starts *after* the sidebar)
        // ==========================================
        HBox topBar = new HBox(); // No fixed spacing, handled by Region spacer
        topBar.setPadding(new Insets(16, 28, 16, 28));
        topBar.setAlignment(Pos.CENTER_LEFT);
        topBar.setStyle("-fx-background-color: #ffffff; -fx-border-color: #e5e7eb; -fx-border-width: 0 0 1 0;");

        // Search Field (Rounded Pill)
        TextField searchField = new TextField();
        searchField.setPromptText("Search athletes, events, drills...");
        searchField.setPrefWidth(450);
        searchField.setPrefHeight(42);
        searchField.setStyle("-fx-background-color: white; -fx-background-radius: 21; -fx-border-radius: 21; -fx-border-color: #d1d5db; -fx-border-width: 1; -fx-padding: 0 20; -fx-prompt-text-fill: #9ca3af; -fx-font-size: 14px;");

        // Search Button (Blue Pill)
        Button searchButton = new Button("Search");
        searchButton.setPrefSize(110, 42);
        searchButton.setCursor(Cursor.HAND);
        searchButton.setStyle("-fx-background-color: #3b82f6; -fx-text-fill: white; -fx-background-radius: 21; -fx-font-weight: bold; -fx-font-size: 14px;");
        searchButton.setOnMouseEntered(e -> searchButton.setStyle("-fx-background-color: #2563eb; -fx-text-fill: white; -fx-background-radius: 21; -fx-font-weight: bold; -fx-font-size: 14px;"));
        searchButton.setOnMouseExited(e -> searchButton.setStyle("-fx-background-color: #3b82f6; -fx-text-fill: white; -fx-background-radius: 21; -fx-font-weight: bold; -fx-font-size: 14px;"));

        // Wrap search elements in an HBox (Aligned Left)
        HBox searchBox = new HBox(12, searchField, searchButton);
        searchBox.setAlignment(Pos.CENTER_LEFT);

        // --- SPACER ---
        // This acts as a spring, pushing the SearchBox to the Left, and Icons to the Right
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        // Notification Button
        Button notificationButton = new Button("🔔");
        notificationButton.setCursor(Cursor.HAND);
        notificationButton.setPrefSize(42, 42);
        notificationButton.setStyle("-fx-background-color: #eff6ff; -fx-background-radius: 21; -fx-text-fill: #1d4ed8; -fx-font-size: 14px;");
        notificationButton.setOnMouseEntered(e -> notificationButton.setStyle("-fx-background-color: #dbeafe; -fx-background-radius: 21; -fx-text-fill: #1d4ed8; -fx-font-size: 14px;"));
        notificationButton.setOnMouseExited(e -> notificationButton.setStyle("-fx-background-color: #eff6ff; -fx-background-radius: 21; -fx-text-fill: #1d4ed8; -fx-font-size: 14px;"));
        notificationButton.setOnAction(event -> {
            loadAnimatedPage(borderPane, createPlaceholderPage("Notifications", "You have no new notifications at the moment."));
        });

        // Profile Button
        Button profileButton = new Button("P");
        profileButton.setCursor(Cursor.HAND);
        profileButton.setPrefSize(42, 42);
        profileButton.setStyle("-fx-background-color: #2563eb; -fx-text-fill: white; -fx-background-radius: 21; -fx-font-size: 15px; -fx-font-weight: bold;");
        profileButton.setOnMouseEntered(e -> profileButton.setStyle("-fx-background-color: #1d4ed8; -fx-text-fill: white; -fx-background-radius: 21; -fx-font-size: 15px; -fx-font-weight: bold;"));
        profileButton.setOnMouseExited(e -> profileButton.setStyle("-fx-background-color: #2563eb; -fx-text-fill: white; -fx-background-radius: 21; -fx-font-size: 15px; -fx-font-weight: bold;"));
        profileButton.setOnAction(event -> {
            loadAnimatedPage(borderPane, new Player_Profile(borderPane));
        });

        // Right Actions Container
        HBox rightActions = new HBox(12, notificationButton, profileButton);
        rightActions.setAlignment(Pos.CENTER_RIGHT);

        // Add Left (Search), Middle (Spacer), Right (Icons) to TopBar
        topBar.getChildren().addAll(searchBox, spacer, rightActions);
        borderPane.setTop(topBar); 

        // Set Inner Container into the Center of Main Layout
        mainLayout.setCenter(borderPane);

        // ==========================================
        // 3. PAGE NAVIGATION & SWITCHING
        // ==========================================
        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldItem, selectedItem) -> {
            if (selectedItem == null) return;

            Node newPageNode = null;
            switch (selectedItem) {
                case "Dashboard" -> newPageNode = new Player_Dashboard(borderPane);
                case "Community" -> newPageNode = new Community_Dashboard(borderPane);
                case "Profile" -> newPageNode = new Player_Profile(borderPane);
                case "Academy" -> newPageNode = new Academy_Dashboard().getView();
                case "Scorecard" -> newPageNode = new ScorecardPage().getView();
                case "Tournament" -> newPageNode = new TournamentPage().getView();
                case "Leaderboard" -> newPageNode = new Leaderboard_Page(borderPane);
                case "Traning / Fitness" -> newPageNode = new Traning_dashboard().getView();
                default -> newPageNode = createPlaceholderPage(selectedItem + " Page", "You are viewing the " + selectedItem.toLowerCase() + " section.");
            }

            // Load the new page with beautiful bottom-to-top animation
            loadAnimatedPage(borderPane, newPageNode);
        });

        // Trigger the first selection on Startup
        listView.getSelectionModel().select("Dashboard");

        // Display Scene
        Scene scene = new Scene(mainLayout, 1500, 750);
        stage.setScene(scene);
        stage.setTitle("Athlix Core");
        stage.show();
    }

    /**
     * Replaces the old content with the new Node and smoothly translates it from bottom to top.
     */
    private void loadAnimatedPage(BorderPane container, Node pageNode) {
        if (pageNode == null) return;
        
        container.setCenter(pageNode);

        // Prepare animation starting position
        pageNode.setTranslateY(80); // Start 80 pixels lower
        pageNode.setOpacity(0);     // Invisible at start

        // Fade in
        FadeTransition fade = new FadeTransition(Duration.millis(450), pageNode);
        fade.setToValue(1.0);
        fade.setInterpolator(Interpolator.EASE_OUT);

        // Slide up
        TranslateTransition slide = new TranslateTransition(Duration.millis(450), pageNode);
        slide.setToY(0);
        slide.setInterpolator(Interpolator.EASE_OUT);

        // Play together
        ParallelTransition pt = new ParallelTransition(fade, slide);
        pt.play();
    }

    /**
     * Helper to easily generate "under construction" views for missing pages
     */
    private VBox createPlaceholderPage(String titleText, String bodyText) {
        VBox defaultBox = new VBox(20);
        defaultBox.setPadding(new Insets(40));
        defaultBox.setStyle("-fx-background-color: transparent;");

        Label contentTitle = new Label(titleText);
        contentTitle.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: #111827;");

        Text contentText = new Text(bodyText);
        contentText.setStyle("-fx-font-size: 16px; -fx-fill: #4b5563;");

        defaultBox.getChildren().addAll(contentTitle, contentText);
        return defaultBox;
    }
}