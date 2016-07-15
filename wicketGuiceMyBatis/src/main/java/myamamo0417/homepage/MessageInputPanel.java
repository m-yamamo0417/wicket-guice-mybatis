package myamamo0417.homepage;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.event.Broadcast;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

import com.google.inject.Inject;

import myamamo0417.mapper.MessageMapper;

public class MessageInputPanel extends Panel {

    @Inject
    private MessageMapper mapper;

    public MessageInputPanel(String id) {
	super(id);
    }

    protected void onInitialize() {
	super.onInitialize();

	Form form = new Form("form");
	final TextField<String> text = new TextField<String>("text", Model.of(""));
	text.setOutputMarkupId(true);
	AjaxButton button = new AjaxButton("button") {
		protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
		    String message = text.getModelObject();
		    MessageInputPanel.this.mapper.insert(message);
		    text.setModelObject("");
		    target.add(text);
		    send(this, Broadcast.BUBBLE, new MessageSubmitted(target));
		}
	    };

	form.add(text);
	form.add(button);
	add(form);
    }

    public void setMessageMapper(MessageMapper mapper) {
	this.mapper = mapper;
    }

    static class MessageSubmitted {
	private final AjaxRequestTarget target;

	private MessageSubmitted(AjaxRequestTarget target) {
	    this.target = target;
	}

	AjaxRequestTarget getTarget() {
	    return target;
	}
    }
}
