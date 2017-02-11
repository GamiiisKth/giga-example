package metric.util;

import com.codahale.metrics.Counter;
import com.codahale.metrics.Meter;
import com.so4it.metric.springframework.MetricsBean;
import com.so4it.metric.springframework.MetricsMethod;

import java.util.Map;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */

@MetricsBean(name = "fibonacciSeriesMetric")
public abstract class FibonacciSeriesMetricImpl implements FibonacciSeriesMetric {


    
    private Meter meter ;

    public FibonacciSeriesMetricImpl() {
        this.meter = meter;
    }

    @Override
    @MetricsMethod("producerCountSize")
    public void producerCountSize() {

        
    }

    @Override
    @MetricsMethod("producerOneMinuteRate")
    public void producerOneMinuteRate() {

    }

    @Override
    @MetricsMethod("producerOneMeanRate")
    public void producerOneMeanRate() {

    }

    @Override
    @MetricsMethod("producerIncJob")
    public void producerIncJob() {

    }
}
