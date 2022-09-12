package dk.jplm.si.assignment2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenderizeResponse {
    private String name;
    private String gender;
    private String country_id;
    private double probability;
    private int count;

}
