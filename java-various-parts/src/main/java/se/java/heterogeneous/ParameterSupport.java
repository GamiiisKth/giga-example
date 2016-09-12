package se.java.heterogeneous;

/**
 * Provides support for the heterogeneous container
 * <p>
 * ParameterSupport implements the methods of the Parameter interface by using a
 * java.util.Map to store parameter values keyed to the type of the parameter.
 * It also provides a static method to return a parameterSupport object - note that the client provides the type,
 * value, the ParameterValidator object.
 *
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */


import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ParameterSupport implements Parameter {
    private static final Logger LOGGER = Logger.getLogger(ParameterSupport.class);
    private String name;
    private ParameterValidator parameterValidator;
    private Map<Class<?>, Object> parameterMap = new HashMap<>();

    public static <T> ParameterSupport getParameterSupport(Class<T> type, T value, ParameterValidator parameterValidator) {
        ParameterSupport ps = new ParameterSupport();
        ps.setParameterValue(type, value);
        ps.setParameterValidator(parameterValidator);
        return ps;
    }


    /**
     * Gets the name that was specified for this parameter. This is an
     * arbitrary name.
     *
     * @return the name that was specified for this parameter.
     */
    public String getParameterName() {
        return this.name;
    }

    /**
     * \* Gets the value of this parameter.
     * \*
     * \*
     * \* @return the value of this parameter.
     * \
     */
    public <T> T getParameterValue(Class<T> type) {
        return type.cast(parameterMap.get(type));
    }


    /**
     * \* Sets the value of this parameter. If {@code type} is null, this
     * \* method throws a {@code NullPointerException}.
     * \*
     * \*
     * \* @param type the type of this parameter
     * \*
     * \* @param value the value of this parameter
     * \
     */
    public <T> void setParameterValue(Class<T> type, T value) {
        if (type == null) {
            throw new NullPointerException("type cannot be null");
        }
        parameterMap.put(type, value);
    }


    /**
     * Return the {@code ParameterValidator} for this parameter. The
     * {@code ParameterValidator} exposes the {@code validate} method
     * which will be used by objects that require validation of parameters.
     *
     * @return the parameterValidator for this parameter
     */
    public ParameterValidator getParameterValidator() {
        return this.parameterValidator;
    }


    /**
     * \* Sets the {@code ParameterValidator} for this parameter. The
     * \* {@code ParameterValidator} exposes the {@code validate} method
     * \* which will be used by objects that require validation of parameters.
     * \*
     * \*
     * \* @param parameterValidator the parameterValidator for this parameter
     * \
     */
    public void setParameterValidator(ParameterValidator parameterValidator) {
        this.parameterValidator = parameterValidator;
    }


    /**
     * \* Performs validation checks on the {@code parameters}. The
     * \* parameter checks are specific to the type of database. If the
     * \* parameters validate successfully, this method return {@code true},
     * \* otherwise the method returns {@code false}.
     * \* <br />
     * \* If {@code parameters} is null, no action is taken, no exception
     * \* is thrown, and this method returns {@code false}.
     * \*
     * \* @param parameters a list of parameters to validate
     * \
     */
    public Boolean validateParameters(List<Parameter> parameters) {
        Boolean result;
        for (Parameter parameter : parameters) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("validating parameter: " + parameter.getParameterName());
            }
            ParameterValidator pv = parameter.getParameterValidator();
            pv.validate(parameter);
        }
        return true;
    }
}