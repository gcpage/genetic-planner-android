package planner.model.item;

import java.io.Serializable;
import java.util.ArrayList;

import planner.model.data.ItemEntity;

public abstract class Item implements Serializable {
	
	private static final long serialVersionUID = -7943195019888260373L;

	public int itemId;
	public ItemType type;
	public String title;
	public String details;

	public ArrayList<Note> notes;

	public Item(int itemId, ItemType type, String title, String details) {
		this.itemId = itemId;
		this.type = type;
		this.title = title;
		this.details = details;
		this.notes = new ArrayList<>();
	}
	
	public abstract ArrayList<Note> generateNotes(long[] gene);
	
	public abstract void complete(Note note);
	
	public void clean() {
		notes.clear();
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
