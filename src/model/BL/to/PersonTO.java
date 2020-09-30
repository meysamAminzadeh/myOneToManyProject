package model.BL.to;

import java.util.List;

public class PersonTO {

    private long id;
    private String name;
    private String family;
    private List<AddressesTO> Address_list;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public List<AddressesTO> getAddress_list() {
        return Address_list;
    }

    public void setAddress_list(List<AddressesTO> address_list) {
        Address_list = address_list;
    }


}
