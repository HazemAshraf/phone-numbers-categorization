package com.jumia.phonenumberscategorization.ui;

import com.jumia.phonenumberscategorization.enums.CountryCodes;
import com.jumia.phonenumberscategorization.facade.CustomerFacade;
import com.jumia.phonenumberscategorization.model.dto.CustomerDTO;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Value;


@SpringUI(path="/home")
@Theme("valo")
public class MainView extends UI {

    private final CustomerFacade customerFacade;

    private VerticalLayout root = new VerticalLayout();

    private Grid<CustomerDTO> grid;

    private ComboBox<CountryCodes> select;

    private Button next;

    private Button previous;

    @Value("${Pagination.NumberOfRecords.PerPage}")
    private long noOfRecords;

    private long noOfPages;

    private int page;

    public MainView(CustomerFacade customerFacade) {
        this.customerFacade = customerFacade;

    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        this.page = 1;
        //  System.out.println("count of all customers " + customerFacade.countAllCustomers());
        this.noOfPages = getNoOfPages(customerFacade.countAllCustomers(), noOfRecords);
        this.root = new VerticalLayout();
        this.root.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        this.grid = new Grid<>(CustomerDTO.class);
        this.next = new Button("");
        this.previous = new Button("");

        //grid.setHeight("300px");
        grid.setColumns("id", "name", "phone", "country");
        grid.setWidth("100%");

        this.select = new ComboBox<>("Select a Country");
        this.select.setItems(CountryCodes.getAll());
        this.select.setItemCaptionGenerator(CountryCodes::name);
        this.select.addValueChangeListener(valueChangeEvent -> {
            String filter = null;
            if (valueChangeEvent.getValue() != null) filter = valueChangeEvent.getValue().name();
            listCustomers(this.page, filter);
        });
        // Initialize listing
        listCustomers(1, null);
        this.root.addComponents(select, grid);
        addPagination();
        setContent(this.root);
    }

    private long getNoOfPages(long countAllCustomers, long noOfRecords) {
        return countAllCustomers / noOfRecords;
    }

    private void addPagination() {
        HorizontalLayout paginationLayout = new HorizontalLayout();
        Button next = new Button("next");
        next.addStyleName(ValoTheme.BUTTON_PRIMARY);

        Button previous = new Button("Previous");
        previous.addStyleName(ValoTheme.BUTTON_PRIMARY);

        next.addClickListener(clickEvent -> {
//            this.page = this.page + 1 < this.noOfPages - 1 ? this.page + 1 : this.page;
            this.page++;
            //validation for redundant increasing hits
            if (this.page > noOfPages + 1)
                this.page--; // due to decreasing page at customerService by 1 will plus 1 to noOfPages
            String filter = null;
            if (this.select.getValue() != null) filter = this.select.getValue().name();
            listCustomers(this.page, filter);
        });


        previous.addClickListener(clickEvent -> {
            this.page = this.page - 1 < 1 ? 1 : this.page - 1;
            String filter = null;
            if (this.select.getValue() != null) filter = this.select.getValue().name();
            listCustomers(this.page, filter);
        });
        paginationLayout.addComponents(previous, next);
        this.root.addComponent(paginationLayout);
    }

    void listCustomers(int page, String filterText) {
        this.grid.setItems(customerFacade.readAllCustomerCategorizedPhoneNumbers(page, filterText).getResponseData());
    }

}