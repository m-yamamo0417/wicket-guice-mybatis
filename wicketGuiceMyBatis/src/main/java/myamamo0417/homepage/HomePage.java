package myamamo0417.homepage;

import org.apache.wicket.event.IEvent;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.util.time.Duration;

public class HomePage extends WebPage {

    private final MessageInputPanel messageInputPanel;
    private final MessageViewPanel messageViewPanel;

    public HomePage() {
	messageInputPanel = new MessageInputPanel("messageInputPanel");
	messageViewPanel = new MessageViewPanel("messageViewPanel");
    }

    public void onEvent(IEvent<?> event) {
	super.onEvent(event);

	Object payload = event.getPayload();
	if (payload instanceof MessageInputPanel.MessageSubmitted) {
	    MessageInputPanel.MessageSubmitted submitted = (MessageInputPanel.MessageSubmitted) payload;
	    submitted.getTarget().add(messageViewPanel);
	}
	
    }

    protected void onInitialize() {
	super.onInitialize();

	messageViewPanel.setOutputMarkupId(true);
	
	add(messageInputPanel);
	add(messageViewPanel);
    }	

    public void renderHead(IHeaderResponse response) {
	response.render(CssHeaderItem.forUrl("https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/css/materialize.min.css"));
	response.render(JavaScriptHeaderItem.forUrl("https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/js/materialize.min.js"));
    }
}
