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

// public class Fitness_LogNutritionButton {

//     private StackPane rootContainer;
//     private Runnable onBack;

//     // Interactive state for hydration
//     private double currentHydration = 1.8;
//     private final double MAX_HYDRATION = 3.5;
//     private Label hydrationValueLabel;
//     private Rectangle waterFill;
//     private final double MAX_BOTTLE_HEIGHT = 160.0;

//     public Fitness_LogNutritionButton(Runnable onBack) {
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
            
//             // Main Content: Hydration and Nutrition Log
//             HBox contentRow = new HBox(30);
            
//             VBox hydrationCard = buildHydrationCard();
//             VBox nutritionCard = buildNutritionLogCard();
            
//             HBox.setHgrow(nutritionCard, Priority.ALWAYS);
//             contentRow.getChildren().addAll(hydrationCard, nutritionCard);

//             mainLayout.getChildren().addAll(backButtonRow, contentRow);

//             // --- Entrance Animations ---
//             animateNodeEntrance(backButtonRow, 0);
//             animateNodeEntrance(hydrationCard, 100);
//             animateNodeEntrance(nutritionCard, 200);

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
//         scaleIn.setToX(1.03); scaleIn.setToY(1.03);
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

//     // --- HYDRATION CARD ---
//     private VBox buildHydrationCard() {
//         VBox box = new VBox(25);
//         box.setPrefWidth(320); box.setMinWidth(320);
//         box.setAlignment(Pos.TOP_CENTER);
//         box.setPadding(new Insets(30));
//         box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.04), 15, 0, 0, 5);");

//         // Header
//         HBox header = new HBox();
//         header.setAlignment(Pos.CENTER_LEFT);
//         Label icon = new Label("💧"); icon.setStyle("-fx-text-fill: #10b981; -fx-font-size: 18px;");
//         Label title = new Label(" Hydration"); title.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: #0f172a;");
//         Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);
//         Label goal = new Label("Goal: 3.5L"); goal.setStyle("-fx-font-size: 12px; -fx-text-fill: #64748b; -fx-font-weight: bold;");
//         header.getChildren().addAll(icon, title, sp, goal);

//         // Water Bottle Visual
//         StackPane bottleContainer = new StackPane();
//         bottleContainer.setPrefSize(140, MAX_BOTTLE_HEIGHT);
//         bottleContainer.setMaxSize(140, MAX_BOTTLE_HEIGHT);

//         Rectangle bottleBg = new Rectangle(140, MAX_BOTTLE_HEIGHT);
//         bottleBg.setArcWidth(40); bottleBg.setArcHeight(40);
//         bottleBg.setFill(Color.web("#f1f5f9"));

//         waterFill = new Rectangle(140, (currentHydration / MAX_HYDRATION) * MAX_BOTTLE_HEIGHT);
//         waterFill.setArcWidth(40); waterFill.setArcHeight(40);
//         waterFill.setFill(Color.web("#bbf7d0")); // Light green water color
//         StackPane.setAlignment(waterFill, Pos.BOTTOM_CENTER);

//         hydrationValueLabel = new Label(String.format("%.1fL", currentHydration));
//         hydrationValueLabel.setStyle("-fx-font-size: 32px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");

//         bottleContainer.getChildren().addAll(bottleBg, waterFill, hydrationValueLabel);

//         // Add Buttons
//         HBox btnRow = new HBox(15);
//         btnRow.setAlignment(Pos.CENTER);

//         VBox btn250 = createAddWaterBtn("🥛", "250ml", 0.25);
//         VBox btn500 = createAddWaterBtn("🍼", "500ml", 0.50);

//         btnRow.getChildren().addAll(btn250, btn500);

//         box.getChildren().addAll(header, bottleContainer, btnRow);
//         return box;
//     }

//     private VBox createAddWaterBtn(String icon, String text, double amountToAdd) {
//         VBox btn = new VBox(5);
//         btn.setAlignment(Pos.CENTER);
//         btn.setPrefSize(80, 80);
//         btn.setStyle("-fx-background-color: #f8fafc; -fx-background-radius: 12; -fx-cursor: hand; -fx-border-color: #e2e8f0; -fx-border-radius: 12;");
//         addHoverScale(btn);

