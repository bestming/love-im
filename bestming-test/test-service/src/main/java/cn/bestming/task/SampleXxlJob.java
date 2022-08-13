package cn.bestming.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import com.xxl.job.core.handler.annotation.XxlJob;

/**
 * @author wxm
 * @date 2022/8/13 18:28
 */
public class SampleXxlJob {
    // private static Logger logger = LoggerFactory.getLogger(SampleXxlJob.class);
    /**
     * 1、简单任务示例（Bean模式）
     */
    @XxlJob("demoJobHandler")
    public void demoJobHandler() throws Exception {
        System.out.println("1、简单任务示例（Bean模式） demoJobHandler.......");
        for (int i = 0; i < 5; i++) {
            TimeUnit.SECONDS.sleep(2);
        }
    }
}
