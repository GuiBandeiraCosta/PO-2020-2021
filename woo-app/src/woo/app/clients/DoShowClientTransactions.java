package woo.app.clients;

import pt.tecnico.po.ui.Command;                                                                                                              import pt.tecnico.po.ui.DialogException;                                                                                                      import pt.tecnico.po.ui.Input;                                                                                                                import woo.Storefront;                                                                                                                        //FIXME import other classes
import woo.exceptions.ChaveClienteNaoConhecidaException;
import woo.app.exceptions.UnknownClientKeyException;
/**
 * Show all transactions for a specific client.
 */
public class DoShowClientTransactions extends Command<Storefront> {
	private Input<String> _input;
  //FIXME add input fields

  public DoShowClientTransactions(Storefront storefront) {
    super(Label.SHOW_CLIENT_TRANSACTIONS, storefront);
    _input = _form.addStringInput(Message.requestClientKey());
    //FIXME init input fields
  }

  @Override
  public void execute() throws DialogException {
    //FIXME implement command
	  _form.parse();
	  String _id = _input.value();
	  try {
	  _display.popup(_receiver.ShowTransacaoClienteFront(_id));
	  }
	  catch(ChaveClienteNaoConhecidaException e) { throw new UnknownClientKeyException(_id);}
  }

}
