package myamamo0417.homepage;

import org.apache.wicket.event.IEvent;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.util.time.Duration;

public class HomePage extends WebPage {

    private final MessageInputPanel messageInputPanel;
    private final MessageViewPanel messageViewPanel;

    public HomePage() {
	messageInputPanel = new MessageInputPanel("messageInputPanel");
	messageViewPanel = new MessageViewPanel("messageViewPanel");
    }

    protected void onInitialize() {
	super.onInitialize();

	messageViewPanel.setOutputMarkupId(true);
	
	add(messageInputPanel);
	add(messageViewPanel);
    }	

    public void onEvent(IEvent<?> event) {
	super.onEvent(event);

	Object payload = event.getPayload();
	if (payload instanceof MessageInputPanel.MessageSubmitted) {
	    MessageInputPanel.MessageSubmitted submitted = (MessageInputPanel.MessageSubmitted) payload;
	    submitted.getTarget().add(messageViewPanel);
	}
	
    }
}
