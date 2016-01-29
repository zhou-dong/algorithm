package org.dzhou.interview.ood;

import java.util.ArrayList;
import java.util.List;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 */
public class FileSystem {

	public abstract class Entry {

		protected long created;
		protected long lastUpdated;
		protected long lastAccessed;
		protected String name;
		protected Directory parent;

		public Entry(String name, Directory parent) {
			this.name = name;
			this.parent = parent;
			created = System.currentTimeMillis();
			lastUpdated = System.currentTimeMillis();
			lastAccessed = System.currentTimeMillis();
		}

		public abstract int size();

		public String getFullPath() {
			if (parent == null)
				return name;
			else
				return parent.getFullPath() + "/" + name;
		}

		public Directory getParent() {
			return parent;
		}

		public void setParent(Directory parent) {
			this.parent = parent;
		}

		public long getLastUpdated() {
			return lastUpdated;
		}

		public void setLastUpdated(long lastUpdated) {
			this.lastUpdated = lastUpdated;
		}

		public long getLastAccessed() {
			return lastAccessed;
		}

		public void setLastAccessed(long lastAccessed) {
			this.lastAccessed = lastAccessed;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public long getCreated() {
			return created;
		}

	}

	public class File extends Entry {

		private String content;
		private int size;

		public File(String name, Directory parent) {
			super(name, parent);
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public void setSize(int size) {
			this.size = size;
		}

		@Override
		public int size() {
			return this.size;
		}

	}

	public class Directory extends Entry {

		protected List<Entry> contents;

		public Directory(String name, Directory parent) {
			super(name, parent);
			contents = new ArrayList<>();
		}

		@Override
		public int size() {
			int size = 0;
			for (Entry entry : contents) {
				size += entry.size();
			}
			return size;
		}

		public boolean deleteEntry(Entry entry) {
			return contents.remove(entry);
		}

		public void addEntry(Entry entry) {
			contents.add(entry);
		}

		public int numberOfFiles() {
			int count = 0;
			for (Entry entry : contents) {
				if (entry instanceof Directory)
					count += ((Directory) entry).numberOfFiles();
				count++;
			}
			return count;
		}

		public List<Entry> getContents() {
			return new ArrayList<>(contents);
		}

	}

}
