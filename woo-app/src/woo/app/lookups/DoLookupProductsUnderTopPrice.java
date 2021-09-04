package woo.app.lookups;

import pt.tecnico.po.ui.Command;                                                                                                              import pt.tecnico.po.ui.DialogException;                                                                                                      import pt.tecnico.po.ui.Input;                                                                                                                import woo.Storefront;                                                                                                                        //FIXME import other classes

/**
 * Lookup products cheaper than a given price.
 */
public class DoLookupProductsUnderTopPrice extends Command<Storefront> {
	private Input<Integer> preco;
  //FIXME add input fields

  public DoLookupProductsUnderTopPrice(Storefront storefront) {
    super(Label.PRODUCTS_UNDER_PRICE, storefront);
    preco = _form.addIntegerInput(Message.requestPriceLimit());
    //FIXME init input fields
  }

  @Override
  public void execute() throws DialogException {
    //FIXME implement command
	  _form.parse();
	  int p = preco.value();
	  _display.popup(_receiver.ProcuraPUnderFront(p));
  }
}
