package woo.app.products;
import woo.Produto;
import pt.tecnico.po.ui.Command;                                                                                                              import pt.tecnico.po.ui.DialogException;                                                                                                      import pt.tecnico.po.ui.Input;                                                                                                                import woo.Storefront;                                                                                                                        //FIXME import other classes

/**
 * Show all products.
 */
public class DoShowAllProducts extends Command<Storefront> {

  //FIXME add input fields

  public DoShowAllProducts(Storefront receiver) {
    super(Label.SHOW_ALL_PRODUCTS, receiver);
    //FIXME init input fields
  }

  @Override
  public final void execute() throws DialogException {
	  for (Produto p : _receiver.getAllProdutosFront()) // meter no core 
			_display.addLine(p.toString());
			_display.display();
  }

}
