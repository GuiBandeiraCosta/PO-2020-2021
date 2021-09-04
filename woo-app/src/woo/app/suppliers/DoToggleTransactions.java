package woo.app.suppliers;

import pt.tecnico.po.ui.Command;       
import pt.tecnico.po.ui.DialogException;                                                                                                      import pt.tecnico.po.ui.Input;                                                                                                                import woo.Storefront;                                                                                                                        //FIXME import other classes
import woo.exceptions.idFornecedorDesconhecidoException;
import woo.app.exceptions.UnknownSupplierKeyException;
/**
 * Enable/disable supplier transactions.
 */
public class DoToggleTransactions extends Command<Storefront> {
	 private Input<String> _id;
  //FIXME add input fields

  public DoToggleTransactions(Storefront receiver) {
    super(Label.TOGGLE_TRANSACTIONS, receiver);
    _id = _form.addStringInput(Message.requestSupplierKey());
    //FIXME init input fields
  }

  @Override
  public void execute() throws DialogException {
	  	_form.parse();
		 String id = _id.value();
		 
		 try {
			 int i = _receiver.toggleTFront(id);
			 if (i == 0) _display.popup(Message.transactionsOn(id));
			 else if (i == 1 )_display.popup(Message.transactionsOff(id));
			 
		 } catch(idFornecedorDesconhecidoException e) {throw new UnknownSupplierKeyException(id);}
		 
  }

}
  


