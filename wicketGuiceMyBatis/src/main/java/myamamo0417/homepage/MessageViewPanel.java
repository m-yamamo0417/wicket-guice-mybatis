package myamamo0417.homepage;

import java.util.Iterator;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import com.google.inject.Inject;

import myamamo0417.mapper.MessageMapper;

public class MessageViewPanel extends Panel {

    @Inject
    private MessageMapper mapper;

    public MessageViewPanel(String id) {
	super(id);
	add(new MessageView());
    }

    public void setMessageMapper(MessageMapper mapper) {
	this.mapper = mapper;
    }

    private class MessageView extends DataView<String> {

	MessageView() {
	    super("messages", new MessageProvider());
	}

	public void populateItem(final Item<String> item) {
	    item.add(new Label("message", item.getModelObject()));
	}
    }

    private class MessageProvider implements IDataProvider<String> {

	public Iterator<String> iterator(long first, long count) {
	    List<String> messages = MessageViewPanel.this.mapper.selectAll();
	    return messages.iterator();
	}

	public long size() {
	    List<String> messages = MessageViewPanel.this.mapper.selectAll();
	    return messages.size();
	}

	public IModel<String> model(String object) {
	    return Model.of(object);
	}

	public void detach() {
	}
    }

}
