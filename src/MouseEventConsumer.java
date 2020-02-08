import org.osbot.rs07.Bot;
import org.osbot.rs07.api.map.Position;
import org.osbot.rs07.script.MethodProvider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class MouseEventConsumer extends Observable {

    public Position currentPosition = null;

    public final List<String> elements = new ArrayList<>();

    private final MethodProvider api;

    public MouseEventConsumer(Bot bot) {
        api = bot.getMethods();
    }

    private void addPositions(Position pos) {
        currentPosition = pos;
        elements.clear();
        int flag = api.getMap().getClippingFlags()[pos.getLocalX(api.getBot())][pos.getLocalY(api.getBot())];
        for (Collision coll : Collision.values()) {
            if ((coll.flag & flag) == coll.flag) {
                elements.add(coll.toString().replace('_', ' '));
            }
        }
        setChanged();
        notifyObservers();
    }

    public void run(MouseEvent event) {
        if (event != null && SwingUtilities.isRightMouseButton(event) && event.getID() == MouseEvent.MOUSE_PRESSED) {
            List<Position> positions = api.myPlayer().getArea(10).getPositions();
            for (Position pos : positions) {
                Polygon poly = pos.getPolygon(api.getBot());
                if (poly.contains(event.getPoint())) {
                    addPositions(pos);
                    break;
                }
            }
        }
    }

}
