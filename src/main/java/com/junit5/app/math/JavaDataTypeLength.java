package com.junit5.app.math;

class DataTypeNotFound extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	DataTypeNotFound(String message){
		super(message);
	}
	
	DataTypeNotFound(String message,Throwable cause){
		super(message,cause);
	}
}


public class JavaDataTypeLength {

	private boolean isvalidDataType(String dataType){
		if(dataType.equals("Integer") || dataType.equals("int") ||
			dataType.equals("Double") || dataType.equals("double") ||
			dataType.equals("Float") || dataType.equals("float") ||
			dataType.equals("Long") || dataType.equals("long") ||
			dataType.equals("Short") || dataType.equals("short") ||
			dataType.equals("Byte") || dataType.equals("byte")) 
			return true;
 		    return false;
	}
	
	public String [] getMinValueMaxValue(String dataType){
		String [] metaInfo=new String[2];
		
		if(dataType==null || dataType.length()==0 || !(isvalidDataType(dataType)))
			 throw new DataTypeNotFound("[ "+dataType+  " ]" + " Datatype not found!",new Throwable(dataType + " Data type is not supported by java language"));
		
		if(dataType.equals("Integer") || dataType.equals("int")) {
			metaInfo[0]=Integer.MIN_VALUE+"";
			metaInfo[1]=Integer.MAX_VALUE+"";
			return metaInfo;
		}
		if(dataType.equals("Double") || dataType.equals("double")) {
			metaInfo[0]=Double.MIN_VALUE+"";
			metaInfo[1]=Double.MAX_VALUE+"";
			return metaInfo;
		}
		
		if(dataType.equals("Float") || dataType.equals("float")) {
			metaInfo[0]=Float.MIN_VALUE+"";
			metaInfo[1]=Float.MAX_VALUE+"";
			return metaInfo;
		}
		
		if(dataType.equals("Long") || dataType.equals("long")) {
			metaInfo[0]=Long.MIN_VALUE+"";
			metaInfo[1]=Long.MAX_VALUE+"";
			return metaInfo;
		}
		
		if(dataType.equals("Short") || dataType.equals("short")) {
			metaInfo[0]=Double.MIN_VALUE+"";
			metaInfo[1]=Double.MAX_VALUE+"";
			return metaInfo;
		}
		if(dataType.equals("Byte") || dataType.equals("byte")) {
			metaInfo[0]=Double.MIN_VALUE+"";
			metaInfo[1]=Double.MAX_VALUE+"";
			return metaInfo;
		}
		
		return metaInfo;
		
	}
	
}
