package view;

import boardifier.model.GameElement;
import boardifier.view.ElementLook;
import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.Escape;
import model.Pawn;

public class EscapeLook extends ElementLook{

    private Rectangle rectangle;


    public EscapeLook(int width, GameElement element) {
        super(element);
        SVGPath path1 = new SVGPath();
        path1.setContent("M 39.03125 0 L 36.023438 0 C 35.652344 0 35.355469 0.300781 35.355469 0.667969 L 35.355469 3.5625 L 32.90625 3.5625 L 32.90625 0.667969 C 32.90625 0.300781 32.609375 0 32.238281 0 L 27.28125 0 C 26.910156 0 26.613281 0.300781 26.613281 0.667969 L 26.613281 3.5625 L 24.164062 3.5625 L 24.164062 0.667969 C 24.164062 0.300781 23.867188 0 23.496094 0 L 18.539062 0 C 18.167969 0 17.871094 0.300781 17.871094 0.667969 L 17.871094 3.5625 L 15.421875 3.5625 L 15.421875 0.667969 C 15.421875 0.300781 15.125 0 14.753906 0 L 11.96875 0 C 11.601562 0 11.300781 0.300781 11.300781 0.667969 L 11.300781 11.136719 C 11.300781 11.503906 11.601562 11.804688 11.96875 11.804688 L 14.308594 11.804688 L 14.308594 50.332031 C 14.308594 50.699219 14.609375 51 14.976562 51 L 36.023438 51 C 36.390625 51 36.691406 50.699219 36.691406 50.332031 L 36.691406 11.804688 L 39.03125 11.804688 C 39.398438 11.804688 39.699219 11.503906 39.699219 11.136719 L 39.699219 0.667969 C 39.699219 0.300781 39.398438 0 39.03125 0 Z M 20.988281 49.664062 L 18.316406 49.664062 L 18.316406 44.097656 C 18.316406 43.359375 18.917969 42.761719 19.652344 42.761719 C 20.390625 42.761719 20.988281 43.359375 20.988281 44.097656 Z M 35.355469 49.664062 L 22.328125 49.664062 L 22.328125 44.097656 C 22.328125 42.621094 21.128906 41.421875 19.652344 41.421875 C 18.179688 41.421875 16.980469 42.621094 16.980469 44.097656 L 16.980469 49.664062 L 15.644531 49.664062 L 15.644531 11.804688 L 35.355469 11.804688 Z M 38.363281 10.46875 L 12.636719 10.46875 L 12.636719 1.335938 L 14.085938 1.335938 L 14.085938 4.230469 C 14.085938 4.601562 14.386719 4.898438 14.753906 4.898438 L 18.539062 4.898438 C 18.90625 4.898438 19.207031 4.601562 19.207031 4.230469 L 19.207031 1.335938 L 22.828125 1.335938 L 22.828125 4.230469 C 22.828125 4.601562 23.128906 4.898438 23.496094 4.898438 L 27.28125 4.898438 C 27.648438 4.898438 27.949219 4.601562 27.949219 4.230469 L 27.949219 1.335938 L 31.570312 1.335938 L 31.570312 4.230469 C 31.570312 4.601562 31.871094 4.898438 32.238281 4.898438 L 36.023438 4.898438 C 36.390625 4.898438 36.691406 4.601562 36.691406 4.230469 L 36.691406 1.335938 L 38.359375 1.335938 L 38.359375 10.46875 Z M 38.363281 10.46875");
        path1.setFill(Color.GREEN);
        path1.setTranslateX(-10);
        path1.setTranslateY(0);

        addShape(path1);


    }

    @Override
    public void onSelectionChange() {
        Escape escape = (Escape)getElement();
        if (escape.isSelected()) {
            rectangle.setStrokeWidth(3);
            rectangle.setStrokeMiterLimit(10);
            rectangle.setStrokeType(StrokeType.CENTERED);
            rectangle.setStroke(Color.valueOf("0x333333"));
        }
        else {
            rectangle.setStrokeWidth(0);
        }
    }

    @Override
    public void onChange() {
        // TODO Auto-generated method stub

    }


}