package demoprojects.currencyconverterapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CurrencyconverterapiApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void main() {
		// Loading a Spring context of the application takes time - it is bad.
		// This test is only for metrics to complete 100% coverage as this is a demo project
		CurrencyconverterapiApplication.main(new String[] {});
	}
}
