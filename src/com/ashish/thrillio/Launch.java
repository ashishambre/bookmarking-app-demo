package com.ashish.thrillio;

import com.ashish.thrillio.entities.Bookmark;
import com.ashish.thrillio.entities.User;
import com.ashish.thrillio.managers.BookmarkManager;
import com.ashish.thrillio.managers.UserManager;

public class Launch {
	private static User[] users;
	private static Bookmark[][] bookmarks;

	private static void loadData() {
		//System.out.println("01 : Loading Data ...");
		DataStore.loadData();

		users = UserManager.getInstance().getUsers();
		bookmarks = BookmarkManager.getInstance().getBookmarks();

		//System.out.println("Printing Data...");
		//printUserData();
		//printBookmarkData();
	}

	private static void printUserData() {
		for (User user : users)
			System.out.println(user);
	}

	private static void printBookmarkData() {
		for (Bookmark[] bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {
				System.out.println(bookmark);
			}
		}
	}
	
	private static void start() {
		System.out.println("2. Bookmarking ...");
		for(User user : users) {
			View.browse(user, bookmarks);
		}
	}

	public static void main(String[] args) {
		loadData();
		start();
	}

}
