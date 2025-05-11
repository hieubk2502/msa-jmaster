package com.dev.account.service.client;

import com.dev.account.dto.CreateStatisticDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "statistic-service"
        , url = "http://localhost:8081/statistic"
        , fallback = StatisticServiceImpl.class
        ,configuration = StatisticFeignClientConfiguration.class)
public interface StatisticService {

    @PostMapping("/create")
    void add(@RequestBody CreateStatisticDTO statisticDTO) ;
}

@Component
@Slf4j
class StatisticServiceImpl implements StatisticService {
    @Override
    public void add(CreateStatisticDTO statisticDTO) {
        // fallback
        log.error("Statistic service is slow");
    }
}
// Nếu không cấu hình tự đọng thì khi có request tới thằng statistic
// thì tk bean sẽ call tới auth server để lấy token r đính kèm request r gửi sang

class StatisticFeignClientConfiguration {
//
//    private final String CLIENT_REGISTRATION_ID = "a-service";
//
//    @Bean
//    RequestInterceptor requestInterceptor(OAuth2AuthorizedClientManager authorizedClientManager) {
//        return new OAuth2AccessTokenInterceptor(CLIENT_REGISTRATION_ID, authorizedClientManager);
//    }
}
