package com.ashish.thrillio.entities;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

import com.ashish.thrillio.constants.BookGenre;
import com.ashish.thrillio.partners.Shareable;

public class Book extends Bookmark implements Shareable {
	private int publicationYear;
	private String publisher;
	private String[] authors;
	private String genre;
	private double amazonRating;

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String[] getAuthors() {
		return authors;
	}

	public void setAuthors(String[] authors) {
		this.authors = authors;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getAmazonRating() {
		return amazonRating;
	}

	public void setAmazonRating(double amazonRating) {
		this.amazonRating = amazonRating;
	}

	public boolean isKidFriendlyEligible() {
		if (genre.equals(BookGenre.SELF_HELP) || (genre.equals(BookGenre.PHILOSOPHY))) {
			return false;
		}
		return true;
	}

	public String getItemData() {
		StringBuilder builder = new StringBuilder();
		builder.append("<item>");
		builder.append("<type>Book</type>");
		builder.append("<title>").append(getTitle()).append("</title>");
		builder.append("<publicationYear>").append(publicationYear).append("</publicationYear>");
		builder.append("<publisher>").append(publisher).append("</publisher>");
		builder.append("<authors>").append(StringUtils.join(authors, ",")).append("</authors>");
		builder.append("<genre>").append(genre).append("</genre>");
		builder.append("<amazonRating>").append(publicationYear).append("</amazonRating>");
		builder.append("</item>");
		return builder.toString();
	}

	public String toString() {
		return "Book [publicationYear=" + publicationYear + ", publisher=" + publisher + ", authors="
				+ Arrays.toString(authors) + ", genre=" + genre + ", amazonRating=" + amazonRating + "]";
	}
}
