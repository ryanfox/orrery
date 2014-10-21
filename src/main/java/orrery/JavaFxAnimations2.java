package orrery;

/**
 *
 * @author maxspolaor
 */
import java.util.List;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class JavaFxAnimations2 extends Application {
    /**
     * Generate Path upon which animation will occur.
     *
     * @param pathOpacity The opacity of the path representation.
     * @return Generated path.
     */
    private Path generateCurvyPath(final double pathOpacity) {
        PlanetarySystem system = new PlanetarySystem();
        double period = system.getPeriod()/(60 * 60 * 24);
        double[] x = new double[376];
        double[] y = new double[376];


        for(int i = 0; i <= period; i++) {
            x[i] =  (1 * Math.cos((i / period) * 2 * Math.PI)*100) + 500;
            y[i] = (1 * Math.sin((i / period) * 2 * Math.PI)*100) + 500;
            System.out.println(i + " " + x[i] + " " + y[i]);
        }


        final Path path = new Path();
        path.getElements().add(new MoveTo(600.0, 500.0));
        for (int i = 0; i< x.length; i++){
            path.getElements().add(new LineTo(x[i], y[i]));
        }
        path.setOpacity(pathOpacity);
        return path;
    }


    /**
     * Generate the path transition.
     *
     * @param shape Shape to travel along path.
     * @param path Path to be traveled upon.
     * @return PathTransition.
     */
    private PathTransition generatePathTransition(final Shape shape, final Path path) {
        final PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(8.0));
        pathTransition.setDelay(Duration.seconds(2.0));
        pathTransition.setPath(path);
        pathTransition.setNode(shape);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.setAutoReverse(false);
        return pathTransition;
    }

    /**
     * Determine the path's opacity based on command-line argument if supplied
     * or zero by default if no numeric value provided.
     *
     * @return Opacity to use for path.
     */
    private double determinePathOpacity() {
        final Parameters params = getParameters();
        final List<String> parameters = params.getRaw();
        double pathOpacity = 0.5;
        if (!parameters.isEmpty()) {
            try {
                pathOpacity = Double.valueOf(parameters.get(0));
            } catch (NumberFormatException nfe)  {
                pathOpacity = 0.0;
            }
        }
        return pathOpacity;
    }

    /**
     * Apply animation, the subject of this class.
     *
     * @param group Group to which animation is applied.
     */
    private void applyAnimation(final Group group) {
        final Circle circle = new Circle(20, 20, 15);
        circle.setFill(Color.DARKRED);
        final Path path = generateCurvyPath(determinePathOpacity());
        group.getChildren().add(path);
        group.getChildren().add(circle);
        group.getChildren().add(new Circle(500, 500, 5));
        final PathTransition transition = generatePathTransition(circle, path);
        transition.play();
    }

    /**
     * Start the JavaFX application
     *
     * @param stage Primary stage.
     * @throws Exception Exception thrown during application.
     */
    @Override
    public void start(final Stage stage) throws Exception {
        final Group rootGroup = new Group();
        final Scene scene = new Scene(rootGroup, 1000, 1000, Color.GHOSTWHITE);
        stage.setScene(scene);
        stage.setTitle("JavaFX 2 Animations");
        stage.show();
        applyAnimation(rootGroup);
    }

    /**
     * Main function for running JavaFX application.
     *
     * @param arguments Command-line arguments; optional first argument is the
     *    opacity of the path to be displayed (0 effectively renders path
     *    invisible).
     */
    public static void main(final String[] arguments) {
        Application.launch(arguments);
    }
}
