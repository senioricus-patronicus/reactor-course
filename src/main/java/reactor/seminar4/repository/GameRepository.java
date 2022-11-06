package reactor.seminar4.repository;

import org.apache.commons.lang3.RandomUtils;
import reactor.core.publisher.Flux;
import reactor.seminar4.model.*;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static reactor.seminar4.model.Names.*;

public class GameRepository {
    private static volatile GameRepository INSTANCE;

    private List<Game> games;

    private GameRepository() {
        initialize();
    }

    public static synchronized GameRepository getInstance() {
        if (Objects.isNull(INSTANCE)) {
            INSTANCE = new GameRepository();
        }

        return INSTANCE;
    }

    public Flux<Game> findAll() {
        return Flux.fromIterable(games);
    }

    private void initialize() {
        Game game1 = Game.builder()
                .white(new Participant(HIKARU.getName(), MatchResult.DRAW))
                .black(new Participant(MAGNUS_CARLSEN.getName(), MatchResult.DRAW))
                .moves(63)
                .settings(Settings.builder()
                        .mode(Mode.STANDARD)
                        .timeControl(TimeControl.BLITZ_3_MIN)
                        .build())
                .accuracies(AccuracyInfo.builder()
                        .whiteAccuracy(87.1)
                        .blackAccuracy(86.2)
                        .build())
                .victoryType(VictoryType.NONE)
                .startedAt(ZonedDateTime.now().minus(5, ChronoUnit.DAYS))
                .finishedAt(ZonedDateTime.now().minus(5, ChronoUnit.DAYS)
                        .plus(5, ChronoUnit.MINUTES).plus(RandomUtils.nextInt(1, 59), ChronoUnit.SECONDS))
                .build();

        Game game2 = Game.builder()
                .white(new Participant(BIG_FISH_1995.getName(), MatchResult.LOSE))
                .black(new Participant(HIKARU.getName(), MatchResult.WIN))
                .moves(42)
                .settings(Settings.builder()
                        .mode(Mode.STANDARD)
                        .timeControl(TimeControl.BLITZ_3_MIN)
                        .build())
                .accuracies(AccuracyInfo.builder()
                        .whiteAccuracy(82.6)
                        .blackAccuracy(90.3)
                        .build())
                .victoryType(VictoryType.RESIGNATION)
                .startedAt(ZonedDateTime.now().minus(4, ChronoUnit.DAYS))
                .finishedAt(ZonedDateTime.now().minus(4, ChronoUnit.DAYS)
                        .plus(4, ChronoUnit.MINUTES).plus(RandomUtils.nextInt(1, 59), ChronoUnit.SECONDS))
                .build();

        Game game3 = Game.builder()
                .white(new Participant(DANIEL_NARODITSKY.getName(), MatchResult.DRAW))
                .black(new Participant(HIKARU.getName(), MatchResult.DRAW))
                .moves(55)
                .settings(Settings.builder()
                        .mode(Mode.STANDARD)
                        .timeControl(TimeControl.BLITZ_5_MIN)
                        .build())
                .accuracies(AccuracyInfo.builder()
                        .whiteAccuracy(83.7)
                        .blackAccuracy(82.3)
                        .build())
                .victoryType(VictoryType.NONE)
                .startedAt(ZonedDateTime.now().minus(3, ChronoUnit.DAYS))
                .finishedAt(ZonedDateTime.now().minus(3, ChronoUnit.DAYS)
                        .plus(7, ChronoUnit.MINUTES).plus(RandomUtils.nextInt(1, 59), ChronoUnit.SECONDS))
                .build();

        Game game4 = Game.builder()
                .white(new Participant(DANIEL_NARODITSKY.getName(), MatchResult.DRAW))
                .black(new Participant(BIG_FISH_1995.getName(), MatchResult.DRAW))
                .moves(37)
                .settings(Settings.builder()
                        .mode(Mode.STANDARD)
                        .timeControl(TimeControl.BLITZ_5_MIN)
                        .build())
                .accuracies(AccuracyInfo.builder()
                        .whiteAccuracy(81.7)
                        .blackAccuracy(84.3)
                        .build())
                .victoryType(VictoryType.NONE)
                .startedAt(ZonedDateTime.now().minus(6, ChronoUnit.DAYS))
                .finishedAt(ZonedDateTime.now().minus(6, ChronoUnit.DAYS)
                        .plus(5, ChronoUnit.MINUTES).plus(RandomUtils.nextInt(1, 59), ChronoUnit.SECONDS))
                .build();

        Game game5 = Game.builder()
                .white(new Participant(FIROUZJA_2003.getName(), MatchResult.LOSE))
                .black(new Participant(HIKARU.getName(), MatchResult.LOSE))
                .moves(91)
                .settings(Settings.builder()
                        .mode(Mode.STANDARD)
                        .timeControl(TimeControl.BLITZ_5_MIN)
                        .build())
                .accuracies(AccuracyInfo.builder()
                        .whiteAccuracy(87.7)
                        .blackAccuracy(81.3)
                        .build())
                .victoryType(VictoryType.TIMEOUT)
                .startedAt(ZonedDateTime.now().minus(5, ChronoUnit.DAYS).minus(29, ChronoUnit.MINUTES))
                .finishedAt(ZonedDateTime.now().minus(5, ChronoUnit.DAYS)
                        .minus(20, ChronoUnit.MINUTES).plus(RandomUtils.nextInt(1, 59), ChronoUnit.SECONDS))
                .build();

        Game game6 = Game.builder()
                .white(new Participant(MAGNUS_CARLSEN.getName(), MatchResult.WIN))
                .black(new Participant(FIROUZJA_2003.getName(), MatchResult.LOSE))
                .moves(62)
                .settings(Settings.builder()
                        .mode(Mode.STANDARD)
                        .timeControl(TimeControl.BLITZ_5_MIN)
                        .build())
                .accuracies(AccuracyInfo.builder()
                        .whiteAccuracy(89.7)
                        .blackAccuracy(84.3)
                        .build())
                .victoryType(VictoryType.CHECKMATE)
                .startedAt(ZonedDateTime.now().minus(2, ChronoUnit.DAYS).minus(71, ChronoUnit.MINUTES))
                .finishedAt(ZonedDateTime.now().minus(2, ChronoUnit.DAYS)
                        .minus(62, ChronoUnit.MINUTES).plus(RandomUtils.nextInt(1, 59), ChronoUnit.SECONDS))
                .build();

        Game game7 = Game.builder()
                .white(new Participant(ANISH_GIRI.getName(), MatchResult.DRAW))
                .black(new Participant(MAGNUS_CARLSEN.getName(), MatchResult.DRAW))
                .moves(77)
                .settings(Settings.builder()
                        .mode(Mode.STANDARD)
                        .timeControl(TimeControl.BLITZ_5_MIN)
                        .build())
                .accuracies(AccuracyInfo.builder()
                        .whiteAccuracy(85)
                        .blackAccuracy(85.2)
                        .build())
                .victoryType(VictoryType.NONE)
                .startedAt(ZonedDateTime.now().minus(2, ChronoUnit.DAYS).minus(61, ChronoUnit.MINUTES))
                .finishedAt(ZonedDateTime.now().minus(2, ChronoUnit.DAYS)
                        .minus(55, ChronoUnit.MINUTES).plus(RandomUtils.nextInt(1, 59), ChronoUnit.SECONDS))
                .build();

        Game game8 = Game.builder()
                .white(new Participant(LACHESIS_Q.getName(), MatchResult.WIN))
                .black(new Participant(ANISH_GIRI.getName(), MatchResult.LOSE))
                .moves(44)
                .settings(Settings.builder()
                        .mode(Mode.STANDARD)
                        .timeControl(TimeControl.BLITZ_3_MIN)
                        .build())
                .accuracies(AccuracyInfo.builder()
                        .whiteAccuracy(81.3)
                        .blackAccuracy(89.2)
                        .build())
                .victoryType(VictoryType.RESIGNATION)
                .startedAt(ZonedDateTime.now().minus(2, ChronoUnit.DAYS).minus(54, ChronoUnit.MINUTES))
                .finishedAt(ZonedDateTime.now().minus(2, ChronoUnit.DAYS)
                        .minus(50, ChronoUnit.MINUTES).plus(RandomUtils.nextInt(1, 59), ChronoUnit.SECONDS))
                .build();

        Game game9 = Game.builder()
                .white(new Participant(DANIEL_NARODITSKY.getName(), MatchResult.DRAW))
                .black(new Participant(LACHESIS_Q.getName(), MatchResult.DRAW))
                .moves(57)
                .settings(Settings.builder()
                        .mode(Mode.STANDARD)
                        .timeControl(TimeControl.BLITZ_3_MIN)
                        .build())
                .accuracies(AccuracyInfo.builder()
                        .whiteAccuracy(84.3)
                        .blackAccuracy(82.2)
                        .build())
                .victoryType(VictoryType.NONE)
                .startedAt(ZonedDateTime.now().minus(2, ChronoUnit.DAYS).minus(49, ChronoUnit.MINUTES))
                .finishedAt(ZonedDateTime.now().minus(2, ChronoUnit.DAYS)
                        .minus(44, ChronoUnit.MINUTES).plus(RandomUtils.nextInt(1, 59), ChronoUnit.SECONDS))
                .build();

        Game game10 = Game.builder()
                .white(new Participant(FIROUZJA_2003.getName(), MatchResult.DRAW))
                .black(new Participant(DANIEL_NARODITSKY.getName(), MatchResult.DRAW))
                .moves(36)
                .settings(Settings.builder()
                        .mode(Mode.STANDARD)
                        .timeControl(TimeControl.BLITZ_3_MIN)
                        .build())
                .accuracies(AccuracyInfo.builder()
                        .whiteAccuracy(86.3)
                        .blackAccuracy(85.8)
                        .build())
                .victoryType(VictoryType.NONE)
                .startedAt(ZonedDateTime.now().minus(3, ChronoUnit.DAYS).minus(105, ChronoUnit.MINUTES))
                .finishedAt(ZonedDateTime.now().minus(3, ChronoUnit.DAYS)
                        .minus(100, ChronoUnit.MINUTES).plus(RandomUtils.nextInt(1, 59), ChronoUnit.SECONDS))
                .build();

        Game game11 = Game.builder()
                .white(new Participant(HIKARU.getName(), MatchResult.WIN))
                .black(new Participant(LACHESIS_Q.getName(), MatchResult.LOSE))
                .moves(73)
                .settings(Settings.builder()
                        .mode(Mode.TOURNAMENT)
                        .timeControl(TimeControl.BLITZ_5_MIN)
                        .build())
                .accuracies(AccuracyInfo.builder()
                        .whiteAccuracy(84.3)
                        .blackAccuracy(82.8)
                        .build())
                .victoryType(VictoryType.RESIGNATION)
                .startedAt(ZonedDateTime.now().minus(17, ChronoUnit.DAYS)
                        .minus(217, ChronoUnit.MINUTES))
                .finishedAt(ZonedDateTime.now().minus(17, ChronoUnit.DAYS)
                        .minus(208, ChronoUnit.MINUTES).plus(RandomUtils.nextInt(1, 59), ChronoUnit.SECONDS))
                .build();

        Game game12 = Game.builder()
                .white(new Participant(MAGNUS_CARLSEN.getName(), MatchResult.WIN))
                .black(new Participant(HIKARU.getName(), MatchResult.LOSE))
                .moves(85)
                .settings(Settings.builder()
                        .mode(Mode.TOURNAMENT)
                        .timeControl(TimeControl.BLITZ_5_MIN)
                        .build())
                .accuracies(AccuracyInfo.builder()
                        .whiteAccuracy(88.3)
                        .blackAccuracy(83.9)
                        .build())
                .victoryType(VictoryType.RESIGNATION)
                .startedAt(ZonedDateTime.now().minus(16, ChronoUnit.DAYS)
                        .minus(317, ChronoUnit.MINUTES))
                .finishedAt(ZonedDateTime.now().minus(16, ChronoUnit.DAYS)
                        .minus(307, ChronoUnit.MINUTES).plus(RandomUtils.nextInt(1, 59), ChronoUnit.SECONDS))
                .build();

        Game game13 = Game.builder()
                .white(new Participant(LACHESIS_Q.getName(), MatchResult.LOSE))
                .black(new Participant(BIG_FISH_1995.getName(), MatchResult.WIN))
                .moves(61)
                .settings(Settings.builder()
                        .mode(Mode.TOURNAMENT)
                        .timeControl(TimeControl.BLITZ_5_MIN)
                        .build())
                .accuracies(AccuracyInfo.builder()
                        .whiteAccuracy(84.3)
                        .blackAccuracy(85.9)
                        .build())
                .victoryType(VictoryType.RESIGNATION)
                .startedAt(ZonedDateTime.now().minus(16, ChronoUnit.DAYS)
                        .minus(317, ChronoUnit.MINUTES))
                .finishedAt(ZonedDateTime.now().minus(16, ChronoUnit.DAYS)
                        .minus(308, ChronoUnit.MINUTES)
                        .plus(RandomUtils.nextInt(1, 59), ChronoUnit.SECONDS))
                .build();

        Game game14 = Game.builder()
                .white(new Participant(LACHESIS_Q.getName(), MatchResult.WIN))
                .black(new Participant(MAGNUS_CARLSEN.getName(), MatchResult.LOSE))
                .moves(59)
                .settings(Settings.builder()
                        .mode(Mode.TOURNAMENT)
                        .timeControl(TimeControl.BLITZ_5_MIN)
                        .build())
                .accuracies(AccuracyInfo.builder()
                        .whiteAccuracy(87.3)
                        .blackAccuracy(81.9)
                        .build())
                .victoryType(VictoryType.RESIGNATION)
                .startedAt(ZonedDateTime.now().minus(15, ChronoUnit.DAYS)
                        .minus(109, ChronoUnit.MINUTES))
                .finishedAt(ZonedDateTime.now().minus(15, ChronoUnit.DAYS)
                        .minus(100, ChronoUnit.MINUTES)
                        .plus(RandomUtils.nextInt(1, 59), ChronoUnit.SECONDS))
                .build();

        Game game15 = Game.builder()
                .white(new Participant(HIKARU.getName(), MatchResult.WIN))
                .black(new Participant(BIG_FISH_1995.getName(), MatchResult.LOSE))
                .moves(43)
                .settings(Settings.builder()
                        .mode(Mode.TOURNAMENT)
                        .timeControl(TimeControl.BLITZ_5_MIN)
                        .build())
                .accuracies(AccuracyInfo.builder()
                        .whiteAccuracy(89.1)
                        .blackAccuracy(80.1)
                        .build())
                .victoryType(VictoryType.RESIGNATION)
                .startedAt(ZonedDateTime.now().minus(15, ChronoUnit.DAYS)
                        .minus(109, ChronoUnit.MINUTES))
                .finishedAt(ZonedDateTime.now().minus(15, ChronoUnit.DAYS)
                        .minus(102, ChronoUnit.MINUTES)
                        .plus(RandomUtils.nextInt(1, 59), ChronoUnit.SECONDS))
                .build();

        Game game16 = Game.builder()
                .white(new Participant(HIKARU.getName(), MatchResult.WIN))
                .black(new Participant(MAGNUS_CARLSEN.getName(), MatchResult.LOSE))
                .moves(69)
                .settings(Settings.builder()
                        .mode(Mode.TOURNAMENT)
                        .timeControl(TimeControl.BLITZ_5_MIN)
                        .build())
                .accuracies(AccuracyInfo.builder()
                        .whiteAccuracy(87.1)
                        .blackAccuracy(86.1)
                        .build())
                .victoryType(VictoryType.RESIGNATION)
                .startedAt(ZonedDateTime.now().minus(14, ChronoUnit.DAYS)
                        .minus(109, ChronoUnit.MINUTES))
                .finishedAt(ZonedDateTime.now().minus(14, ChronoUnit.DAYS)
                        .minus(102, ChronoUnit.MINUTES)
                        .plus(RandomUtils.nextInt(1, 59), ChronoUnit.SECONDS))
                .build();

        Game game17 = Game.builder()
                .white(new Participant(BIG_FISH_1995.getName(), MatchResult.DRAW))
                .black(new Participant(LACHESIS_Q.getName(), MatchResult.DRAW))
                .moves(19)
                .settings(Settings.builder()
                        .mode(Mode.TOURNAMENT)
                        .timeControl(TimeControl.BLITZ_5_MIN)
                        .build())
                .accuracies(AccuracyInfo.builder()
                        .whiteAccuracy(87.1)
                        .blackAccuracy(86.1)
                        .build())
                .victoryType(VictoryType.NONE)
                .startedAt(ZonedDateTime.now().minus(14, ChronoUnit.DAYS)
                        .minus(108, ChronoUnit.MINUTES))
                .finishedAt(ZonedDateTime.now().minus(14, ChronoUnit.DAYS)
                        .minus(101, ChronoUnit.MINUTES)
                        .plus(RandomUtils.nextInt(1, 59), ChronoUnit.SECONDS))
                .build();

        Game game18 = Game.builder()
                .white(new Participant(MAGNUS_CARLSEN.getName(), MatchResult.DRAW))
                .black(new Participant(LACHESIS_Q.getName(), MatchResult.DRAW))
                .moves(19)
                .settings(Settings.builder()
                        .mode(Mode.TOURNAMENT)
                        .timeControl(TimeControl.BLITZ_5_MIN)
                        .build())
                .accuracies(AccuracyInfo.builder()
                        .whiteAccuracy(87.1)
                        .blackAccuracy(86.1)
                        .build())
                .victoryType(VictoryType.NONE)
                .startedAt(ZonedDateTime.now().minus(13, ChronoUnit.DAYS)
                        .minus(108, ChronoUnit.MINUTES))
                .finishedAt(ZonedDateTime.now().minus(13, ChronoUnit.DAYS)
                        .minus(101, ChronoUnit.MINUTES)
                        .plus(RandomUtils.nextInt(1, 59), ChronoUnit.SECONDS))
                .build();

        Game game19 = Game.builder()
                .white(new Participant(BIG_FISH_1995.getName(), MatchResult.DRAW))
                .black(new Participant(HIKARU.getName(), MatchResult.DRAW))
                .moves(57)
                .settings(Settings.builder()
                        .mode(Mode.TOURNAMENT)
                        .timeControl(TimeControl.BLITZ_5_MIN)
                        .build())
                .accuracies(AccuracyInfo.builder()
                        .whiteAccuracy(83.1)
                        .blackAccuracy(84.2)
                        .build())
                .victoryType(VictoryType.NONE)
                .startedAt(ZonedDateTime.now().minus(13, ChronoUnit.DAYS)
                        .minus(108, ChronoUnit.MINUTES))
                .finishedAt(ZonedDateTime.now().minus(13, ChronoUnit.DAYS)
                        .minus(101, ChronoUnit.MINUTES)
                        .plus(RandomUtils.nextInt(1, 59), ChronoUnit.SECONDS))
                .build();

        Game game20 = Game.builder()
                .white(new Participant(LACHESIS_Q.getName(), MatchResult.DRAW))
                .black(new Participant(HIKARU.getName(), MatchResult.DRAW))
                .moves(62)
                .settings(Settings.builder()
                        .mode(Mode.TOURNAMENT)
                        .timeControl(TimeControl.BLITZ_5_MIN)
                        .build())
                .accuracies(AccuracyInfo.builder()
                        .whiteAccuracy(83.1)
                        .blackAccuracy(84.2)
                        .build())
                .victoryType(VictoryType.NONE)
                .startedAt(ZonedDateTime.now().minus(12, ChronoUnit.DAYS)
                        .minus(111, ChronoUnit.MINUTES))
                .finishedAt(ZonedDateTime.now().minus(12, ChronoUnit.DAYS)
                        .minus(102, ChronoUnit.MINUTES)
                        .plus(RandomUtils.nextInt(1, 59), ChronoUnit.SECONDS))
                .build();

        Game game21 = Game.builder()
                .white(new Participant(BIG_FISH_1995.getName(), MatchResult.DRAW))
                .black(new Participant(MAGNUS_CARLSEN.getName(), MatchResult.DRAW))
                .moves(62)
                .settings(Settings.builder()
                        .mode(Mode.TOURNAMENT)
                        .timeControl(TimeControl.BLITZ_5_MIN)
                        .build())
                .accuracies(AccuracyInfo.builder()
                        .whiteAccuracy(85.1)
                        .blackAccuracy(85.2)
                        .build())
                .victoryType(VictoryType.NONE)
                .startedAt(ZonedDateTime.now().minus(12, ChronoUnit.DAYS)
                        .minus(110, ChronoUnit.MINUTES))
                .finishedAt(ZonedDateTime.now().minus(12, ChronoUnit.DAYS)
                        .minus(101, ChronoUnit.MINUTES)
                        .plus(RandomUtils.nextInt(1, 59), ChronoUnit.SECONDS))
                .build();

        Game game22 = Game.builder()
                .white(new Participant(MAGNUS_CARLSEN.getName(), MatchResult.WIN))
                .black(new Participant(BIG_FISH_1995.getName(), MatchResult.LOSE))
                .moves(62)
                .settings(Settings.builder()
                        .mode(Mode.TOURNAMENT)
                        .timeControl(TimeControl.BLITZ_5_MIN)
                        .build())
                .accuracies(AccuracyInfo.builder()
                        .whiteAccuracy(85.1)
                        .blackAccuracy(85.2)
                        .build())
                .victoryType(VictoryType.RESIGNATION)
                .startedAt(ZonedDateTime.now().minus(11, ChronoUnit.DAYS)
                        .minus(112, ChronoUnit.MINUTES))
                .finishedAt(ZonedDateTime.now().minus(11, ChronoUnit.DAYS)
                        .minus(102, ChronoUnit.MINUTES)
                        .plus(RandomUtils.nextInt(1, 59), ChronoUnit.SECONDS))
                .build();


        games = Stream.of(game1, game2, game3, game4, game5, game6, game7, game8, game9, game10,
                        game11, game12, game13, game14, game15, game16, game17, game18, game19, game20, game21, game22)
                .toList();
    }
}
