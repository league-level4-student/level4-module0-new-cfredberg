package _04_Data_Type_Option_Pane;

import javax.swing.JOptionPane;

public class DataTypeOptionPane {
    public static void main(String[] args) {

        DataType[] dataTypes;
        
        dataTypes = DataType.values();
        
        int response = JOptionPane.showOptionDialog(null, "            Please select the data type that you would like\n                                     to learn about.", "Your Choice", 0, JOptionPane.PLAIN_MESSAGE, null, dataTypes, 0);
        
        switch (response) {
        case 0:
        	JOptionPane.showMessageDialog(null, "A char can contain only one character.  A character is any letter, lower or upper case, or any single digit number.  A char is made up of " + DataType.CHAR.getBits() + " bits.");
        	break;
        case 1:
        	JOptionPane.showMessageDialog(null, "The biggest number a short can contain is 32,767 .  It is made up of " + DataType.SHORT.getBits() + " bits.");
        	break;
        case 2:
        	JOptionPane.showMessageDialog(null, "The biggest number an int can contain is 2,147,483,647.  An int is made up of " + DataType.INT.getBits() + " bits.");
        	break;
        case 3:
        	JOptionPane.showMessageDialog(null, "The biggest number a long can contain is 9,223,372,036,854,775,807.  A long is made up of " + DataType.LONG.getBits() + " bits.");
        	break;
        case 4:
        	JOptionPane.showMessageDialog(null, "The biggest number a double can reliably contain is 2^53. It can hold not only integers, but also decimal numbers.  A double is made up of " + DataType.DOUBLE.getBits() + " bits.");
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
