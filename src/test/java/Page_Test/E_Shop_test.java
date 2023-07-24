package Page_Test;

import com.page_object.E_Shop;
import com.utility.Base_Utility;

public class E_Shop_test extends Base_Utility{
	public Login_Page_Test login;
	public E_Shop ob;
	public void registered_customers()
	{
		msg("************************E Shop**************************");
		ob = new E_Shop();
//		login = new Login_Page_Test();
//		login.login();
		Custom_click(ob.E_shop(), ob.E_shop().getText());
	}

}
