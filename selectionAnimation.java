import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class selectionAnimation extends Application {

    private static final int ARRAY_SIZE = 6;
    private static final int RECT_WIDTH = 50;
    private static final int RECT_SPACING = 10;
    private static final int CANVAS_WIDTH = ARRAY_SIZE * (RECT_WIDTH + RECT_SPACING) - RECT_SPACING;
    private static final int CANVAS_HEIGHT = 200;
    private static final int ANIMATION_DURATION = 1000;

    private Comparable[] array = {59, 66, 3, 7, 29, 9};
    private Rectangle[] rectangles = new Rectangle[ARRAY_SIZE];
    private Text[] valueTexts = new Text[ARRAY_SIZE];

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        for (int i = 0; i < ARRAY_SIZE; i++) {
            Rectangle rect = new Rectangle(i * (RECT_WIDTH + RECT_SPACING), CANVAS_HEIGHT - (int) array[i], RECT_WIDTH, (int) array[i]);
            rect.setFill(Color.BLUE);
            rectangles[i] = rect;
            pane.getChildren().add(rect);

            Text text = new Text(String.valueOf(array[i]));
            text.setLayoutX(i * (RECT_WIDTH + RECT_SPACING) + RECT_WIDTH / 2 - text.getBoundsInLocal().getWidth() / 2);
            text.setLayoutY(CANVAS_HEIGHT - (int) array[i] - 5);
            valueTexts[i] = text;
            pane.getChildren().add(text);
        }

        Scene scene = new Scene(pane, CANVAS_WIDTH, CANVAS_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Selection Sort Visualization");
        primaryStage.show();

        Timeline timeline = new Timeline();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            int finalI = i;
            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.seconds(i + 1), e -> {
                        sortStep(finalI);
                        updateVisualization();
                    })
            );
        }
        timeline.play();
    }

    private void sortStep(int i) {
        int minIndex = i;
        for (int j = i + 1; j < ARRAY_SIZE; j++) {
            if (less(array[j], array[minIndex])) {
                minIndex = j;
            }
        }
        if (i != minIndex) {
            Comparable temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;

            Text tempText = valueTexts[i];
            valueTexts[i] = valueTexts[minIndex];
            valueTexts[minIndex] = tempText;
        }
    }

    private boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private void updateVisualization() {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            Rectangle rect = rectangles[i];
            Text text = valueTexts[i];

            double newX = i * (RECT_WIDTH + RECT_SPACING);
            double newY = CANVAS_HEIGHT - (int) array[i];

            animation(rect, newX, newY, (int) array[i]);
            animation(text, newX + RECT_WIDTH / 2 - text.getBoundsInLocal().getWidth() / 2, newY - 5);
        }
    }

    private void animation(Rectangle rect, double newX, double newY, int height) {
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO, e -> {
                }),
                new KeyFrame(Duration.millis(ANIMATION_DURATION), e -> {
                    rect.setX(newX);
                    rect.setY(newY);
                    rect.setHeight(height);
                })
        );
        timeline.play();
    }

    private void animation(Text text, double newX, double newY) {
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO, e -> {
                }),
                new KeyFrame(Duration.millis(ANIMATION_DURATION), e -> {
                    text.setLayoutX(newX);
                    text.setLayoutY(newY);
                })
        );
        timeline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}