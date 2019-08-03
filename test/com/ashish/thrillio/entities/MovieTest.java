package com.ashish.thrillio.entities;

import static org.junit.Assert.assertFalse;
import org.junit.jupiter.api.Test;

import com.ashish.thrillio.constants.MovieGenre;
import com.ashish.thrillio.managers.BookmarkManager;

class MovieTest {

	@Test
	void testIsKidFriendlyEligible() {
		// Movie Genre should not be Horror or Thriller
		
		// test 1
		Movie movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.HORROR,
				8.5);
		
		boolean isKidFriendly = movie.isKidFriendlyEligible();
		assertFalse("for genre Horror isKidFriendlyEligible() should return False", isKidFriendly);
		
		// test 2
		movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.THRILLERS,
				8.5);
		isKidFriendly = movie.isKidFriendlyEligible();
		assertFalse("for genre Thriller isKidFriendlyEligible() should return False", isKidFriendly);
		
	}

}
