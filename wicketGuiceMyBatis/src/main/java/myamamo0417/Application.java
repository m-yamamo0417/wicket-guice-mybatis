package myamamo0417;

import com.google.inject.Inject;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

import org.apache.ibatis.exceptions.PersistenceException;

import myamamo0417.homepage.HomePage;
import myamamo0417.mapper.MessageMapper;

public class Application extends WebApplication {

    private final MessageMapper messageMapper;

    @Inject
    public Application(MessageMapper messageMapper) {
	this.messageMapper = messageMapper;
    }

    public Class<? extends WebPage> getHomePage() {
	return HomePage.class;
    }

    protected void init() {
	try {
	    messageMapper.drop();
	} catch (PersistenceException e) {
	    
	}
	messageMapper.create();
    }
	    
}