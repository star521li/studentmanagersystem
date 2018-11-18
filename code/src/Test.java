
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DbHelper db=new DbHelper();
		System.out.println(db.checkTrue("select uname from admin where uname='admin'"));
	}

}