//         Label iLbl = new Label(icon); iLbl.setStyle("-fx-font-size: 20px; -fx-text-fill: #64748b;");
//         Label tLbl = new Label(text); tLbl.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
//         btn.getChildren().addAll(iLbl, tLbl);

//         // Interactive Logic
//         btn.setOnMouseClicked(e -> {
//             if (currentHydration < MAX_HYDRATION) {
//                 currentHydration += amountToAdd;
//                 if (currentHydration > MAX_HYDRATION) currentHydration = MAX_HYDRATION;
                
//                 // Update Label
//                 hydrationValueLabel.setText(String.format("%.1fL", currentHydration));
                
//                 // Animate Water Level filling up
//                 double newHeight = (currentHydration / MAX_HYDRATION) * MAX_BOTTLE_HEIGHT;
//                 waterFill.setHeight(newHeight);
//             }
//         });

//         return btn;
//     }

//     // --- NUTRITION LOG CARD ---
//     private VBox buildNutritionLogCard() {
//         VBox box = new VBox(20);
//         box.setPadding(new Insets(30));
//         box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.04), 15, 0, 0, 5);");

//         // Header
//         HBox header = new HBox();
//         header.setAlignment(Pos.CENTER_LEFT);
//         Label title = new Label("Nutrition Log"); title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #0f172a;");
//         Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);
//         Label aiBadge = new Label("AI Suggestions Active");
//         aiBadge.setStyle("-fx-background-color: #d1fae5; -fx-text-fill: #10b981; -fx-font-weight: bold; -fx-font-size: 11px; -fx-padding: 6 12; -fx-background-radius: 15;");
//         header.getChildren().addAll(title, sp, aiBadge);

//         // Content List
//         VBox list = new VBox(15);

//         // Meal 1
//         list.getChildren().add(createMealItem("🌅", "#fee2e2", "#ef4444", "Breakfast", "Oatmeal, protein shake, berries", "620"));
        
//         // Meal 2
//         list.getChildren().add(createMealItem("☀️", "#fef08a", "#eab308", "Lunch", "Grilled chicken, quinoa, spinach salad", "780"));

//         // Coach Suggestion
//         VBox suggestionBox = new VBox(8);
//         suggestionBox.setPadding(new Insets(20));
//         suggestionBox.setStyle("-fx-background-color: #0f172a; -fx-background-radius: 12; -fx-border-color: #10b981; -fx-border-width: 0 0 0 4; -fx-border-radius: 12;");
        
//         HBox sugHeader = new HBox(5);
//         sugHeader.setAlignment(Pos.CENTER_LEFT);
//         Label sugIcon = new Label("✨"); sugIcon.setStyle("-fx-text-fill: #10b981;");
//         Label sugTitle = new Label("COACH SUGGESTION"); sugTitle.setStyle("-fx-text-fill: #34d399; -fx-font-weight: bold; -fx-font-size: 10px; -fx-letter-spacing: 1px;");
//         sugHeader.getChildren().addAll(sugIcon, sugTitle);

//         Label sugText = new Label("\"Increase protein intake by 20g in dinner to support muscle recovery from today's sprint training.\"");
//         sugText.setWrapText(true);
//         sugText.setStyle("-fx-text-fill: white; -fx-font-style: italic; -fx-font-size: 13px; -fx-line-spacing: 5px;");
        
//         suggestionBox.getChildren().addAll(sugHeader, sugText);
//         addHoverScale(suggestionBox);
//         list.getChildren().add(suggestionBox);

//         // Pending Meal
//         HBox pendingRow = new HBox(15);
//         pendingRow.setAlignment(Pos.CENTER_LEFT);
//         pendingRow.setPadding(new Insets(15, 20, 15, 20));
//         pendingRow.setStyle("-fx-background-color: transparent; -fx-border-color: #e2e8f0; -fx-border-style: dashed; -fx-border-radius: 12; -fx-background-radius: 12; -fx-cursor: hand;");
//         addHoverScale(pendingRow);

