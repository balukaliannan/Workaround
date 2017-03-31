

import java.time.Duration;
import java.util.*;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.*;
public class TestStreams {
	


    private int year;
    private String nationality;
    private String name;
    private String team;
    private int lengthKm;
    private Duration winningTime;
    private int stageWins;
    private int daysInYellow;
    public TestStreams(int year, String nationality, String name, String team, int lengthKm, Duration winningTime, int daysInYellow) {
        this.year = year;
        this.nationality = nationality;
        this.name = name;
        this.team = team;
        this.lengthKm = lengthKm;
        this.winningTime = winningTime;
        this.daysInYellow = daysInYellow;
    }
    public static final List<TestStreams> tdfTestStreamss = Arrays.asList(
            new TestStreams(2006, "Spain", "Óscar Pereiro", "Caisse d'Epargne–Illes Balears", 3657, Duration.parse("PT89H40M27S"), 8),
            new TestStreams(2007, "Spain", "Alberto Contador", "Discovery Channel", 3570, Duration.parse("PT91H00M26S"), 4),
            new TestStreams(2008, "Spain", "Carlos Sastre", "Team CSC", 3559, Duration.parse("PT87H52M52S"), 5),
            new TestStreams(2009, "Spain", "Alberto Contador", "Astana", 3459, Duration.parse("PT85H48M35S"), 7),
            new TestStreams(2010, "Luxembourg", "Andy Schleck", "Team Saxo Bank", 3642, Duration.parse("PT91H59M27S"), 12),
            new TestStreams(2011, "Australia", "Cadel Evans", "BMC Racing Team", 3430, Duration.parse("PT86H12M22S"), 2),
            new TestStreams(2012, "Great Britain", "Bradley Wiggins", "Team Sky", 3496, Duration.parse("PT87H34M47S"), 14),
            new TestStreams(2013, "Great Britain", "Chris Froome", "Team Sky", 3404, Duration.parse("PT83H56M20S"), 14),
            new TestStreams(2014, "Italy", "Vincenzo Nibali", "Astana", 3661, Duration.parse("PT89H59M06S"), 19),
            new TestStreams(2015, "Great Britain", "Chris Froome", "Team Sky", 3360, Duration.parse("PT84H46M14S"), 16),
            new TestStreams(2016, "Great Britain", "Chris Froome", "Team Sky", 3529, Duration.parse("PT89H04M48S"), 14 ));
    public static void main(String args[]) {
        // Filter and Map -
        List<String> TestStreamssOfToursLessThan3500km = tdfTestStreamss
                                                        .stream()
                                                        .filter(d -> d.getLengthKm() < 3500) // Separate out Tours less than 3500km
                                                        .map(TestStreams::getName) // Get names of TestStreamss
                                                        .collect(toList()); // Return a list
        
        // TestStreamss of Tours Less than 3500km - [Alberto Contador, Cadel Evans, Bradley Wiggins, Chris Froome, Chris Froome]        
        System.out.println("TestStreamss of Tours Less than 3500km - " + TestStreamssOfToursLessThan3500km);
        List<String> TestStreamssOfToursGreaterThan3500km = tdfTestStreamss
                                                         .stream()
                                                         .filter(d -> d.getLengthKm() >= 3500)
                                                         .map(TestStreams::getName)
                                                         .collect(toList());
        
        // TestStreamss of Tours Greater than 3500km - [Óscar Pereiro, Alberto Contador, Carlos Sastre, Andy Schleck, Vincenzo Nibali, Chris Froome]
        System.out.println("TestStreamss of Tours Greater than 3500km - " + TestStreamssOfToursGreaterThan3500km);
        // limit - 
        List<TestStreams> TestStreamsObjectsOfToursLessThan3500kmLimit2 = tdfTestStreamss
                                                                  .stream()
                                                                  .filter(d -> d.getLengthKm() < 3500)
                                                                  .limit(2)
                                                                  .collect(toList());
        
        
        // TestStreamsObjectsOfToursLessThan3500kmLimit2 [Alberto Contador, Cadel Evans]
        System.out.println("TestStreamsObjectsOfToursLessThan3500kmLimit2 " + TestStreamsObjectsOfToursLessThan3500kmLimit2);
        List<String> firstTwoTestStreamssOfToursLessThan3500km = tdfTestStreamss
                                                              .stream()
                                                              .filter(d -> d.getLengthKm() < 3500)
                                                              .map(TestStreams::getName)
                                                              .limit(2)
                                                              .collect(toList());
        
        
        // firstTwoTestStreamssOfToursLessThan3500km - [Alberto Contador, Cadel Evans]
        System.out.println("firstTwoTestStreamssOfToursLessThan3500km - " + firstTwoTestStreamssOfToursLessThan3500km);
        // filter by distinct
        List<String> distinctTDFTestStreamss = tdfTestStreamss
                                             .stream()
                                             .map(TestStreams::getName)
                                             .distinct()
                                             .collect(toList());
        System.out.println("distinctTDFTestStreamss - " + distinctTDFTestStreamss);
        long numberOfDistinceTestStreamss = tdfTestStreamss
                                          .stream()
                                          .map(TestStreams::getName)
                                          .distinct()
                                          .count();
        
        // numberOfDistinceTestStreamss - 8
        System.out.println("numberOfDistinceTestStreamss - " + numberOfDistinceTestStreamss);
        // skip records
        List<TestStreams> skipEveryOtherTDFTestStreams = tdfTestStreamss
                                                 .stream()
                                                 .skip(2)
                                                 .collect(toList());
        
        
        // skipEveryOtherTDFTestStreams - [Carlos Sastre, Alberto Contador, Andy Schleck, Cadel Evans, Bradley Wiggins, Chris Froome, Vincenzo Nibali, Chris Froome, Chris Froome]
        System.out.println("skipEveryOtherTDFTestStreams - " + skipEveryOtherTDFTestStreams);
        List<String> mapTestStreamsYearNamesToList = tdfTestStreamss
                                                   .stream()
                                                   .map(w -> w.getYear() + " - " + w.getName())
                                                   .collect(toList());
        
        
        // mapTestStreamsYearNamesToList [2006 - Óscar Pereiro, 2007 - Alberto Contador, 2008 - Carlos Sastre, 2009 - Alberto Contador, 2010 - Andy Schleck, 2011 - Cadel Evans, 2012 - Bradley Wiggins, 2013 - Chris Froome, 2014 - Vincenzo Nibali, 2015 - Chris Froome, 2016 - Chris Froome]
        System.out.println("mapTestStreamsYearNamesToList " + mapTestStreamsYearNamesToList);
        List<Integer> mapTestStreamsNameLengthToList = tdfTestStreamss
                                                    .stream()
                                                    .map(TestStreams::getName)
                                                    .map(String::length)
                                                    .collect(toList());
        
        
        // mapTestStreamsNameLengthToList [13, 16, 13, 16, 12, 11, 15, 12, 15, 12, 12]
        System.out.println("mapTestStreamsNameLengthToList " + mapTestStreamsNameLengthToList);
        // matching - allMatch, noneMatch
        Optional<TestStreams> TestStreams2012 = tdfTestStreamss.stream().filter(w -> w.getName().contains("Wiggins")).findAny();
        // TestStreams2012 - Bradley Wiggins
        System.out.println("TestStreams2012 - " + TestStreams2012.get());
        Optional<Integer> TestStreamsYear2014 = tdfTestStreamss.stream().map(TestStreams::getYear).filter(x -> x == 2014).findFirst();
        // TestStreamsYear2014 - 2014
        System.out.println("TestStreamsYear2014 - " + TestStreamsYear2014.get());
        // reducing - 0 --> initial value
        int totalDistance = tdfTestStreamss.stream().map(TestStreams::getLengthKm).reduce(0, Integer::sum);
        // totalDistance - 38767
        System.out.println("totalDistance - " + totalDistance);
        Optional<Integer> shortestYear = tdfTestStreamss.stream().map(TestStreams::getLengthKm).reduce(Integer::min);
        // shortestYear - 3360
        System.out.println("shortestYear - " + shortestYear.get());
        Optional<Integer> longestYear = tdfTestStreamss.stream().map(TestStreams::getLengthKm).reduce(Integer::max);
        // longestYear - 3661
        System.out.println("longestYear - " + longestYear.get());
        Optional<TestStreams> fastestTestStreams = tdfTestStreamss.stream().min(Comparator.comparingDouble(TestStreams::getAveSpeed));
        System.out.println("fastestTDF - " + fastestTestStreams.get()); 
        // shorthand
        OptionalDouble fastestTDF = tdfTestStreamss.stream().mapToDouble(TestStreams::getAveSpeed).min();
        // fastestTDF - 39.0
        System.out.println("fastestTDF - " + fastestTDF.getAsDouble());
        // groupingby - make a map whose keys are names
        Map<String, List<TestStreams>> namesVsTestStreams = tdfTestStreamss.stream().collect(groupingBy(TestStreams::getName));
        // namesVsTestStreams - {Bradley Wiggins=[Bradley Wiggins], Carlos Sastre=[Carlos Sastre], Cadel Evans=[Cadel Evans], Óscar Pereiro=[Óscar Pereiro], Chris Froome=[Chris Froome, Chris Froome, Chris Froome], Andy Schleck=[Andy Schleck], Alberto Contador=[Alberto Contador, Alberto Contador], Vincenzo Nibali=[Vincenzo Nibali]}
        System.out.println("namesVsTestStreams - " + namesVsTestStreams);
        // join strings
        String allTDFTestStreamssTeamsCSV = tdfTestStreamss.stream().map(TestStreams::getTeam).collect(joining(", "));
        // allTDFTestStreamssTeams Caisse d'Epargne–Illes Balears, Discovery Channel, Team CSC, Astana, Team Saxo Bank, BMC Racing Team, Team Sky, Team Sky, Astana, Team Sky, Team Sky
        System.out.println("allTDFTestStreamssTeams " + allTDFTestStreamssTeamsCSV);
        // grouping
        Map<String, List<TestStreams>> TestStreamssByNationality = tdfTestStreamss.stream().collect(groupingBy(TestStreams::getNationality));
        // TestStreamssByNationality - {Great Britain=[Bradley Wiggins, Chris Froome, Chris Froome, Chris Froome], Luxembourg=[Andy Schleck], Italy=[Vincenzo Nibali], Australia=[Cadel Evans], Spain=[Óscar Pereiro, Alberto Contador, Carlos Sastre, Alberto Contador]}
        System.out.println("TestStreamssByNationality - " + TestStreamssByNationality);
        Map<String, Long> winsByNationalityCounting = tdfTestStreamss.stream().collect(groupingBy(TestStreams::getNationality, counting()));
        // winsByNationalityCounting - {Great Britain=4, Luxembourg=1, Italy=1, Australia=1, Spain=4}
        System.out.println("winsByNationalityCounting - " + winsByNationalityCounting);
    }
    public double getAveSpeed() { 
        return (getLengthKm() / (getWinningTime().getSeconds() / 3600) );
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTeam() {
        return team;
    }
    public void setTeam(String team) {
        this.team = team;
    }
    public int getLengthKm() {
        return lengthKm;
    }
    public void setLengthKm(int lengthKm) {
        this.lengthKm = lengthKm;
    }
    public Duration getWinningTime() {
        return winningTime;
    }
    public void setWinningTime(Duration winningTime) {
        this.winningTime = winningTime;
    }
    public int getStageWins() {
        return stageWins;
    }
    public void setStageWins(int stageWins) {
        this.stageWins = stageWins;
    }
    public int getDaysInYellow() {
        return daysInYellow;
    }
    public void setDaysInYellow(int daysInYellow) {
        this.daysInYellow = daysInYellow;
    }
    @Override
    public String toString() {
        return name;
    }    
}

