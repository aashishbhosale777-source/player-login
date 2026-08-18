

// package com.athlixcore.view.player.Tournament.Current_Tournament;

// import javafx.animation.ScaleTransition;
// import javafx.geometry.Insets;
// import javafx.geometry.Pos;
// import javafx.scene.Node;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.control.ScrollPane;
// import javafx.scene.layout.HBox;
// import javafx.scene.layout.Priority;
// import javafx.scene.layout.VBox;
// import javafx.util.Duration;

// public class CurrentTournamentview {

//     private Runnable onBackAction;
//     private Runnable onViewLiveMatchAction;

//     public CurrentTournamentview(Runnable onBackAction, Runnable onViewLiveMatchAction) {
//         this.onBackAction = onBackAction;
//         this.onViewLiveMatchAction = onViewLiveMatchAction;
//     }

//     public Node getView() {
//         VBox mainContainer = new VBox(25);
//         mainContainer.setPadding(new Insets(30, 30, 80, 30));
//         mainContainer.setStyle("-fx-background-color: #f8fafc;");

//         // --- HEADER SECTION: Back Button & Title ---
//         HBox header = new HBox(20);
//         header.setAlignment(Pos.CENTER_LEFT);

//         Button backBtn = new Button("❮  Back to Ongoing");
//         backBtn.setStyle(
//             "-fx-background-color: #ffffff; -fx-text-fill: #10b981; -fx-font-weight: bold; -fx-font-size: 14px; -fx-padding: 8 18; -fx-background-radius: 20; -fx-border-color: #e2e8f0; -fx-border-radius: 20; -fx-cursor: hand;"
//         );
//         backBtn.setOnAction(e -> {
//             if (onBackAction != null) onBackAction.run();
//         });

//         Label titleText = new Label("🔥 All Current & Ongoing Tournaments");
//         titleText.setStyle("-fx-font-size: 26px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");

//         header.getChildren().addAll(backBtn, titleText);

//         // --- VERTICAL LIST OF MULTIPLE TOURNAMENTS ---
//         VBox tournamentsList = new VBox(25);
//         tournamentsList.setAlignment(Pos.CENTER);

//         tournamentsList.getChildren().addAll(
//             createTournamentCard("Corporate T20 Blast", "Shivaji Park, Mumbai", "₹1.2L Prize", "#3b82f6"),
//             createTournamentCard("Academy U-19 Championship", "NCA Grounds, Pune", "Selection Trial", "#10b981"),
//             createTournamentCard("Weekend Warriors Cup", "Local Ground, Nashik", "Trophy + Kit", "#8b5cf6"),
//             createTournamentCard("State Super League", "MCA Stadium, Pune", "₹5.0L Prize", "#f59e0b")
//         );

//         mainContainer.getChildren().addAll(header, tournamentsList);

//         ScrollPane scrollPane = new ScrollPane(mainContainer);
//         scrollPane.setFitToWidth(true);
//         scrollPane.setStyle("-fx-background-color: transparent; -fx-background: #f8fafc;");
//         scrollPane.getStylesheets().add("data:text/css,.scroll-pane > .viewport { -fx-background-color: transparent; }");

//         return scrollPane;
//     }

//     private VBox createTournamentCard(String title, String loc, String prize, String accentColor) {
//         VBox card = new VBox(15);
//         card.setPadding(new Insets(25));
//         card.setMaxWidth(850);
//         card.setStyle("-fx-background-color: white; -fx-background-radius: 12; -fx-border-color: " + accentColor + " #e2e8f0 #e2e8f0 #e2e8f0; -fx-border-width: 4 1 1 1; -fx-border-radius: 12;");
//         HBox.setHgrow(card, Priority.ALWAYS);

//         VBox bannerBox = new VBox();
//         bannerBox.setAlignment(Pos.CENTER);
//         bannerBox.setPadding(new Insets(30, 20, 30, 20));
//         bannerBox.setStyle("-fx-background-color: #f1f5f9; -fx-background-radius: 8; -fx-border-color: #cbd5e1; -fx-border-radius: 8;");
        
//         Label bannerTitle = new Label(title);
//         bannerTitle.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
//         bannerBox.getChildren().add(bannerTitle);

//         Label l = new Label("📍 " + loc);
//         l.setStyle("-fx-font-size: 14px; -fx-text-fill: #64748b;");

//         HBox details = new HBox();
//         Label p = new Label("🏆 " + prize);
//         p.setStyle("-fx-font-size: 14px; -fx-text-fill: #10b981; -fx-font-weight: bold;");
//         details.getChildren().add(p);

