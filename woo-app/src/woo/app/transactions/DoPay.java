package woo.app.transactions;

import pt.tecnico.po.ui.Command;                                                                                                              import pt.tecnico.po.ui.DialogException;                                                                                                      import pt.tecnico.po.ui.Input;                                                                                                                import woo.Storefront;                                                                                                                        //FIXME import other classes

import woo.app.exceptions.UnknownTransactionKeyException;
import woo.exceptions.TransacaoDesconhecidaException;
/**
 * Pay transaction (sale).
 */
public class DoPay extends Command<Storefront> {
	 private Input<Integer> _input;
  //FIXME add input fields
  
  public DoPay(Storefront storefront) {
    super(Label.PAY, storefront);
    _input = _form.addIntegerInput(Message.requestTransactionKey());
    //FIXME init input fields
  }

  @Override
  public final void execute() throws DialogException {
    //FIXME implement command
	  _form.parse();
	  int _id = _input.value();
	  	try {
		  _receiver.PayFront(_id);
	  	}
	  	catch ( TransacaoDesconhecidaException e ) { throw new UnknownTransactionKeyException(_id);}
	  
  }

}
