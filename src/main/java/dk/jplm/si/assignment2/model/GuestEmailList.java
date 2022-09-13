package dk.jplm.si.assignment2.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuestEmailList {

    private List<Guest> guests;
    private String body;

}