//         StackPane pIconPane = new StackPane();
//         Circle pC = new Circle(20, Color.web("#f1f5f9"));
//         Label pI = new Label("🌙"); pI.setStyle("-fx-font-size: 16px;");
//         pIconPane.getChildren().addAll(pC, pI);

//         VBox pTexts = new VBox(3);
//         Label pT = new Label("Dinner"); pT.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: #0f172a;");
//         Label pS = new Label("Not logged yet"); pS.setStyle("-fx-font-size: 12px; -fx-text-fill: #94a3b8;");
//         pTexts.getChildren().addAll(pT, pS);

//         Region pSp = new Region(); HBox.setHgrow(pSp, Priority.ALWAYS);
//         Label addLbl = new Label("+ Add Meal");
//         addLbl.setStyle("-fx-text-fill: #10b981; -fx-font-weight: bold; -fx-font-size: 13px;");

//         pendingRow.getChildren().addAll(pIconPane, pTexts, pSp, addLbl);
//         list.getChildren().add(pendingRow);

//         box.getChildren().addAll(header, list);
//         return box;
//     }

//     private HBox createMealItem(String icon, String bgHex, String iconHex, String title, String sub, String kcal) {
//         HBox row = new HBox(15);
//         row.setAlignment(Pos.CENTER_LEFT);
//         row.setPadding(new Insets(15, 20, 15, 20));
//         row.setStyle("-fx-background-color: #f8fafc; -fx-background-radius: 12; -fx-border-color: #f1f5f9; -fx-border-radius: 12;");
//         addHoverScale(row);

//         StackPane iconPane = new StackPane();
//         Circle c = new Circle(20, Color.web(bgHex));
//         Label i = new Label(icon); i.setStyle("-fx-text-fill: " + iconHex + "; -fx-font-size: 16px;");
//         iconPane.getChildren().addAll(c, i);

//         VBox texts = new VBox(3);
//         Label t = new Label(title); t.setStyle("-fx-font-weight: bold; -fx-font-size: 15px; -fx-text-fill: #0f172a;");
//         Label s = new Label(sub); s.setStyle("-fx-font-size: 12px; -fx-text-fill: #64748b;");
//         texts.getChildren().addAll(t, s);

//         Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);

//         VBox kcalBox = new VBox(); kcalBox.setAlignment(Pos.CENTER_RIGHT);
//         Label kcV = new Label(kcal); kcV.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #0f172a;");
//         Label kcL = new Label("kcal"); kcL.setStyle("-fx-font-size: 11px; -fx-text-fill: #94a3b8; -fx-font-weight: bold;");
//         kcalBox.getChildren().addAll(kcV, kcL);

//         row.getChildren().addAll(iconPane, texts, sp, kcalBox);
//         return row;
//     }
// }

package com.athlixcore.view.player.Training_Fitness;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
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

public class Fitness_LogNutritionButton {

    private StackPane rootContainer;
    private Runnable onBack;

    // Interactive state for hydration
    private double currentHydration = 1.8;
    private final double MAX_HYDRATION = 3.5;
    
    // UI Elements that need dynamic updating
    private Label hydrationValueLabel;
    private Rectangle waterFill;
    private Label goalLabel;
    private VBox hydrationCardBox;
    private final double MAX_BOTTLE_HEIGHT = 160.0;

    public Fitness_LogNutritionButton(Runnable onBack) {
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
            
            // Main Content: Hydration and Nutrition Log
            HBox contentRow = new HBox(30);
            
            hydrationCardBox = buildHydrationCard();
            VBox nutritionCard = buildNutritionLogCard();
            
            HBox.setHgrow(nutritionCard, Priority.ALWAYS);
            contentRow.getChildren().addAll(hydrationCardBox, nutritionCard);

            mainLayout.getChildren().addAll(backButtonRow, contentRow);

            // --- Entrance Animations ---
            animateNodeEntrance(backButtonRow, 0);
            animateNodeEntrance(hydrationCardBox, 100);
            animateNodeEntrance(nutritionCard, 200);

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
        scaleIn.setToX(1.03); scaleIn.setToY(1.03);
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

    // --- HYDRATION CARD (With Animations & Theme Switching) ---
    private VBox buildHydrationCard() {
        VBox box = new VBox(25);
        box.setPrefWidth(320); box.setMinWidth(320);
        box.setAlignment(Pos.TOP_CENTER);
        box.setPadding(new Insets(30));
        box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.04), 15, 0, 0, 5); -fx-border-color: transparent; -fx-border-width: 2; -fx-border-radius: 16;");

