package team.seesaw.api.kobis;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class KobisController {

//    private final KobisService service;
//
//    @GetMapping("/list")
//    public String movieList() throws IOException {
//        int curPage = service.getCurPage();
//        while(curPage <= service.getMaxPage()){
//            log.info("현재 페이지 : {}", curPage);
//            JsonNode movieList = service.doGetMovieList();
//            for(JsonNode movie : movieList){
//                KobisMovieDto movieDto = service.parsingMovieList(movie);
//                if(movieDto == null)
//                    continue;
//                Movie savedMovie = service.saveMovie(movieDto);
//                service.saveDirector(movieDto, savedMovie);
//                service.saveGenre(movieDto, savedMovie);
//            }
//            service.setCurPage(++curPage);
//        }
//
//        return "success";
//    }
//
//    @GetMapping("/info")
//    public String movieInfo() throws IOException {
//        List<Movie> movieAll = service.getMovieAll();
//        int cnt = 1;
//        for(Movie movie : movieAll){
//            JsonNode movieInfo = service.doGetMovieInfo(movie.getId());
//            KobisMovieDto movieDto = service.parsingMovieInfo(movieInfo);
//            if(movieDto == null) continue;
//            Movie updatedMovieInfo = service.updateMovieInfo(movie, movieDto);
//            log.info("{}", updatedMovieInfo);
//            service.saveActor(movieDto, updatedMovieInfo);
//            cnt++;
//        }
//        log.info("총 처리 영화 개수 {}", cnt);
//
//        return "success";
//    }


}
