

package com.athlixcore.view.player.Academy;

import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
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
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.Arrays;
import java.util.List;

class Coach_Discovery {

    private String name;
    private String specialty;
    private String distanceText;
    private double rating;
    private String avatarUrl;
    private Runnable onBackAction;

    // Dynamic Mock Data Variables
    private String experience;
    private String studentsCoached;
    private String dailyRate; 
    private List<String> expertiseTags;
    private List<String> careerHighlights;
    private String customBio;

    // Root container to hold the view and overlay popups properly
    private StackPane rootLayer;

    public Coach_Discovery(String name, String specialty, String distanceText, double rating, String avatarUrl, Runnable onBackAction) {
        this.name = name;
        this.specialty = specialty;
        this.distanceText = distanceText;
        this.rating = rating;
        this.avatarUrl = avatarUrl;
        this.onBackAction = onBackAction;
        
        generateDynamicCoachData(); 
    }

    public Node getView() {
        if (rootLayer == null) {
            rootLayer = new StackPane();
            
            VBox mainContainer = new VBox(20);
            mainContainer.setPadding(new Insets(25, 30, 80, 30));
            mainContainer.setStyle("-fx-background-color: #f8fafc;"); 

            // --- 1. HEADER (Back Button) ---
            HBox header = new HBox(20);
            header.setAlignment(Pos.CENTER_LEFT);

            Button backBtn = new Button("❮  Back to Academy");
            backBtn.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #3b82f6; -fx-font-weight: bold; -fx-font-size: 14px; -fx-padding: 8 18; -fx-background-radius: 20; -fx-border-color: #e2e8f0; -fx-border-radius: 20; -fx-cursor: hand; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.05), 5, 0, 0, 2);");
            backBtn.setOnAction(e -> {
                if (onBackAction != null) onBackAction.run();
            });

            Label headerTitle = new Label("Coach Profile Overview");
            headerTitle.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
            header.getChildren().addAll(backBtn, headerTitle);

            // --- 2. MAIN PROFILE CARD ---
            VBox profileCard = new VBox();
            profileCard.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-border-color: #e2e8f0; -fx-border-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.08), 20, 0, 0, 8);");
            profileCard.setMaxWidth(Double.MAX_VALUE); 
            VBox.setVgrow(profileCard, Priority.ALWAYS);

            // A. BANNER & CENTERED AVATAR
            StackPane bannerPane = new StackPane();
            bannerPane.setAlignment(Pos.BOTTOM_CENTER); 
            
            Region banner = new Region();
            banner.setMinHeight(200);
            banner.setMaxWidth(Double.MAX_VALUE);
            banner.setStyle("-fx-background-color: " + getBannerGradient(specialty) + "; -fx-background-radius: 16 16 0 0;"); 

            StackPane avatarContainer = new StackPane();
            Circle borderCircle = new Circle(75, Color.web("#f1f5f9")); 
            borderCircle.setStroke(Color.WHITE);
            borderCircle.setStrokeWidth(6);
            borderCircle.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 15, 0, 0, 5);");
            
            ImageView avatar = new ImageView();
            try {
                Image img = new Image(avatarUrl, 140, 140, true, true, true);
                avatar.setImage(img);
            } catch (Exception e) {}
            avatar.setFitWidth(140);
            avatar.setFitHeight(140);
            avatar.setClip(new Circle(70, 70, 70));
            
            avatarContainer.getChildren().addAll(borderCircle, avatar);
            StackPane.setMargin(avatarContainer, new Insets(0, 0, -75, 0)); 
            
            bannerPane.getChildren().addAll(banner, avatarContainer);

            // B. PROFILE CONTENT
            VBox infoSection = new VBox(30);
            infoSection.setPadding(new Insets(90, 50, 50, 50)); 

            // Name, Badge, and Action Buttons
            VBox nameBox = new VBox(10);
            nameBox.setAlignment(Pos.CENTER);
            
            Label nameLbl = new Label(name);
            nameLbl.setStyle("-fx-font-size: 34px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
            
            HBox badgeRow = new HBox(10);
            badgeRow.setAlignment(Pos.CENTER);
            Label specBadge = new Label(specialty);
            specBadge.setStyle(getBadgeStyle(specialty) + " -fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 6 20; -fx-background-radius: 20;");
            
            Label metaLbl = new Label("📍 " + distanceText + " away   •   ⭐ " + rating + " / 5.0 (Verified)");
            metaLbl.setStyle("-fx-font-size: 15px; -fx-text-fill: #64748b; font-weight: bold;");
            
            badgeRow.getChildren().addAll(specBadge, metaLbl);
            nameBox.getChildren().addAll(nameLbl, badgeRow);

            HBox actionRowTop = new HBox(15);
            actionRowTop.setAlignment(Pos.CENTER);
            
            Button msgBtn = new Button("✉ Message");
            msgBtn.setStyle("-fx-background-color: #f8fafc; -fx-border-color: #cbd5e1; -fx-border-radius: 8; -fx-text-fill: #0f172a; -fx-font-size: 15px; -fx-font-weight: bold; -fx-padding: 10 30; -fx-background-radius: 8; -fx-cursor: hand;");
            addHoverEffect(msgBtn, "-fx-background-color: #f8fafc; -fx-border-color: #cbd5e1;", "-fx-background-color: #e2e8f0; -fx-border-color: #94a3b8;");

            // --- PURCHASE BUTTON (Wired correctly to AcademyApplicationForm) ---
            Button purchaseBtn = new Button("🛒 Purchase Coach");
            String btnDefault = "-fx-background-color: linear-gradient(to right, #3b82f6, #2563eb); -fx-text-fill: white; -fx-font-size: 15px; -fx-font-weight: bold; -fx-padding: 10 30; -fx-background-radius: 8; -fx-cursor: hand; -fx-effect: dropshadow(three-pass-box, rgba(59,130,246,0.4), 8, 0, 0, 4);";
            String btnHover = "-fx-background-color: linear-gradient(to right, #2563eb, #1d4ed8); -fx-text-fill: white; -fx-font-size: 15px; -fx-font-weight: bold; -fx-padding: 10 30; -fx-background-radius: 8; -fx-cursor: hand; -fx-effect: dropshadow(three-pass-box, rgba(29,78,216,0.6), 12, 0, 0, 5);";
            purchaseBtn.setStyle(btnDefault);
            addHoverEffect(purchaseBtn, btnDefault, btnHover);
            
            purchaseBtn.setOnAction(e -> {
                AcademyApplicationForm form = new AcademyApplicationForm(
                    name,
                    () -> {
                        // Cancel Action: removes the form overlay
                        if (rootLayer.getChildren().size() > 1) {
                            rootLayer.getChildren().remove(rootLayer.getChildren().size() - 1);
                        }
                    },
                    () -> {
                        // Submit Action: removes the form overlay and logs submission
                        if (rootLayer.getChildren().size() > 1) {
                            rootLayer.getChildren().remove(rootLayer.getChildren().size() - 1);
                        }
                        System.out.println("Application submitted successfully for " + name);
                    }
                );
                rootLayer.getChildren().add(form.getView());
            });
            
            actionRowTop.getChildren().addAll(msgBtn, purchaseBtn);
            nameBox.getChildren().add(actionRowTop);

            // Statistics Grid
            GridPane statsGrid = new GridPane();
            statsGrid.setHgap(20); statsGrid.setVgap(15);
            ColumnConstraints cc = new ColumnConstraints();
            cc.setPercentWidth(25);
            statsGrid.getColumnConstraints().addAll(cc, cc, cc, cc);
            
            statsGrid.add(createStatBlock("⏱ Experience", experience), 0, 0);
            statsGrid.add(createStatBlock("👥 Students Coached", studentsCoached), 1, 0);
            statsGrid.add(createStatBlock("💵 Rate", dailyRate), 2, 0); 
            statsGrid.add(createStatBlock("📅 Availability", "Mon - Sat"), 3, 0);

            // About & Expertise
            HBox detailsRow = new HBox(40);
            detailsRow.setMaxWidth(Double.MAX_VALUE);
            
            VBox aboutBox = new VBox(10);
            HBox.setHgrow(aboutBox, Priority.ALWAYS);
            Label aboutTitle = new Label("About the Coach");
            aboutTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
            Text bioText = new Text(customBio);
            bioText.setWrappingWidth(600); 
            bioText.setStyle("-fx-font-size: 15px; -fx-fill: #475569; -fx-line-spacing: 6px;");
            aboutBox.getChildren().addAll(aboutTitle, bioText);

            VBox expertiseBox = new VBox(12);
            expertiseBox.setPrefWidth(400);
            Label expTitle = new Label("Areas of Expertise");
            expTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
            FlowPane tagsPane = new FlowPane();
            tagsPane.setHgap(10); tagsPane.setVgap(10);
            tagsPane.setPrefWrapLength(350);
            for (String tag : expertiseTags) {
                Label tagLbl = new Label(tag);
                tagLbl.setStyle("-fx-background-color: #f1f5f9; -fx-text-fill: #334155; -fx-font-size: 13px; -fx-font-weight: bold; -fx-padding: 8 16; -fx-background-radius: 6; -fx-border-color: #e2e8f0; -fx-border-radius: 6;");
                tagsPane.getChildren().add(tagLbl);
            }
            expertiseBox.getChildren().addAll(expTitle, tagsPane);
            
            detailsRow.getChildren().addAll(aboutBox, expertiseBox);

            // Career Highlights
            VBox highlightsBox = new VBox(12);
            highlightsBox.setPadding(new Insets(20, 0, 0, 0));
            Label hlTitle = new Label("Career Highlights");
            hlTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
            highlightsBox.getChildren().add(hlTitle);
            
            for (String highlight : careerHighlights) {
                Label hLbl = new Label("✦  " + highlight);
                hLbl.setStyle("-fx-font-size: 15px; -fx-text-fill: #475569; -fx-font-weight: bold;");
                highlightsBox.getChildren().add(hLbl);
            }

            infoSection.getChildren().addAll(nameBox, statsGrid, detailsRow, highlightsBox);
            profileCard.getChildren().addAll(bannerPane, infoSection);

            mainContainer.getChildren().addAll(header, profileCard);

            ScrollPane scrollPane = new ScrollPane(mainContainer);
            scrollPane.setFitToWidth(true);
            scrollPane.setStyle("-fx-background-color: transparent; -fx-background: #f1f5f9;");
            scrollPane.getStylesheets().add("data:text/css,.scroll-pane > .viewport { -fx-background-color: transparent; }");

            rootLayer.getChildren().add(scrollPane);
        }
        return rootLayer;
    }

