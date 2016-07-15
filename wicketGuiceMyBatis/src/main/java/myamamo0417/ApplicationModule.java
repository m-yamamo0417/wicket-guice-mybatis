package myamamo0417;

import org.apache.wicket.protocol.http.WebApplication;

import com.google.inject.AbstractModule;

public class ApplicationModule extends AbstractModule {

    protected void configure() {
	bind(WebApplication.class).to(Application.class);
    }
}
