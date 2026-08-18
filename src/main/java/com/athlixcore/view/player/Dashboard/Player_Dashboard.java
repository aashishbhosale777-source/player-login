package com.athlixcore.view.player.Dashboard;

import com.athlixcore.view.player.Academy.Academy_Dashboard;
import com.athlixcore.view.player.Tournament.Completed_Tournament.CompletedTournamentView;
import com.athlixcore.view.player.Tournament.Current_Tournament.CurrentTournamentLiveMatchview;
import com.athlixcore.view.player.Tournament.Tournament_dashboard.TournamentPage;
import com.athlixcore.view.player.Training_Fitness.Traning_dashboard;
import com.athlixcore.view.player.community.Community_Dashboard;
import com.athlixcore.view.player.community.Community_Events_Page;
import com.athlixcore.view.player.community.Community_Following_Page;
import com.athlixcore.view.player.community.Groups_Page;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Player_Dashboard extends ScrollPane {

    private BorderPane mainLayout;

    public Player_Dashboard(BorderPane mainLayout) {
        this.mainLayout = mainLayout;

        this.setFitToWidth(true);
        this.setStyle("-fx-background-color: #f4f7f9; -fx-background-insets: 0; -fx-padding: 0;");
        this.getStylesheets().add("data:text/css,.scroll-pane > .viewport { -fx-background-color: transparent; } .scroll-bar:horizontal { -fx-opacity: 0; }");

        VBox pageLayout = new VBox(25);
        pageLayout.setPadding(new Insets(30, 40, 40, 40));

        // --- 1. HERO SECTION ---
        pageLayout.getChildren().add(buildHeroCard());

        // --- 2. DYNAMIC MATCHES CAROUSEL ---
        pageLayout.getChildren().add(buildTopMatchesWidget());

        // --- 3. MAIN SPLIT LAYOUT ---
        HBox mainSplit = new HBox(25);

        // LEFT COLUMN
        VBox leftColumn = new VBox(25);
        HBox.setHgrow(leftColumn, Priority.ALWAYS);
        leftColumn.getChildren().addAll(
            buildTrainingWidget(), 
            buildCommunityFeed()
        );

        // RIGHT COLUMN
        VBox rightColumn = new VBox(25);
        rightColumn.setPrefWidth(380);
        rightColumn.setMinWidth(380);
        rightColumn.getChildren().addAll(
            buildFitnessWidget(), 
            buildQuickActionsWidget(),
            buildNotificationsWidget(),
            buildMessagesWidget()
        );

        mainSplit.getChildren().addAll(leftColumn, rightColumn);
        pageLayout.getChildren().add(mainSplit);

        this.setContent(pageLayout);
    }

    // =========================================================================
    // SMART ROUTER ENGINE (Fixes the Routing & Sidebar Selection)
    // =========================================================================
    private void navigateAndUpdateSidebar(String targetTabName, Node specificPage) {
        // 1. Search the entire screen for the Sidebar ListView and trigger it
        if (mainLayout.getScene() != null) {
            findAndSelectInListView(mainLayout.getScene().getRoot(), targetTabName);
        }

        // 2. If a specific deep-linked page is requested, overwrite the default page
        if (specificPage != null) {
            Platform.runLater(() -> {
                // Pause slightly so the default sidebar click doesn't overwrite our deep-link
                PauseTransition pause = new PauseTransition(Duration.millis(50));
                pause.setOnFinished(e -> {
                    mainLayout.setCenter(specificPage);
                    
                    // Add smooth entrance animation for deep link
                    specificPage.setTranslateY(80);
                    specificPage.setOpacity(0);
                    FadeTransition ft = new FadeTransition(Duration.millis(400), specificPage);
                    ft.setToValue(1.0);
                    TranslateTransition tt = new TranslateTransition(Duration.millis(400), specificPage);
                    tt.setToY(0);
                    ft.play();
                    tt.play();
                });
                pause.play();
            });
        }
    }

    private boolean findAndSelectInListView(Node node, String targetTabName) {
        if (node instanceof ListView) {
            @SuppressWarnings("unchecked")
            ListView<String> listView = (ListView<String>) node;
            for (int i = 0; i < listView.getItems().size(); i++) {
                String item = listView.getItems().get(i);
                if (item != null && (item.equalsIgnoreCase(targetTabName) || item.contains(targetTabName))) {
                    final int index = i;
                    Platform.runLater(() -> listView.getSelectionModel().select(index));
                    return true; 
                }
            }
        }
        if (node instanceof javafx.scene.Parent) {
            for (Node child : ((javafx.scene.Parent) node).getChildrenUnmodifiable()) {
                if (findAndSelectInListView(child, targetTabName)) return true;
            }
        }
        return false;
    }

    // =========================================================================
    // 2. HERO CARD
    // =========================================================================
    private StackPane buildHeroCard() {
        StackPane card = new StackPane();
        card.setStyle("-fx-background-color: #0f172a; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.15), 20, 0, 0, 5);");

        ImageView playerImg = new ImageView();
        try {
            Image img = new Image("file:src/main/resources/assests/images/virat.jpg", true);
            playerImg.setImage(img);
        } catch (Exception e) {}
        playerImg.setFitHeight(230);
        playerImg.setPreserveRatio(true);
        StackPane.setAlignment(playerImg, Pos.BOTTOM_RIGHT);
        StackPane.setMargin(playerImg, new Insets(0, 40, 0, 0));

        Region overlay = new Region();
        overlay.setStyle("-fx-background-color: linear-gradient(to right, #0f172a 45%, rgba(15,23,42,0.85) 70%, rgba(15,23,42,0.2) 95%); -fx-background-radius: 16;");

        HBox layout = new HBox(20);
        layout.setPadding(new Insets(30));
        layout.setAlignment(Pos.CENTER_LEFT);

        VBox leftText = new VBox(5);
        Label badge = new Label("✓ ELITE ATHLETE");
        badge.setStyle("-fx-text-fill: #10b981; -fx-font-size: 11px; -fx-font-weight: bold; -fx-letter-spacing: 1px;");

        Label greeting = new Label("Good Morning, Virat!");
        greeting.setStyle("-fx-text-fill: white; -fx-font-size: 32px; -fx-font-weight: bold;");

        HBox statsRow = new HBox(40);
        statsRow.setPadding(new Insets(15, 0, 0, 0));
        statsRow.getChildren().addAll(
            createHeroStat("154", "MATCHES"),
            createHeroStat("6,420", "RUNS"),
            createHeroStat("12", "WICKETS"),
            createHeroStat("42.5", "AVG"),
            createHeroStat("138.2", "SR")
        );

        leftText.getChildren().addAll(badge, greeting, statsRow);
        layout.getChildren().add(leftText);

        card.getChildren().addAll(playerImg, overlay, layout);

        // Make Entire Block Clickable -> Routes to Profile Page
        card.setCursor(Cursor.HAND);
        card.setOnMouseClicked(e -> navigateAndUpdateSidebar("Profile", null));
        addSimpleHoverScaleAnimation(card);

        return card;
    }

    private VBox createHeroStat(String value, String label) {
        VBox v = new VBox(0);
        Label val = new Label(value);
        val.setStyle("-fx-text-fill: white; -fx-font-size: 26px; -fx-font-weight: bold;");
        Label lbl = new Label(label);
        lbl.setStyle("-fx-text-fill: #94a3b8; -fx-font-size: 11px; -fx-font-weight: bold;");
        v.getChildren().addAll(val, lbl);
        return v;
    }

    // =========================================================================
    // 3. INTERACTIVE MATCH CAROUSEL ENGINE 
    // =========================================================================
    private VBox buildTopMatchesWidget() {
        VBox widget = new VBox(15);
        widget.setMaxWidth(Double.MAX_VALUE);

        HBox header = new HBox(20);
        header.setAlignment(Pos.BOTTOM_LEFT);
        header.setStyle("-fx-border-color: #e2e8f0; -fx-border-width: 0 0 1 0; -fx-padding: 0 0 8 0;");

        HBox cardsBox = new HBox(20);
        cardsBox.setPadding(new Insets(5, 5, 15, 5));

        Label currentLbl = createMatchTab("Current Matches", true, cardsBox);
        Label upcomingLbl = createMatchTab("Upcoming Matches", false, cardsBox);
        Label completedLbl = createMatchTab("Completed Matches", false, cardsBox);

        HBox tabsBox = new HBox(20, currentLbl, upcomingLbl, completedLbl);
        tabsBox.setAlignment(Pos.BOTTOM_LEFT);

        Region spacer = new Region(); 
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Label schedule = new Label("Cricket Schedule >");
        schedule.setStyle("-fx-text-fill: #2563eb; -fx-font-size: 13px; -fx-font-weight: bold; -fx-cursor: hand;");
        schedule.setOnMouseClicked(e -> navigateAndUpdateSidebar("Tournament", null));

        header.getChildren().addAll(tabsBox, spacer, schedule);

        ScrollPane scroll = new ScrollPane(cardsBox);
        scroll.setFitToHeight(true);
        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER); 
        scroll.setStyle("-fx-background-color: transparent; -fx-background-insets: 0; -fx-padding: 0;");

        scroll.setOnScroll(event -> {
            if (event.getDeltaY() != 0) {
                double width = scroll.getContent().getBoundsInLocal().getWidth();
                if (width > 0) {
                    scroll.setHvalue(scroll.getHvalue() - (event.getDeltaY() * 2) / width);
                }
            }
        });

        updateMatchesCarousel("Current Matches", cardsBox);

        widget.getChildren().addAll(header, scroll);
        return widget;
    }

    private Label createMatchTab(String text, boolean isActive, HBox cardsBox) {
        Label lbl = new Label(text);
        lbl.setCursor(Cursor.HAND);
        updateMatchTabStyle(lbl, isActive);

        lbl.setOnMouseClicked(e -> {
            if (lbl.getParent() != null) {
                for (Node n : ((HBox)lbl.getParent()).getChildren()) {
                    if (n instanceof Label) {
                        updateMatchTabStyle((Label) n, false);
                    }
                }
            }
            updateMatchTabStyle(lbl, true);
            updateMatchesCarousel(text, cardsBox);
        });

        return lbl;
    }

    private void updateMatchTabStyle(Label lbl, boolean isActive) {
        if (isActive) {
            lbl.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: #0f172a; -fx-border-color: #ef4444; -fx-border-width: 0 0 2 0; -fx-padding: 0 0 8 0;");
        } else {
            lbl.setStyle("-fx-font-weight: normal; -fx-font-size: 15px; -fx-text-fill: #64748b; -fx-border-color: transparent; -fx-border-width: 0 0 2 0; -fx-padding: 0 0 8 0;");
        }
    }

    private void updateMatchesCarousel(String category, HBox cardsBox) {
        cardsBox.getChildren().clear();

        Runnable liveMatchAction = () -> navigateAndUpdateSidebar("Tournament", new CurrentTournamentLiveMatchview(() -> navigateAndUpdateSidebar("Dashboard", new Player_Dashboard(mainLayout))).getView());
        Runnable completedMatchAction = () -> navigateAndUpdateSidebar("Tournament", new CompletedTournamentView(() -> navigateAndUpdateSidebar("Dashboard", new Player_Dashboard(mainLayout)), title -> System.out.println("Viewing details for: " + title)).getView());
        Runnable upcomingMatchAction = () -> navigateAndUpdateSidebar("Tournament", null); 

        if (category.equals("Current Matches")) {
            cardsBox.getChildren().addAll(
                createMatchCardLive("IND vs SL 2026", "1st Test, Galle", "IN IND", "36-0", "8.3", "LK SL", "Yet to bat", "Day 1 : IND opt to bat", liveMatchAction),
                createMatchCardLive("BAN vs AUS 2026", "1st Test, Marrara", "AU AUS", "198 & 51-2", "12.0", "BD BAN", "426", "Day 3 : Tea Break", liveMatchAction),
                createMatchCardLive("ENG vs NZ 2026", "2nd T20I, Eden Park", "EN ENG", "182/4", "20.0", "NZ NZL", "110/3", "NZ needs 73 runs", liveMatchAction)
            );
        } else if (category.equals("Upcoming Matches")) {
            cardsBox.getChildren().addAll(
                createMatchCardUpcoming("AFG vs IRE 2026", "5th ODI, Civil Service", "IE Ireland", "AF Afghanistan", "Today\n3:15 PM", upcomingMatchAction),
                createMatchCardUpcoming("ENG vs SA 2026", "1st T20I, Lord's", "EN England", "SA South Africa", "Tomorrow\n6:30 PM", upcomingMatchAction),
                createMatchCardUpcoming("MUM vs PUN 2026", "Ranji Trophy, Wankhede", "MH Mumbai", "PB Punjab", "Wed, 18 Aug\n9:00 AM", upcomingMatchAction)
            );
        } else if (category.equals("Completed Matches")) {
            cardsBox.getChildren().addAll(
                createMatchCardCompleted("IND vs PAK 2026", "Final, Eden Gardens", "IN IND", "210/4", "PK PAK", "198/8", "IND won by 12 runs", completedMatchAction),
                createMatchCardCompleted("WI vs NZ 2026", "3rd ODI, Sabina Park", "WI West Indies", "280/9", "NZ New Zealand", "281/5", "NZ won by 5 wickets", completedMatchAction),
                createMatchCardCompleted("CSK vs RCB 2026", "IPL Eliminator", "CH CSK", "195/3", "BA RCB", "180/9", "CSK won by 15 runs", completedMatchAction)
            );
        }

        for (int i = 0; i < cardsBox.getChildren().size(); i++) {
            Node card = cardsBox.getChildren().get(i);
            card.setOpacity(0);
            card.setTranslateY(15);
            
            FadeTransition ft = new FadeTransition(Duration.millis(300), card);
            ft.setToValue(1);
            ft.setDelay(Duration.millis(i * 80)); 
            
            TranslateTransition tt = new TranslateTransition(Duration.millis(300), card);
            tt.setToY(0);
            tt.setDelay(Duration.millis(i * 80));
            
            ft.play();
            tt.play();
        }
    }

    private void applyHoverStyleAnimation(Node card, String baseStyle, String hoverStyle, Runnable onClickAction) {
        ScaleTransition scaleIn = new ScaleTransition(Duration.millis(150), card);
        scaleIn.setToX(1.02);
        scaleIn.setToY(1.02);

        ScaleTransition scaleOut = new ScaleTransition(Duration.millis(150), card);
        scaleOut.setToX(1.0);
        scaleOut.setToY(1.0);

        card.setOnMouseEntered(e -> {
            scaleIn.playFromStart();
            card.setStyle(hoverStyle);
        });
        card.setOnMouseExited(e -> {
            scaleOut.playFromStart();
            card.setStyle(baseStyle);
        });

        if (onClickAction != null) {
            card.setOnMouseClicked(e -> onClickAction.run());
        }
    }

    private VBox createMatchCardLive(String title, String subtitle, String t1, String s1, String overs1, String t2, String s2, String status, Runnable onClickAction) {
        VBox card = new VBox(15);
        card.setPrefWidth(320);
        card.setMinWidth(320);
        card.setPadding(new Insets(15, 20, 15, 20));
        String baseStyle = "-fx-background-color: white; -fx-background-radius: 12; -fx-border-color: #e2e8f0; -fx-border-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 8, 0, 0, 2);";
        String hoverStyle = "-fx-background-color: #f8fafc; -fx-background-radius: 12; -fx-border-color: #cbd5e1; -fx-border-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.06), 10, 0, 0, 3);";
        card.setStyle(baseStyle);
        card.setCursor(Cursor.HAND);

        HBox top = new HBox(8);
        top.setAlignment(Pos.CENTER_LEFT);
        Circle liveDot = new Circle(4, Color.web("#ef4444"));
        Label liveTxt = new Label("Live");
        liveTxt.setStyle("-fx-text-fill: #ef4444; -fx-font-weight: bold; -fx-font-size: 12px;");
        Label sep = new Label("|");
        sep.setStyle("-fx-text-fill: #cbd5e1;");
        Label tLbl = new Label(title);
        tLbl.setStyle("-fx-font-weight: bold; -fx-font-size: 13px; -fx-text-fill: #0f172a;");
        Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);
        Label arrow = new Label(">");
        arrow.setStyle("-fx-text-fill: #94a3b8; -fx-font-weight: bold;");
        top.getChildren().addAll(liveDot, liveTxt, sep, tLbl, sp, arrow);

        Label sub = new Label(subtitle);
        sub.setStyle("-fx-text-fill: #64748b; -fx-font-size: 11px;");

        HBox team1 = new HBox(8);
        team1.setAlignment(Pos.CENTER_LEFT);
        Label n1 = new Label(t1);
        n1.setStyle("-fx-font-size: 14px; -fx-text-fill: #334155;");
        Label sc1 = new Label(s1);
        sc1.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #2563eb;");
        Label o1 = new Label(overs1 + (!overs1.isEmpty() ? " 🏏" : ""));
        o1.setStyle("-fx-font-size: 12px; -fx-text-fill: #94a3b8;");
        team1.getChildren().addAll(n1, sc1, o1);

        HBox team2 = new HBox(8);
        team2.setAlignment(Pos.CENTER_LEFT);
        Label n2 = new Label(t2);
        n2.setStyle("-fx-font-size: 14px; -fx-text-fill: #334155;");
        Label sc2 = new Label(s2);
        sc2.setStyle("-fx-font-size: 14px; -fx-text-fill: #64748b;");
        team2.getChildren().addAll(n2, sc2);

        Label stat = new Label(status);
        stat.setStyle("-fx-text-fill: #d97706; -fx-font-size: 12px; -fx-font-weight: bold;");

        card.getChildren().addAll(top, sub, team1, team2, stat);
        applyHoverStyleAnimation(card, baseStyle, hoverStyle, onClickAction);

        return card;
    }

    private VBox createMatchCardUpcoming(String title, String subtitle, String t1, String t2, String time, Runnable onClickAction) {
        VBox card = new VBox(15);
        card.setPrefWidth(320);
        card.setMinWidth(320);
        card.setPadding(new Insets(15, 20, 15, 20));
        String baseStyle = "-fx-background-color: #f8fafc; -fx-background-radius: 12; -fx-border-color: #e2e8f0; -fx-border-radius: 12;";
        String hoverStyle = "-fx-background-color: white; -fx-background-radius: 12; -fx-border-color: #cbd5e1; -fx-border-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.06), 10, 0, 0, 3);";
        card.setStyle(baseStyle);
        card.setCursor(Cursor.HAND);

        HBox top = new HBox(8);
        top.setAlignment(Pos.CENTER_LEFT);
        Label tLbl = new Label(title);
        tLbl.setStyle("-fx-font-weight: bold; -fx-font-size: 13px; -fx-text-fill: #475569;");
        Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);
        Label arrow = new Label(">");
        arrow.setStyle("-fx-text-fill: #94a3b8; -fx-font-weight: bold;");
        top.getChildren().addAll(tLbl, sp, arrow);

        Label sub = new Label(subtitle);
        sub.setStyle("-fx-text-fill: #64748b; -fx-font-size: 11px;");

        HBox split = new HBox(10);
        VBox teams = new VBox(15);
        teams.setAlignment(Pos.CENTER_LEFT);
        Label n1 = new Label(t1); n1.setStyle("-fx-font-size: 14px; -fx-text-fill: #334155;");
        Label n2 = new Label(t2); n2.setStyle("-fx-font-size: 14px; -fx-text-fill: #334155;");
        teams.getChildren().addAll(n1, n2);

        Region ssp = new Region(); HBox.setHgrow(ssp, Priority.ALWAYS);

        VBox rightTime = new VBox(2);
        rightTime.setAlignment(Pos.CENTER_RIGHT);
        rightTime.setStyle("-fx-border-color: #cbd5e1; -fx-border-width: 0 0 0 1; -fx-padding: 0 0 0 15;");
        Label lT = new Label(time.contains("\n") ? time.split("\n")[0] : "Today");
        lT.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: #0f172a;");
        Label lP = new Label(time.contains("\n") ? time.split("\n")[1] : time);
        lP.setStyle("-fx-font-size: 12px; -fx-text-fill: #64748b;");
        rightTime.getChildren().addAll(lT, lP);

        split.getChildren().addAll(teams, ssp, rightTime);
        card.getChildren().addAll(top, sub, split);
        applyHoverStyleAnimation(card, baseStyle, hoverStyle, onClickAction);

        return card;
    }

    private VBox createMatchCardCompleted(String title, String subtitle, String t1, String s1, String t2, String s2, String result, Runnable onClickAction) {
        VBox card = new VBox(15);
        card.setPrefWidth(320);
        card.setMinWidth(320);
        card.setPadding(new Insets(15, 20, 15, 20));
        String baseStyle = "-fx-background-color: white; -fx-background-radius: 12; -fx-border-color: #e2e8f0; -fx-border-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.03), 8, 0, 0, 2);";
        String hoverStyle = "-fx-background-color: #f8fafc; -fx-background-radius: 12; -fx-border-color: #cbd5e1; -fx-border-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.06), 10, 0, 0, 3);";
        card.setStyle(baseStyle);
        card.setCursor(Cursor.HAND);

        HBox top = new HBox(8);
        top.setAlignment(Pos.CENTER_LEFT);
        Label resTxt = new Label("Result");
        resTxt.setStyle("-fx-text-fill: #64748b; -fx-font-weight: bold; -fx-font-size: 12px;");
        Label sep = new Label("|");
        sep.setStyle("-fx-text-fill: #cbd5e1;");
        Label tLbl = new Label(title);
        tLbl.setStyle("-fx-font-weight: bold; -fx-font-size: 13px; -fx-text-fill: #0f172a;");
        Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);
        top.getChildren().addAll(resTxt, sep, tLbl, sp);

        Label sub = new Label(subtitle);
        sub.setStyle("-fx-text-fill: #64748b; -fx-font-size: 11px;");

        HBox team1 = new HBox(8);
        team1.setAlignment(Pos.CENTER_LEFT);
        Label n1 = new Label(t1);
        n1.setStyle("-fx-font-size: 14px; -fx-text-fill: #334155;");
        Region t1sp = new Region(); HBox.setHgrow(t1sp, Priority.ALWAYS);
        Label sc1 = new Label(s1);
        sc1.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
        team1.getChildren().addAll(n1, t1sp, sc1);

        HBox team2 = new HBox(8);
        team2.setAlignment(Pos.CENTER_LEFT);
        Label n2 = new Label(t2);
        n2.setStyle("-fx-font-size: 14px; -fx-text-fill: #334155;");
        Region t2sp = new Region(); HBox.setHgrow(t2sp, Priority.ALWAYS);
        Label sc2 = new Label(s2);
        sc2.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
        team2.getChildren().addAll(n2, t2sp, sc2);

        Label stat = new Label(result);
        stat.setStyle("-fx-text-fill: #10b981; -fx-font-size: 12px; -fx-font-weight: bold;");

        card.getChildren().addAll(top, sub, team1, team2, stat);
        applyHoverStyleAnimation(card, baseStyle, hoverStyle, onClickAction);

        return card;
    }


    // =========================================================================
    // 4. MAIN SPLIT (LEFT COLUMN - AI & FEED)
    // =========================================================================
    private VBox buildTrainingWidget() {
        VBox card = new VBox(20);
        card.setPadding(new Insets(25));
        card.setStyle("-fx-background-color: #1e293b; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0, 0, 4);");

        HBox header = new HBox();
        Label title = new Label("🏋️ Training Schedule");
        title.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: white;");
        Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);
        Label seeMore = new Label("See More");
        seeMore.setStyle("-fx-text-fill: #38bdf8; -fx-font-size: 12px; -fx-font-weight: bold; -fx-cursor: hand;");

        header.getChildren().addAll(title, sp, seeMore);

        VBox list = new VBox(15);
        list.getChildren().addAll(
            createTrainingRow("Power Hitting Nets", "Today, 4:00 PM", "Coach Rahul", "#10b981"),
            createTrainingRow("Pace Bowling Facing", "Tomorrow, 8:00 AM", "Bowling Machine", "#f59e0b"),
            createTrainingRow("Agility & Footwork", "Wed, 18 Aug, 10:00 AM", "Fitness Coach", "#38bdf8")
        );

        card.getChildren().addAll(header, list);

        // Entire Block Clickable -> Routes to Training
        card.setCursor(Cursor.HAND);
        card.setOnMouseClicked(e -> {
            Traning_dashboard.showFitnessFirst = false;
            navigateAndUpdateSidebar("Traning / Fitness", null);
        });
        addSimpleHoverScaleAnimation(card);

        return card;
    }

    private HBox createTrainingRow(String drill, String time, String coach, String colorStr) {
        HBox row = new HBox(15);
        row.setAlignment(Pos.CENTER_LEFT);
        
        Circle dot = new Circle(4, Color.web(colorStr));

        VBox details = new VBox(3);
        Label lDrill = new Label(drill);
        lDrill.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14px;");
        Label lTime = new Label(time + " • " + coach);
        lTime.setStyle("-fx-text-fill: #94a3b8; -fx-font-size: 11px;");
        details.getChildren().addAll(lDrill, lTime);

        row.getChildren().addAll(dot, details);
        return row;
    }

    private VBox buildCommunityFeed() {
        VBox feed = new VBox(15);
        
        HBox header = new HBox();
        Label title = new Label("Community Feed");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: #0f172a;");
        Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);
        Label viewAll = new Label("View All");
        viewAll.setStyle("-fx-text-fill: #10b981; -fx-font-weight: bold; -fx-font-size: 12px; -fx-cursor: hand;");
        
        viewAll.setOnMouseClicked(e -> navigateAndUpdateSidebar("Community", new Community_Dashboard(mainLayout)));

        header.getChildren().addAll(title, sp, viewAll);

        VBox post1 = buildFeedPost("Rohit Sharma", "2 hours ago • Pro Player", "Incredible session today focusing on reverse sweeps. Technique is feeling sharp! 🏏💪", "RS", "#2563eb");
        VBox post2 = buildFeedPost("Cricket Academy", "4 hours ago • Verified Institution", "New masterclass uploaded: 'Mastering the Short Ball'. Exclusive access for AthliX Pro members. Check it out in the Training tab!", "CA", "#10b981");

        feed.getChildren().addAll(header, post1, post2);
        return feed;
    }

    private VBox buildFeedPost(String name, String sub, String text, String initials, String color) {
        VBox card = new VBox(15);
        card.setPadding(new Insets(20));
        card.setStyle("-fx-background-color: white; -fx-background-radius: 12; -fx-border-color: #e2e8f0; -fx-border-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.02), 8, 0, 0, 2);");

        HBox header = new HBox(12);
        StackPane avatar = createMiniAvatar(initials, color, 40);
        VBox info = new VBox(2);
        Label n = new Label(name);
        n.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: #0f172a;");
        Label s = new Label(sub);
        s.setStyle("-fx-text-fill: #64748b; -fx-font-size: 11px;");
        info.getChildren().addAll(n, s);
        Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);
        Label more = new Label("⋯");
        more.setStyle("-fx-text-fill: #94a3b8; -fx-font-size: 18px;");
        header.getChildren().addAll(avatar, info, sp, more);

        Label body = new Label(text);
        body.setWrapText(true);
        body.setStyle("-fx-text-fill: #334155; -fx-font-size: 13px;");

        HBox actions = new HBox(20);
        actions.getChildren().addAll(
            createActionLabel("♡ 1.2k"),
            createActionLabel("💬 245"),
            createActionLabel("↗ 89")
        );
        card.getChildren().addAll(header, body, actions);

        // Entire Block Clickable -> Routes to Community
        card.setCursor(Cursor.HAND);
        card.setOnMouseClicked(e -> navigateAndUpdateSidebar("Community", null));
        addSimpleHoverScaleAnimation(card);

        return card;
    }

    private Label createActionLabel(String text) {
        Label l = new Label(text);
        l.setStyle("-fx-text-fill: #64748b; -fx-font-size: 12px; -fx-font-weight: bold; -fx-cursor: hand;");
        return l;
    }

    // =========================================================================
    // 5. MAIN SPLIT (RIGHT COLUMN - FITNESS & QUICK ACTIONS)
    // =========================================================================
    private VBox buildFitnessWidget() {
        VBox card = new VBox(20);
        card.setPadding(new Insets(25));
        card.setStyle("-fx-background-color: white; -fx-background-radius: 12; -fx-border-color: #e2e8f0; -fx-border-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.02), 8, 0, 0, 2);");

        HBox header = new HBox();
        Label title = new Label("❤️ Fitness Overview");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: #0f172a;");
        Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);
        Label seeMore = new Label("See More");
        seeMore.setStyle("-fx-text-fill: #2563eb; -fx-font-size: 12px; -fx-font-weight: bold;");

        header.getChildren().addAll(title, sp, seeMore);

        HBox readinessRow = new HBox(15);
        readinessRow.setAlignment(Pos.CENTER_LEFT);
        
        VBox rScore = new VBox(-5);
        Label score = new Label("92%");
        score.setStyle("-fx-font-size: 36px; -fx-font-weight: bold; -fx-text-fill: #10b981;");
        Label slbl = new Label("Readiness");
        slbl.setStyle("-fx-font-size: 11px; -fx-text-fill: #64748b; -fx-font-weight: bold;");
        rScore.getChildren().addAll(score, slbl);

        Region rsp = new Region(); HBox.setHgrow(rsp, Priority.ALWAYS);

        VBox statusBox = new VBox(5);
        statusBox.setAlignment(Pos.CENTER_RIGHT);
        Label s1 = new Label("Peak Match Condition");
        s1.setStyle("-fx-background-color: #dcfce3; -fx-text-fill: #166534; -fx-padding: 4 8; -fx-background-radius: 6; -fx-font-size: 11px; -fx-font-weight: bold;");
        Label s2 = new Label("Fully Recovered");
        s2.setStyle("-fx-text-fill: #64748b; -fx-font-size: 11px;");
        statusBox.getChildren().addAll(s1, s2);

        readinessRow.getChildren().addAll(rScore, rsp, statusBox);

        HBox metrics = new HBox(15);
        metrics.getChildren().addAll(
            createFitnessMetric("💤", "Sleep", "8h 15m"),
            createFitnessMetric("💧", "Hydration", "2.5L / 3L"),
            createFitnessMetric("🔋", "Fatigue", "Low")
        );

        card.getChildren().addAll(header, readinessRow, metrics);

        // Entire Block Clickable -> Routes to Fitness
        card.setCursor(Cursor.HAND);
        card.setOnMouseClicked(e -> {
            Traning_dashboard.showFitnessFirst = true;
            navigateAndUpdateSidebar("Traning / Fitness", null);
        });
        addSimpleHoverScaleAnimation(card);

        return card;
    }

    private VBox createFitnessMetric(String icon, String label, String value) {
        VBox box = new VBox(5);
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(12));
        box.setStyle("-fx-background-color: #f8fafc; -fx-background-radius: 8; -fx-border-color: #e2e8f0; -fx-border-radius: 8;");
        HBox.setHgrow(box, Priority.ALWAYS);

        Label lIcon = new Label(icon);
        lIcon.setStyle("-fx-font-size: 18px;");
        Label lText = new Label(label);
        lText.setStyle("-fx-font-size: 10px; -fx-font-weight: bold; -fx-text-fill: #64748b;");
        Label lVal = new Label(value);
        lVal.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
        
        box.getChildren().addAll(lIcon, lText, lVal);
        return box;
    }

    private VBox buildQuickActionsWidget() {
        VBox card = new VBox(15);
        Label title = new Label("Quick Actions");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: #0f172a;");

        GridPane grid = new GridPane();
        grid.setHgap(15);
        grid.setVgap(15);
        
        Button b1 = createGridButton("🔍", "Find Players", () -> navigateAndUpdateSidebar("Community", new Community_Following_Page(mainLayout)));
        Button b2 = createGridButton("👥", "Create Team", () -> navigateAndUpdateSidebar("Community", new Groups_Page(mainLayout))); 
        Button b3 = createGridButton("🏆", "Join Tournament", () -> navigateAndUpdateSidebar("Tournament", new TournamentPage().getView()));
        Button b4 = createGridButton("📅", "Events", () -> navigateAndUpdateSidebar("Community", new Community_Events_Page(mainLayout)));

        grid.add(b1, 0, 0);
        grid.add(b2, 1, 0);
        grid.add(b3, 0, 1);
        grid.add(b4, 1, 1);

        card.getChildren().addAll(title, grid);
        return card;
    }

    private Button createGridButton(String icon, String text, Runnable onClick) {
        Button b = new Button(icon + "\n" + text);
        b.setPrefSize(180, 80);
        b.setWrapText(true);
        b.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        b.setCursor(Cursor.HAND);
        b.setStyle("-fx-background-color: white; -fx-border-color: #e2e8f0; -fx-border-radius: 12; -fx-background-radius: 12; -fx-text-fill: #334155; -fx-font-weight: bold; -fx-font-size: 12px; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.02), 8, 0, 0, 2);");
        
        b.setOnMouseEntered(e -> b.setStyle("-fx-background-color: #f8fafc; -fx-border-color: #cbd5e1; -fx-border-radius: 12; -fx-background-radius: 12; -fx-text-fill: #1e293b; -fx-font-weight: bold; -fx-font-size: 12px; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.04), 10, 0, 0, 3);"));
        b.setOnMouseExited(e -> b.setStyle("-fx-background-color: white; -fx-border-color: #e2e8f0; -fx-border-radius: 12; -fx-background-radius: 12; -fx-text-fill: #334155; -fx-font-weight: bold; -fx-font-size: 12px; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.02), 8, 0, 0, 2);"));
        
        b.setOnAction(e -> onClick.run());

        return b;
    }

    private VBox buildNotificationsWidget() {
        VBox card = new VBox(15);
        HBox header = new HBox();
        Label title = new Label("Notifications");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: #0f172a;");
        Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);
        Circle dot = new Circle(4, Color.RED);
        header.getChildren().addAll(title, sp, dot);

        VBox list = new VBox(10);
        list.getChildren().addAll(
            createNotifRow("✓", "Tournament Approval", "Your entry for Elite Series confirmed.", "#10b981", "#dcfce3", () -> navigateAndUpdateSidebar("Tournament", null)),
            createNotifRow("✉", "New Message from Coach", "Rahul sent you a training update.", "#2563eb", "#eff6ff", () -> navigateAndUpdateSidebar("Academy", null))
        );

        card.getChildren().addAll(header, list);
        return card;
    }

    private HBox createNotifRow(String icon, String title, String sub, String iconColor, String iconBg, Runnable onClick) {
        HBox row = new HBox(12);
        row.setAlignment(Pos.CENTER_LEFT);
        row.setCursor(Cursor.HAND);
        
        Label lIcon = new Label(icon);
        lIcon.setPrefSize(35, 35);
        lIcon.setMinSize(35, 35);
        lIcon.setAlignment(Pos.CENTER);
        lIcon.setStyle("-fx-background-color: " + iconBg + "; -fx-text-fill: " + iconColor + "; -fx-background-radius: 8; -fx-font-weight: bold;");

        VBox text = new VBox(2);
        Label lTitle = new Label(title);
        lTitle.setStyle("-fx-font-weight: bold; -fx-font-size: 13px; -fx-text-fill: #1e293b;");
        Label lSub = new Label(sub);
        lSub.setStyle("-fx-text-fill: #64748b; -fx-font-size: 11px;");
        text.getChildren().addAll(lTitle, lSub);

        row.getChildren().addAll(lIcon, text);
        
        row.setOnMouseClicked(e -> onClick.run());
        addSimpleHoverScaleAnimation(row);
        
        return row;
    }

    private VBox buildMessagesWidget() {
        VBox card = new VBox(15);
        Label title = new Label("Recent Messages");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: #0f172a;");

        VBox list = new VBox(15);
        list.getChildren().addAll(
            createMessageRow("CR", "Coach Rahul", "Check the drill list before 4 PM...", "1h", true),
            createMessageRow("HP", "Hardik Pandya", "Great knock yesterday, mate!", "10m", false)
        );

        card.getChildren().addAll(title, list);
        return card;
    }

    private HBox createMessageRow(String initials, String name, String msg, String time, boolean unread) {
        HBox row = new HBox(12);
        row.setAlignment(Pos.CENTER_LEFT);
        row.setCursor(Cursor.HAND);
        
        row.setOnMouseClicked(e -> navigateAndUpdateSidebar("Community", null));
        addSimpleHoverScaleAnimation(row);

        StackPane avatar = createMiniAvatar(initials, "#475569", 35);

        VBox text = new VBox(2);
        Label lName = new Label(name);
        lName.setStyle("-fx-font-weight: bold; -fx-font-size: 13px; -fx-text-fill: #1e293b;");
        Label lMsg = new Label(msg);
        lMsg.setStyle("-fx-text-fill: #64748b; -fx-font-size: 11px;");
        text.getChildren().addAll(lName, lMsg);

        Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);

        VBox right = new VBox(5);
        right.setAlignment(Pos.CENTER_RIGHT);
        Label lTime = new Label(time);
        lTime.setStyle("-fx-text-fill: #94a3b8; -fx-font-size: 10px;");
        right.getChildren().add(lTime);
        
        if (unread) {
            Circle dot = new Circle(4, Color.web("#10b981"));
            right.getChildren().add(dot);
        }

        row.getChildren().addAll(avatar, text, sp, right);
        return row;
    }

    private StackPane createMiniAvatar(String initials, String bgColor, double size) {
        StackPane avatar = new StackPane();
        avatar.setPrefSize(size, size);
        avatar.setMinSize(size, size);
        avatar.setStyle("-fx-background-color: " + bgColor + "; -fx-background-radius: " + (size/2) + ";");
        Label l = new Label(initials);
        l.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: " + (size/2.5) + "px;");
        avatar.getChildren().add(l);
        return avatar;
    }

    // Standard scaling method that doesn't overwrite specific styles for complex cards
    private void addSimpleHoverScaleAnimation(Node node) {
        ScaleTransition scaleIn = new ScaleTransition(Duration.millis(150), node);
        scaleIn.setToX(1.02);
        scaleIn.setToY(1.02);

        ScaleTransition scaleOut = new ScaleTransition(Duration.millis(150), node);
        scaleOut.setToX(1.0);
        scaleOut.setToY(1.0);

        node.setOnMouseEntered(e -> scaleIn.playFromStart());
        node.setOnMouseExited(e -> scaleOut.playFromStart());
    }
}