    // --- DATA GENERATOR ---
    private void generateDynamicCoachData() {
        if (name.contains("Dravid") || name.contains("Kohli")) {
            experience = "15+ Years";
            studentsCoached = "1,200+";
            dailyRate = "₹2,000 / day"; 
            expertiseTags = Arrays.asList("Top Order Pacing", "Spin Defense", "Mental Toughness", "Cover Drives");
            careerHighlights = Arrays.asList(
                "Former National Team Captain with 10,000+ International Runs.",
                "Coached the U-19 National Team to a World Cup victory.",
                "Specializes in building solid fundamental techniques for long-format games."
            );
            customBio = "A legendary batting figure dedicated to passing on the classical arts of batting. My coaching philosophy revolves around unbreakable defense, immense patience, and dominating the crease through sheer willpower and technique.";
        } 
        else if (specialty.equals("Bowling")) {
            experience = "12+ Years";
            studentsCoached = "800+";
            dailyRate = "₹1,800 / day"; 
            expertiseTags = Arrays.asList("Death Overs", "Reverse Swing", "Pace Generation", "Yorkers");
            careerHighlights = Arrays.asList(
                "Leading wicket-taker in 3 consecutive domestic seasons.",
                "Certified Level 3 NCA Fast Bowling Coach.",
                "Successfully rehabilitated 5 major fast bowlers from severe back injuries."
            );
            customBio = "Fast bowling is an art of rhythm, aggression, and precision. I focus heavily on bio-mechanics to ensure you generate maximum pace without risking injury. Join me to master the art of the perfect yorker.";
        } 
        else if (specialty.equals("Wicket Keeping")) {
            experience = "10+ Years";
            studentsCoached = "400+";
            dailyRate = "₹1,500 / day"; 
            expertiseTags = Arrays.asList("Reflexes", "Spin Keeping", "Stumpings", "Game Reading");
            careerHighlights = Arrays.asList(
                "Record holder for most dismissals in domestic T20 league.",
                "Pioneered modern proactive wicket-keeping techniques.",
                "Consultant coach for various franchise league teams."
            );
            customBio = "The wicket-keeper is the heartbeat of the fielding side. I train my students to read the bowler's hand, anticipate the batter's movement, and develop lightning-fast reflexes that can turn a match in a split second.";
        } 
        else {
            experience = "8+ Years";
            studentsCoached = "650+";
            dailyRate = "₹1,200 / day"; 
            expertiseTags = Arrays.asList("Inner Circle", "Direct Hits", "Agility", "Boundary Catching");
            careerHighlights = Arrays.asList(
                "Renowned as one of the finest point fielders of his generation.",
                "Developed the 'Dynamic Reaction' fielding program used globally.",
                "Won the 'Fielder of the Tournament' award twice."
            );
            customBio = "Matches are won and lost in the field. My sessions are high-intensity and focus on anticipation, safe hands, and aggressive inner-circle pressure. I will make you the fielder the captain always relies on.";
        }
    }

