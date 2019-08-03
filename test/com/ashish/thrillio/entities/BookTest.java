package com.ashish.thrillio.entities;

import static org.junit.Assert.assertFalse;
import org.junit.jupiter.api.Test;

import com.ashish.thrillio.constants.BookGenre;
import com.ashish.thrillio.managers.BookmarkManager;

class BookTest {

	@Test
	void testIsKidFriendlyEligible() {
		// test 1
		Book book = BookmarkManager.getInstance().createBook(4000, "Walden", "", 1854, "Wilder Publications",
				new String[] { "Henry David Thoreau" }, BookGenre.PHILOSOPHY, 4.3);
		boolean isKidFriendlyEligible = book.isKidFriendlyEligible();
		assertFalse("For Philosophy -- return False",isKidFriendlyEligible);
		
		// test 2
		book = BookmarkManager.getInstance().createBook(4000, "Walden", "", 1854, "Wilder Publications",
				new String[] { "Henry David Thoreau" }, BookGenre.SELF_HELP, 4.3);
		isKidFriendlyEligible = book.isKidFriendlyEligible();
		assertFalse("For Self help -- return False",isKidFriendlyEligible);
	}
}
