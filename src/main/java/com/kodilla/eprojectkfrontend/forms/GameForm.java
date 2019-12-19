package com.kodilla.eprojectkfrontend.forms;

import com.kodilla.eprojectkfrontend.domains.GameDto;
import com.kodilla.eprojectkfrontend.services.GameService;
import com.kodilla.eprojectkfrontend.views.GameView;
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
public class GameForm extends FormLayout {

    private GameView gameView;

    private TextField gameTitle = new TextField("Title");
    private TextField gameDeveloper = new TextField("Developer");
    private TextField gameRating = new TextField("Rating");

    private NumberField countAllGamesNumberField = new NumberField("Games size");

    private Button saveGame = new Button("Add");
    private Button deleteGame = new Button("Delete");
    private Button updateGame = new Button("Update");
    private Button deleteAllGames = new Button("Delete All");
    private Button findGameByDeveloper = new Button("Find By Developer");
    private Button findGameByRating = new Button("Find By Rating");
    private Button buttonCountAllGames = new Button("Check stored games size");

    private Binder<GameDto> binder = new Binder<>(GameDto.class);

    private GameService gameService = new GameService();

    private GameDto gameDto = new GameDto();

    public GameForm(GameView gameView) {
        this.gameView = gameView;

        updateGame.setEnabled(false);
        deleteGame.setEnabled(false);

        HorizontalLayout buttons = new HorizontalLayout(saveGame, deleteGame, updateGame, deleteAllGames);
        HorizontalLayout buttonsSecondRow = new HorizontalLayout(findGameByDeveloper, findGameByRating, buttonCountAllGames);

        saveGame.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        deleteGame.addThemeVariants(ButtonVariant.LUMO_ERROR);
        updateGame.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        deleteAllGames.addThemeVariants(ButtonVariant.LUMO_ERROR);
        findGameByDeveloper.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        findGameByRating.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        add(gameTitle, gameDeveloper, gameRating, buttons, buttonsSecondRow);

        countAllGamesNumberField.setReadOnly(true);
        add(countAllGamesNumberField);

        binder.bindInstanceFields(this);
        binder.setBean(gameDto);

        saveGame.addClickListener(event -> saveGame());
        deleteGame.addClickListener(event -> deleteGame());
        updateGame.addClickListener(event -> updateGame());
        deleteAllGames.addClickListener(event -> deleteAllGames());

        findGameByDeveloper.addClickListener(event -> findGameByDeveloper());
        findGameByRating.addClickListener(event -> findGameByRating());
        buttonCountAllGames.addClickListener(event -> countAllGamesNumberField.setValue(countAllGames()));

        saveGame.addClickListener(event -> UI.getCurrent().getPage().reload());
        deleteGame.addClickListener(event -> UI.getCurrent().getPage().reload());
        updateGame.addClickListener(event -> UI.getCurrent().getPage().reload());
        deleteAllGames.addClickListener(event -> UI.getCurrent().getPage().reload());
    }

    private void saveGame() {
        GameDto gameDto = binder.getBean();
        gameService.createGame(gameDto);
        gameView.refresh();
    }

    private void deleteGame() {
        GameDto gameDto = binder.getBean();
        gameService.deleteGame(gameDto.getGameID());
        gameView.refresh();
    }

    private void deleteAllGames() {
        gameService.deleteAllGames();
        gameView.refresh();
    }

    public void updateGame() {
        GameDto gameDto = binder.getBean();
        gameService.updateGame(gameDto);
        gameView.refresh();
    }

    public void findGameByDeveloper() {
        String gameDto = binder.getBean().getGameDeveloper();
        gameService.findGameByDeveloper(gameDto);
        gameView.refreshByAllDevelopers(gameDto);
    }

    public void findGameByRating() {
        String gameDto = binder.getBean().getGameRating();
        gameService.findGameByRating(gameDto);
        gameView.refreshByAllRatings(gameDto);
    }

    public double countAllGames() {
        return gameService.countAllGames();
    }

    public void setGameDto(GameDto gameDto) {
        binder.setBean(gameDto);
    }
}