    // --- HELPERS ---
    private VBox createStatBlock(String title, String value) {
        VBox box = new VBox(8);
        box.setPadding(new Insets(20));
        box.setMaxWidth(Double.MAX_VALUE);
        box.setStyle("-fx-background-color: #f8fafc; -fx-border-color: #e2e8f0; -fx-border-radius: 8; -fx-background-radius: 8; -fx-border-width: 1;");
        
        Label tLbl = new Label(title);
        tLbl.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-text-fill: #64748b; text-transform: uppercase;");
        
        Label vLbl = new Label(value);
        vLbl.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
        
        box.getChildren().addAll(tLbl, vLbl);
        return box;
    }

    private String getBadgeStyle(String specialty) {
        switch (specialty) {
            case "Batting": return "-fx-background-color: #dbeafe; -fx-text-fill: #1d4ed8;";
            case "Bowling": return "-fx-background-color: #dcfce7; -fx-text-fill: #15803d;";
            case "Fielding": return "-fx-background-color: #fef9c3; -fx-text-fill: #a16207;";
            case "Wicket Keeping": return "-fx-background-color: #f3e8ff; -fx-text-fill: #7e22ce;";
            default: return "-fx-background-color: #f1f5f9; -fx-text-fill: #475569;";
        }
    }

    private String getBannerGradient(String specialty) {
        switch (specialty) {
            case "Batting": return "linear-gradient(to right, #3b82f6, #1d4ed8)"; 
            case "Bowling": return "linear-gradient(to right, #10b981, #047857)"; 
            case "Fielding": return "linear-gradient(to right, #f59e0b, #b45309)"; 
            case "Wicket Keeping": return "linear-gradient(to right, #8b5cf6, #6d28d9)"; 
            default: return "linear-gradient(to right, #64748b, #334155)"; 
        }
    }

    private void addHoverEffect(Node node, String defaultStyle, String hoverStyle) {
        ScaleTransition scaleIn = new ScaleTransition(Duration.millis(150), node);
        scaleIn.setToX(1.03); scaleIn.setToY(1.03);
        ScaleTransition scaleOut = new ScaleTransition(Duration.millis(150), node);
        scaleOut.setToX(1.0); scaleOut.setToY(1.0);

        node.setOnMouseEntered(e -> {
            node.setStyle(hoverStyle + node.getStyle().substring(node.getStyle().indexOf("-fx-border-radius"))); 
            scaleIn.playFromStart();
        });
        node.setOnMouseExited(e -> {
            node.setStyle(defaultStyle + node.getStyle().substring(node.getStyle().indexOf("-fx-border-radius")));
            scaleOut.playFromStart();
        });
    }
}