/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package birth;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pc
 */
public class UpdateModel extends AbstractTableModel{

    ArrayList<entity> entities;
    
    UpdateModel(ArrayList<entity> entities) {
        super();
        this.entities = entities;       
    }
    
    @Override
    public int getRowCount() {
        return entities.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int r, int c) {
        switch (c) {
            case 0:
                return entities.get(r).getTag1();
            case 1:
                return entities.get(r).getTag2();
            case 2:
                return entities.get(r).getTag3();
            case 3:
                return entities.get(r).getDate();
            default:
                return "";
        }
    }
    
    @Override
    public String getColumnName(int c) {
        String result = "";
        switch (c) {
            case 0:
                result = "Tag1";
                break;
            case 1:
                result = "Tag2";
                break;
            case 2:
                result = "Tag3";
                break;
            case 3:
                result = "Date";            
                break;
        }
        return result;        
    }        
    
    public void addRow(entity ent) {
        entities.add(ent);
    }
    
    public void deleteRow(entity ent) {
        entities.remove(ent);
    }
    
    @Override
    public boolean isCellEditable(int r, int c) {
        if(c < 0) 
            return false;
        else
            return true;
    }
      
    @Override
    public void setValueAt(Object value, int r, int c) {        
        backend Bend = new backend();
        
        switch(c) {
            case 0:                                
                Bend.update(entities.get(r).getTag1(), 
                        entities.get(r).getTag2(), 
                        entities.get(r).getTag3(), 
                        entities.get(r).date,
                        String.valueOf(value), 
                        "tag1");
                entities.get(r).setTag1(String.valueOf(value));
                break;
            case 1:                
                Bend.update(entities.get(r).getTag1(), 
                        entities.get(r).getTag2(), 
                        entities.get(r).getTag3(), 
                        entities.get(r).date,
                        String.valueOf(value), 
                        "tag2");
                entities.get(r).setTag2(String.valueOf(value));
                break;
            case 2:                
                Bend.update(entities.get(r).getTag1(), 
                        entities.get(r).getTag2(), 
                        entities.get(r).getTag3(), 
                        entities.get(r).date,
                        String.valueOf(value), 
                        "tag3");
                entities.get(r).setTag3(String.valueOf(value));
                break;
            case 3:                
                Bend.update(entities.get(r).getTag1(), 
                        entities.get(r).getTag2(), 
                        entities.get(r).getTag3(), 
                        entities.get(r).date,
                        String.valueOf(value), 
                        "datas");
                entities.get(r).setDate(String.valueOf(value));
                break;
        }        
        fireTableCellUpdated(r, c);
                
    }
}
