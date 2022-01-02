package _01_Encapsulate_the_Data;

public class EncapsulateTheData {

    /*
     * itemsReceived cannot negative. All negative parameters should set
     * itemsReceived to 0.
     */

    private int itemsReceived;

    /*
     * degreesTurned must be locked between 0.0 and 360.0 inclusive. All
     * parameters outside this range should set degreesTurned to the nearest
     * bound.
     */

    private double degreesTurned;

    /*
     * nomenclature must not contain an empty String. An empty String parameter
     * should set nomenclature to a String with a single space.
     */

    private String nomenclature;

    /*
     * memberObj must not be a String. A String parameter should set memberObj
     * to a new Object(); Hint: Use the instanceof operator.
     */

    private Object memberObj;
    
    public void setItemsReceived(int num) {
    	if (num > 0) {
    		itemsReceived = num;
    	}else {
    		itemsReceived = 0;
    	}
    }
    
    public int getItemsReceived() {
    	return itemsReceived;
    }
    
    public void setDegreesTurned(Double num) {
    	if (num > 360) {
    		degreesTurned = 360;
    	}else if (num < 0) {
    		degreesTurned = 0;
    	}else {
    		degreesTurned = num;
    	}
    }
    
    public Double getDegreesTurned() {
    	return degreesTurned;
    }
    
    public void setNomenclature(String str) {
    	if (str.equals("")) {
    		nomenclature = " ";
    	}else {
    		nomenclature = str;
    	}
    }
    
    public String getNomenclature() {
    	return nomenclature;
    }
    
    public void setMemberObj(Object obj) {
    	if (obj instanceof String) {
    		memberObj = new Object();
    	}else {
    		memberObj = obj;
    	}
    }
    
    public Object getMemberObj() {
    	return memberObj;
    }
}
