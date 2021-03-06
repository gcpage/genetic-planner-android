package planner.model.item;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import planner.model.core.C;
import planner.model.data.NoteEntity;

public class Note implements Comparable<Note>, Serializable {

	private static final long serialVersionUID = 5710812068584817767L;

	public int noteId;
	public String title;
	public String details;
	public long start;
	public long duration;

	public Item parent;

	public Note(int noteId, String title, String details, long start, long duration, Item parent) {
		this.noteId = noteId;
		this.title = title;
		this.details = details;
		this.start = start;
		this.duration = duration;
		this.noteId = hashCode();
		this.parent = parent;
	}

	public Note(long start, long duration) {
		title = null;
		details = null;
		this.start = start;
		this.duration = duration;
		parent = null;
	}

	public void complete() {
		parent.complete(this);
	}

	@Override
	public int compareTo(@NonNull Note other) {
		return (int) Math.signum(this.start - other.start);
	}

	@Override
	public String toString() {
		SimpleDateFormat f = new SimpleDateFormat(C.DATE_TIME_FORMAT, Locale.US);
		//String str = f.format(getStartDate().getTime()) + " - " + f.format(getEndDate().getTime()) + ": " + title;
		String str = start + " - " + getEnd() + ": " + title;
		if (details != null && !details.equals(""))
			str += " - " + details;
		str += " [" + noteId + "]";
		return str;
	}

	public Calendar getStartDate() {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(start);
		return cal;
	}

	private Calendar getEndDate() {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(start + duration);
		return cal;
	}

	public long getEnd() {
		return start + duration;
	}
}
