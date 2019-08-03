package com.ashish.thrillio;

import com.ashish.thrillio.constants.KidFriendlyStatus;
import com.ashish.thrillio.constants.UserType;
import com.ashish.thrillio.controllers.BookmarkController;
import com.ashish.thrillio.entities.Bookmark;
import com.ashish.thrillio.entities.User;
import com.ashish.thrillio.partners.Shareable;

public class View {
	public static void browse(User user, Bookmark[][] bookmarks) {
		System.out.println("\n" + user.getEmail() + " is browsing item.");
		int bookmarkCount = 0;

		for (Bookmark[] bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {
				// Bookmarking
				if (bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
					boolean isBookmarked = getBookmarkDecision(bookmark);
					if (isBookmarked) {
						bookmarkCount++;

						BookmarkController.getInstance().saveUserBookmark(user, bookmark);

						System.out.println("New item bookmarked -- " + bookmark);
					}
				}
				// Mark as Kid friendly
				if (user.getUserType().equals(UserType.EDITOR) || user.getUserType().equals(UserType.CHIEF_EDITOR)) {
					if (bookmark.isKidFriendlyEligible()
							&& bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
						String kidFriendlyStatus = getKidFriendlyStatusDecision(bookmark);
						if (!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)) {
							BookmarkController.getInstance().setKidFriendlyStatus(user, kidFriendlyStatus, bookmark);
						}
					}
				}
				// Sharing
				if(bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED) && bookmark instanceof Shareable) {
					boolean isShared = getShareDecision();
					if(isShared) {
						BookmarkController.getInstance().share(user, bookmark);
					}
				}
			}
		}
	}

	private static boolean getShareDecision() {
		return Math.random() < 0.5 ? true : false;
	}

	private static String getKidFriendlyStatusDecision(Bookmark bookmark) {
		return Math.random() < 0.4 ? KidFriendlyStatus.APPROVED
				: (Math.random() >= 0.4 && Math.random() < 0.8 ? KidFriendlyStatus.REJECTED
						: KidFriendlyStatus.UNKNOWN);
	}

	private static boolean getBookmarkDecision(Bookmark bookmark) {
		return Math.random() < 0.5 ? true : false;
	}

	/*
	 * public static void bookmark(User user, Bookmark[][] bookmarks) {
	 * System.out.println("\n"+ user.getEmail() + "is bookmarking..."); for(int i =
	 * 0; i < DataStore.USER_BOOKMARK_LIMIT; i++) { int typeOffset =
	 * (int)(Math.random() * DataStore.BOOKMARKS_TYPE_COUNT); int bookmarkOffset =
	 * (int)(Math.random() * DataStore.BOOKMARK_COUNT_PER_TYPE);
	 * 
	 * Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];
	 * 
	 * BookmarkController.getInstance().saveUserBookmark(user, bookmark);
	 * 
	 * System.out.println(bookmark); } }
	 */
}
