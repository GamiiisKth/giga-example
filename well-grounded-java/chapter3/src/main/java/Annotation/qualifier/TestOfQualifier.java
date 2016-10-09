package Annotation.qualifier;

import javax.inject.Inject;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 *         <p>
 *         <p>
 *         lof of qualifire annotation
 *         http://buraktas.com/create-qualifiers-cdi-beans/
 *         https://spring.io/blog/2014/11/04/a-quality-qualifier
 */
public class TestOfQualifier {
    @Inject
    @MusicGenreAnnotation(genre = Genre.CLASSICAL)
    Genre genre;


    public static void main(String[] args) {
        TestOfQualifier testOfQualifier = new TestOfQualifier();

        if (testOfQualifier.genre.equals(Genre.CLASSICAL)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

}
