package MidTermPack3;

/**
 * alter command class for altering
 */
public class AlterCommand {
    private String alter_command_control = "ALTER";
    private String _data;

    public AlterCommand(String alter){
        if (alter.equals(this.alter_command_control)){
            System.out.println("Alter Command created");
        }
    }
    public String action(String data){
        System.out.println("Altering");
        _data = data;
        return _data;
    }

    public String get_data() {
        return _data;
    }
}
