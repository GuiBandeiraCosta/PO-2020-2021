package woo.app.lookups;

import pt.tecnico.po.ui.Command;                                                                                                              import pt.tecnico.po.ui.DialogException;                                                                                                      import pt.tecnico.po.ui.Input;                                                                                                                import woo.Storefront;                                                                                                                        //FIXME import other classes
import woo.exceptions.ChaveClienteNaoConhecidaException;
import woo.app.exceptions.UnknownClientKeyException;
/**
 * Lookup payments by given client.
 */
public class DoLookupPaymentsByClient extends Command<Storefront> {
	private Input<String> _input;
  //FIXME add input fields

  public DoLookupPaymentsByClient(Storefront storefront) {
    super(Label.PAID_BY_CLIENT, storefront);
    _input = _form.addStringInput(Message.requestClientKey());
    //FIXME init input fields
  }

  @Override
  public void execute() throws DialogException {
    //FIXME implement command
	  _form.parse();
	  String _id = _input.value();
	  try {
	  _display.popup(_receiver.ShowFaturasClienteFront(_id));
	  }  catch(ChaveClienteNaoConhecidaException e) { throw new UnknownClientKeyException(_id);}
  }

}
