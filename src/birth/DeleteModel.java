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

//Fix Delete model
public class DeleteModel extends AbstractTableModel{

    ArrayList<entity> entities;
    
    DeleteModel(ArrayList<entity> entities) {
        super();
        this.entities = entities;       
    }
    
    @Override
    public int getRowCount() {
        return entities.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int r, int c) {
        switch (c) {
            case 0:
                return entities.get(r).getDelete();
            case 1:
                return entities.get(r).getTag1();
            case 2:
                return entities.get(r).getTag2();
            case 3:
                return entities.get(r).getTag3();
            case 4:
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
                result = "Delete";
                break;
            case 1:
                result = "Tag1";
                break;
            case 2:
                result = "Tag2";
                break;
            case 3:
                result = "Tag3";            
                break;
            case 4:
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
        if(c == 0) 
            return true;
        else
            return false;
    }
      
    public void updateRow() {
        
    }
    
    @Override
    public Class<?> getColumnClass(int c) {                
        switch(c) {
            case 0:                
                return entities.get(1).getDelete().getClass();
            case 1:
                return entities.get(1).getTag1().getClass();
            case 2:
                return entities.get(1).getTag2().getClass();
            case 3:
                return entities.get(1).getTag3().getClass();
            case 4:
                return entities.get(1).getDate().getClass();
            default:
                return null;
        }
                                   
    }
    
    @Override
    public void setValueAt(Object value, int r, int c) {           
        if(entities.get(r).getDelete())
            entities.get(r).setDelete(false);                
        else 
            entities.get(r).setDelete(true);                                                                   
        fireTableCellUpdated(r, c);
        }                
                    
}
