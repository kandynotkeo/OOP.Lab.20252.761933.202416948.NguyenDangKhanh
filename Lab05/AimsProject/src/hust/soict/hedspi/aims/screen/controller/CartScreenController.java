package hust.soict.hedspi.aims.screen.controller;

import hust.soict.hedspi.aims.AimsApp;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.screen.AddBookToStoreScreen;
import hust.soict.hedspi.aims.screen.AddCompactDiscToStoreScreen;
import hust.soict.hedspi.aims.screen.AddDigitalVideoDiscToStoreScreen;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
    private Cart cart;
    private AimsApp app;

    @FXML
    public Button btnPlay;
    @FXML
    public Button btnRemove;
    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    @FXML
    private TableColumn<Media, String> colMediaCategory;
    @FXML
    private TableColumn<Media, Double> colMediaCost;
    @FXML
    public TextField tfFilter;
    @FXML
    public RadioButton radioBtnFilterId;
    @FXML
    private ToggleGroup filterCategory;
    @FXML
    public RadioButton radioBtnFilterTitle;
    @FXML
    public Label lblTotalCost;

    public CartScreenController(Cart cart, AimsApp app) {
        super();
        this.cart = cart;
        this.app = app;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Double>("cost"));
        tblMedia.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tblMedia.setItems(this.cart.getItemsOrdered());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        updateTotalCost();

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

        cart.getItemsOrdered().addListener(new ListChangeListener<Media>() {
            @Override
            public void onChanged(Change<? extends Media> c) {
                updateTotalCost();
            }
        });
    }

    public void refresh() {
        updateTotalCost();
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
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Playing");
                alert.setHeaderText("Playing " + media.getTitle());
                alert.showAndWait();
            } catch (PlayerException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(e.getMessage());
                alert.showAndWait();
            }
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent actionEvent) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
            updateTotalCost();
        }
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent actionEvent) {
        if (cart.getItemsOrdered().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Place Order");
            alert.setHeaderText("Cart is empty!");
            alert.showAndWait();
        } else {
            cart.empty();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Place Order");
            alert.setHeaderText("Order placed successfully!");
            alert.showAndWait();
            updateTotalCost();
        }
    }

    @FXML
    void filterModeChanged() {
        showFilteredMedia(tfFilter.getText());
    }

    @FXML
    void addBook() {
        new AddBookToStoreScreen(app.getStore());
    }

    @FXML
    void addCD() {
        new AddCompactDiscToStoreScreen(app.getStore());
    }

    @FXML
    void addDVD() {
        new AddDigitalVideoDiscToStoreScreen(app.getStore());
    }

    @FXML
    void viewStore() {
        app.showStore();
    }

    @FXML
    void viewCart() {
        app.showCart();
    }

    private void updateTotalCost() {
        if (lblTotalCost != null) {
            lblTotalCost.setText(String.format("%.2f$", cart.totalCost()));
        }
    }
}
