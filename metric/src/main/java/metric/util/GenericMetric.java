package metric.util;

import com.codahale.metrics.Counter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.Metric;
import org.springframework.stereotype.Component;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */

public interface GenericMetric{


    void producerCountSize();

    void producerOneMinuteRate();

    void producerOneMeanRate();

    void producerIncJob();

    void producerIncDecJob();


    void setConsumerCountSize();

    void setConsumerOneMinuteRate();

    void setConsumerOneMeanRate();


}
