package concurrency;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 *         <p>
 *         Safety (also known as concurrent type safety)
 *         ■ Liveness
 *         ■Performance
 *         ■Reusability
 *         <p>
 *         java.util.concurrent
 *         <p>
 *         Immutable
 *         These  are  always  safe  and  live,
 *         because their state can’t be mutated, so they can never be in an inconsistent state.
 */
public class Immutable {

    private final String author;
    private final String rate;

    private Immutable(Builder builder) {
        this.author = builder.author;
        this.rate = builder.rate;
    }


    public static class Builder implements ObjBuilder<Immutable> {
        private String author;
        private String rate;

        public Builder withAuthor(String author) {
            this.author = author;
            return this;
        }

        public Builder withRate(String rate) {
            this.rate = rate;
            return this;
        }

        @Override
        public Immutable build() {
            return new Immutable(this);
        }
    }

}
