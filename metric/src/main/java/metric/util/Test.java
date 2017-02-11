package metric.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public class Test {

    private static String[] metrics = {
            "50thPercentile",
            "90thPercentile",
            "99thPercentile",
            "DurationUnit",
            "ErrorCount",
            "InvocationCount",
            "Max",
            "Min",
            "MeanRate",
            "OneMinuteRate",
            "RateUnit"};

    private static String[] metricsName = {
            "FiftyPercentile",
            "NinetyPercentile",
            "NinetyNinePercentile",
            "DurationUnit",
            "ErrorCount",
            "InvocationCount",
            "Max",
            "Min",
            "MeanRate",
            "OneMinuteRate",
            "RateUnit"};

    private static String[] completeQuerys = new String[metrics.length];


    public static void main(String[] args) {


        BufferedReader br = null;
        String packageName;

        try {

            br = new BufferedReader(new InputStreamReader(System.in));

            while (true) {

                System.out.println("enter package name");

                packageName= br.readLine();

                System.out.println("enter the bean follow by package name");

                String input = br.readLine();

                if ("q".equals(input)) {
                    System.out.println("Exit!");
                    System.exit(0);
                } else {
                    if (input.contains("&")) {
                        String[] splits = input.split("&");
                        for (String s : splits) {

                            System.out.println("--------start---------");
                            createMetricQuery(s, "_"+packageName);

                            for (String a : completeQuerys) {

                                System.out.println(a);
                            }

                            System.out.println("---------end--------");
                        }
                    } else {
                        System.out.println("--------start---------");
                        createMetricQuery(input,"_"+packageName);

                        for (String a : completeQuerys) {

                            System.out.println(a);
                        }

                        System.out.println("---------end--------");
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private static void createMetricQuery(String s, String clazz) {
        final String objectName = "<query objectName=";
        final String attribute = " attribute=";
        final String resultAlias = " resultAlias=";


        StringBuilder buildQuery = new StringBuilder();

        for (int i = 0; i < metrics.length; i++) {

            completeQuerys[i] = buildQuery
                    .append(objectName).append("'")
                    .append(s).append("'")
                    .append(attribute).append("'")
                    .append(metrics[i]).append("'")
                    .append(resultAlias).append("'")
                    .append(metricsName[i]).append(clazz).append("'")
                    .append("/>").toString();

            buildQuery.setLength(0);

        }

    }
}
