package com.ashish.thrillio.dao;

import com.ashish.thrillio.DataStore;
import com.ashish.thrillio.entities.Bookmark;
import com.ashish.thrillio.entities.UserBookmark;

public class BookmarkDao {
	public Bookmark[][] getBookmarks() {
		return DataStore.getBookmarks();
	}

	public void saveUserBookmark(UserBookmark userBookmark) {
		DataStore.add(userBookmark);
	}
}
