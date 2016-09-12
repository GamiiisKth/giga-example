package se.java.heterogeneous;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public interface Parameter {
    /**
     * \* Gets the name that was specified for this parameter. This is an
     * \* arbitrary name.
     * \*
     * \*
     * \* @return the name that was specified for this parameter.
     * \
     */

    public String getParameterName();


    /**
     * \* Gets the value of this parameter.
     * \*
     * \*
     * \* @return the value of this parameter.
     * \
     */

    public <T> T getParameterValue(Class<T> type);


    /**
     * \* Sets the value of this parameter.
     * \*
     * \*
     * \* @param type the type of this parameter
     * \*
     * \* @param value the value of this parameter
     * \
     */
    public <T> void setParameterValue(Class<T> type, T value);


    /**
     * Return the {@code ParameterValidator} for this parameter. The
     * {@code ParameterValidator} exposes the {@code validate} method
     * which will be used by objects that require validation of parameters.
     *
     * @return the parameterValidator for this parameter
     */
    public ParameterValidator getParameterValidator();
}