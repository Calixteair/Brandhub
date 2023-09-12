package control;

import boardifier.control.Controller;
import boardifier.control.ControllerAction;
import boardifier.model.*;
import boardifier.view.View;
import javafx.event.*;
import view.BrandubhRootPane;
import view.BrandubhView;


/**
 * A basic action controller that only manages menu actions
 * Action events are mostly generated when there are user interactions with widgets like
 * buttons, checkboxes, menus, ...
 */
public class BrandubhControllerAction extends ControllerAction implements EventHandler<ActionEvent> {

    // to avoid lots of casts, create an attribute that matches the instance type.
    protected BrandubhView BrandubhView;

    protected BrandubhController control;


    public BrandubhRootPane rootPane;

    public BrandubhControllerAction(Model model, View view, Controller control) {
        super(model, view, control);
        // take the view parameter ot define a local view attribute with the real instance type, i.e. BrandubhView.
        BrandubhView = (BrandubhView) view;

        this.control = (BrandubhController) control;
        // set handlers dedicated to menu items
        setMenuHandlers();

        // If needed, set the general handler for widgets that may be included within the scene.
        // In this case, the current gamestage view must be retrieved and casted to the right type
        // in order to have an access to the widgets, and finally use setOnAction(this).
        // For example, assuming the current gamestage view is an instance of MyGameStageView, which
        // creates a Button myButton :
        // ((MyGameStageView)view.getCurrentGameStageView()).getMyButton().setOnAction(this).

    }


    public void setMenuHandlers() {
       rootPane = (BrandubhRootPane)view.getRootPane();
       rootPane.combo.setValue(rootPane.combo.getItems().get(control.mode));
        // set event handler on the MenuStart item
        BrandubhView.getMenuStart().setOnAction(e -> {
            try {
                System.out.println(getModeFromComboBox());
                (control).setMode(getModeFromComboBox());
                (control).trysetmode();
                control.startGame();
            }
            catch(GameException err) {
                System.err.println(err.getMessage());
                System.exit(1);
            }
        });
        // set event handler on the MenuIntro item
        BrandubhView.getMenuIntro().setOnAction(e -> {
            control.stopGame();
            BrandubhView.resetView();
            rootPane = (BrandubhRootPane)view.getRootPane();
            setMenuHandlers();
        });
        BrandubhView.getMenuAboutUs().setOnAction(e -> {
            control.stopGame();
            BrandubhView.creatAboutUs();
            rootPane = (BrandubhRootPane)view.getRootPane();
            setMenuHandlers();
        });

        BrandubhView.getMenuRule().setOnAction(e -> {
            control.stopGame();
            BrandubhView.creatRule();
            rootPane = (BrandubhRootPane)view.getRootPane();
            setMenuHandlers();
        });

        // set event handler on the MenuQuit item
        BrandubhView.getMenuQuit().setOnAction(e -> {
            System.exit(0);
        });
        rootPane.getPlayButton().setOnAction(e -> {
            try {
                (control).setMode(getModeFromComboBox());
                (control).trysetmode();
                control.startGame();
            }
            catch(GameException err) {
                System.err.println(err.getMessage());

            }

        });
    }


    public int getModeFromComboBox() {
        BrandubhRootPane rootPane = (BrandubhRootPane)view.getRootPane();
        return rootPane.combo.getSelectionModel().getSelectedIndex();
    }




    /**
     * The general handler for action events.
     * this handler should be used if the code to process a particular action event is too long
     * to fit in an arrow function (like with menu items above). In this case, this handler must be
     * associated to a widget w, by calling w.setOnAction(this) (see constructor).
     *
     * @param event An action event generated by a widget of the scene.
     */
    public void handle(ActionEvent event) {

        if (!model.isCaptureActionEvent()) return;

    }
}

