package com.testdata;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {

	@DataProvider(name = "test-data")
	
	public static Object[][] getData(Method m) {
		switch (m.getName()) {
		case "verifyPaymentScreen":
			return new Object[][] { { "https://sanbox.undostres.com.mx/payment.php" } };
		case "verifySuccessMessage":
			return new Object[][] { { "¡Recarga Exitosa!" }};
		case "verifyRechargeSuccess":
			return new Object[][] { { "https://sanbox.undostres.com.mx/confirmation/success" }};
		}
		return null;
	}
}
