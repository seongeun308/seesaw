package team.seesaw.api.kobis;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class KobisService {

//    private final RestTemplate restTemplate;
//    private final MovieRepository movieRepository;
//    private final GenreRepository genreRepository;
//    private final MovieGenreRepository movieGenreRepository;
//    private final DirectorRepository directorRepository;
//    private final MovieDirectorRepository movieDirectorRepository;
//    private final ActorRepository actorRepository;
//    private final MovieActorRepository movieActorRepository;
//    private final ObjectMapper objectMapper;
//
//    @Value("${tmdb_key}")
//    private String key;
//
//    @Value("${tmdb_url}")
//    private String url;
//
//    @Value("${tmdb_curPage}")
//    @Getter @Setter
//    private int curPage;
//
//    @Value("${tmdb_itemPerPage}")
//    private int itemPerPage;
//
//    @Getter
//    private int maxPage = 50;
//
//
//    protected JsonNode doGetMovieList() throws IOException {
//        UriComponents uri = UriComponentsBuilder.fromHttpUrl(url)
//                .path("searchMovieList.json")
//                .queryParam("key", key)
//                .queryParam("curPage", curPage)
//                .queryParam("itemPerPage", itemPerPage)
//                .build(true);
//
//        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri.toUri(), String.class);
//        String jsonResponse = responseEntity.getBody();
//        JsonNode response = objectMapper.readTree(jsonResponse);
//
//        JsonNode movieListResult = response.get("movieListResult");
////        setMaxPage(movieListResult.get("totCnt").asInt());
//        return movieListResult.get("movieList");
//    }
//
//    protected JsonNode doGetMovieInfo(Long movieCd) throws IOException {
//        UriComponents uri = UriComponentsBuilder.fromHttpUrl(url)
//                .path("searchMovieInfo.json")
//                .queryParam("key", key)
//                .queryParam("movieCd", movieCd)
//                .build(true);
//
//        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri.toUri(), String.class);
//        String jsonResponse = responseEntity.getBody();
//        JsonNode response = objectMapper.readTree(jsonResponse);
//
//        JsonNode movieListResult = response.get("movieInfoResult");
//        return movieListResult.get("movieInfo");
//    }
//
//    protected KobisMovieDto parsingMovieList(JsonNode movie){
//        List<String> genreList = separateGenre(movie.get("genreAlt").asText());
//        if((genreList.contains("")|| genreList.contains("성인물(에로)") || genreList.contains("멜로/로맨스") || genreList.contains("드라마")
//                || genreList.contains("기타") || movie.get("directors").isEmpty())) {
//            return null;
//        }
//        return KobisMovieDto.builder()
//                .movieCd(movie.get("movieCd").asLong())
//                .movieNm(movie.get("movieNm").asText())
//                .movieNmEn(movie.get("movieNmEn").asText())
//                .prdtYear(movie.get("prdtYear").asText())
//                .repNationNm(movie.get("repNationNm").asText())
//                .directors(movie.get("directors"))
//                .genreAlt(movie.get("genreAlt").asText())
//                .build();
//    }
//
//    protected KobisMovieDto parsingMovieInfo(JsonNode movieInfo){
//        if (movieInfo.get("movieCd").isNull())
//            return null;
//
//        String watchGradeNm = null;
//        if(!movieInfo.get("audits").isEmpty()) {
//            JsonNode audits = movieInfo.get("audits");
//            watchGradeNm = audits.get(0).get("watchGradeNm").asText();
//        }
//
//        return KobisMovieDto.builder()
//                .movieCd(movieInfo.get("movieCd").asLong())
//                .showTm(movieInfo.get("showTm").asText())
//                .actors(movieInfo.get("actors"))
//                .watchGradeNm(watchGradeNm)
//                .build();
//    }
//
//    protected void saveActor(KobisMovieDto movieDto, Movie savedMovie) {
//        JsonNode actors = movieDto.getActors();
//        for(JsonNode actorNode : actors){
//            Actor actor = Actor.builder()
//                    .actorName(actorNode.get("peopleNm").asText())
//                    .actorNameEn(actorNode.get("peopleNmEn").asText())
//                    .castName(actorNode.get("cast").asText())
//                    .castNameEn(actorNode.get("castEn").asText())
//                    .build();
//            Actor savedActor = actorRepository.save(actor);
//            saveMovieActor(savedMovie, savedActor);
//        }
//    }
//
//    protected void saveMovieActor(Movie movie, Actor actor) {
//        MovieActor movieActor = MovieActor.builder()
//                .movie(movie)
//                .actor(actor)
//                .build();
//        movieActorRepository.save(movieActor);
//    }
//
//    protected void saveGenre(KobisMovieDto movieDto, Movie movie) {
//        List<String> genreList = separateGenre(movieDto.getGenreAlt());
//        for (String strGenre : genreList) {
//            Genre genre = genreRepository.save(Genre.builder().genre(strGenre).build());
//            saveMovieGenre(movie, genre);
//        }
//    }
//
//    protected void saveMovieGenre(Movie movie, Genre genre) {
//        MovieGenre movieGenre = MovieGenre.builder()
//                .movie(movie)
//                .genre(genre)
//                .build();
//        movieGenreRepository.save(movieGenre);
//    }
//
//    protected void saveDirector(KobisMovieDto movieDto, Movie movie) {
//        JsonNode directors = movieDto.getDirectors();
//        for (JsonNode directorNode : directors) {
//            String peopleNm = directorNode.get("peopleNm").asText();
//            Director savedDirector = directorRepository.save(Director.builder().peopleNm(peopleNm).build());
//            saveMovieDirector(movie, savedDirector);
//        }
//    }
//
//    protected void saveMovieDirector(Movie movie, Director savedDirector) {
//        MovieDirector movieDirector = MovieDirector.builder()
//                .movie(movie)
//                .director(savedDirector)
//                .build();
//        movieDirectorRepository.save(movieDirector);
//    }
//
//    public Movie saveMovie(KobisMovieDto movieDto){
//        Movie saved = movieRepository.save(movieDto.toEntity());
//        log.info("{}", saved);
//        return saved;
//    }
//
//    protected void setMaxPage(int totCnt) {
//        if (totCnt % itemPerPage == 0)
//            maxPage = totCnt / itemPerPage;
//        else
//            maxPage = totCnt / itemPerPage + 1;
//    }
//
//    protected List<String> separateGenre(String str) {
//        return Arrays.asList(str.trim().split(","));
//    }
//
//    protected List<Long> getMovieIdList() {
//        List<Movie> movieList = movieRepository.findAll();
//        List<Long> movieIdList = new ArrayList<>();
//        for(Movie movie : movieList)
//            movieIdList.add(movie.getId());
//        return movieIdList;
//    }
//
//    protected List<Movie> getMovieAll(){
//        return movieRepository.findAll();
//    }
//
//    protected Movie updateMovieInfo(Movie movie, KobisMovieDto movieDto){
//        movie.updateMovieInfo(movieDto.getShowTm(), movieDto.getWatchGradeNm());
//        return movieRepository.save(movie);
//    }
}

