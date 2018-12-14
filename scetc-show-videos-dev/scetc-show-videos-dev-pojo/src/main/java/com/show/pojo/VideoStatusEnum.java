package com.show.pojo;

public enum VideoStatusEnum {

	Success(1),
	FORBID(2);
	
	public final int value;
	VideoStatusEnum(int value)
	{
		this.value=value;
	}
   public int getValue()
   {
	  return value; 
   }
	
}
