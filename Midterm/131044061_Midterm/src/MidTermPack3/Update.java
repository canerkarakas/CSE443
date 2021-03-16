package MidTermPack3;

import java.util.Stack;

/**
 * Update for Update command
 */
public class Update implements Command{
    private UpdateCommand updateCommand;
    String _data;
    /**
     * Stack allows to keep all alter commands made
     */
    private Stack<UpdateCommand> _updatedItems = new Stack<>();

    public Update(String updateCommandName){
        this.updateCommand = new UpdateCommand(updateCommandName);
    }

    @Override
    public void execute(String data) {
        this.updateCommand = new UpdateCommand("UPDATE");
        _data = updateCommand.action(data);
        _updatedItems.push(updateCommand);
        System.out.println(_data);
    }
    /**
     * Removes the topmost element from the list from the stack.
     */
    @Override
    public void undo() {
        updateCommand = _updatedItems.pop();
        System.out.println(updateCommand.get_data());
    }
}
