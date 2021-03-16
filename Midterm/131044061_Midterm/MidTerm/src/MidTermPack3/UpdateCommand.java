package MidTermPack3;

/**
 * update command class for updating
 */
public class UpdateCommand {
    private String update_command_control = "UPDATE";
    private String _data;

    public UpdateCommand(String update){
        if (update.equals(this.update_command_control)){
            System.out.println("Update Command created");
        }
    }
    public String action(String data){
        System.out.println("Updating");
        _data = data;
        return _data;
    }

    public String get_data() {
        return _data;
    }
}
