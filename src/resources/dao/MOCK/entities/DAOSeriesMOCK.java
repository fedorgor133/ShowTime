package resources.dao.MOCK.entities;

import model.Series;
import resources.dao.entities.DAOSeries;

import java.util.*;

public class DAOSeriesMOCK implements DAOSeries {

    private Map<String, Series> series = new HashMap<>();

    public DAOSeriesMOCK(){
        addSeries("Stranger Things","When a young boy vanishes, a small town uncovers a mystery involving secret experiments, terrifying supernatural forces and one strange little girl.", "URL_strangerthings", 2016, "English", 10);
        addSeries("Game of Thrones", "A series about the fight for the Iron Throne", "URL_got", 2011, "English", 9);
        addSeries("The Crown", "The reign of Queen Elizabeth II", "URL_crown", 2016, "English", 9);
        addSeries("The Mandalorian", "A lone gunfighter makes his way through the galaxy", "URL_mandalorian", 2019, "English", 9);
        addSeries("The Witcher", "The tale of Geralt of Rivia, a solitary monster hunter", "URL_witcher", 2019, "English", 9);
        addSeries("Breaking Bad", "A high school teacher turned methamphetamine manufacturer", "URL_breakingbad", 2008, "English", 9);
        addSeries("The Office", "A mockumentary on a group of office workers", "URL_office", 2005, "English", 9);
        addSeries("Friends", "Follows the lives of six friends living in Manhattan", "URL_friends", 1994, "English", 9);
        addSeries("The Big Bang Theory", "A group of nerds and their interactions with a waitress", "URL_bigbang", 2007, "English", 9);
        addSeries("Chernobyl", "A series about the Chernobyl nuclear disaster", "URL_chernobyl", 2019, "English", 9);
        addSeries("Peaky Blinders", "A gangster family in Birmingham, England, in 1919", "URL_peaky", 2013, "English", 9);
  }

    private void addSeries(String seriesName, String description, String url, int releaseYear, String language, int duration) {
        series.put(seriesName, new Series(seriesName, description, url, releaseYear, language, duration));
    }

    @Override
    public Optional<Series> getById(String[] id) throws Exception {
        return Optional.ofNullable(series.get(Objects.requireNonNull(id[0], "Series name cannot be null")));
    }

    @Override
    public List<Series> getAll() throws Exception {
        return new ArrayList<>(series.values());
    }

    @Override
    public boolean add(Series series) throws Exception {
        if (getById(new String[]{series.getTitle()}).isPresent()) {
            return false;
        }
        this.series.put(series.getTitle(), series);
        return true;
    }

    @Override
    public boolean update(Series series, String[] params) throws Exception {
        series.setTitle(Objects.requireNonNull(
                params[0], "Series name cannot be null"));
        return this.series.replace(series.getTitle(), series) != null;
    }

    @Override
    public boolean delete(Series series) throws Exception {
        return this.series.remove(series.getTitle()) != null;
    }

}
