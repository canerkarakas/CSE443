package MidTermPack3;

import java.util.Stack;

/**
 * Alter for alter command
 */
public class Alter implements Command{
    private AlterCommand alterCommand;
    String _data;
    /**
     * Stack allows to keep all alter commands made
     */
    private Stack<AlterCommand> _alteredItems = new Stack<>();

    public Alter(String alterCommandName){
        this.alterCommand = new AlterCommand(alterCommandName);
    }


    @Override
    public void execute(String data) {
        this.alterCommand = new AlterCommand("ALTER");
        _data = alterCommand.action(data);
        _alteredItems.push(alterCommand);
        System.out.println(_data);
    }

    /**
     * Removes the topmost element from the list from the stack.
     */
    @Override
    public void undo() {
        alterCommand = _alteredItems.pop();
        System.out.println(alterCommand.get_data());
    }
}
