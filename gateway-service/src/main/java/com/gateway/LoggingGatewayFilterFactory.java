package com.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component("Logging")
@Slf4j
public class LoggingGatewayFilterFactory extends AbstractGatewayFilterFactory<LoggingGatewayFilterFactory.Config> {

    public LoggingGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return new OrderedGatewayFilter((exchange, chain) -> {
            // Pre-processing
            log.info("Pre GatewayFilter logging: ");
            return chain.filter(exchange)
                    .then(Mono.fromRunnable(() -> {
                        // Post-processing
                        log.info("Post GatewayFilter logging: ");
                    }));
        }, -2);
    }

    public static class Config {
        //Put the configuration properties for your filter here
        private String baseMsg;

        public void setBaseMsg(String baseMsg) {
            this.baseMsg = baseMsg;
        }

        public String getBaseMsg() {
            return baseMsg;
        }
    }


}