        // Header
        HBox header = new HBox();
        header.setAlignment(Pos.CENTER_LEFT);
        Label icon = new Label("💧"); icon.setStyle("-fx-text-fill: #10b981; -fx-font-size: 18px;");
        Label title = new Label(" Hydration"); title.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: #0f172a;");
        Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);
        goalLabel = new Label("Goal: 3.5L"); goalLabel.setStyle("-fx-font-size: 12px; -fx-text-fill: #64748b; -fx-font-weight: bold;");
        header.getChildren().addAll(icon, title, sp, goalLabel);

        // Water Bottle Visual
        StackPane bottleContainer = new StackPane();
        bottleContainer.setPrefSize(140, MAX_BOTTLE_HEIGHT);
        bottleContainer.setMaxSize(140, MAX_BOTTLE_HEIGHT);

        Rectangle bottleBg = new Rectangle(140, MAX_BOTTLE_HEIGHT);
        bottleBg.setArcWidth(40); bottleBg.setArcHeight(40);
        bottleBg.setFill(Color.web("#f1f5f9"));

        waterFill = new Rectangle(140, (currentHydration / MAX_HYDRATION) * MAX_BOTTLE_HEIGHT);
        waterFill.setArcWidth(40); waterFill.setArcHeight(40);
        waterFill.setFill(Color.web("#bbf7d0")); // Light green water color
        StackPane.setAlignment(waterFill, Pos.BOTTOM_CENTER);

        hydrationValueLabel = new Label(String.format("%.1fL", currentHydration));
        hydrationValueLabel.setStyle("-fx-font-size: 32px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");

        bottleContainer.getChildren().addAll(bottleBg, waterFill, hydrationValueLabel);

        // Add Buttons
        HBox btnRow = new HBox(15);
        btnRow.setAlignment(Pos.CENTER);

        VBox btn250 = createAddWaterBtn("🥛", "250ml", 0.25);
        VBox btn500 = createAddWaterBtn("🍼", "500ml", 0.50);

        btnRow.getChildren().addAll(btn250, btn500);

        box.getChildren().addAll(header, bottleContainer, btnRow);
        return box;
    }

    private VBox createAddWaterBtn(String icon, String text, double amountToAdd) {
        VBox btn = new VBox(5);
        btn.setAlignment(Pos.CENTER);
        btn.setPrefSize(80, 80);
        btn.setStyle("-fx-background-color: #f8fafc; -fx-background-radius: 12; -fx-cursor: hand; -fx-border-color: #e2e8f0; -fx-border-radius: 12;");
        addHoverScale(btn);

        Label iLbl = new Label(icon); iLbl.setStyle("-fx-font-size: 20px; -fx-text-fill: #64748b;");
        Label tLbl = new Label(text); tLbl.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #0f172a;");
        btn.getChildren().addAll(iLbl, tLbl);

        // Interactive Logic with Animation
        btn.setOnMouseClicked(e -> {
            if (currentHydration < MAX_HYDRATION) {
                currentHydration += amountToAdd;
                
                if (currentHydration >= MAX_HYDRATION) {
                    currentHydration = MAX_HYDRATION;
                    
                    // --- GOAL REACHED: THEME CHANGE ANIMATION ---
                    Timeline timeline = new Timeline(
                        new KeyFrame(Duration.millis(500), 
                            new KeyValue(waterFill.heightProperty(), MAX_BOTTLE_HEIGHT),
                            new KeyValue(waterFill.fillProperty(), Color.web("#10b981")) // Turns solid green
                        )
                    );
                    timeline.play();
                    
                    hydrationValueLabel.setText(String.format("%.1fL", currentHydration));
                    hydrationValueLabel.setStyle("-fx-font-size: 32px; -fx-font-weight: bold; -fx-text-fill: #10b981;");
                    
                    goalLabel.setText("🎉 GOAL REACHED!");
                    goalLabel.setStyle("-fx-font-size: 12px; -fx-text-fill: #10b981; -fx-font-weight: bold;");
                    
                    hydrationCardBox.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(16,185,129,0.35), 20, 0, 0, 8); -fx-border-color: #10b981; -fx-border-width: 2; -fx-border-radius: 16;");
                    
                } else {
                    // --- NORMAL FILL ANIMATION ---
                    double newHeight = (currentHydration / MAX_HYDRATION) * MAX_BOTTLE_HEIGHT;
                    
                    Timeline timeline = new Timeline(
                        new KeyFrame(Duration.millis(400), 
                            new KeyValue(waterFill.heightProperty(), newHeight)
                        )
                    );
                    timeline.play();
                    
                    hydrationValueLabel.setText(String.format("%.1fL", currentHydration));
                }
            }
        });

        return btn;
    }

    // --- ATHLETE-FOCUSED NUTRITION LOG CARD ---
    private VBox buildNutritionLogCard() {
        VBox box = new VBox(20);
        box.setPadding(new Insets(30));
        box.setStyle("-fx-background-color: white; -fx-background-radius: 16; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.04), 15, 0, 0, 5);");

        // Header
        HBox header = new HBox();
        header.setAlignment(Pos.CENTER_LEFT);
        Label title = new Label("Performance Nutrition Log"); title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #0f172a;");
        Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);
        Label aiBadge = new Label("AI Suggestions Active");
        aiBadge.setStyle("-fx-background-color: #d1fae5; -fx-text-fill: #10b981; -fx-font-weight: bold; -fx-font-size: 11px; -fx-padding: 6 12; -fx-background-radius: 15;");
        header.getChildren().addAll(title, sp, aiBadge);

        // Content List
        VBox list = new VBox(15);

        // Athletic Meals with Macros (P / C / F)
        list.getChildren().add(createAthleteMealItem("🌅", "#fee2e2", "#ef4444", "Pre-Training Fuel", "Oats, Whey Protein, Banana", "450", "35g", "60g", "8g"));
        list.getChildren().add(createAthleteMealItem("☀️", "#fef08a", "#eab308", "Post-Match Recovery", "Grilled Chicken, Quinoa, Spinach", "780", "45g", "95g", "15g"));

        // Coach Suggestion (Tailored for fitness)
        VBox suggestionBox = new VBox(8);
        suggestionBox.setPadding(new Insets(20));
        suggestionBox.setStyle("-fx-background-color: #0f172a; -fx-background-radius: 12; -fx-border-color: #10b981; -fx-border-width: 0 0 0 4; -fx-border-radius: 12;");
        
        HBox sugHeader = new HBox(5);
        sugHeader.setAlignment(Pos.CENTER_LEFT);
        Label sugIcon = new Label("✨"); sugIcon.setStyle("-fx-text-fill: #10b981;");
        Label sugTitle = new Label("COACH SUGGESTION"); sugTitle.setStyle("-fx-text-fill: #34d399; -fx-font-weight: bold; -fx-font-size: 10px; -fx-letter-spacing: 1px;");
        sugHeader.getChildren().addAll(sugIcon, sugTitle);

        Label sugText = new Label("\"Heavy glycogen depletion detected from your 20m sprint training. Increase complex carb intake by 50g in your dinner to fully restore muscle glycogen stores for tomorrow's match.\"");
        sugText.setWrapText(true);
        sugText.setStyle("-fx-text-fill: white; -fx-font-style: italic; -fx-font-size: 13px; -fx-line-spacing: 5px;");
        
        suggestionBox.getChildren().addAll(sugHeader, sugText);
        addHoverScale(suggestionBox);
        list.getChildren().add(suggestionBox);

        // Pending Meal
        HBox pendingRow = new HBox(15);
        pendingRow.setAlignment(Pos.CENTER_LEFT);
        pendingRow.setPadding(new Insets(15, 20, 15, 20));
        pendingRow.setStyle("-fx-background-color: transparent; -fx-border-color: #e2e8f0; -fx-border-style: dashed; -fx-border-radius: 12; -fx-background-radius: 12; -fx-cursor: hand;");
        addHoverScale(pendingRow);

        StackPane pIconPane = new StackPane();
        Circle pC = new Circle(20, Color.web("#f1f5f9"));
        Label pI = new Label("🌙"); pI.setStyle("-fx-font-size: 16px;");
        pIconPane.getChildren().addAll(pC, pI);

        VBox pTexts = new VBox(3);
        Label pT = new Label("Evening Macros"); pT.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: #0f172a;");
        Label pS = new Label("Not logged yet"); pS.setStyle("-fx-font-size: 12px; -fx-text-fill: #94a3b8;");
        pTexts.getChildren().addAll(pT, pS);

        Region pSp = new Region(); HBox.setHgrow(pSp, Priority.ALWAYS);
        Label addLbl = new Label("+ Add Meal");
        addLbl.setStyle("-fx-text-fill: #10b981; -fx-font-weight: bold; -fx-font-size: 13px;");

        pendingRow.getChildren().addAll(pIconPane, pTexts, pSp, addLbl);
        list.getChildren().add(pendingRow);

        box.getChildren().addAll(header, list);
        return box;
    }

    private HBox createAthleteMealItem(String icon, String bgHex, String iconHex, String title, String sub, String kcal, String p, String c, String f) {
        HBox row = new HBox(15);
        row.setAlignment(Pos.CENTER_LEFT);
        row.setPadding(new Insets(15, 20, 15, 20));
        row.setStyle("-fx-background-color: #f8fafc; -fx-background-radius: 12; -fx-border-color: #f1f5f9; -fx-border-radius: 12;");
        addHoverScale(row);

        StackPane iconPane = new StackPane();
        Circle circ = new Circle(20, Color.web(bgHex));
        Label i = new Label(icon); i.setStyle("-fx-text-fill: " + iconHex + "; -fx-font-size: 16px;");
        iconPane.getChildren().addAll(circ, i);

        VBox texts = new VBox(6);
        Label t = new Label(title); t.setStyle("-fx-font-weight: bold; -fx-font-size: 15px; -fx-text-fill: #0f172a;");
        Label s = new Label(sub); s.setStyle("-fx-font-size: 12px; -fx-text-fill: #64748b;");
        
        // Macronutrients Badges
        HBox macros = new HBox(8);
        Label pLbl = new Label("P: " + p); pLbl.setStyle("-fx-font-size: 10px; -fx-text-fill: #ef4444; -fx-font-weight: bold; -fx-background-color: #fee2e2; -fx-padding: 3 8; -fx-background-radius: 6;");
        Label cLbl = new Label("C: " + c); cLbl.setStyle("-fx-font-size: 10px; -fx-text-fill: #3b82f6; -fx-font-weight: bold; -fx-background-color: #dbeafe; -fx-padding: 3 8; -fx-background-radius: 6;");
        Label fLbl = new Label("F: " + f); fLbl.setStyle("-fx-font-size: 10px; -fx-text-fill: #eab308; -fx-font-weight: bold; -fx-background-color: #fef08a; -fx-padding: 3 8; -fx-background-radius: 6;");
        macros.getChildren().addAll(pLbl, cLbl, fLbl);
        
        texts.getChildren().addAll(t, s, macros);

        Region sp = new Region(); HBox.setHgrow(sp, Priority.ALWAYS);

        VBox kcalBox = new VBox(); kcalBox.setAlignment(Pos.CENTER_RIGHT);
        Label kcV = new Label(kcal); kcV.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: #0f172a;");
        Label kcL = new Label("kcal"); kcL.setStyle("-fx-font-size: 11px; -fx-text-fill: #94a3b8; -fx-font-weight: bold;");
        kcalBox.getChildren().addAll(kcV, kcL);

        row.getChildren().addAll(iconPane, texts, sp, kcalBox);
        return row;
    }
}