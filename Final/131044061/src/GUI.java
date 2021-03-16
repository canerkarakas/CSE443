import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class GUI implements ActionListener, GUIMapObserver{
    private JFrame viewFrame;
    private JPanel viewPanel;
    private JFrame viewFrame2;
    private JPanel viewPanel2;
    private JFrame controlFrame;
    private JPanel controlPanel;
    private JTextField inputTextField;
    private JButton addBulk;
    private JButton increaseNumOfPerson;
    private JButton start;
    private JButton resume;
    private JButton stop;
    private JButton undo;
    private JLabel inputLabel;
    private ModelInterface modelInterface;
    private ControllerInterFace controllerInterFace;
    private Memento memento;
    private JLabel numOfInfected;
    private JLabel numOfHealthy;
    private JLabel numOfAtHospital;
    private JLabel numOfDeadPerson;
    private JLabel meanOfD;
    private JLabel meanOfM;
    private JLabel population;
    private JLabel p;


    public GUI(ControllerInterFace controllerInterFace, ModelInterface modelInterface){
        this.controllerInterFace = controllerInterFace;
        this.modelInterface = modelInterface;
        modelInterface.registerObserver((GUIMapObserver) this);
        memento = new Memento();
    }

    public void createView(){
        viewPanel = new JPanel(new GridLayout(1, 2));
        viewFrame = new JFrame("View");
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewFrame.setSize(new Dimension(1040, 640));
        viewFrame.setLocation(200,100);
        viewFrame.setResizable(false);
        viewFrame.getContentPane().add(viewPanel, BorderLayout.CENTER);
        viewFrame.setVisible(true);
        viewPanel.setBackground(Color.WHITE);
    }

    public void createControls(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        controlFrame = new JFrame("Control");
        controlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controlFrame.setSize(new Dimension(250, 150));
        controlFrame.setResizable(false);
        controlFrame.setLocation(1240, 100);
        controlPanel = new JPanel(new GridLayout(1, 2));
        inputTextField = new JTextField(2);
        inputLabel = new JLabel("Enter People num:", SwingConstants.RIGHT);
        addBulk = new JButton("Bulk add");
        addBulk.setSize(new Dimension(10 , 40));
        increaseNumOfPerson = new JButton("+");
        increaseNumOfPerson.setSize(new Dimension(10 , 40));
        start = new JButton("Start");
        start.setSize(new Dimension(10, 40));
        resume = new JButton("Resume");
        resume.setSize(new Dimension(10, 40));
        stop = new JButton("Stop");
        stop.setSize(new Dimension(10, 40));
        undo = new JButton("Undo");
        undo.setSize(new Dimension(10, 40));
        undo.addActionListener(this);
        addBulk.addActionListener(this);
        increaseNumOfPerson.addActionListener(this);
        resume.addActionListener(this);
        stop.addActionListener(this);
        start.addActionListener(this);
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(resume);
        buttonPanel.add(stop);
        JPanel enterPanel = new JPanel(new GridLayout(1, 2));
        enterPanel.add(inputLabel);
        enterPanel.add(inputTextField);
        JPanel startStopButtonPanel = new JPanel(new GridLayout(1, 2));
        startStopButtonPanel.add(addBulk);
        startStopButtonPanel.add(increaseNumOfPerson);
        JPanel insideControlPanel = new JPanel(new GridLayout(5, 2));
        insideControlPanel.add(enterPanel);
        insideControlPanel.add(start);
        insideControlPanel.add(buttonPanel);
        insideControlPanel.add(startStopButtonPanel);
        insideControlPanel.add(undo);
        controlPanel.add(insideControlPanel);
        inputLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        controlFrame.getContentPane().add(controlPanel, BorderLayout.CENTER);
        controlFrame.setVisible(true);
    }

    public void createView2(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        viewPanel2 = new JPanel(new GridLayout(8, 1));
        viewFrame2 = new JFrame("View2");
        viewFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewFrame2.setSize(new Dimension(250, 150));
        viewFrame2.setLocation(1240,250);
        viewFrame2.setResizable(false);
        viewFrame2.getContentPane().add(viewPanel2, BorderLayout.CENTER);
        viewPanel2.setBackground(Color.WHITE);
        numOfInfected = new JLabel("Infected : ");
        numOfHealthy = new JLabel("Healthy : ");
        numOfAtHospital = new JLabel("Hospital : ");
        numOfDeadPerson = new JLabel("Dead : ");
        meanOfD = new JLabel("Mean Of D : ");
        meanOfM = new JLabel("Percentage Of M : ");
        population = new JLabel("Population : ");
        p = new JLabel("P : ");
        viewPanel2.add(numOfInfected);
        viewPanel2.add(numOfHealthy);
        viewPanel2.add(numOfAtHospital);
        viewPanel2.add(numOfDeadPerson);
        viewPanel2.add(meanOfD);
        viewPanel2.add(meanOfM);
        viewPanel2.add(p);
        viewPanel2.add(population);
        viewFrame2.getContentPane().add(viewPanel2, BorderLayout.CENTER);
        viewFrame2.setVisible(true);

    }



    public Memento getMemento() {
        return memento;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBulk)
            controllerInterFace.addBulk(Integer.parseInt(inputTextField.getText()));
        else if (e.getSource() == increaseNumOfPerson)
            controllerInterFace.increaseNOP();
        else if (e.getSource() == start)
            controllerInterFace.start();
        else if (e.getSource() == resume)
            controllerInterFace.resume();
        else if (e.getSource() == stop)
            controllerInterFace.stop();
        else if (e.getSource() == undo)
            controllerInterFace.undo();
    }

    @Override
    public void updateMap() {
        Graphics g = viewPanel.getGraphics();
        g.clearRect(0,0, viewPanel.getWidth(), viewPanel.getHeight());
        modelInterface.getMutexPeople().lock();
        Vector<Person> people = modelInterface.getPeople();
        int maskUsed = 0; int sumOfD = 0; int healthy = 0; int dead = 0;
        int infected = 0; int atHospital = 0; double sumOfP = 0.0;
        for (Person person : people) {
            sumOfD += person.getD();
            if (person.getM()==0.2)
                maskUsed++;
            if (person.getSituation() == 0)
                healthy++;
            if (person.getSituation() == 1){
                sumOfP += person.getP();
                infected++;
            }
            if (person.getSituation() == 2)
                atHospital++;
            if (person.getDie())
                dead++;
            g.setColor(person.getColor());
            g.fillRect(person.getX_coordinate(),
                    person.getY_coordinate(), 5, 5);
        }
        double meanOfD = (double)sumOfD / people.size();
        double meanOfM = (double)(100*maskUsed) / people.size();
        double meanOfP = sumOfP * 100;
        numOfHealthy.setText("Healthy : " + healthy);
        numOfDeadPerson.setText("Dead : " + dead);
        numOfInfected.setText("Infected : " + infected);
        numOfAtHospital.setText("Hospital : " + atHospital);
        this.meanOfD.setText("Mean Of D : " + meanOfD);
        this.meanOfM.setText("Percentage of M : " + meanOfM);
        this.population.setText("Population : " + people.size());
        p.setText("P : " + meanOfP);
        modelInterface.getMutexPeople().unlock();
    }
}
