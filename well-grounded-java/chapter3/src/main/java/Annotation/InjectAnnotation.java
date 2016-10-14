package Annotation;

import javax.inject.Inject;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 *         page 62
 *         3.2.1
 *         The @Inject annotation
 *         <p>
 *         The class member types that can be injected, in the order that they’re processed at runtime are:
 *         1 Constructors 2 Methods 3 Fields
 */
public class InjectAnnotation {

    String s1;
    String s2;

    /**
     * You can annotate a constructor with @Inject and expect its parameters to be provided at runtime by your configured IoC
     * container. For example, the Header and Content objects are injected into the MurmurMessage when the constructor is invoked.
     * <p>
     * only  be  one  constructor  in  a class with an @Inject annotation
     */
    @Inject
    public InjectAnnotation(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }


    /**
     * Inject Method
     * <p>
     * TIP:: It has become a default best practice to use constructor injection for set- ting mandatory dependencies
     * for a class and to use setter injection for non- mandatory dependencies, such as fields that already have sensible defaults.
     * page 63
     */

    @Inject
    public void setS1(String s1) {
        this.s1 = s1;
    }

    @Inject
    public void setS2(String s2) {
        this.s2 = s2;
    }
}
