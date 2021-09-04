package woo.app.clients;
import woo.Cliente;
import pt.tecnico.po.ui.Command;                                                                                                              import pt.tecnico.po.ui.DialogException;                                                                                                      import pt.tecnico.po.ui.Input;                                                                                                                import woo.Storefront;                                                                                                                        //FIXME import other classes

/**
 * Show all clients.
 */
public class DoShowAllClients extends Command<Storefront> {

  //FIXME add input fields

  public DoShowAllClients(Storefront storefront) {
    super(Label.SHOW_ALL_CLIENTS, storefront);
                //FIXME init input fields
  }

  @Override
  public void execute() throws DialogException {
	  	for (Cliente i : _receiver.getAllClientesFront()) 
	  			_display.addLine(i.toString());
	  			_display.display();
  }
}
