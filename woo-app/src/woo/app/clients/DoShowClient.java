package woo.app.clients;

import pt.tecnico.po.ui.Command;                                                                                                              import pt.tecnico.po.ui.DialogException;                                                                                                      import pt.tecnico.po.ui.Input;                                                                                                                import woo.Storefront;                                                                                                                        //FIXME import other classes
import woo.app.exceptions.UnknownClientKeyException;
import woo.exceptions.ChaveClienteNaoConhecidaException;

/**
 * Show client.
 */
public class DoShowClient extends Command<Storefront> {
  private Input<String> _input;
  //FIXME add input fields

  public DoShowClient(Storefront storefront) {
    super(Label.SHOW_CLIENT, storefront);
    _input = _form.addStringInput(Message.requestClientKey());
    //FIXME init input fields
  }
  
  @Override
  public void execute() throws DialogException {
	  _form.parse();
	  String _id = _input.value();
	  
	  try {
			
			_display.popup(_receiver.getClientFront(_id).toString());
		 } catch(ChaveClienteNaoConhecidaException e) {
			 throw new UnknownClientKeyException(_id);
		 }
	  
  }
}
