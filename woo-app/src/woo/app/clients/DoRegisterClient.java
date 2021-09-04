package woo.app.clients;

import pt.tecnico.po.ui.Command;                                                                                                              import pt.tecnico.po.ui.DialogException;                                                                                                      import pt.tecnico.po.ui.Input;                                                                                                                import woo.Storefront;                                                                                                                        //FIXME import other classes
import woo.exceptions.ChaveDuplicadaClienteException;
import woo.app.exceptions.DuplicateClientKeyException;

/**
 * Register new client.
 */
public class DoRegisterClient extends Command<Storefront> {
  private Input<String> _id;
  private Input<String> _nome;
  private Input<String> _morada;
  //FIXME add input fields

  public DoRegisterClient(Storefront storefront) {
    super(Label.REGISTER_CLIENT, storefront);
    _id = _form.addStringInput(Message.requestClientKey());
    _nome = _form.addStringInput(Message.requestClientName());
    _morada = _form.addStringInput(Message.requestClientAddress());
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
		 _receiver.RegisterClientFront(id,nome,morada);
	 } catch(ChaveDuplicadaClienteException e) {
		 throw new DuplicateClientKeyException(id);
	 }
	 
	
	
	 
  }
}
