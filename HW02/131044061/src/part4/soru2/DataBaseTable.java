package part4.soru2;

import java.util.ArrayList;

public class DataBaseTable implements ITable{
    ArrayList<ArrayList<Integer>> elements;

    public DataBaseTable(ArrayList<ArrayList<Integer>> elements){
        this.elements = elements;
    }

    @Override
    public Object getElementAt(int row, int column) {
        return elements.get(row).get(column);
    }

    @Override
    public void setElementAt(int row, int column, Object o) {
        ArrayList<Integer> temp = elements.get(row);
        temp.set(column, (Integer) o);
        elements.set(row, temp);
    }

    @Override
    public int getNumberOfRows() {
        return elements.size();
    }

    @Override
    public int getNumberOfColumns() {
        return elements.get(0).size();
    }
}