//         // Action Button to open live match view
//         Button currentTourneyBtn = new Button("View Current Tournament");
//         currentTourneyBtn.setMaxWidth(Double.MAX_VALUE);
//         currentTourneyBtn.setStyle("-fx-background-color: #10b981; -fx-text-fill: white; -fx-font-size: 15px; -fx-font-weight: bold; -fx-background-radius: 6; -fx-padding: 12; -fx-cursor: hand;");
        
//         currentTourneyBtn.setOnAction(e -> {
//             if (onViewLiveMatchAction != null) {
//                 onViewLiveMatchAction.run(); // THIS TRIGGERS THE SWITCH!
//             }
//         });

//         card.getChildren().addAll(bannerBox, l, details, currentTourneyBtn);

//         ScaleTransition scaleIn = new ScaleTransition(Duration.millis(200), card);
//         scaleIn.setToX(1.01);
//         scaleIn.setToY(1.01);
//         ScaleTransition scaleOut = new ScaleTransition(Duration.millis(200), card);
//         scaleOut.setToX(1.0);
//         scaleOut.setToY(1.0);

//         card.setOnMouseEntered(e -> scaleIn.playFromStart());
//         card.setOnMouseExited(e -> scaleOut.playFromStart());

//         return card;
//     }
// }

package com.athlixcore.view.player.Tournament.Current_Tournament;

import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.io.File;
import java.io.InputStream;

public class CurrentTournamentview {

    private Runnable onBackAction;
    private Runnable onViewLiveMatchAction;

    public CurrentTournamentview(Runnable onBackAction, Runnable onViewLiveMatchAction) {
        this.onBackAction = onBackAction;
        this.onViewLiveMatchAction = onViewLiveMatchAction;
    }

    public Node getView() {
        VBox mainContainer = new VBox(25);
        mainContainer.setPadding(new Insets(30, 30, 80, 30));
        mainContainer.setStyle("-fx-background-color: #f8fafc;");

        // --- HEADER SECTION: Back Button & Title ---
        HBox header = new HBox(20);
        header.setAlignment(Pos.CENTER_LEFT);

        Button backBtn = new Button("❮  Back to Ongoing");
        backBtn.setStyle(
            "-fx-background-color: #ffffff; -fx-text-fill: #10b981; -fx-font-weight: bold; -fx-font-size: 14px; -fx-padding: 8 18; -fx-background-radius: 20; -fx-border-color: #e2e8f0; -fx-border-radius: 20; -fx-cursor: hand;"
        );
        backBtn.setOnAction(e -> {
            if (onBackAction != null) onBackAction.run();
        });

        Label titleText = new Label("🔥 All Current & Ongoing Tournaments");
        titleText.setStyle("-fx-font-size: 26px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");

        header.getChildren().addAll(backBtn, titleText);

        // --- VERTICAL LIST OF MULTIPLE TOURNAMENTS WITH DYNAMIC IMAGES ---
        VBox tournamentsList = new VBox(25);
        tournamentsList.setAlignment(Pos.CENTER);

        tournamentsList.getChildren().addAll(
            createTournamentCard("Corporate T20 Blast", "Shivaji Park, Mumbai", "₹1.2L Prize", "#3b82f6", "/assests/images/currentTournament.png"),
            createTournamentCard("Academy U-19 Championship", "NCA Grounds, Pune", "Selection Trial", "#10b981", "/assests/images/currentTournament1.png"),
            // Reusing the images for demonstration, you can change paths as needed
            createTournamentCard("Weekend Warriors Cup", "Local Ground, Nashik", "Trophy + Kit", "#8b5cf6", "/assests/images/currentTournament2.png"),
            createTournamentCard("State Super League", "MCA Stadium, Pune", "₹5.0L Prize", "#f59e0b", "/assests/images/currentTournament3.png")
        );

        mainContainer.getChildren().addAll(header, tournamentsList);

        ScrollPane scrollPane = new ScrollPane(mainContainer);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color: transparent; -fx-background: #f8fafc;");
        scrollPane.getStylesheets().add("data:text/css,.scroll-pane > .viewport { -fx-background-color: transparent; }");

        return scrollPane;
    }

