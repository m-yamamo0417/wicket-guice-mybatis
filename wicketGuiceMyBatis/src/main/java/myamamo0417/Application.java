package myamamo0417;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

import myamamo0417.homepage.HomePage;

public class Application extends WebApplication {

    public Class<? extends WebPage> getHomePage() {
	return HomePage.class;
    }
	    
}