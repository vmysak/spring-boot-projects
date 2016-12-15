package org.zeksa.springcore.resources;

import org.junit.AssumptionViolatedException;
import org.junit.rules.Stopwatch;
import org.junit.runner.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class TestStopwatch extends Stopwatch {

    private static final Logger LOG = LoggerFactory.getLogger(ResourceAbstractTest.class);

    private static void logInfo(Description description, String status, long nanos) {
        String testName = description.getMethodName();
        LOG.info(String.format("Test %s %s, spent %d miliseconds",
                testName, status, TimeUnit.MILLISECONDS.convert(nanos, TimeUnit.NANOSECONDS)));
    }

    @Override
    protected void succeeded(long nanos, Description description) {
        logInfo(description, "succeeded", nanos);
    }

    @Override
    protected void failed(long nanos, Throwable e, Description description) {
        logInfo(description, "failed", nanos);
    }

    @Override
    protected void skipped(long nanos, AssumptionViolatedException e, Description description) {
        logInfo(description, "skipped", nanos);
    }

    @Override
    protected void finished(long nanos, Description description) {
        logInfo(description, "finished", nanos);
    }
}