    private VBox createTournamentCard(String title, String loc, String prize, String accentColor, String imagePath) {
        VBox card = new VBox(15);
        card.setPadding(new Insets(20)); // Adjusted padding to frame the image nicely
        card.setMaxWidth(850);
        card.setStyle("-fx-background-color: white; -fx-background-radius: 12; -fx-border-color: " + accentColor + " #e2e8f0 #e2e8f0 #e2e8f0; -fx-border-width: 4 1 1 1; -fx-border-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.05), 10, 0, 0, 4);");
        HBox.setHgrow(card, Priority.ALWAYS);

        // --- 1. STADIUM IMAGE BANNER WITH OVERLAID TEXT ---
        ImageView bannerImg = loadRobustImage(imagePath);
        bannerImg.setFitHeight(180);
        bannerImg.setPreserveRatio(false);

        StackPane imagePane = new StackPane();
        imagePane.setAlignment(Pos.CENTER);
        bannerImg.fitWidthProperty().bind(imagePane.widthProperty()); // Binds image width to card width dynamically

        // Dark gradient at the bottom so the white text is always readable against the stadium lights
        Region gradientOverlay = new Region();
        gradientOverlay.setStyle("-fx-background-color: linear-gradient(to top, rgba(0,0,0,0.85) 0%, transparent 80%);");

        // The Tournament Title is now placed ON the image
        Label bannerTitle = new Label(title);
        bannerTitle.setStyle("-fx-font-size: 26px; -fx-font-weight: bold; -fx-text-fill: white; -fx-effect: dropshadow(two-pass-box, rgba(0,0,0,0.5), 5, 0, 0, 2);");
        StackPane.setAlignment(bannerTitle, Pos.BOTTOM_LEFT);
        StackPane.setMargin(bannerTitle, new Insets(0, 0, 15, 20));

        imagePane.getChildren().addAll(bannerImg, gradientOverlay, bannerTitle);

        // Add curved corners to the image so it matches the card theme
        Rectangle clip = new Rectangle();
        clip.widthProperty().bind(imagePane.widthProperty());
        clip.heightProperty().bind(imagePane.heightProperty());
        clip.setArcWidth(12);
        clip.setArcHeight(12);
        imagePane.setClip(clip);

        // --- 2. DETAILS ---
        VBox detailsBox = new VBox(8);
        
        Label l = new Label("📍 " + loc);
        l.setStyle("-fx-font-size: 14px; -fx-text-fill: #64748b;");

        HBox details = new HBox();
        Label p = new Label("🏆 " + prize);
        p.setStyle("-fx-font-size: 14px; -fx-text-fill: #10b981; -fx-font-weight: bold;");
        details.getChildren().add(p);
        
        detailsBox.getChildren().addAll(l, details);

        // --- 3. ACTION BUTTON ---
        Button currentTourneyBtn = new Button("View Current Tournament");
        currentTourneyBtn.setMaxWidth(Double.MAX_VALUE);
        currentTourneyBtn.setStyle("-fx-background-color: #10b981; -fx-text-fill: white; -fx-font-size: 15px; -fx-font-weight: bold; -fx-background-radius: 6; -fx-padding: 12; -fx-cursor: hand;");
        
        currentTourneyBtn.setOnAction(e -> {
            if (onViewLiveMatchAction != null) {
                onViewLiveMatchAction.run(); // THIS TRIGGERS THE SWITCH!
            }
        });

        // Assemble the card
        card.getChildren().addAll(imagePane, detailsBox, currentTourneyBtn);

        // Hover scale animation
        ScaleTransition scaleIn = new ScaleTransition(Duration.millis(200), card);
        scaleIn.setToX(1.015);
        scaleIn.setToY(1.015);

        ScaleTransition scaleOut = new ScaleTransition(Duration.millis(200), card);
        scaleOut.setToX(1.0);
        scaleOut.setToY(1.0);

        card.setOnMouseEntered(e -> scaleIn.playFromStart());
        card.setOnMouseExited(e -> scaleOut.playFromStart());

        return card;
    }

    // --- ROBUST IMAGE LOADER HELPER ---
    private ImageView loadRobustImage(String imagePath) {
        ImageView imageView = new ImageView();
        if (imagePath != null && !imagePath.isEmpty()) {
            try {
                if (imagePath.startsWith("http")) {
                    imageView.setImage(new Image(imagePath, true));
                } else if (imagePath.startsWith("file:")) {
                    imageView.setImage(new Image(imagePath, true));
                } else {
                    String cleanPath = imagePath.startsWith("/") ? imagePath.substring(1) : imagePath;
                    File file = new File("src/main/resources/" + cleanPath);
                    if (file.exists()) {
                        imageView.setImage(new Image(file.toURI().toString(), true));
                    } else {
                        // Fallback to classpath stream
                        InputStream stream = getClass().getResourceAsStream(imagePath.startsWith("/") ? imagePath : "/" + imagePath);
                        if (stream != null) {
                            imageView.setImage(new Image(stream));
                        }
                    }
                }
            } catch (Exception e) {}
        }
        return imageView;
    }
}