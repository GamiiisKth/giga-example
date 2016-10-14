package Annotation.qualifier;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 * <p>
 * page 64 see the picture
 * <p>
 * if you had two objects of the same type configured in your IoC container,
 * you’d want to be able to distinguish between those two objects when it came to injecting them into your code.
 * The visual representation in figure 3.1 helps explain this concept.
 */


import javax.inject.Qualifier;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * ■ It must be annotated with the @Qualifier
 * and @Retention(RUNTIME) annotations. This ensures that the qualifier is retained at runtime.
 * ■ It should typically be @Documented so that the implementation is added as part of the public Javadoc for that API.
 * ■ It can have attributes.
 * ■ It may have restricted usage if annotated with @Target; for example, it might
 * restrict usage to fields as opposed to the default of fields and method parameters.
 * To bring the preceding list into perspective, here’s a brief hypothetical example of a @Qualifier
 * implementation that an IoC container might provide for you. A music library framework might provide a @MusicGenreAnnotation qualifier,
 * which can be used by developers when they create a MetalRecord Albumns class.
 * The qualifier ensures that the injected Genre is of the right type.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface MusicGenreAnnotation {

    Genre genre() default Genre.TRANCE;
}
