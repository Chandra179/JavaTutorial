package programmer.zaman.now.i18n;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class MessageFormatTypeTest {

	@Test
	void testMessageFormatType() {
		var locale = new Locale("in", "ID");
		var resourceBundle = ResourceBundle.getBundle("message", locale);

		var pattern = resourceBundle.getString("status");

		var messageFormat = new MessageFormat(pattern, locale);
		var format = messageFormat.format(new Object[] { "Eko", new Date(), 1000000 });

		System.out.println(format);
	}

	@Test
	@Disabled
	void testMessageFormatTypeAmerica() {
		var locale = new Locale("en", "US");
		var resourceBundle = ResourceBundle.getBundle("message", locale);

		var pattern = resourceBundle.getString("status");

		var messageFormat = new MessageFormat(pattern, locale);
		var format = messageFormat.format(new Object[] { "Eko", new Date(), 1000000 });

		System.out.println(format);
	}
}
