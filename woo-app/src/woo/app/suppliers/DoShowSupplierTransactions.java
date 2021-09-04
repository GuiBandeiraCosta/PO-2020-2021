package woo.app.suppliers;

import pt.tecnico.po.ui.Command;   
import pt.tecnico.po.ui.DialogException;                                                                                                      import pt.tecnico.po.ui.Input;                                                                                                                import woo.Storefront;                                                                                                                        //FIXME import other classes

import woo.app.exceptions.UnknownSupplierKeyException;
import woo.exceptions.idFornecedorDesconhecidoException;
/**
 * Show all transactions for specific supplier.
 */
public class DoShowSupplierTransactions extends Command<Storefront> {
	private Input<String> _input;
  //FIXME add input fields

  public DoShowSupplierTransactions(Storefront receiver) {
    super(Label.SHOW_SUPPLIER_TRANSACTIONS, receiver);
    _input = _form.addStringInput(Message.requestSupplierKey());
    //FIXME init input fields
  }

  @Override
  public void execute() throws DialogException {
    //FIXME implement command
	  _form.parse();
	  String _id = _input.value();
	  try {
	  _display.popup(_receiver.ShowTransacaoFornecedorFront(_id));
	  }
	  catch ( idFornecedorDesconhecidoException e ){throw new UnknownSupplierKeyException(_id);}
  }

}
