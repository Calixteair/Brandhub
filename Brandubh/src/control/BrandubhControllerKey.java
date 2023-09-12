package control;

import boardifier.control.Controller;
import boardifier.control.ControllerKey;
import boardifier.model.GameException;
import boardifier.model.GridElement;
import boardifier.model.Model;
import boardifier.view.View;
import javafx.event.*;
import javafx.scene.input.*;
import model.BrandubhStageModel;
import view.BrandubhRootPane;

/**
 * A basic keystrokes handler.
 * Generally useless for board games, but it can still be used if needed
 */
public class BrandubhControllerKey extends ControllerKey implements EventHandler<KeyEvent> {

    protected BrandubhController control;

    public BrandubhControllerKey(Model model, View view, Controller control) {
        super(model, view, control);
        this.control = (BrandubhController) control;
    }

    public void handle(KeyEvent event) {
        if (!model.isCaptureKeyEvent()) return;

        // if a key is pressed, just prints its code
        System.out.println(event.getCode());
        if (event.getCode() == KeyCode.T) {
            setPriseThrone();
        }
        if (event.getCode() == KeyCode.Y) {
            setPrisenextToThrone();
        }
        if (event.getCode() == KeyCode.U) {
            setapatIA();
        }
        if (event.getCode() == KeyCode.I) {
            winIA();
        }
        if (event.getCode() == KeyCode.O) {
            iAsave();
        }
        if (event.getCode() == KeyCode.G) {
            killKing();
        }
        if (event.getCode() == KeyCode.H) {
            stopKing();
        }
        if (event.getCode() == KeyCode.J) {
            killPawn();
        }
    }

    public void setPriseThrone(){
        GridElement grid = model.getGrid("Brandubhboard");
        grid.removeElement(grid.getElement(2,3));
        grid.removeElement(grid.getElement(3,2));
        grid.removeElement(grid.getElement(3,4));

        grid.moveElement(grid.getElement(4,3),0,1);
    }

    public void setPrisenextToThrone(){
        GridElement grid = model.getGrid("Brandubhboard");
        grid.removeElement(grid.getElement(2,3));
        grid.removeElement(grid.getElement(3,2));
        grid.moveElement(grid.getElement(3,4),0,1);

        grid.removeElement(grid.getElement(1,3));
        grid.moveElement(grid.getElement(4,3),4,1);

        grid.moveElement(grid.getElement(3,1),2,1);
        grid.moveElement(grid.getElement(3,5),2,5);
    }

    public void setapatIA(){
        GridElement grid = model.getGrid("Brandubhboard");
        grid.moveElement(grid.getElement(3,5),2,4);
        grid.moveElement(grid.getElement(4,3),2,6);
    }

    public void winIA(){
        GridElement grid = model.getGrid("Brandubhboard");
        grid.removeElement(grid.getElement(0,3));
        grid.removeElement(grid.getElement(1,3));
        grid.removeElement(grid.getElement(3,0));
        grid.removeElement(grid.getElement(3,1));
        grid.removeElement(grid.getElement(3,5));
        grid.removeElement(grid.getElement(3,6));
        grid.removeElement(grid.getElement(5,3));

        grid.moveElement(grid.getElement(5,3),4,2);




    }

    public void iAsave(){
        GridElement grid = model.getGrid("Brandubhboard");
        grid.removeElement(grid.getElement(0,3));
        grid.removeElement(grid.getElement(1,3));
        grid.removeElement(grid.getElement(3,0));
        grid.removeElement(grid.getElement(3,1));
        grid.removeElement(grid.getElement(3,5));

        grid.moveElement(grid.getElement(5,3),4,0);
        grid.moveElement(grid.getElement(4,3),5,4);
    }

    public void killKing(){
          GridElement grid = model.getGrid("Brandubhboard");
            grid.removeElement(grid.getElement(0,3));
            grid.removeElement(grid.getElement(1,3));
            grid.removeElement(grid.getElement(3,0));
            grid.removeElement(grid.getElement(3,1));

            grid.removeElement(grid.getElement(2,3));

            grid.removeElement(grid.getElement(3,2));
            grid.removeElement(grid.getElement(3,4));

            grid.moveElement(grid.getElement(3,5),4,4);



    }

    public void stopKing(){
        GridElement grid = model.getGrid("Brandubhboard");
        grid.removeElement(grid.getElement(0,3));
        grid.removeElement(grid.getElement(1,3));
        grid.removeElement(grid.getElement(3,0));
        grid.removeElement(grid.getElement(3,1));

        grid.removeElement(grid.getElement(2,3));

        grid.removeElement(grid.getElement(3,2));
        grid.removeElement(grid.getElement(3,4));

        grid.moveElement(grid.getElement(3,5),4,4);
        grid.moveElement(grid.getElement(4,3),0,1);
    }

    public void killPawn(){
        GridElement grid = model.getGrid("Brandubhboard");

        grid.moveElement(grid.getElement(3,6),4,4);

    }


}

