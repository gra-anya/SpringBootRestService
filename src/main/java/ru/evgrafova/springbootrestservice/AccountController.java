package ru.evgrafova.springbootrestservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
public class AccountController {

    @GetMapping
    public String getJson() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return "{\"account\":\"AAA\",\"password\":\"BBB\"}";
    }

    @PostMapping
    public String pay(@RequestBody Account account) throws JsonProcessingException, InterruptedException {
        String accountName = account.getAccount();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy hh:mm:ss");
        String date = dtf.format(LocalDateTime.now());
        Map<String, String> map = new HashMap<>();
        map.put("account", accountName);
        map.put("date", date);
        String json = new ObjectMapper().writeValueAsString(map);
        TimeUnit.SECONDS.sleep(5);
        return json;
    }
}
