package com.kodilla.eprojectkfrontend.views;

import com.kodilla.eprojectkfrontend.domains.GameDto;
import com.kodilla.eprojectkfrontend.forms.GameForm;
import com.kodilla.eprojectkfrontend.services.GameService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;

@Route("gameView")
public class GameView extends VerticalLayout {

    private GameService gameService = new GameService();
    private Grid<GameDto> gridGameDto = new Grid<>(GameDto.class);
    private Grid<GameDto> gridSearchResult = new Grid<>(GameDto.class);

    private Button goToLoveView = new Button("Go to Love Calculator!");
    private Button goToQuoteView = new Button("Go to Quotes!");
    private Button goToMotiveView = new Button("Go to Motives!");
    private Button goToMovieView = new Button("Go to Movies!");
    private Button goToBookView = new Button("Go to Books!");
    private Button goToTvShowView = new Button("Go to TV Shows!");

    private GameForm gameForm = new GameForm(this);

    private Label labelGameView = new Label("Games");
    private Label gridGameDtoLabel = new Label("Main view from Games");
    private Label gridSearchResultLabel = new Label("Search results from Games");


    private TextArea tutorialGames = new TextArea();

    public Grid<GameDto> getGridGameDto() {
        return gridGameDto;
    }

    public Grid<GameDto> gridSearchResult() {
        return gridSearchResult;
    }

    public GameView(){
        gridGameDto.setColumns("gameTitle", "gameDeveloper", "gameRating");
        gridSearchResult.setColumns("gameTitle", "gameDeveloper", "gameRating");

        HorizontalLayout sercondContent = new HorizontalLayout(gridSearchResult, gameForm);
        sercondContent.setSizeFull();
        HorizontalLayout mainContent = new HorizontalLayout(gridGameDtoLabel, gridGameDto);
        mainContent.setSizeFull();
        gridGameDto.setSizeFull();
        gridSearchResult.setSizeFull();

        goToLoveView.addThemeVariants(ButtonVariant.LUMO_SMALL);
        goToLoveView.addClickListener(event -> goToLoveView.getUI().ifPresent(ui -> ui.navigate("loveCalculatorView")));

        goToQuoteView.addThemeVariants(ButtonVariant.LUMO_SMALL);
        goToQuoteView.addClickListener(event -> goToQuoteView.getUI().ifPresent(ui -> ui.navigate("quotesView")));

        goToMotiveView.addThemeVariants(ButtonVariant.LUMO_SMALL);
        goToMotiveView.addClickListener(event -> goToMotiveView.getUI().ifPresent(ui -> ui.navigate("motiveView")));

        goToMovieView.addThemeVariants(ButtonVariant.LUMO_SMALL);
        goToMovieView.addClickListener(event -> goToMovieView.getUI().ifPresent(ui -> ui.navigate("movieView")));

        goToBookView.addThemeVariants(ButtonVariant.LUMO_SMALL);
        goToBookView.addClickListener(event -> goToBookView.getUI().ifPresent(ui -> ui.navigate("bookView")));

        goToTvShowView.addThemeVariants(ButtonVariant.LUMO_SMALL);
        goToTvShowView.addClickListener(event -> goToTvShowView.getUI().ifPresent(ui -> ui.navigate("tvShowView")));

        HorizontalLayout goTos = new HorizontalLayout(goToMotiveView, goToBookView, goToMovieView,
                goToTvShowView, goToLoveView, goToQuoteView);

        tutorialGames.setReadOnly(true);
        tutorialGames.setValue("Add your favourite games, and rate them! When in doubt, refresh page!");
        tutorialGames.setAutofocus(true);
        tutorialGames.setWidthFull();

        add(goTos);
        add(labelGameView);
        add(tutorialGames);

        add(mainContent);
        add(gridSearchResultLabel);
        add(sercondContent);
        setSizeFull();
        refresh();

        gridGameDto.asSingleSelect().addValueChangeListener(event -> gameForm.setGameDto(gridGameDto.asSingleSelect().getValue()));
        gridSearchResult.asSingleSelect().addValueChangeListener(event -> gameForm.setGameDto(gridSearchResult.asSingleSelect().getValue()));
    }

    public void refresh(){
        gridGameDto.setItems(gameService.getAllGame());
    }

    public void refreshByAllDevelopers(String author){
        gridSearchResult.setItems(gameService.findGameByDeveloper(author));
    }

    public void refreshByAllRatings(String gameRating){
        gridSearchResult.setItems(gameService.findGameByRating(gameRating));
    }
}