package woo.app.products;

import pt.tecnico.po.ui.Command;                                                                                                              import pt.tecnico.po.ui.DialogException;                                                                                                      import pt.tecnico.po.ui.Input;                                                                                                                import woo.Storefront;                                                                                                                        //FIXME import other classes
import woo.app.exceptions.UnknownProductKeyException;
import woo.exceptions.idProdutoDesconhecidoException;
/**
 * Change product price.
 */
public class DoChangePrice extends Command<Storefront> {
	private Input<Integer> _preco;
	private Input<String> _id;
  //FIXME add input fields
  
  public DoChangePrice(Storefront receiver) {
    super(Label.CHANGE_PRICE, receiver);
    _id = _form.addStringInput(Message.requestProductKey());
    _preco = _form.addIntegerInput(Message.requestPrice());
    //FIXME init input fields
  }

  @Override
  public final void execute() throws DialogException {
	  _form.parse();
	  String id = _id.value();
	  int preco = _preco.value();
	  try {
		  _receiver.ChangePrecoFront(id,preco);
	  } catch(idProdutoDesconhecidoException e) {throw new UnknownProductKeyException(id);}
    //FIXME implement command
  }
}
