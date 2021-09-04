package woo.app.transactions;
import woo.Transacao;
import pt.tecnico.po.ui.Command;                                                                                                              import pt.tecnico.po.ui.DialogException;                                                                                                      import pt.tecnico.po.ui.Input;                                                                                                                import woo.Storefront;                                                                                                                        //FIXME import other classes

import woo.app.exceptions.UnknownTransactionKeyException;
import woo.exceptions.TransacaoDesconhecidaException;
/**
 * Show specific transaction.
 */
public class DoShowTransaction extends Command<Storefront> {
	private Input<Integer> _input;
  //FIXME add input fields

  public DoShowTransaction(Storefront receiver) {
    super(Label.SHOW_TRANSACTION, receiver);
    _input = _form.addIntegerInput(Message.requestTransactionKey());
    //FIXME init input fields
  }

  @Override
  public final void execute() throws DialogException {
    //FIXME implememt command
	  _form.parse();
	  int id = _input.value();
	  try {
	  Transacao t = _receiver.getTransactionFront(id);
      _receiver.Valor_pagarFront(id);
	  
	  _display.popup(t.toString());
	  }
	  catch ( TransacaoDesconhecidaException e ) { throw new UnknownTransactionKeyException(id);}
  

  }
}
