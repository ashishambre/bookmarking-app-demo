package com.ashish.thrillio.controllers;

import com.ashish.thrillio.entities.Bookmark;
import com.ashish.thrillio.entities.User;
import com.ashish.thrillio.entities.UserBookmark;
import com.ashish.thrillio.managers.BookmarkManager;

public class BookmarkController {
	private static BookmarkController instance = new BookmarkController();

	private BookmarkController() {
	}

	public static BookmarkController getInstance() {
		return instance;
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
		BookmarkManager.getInstance().saveUserBookmark(user, bookmark);
	}

	public void setKidFriendlyStatus(User user, String kidFriendlyStatus, Bookmark bookmark) {
		BookmarkManager.getInstance().setKidFriendlyStatus(user, kidFriendlyStatus, bookmark);
	}

	public void share(User user, Bookmark bookmark) {
		BookmarkManager.getInstance().share(user, bookmark);
	}

}
