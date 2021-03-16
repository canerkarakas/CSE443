package MidTermPack3;

import java.util.Stack;

/**
 * Select for Select command
 */
public class Select implements Command{
    private SelectCommand selectCommand;
    String _data;
    /**
     * Stack allows to keep all alter commands made
     */
    private Stack<SelectCommand> _selectedItems = new Stack<>();

    public Select(String selectCommandName){
        this.selectCommand = new SelectCommand(selectCommandName);
    }

    @Override
    public void execute(String data) {
        this.selectCommand = new SelectCommand("SELECT");
        _data = selectCommand.action(data);
        _selectedItems.push(selectCommand);
        System.out.println(_data);
    }
    /**
     * Removes the topmost element from the list from the stack.
     */
    @Override
    public void undo() {
        selectCommand = _selectedItems.pop();
        System.out.println(selectCommand.get_data());
    }
}
