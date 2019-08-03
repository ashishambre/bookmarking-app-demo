package com.ashish.thrillio.entities;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

import com.ashish.thrillio.constants.MovieGenre;
import com.ashish.thrillio.partners.Shareable;

public class Movie extends Bookmark implements Shareable {
	private int releaseYear;
	private String[] cast;
	private String[] directors;
	private String genre;
	private double imdbRating;

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String[] getCast() {
		return cast;
	}

	public void setCast(String[] cast) {
		this.cast = cast;
	}

	public String[] getDirectors() {
		return directors;
	}

	public void setDirectors(String[] directors) {
		this.directors = directors;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}

	public boolean isKidFriendlyEligible() {
		if (genre.equals(MovieGenre.HORROR) || genre.equals(MovieGenre.THRILLERS)) {
			return false;
		}
		return true;
	}

	public String toString() {
		return "Movie [releaseYear=" + releaseYear + ", cast=" + Arrays.toString(cast) + ", directors="
				+ Arrays.toString(directors) + ", genre=" + genre + ", imdbRating=" + imdbRating + "]";
	}

	@Override
	public String getItemData() {
		StringBuilder builder = new StringBuilder();
		builder.append("<item>");
		builder.append("<type>Movie</type>");
		builder.append("<title>").append(getTitle()).append("</title>");
		builder.append("<releaseYear>").append(releaseYear).append("</releaseYear>");
		builder.append("<cast>").append(StringUtils.join(cast, ",")).append("</cast>");
		builder.append("<directors>").append(StringUtils.join(directors, ",")).append("</directors>");
		builder.append("<genre>").append(genre).append("</genre>");
		builder.append("<imdbRating>").append(imdbRating).append("</imdbRating>");
		builder.append("</item>");
		return builder.toString();
	}
}
