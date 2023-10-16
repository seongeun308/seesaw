package team.seesaw.api.kobis;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum KobisSearchList {
    MOVIELIST("searchMovieList.json"),
    MOVIEINFO("searchMovieInfo.json");

    private final String value;
}
