/**
 * This class is the driver for the application. Calling main() will inject the
 * dependencies
 *
 * @author Amit Maharana (amahara1)
 * @since 10/23/2020
 */

public class Main67 {

	/**
	 * The repository acts as the model and observers are attached to it. The view
	 * is setup and then we create the controller to govern
	 */
	public static void main(String[] args) {
		Repository61 model = Repository61.getInstance();

		ObserverTable65 table = new ObserverTable65(Main67Constants.PANEL_WIDTH, Main67Constants.PANEL_HEIGHT - 90);
		ObserverPlotter66 plotter = new ObserverPlotter66(Main67Constants.PLOT_TITLE, Main67Constants.PLOT_X_AXIS,
				Main67Constants.PLOT_Y_AXIS, Main67Constants.PANEL_WIDTH, Main67Constants.PANEL_HEIGHT + 35);

		model.addObserver(table);
		model.addObserver(plotter);

		new Main67Controller(model, new Main67View(table, plotter));
	}
}