package team.seesaw.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

@Service
@Slf4j
@RequiredArgsConstructor
public class MovieApiService {

    @Value("${url}")
    private String url;
    @Value("${key}")
    private String key;
    private int curPage = 1;
    private int maxPage = 1;

    private int itemPerPage = 20;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    protected JsonNode doGetMovieList() throws IOException {
        UriComponents uri = UriComponentsBuilder.fromHttpUrl(url)
                .path("searchMovieList.json")
                .queryParam("key", key)
                .queryParam("curPage", curPage)
                .queryParam("itemPerPage", itemPerPage)
                .build(true);

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri.toUri(), String.class);
        String jsonResponse = responseEntity.getBody();
        JsonNode response = objectMapper.readTree(jsonResponse);

        JsonNode movieListResult = response.get("movieListResult");
        setMaxPage(movieListResult.get("totCnt").asInt());
        return movieListResult.get("movieList");
    }

    protected JsonNode doGetMovieInfo(Long movieCd) throws IOException {
        UriComponents uri = UriComponentsBuilder.fromHttpUrl(url)
                .path("searchMovieInfo.json")
                .queryParam("key", key)
                .queryParam("movieCd", movieCd)
                .build(true);

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri.toUri(), String.class);
        String jsonResponse = responseEntity.getBody();
        JsonNode response = objectMapper.readTree(jsonResponse);

        JsonNode movieListResult = response.get("movieInfoResult");
        return movieListResult.get("movieInfo");
    }

    protected void setMaxPage(int totCnt) {
        if (totCnt % itemPerPage == 0)
            maxPage = totCnt / itemPerPage;
        else
            maxPage = totCnt / itemPerPage + 1;
    }




}
