package ca.bytetube.ood._03_movierecommendation;

import java.util.List;
import java.util.Map;

public class Recommendation {
    private RatingRegister register;

    public Recommendation(RatingRegister register) {
        this.register = register;
    }

    public String recommendMovie(User user) {
        //newUser
        if (register.getUserMovies(user).isEmpty()) return recommendMovieNewUser();
            //ExistingUser
        else return recommendMovieExistingUser(user);


    }


    public String recommendMovieNewUser() {
        double bestRating = 0;
        Movie bestMovie = null;
        for (Movie movie : register.getMovies()) {
            double rating = register.getAverageRating(movie);
            if (rating > bestRating) {
                bestRating = rating;
                bestMovie = movie;
            }
        }

        if (bestMovie != null) {
            return bestMovie.getTitle();

        } else {
            return null;
        }

    }

    public String recommendMovieExistingUser(User user) {
        int similarityScore = Integer.MAX_VALUE;
        Movie bestMovie = null;
        User BestReviewer = null;
        for (User reviewer : register.getUsers()) {
            if (reviewer.getId() == user.getId()) continue;

            int similarity = getSimilarity(user, reviewer);
            if (similarity < similarityScore) {
                similarityScore = similarity;
                BestReviewer = reviewer;
            }
        }

        Movie movie = recommendUnwatchedMovie(user, BestReviewer);
        bestMovie = movie != null ? movie : bestMovie;

        return bestMovie != null ? bestMovie.getTitle() : null;
    }

    private Movie recommendUnwatchedMovie(User user, User reviewer) {
        Movie bestMovie = null;
        int bestRating = 0;
        for (Movie movie : register.getUserMovies(reviewer)) {
            Map<Integer, MovieRating> ratings = register.getMovieRatings(movie);
            if (!ratings.containsKey(user.getId()) && ratings.get(reviewer.getId()).ordinal() > bestRating) {
                bestMovie = movie;
                bestRating = ratings.get(reviewer.getId()).ordinal();
            }

        }
        return bestMovie;
    }


    private int getSimilarity(User user1, User user2) {
        int similarity = Integer.MAX_VALUE;
        for (Movie movie : register.getUserMovies(user2)) {
            Map<Integer, MovieRating> ratings = register.getMovieRatings(movie);
            if (ratings.containsKey(user1.getId())) {
                similarity = similarity == Integer.MAX_VALUE ? 0 : similarity;
                similarity += Math.abs(ratings.get(user1.getId()).ordinal() - ratings.get(user2.getId()).ordinal());
            }
        }

        return similarity;
    }

}
