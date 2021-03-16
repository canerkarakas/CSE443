package MidTermPack3;

public class Main {
    public static void main(String[] args) {
        Command command = new Select("SELECT");
        Command tempSelect = command;
        command.execute("Selectsss!!!");
        command = new Alter("ALTER");
        Command tempAlter = command;
        command.execute("Alterssss!!!");
        command = new Update("UPDATE");
        Command tempUpdate = command;
        command.execute("Updatessss!!!!");
        command.undo();
        command = tempSelect;
        command.execute("Selectsss!!!22");
        command.execute("Selectsss!!!33");
        command.undo();
        command.undo();
        command.undo();
    }
}
