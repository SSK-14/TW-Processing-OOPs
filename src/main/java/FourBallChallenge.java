import processing.core.PApplet;
import java.util.ArrayList;
import java.util.List;

public class FourBallChallenge extends PApplet {
    public static final int WIDTH = 620;
    public static final int HEIGHT = 480;
    public static final int DIAMETER = 12;
    public static final int BALL_COUNT = 4;
    public static final int PARTITION_SIZE = 5;

    public final List<Ball> balls = new ArrayList<>();

    public static void main(String[] args) {
        PApplet.main(FourBallChallenge.class, args);
    }

    @Override
    public void settings() {
        super.settings();
        size(WIDTH, HEIGHT);
    }

    @Override
    public void setup() {
        for (int ballNumber = 1; ballNumber <= BALL_COUNT; ballNumber++) {
            Ball ball = buildBall(ballNumber);
            balls.add(ball);
        }
    }

    private Ball buildBall(int ballNumber) {
        int initialXAxisPosition = 0;
        int initialYAxisPosition = (ballNumber * HEIGHT) / PARTITION_SIZE;
        return new Ball(ballNumber, initialXAxisPosition, initialYAxisPosition, DIAMETER);
    }

    @Override
    public void draw() {
        for (Ball ball : balls) {
            ball.draw(this);
            ball.move();
        }
    }
}
