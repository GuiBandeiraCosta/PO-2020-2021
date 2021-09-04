package woo.app.main;

import pt.tecnico.po.ui.Command;                                                                                                              import pt.tecnico.po.ui.DialogException;                                                                                                      import pt.tecnico.po.ui.Input;                                                                                                                import woo.Storefront;                                                                                                                        //FIXME import other classes
import pt.tecnico.po.ui.Display;
/**
 * Show current date.
 */
public class DoDisplayDate extends Command<Storefront> {
  private int _data;
  
  public DoDisplayDate(Storefront receiver) {
	 
    super(Label.SHOW_DATE, receiver);
    
    //FIXME init input fields
  }

  @Override
  public final void execute() throws DialogException {
	_data = _receiver.getDataFront();
	_display.popup(Message.currentDate(_data));
    
  }
}
