package cug.swt.ssns.exception;

public class SensorAlreadyExistException extends Exception{

	  private static final long serialVersionUID = 1L; 

	  // 提供无参数的构造方法
	  public SensorAlreadyExistException() { 
	  } 

	  // 提供一个有参数的构造方法，可自动生成
	  public SensorAlreadyExistException(String message) { 
	    super(message);// 把参数传递给Throwable的带String参数的构造方法 
	  } 
}
