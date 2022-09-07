package dk.jplm.si.assignment2.model;

// extends class ResourceSupport, which provides method add() for links to other resources
// add HATEOAS dependency in maven for it

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Guest {
    private String name;
    private String mail;
    private String IP;
}

