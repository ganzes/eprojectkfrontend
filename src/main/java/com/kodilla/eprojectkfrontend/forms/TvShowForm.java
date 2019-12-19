package com.kodilla.eprojectkfrontend.forms;

import com.kodilla.eprojectkfrontend.domains.TvShowDto;
import com.kodilla.eprojectkfrontend.services.TvShowService;
import com.kodilla.eprojectkfrontend.views.TvShowView;
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
public class TvShowForm extends FormLayout {

    private TvShowView tvShowView;

    private TextField tvShowTitle = new TextField("Title");
    private TextField tvShowCategory = new TextField("Category");
    private TextField tvShowRating = new TextField("Rating");

    private NumberField countAllTvShowsNumberField = new NumberField("TvShows size");

    private Button saveTvShow = new Button("Add");
    private Button deleteTvShow = new Button("Delete");
    private Button updateTvShow = new Button("Update");
    private Button deleteAllTvShows = new Button("Delete All");
    private Button findTvShowByCategory = new Button("Find By Category");
    private Button findTvShowByRating = new Button("Find By Rating");
    private Button buttonCountAllTvShows = new Button("Check stored tvShows size");

    private Binder<TvShowDto> binder = new Binder<>(TvShowDto.class);

    private TvShowService tvShowService = new TvShowService();

    private TvShowDto tvShowDto = new TvShowDto();

    public TvShowForm(TvShowView tvShowView) {
        this.tvShowView = tvShowView;

        updateTvShow.setEnabled(false);

        binder.bindInstanceFields(this);
        binder.setBean(tvShowDto);

        HorizontalLayout buttons = new HorizontalLayout(saveTvShow, deleteTvShow, updateTvShow, deleteAllTvShows);
        HorizontalLayout buttonsSecondRow = new HorizontalLayout(findTvShowByCategory, findTvShowByRating, buttonCountAllTvShows);

        saveTvShow.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        deleteTvShow.addThemeVariants(ButtonVariant.LUMO_ERROR);
        updateTvShow.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        deleteAllTvShows.addThemeVariants(ButtonVariant.LUMO_ERROR);
        findTvShowByCategory.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        findTvShowByRating.addThemeVariants(ButtonVariant.LUMO_CONTRAST);

        countAllTvShowsNumberField.setReadOnly(true);

        saveTvShow.addClickListener(event -> saveTvShow());
        deleteTvShow.addClickListener(event -> deleteTvShow());
        updateTvShow.addClickListener(event -> updateTvShow());
        deleteAllTvShows.addClickListener(event -> deleteAllTvShows());

        findTvShowByCategory.addClickListener(event -> findTvShowByCategory());
        findTvShowByRating.addClickListener(event -> findTvShowByRating());
        buttonCountAllTvShows.addClickListener(event -> countAllTvShowsNumberField.setValue(countAllTvShows()));

        saveTvShow.addClickListener(event -> UI.getCurrent().getPage().reload());
        deleteTvShow.addClickListener(event -> UI.getCurrent().getPage().reload());
        updateTvShow.addClickListener(event -> UI.getCurrent().getPage().reload());
        deleteAllTvShows.addClickListener(event -> UI.getCurrent().getPage().reload());

        add(tvShowTitle, tvShowCategory, tvShowRating, buttons, buttonsSecondRow);
        add(countAllTvShowsNumberField);
    }

    private void saveTvShow() {
        TvShowDto tvShowDto = binder.getBean();
        tvShowService.createTvShow(tvShowDto);
        tvShowView.refresh();
    }

    private void deleteTvShow() {
        TvShowDto tvShowDto = binder.getBean();
        tvShowService.deleteTvShow(tvShowDto.getTvShowID());
        tvShowView.refresh();
    }

    private void deleteAllTvShows() {
        tvShowService.deleteAllTvShows();
        tvShowView.refresh();
    }

    public void updateTvShow() {
        TvShowDto tvShowDto = binder.getBean();
        tvShowService.updateTvShow(tvShowDto);
        tvShowView.refresh();
    }

    public void findTvShowByCategory() {
        String tvShowDto = binder.getBean().getTvShowCategory();
        tvShowService.findTvShowByCategory(tvShowDto);
        tvShowView.refreshByAllCategorys(tvShowDto);
    }

    public void findTvShowByRating() {
        String tvShowDto = binder.getBean().getTvShowRating();
        tvShowService.findTvShowByRating(tvShowDto);
        tvShowView.refreshByAllRatings(tvShowDto);
    }

    public double countAllTvShows() {
        return tvShowService.countAllTvShows();
    }

    public void setTvShowDto(TvShowDto tvShowDto) {
        binder.setBean(tvShowDto);
    }
}
