package com.kodilla.eprojectkfrontend.forms;

import com.kodilla.eprojectkfrontend.domains.MovieDto;
import com.kodilla.eprojectkfrontend.services.MovieService;
import com.kodilla.eprojectkfrontend.views.MovieView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import lombok.Getter;

@Getter
public class MovieForm extends FormLayout {

    private MovieView movieView;

    private TextField movieTitle = new TextField("Title");
    private TextField movieDirector = new TextField("Director");
    private TextField movieRating = new TextField("Rating");

    private NumberField countAllMoviesNumberField = new NumberField("Movies size");

    private Button saveMovie = new Button("Add");
    private Button deleteMovie = new Button("Delete");
    private Button updateMovie = new Button("Update");
    private Button deleteAllMovies = new Button("Delete All");
    private Button findMovieByDirector = new Button("Find By Director");
    private Button findMovieByRating = new Button("Find By Rating");
    private Button buttonCountAllMovies = new Button("Check stored movies size");

    private Binder<MovieDto> binder = new Binder<>(MovieDto.class);

    private MovieService movieService = new MovieService();

    private MovieDto movieDto = new MovieDto();

    public MovieForm(MovieView movieView) {
        this.movieView = movieView;

        updateMovie.setEnabled(false);
        deleteMovie.setEnabled(false);

        HorizontalLayout buttons = new HorizontalLayout(saveMovie, deleteMovie, updateMovie, deleteAllMovies);
        HorizontalLayout buttonsSecondRow = new HorizontalLayout(findMovieByDirector, findMovieByRating, buttonCountAllMovies);

        saveMovie.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        deleteMovie.addThemeVariants(ButtonVariant.LUMO_ERROR);
        updateMovie.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        deleteAllMovies.addThemeVariants(ButtonVariant.LUMO_ERROR);
        findMovieByDirector.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        findMovieByRating.addThemeVariants(ButtonVariant.LUMO_CONTRAST);

        countAllMoviesNumberField.setReadOnly(true);

        binder.bindInstanceFields(this);
        binder.setBean(movieDto);

        saveMovie.addClickListener(event -> saveMovie());
        deleteMovie.addClickListener(event -> deleteMovie());
        updateMovie.addClickListener(event -> updateMovie());
        deleteAllMovies.addClickListener(event -> deleteAllMovies());

        findMovieByDirector.addClickListener(event -> findMovieByDirector());
        findMovieByRating.addClickListener(event -> findMovieByRating());
        buttonCountAllMovies.addClickListener(event -> countAllMoviesNumberField.setValue(countAllMovies()));

        saveMovie.addClickListener(event -> UI.getCurrent().getPage().reload());
        deleteMovie.addClickListener(event -> UI.getCurrent().getPage().reload());
        updateMovie.addClickListener(event -> UI.getCurrent().getPage().reload());
        deleteAllMovies.addClickListener(event -> UI.getCurrent().getPage().reload());

        add(movieTitle, movieDirector, movieRating, buttons, buttonsSecondRow);
        add(countAllMoviesNumberField);
    }

    private void saveMovie() {
        MovieDto movieDto = binder.getBean();
        movieService.createMovie(movieDto);
        movieView.refresh();
    }

    private void deleteMovie() {
        MovieDto movieDto = binder.getBean();
        movieService.deleteMovie(movieDto.getMovieID());
        movieView.refresh();
    }

    private void deleteAllMovies() {
        movieService.deleteAllMovies();
        movieView.refresh();
    }

    public void updateMovie() {
        MovieDto movieDto = binder.getBean();
        movieService.updateMovie(movieDto);
        movieView.refresh();
    }

    public void findMovieByDirector() {
        String movieDto = binder.getBean().getMovieDirector();
        movieService.findMovieByDirector(movieDto);
        movieView.refreshByAllDirectors(movieDto);
    }

    public void findMovieByRating() {
        String movieDto = binder.getBean().getMovieRating();
        movieService.findMovieByRating(movieDto);
        movieView.refreshByAllRatings(movieDto);
    }

    public double countAllMovies() {
        return movieService.countAllMovies();
    }

    public void setMovieDto(MovieDto movieDto) {
        binder.setBean(movieDto);
    }
}