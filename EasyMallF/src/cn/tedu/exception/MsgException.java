package cn.tedu.exception;

public class MsgException extends Exception{
	public MsgException(){
		super();
	}
	public MsgException(String msg){
		super(msg);
	}
	/*public static void main(String[] args) {
		try{
			throw new MsgException("看你能否捕获我的心");
		}catch (MsgException e) {
			System.out.println(e.getMessage());
		}
	}*/
}
