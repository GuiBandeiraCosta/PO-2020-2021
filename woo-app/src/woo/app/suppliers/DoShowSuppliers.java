package woo.app.suppliers;
import woo.Fornecedor;

import pt.tecnico.po.ui.Command;                                                                                                              import pt.tecnico.po.ui.DialogException;                                                                                                      import pt.tecnico.po.ui.Input;                                                                                                                import woo.Storefront;                                                                                                                        //FIXME import other classes

/**
 * Show all suppliers.
 */
public class DoShowSuppliers extends Command<Storefront> {

  //FIXME add input fields

  public DoShowSuppliers(Storefront receiver) {
    super(Label.SHOW_ALL_SUPPLIERS, receiver);
    //FIXME init input fields
  }

  @Override
  public void execute() throws DialogException {
	  for (Fornecedor i : _receiver.getAllFornecedorFront()) {
		  if(i.getEstado().equals("SIM")) {
			_display.addLine(i.toString() +  Message.yes());
			
		  }
		  else if(i.getEstado().equals("NAO")) {
			_display.addLine(i.toString() +  Message.no());
			
		  }
		  
  }
	 _display.display();
  }
}
