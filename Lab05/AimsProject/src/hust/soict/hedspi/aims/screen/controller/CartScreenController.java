package hust.soict.hedspi.aims.screen.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
    private Cart cart;
    public Button btnPlay;
    public Button btnRemove;

    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    @FXML
    private TableColumn<Media, String> colMediaCategory;
    @FXML
    private TableColumn<Media, Double> colMediaCost;

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Double>("cost"));
        tblMedia.setItems(this.cart.getItemsOrdered());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                if (newValue != null) updateButtonBar(newValue);
            }
        });

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });
    }

    void showFilteredMedia(String newValue) {
        ObservableList<Media> observableMediaList = FXCollections.observableArrayList(this.cart.getItemsOrdered());
        FilteredList<Media> filteredData = new FilteredList<Media>(observableMediaList, _ -> true);

        filteredData.setPredicate(media -> {
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            String lowerCaseFilter = newValue.toLowerCase();
            if (radioBtnFilterTitle.isSelected())
                return media.getTitle().toLowerCase().contains(lowerCaseFilter);
            else if (radioBtnFilterId.isSelected()) {
                try {
                    if (media.getId() == Integer.parseInt(lowerCaseFilter))
                        return true;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
            return false;
        });
        tblMedia.setItems(filteredData);
    }

    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        btnPlay.setVisible(media instanceof Playable);
    }

    @FXML
    void btnPlayPressed(ActionEvent actionEvent) {
    }

    @FXML
    void btnRemovePressed(ActionEvent actionEvent) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) cart.removeMedia(media);
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent actionEvent) {
    }

    @FXML
    void filterModeChanged() {
        showFilteredMedia(tfFilter.getText());
    }

    public TextField tfFilter;
    public RadioButton radioBtnFilterId;
    public ToggleGroup filterCategory;
    public RadioButton radioBtnFilterTitle;
    public Label lblTotalCost;
}
