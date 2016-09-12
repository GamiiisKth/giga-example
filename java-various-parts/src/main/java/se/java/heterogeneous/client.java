package se.java.heterogeneous;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public class client {


    List<Parameter> parameters = new ArrayList<>();
    ParameterSupport ldapServerHostnameParameter = ParameterSupport.
            getParameterSupport(String.class, "127.0.0.1",

                    new ParameterValidator() {
                        public Boolean validate(Parameter parameter) {
                            Boolean result;

                            String hostname = parameter.getParameterValue(String.class);
                            if (hostname == null || hostname.length() == 0) {
                                result = false;
                            } else {
                                try {
                                    InetAddress inetAddress = InetAddress.getByName(hostname);
                                    result = true;
                                } catch (UnknownHostException unknownHost) {
                                    result = false;
                                }
                            }
                            return result;
                        }
                    });

    //   parameters.add(ldapServerHostnameParameter);
}
