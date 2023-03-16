package com.kt.sw.edu.api.friend;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
@RequestMapping("/friends/discovery/{name}/properties")
public class FriendPropertiesDiscoveryController {

    /**
     * URL에 있는 address 값에 요청하는 기능을 가지고 있음
     * 로컬에서 실행한다면  IP:Port로 들어가야 함
     * VM에서 호출한다면 hostname이 들어가야 함
     */

    private final DiscoveryClient discoveryClient;

    private final RestTemplate restTemplate;

    public FriendPropertiesDiscoveryController(DiscoveryClient discoveryClient, RestTemplate restTemplate) {
        this.discoveryClient = discoveryClient;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/name")
    public String retrieveFriendName(@PathVariable String name) {
        return restTemplate.getForEntity(getUri(name) + "/properties/name", String.class).getBody();
    }

    @GetMapping("/number")
    public Integer retrieveFriendNumber(@PathVariable String name) {
        return restTemplate.getForEntity(getUri(name) + "/properties/number", Integer.class).getBody();
    }

    @GetMapping("/wishlist")
    public String retrieveFriendWishList(@PathVariable String name) {
        // RestTemplate을 new로 사용했을 때의 차이가 무엇일까요?
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity( getUri(name) + "/properties/wishlist", String.class).getBody();
    }

    private URI getUri(String serviceId) {
        return discoveryClient.getInstances(serviceId).get(0).getUri();
    }



}
