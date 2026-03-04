package cs3220;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import cs3220.model.GuestBookEntry;

@Component
public class DataComponent {
	private List<GuestBookEntry> entries;
	
	public DataComponent() {
		entries = new ArrayList<GuestBookEntry>();
		entries.add(new GuestBookEntry("Tom", "Hi from Component Bean"));
		entries.add(new GuestBookEntry("John", "Hello"));
	}
	
	public GuestBookEntry getEntryById(int id) {
		for (GuestBookEntry entry : entries) {
			if (entry.getId() == id) {
				return entry;
			}
		}
		return null;
	}

	public List<GuestBookEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<GuestBookEntry> entries) {
		this.entries = entries;
	}
}
