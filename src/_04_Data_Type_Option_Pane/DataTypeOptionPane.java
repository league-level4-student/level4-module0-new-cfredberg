package _04_Data_Type_Option_Pane;

import javax.swing.JOptionPane;

public class DataTypeOptionPane {
    public static void main(String[] args) {

        DataType[] dataTypes;
        
        dataTypes = DataType.values();
        
        int response = JOptionPane.showOptionDialog(null, "Please select the data type that you would like\n                         to learn about.", "Your Choice", 0, 3, null, dataTypes, 0);
        
        switch (response) {
        case 8:
        	break;
        case 16:
        	break;
        case 32:
        	break;
        case 64:
        	break;
        }
        	
    }
    
    enum DataType {
    	CHAR(8),
    	SHORT(16),
    	INT(32),
    	LONG(64),
    	DOUBLE(64);
    	int bits;
    	
    	DataType(int num) {
    		bits = num;
    	}
    	
    	public int getBits() {
    		return bits;
    	}
    }
}
