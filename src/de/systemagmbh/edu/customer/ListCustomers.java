package de.systemagmbh.edu.customer;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Named;

import de.systemagmbh.edu.util.DataListingSupport;

@RequestScoped
@Named
public class ListCustomers extends DataListingSupport<CustomerData> {

    private static final long serialVersionUID = 3019107807960731494L;

    // @Inject
    // private CustomerService customerService;

    private List<CustomerData> result;

    public ListCustomers() {
        setSortField("name");
        setRowsPerPage(10);

        result = new ArrayList<CustomerData>();
        for (int i = 0; i < 100; i++) {
            CustomerData customer = new CustomerData();
            customer.setName("Korvin - " + i);
            result.add(customer);
        }

    }

    @Override
    protected void populateCountAndData() {
        /*
         * This is where we call an EJB (or whatever service layer you have) to perform data retrieval.
         * 
         * You need to make sure to retrieve the result (paginated, sorted), and also the total number of records.
         */

        setRecordCount(result.size());
        int page = getPage();
        int rowsPerPage = getRowsPerPage();
        List<CustomerData> paginatedData = new ArrayList<CustomerData>();
        int startIndex = (page - 1) * rowsPerPage;
        int lastIndex = page * rowsPerPage;
        for (int i = startIndex; i < lastIndex; i++) {
            paginatedData.add(result.get(i));
        }
        setData(new ListDataModel<CustomerData>(paginatedData));
        setDataAsList(paginatedData);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
    }
}