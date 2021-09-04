package woo.app.main;

import pt.tecnico.po.ui.Command;                                                                                                              import pt.tecnico.po.ui.DialogException;                                                                                                      import pt.tecnico.po.ui.Input;                                                                                                                import woo.Storefront;                                                                                                                        //FIXME import other classes
import woo.app.exceptions.InvalidDateException;

/**
 * Advance current date.
 */
public class DoAdvanceDate extends Command<Storefront> {
  private Input<Integer> _input;
  private int _data_atual;
  private int _nova_data;
  
  public DoAdvanceDate(Storefront receiver) {
    super(Label.ADVANCE_DATE, receiver);
    
    _input = _form.addIntegerInput(Message.requestDaysToAdvance());
    //FIXME init input fields
  }

  @Override
  public final void execute() throws DialogException {
	  _form.parse();
	  if(_input.value() < 0) {
		  throw new InvalidDateException(_input.value());
	  }
	  _data_atual = _receiver.getDataFront();
	  _nova_data = _data_atual + _input.value();
	  _receiver.setDataFront(_nova_data);
  }
}
