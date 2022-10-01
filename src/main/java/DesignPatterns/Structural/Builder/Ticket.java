package main.java.DesignPatterns.Structural.Builder;

public class Ticket {

    String id;
    String screenName;
    String movieName;
    String seatNumber;

    public Ticket(Builder builder) {
        this.id = builder.id;
        this.screenName = builder.screenName;
        this.movieName = builder.movieName;
        this.seatNumber = builder.seatNumber;
    }


    static final class Builder {
        private String id;
        private String screenName;
        private String movieName;
        private String seatNumber;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setScreenName(String screenName) {
            this.screenName = screenName;
            return this;
        }

        public Builder setMovieName(String movieName) {
            this.movieName = movieName;
            return this;
        }

        public Builder setSeatNumber(String seatNumber) {
            this.seatNumber = seatNumber;
            return this;
        }

        public Ticket build() {
            return new Ticket(this);
        }
    }
}
