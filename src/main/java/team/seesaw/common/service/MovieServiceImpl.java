package team.seesaw.common.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.seesaw.common.entity.*;
import team.seesaw.common.repository.*;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.Map.Entry;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl {

    private final MovieRepository movieRepository;
    private final DirectorRepository directorRepository;
    private final ActorRepository actorRepository;
    private final GenreRepository genreRepository;
    private final MovieDirectorRepository movieDirectorRepository;
    private final MovieActorRepository movieActorRepository;
    private final MovieGenreRepository movieGenreRepository;

    /**
     * 영화를 page 마다 cnt씩 반환하는 페이징 함수
     * @param page
     * @param cnt
     * @return List<Movie>
     */
    public List<Movie> pagingMovieList(int page, int cnt){
        List<Movie> movies = movieRepository.findAll();
        int startIdx = page * cnt - cnt;
        int endIdx = page * cnt - 1;

        if(endIdx > movies.size()) endIdx = movies.size();

        List<Movie> pagedMovies = new ArrayList<>();
        for(int i = startIdx; i <= endIdx; i++){
            pagedMovies.add(movies.get(i));
        }
        return pagedMovies;
    }

    @PostConstruct
    public void testData(){
        for(int i = 0; i < 20; i++){
            Movie movie = Movie.builder()
                    .title("킬링 로맨스")
                    .country("한국")
                    .poster("https://an2-img.amz.wtchn.net/image/v2/jjIlVed_saBaZ0JegBu3ow.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1SZk5Ea3dlRGN3TUhFNE1DSmRMQ0p3SWpvaUwzWXlMM04wYjNKbEwybHRZV2RsTHpFMk56azVNalEwTVRJME5USTFOakUxTXpZaWZRLkJPMzFzTjFaQTE5bmxwZmszMXZWbFQ4a3RFTm1VQUhxbnpnTDhrV0lKVmc".getBytes())
                    .releaseDate("2021")
                    .runningTime(106)
                    .ageRate("15세")
                    .build();
            Movie savedMovie = movieRepository.save(movie);

            Director director = Director.builder().name("이원석").build();
            Director savedDirector = directorRepository.save(director);

            MovieDirector movieDirector = MovieDirector.builder().movie(savedMovie).director(savedDirector).build();
            movieDirectorRepository.save(movieDirector);

            Map<String, String> actors = new HashMap<>();
            actors.put("이하늬", "여래");
            actors.put("이선균", "조나단");
            actors.put("공명", "범우");
            actors.put("배유람", "이영찬");
            actors.put("앤드류 비숍", "밥");
            actors.put("심달기", "보리 / 타조목소리");
            actors.put("오정세", "찜징방 사장");
            actors.put("최덕문", "최대표");
            actors.put("백현미", "수잔A");
            actors.put("백현숙", "수잔B");
            actors.put("신민재", "");
            actors.put("임정은", "");
            actors.put("김상욱", "범우아빠");
            actors.put("조지안", "재수학원 학생1");

            for(Entry<String, String> act : actors.entrySet()) {
                Actor actor = Actor.builder().actorNm(act.getKey()).castNm(act.getValue()).build();
                Actor savedActor = actorRepository.save(actor);
                movieActorRepository.save(MovieActor.builder().movie(savedMovie).actor(savedActor).build());
            }

            Genre genre1 = Genre.builder().genre("코미디").build();
            Genre genre2 = Genre.builder().genre("음악").build();
            Genre genre3 = Genre.builder().genre("로맨스").build();
            Optional<Genre> optionalGenre1 = genreRepository.findByGenre(genre1.getGenre());
            Optional<Genre> optionalGenre2 = genreRepository.findByGenre(genre2.getGenre());
            Optional<Genre> optionalGenre3 = genreRepository.findByGenre(genre3.getGenre());
            optionalGenre1.ifPresentOrElse(
                    genre -> movieGenreRepository.save(MovieGenre.builder().movie(savedMovie).genre(genre).build()),
                    () -> movieGenreRepository.save(MovieGenre.builder().movie(savedMovie).genre(genreRepository.save(genre1)).build())
            );
            optionalGenre2.ifPresentOrElse(
                    genre -> movieGenreRepository.save(MovieGenre.builder().movie(savedMovie).genre(genre).build()),
                    () -> movieGenreRepository.save(MovieGenre.builder().movie(savedMovie).genre(genreRepository.save(genre2)).build())
            );
            optionalGenre3.ifPresentOrElse(
                    genre -> movieGenreRepository.save(MovieGenre.builder().movie(savedMovie).genre(genre).build()),
                    () -> movieGenreRepository.save(MovieGenre.builder().movie(savedMovie).genre(genreRepository.save(genre3)).build())
            );
        }
    }
}
