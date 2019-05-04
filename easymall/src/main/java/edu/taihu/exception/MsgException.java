package edu.taihu.exception;

public class MsgException extends Exception{
	public MsgException(){
		super();
	}
	public MsgException(String msg){
		super(msg);
	}
	/*public static void main(String[] args) {
		try{
			throw new MsgException("�����ܷ񲶻��ҵ���");
		}catch (MsgException e) {
			System.out.println(e.getMessage());
		}
	}*/
}
