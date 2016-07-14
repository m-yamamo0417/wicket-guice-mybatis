package myamamo0417;

import org.apache.wicket.protocol.http.WebApplication;

import myamamo0417.homepage.HomePage;

public class Application extends WebApplication {

    public Class getHomePage() {
	return HomePage.class;
    }
	    
}