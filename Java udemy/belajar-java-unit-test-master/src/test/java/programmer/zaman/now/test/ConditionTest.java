package programmer.zaman.now.test;

import java.util.Properties;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledForJreRange;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariables;
import org.junit.jupiter.api.condition.DisabledIfSystemProperties;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariables;
import org.junit.jupiter.api.condition.EnabledIfSystemProperties;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

public class ConditionTest {

	@Test
	void testSystemProperties() {
		Properties properties = System.getProperties();
		properties.forEach((key, value) -> System.out.println(key + ": " + value));
	}

	@Test
	@EnabledOnOs({ OS.WINDOWS })
	public void testRunOnlyOnWindows() {

	}

	@Test
	@DisabledOnOs({ OS.WINDOWS })
	public void testDisabledOnWindows() {

	}

	@Test
	@EnabledOnJre({ JRE.JAVA_8 })
	void testEnabledOnJava8() {

	}

	@Test
	@DisabledOnJre({ JRE.JAVA_8 })
	void testDisabledOnJava8() {

	}

	@Test
	@EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_17)
	void testEnabledOnJava11To15() {

	}

	@Test
	@DisabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_15)
	void testDisabledOnJava11To15() {

	}

	@Test
	@EnabledIfSystemProperties({ @EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation") })
	void testEnabledOnJavaVendorOracle() {

	}

	@Test
	@DisabledIfSystemProperties({ @DisabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation") })
	void testDisabledOnJavaVendorOracle() {

	}

	@Test
	@EnabledIfEnvironmentVariables({ @EnabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV") })
	void testEnabledOnProfileDev() {

	}

	@Test
	@DisabledIfEnvironmentVariables({ @DisabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV") })
	void testDisabledOnProfileDev() {

	}
}
