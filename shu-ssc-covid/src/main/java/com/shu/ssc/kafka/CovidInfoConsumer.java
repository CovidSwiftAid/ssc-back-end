package com.shu.ssc.kafka;

import com.shu.ssc.entity.covid.WeiboCCTVNews;
import com.shu.ssc.redis.CovidInfoKeys;
import com.shu.ssc.service.WeiboCCTVNewsService;
import com.shu.ssc.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.internals.DefaultPartitioner;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author oxotn3
 * @create 2021-12-28
 * @description
 */
@Slf4j
@Component
public class CovidInfoConsumer {
    @Resource
    RedisUtil redisUtil;

    @Resource
    WeiboCCTVNewsService weiboCCTVNewsService;

    public static final long ExpireTime = 24 * 60 * 60;  // 24小时过期

    @KafkaListener(topics = "ssc_covid_weiboCCTVNews", groupId = "ssc_covid_weiboCCTVNews")
    public void updateWeiboCCTVNews(ConsumerRecord<?, ?> record, Acknowledgment ack, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        Optional message = Optional.ofNullable(record.value());
        if (message.isPresent()) {
            Object msg = message.get();
            log.info("CovidInfoConsumer 消费了 Topic:" + topic + ", Message:" + msg);
            ack.acknowledge();

            if (redisUtil.hasKey(CovidInfoKeys.WeiboCCTVNewsKey.getKey())) {
                redisUtil.del(CovidInfoKeys.WeiboCCTVNewsKey.getKey());
                log.info("redis中 WeiboCCTVNews 未过期，已删除");
            }
            List<WeiboCCTVNews> weiboCCTVNewsList = weiboCCTVNewsService.getAllWeiboCCTVNews();
            // 缓存到redis中
            redisUtil.set(CovidInfoKeys.WeiboCCTVNewsKey.getKey(), weiboCCTVNewsList, ExpireTime);
            log.info("redis中 WeiboCCTVNews 已更新");
        } else {
            log.error("updateWeiboCCTVNews() error!");
        }
    }




}
