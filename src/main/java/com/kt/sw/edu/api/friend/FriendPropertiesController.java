package com.kt.sw.edu.api.friend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/friends/{address}/properties")
public class FriendPropertiesController {

    /**
     * URL에 있는 address 요청 주소로 하는 기능을 가지고 있음
     * 로컬에서 실행한다고 address IP로 들어가야 하고
     * VM에서 호출한다고 하면 hostname이 들어가야 하고
     * K8S에서 호출한다고 하면 Service 이름이 들어가야 함
     *
     * @param address
     * @return
     */

    private final RestTemplate restTemplate;

    public FriendPropertiesController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/number")
    public Integer retrieveFriendNumber(@PathVariable String address) {
        return restTemplate.getForEntity("http://" + address + "/properties/number", Integer.class).getBody();
    }

    @GetMapping("/wishlist")
    public String retrieveFriendWishList(@PathVariable String address) {
        // RestTemplate을 new로 사용했을 때의 차이가 무엇일까요?
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity( "http://" + address + "/properties/wishlist", String.class).getBody();
    }


}
