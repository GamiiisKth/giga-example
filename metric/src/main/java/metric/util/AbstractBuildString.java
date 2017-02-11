package metric.util;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public abstract class AbstractBuildString implements BuildString{
    private boolean template;

    public AbstractBuildString() {
        this.template = false;
    }

    public AbstractBuildString(boolean template) {
        this.template = template;
    }

    public boolean isTemplate() {
        return template;
    }
}
