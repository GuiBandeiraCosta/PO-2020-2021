package woo.app.suppliers;

import pt.tecnico.po.ui.Command;                                                                                                              import pt.tecnico.po.ui.DialogException;                                                                                                      import pt.tecnico.po.ui.Input;                                                                                                                import woo.Storefront;                                                                                                                        //FIXME import other classes
import woo.exceptions.ChaveDuplicadaFornecedorException;
import woo.app.exceptions.DuplicateSupplierKeyException;
/**
 * Register supplier.
 */
public class DoRegisterSupplier extends Command<Storefront> {
	  private Input<String> _id;
	  private Input<String> _nome;
	  private Input<String> _morada;
  //FIXME add input fields

  public DoRegisterSupplier(Storefront receiver) {
    super(Label.REGISTER_SUPPLIER, receiver);
    _id = _form.addStringInput(Message.requestSupplierKey());
    _nome = _form.addStringInput(Message.requestSupplierName());
    _morada = _form.addStringInput(Message.requestSupplierAddress());
    //FIXME init input fields
  }

  @Override
  public void execute() throws DialogException {
    //FIXME implement command
	  	_form.parse();
		 String id = _id.value();
		 String nome = _nome.value();
		 String morada = _morada.value();
		 
		 try {
			 _receiver.RegisterFornecedorFront(id,nome,morada);
		 } catch(ChaveDuplicadaFornecedorException e) {
			 throw new DuplicateSupplierKeyException(id);
		 }
		 
  }

}
