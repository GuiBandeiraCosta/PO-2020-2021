package woo.app.main;

import java.io.FileNotFoundException;
import java.io.IOException;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.Storefront;
import woo.exceptions.UnavailableFileException;
import woo.app.exceptions.FileOpenFailedException;

//FIXME import other classes

/**
 * Open existing saved state.
 */
public class DoOpen extends Command<Storefront> {
  private Input<String> _file;
  //FIXME add input fields

  /** @param receiver */
  public DoOpen(Storefront receiver) {
    super(Label.OPEN, receiver);
    
    //FIXME init input fields
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
	  
	_file = _form.addStringInput(Message.openFile());
	
    try {
      //FIXME implement command
    	_form.parse();
    	_receiver.load(_file.value());
    	_form.clear();
    	
    } catch (UnavailableFileException ufe) {
      throw new FileOpenFailedException(ufe.getFilename());
    }
    catch (FileNotFoundException ufe) {
    	throw new FileOpenFailedException(_file.value());
      }
    catch (IOException ufe) {
    	ufe.printStackTrace();
      }
    catch (ClassNotFoundException ufe) {
    	ufe.printStackTrace();
      }    
  }

}
