package MidTermPack3;


/**
 * select command class for selecting
 */
public class SelectCommand {
    private String select_command_control = "SELECT";
    private String _data;

    public SelectCommand(String select){
        if (select.equals(this.select_command_control)){
            System.out.println("Select Command created");
        }
    }
    public String action(String data){
        System.out.println("Selecting");
        _data = data;
        return _data;
    }

    public String get_data() {
        return _data;
    }
}
