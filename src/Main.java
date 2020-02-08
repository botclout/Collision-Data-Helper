import org.osbot.rs07.api.map.Position;
import org.osbot.rs07.input.mouse.BotMouseListener;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;

import java.awt.*;
import java.awt.event.MouseEvent;

@ScriptManifest(info = "", version = 1.00, logo = "", name = "Collision Data Helper", author = "camaro")

public class Main extends Script {

    CollisionView view;

    MouseEventConsumer consumer;

    BotMouseListener listener = new BotMouseListener() {
        @Override
        public void checkMouseEvent(MouseEvent mouseEvent) {
            consumer.run(mouseEvent);
        }
    };

    @Override
    public void onPaint(Graphics2D g) {
        if (consumer != null) {
            Position p = consumer.currentPosition;
            if (p != null) {
                Polygon poly = p.getPolygon(getBot());
                g.setColor(Color.GREEN);
                g.drawPolygon(poly);
            }
        }
    }

    @Override
    public void onStart() {
        consumer = new MouseEventConsumer(getBot());
        view = new CollisionView();
        consumer.addObserver(view);
        getBot().addMouseListener(listener);
        view.setVisible(true);
    }

    @Override
    public int onLoop() throws InterruptedException {
        return 1000;
    }

    @Override
    public void onExit() {
        view.setVisible(false);
        getBot().removeMouseListener(listener);
    }
}
